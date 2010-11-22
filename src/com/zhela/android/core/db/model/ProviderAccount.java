package com.zhela.android.core.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public class ProviderAccount implements DBModel,Serializable{
	private static final long serialVersionUID = 7453610318960104864L;

	private final static String TABLE_NAME = "provider_account";
	public final static String createSQL = "CREATE  TABLE IF NOT EXISTS provider_account ("
			+ "account VARCHAR(20) NOT NULL ,"
			+ "provider_id INT NOT NULL ,"
			+ "provider_account VARCHAR(100) NOT NULL ,"
			+ "provider_userId VARCHAR(45) NULL ,"
			+ "provider_userHeader VARCHAR(200) NULL ,"
			+ "provider_userName VARCHAR(45) NULL ,"
			+ "status INT NULL ,"
			+ "update_time DATETIME NULL ,"
			+ "PRIMARY KEY (account, provider_id, provider_account) )";
	public final static String dropSQL = "drop table if not exists provider_account";
	
	public String account;
	public Long provider_id;
	public String provider_account;
	public String provider_userId;
	public String provider_userHeader;
	public String provider_userName;
	public int status;
	public java.util.Date update_time;
	
	@Override
	public ContentValues getContentValues(Set<String> field) {
		ContentValues cv = new ContentValues();
		if(field!=null){
			if(field.contains("account")){
				cv.put("account", account);
			}
			if(field.contains("provider_id")){
				cv.put("provider_id", provider_id);
			}
			if(field.contains("provider_account")){
				cv.put("provider_account", provider_account);
			}
			if(field.contains("provider_userId")){
				cv.put("provider_userId", provider_userId);
			}
			if(field.contains("provider_userHeader")){
				cv.put("provider_userHeader", provider_userHeader);
			}
			if(field.contains("provider_userName")){
				cv.put("provider_userName", provider_userName);
			}
			if(field.contains("status")){
				cv.put("provider_userName", status);
			}
			if(field.contains("update_time")){
				if(update_time==null){
					cv.putNull("update_time");
				}else{
					cv.put("update_time", update_time.toString());
				}
			}
		}else{
			cv.put("account", account);
			cv.put("provider_id", provider_id);
			cv.put("provider_account", provider_account);
			cv.put("provider_userId", provider_userId);
			cv.put("provider_userHeader", provider_userHeader);
			cv.put("provider_userName", provider_userName);
			cv.put("status", status);
			if(update_time==null){
				cv.putNull("update_time");
			}else{
				cv.put("update_time", update_time.toString());
			}
		}
		return cv;
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public void setContentValues(Cursor cur) {
		account = cur.getString(cur.getColumnIndex("account"));
		provider_id = cur.getLong(cur.getColumnIndex("provider_id"));
		provider_account = cur.getString(cur.getColumnIndex("provider_account"));
		provider_userId = cur.getString(cur.getColumnIndex("provider_userId"));
		provider_userHeader = cur.getString(cur.getColumnIndex("provider_userHeader"));
		provider_userName = cur.getString(cur.getColumnIndex("provider_userName"));
		status = cur.getInt(cur.getColumnIndex("status"));
		update_time = new Date(cur.getString(cur.getColumnIndex("update_time")));
	}

}
