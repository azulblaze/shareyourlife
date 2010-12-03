package com.zhela.android.core.db;

import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.Provider;
import com.zhela.android.core.db.model.ProviderAccount;
import com.zhela.android.core.db.model.User;

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
		arg0.execSQL(User.createSQL);
		arg0.execSQL(Image.createSQL);
		arg0.execSQL(Provider.createSQL);
		arg0.execSQL(ProviderAccount.createSQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL(User.dropSQL);
		arg0.execSQL(Image.dropSQL);
		arg0.execSQL(Provider.dropSQL);
		arg0.execSQL(ProviderAccount.dropSQL);
		onCreate(arg0);
	}
		
}