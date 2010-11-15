package com.zhela.android.core.remote.business;

import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.exception.DefaultException;

public interface Service {
	
	public boolean authClient(String deviceType,String deviceSys,String deviceID) throws DefaultException;
	
	public boolean shutdownApp() throws DefaultException;
	
	public RESTInternalUser login(String username,String password) throws DefaultException;
	
}
