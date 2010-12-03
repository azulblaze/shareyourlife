package com.zhela.android.core.db.model;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.zhela.android.core.util.CommonResource;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

public class Image implements DBModel,Serializable{

	private static final long serialVersionUID = -3937034423982884898L;
	public final static String TABLE_NAME = "images";
	public final static int STATUS_OK = 2;
	public final static int STATUS_DOWLOADING = 1;
	public final static int STATUS_PENDING = 0;
	public final static int STATUS_FAIL = -1;
	public final static int TYPE_SYSTEM = 1;
	public final static int TYPE_WEIBO = 0;
	public final static int SCALE_HEADER = 0;
	public final static int SCALE_WEIBOIMG = 1;
	public final static int SCALE_WEIBOHEADER = 2;
	public final static String createSQL = "CREATE  TABLE IF NOT EXISTS images ("
			+ "id INTEGER NOT NULL PRIMARY KEY,"
			+ "type INT NULL ,"
			+ "url VARCHAR(400) NULL ,"
			+ "status VARCHAR(45) NULL ,"
			+ "bitimg BLOB NULL ,"
			+ "update_time DATETIME NULL)";
	public final static String dropSQL = "drop table if not exists images";
	public long id;
	public int type = TYPE_WEIBO;
	public String url;
	public int status = STATUS_PENDING;
	private Bitmap bitmap;
	public byte []bitimg;
	public Date update_time;
	@Override
	public ContentValues getContentValues(Set<String> field) {
		ContentValues cv = new ContentValues();
		if(field!=null){
			if(field.contains("type")){
				cv.put("type", type);
			}
			if(field.contains("url")){
				cv.put("url", url);
			}
			if(field.contains("status")){
				cv.put("status", status);
			}
			if(field.contains("update_time")){
				if(update_time==null){
					cv.putNull("update_time");
				}else{
					cv.put("update_time", iso8601Format.format(update_time));
				}
			}
			if(field.contains("bitimg")){
				if(bitimg!=null){
					cv.put("bitimg", getBitmapAsByteArray(bitmap));
				}else{
					cv.putNull("bitimg");
				}
			}
		}else{
			cv.put("type", type);
			cv.put("url", url);
			cv.put("status", status);
			if(bitimg!=null){
				cv.put("bitimg", getBitmapAsByteArray(bitmap));
			}else{
				cv.putNull("bitimg");
			}
			if(update_time==null){
				cv.putNull("update_time");
			}else{
				cv.put("update_time", iso8601Format.format(update_time));
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
		id = cur.getLong(cur.getColumnIndex("id"));
		type = cur.getInt(cur.getColumnIndex("type"));
		url = cur.getString(cur.getColumnIndex("url"));
		status = cur.getInt(cur.getColumnIndex("status"));
		bitimg = cur.getBlob(cur.getColumnIndex("bitimg"));
		String update_time_str = cur.getString(cur.getColumnIndex("update_time"));
		try {
			if(update_time_str!=null){
				update_time = iso8601Format.parse(update_time_str);
			}
		} catch (java.text.ParseException e) {
		}
	}
	
	public Bitmap getBitmap() {
		if(bitmap==null&&bitimg!=null){
			bitmap = CommonResource.getBitmap(bitimg);
		}
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
		this.bitimg = getBitmapAsByteArray(bitmap);
	}
	private byte[] getBitmapAsByteArray(Bitmap bitmap) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 0, outputStream);
		return outputStream.toByteArray();
	}
}
