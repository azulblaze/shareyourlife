package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.GroupUserDAO;
import com.zhelazhela.db.dao.GrouperDAO;
import com.zhelazhela.db.model.GroupUser;
import com.zhelazhela.db.model.Grouper;
import com.zhelazhela.services.GroupService;

public class GroupServiceImpl implements GroupService {

	GrouperDAO grouperDAO;
	
	GroupUserDAO groupUserDAO;
	
	public void setGrouperDAO(GrouperDAO grouperDAO) {
		this.grouperDAO = grouperDAO;
	}

	@Override
	public GroupUser addUserToGroup(long userId, long groupId,String msg) throws Exception {
		Grouper g = grouperDAO.selectByPrimaryKey(groupId);
		if(g==null){
			throw new Exception("该组不存在或者已经被删除");
		}
		switch(g.getVisibility()){
		case Grouper.VISIBILITY_A_DENEY:
			throw new Exception("该组不允许增加成员");
		case Grouper.VISIBILITY_A_APPLY:
			
		}
		return null;
	}

	@Override
	public boolean allowToGroup(long myId, long userId, long groupId)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void applyPermisson(long myId, long userId, long groupId)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Grouper createGroup(Grouper grouper) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delGroup(long myId, long groupId,String msg) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUserFromGroup(long userId, long groupId) throws Exception {
		// TODO Auto-generated method stub

	}

}
