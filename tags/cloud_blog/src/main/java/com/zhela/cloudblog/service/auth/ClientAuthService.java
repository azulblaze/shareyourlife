package com.zhela.cloudblog.service.auth;

public interface ClientAuthService {

	public String getSerialID(String appkey,String sessionid);
	public boolean checkSerialID(String enc_serialid, String serialid);
}
