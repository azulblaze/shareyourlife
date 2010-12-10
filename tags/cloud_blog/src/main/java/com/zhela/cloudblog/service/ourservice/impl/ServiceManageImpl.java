package com.zhela.cloudblog.service.ourservice.impl;

import com.zhela.cloudblog.dao.ourservice.ServiceBindDAO;
import com.zhela.cloudblog.model.ourservice.ServiceBind;
import com.zhela.cloudblog.model.ourservice.ServiceBindExample;
import com.zhela.cloudblog.service.ourservice.ServiceManage;

public class ServiceManageImpl implements ServiceManage {

	ServiceBindDAO serviceBindDAO;
	
	/* (non-Javadoc)
	 * @see com.zhela.cloudblog.service.ourservice.ServiceManage#isAllowed(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isAllowed(String code, String params) {
		ServiceBind sb = serviceBindDAO.selectByPrimaryKey(code);
		if(sb!=null&&sb.getStatus()==ServiceBind.STATUS_OK&&params.startsWith(sb.getParms())){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isAllowedAccount(String code, String account) {
		ServiceBind sb = serviceBindDAO.selectByPrimaryKey(code);
		if(sb!=null&&sb.getAccount().equals(account)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isExist(String params, int serviceId, String account) {
		ServiceBindExample example = new ServiceBindExample();
		example.createCriteria().andAccountEqualTo(account).andOurServiceIdEqualTo(serviceId).andParmsEqualTo(params);
		if(serviceBindDAO.selectByExample(example).size()>0){
			return true;
		}
		return false;
	}
	

	@Override
	public ServiceBind addService(String account, String parms,int serviceId)throws Exception{
		if(!isExist(parms, serviceId, account)){
			ServiceBind sb = new ServiceBind();
			sb.setParms(parms);
			sb.setAccount(account);
			sb.setCode(getBindID());
			sb.setStatus(ServiceBind.STATUS_OK);
			sb.setOurServiceId(serviceId);
			serviceBindDAO.insert(sb);
			return sb;
		}else{
			throw new Exception("你已经添加过这个服务了");
		}
	}
	
	@Override
	public int deleteService(String account,String bindID) throws Exception {
		ServiceBindExample example = new ServiceBindExample();
		example.createCriteria().andCodeEqualTo(bindID).andAccountEqualTo(account);
		return serviceBindDAO.deleteByExample(example);
	}

	@Override
	public java.util.List<ServiceBind> loadStatus(String account,int serviceId) throws Exception {
		ServiceBindExample example = new ServiceBindExample();
		example.createCriteria().andAccountEqualTo(account).andOurServiceIdEqualTo(serviceId);
		return serviceBindDAO.selectByExample(example);
	}

	@Override
	public ServiceBind updateStatus(String account,String bindID,int status) throws Exception {
		ServiceBind sb = serviceBindDAO.selectByPrimaryKey(bindID);
		if(sb!=null){
			if(!sb.getAccount().equals(account)){
				throw new Exception("你没有操作权限");
			}
			if(status>0){
				status = ServiceBind.STATUS_OK;
			}else{
				status = ServiceBind.STATUS_STOP;
			}
			sb.setStatus(status);
			serviceBindDAO.updateByPrimaryKey(sb);
			return sb;
		}else{
			throw new Exception("该服务不存在");
		}
	}
	
	private static int ROUND = 9;
	private static synchronized String getBindID() {
		if(ROUND>99){
			ROUND = 9;
		}
		ROUND++;
		return System.currentTimeMillis()+""+ROUND;
	}
	
	

	public void setServiceBindDAO(ServiceBindDAO serviceBindDAO) {
		this.serviceBindDAO = serviceBindDAO;
	}
	
}
