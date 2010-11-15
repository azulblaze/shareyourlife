package com.zhela.android.core.remote.business;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.HttpParse;
import com.zhela.android.core.net.NetStatusException;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.exception.DefaultException;

public class ServiceImpl implements Service {
	private final static String APP_KEY = "8ca4e82e189afbd";
	private final static String BASE_URL = "http://10.80.3.186:8080/cloudblog/api/";
	private final static String URL_AuthClient = BASE_URL+ "auth/";
	private final static String URL_AuthUser = BASE_URL+ "";
	private static HttpClient httpclient;
	@Override
	public String authRequestKey() throws DefaultException {
		httpclient = new DefaultHttpClient();
		HttpParse hp = new HttpParse(httpclient);
		try{
			hp.GET(URL_AuthClient+APP_KEY);
		}catch(NetStatusException e){
			
		}
		return "";
	}

	@Override
	public RESTInternalUser login(String username, String password)
			throws DefaultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authRequestResult(String encKey, String deviceType,
			String deviceSys, String deviceID) throws DefaultException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shutdownApp() throws DefaultException {
		// TODO Auto-generated method stub
		return false;
	}

}
