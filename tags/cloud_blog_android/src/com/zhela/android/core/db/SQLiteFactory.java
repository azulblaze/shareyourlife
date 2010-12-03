package com.zhela.android.core.db;

import java.util.Set;

import com.zhela.android.core.db.model.DBModel;

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
		Cursor cur = null;
		try{
			cur = sqlite.rawQuery(sql, null);
			while(cur.moveToNext()){
				DBModel model = (DBModel)classOf.newInstance();
				model.setContentValues(cur);
				models.add(model);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cur.close();
			close();
		}
		return models;
	}
	
	public void saveModel(DBModel model){
		open();
		try{
			sqlite.insert(model.getTableName(), null, model.getContentValues(null));
		}catch(Exception e){
		}
		close();
	}
	
	public int loadModelCount(String sql){
		int size = 0;
		open();
		try{
			Cursor cur = sqlite.rawQuery(sql, null);
			if(cur.moveToNext()){
				size = cur.getInt(0);
			}
			cur.close();
		}catch(Exception e){
			
		}
		close();
		return size;
	}
	
	public void executeSQL(String sql){
		open();
		try{
			sqlite.execSQL(sql);
		}catch(Exception e){
		}
		close();
	}
	
	public int updateModel(DBModel model,String where,Set<String> field){
		open();
		try{
			return sqlite.update(model.getTableName(), model.getContentValues(field), where, null);
		}catch(Exception e){
		}
		close();
		return 0;
	}
}
