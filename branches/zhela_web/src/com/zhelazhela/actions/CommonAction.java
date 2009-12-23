package com.zhelazhela.actions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zhelazhela.services.UtilService;

@SuppressWarnings("serial")
public class CommonAction extends BaseAction {
	
	private long province_id;
	
	private long father_id;
	
	private UtilService utilService;
	
	public String loadCity() throws Exception{
		JSONObject jb = new JSONObject();
		JSONArray ja = new JSONArray();
		ja.addAll(utilService.loadCitys(province_id));
		jb.put("result", ja);
		setValue("json",jb);
		return "json";
	}
	
	public long getProvince_id() {
		return province_id;
	}

	public void setProvince_id(long provinceId) {
		province_id = provinceId;
	}

	public long getFather_id() {
		return father_id;
	}

	public void setFather_id(long fatherId) {
		father_id = fatherId;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}
	
}
