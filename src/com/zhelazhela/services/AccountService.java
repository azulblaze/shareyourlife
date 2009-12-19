package com.zhelazhela.services;

import com.zhelazhela.db.model.ManageUser;

public interface AccountService {
	
	public boolean validateManager(ManageUser mu) throws Exception;
	
}
