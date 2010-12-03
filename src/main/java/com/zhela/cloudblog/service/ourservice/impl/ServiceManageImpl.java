package com.zhela.cloudblog.service.ourservice.impl;

import com.zhela.cloudblog.dao.ourservice.ServiceBindDAO;
import com.zhela.cloudblog.model.ourservice.ServiceBind;
import com.zhela.cloudblog.service.ourservice.ServiceManage;

public class ServiceManageImpl implements ServiceManage {

	ServiceBindDAO serviceBindDAO;
	
	/* (non-Javadoc)
	 * @see com.zhela.cloudblog.service.ourservice.ServiceManage#isAllowed(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isAllowed(String code, String params) {
		ServiceBind sb = serviceBindDAO.selectByPrimaryKey(code);
		if(sb!=null&&params.startsWith(sb.getParms())){
			return true;
		}
		return false;
	}

	
	public void setServiceBindDAO(ServiceBindDAO serviceBindDAO) {
		this.serviceBindDAO = serviceBindDAO;
	}
	
}
