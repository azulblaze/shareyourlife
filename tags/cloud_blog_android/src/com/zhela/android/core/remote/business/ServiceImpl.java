package com.zhela.android.core.remote.business;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.HttpParse;
import com.zhela.android.core.net.NetStatusException;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.remote.model.RESTResponse;
import com.zhela.android.exception.DefaultException;

public class ServiceImpl implements Service {
	private final static String APP_KEY = "8ca4e82e189afbd";
	private final static String FORMAT = ".json";
	private final static String BASE_URL = "http://169.254.165.229:8080/cloudblog/api/";
	private final static String URL_AuthClient = BASE_URL+ "auth/";
	private final static String URL_AuthUser = BASE_URL+ "users/";
	private static HttpClient httpclient;

	@Override
	public RESTInternalUser login(String username, String password)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTInternalUser response;
			response = hp.getResponse(HttpParse.METHOD_GET, (URL_AuthUser+URLEncoder.encode(username,"utf-8")+"/"+URLEncoder.encode(password,"utf-8"+FORMAT)), null, null, null, RESTInternalUser.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,e.getMessage());
			}else{
				DefaultException de = new DefaultException(DefaultException.NEEDLOGIN,e.getMessage());
				RESTResponse response = new RESTResponse();
				response.setStatus(e.getCode()+"");
				response.setDescription(e.getMessage());
				de.setResponse(response);
				throw de;
			}
		}catch(UnsupportedEncodingException e){
			throw new DefaultException(DefaultException.NEEDLOGIN,e.getMessage());
		}
	}

	@Override
	public boolean authClient(String deviceType,
			String deviceSys, String deviceID) throws DefaultException {
		httpclient = new DefaultHttpClient();
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_GET, URL_AuthClient+APP_KEY+FORMAT, null, null, null, RESTResponse.class);
			String encKey = response.getDescription();
			try{
				encKey = URLEncoder.encode(encKey, "utf-8");
				deviceType = URLEncoder.encode(deviceType, "utf-8");
				deviceSys = URLEncoder.encode(deviceSys, "utf-8");
				deviceID = URLEncoder.encode(deviceID, "utf-8");
			}catch(Exception e){
				
			}
			response = hp.getResponse(HttpParse.METHOD_GET, 
					URL_AuthClient+encKey+"/"+deviceType+"/"+deviceSys+"/"+deviceID+FORMAT,
					null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else{
				throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
			}
		}
	}

	@Override
	public boolean shutdownApp() throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			@SuppressWarnings("unused")
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_AuthUser, null, null, null, RESTResponse.class);
		}catch(NetStatusException e){
		}
		return true;
	}

}
