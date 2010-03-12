package com.zhelazhela.services;

import com.zhelazhela.domain.form.AddFriend;

public interface UserRelationService {

	public int addFriend(AddFriend af) throws Exception;
	
	public boolean delFriend(AddFriend af) throws Exception;
	
	public boolean allowFriend(AddFriend af) throws Exception;
	
	public boolean blockFriend(AddFriend af) throws Exception;
}
