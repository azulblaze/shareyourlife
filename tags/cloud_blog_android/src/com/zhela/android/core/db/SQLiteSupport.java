package com.zhela.android.core.db;

import com.zhela.android.core.db.model.Users;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteSupport extends SQLiteOpenHelper{
	
	public SQLiteSupport(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		//create users
		arg0.execSQL(Users.createSQL);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL(Users.dropSQL);
		onCreate(arg0);
	}
		
}