package com.zhela.android.core.db.model;

import java.util.Set;

import android.content.ContentValues;
import android.database.Cursor;

public interface DBModel{

	public String getTableName();
	public ContentValues getContentValues(Set<String> field);
	public void setContentValues(Cursor cur);
}
