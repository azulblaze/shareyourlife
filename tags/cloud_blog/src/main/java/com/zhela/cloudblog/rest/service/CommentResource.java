package com.zhela.cloudblog.rest.service;


import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.model.RESTResponse;
import com.zhela.cloudblog.rest.model.RESTServiceComment;
import com.zhela.cloudblog.rest.model.RESTServiceCommentList;
import com.zhela.cloudblog.service.ourservice.CommentService;
@Path("/services/comments")
public class CommentResource extends BaseResource{
	static{
		authURLs.add("/services/comments");
	}
	
	private CommentService commentService;
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{code}/{page}")
	public Response getComments(@PathParam("code") String code,
			@PathParam("page") int page,
			@QueryParam("u") String webURL,
			@DefaultValue("10") @QueryParam("s") int size,
			@DefaultValue("desc") @QueryParam("o") String order){
		try{
			if(StringUtils.isBlank(webURL)){
				return RESPONSE_SERVICE_UNAVAILABLE;
			}
			RESTServiceCommentList result = commentService.loadComment(code, webURL, page, size, order);
			return genOK("ZLloadComment('"+result.loadJSON()+"')");
		}catch(Exception e){
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/post/{code}/")
	public Response postComments(@PathParam("code") String code,
			@QueryParam("u") String webURL,
			@QueryParam("account") String account,
			@QueryParam("dn") String display_name,
			@QueryParam("c") String content,
			@QueryParam("pass") String password){
		try{
			String result = commentService.postComment(code, account, password, display_name, webURL, servletRequest.getRemoteAddr(), content).loadJSON();
			return genOK("ZLappendComment('"+result+"')");
		}catch(Exception e){
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	/**
	@DELETE
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response postComments(@PathParam("id") long id){
		try{
			RESTServiceComment rest = commentService.deleteComment(null,id);
			if(rest!=null){
				return genOK(rest);
			}else{
				return genOK(new RESTResponse(Status.NOT_FOUND,"fail"));
			}
		}catch(Exception e){
			return RESPONSE_SERVICE_UNAVAILABLE;
		}
	}
	**/
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
}
