package com.zhela.cloudblog.service.ourservice;

import com.zhela.cloudblog.rest.model.RESTServiceComment;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;

public interface CommentService {

	public RESTServiceComment postComment(String code,String account,String password,String display_name,String web_url,String user_ip,String content) throws Exception;
	
	public RESTServiceCommentList loadComment(String code,String web_url, int page,int size,String order) throws Exception;
	
	public RESTServiceComment deleteComment(long id) throws Exception;
}
