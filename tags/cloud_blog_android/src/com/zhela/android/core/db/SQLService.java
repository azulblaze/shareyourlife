package com.zhela.android.core.db;

import java.util.List;
import java.util.Set;

public class SQLService {

	private SQLiteFactory sqf;
	
	public SQLService(){
		sqf =SQLiteFactory.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public Users getDefaultUsers(){
		List<Users> users;
		try {
			users = (List<Users>)sqf.loadList("select * from users where is_default='true'", Users.class);
			if(users.size()>=0){
				return users.get(0);
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	public int getUserCount(){
		return sqf.loadModelCount("select count(*) from users"); 
	}
	@SuppressWarnings("unchecked")
	public int updateOrInsertUser(Users users,String where,Set<String> field){
		int size = 0;
		try {
			size = ((java.util.List<Users>)sqf.loadList("select * from users where account='"+users.account+"'", Users.class)).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(size>0){
			return sqf.updateModel(users, where, field);
		}else{
			users.update_time = new java.util.Date();
			sqf.saveModel(users);
			return 1;
		}
	}
	public void reSetDefaultUser(){
		sqf.equals("update users set is_default='false' where is_default='true'");
	}
}
