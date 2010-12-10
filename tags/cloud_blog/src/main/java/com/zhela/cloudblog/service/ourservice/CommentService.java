package com.zhela.cloudblog.service.ourservice;

import com.zhela.cloudblog.rest.model.RESTServiceComment;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;

public interface CommentService {
	
	public final static int SERVICE_ID = 1;
	
	public RESTServiceComment postComment(String code,String account,String password,String display_name,String web_url,String user_ip,String content) throws Exception;
	
	public RESTServiceCommentList loadComment(String code,String web_url, int page,int size,String order) throws Exception;
	
	public RESTServiceCommentList loadComment(String code,int page,int size,String order,String account) throws Exception;
	
	public int loadCommentCount(String account,String code) throws Exception;
	
	public RESTServiceComment deleteComment(String account,long id) throws Exception;
	
	public void createCommentFile(String code,String path) throws Exception;
	
	public void deleteCommentFile(String path) throws Exception;
	
	public void deleteCommentbyCode(String code) throws Exception;
}
