package com.zhela.cloudblog.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.rest.auth.AuthResource.DeviceStatus;
import com.zhela.cloudblog.rest.model.RESTResponse;

public class BaseResource {

	protected final static String SESSION_AUTH = "auth";
	
	protected final static Response RESPONSE_UNAUTHORIZED = Response.status(Status.UNAUTHORIZED)
	.entity(new RESTResponse(Status.UNAUTHORIZED,"Not Allowed"))
	.build();
	
	protected final static Response RESPONSE_SERVICE_UNAVAILABLE =  Response.status(Status.SERVICE_UNAVAILABLE)
	.entity(new RESTResponse(Status.SERVICE_UNAVAILABLE,"System Exception"))
	.build();
	
	protected @Context HttpServletRequest servletRequest;
	
	protected void saveSession(String key,Object value){
		servletRequest.getSession().setAttribute(key, value);
	}
	
	protected Object getSession(String key){
		return servletRequest.getSession().getAttribute(key);
	}
	
	protected void clearSession(String key){
		servletRequest.getSession().removeAttribute(key);
	}
	
	protected String getSessionId(){
		return servletRequest.getSession().getId();
	}
	
	protected boolean isAuth( ){
		DeviceStatus status = (DeviceStatus)getSession(SESSION_AUTH);
		if(status!=null&&StringUtils.isNotBlank(status.getTransID())){
			return true;
		}
		return false;
	}
	
	protected Response genOK(Object obj){
		return Response.status(Status.OK)
		.entity(obj)
		.build();
	}
	
	protected Response genNotAcceptable(Object obj){
		return Response.status(Status.NOT_ACCEPTABLE)
		.entity(obj)
		.build();
	}
}
