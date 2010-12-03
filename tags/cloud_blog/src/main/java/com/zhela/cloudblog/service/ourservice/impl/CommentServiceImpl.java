package com.zhela.cloudblog.service.ourservice.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.dao.ourservice.CommentDAO;
import com.zhela.cloudblog.model.ourservice.Comment;
import com.zhela.cloudblog.model.ourservice.CommentExample;
import com.zhela.cloudblog.model.ourservice.CommentExample.Criteria;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTServiceComment;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.service.ourservice.CommentService;
import com.zhela.cloudblog.service.ourservice.ServiceManage;
import com.zhela.cloudblog.util.SystemConfig;

public class CommentServiceImpl implements CommentService {

	CommentDAO commentDAO;
	ServiceManage serviceManage;
	InternalUserService internalUserService;
	
	
	
	@Override
	public RESTServiceCommentList loadComment(String code,String web_url, int page,
			int size,String order) throws Exception {
		if(!serviceManage.isAllowed(code, web_url)){
			throw new Exception("你没有权限");
		}
		if(page<=0){
			page = 1;
		}
		RESTServiceCommentList restcomment = new RESTServiceCommentList();
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andServiceBindCodeEqualTo(code).andWebUrlEqualTo(web_url);
		example.setPage(page, size);
		int count = commentDAO.countByExample(example);
		restcomment.setCount(count);
		if(count>page*size){
			if(count>size){
				restcomment.setNextPage(page+1);
			}
		}
		if(page>1){
			restcomment.setLastPage(page-1);
		}
		example.setOrderByClause("id "+order);
		List<Comment> comments = commentDAO.selectByExampleWithBLOBs(example);
		java.util.List<RESTServiceComment> _comments = new java.util.ArrayList<RESTServiceComment>();
		RESTServiceComment rest;
		for(Comment _comment:comments){
			rest = getRESTFromComment(_comment);
			_comments.add(rest);
		}
		restcomment.setComment(_comments);
		return restcomment;
	}

	private RESTServiceComment getRESTFromComment(Comment _comment){
		RESTServiceComment rest = new RESTServiceComment();
		rest.setId(_comment.getId());
		rest.setContent(_comment.getContent());
		rest.setUpdate_time(_comment.getUpdateTime());
		rest.setUserheader(SystemConfig.domain+_comment.getUserHeader());
		rest.setUsername(_comment.getUserName());
		return rest;
	}
	
	@Override
	public RESTServiceComment postComment(String code, String account, String password,
			String displayName, String webUrl, String userIp, String content) throws Exception {
		if(!serviceManage.isAllowed(code, webUrl)){
			throw new Exception("你没有权限");
		}
		if((StringUtils.isBlank(account)&&StringUtils.isBlank(password)&&StringUtils.isBlank(displayName))||StringUtils.isBlank(content)){
			throw new Exception("参数不够");
		}
		Users users = null;
		if(StringUtils.isNotBlank(account)&&StringUtils.isNotBlank(password)){
			try {
				users = internalUserService.getUsers(account, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Comment comment = new Comment();
		if(users!=null){
			comment.setUserHeader(users.getHeader());
			comment.setUserName(users.getDisplayName());
		}else{
			comment.setUserHeader(Users.DEFAULT_HEADER);
			comment.setUserName(displayName);
		}
		comment.setContent(content);
		comment.setServiceBindCode(code);
		comment.setUpdateTime(new java.util.Date());
		comment.setUserIp(userIp);
		comment.setWebUrl(webUrl);
		commentDAO.insert(comment);
		return getRESTFromComment(commentDAO.selectByPrimaryKey(comment.getId()));
	}

	@Override
	public RESTServiceComment deleteComment(long id) {
		Comment comment = commentDAO.selectByPrimaryKey(id);
		if(comment!=null){
			commentDAO.deleteByPrimaryKey(id);
			return getRESTFromComment(comment);
		}
		return null;
	}
	
	
	
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public void setInternalUserService(InternalUserService internalUserService) {
		this.internalUserService = internalUserService;
	}

	public void setServiceManage(ServiceManage serviceManage) {
		this.serviceManage = serviceManage;
	}

	
}
