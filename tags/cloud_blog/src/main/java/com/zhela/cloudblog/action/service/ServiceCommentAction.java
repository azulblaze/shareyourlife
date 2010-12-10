package com.zhela.cloudblog.action.service;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.action.BaseAction;
import com.zhela.cloudblog.action.model.JSONResponse;
import com.zhela.cloudblog.model.ourservice.ServiceBind;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.service.ourservice.CommentService;
import com.zhela.cloudblog.service.ourservice.ServiceManage;

@SuppressWarnings("serial")
public class ServiceCommentAction extends BaseAction{
	
	CommentService commentService;
	ServiceManage serviceManage;
	private String code;
	private int page;
	private int size = 10;
	private String order = "desc";
	private int status;
	private long id;
	private String web_url;
	
	public String info() throws Exception{
		return SUCCESS;
	}

	public String status() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		setValue("list",serviceManage.loadStatus(_user.getAccount(), CommentService.SERVICE_ID));
		return SUCCESS;
	}
	
	public String loadCount() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			setValue(JSON,new JSONResponse(JSONResponse.LOGIN,"").toJSON());
		}else{
			try{
				setValue(JSON,new JSONResponse(JSONResponse.SUCCESS,""+commentService.loadCommentCount(_user.getAccount(), code)).toJSON());
			}catch(Exception e){
				setValue(JSON,new JSONResponse(JSONResponse.FAIL,""+e.getMessage()).toJSON());
			}
		}
		return JSON;
	}
	
	public String myComments() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		java.util.List<ServiceBind> sbs = serviceManage.loadStatus(_user.getAccount(), CommentService.SERVICE_ID);
		setValue("sbs",sbs);
		if(sbs.size()==0){
			return SUCCESS;
		}
		ServiceBind sb = null;
		if(StringUtils.isBlank(code)){
			sb  = sbs.remove(0);
		}else{
			for(ServiceBind _sb:sbs){
				if(_sb.getCode().equals(code)){
					sb = _sb;
					sbs.remove(_sb);
					break;
				}
			}
		}
		setValue("select",sb);
		if(sb!=null){
			setValue("list",commentService.loadComment(sb.getCode(), page, size, order,_user.getAccount()));
		}
		return SUCCESS;
	}
	
	public String postService() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		if(StringUtils.isNotBlank(web_url)){
			try{
				ServiceBind sb = serviceManage.addService(_user.getAccount(), web_url, CommentService.SERVICE_ID);
				commentService.createCommentFile(sb.getCode(), getRootPath());
				setValue("sb",sb);
				return SUCCESS;
			}catch(Exception e){
				setValue("error",e.getMessage());
				return INPUT;
			}
		}else{
			return INPUT;
		}
	}
	
	public String deleteService() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			setValue(JSON,new JSONResponse(JSONResponse.LOGIN,"").toJSON());
		}else{
			try{
				if(serviceManage.deleteService(_user.getAccount(),code)>0){
					commentService.deleteCommentFile(getRootPath()+"/zl_js/service/comment/"+code+".js");
					commentService.deleteCommentbyCode(code);
					setValue(JSON,new JSONResponse(JSONResponse.SUCCESS,"").toJSON());
				}else{
					setValue(JSON,new JSONResponse(JSONResponse.FAIL,"你没有权限或者该服务不存在").toJSON());
				}
			}catch(Exception e){
				setValue(JSON,new JSONResponse(JSONResponse.FAIL,""+e.getMessage()).toJSON());
			}
		}
		return JSON;
	}
	
	public String updateStatus() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			setValue(JSON,new JSONResponse(JSONResponse.LOGIN,"").toJSON());
		}else{
			try{
				serviceManage.updateStatus(_user.getAccount(),code,status);
				setValue(JSON,new JSONResponse(JSONResponse.SUCCESS,"").toJSON());
			}catch(Exception e){
				setValue(JSON,new JSONResponse(JSONResponse.FAIL,""+e.getMessage()).toJSON());
			}
		}
		return JSON;
	}
	
	public String deleteComments()throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			setValue(JSON,new JSONResponse(JSONResponse.LOGIN,"").toJSON());
		}else{
			try{
				if(commentService.deleteComment(_user.getAccount(),id)!=null){
					setValue(JSON,new JSONResponse(JSONResponse.SUCCESS,"").toJSON());
				}else{
					setValue(JSON,new JSONResponse(JSONResponse.FAIL,"你没有权限或者该服务不存在").toJSON());
				}
			}catch(Exception e){
				setValue(JSON,new JSONResponse(JSONResponse.FAIL,""+e.getMessage()).toJSON());
			}
		}
		return JSON;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String webUrl) {
		web_url = webUrl;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public void setServiceManage(ServiceManage serviceManage) {
		this.serviceManage = serviceManage;
	}
	
}
