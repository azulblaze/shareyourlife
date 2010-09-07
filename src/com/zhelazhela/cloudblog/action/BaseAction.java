package com.zhelazhela.cloudblog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class BaseAction {
	
	
	
	public String getRootPath(){
		return ServletActionContext.getServletContext().getRealPath("/");
	}
	
	public void setValue(String key, Object value){
		ServletActionContext.getValueStack(getHttpServletRequest()).set(key, value);
	}
	
	public HttpSession getHttpSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	public HttpSession getHttpServletSession(boolean arg0){
		return ServletActionContext.getRequest().getSession(arg0);
	}	
	
	public HttpServletRequest getHttpServletRequest(){
		return ServletActionContext.getRequest();	
	}
	
	public HttpServletResponse getHttpServletResponse(){
		return ServletActionContext.getResponse();	
	}

	public String getRequestParameter(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}
	
	public String[] getRequestParameterValues(String key) {
		return ServletActionContext.getRequest().getParameterValues(key);
	}
	
	public void clearSession(String key){
		ServletActionContext.getRequest().getSession().removeAttribute(key);
	}
	
	public void saveSession(String key,Object value){
		ServletActionContext.getRequest().getSession().setAttribute(key, value);
	}
	
	public Object getSession(String key){
		return ServletActionContext.getRequest().getSession().getAttribute(key);
	}
}
