package com.zhela.cloudblog.service.ourservice;

import com.zhela.cloudblog.model.ourservice.ServiceBind;

public interface ServiceManage {

	public boolean isAllowed(String code,String params);
	
	public boolean isAllowedAccount(String code,String account);
	
	public boolean isExist(String params,int service_id,String account);
	
	public ServiceBind addService(String account, String parms,int serviceId)throws Exception;
	
	public java.util.List<ServiceBind> loadStatus(String account,int serviceId) throws Exception;
	
	public ServiceBind updateStatus(String account,String bindID,int status) throws Exception;
	
	public int deleteService(String account,String bindID) throws Exception;
	
}
