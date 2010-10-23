package com.zhela.cloudblog.rest;

import javax.servlet.http.HttpServletRequest;

public class BaseResource {

	protected final static String SESSION_AUTH = "auth";
	
	protected void saveSession(HttpServletRequest servletRequest,String key,Object value){
		servletRequest.getSession().setAttribute(key, value);
	}
	
	protected Object getSession(HttpServletRequest servletRequest,String key){
		return servletRequest.getSession().getAttribute(key);
	}
	
	protected void clearSession(HttpServletRequest servletRequest,String key){
		servletRequest.getSession().removeAttribute(key);
	}
	
	protected boolean isAuth(HttpServletRequest servletRequest){
		Object auth = getSession(servletRequest,SESSION_AUTH);
		if(auth!=null){
			String tmp = (String)auth;
			if(tmp.equals("Success")){
				return true;
			}
		}
		return false;
	}
}
