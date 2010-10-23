package com.zhela.cloudblog.service.auth;

import com.zhela.cloudblog.rest.auth.AuthResource;

public interface ClientAuthService {

	public String getSerialID(String appkey,String sessionid);
	public boolean checkSerialID(String enc_serialid, String serialid);
	public void insertDeviceLog(AuthResource.DeviceStatus status,String sessionId,int action);
}
