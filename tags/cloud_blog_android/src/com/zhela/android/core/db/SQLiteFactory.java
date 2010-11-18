package com.zhela.android.core.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteFactory {
	public static SQLiteSupport instance = null;
	private SQLiteDatabase sqlite;
	
	private SQLiteFactory(){
		
	}
	private static SQLiteFactory factory;
	public static synchronized SQLiteFactory getInstance(){
		if(factory==null){
			factory = new SQLiteFactory();
		}
		return factory;
	}
	
	private void open(){
		sqlite = instance.getWritableDatabase();
	}
	private void close(){
		sqlite.close();
	}
	@SuppressWarnings("unchecked")
	public Object loadList(String sql,Class classOf) throws Exception{
		java.util.List<DBModel> models = new java.util.ArrayList<DBModel>();
		open();
		Cursor cur = sqlite.rawQuery(sql, null);
		while(cur.moveToNext()){
			DBModel model = (DBModel)classOf.newInstance();
			model.setContentValues(cur);
			models.add(model);
		}
		cur.close();
		close();
		return models;
	}
	
	public void saveModel(DBModel model){
		open();
		sqlite.insert(model.getTableName(), null, model.getContentValues());
		close();
	}
	
	public int loadModelCount(String sql){
		int size = 0;
		open();
		Cursor cur = sqlite.rawQuery(sql, null);
		if(cur.moveToNext()){
			size = cur.getInt(1);
		}
		cur.close();
		close();
		return size;
	}
	
	public int updateModel(DBModel model,String where,String []whereargs){
		open();
		int size = sqlite.update(model.getTableName(), model.getContentValues(), where, whereargs);
		close();
		return size;
	}
}
