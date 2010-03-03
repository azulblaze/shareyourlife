package com.zhelazhela.services.impl;

import java.util.List;

import com.zhelazhela.db.dao.UserPrivacyDAO;
import com.zhelazhela.db.model.UserPrivacy;
import com.zhelazhela.db.model.UserPrivacyExample;
import com.zhelazhela.services.UserPrivacyService;

public class UserPrivacyServiceImpl implements UserPrivacyService {
	
	private UserPrivacyDAO userPrivacyDAO;
	
	private static List<UserPrivacy> initPrivacy = new java.util.ArrayList<UserPrivacy>();
	
	static{
		//允许所有用户关注
		UserPrivacy _up = new UserPrivacy();
		_up.setType(UserPrivacyService.TYPE_ALLOW_CARE);
		_up.setParameter1(UserPrivacyService.ALLOW_PRAMETER_USER);
		initPrivacy.add(_up);
		//允许所有用户邀请加入组
		_up = new UserPrivacy();
		_up.setType(UserPrivacyService.TYPE_ALLOW_GROUPADD);
		_up.setParameter1(UserPrivacyService.ALLOW_PRAMETER_USER);
		initPrivacy.add(_up);
		//允许所有用户浏览
		_up = new UserPrivacy();
		_up.setType(UserPrivacyService.TYPE_ALLOW_VIEW);
		_up.setParameter1(UserPrivacyService.ALLOW_PRAMETER_USER);
		initPrivacy.add(_up);
	}

	public void setUserPrivacyDAO(UserPrivacyDAO userPrivacyDAO) {
		this.userPrivacyDAO = userPrivacyDAO;
	}

	
	@Override
	public UserPrivacy addPrivacy(long userId, int type, int prame1, int prame2)
			throws Exception {
		UserPrivacy up = new UserPrivacy();
		up.setParameter1(prame1);
		up.setParameter2(prame2);
		up.setType(type);
		up.setUserId(userId);
		up.setUpdateTime(new java.util.Date());
		userPrivacyDAO.insert(up);
		return up;
	}

	@Override
	public void initPrivacy(long userId) throws Exception {
		for(UserPrivacy tmp:initPrivacy){
			tmp.setId(null);
			tmp.setUpdateTime(new java.util.Date());
			tmp.setUserId(userId);
			userPrivacyDAO.insert(tmp);
		}
	}

	@Override
	public List<UserPrivacy> loadUserPrivacy(long userId) throws Exception {
		UserPrivacyExample example = new UserPrivacyExample();
		example.createCriteria().andUserIdEqualTo(userId);
		java.util.List<UserPrivacy> ups = userPrivacyDAO.selectByExample(example);
		return ups;
	}

	@Override
	public UserPrivacy loadUserPrivacy(long userId, int type) throws Exception {
		UserPrivacyExample example = new UserPrivacyExample();
		example.createCriteria().andUserIdEqualTo(userId).andTypeEqualTo(type);
		java.util.List<UserPrivacy> ups = userPrivacyDAO.selectByExample(example);
		if(ups.size()>0){
			return ups.get(0);
		}
		return null;
	}

}
