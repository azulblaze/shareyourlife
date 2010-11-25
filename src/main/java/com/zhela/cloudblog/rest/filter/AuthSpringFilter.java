package com.zhela.cloudblog.rest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.RequestContextFilter;

import com.zhela.cloudblog.rest.BaseResource;
import com.zhela.cloudblog.rest.auth.AuthResource.DeviceStatus;
import com.zhela.cloudblog.rest.model.RESTInternalUser;

public class AuthSpringFilter extends RequestContextFilter {

	public static boolean initPath = false;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(!initPath){
			initPath = true;
			BaseResource.ROOT_PATH = request.getRealPath("/");
		}
		String path = request.getPathInfo();
		int result = isAuthDispatch(path,request);
		String suffix = "";
		if(path.endsWith(".json")){
			suffix = ".json";
		}else if(path.endsWith(".xml")){
			suffix = ".xml";
		}
		if(result==1){
			super.doFilterInternal(request, response, filterChain);
			return;
		}
		if(result==-1){
			RequestDispatcher rd = request.getRequestDispatcher(request.getServletPath()+ "/auth/unauth"+suffix);
			rd.forward(request,response); 
			return;
		}
		if(result==2){
			if(!isLoginDispatch(path,request)){
				super.doFilterInternal(request, response, filterChain);
				return;
			}else{
				RequestDispatcher rd = request.getRequestDispatcher(request.getServletPath()+ "/auth/unlogin"+suffix);
				rd.forward(request,response); 
				return;
			}
		}
	}

	/**
	 * 
	 * @param path
	 * @param request
	 * @return  1- auth URL, 2- authed, -1 -unauth
	 */
	private int isAuthDispatch(String path,HttpServletRequest request){
		for(String tmp:BaseResource.authURLs){
			if(path.startsWith(tmp)){
				return 1;
			}
		}
		DeviceStatus status = (DeviceStatus)request.getSession().getAttribute(BaseResource.SESSION_AUTH);
		if(status!=null&&StringUtils.isNotBlank(status.getTransID())){
			return 2;
		}else{
			return -1;
		}
	}
	private boolean isLoginDispatch(String path,HttpServletRequest request){
		RESTInternalUser restiu = (RESTInternalUser)request.getSession().getAttribute(BaseResource.SESSION_USER);
		if(restiu==null){
			for(String tmp:BaseResource.loginURLs){
				if(path.startsWith(tmp)){
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
