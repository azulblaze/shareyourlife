package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.GroupDiscussionDAO;
import com.zhelazhela.db.dao.GroupDiscussionPostDAO;
import com.zhelazhela.db.dao.GroupUserDAO;
import com.zhelazhela.db.dao.GroupWallDAO;
import com.zhelazhela.db.dao.GrouperDAO;
import com.zhelazhela.db.model.GroupDiscussionExample;
import com.zhelazhela.db.model.GroupDiscussionPostExample;
import com.zhelazhela.db.model.GroupUser;
import com.zhelazhela.db.model.GroupUserExample;
import com.zhelazhela.db.model.GroupWallExample;
import com.zhelazhela.db.model.Grouper;
import com.zhelazhela.db.model.GrouperExample;
import com.zhelazhela.db.model.UserPrivacy;
import com.zhelazhela.services.GroupService;
import com.zhelazhela.services.UserPrivacyService;

public class GroupServiceImpl implements GroupService {

	private GrouperDAO grouperDAO;
	
	private GroupUserDAO groupUserDAO;
	
	private UserPrivacyService userPrivacyService;
	
	private GroupDiscussionDAO groupDiscussionDAO;
	
	private GroupDiscussionPostDAO groupDiscussionPostDAO;
	
	private GroupWallDAO groupWallDAO;
	
	public void setGrouperDAO(GrouperDAO grouperDAO) {
		this.grouperDAO = grouperDAO;
	}

	public void setUserPrivacyService(UserPrivacyService userPrivacyService) {
		this.userPrivacyService = userPrivacyService;
	}

	public void setGroupUserDAO(GroupUserDAO groupUserDAO) {
		this.groupUserDAO = groupUserDAO;
	}

	public void setGroupDiscussionDAO(GroupDiscussionDAO groupDiscussionDAO) {
		this.groupDiscussionDAO = groupDiscussionDAO;
	}

	public void setGroupDiscussionPostDAO(
			GroupDiscussionPostDAO groupDiscussionPostDAO) {
		this.groupDiscussionPostDAO = groupDiscussionPostDAO;
	}

	public void setGroupWallDAO(GroupWallDAO groupWallDAO) {
		this.groupWallDAO = groupWallDAO;
	}

	@Override
	public GroupUser addUserToGroup(long userId, long groupId,String msg) throws Exception {
		Grouper g = grouperDAO.selectByPrimaryKey(groupId);
		if(g==null){
			throw new Exception("该组不存在或者已经被删除");
		}
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
		int size = groupUserDAO.countByExample(gue);
		if(size>0){
			throw new Exception("您已经是该组的成员");
		}
		gue.clear();
		gue.createCriteria().andGroupIdEqualTo(groupId);
		size = groupUserDAO.countByExample(gue);
		if(size>=g.getMaxUser()){
			throw new Exception("该组的用户数已经达到上限");
		}
		GroupUser gu = new GroupUser();
		gu.setPermission(GroupUser.PERMISSION_GEN);
		gu.setGroupId(groupId);
		gu.setUserId(userId);
		gu.setUpdatetime(new java.util.Date());
		groupUserDAO.insert(gu);
		return gu;
	}

	@Override
	public void applyPermisson(long myId, long userId, long groupId,int permisson)
			throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(myId).andPermissionEqualTo(GroupUser.PERMISSION_CREATER);
		int size = groupUserDAO.countByExample(gue);
		if(size==0){
			throw new Exception("您不具有该权限");
		}
		
		if(permisson==GroupUser.PERMISSION_ADMIN){
			gue.clear();
			gue.createCriteria().andGroupIdEqualTo(groupId).andPermissionEqualTo(permisson);
			size = groupUserDAO.countByExample(gue);
			if(size>=GroupUser.MAX_ADMIN){
				throw new Exception("该组的管理员用户已经打到最大数量");
			}
		}
		
		gue.clear();
		gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId).andPermissionNotEqualTo(GroupUser.PERMISSION_CREATER);
		java.util.List<GroupUser> list = groupUserDAO.selectByExample(gue);
		if(list.size()==0){
			throw new Exception("该用户还不是该组的成员");
		}else{
			GroupUser _gu = list.get(0);
			_gu.setPermission(permisson);
			_gu.setUpdatetime(new java.util.Date());
			groupUserDAO.updateByPrimaryKeySelective(_gu);
		}
	}

	@Override
	public Grouper createGroup(Grouper grouper) throws Exception {
		UserPrivacy up = userPrivacyService.loadUserPrivacy(grouper.getUserId(), UserPrivacyService.TYPE_MAX_GROUP);
		int max_group = up.getParameter1();
		GrouperExample ge = new GrouperExample();
		ge.createCriteria().andUserIdEqualTo(grouper.getUserId());
		if(grouperDAO.countByExample(ge)>=max_group){
			throw new Exception("您最多只能创建"+max_group+"个组");
		}
		grouperDAO.insert(grouper);
		return grouper;
	}

	@Override
	public void delGroup(long myId, long groupId,String msg) throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(myId).andPermissionEqualTo(GroupUser.PERMISSION_CREATER);
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您不是改组得创建者");
		}
		grouperDAO.deleteByPrimaryKey(groupId);
		gue.clear();
		gue.createCriteria().andGroupIdEqualTo(groupId);
		groupUserDAO.deleteByExample(gue);
		GroupDiscussionExample gde = new GroupDiscussionExample();
		gde.createCriteria().andGroupIdEqualTo(groupId);
		groupDiscussionDAO.deleteByExample(gde);
		GroupDiscussionPostExample gdpe = new GroupDiscussionPostExample();
		gdpe.createCriteria().andGroupDisIdEqualTo(groupId);
		groupDiscussionPostDAO.deleteByExample(gdpe);
		GroupWallExample gwe = new GroupWallExample();
		gwe.createCriteria().andGroupIdEqualTo(groupId);
		groupWallDAO.deleteByExample(gwe);
	}

	@Override
	public void removeUserFromGroup(long my_id,long userId, long groupId) throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(my_id);
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		if(gus.get(0).getPermission()==GroupUser.PERMISSION_ADMIN||gus.get(0).getPermission()==GroupUser.PERMISSION_CREATER){
			gue.clear();
			gue.createCriteria().andGroupIdEqualTo(groupId).andUserIdEqualTo(userId);
			groupUserDAO.deleteByExample(gue);
		}else{
			throw new Exception("您无权执行该操作");
		}
	}

}
