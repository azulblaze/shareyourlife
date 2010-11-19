package com.zhela.android.core.db;

import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public interface DBModel{

	public String getTableName();
	public ContentValues getContentValues(Set<String> filed);
	public void setContentValues(Cursor cur);
}
