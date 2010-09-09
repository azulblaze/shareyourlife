package com.zhelazhela.cloudblog.action;

import java.util.HashMap;
import java.util.Map;

import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.services.Maintenance;

public class SystemAction extends BaseAction {

	private static final long serialVersionUID = -846676903732584882L;
	private Maintenance maintenance;
	private String lastupdate;
	
	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	public void setMaintenance(Maintenance maintenance) {
		this.maintenance = maintenance;
	}

	public String testNetwork() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		setValue(XML,maintenance.testNetwork(param));
		return SUCCESS;
	}
	
	public String getSession() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("appkey", getRequestParameter("appkey"));
		param.put("serialid", getHttpSession().getId()+System.currentTimeMillis());
		ACK ack = maintenance.getSerialID(param);
		if(ack.getResultCode().equals(com.zhelazhela.cloudblog.domain.Result.SUCCESS)){
			saveSession("SN",ack);
		}
		setValue(XML,ack.toXML());
		return SUCCESS;
	}
	
	public String checkSession() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		ACK ack = (ACK)getSession("SN");
		if(ack!=null&&ack.getResultCode().equals(com.zhelazhela.cloudblog.domain.Result.SUCCESS)){
			param.put("serialid", ack.getResultDesc());
		}
		param.put("enc_serialid", getRequestParameter("serialid"));
		ack = maintenance.checkSerialID(param);
		clearSession("SN");
		if(ack.getResultCode().equals(com.zhelazhela.cloudblog.domain.Result.SUCCESS)){
			saveSession(ALLOW,com.zhelazhela.cloudblog.domain.Result.SUCCESS);
		}
		setValue(XML,ack.toXML());
		return SUCCESS;
	}
	
	public String loadProvider() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("lastupdate", lastupdate);
		setValue(XML,maintenance.loadProviders(param));
		return SUCCESS;
	}
	
}
