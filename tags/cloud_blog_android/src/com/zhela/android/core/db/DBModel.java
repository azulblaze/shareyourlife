package com.zhela.android.core.db;

import android.content.ContentValues;
import android.database.Cursor;

public interface DBModel{

	public String getTableName();
	public ContentValues getContentValues();
	public void setContentValues(Cursor cur);
}
