package com.zhela.android.core.db.model;

import java.io.Serializable;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public class Providers implements DBModel ,Serializable{
	
	private static final long serialVersionUID = 2649492093263108032L;
	private final static String TABLE_NAME = "users";
	public final static String createSQL = "CREATE  TABLE IF NOT EXISTS providers ("
			+ "id INT NOT NULL ,"
			+ "rank INT NULL ,"
			+ "name VARCHAR(45) NULL ,"
			+ "web_url VARCHAR(200) NULL ,"
			+ "reg_url VARCHAR(200) NULL ,"
			+ "description VARCHAR(500) NULL ,"
			+ "logo VARCHAR(200) NULL ,"
			+ "logo_img BLOB NULL ,"
			+ "status INT NULL ," + "PRIMARY KEY (id) )";
	public final static String dropSQL = "drop table if not exists providers";
	
	public int id;
	public int rank;
	public String name;
	public String web_url;
	public String reg_url;
	public String description;
	public String logo;
	
	@Override
	public ContentValues getContentValues(Set<String> field) {
		ContentValues cv = new ContentValues();
		if(field!=null){
			if(field.contains("id")){
				cv.put("id", id);
			}
			if(field.contains("rank")){
				cv.put("rank", rank);
			}
			if(field.contains("name")){
				cv.put("name", name);
			}
			if(field.contains("web_url")){
				cv.put("web_url", web_url);
			}
			if(field.contains("reg_url")){
				cv.put("reg_url", reg_url);
			}
			if(field.contains("description")){
				cv.put("description", description);
			}
			if(field.contains("logo")){
				cv.put("logo", logo);
			}
		}else{
			cv.put("id", id);
			cv.put("rank", rank);
			cv.put("name", name);
			cv.put("web_url", web_url);
			cv.put("reg_url", reg_url);
			cv.put("description", description);
			cv.put("logo", logo);
		}
		return cv;
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public void setContentValues(Cursor cur) {
		id = cur.getInt(cur.getColumnIndex("id"));
		rank = cur.getInt(cur.getColumnIndex("rank"));
		name = cur.getString(cur.getColumnIndex("name"));
		web_url = cur.getString(cur.getColumnIndex("web_url"));
		reg_url = cur.getString(cur.getColumnIndex("reg_url"));
		description = cur.getString(cur.getColumnIndex("description"));
		logo = cur.getString(cur.getColumnIndex("logo"));
	}

}
