package com.zhela.cloudblog.action.model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class JSONResponse {

	public final static String SUCCESS = "success";
	public final static String FAIL = "fail";
	public final static String LOGIN = "login";
	
	private JSONObject jb = new JSONObject();
	
	public JSONResponse(String result,JSONObject data){
		try {
			jb.put("result", result);
			jb.put("data", data);
		} catch (JSONException e) {
			
		}
	}
	
	public JSONResponse(String result,String data){
		try {
			jb.put("result", result);
			jb.put("data", data);
		} catch (JSONException e) {
			
		}
	}
	
	public String toJSON(){
		return jb.toString();
	}
}
