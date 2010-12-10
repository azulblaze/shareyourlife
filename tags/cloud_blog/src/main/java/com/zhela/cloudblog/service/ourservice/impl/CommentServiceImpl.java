package com.zhela.cloudblog.service.ourservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.dao.ourservice.CommentDAO;
import com.zhela.cloudblog.model.ourservice.Comment;
import com.zhela.cloudblog.model.ourservice.CommentExample;
import com.zhela.cloudblog.model.ourservice.CommentExample.Criteria;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.rest.model.RESTServiceComment;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.service.ourservice.CommentService;
import com.zhela.cloudblog.service.ourservice.ServiceManage;
import com.zhela.cloudblog.service.tweet.provider.impl.ProviderTweetServiceSINA;
import com.zhela.cloudblog.util.SystemConfig;

public class CommentServiceImpl implements CommentService {
	

	CommentDAO commentDAO;
	ServiceManage serviceManage;
	InternalUserService internalUserService;
	
	
	
	@Override
	public RESTServiceCommentList loadComment(String code,String web_url, int page,
			int size,String order) throws Exception {
		if(!serviceManage.isAllowed(code, web_url)){
			throw new Exception("你没有注册过该服务或者你已经停止了该服务");
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
	
	@Override
	public RESTServiceCommentList loadComment(String code, int page,
			int size,String order,String account) throws Exception {
		if(!serviceManage.isAllowedAccount(code, account)){
			throw new Exception("你没有权限查看该统计");
		}
		if(page<=0){
			page = 1;
		}
		RESTServiceCommentList restcomment = new RESTServiceCommentList();
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andServiceBindCodeEqualTo(code);
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
		example.setOrderByClause("web_url,id "+order);
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
		rest.setWeb_url(_comment.getWebUrl());
		rest.setService_code(_comment.getServiceBindCode());
		rest.setIp(_comment.getUserIp());
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
		if(code.equals("129134358831101")){
			new POSTWeibo(webUrl,comment.getUserName(),content).start();
		}
		return getRESTFromComment(commentDAO.selectByPrimaryKey(comment.getId()));
	}

	@Override
	public RESTServiceComment deleteComment(String account,long id) {
		Comment comment = commentDAO.selectByPrimaryKey(id);
		if(comment!=null){
			if(serviceManage.isAllowedAccount(comment.getServiceBindCode(), account)){
				commentDAO.deleteByPrimaryKey(id);
				return getRESTFromComment(comment);
			}
		}
		return null;
	}

	@Override
	public int loadCommentCount(String account,String code)throws Exception {
		if(!serviceManage.isAllowedAccount(code, account)){
			throw new Exception("你没有权限查看该统计");
		}
		CommentExample example =  new CommentExample();
		example.createCriteria().andServiceBindCodeEqualTo(code);
		return commentDAO.countByExample(example);
	}
	
	private final static String comment_template = "/zl_js/service/comment/template/zl_comment_template.js";
	@Override
	public void createCommentFile(String code, String path) throws Exception {
		File file = new File(path+comment_template);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			throw new Exception("生产文件错误，模板文件没找到");
		} catch (IOException e) {
			throw new Exception("生产文件错误，模板文件读取错误");
		}
		try {
			String jstext = new String(filecontent, "utf-8");
			jstext = jstext.replaceAll("zlIDzl", code);
			file = new File(path+"/zl_js/service/comment/"+code+".js");
			FileOutputStream out = new FileOutputStream(file);
			out.write(jstext.getBytes("utf-8"));
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
		}
	}

	@Override
	public void deleteCommentFile(String path) throws Exception {
		File file = new File(path);
		file.delete();
	}
	
	@Override
	public void deleteCommentbyCode(String code) throws Exception {
		CommentExample example =  new CommentExample();
		example.createCriteria().andServiceBindCodeEqualTo(code);
		commentDAO.deleteByExample(example);
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
	
	private ProviderTweetServiceSINA ptss = new ProviderTweetServiceSINA();

	class POSTWeibo extends Thread{

		private String content;
		private boolean send = true;
		public POSTWeibo(String url,String name,String comment){
			if(name.length()+comment.length()>110){
				int left = (110-name.length());
				if(left>0){
					comment = comment.substring(0,left);
				}else{
					send = false;
				}
				
			}
			this.content = name+" 评论了我的博文( "+"http://"+url+" )："+comment;
		}
		
		@Override
		public void run() {
			if(send){
				try {
					ptss.publishTweet(content, "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null, null, null, null);
				} catch (Exception e) {
					
				}
			}
		}
		
	}

	
}
