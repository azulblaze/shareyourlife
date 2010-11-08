package com.zhela.cloudblog.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.model.users.ProviderUserKey;
import com.zhela.cloudblog.rest.auth.AuthResource.DeviceStatus;
import com.zhela.cloudblog.rest.model.RESTInternalUser;
import com.zhela.cloudblog.rest.model.RESTResponse;

public class BaseResource {

	public final static String SESSION_AUTH = "auth";
	public final static String SESSION_USER = "user";
	protected final static String SESSION_PROVIDERACCOUNT = "provider_account";
	public static java.util.List<String> authURLs = new java.util.ArrayList<String>();
	public static java.util.List<String> loginURLs = new java.util.ArrayList<String>();
	static{
		authURLs.add("/auth");
		loginURLs.add("/users");
	}
	protected final static Response RESPONSE_UNAUTHORIZED = Response.status(Status.UNAUTHORIZED)
	.entity(new RESTResponse(Status.UNAUTHORIZED,"Not Allowed"))
	.build();
	
	protected final static Response RESPONSE_NEEDLOGIN = Response.status(Status.UNAUTHORIZED)
	.entity(new RESTResponse(Status.UNAUTHORIZED,"Need Login"))
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
		if(status==null){
			status = new com.zhela.cloudblog.rest.auth.AuthResource().new DeviceStatus();
			status.setTransID("ABCDEF");
			saveSession(SESSION_AUTH,status);
		}
		if(status!=null&&StringUtils.isNotBlank(status.getTransID())){
			return true;
		}
		return false;
	}
	
	protected boolean isLogin(){
		RESTInternalUser restiu = (RESTInternalUser)getSession(SESSION_USER);
		if(restiu==null){
			restiu = new RESTInternalUser();
			restiu.setAccount("cashguy");
			restiu.setDisplayName("BTboy");
			restiu.setHeader("");
			restiu.setUpdateTime(new java.util.Date());
			saveSession(SESSION_USER,restiu);
		}
		if(restiu!=null){
			return true;
		}
		return false;
	}
	
	protected RESTInternalUser getUser(){
		return (RESTInternalUser)getSession(SESSION_USER);
	}
	
	@SuppressWarnings("unchecked")
	protected java.util.List<ProviderUser> getProviderUser(){
		return (java.util.List<ProviderUser>)getSession(SESSION_PROVIDERACCOUNT);
	}
	
	protected ProviderUser getProviderUserByAccount(long providerId,String providerAccount){
		ProviderUserKey puk = new ProviderUserKey();
		RESTInternalUser user = getUser();
		puk.setAccount(user.getAccount());
		puk.setProviderAccount(providerAccount);
		puk.setProviderId(providerId);
		java.util.List<ProviderUser> pus = getProviderUser();
		int index = pus.indexOf(puk);
		if(index>=0){
			return pus.get(index);
		}
		return null;
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
	
	@SuppressWarnings("unchecked")
	protected java.util.List<ProviderUser> getProviderAccount(){
		return (java.util.List<ProviderUser>)getSession(SESSION_PROVIDERACCOUNT);
	}
}
