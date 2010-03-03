package com.zhelazhela.services;

import com.zhelazhela.db.model.GroupUser;
import com.zhelazhela.db.model.Grouper;

public interface GroupService {

	public Grouper createGroup(Grouper grouper) throws Exception;
	
	public GroupUser addUserToGroup(long user_id,long group_id,String msg) throws Exception;
		
	public void applyPermisson(long my_id,long user_id,long group_id,int permisson) throws Exception;
	
	public void removeUserFromGroup(long user_id,long group_id) throws Exception;
	
	public void delGroup(long my_id,long group_id,String msg) throws Exception;
	
}
