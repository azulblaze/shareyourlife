package com.zhela.android.core.db.model;

import java.text.SimpleDateFormat;
import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public interface DBModel{

	public final static java.text.DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String getTableName();
	public ContentValues getContentValues(Set<String> field);
	public void setContentValues(Cursor cur);
}
