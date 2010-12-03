package com.zhela.android.core.db.model;

import java.io.Serializable;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public class User implements DBModel,Serializable{
	
	private static final long serialVersionUID = 4712138648251409930L;

	public final static String TABLE_NAME = "users";
	
	public final static String createSQL = "CREATE  TABLE IF NOT EXISTS users ("
			+ "account VARCHAR(100) NOT NULL ,"
			+ "display_name VARCHAR(45) NOT NULL ,"
			+ "is_password boolean  NULL DEFAULT true ,"
			+ "is_default boolean  NULL DEFAULT false ,"
			+ "account_password VARCHAR(200) NULL ,"
			+ "email VARCHAR(45) NULL ,"
			+ "header_url VARCHAR(200) NULL ,"
			+ "update_time TIMESTAMP NULL ,"
			+ "PRIMARY KEY (account) )";
	public final static String dropSQL = "drop table if not exists users";
	
	public String account;
	public String display_name;
	public boolean is_password = true;
	public boolean is_default = false;
	public String account_password;
	public String email;
	public String header_url;
	public java.util.Date update_time;
	public boolean want_login;
	
	
	public ContentValues getContentValues(Set<String> field){
		ContentValues cv = new ContentValues();
		if(field!=null){
			if(field.contains("account")){
				cv.put("account", account);
			}
			if(field.contains("display_name")){
				cv.put("display_name", display_name);
			}
			if(field.contains("is_password")){
				cv.put("is_password", Boolean.toString(is_password));
			}
			if(field.contains("is_default")){
				cv.put("is_default", Boolean.toString(is_default));
			}
			if(field.contains("account_password")){
				cv.put("account_password", account_password);
			}
			if(field.contains("email")){
				cv.put("email", email);
			}
			if(field.contains("header_url")){
				cv.put("header_url", header_url);
			}
			if(field.contains("update_time")){
				if(update_time==null){
					cv.putNull("update_time");
				}else{
					cv.put("update_time",iso8601Format.format(update_time));
				}
			}
		}else{
			cv.put("account", account);
			cv.put("display_name", display_name);
			cv.put("is_password", Boolean.toString(is_password));
			cv.put("is_default", Boolean.toString(is_default));
			cv.put("account_password", account_password);
			cv.put("email", email);
			cv.put("header_url", header_url);
			if(update_time==null){
				cv.putNull("update_time");
			}else{
				cv.put("update_time", iso8601Format.format(update_time));
			}
		}
		return cv;
	}
	
	public void setContentValues(Cursor cur){
		header_url = cur.getString(cur.getColumnIndex("header_url"));
		account = cur.getString(cur.getColumnIndex("account"));
		display_name = cur.getString(cur.getColumnIndex("display_name"));
		is_password = Boolean.parseBoolean(cur.getString(cur.getColumnIndex("is_password")));
		if(is_password){
			account_password = cur.getString(cur.getColumnIndex("account_password"));
		}
		is_default = Boolean.parseBoolean(cur.getString(cur.getColumnIndex("is_default")));
		email = cur.getString(cur.getColumnIndex("email"));
		String update_time_str = cur.getString(cur.getColumnIndex("update_time"));
		try {
			if(update_time_str!=null){
				update_time = iso8601Format.parse(update_time_str);
			}
		} catch (java.text.ParseException e) {
		}
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
}
