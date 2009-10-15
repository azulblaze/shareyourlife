package com.twitpic.domain;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.json.JSONObject;

import com.twitpic.db.model.PicturesParameter;

public class JSONTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		PicturesParameter p = new PicturesParameter();
		p.setUploadTime(new java.util.Date());
	
		String json_str = p.to_json().toString();
		JSONObject jsonObject = JSONObject.fromObject(json_str);      
		System.out.println(jsonObject.get("uploadTime"));
		Object bean = JSONObject.toBean( jsonObject );
	}
}