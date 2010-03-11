package com.zhelazhela.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>BaseAction.java</code> is the interface of outputting the logs.
 * 
 * @author  Sol Zhang
 * @version 1.0, 2009-6-9
 */
@SuppressWarnings("serial")
public abstract class BaseAction extends ActionSupport {
	
	protected final static String ROOT_PARENT_ID = "0";
	protected String urlBack;
	protected String JSON = "json";
	public String getUrlBack() {
		return urlBack;
	}

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
	
	protected void loadUrlBack(){
		this.urlBack = ServletActionContext.getRequest().getHeader("Referer");
	}
}
