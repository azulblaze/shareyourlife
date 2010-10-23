package com.zhela.cloudblog.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.rest.auth.AuthResource.DeviceStatus;

public class BaseResource {

	protected final static String SESSION_AUTH = "auth";
	
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
}
