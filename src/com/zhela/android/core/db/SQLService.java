package com.zhela.android.core.db;

import java.util.List;

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
	public int updateUser(Users users,String where,String []whereargs){
		return sqf.updateModel(users, where, whereargs);
	}
}
