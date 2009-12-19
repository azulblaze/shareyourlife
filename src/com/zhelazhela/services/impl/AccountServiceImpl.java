package com.zhelazhela.services.impl;

import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.db.dao.ManageUserDAO;
import com.zhelazhela.services.AccountService;

public class AccountServiceImpl implements AccountService {

	private ManageUserDAO manageUserDAO;
	
	@Override
	public boolean validateManager(ManageUser mu) throws Exception {
		ManageUser tmp = manageUserDAO.selectByPrimaryKey(mu.getAccount());
		if(tmp!=null&&tmp.getIsvalid()&&tmp.getPassword().equals(mu.getPassword())){
			mu.setPassword(null);
			return true;
		}
		return false;
	}

	public void setManageUserDAO(ManageUserDAO manageUserDAO) {
		this.manageUserDAO = manageUserDAO;
	}

	
}
