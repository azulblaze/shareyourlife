package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.GroupDiscussionDAO;
import com.zhelazhela.db.dao.GroupDiscussionPostDAO;
import com.zhelazhela.db.dao.GroupUserDAO;
import com.zhelazhela.db.model.GroupDiscussion;
import com.zhelazhela.db.model.GroupDiscussionPost;
import com.zhelazhela.db.model.GroupUser;
import com.zhelazhela.db.model.GroupUserExample;
import com.zhelazhela.services.GroupDiscussionService;

public class GroupDiscussionServiceImpl implements GroupDiscussionService {

	private GroupUserDAO groupUserDAO;
	
	private GroupDiscussionDAO groupDiscussionDAO;
	
	private GroupDiscussionPostDAO groupDiscussionPostDAO;
	
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

	@Override
	public GroupDiscussion createDiscussion(GroupDiscussion gd)
			throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(gd.getGroupId()).andUserIdEqualTo(gd.getCreateUserId());
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		if(gus.get(0).getPermission()==GroupUser.PERMISSION_ADMIN||gus.get(0).getPermission()==GroupUser.PERMISSION_CREATER){
			groupDiscussionDAO.insert(gd);
			return gd;
		}else{
			throw new Exception("您无权执行该操作");
		}
	}

	@Override
	public boolean delDiscussion(long id) throws Exception {
		int row = groupDiscussionDAO.deleteByPrimaryKey(id);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delPost(long id,long groupid,long user_id)
			throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(groupid).andUserIdEqualTo(user_id);
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		if(gus.get(0).getPermission()==GroupUser.PERMISSION_ADMIN||gus.get(0).getPermission()==GroupUser.PERMISSION_CREATER){
			int row = groupDiscussionPostDAO.deleteByPrimaryKey(id);
			if(row>0){
				return true;
			}
			return false;
		}else{
			throw new Exception("您无权执行该操作");
		}
	}

	@Override
	public GroupDiscussion editDiscussion(GroupDiscussion gd) throws Exception {
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(gd.getGroupId()).andUserIdEqualTo(gd.getCreateUserId());
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		if(gus.get(0).getPermission()==GroupUser.PERMISSION_ADMIN||gus.get(0).getPermission()==GroupUser.PERMISSION_CREATER){
			GroupDiscussion record = groupDiscussionDAO.selectByPrimaryKey(gd.getId());
			if(record==null){
				throw new Exception("该主题已经不存在");
			}
			if(!record.getTopic().equals(gd.getTopic())){
				record.setUpdateTime(new java.util.Date());
				record.setTopic(gd.getTopic());
				groupDiscussionDAO.updateByPrimaryKey(record);
			}
			return record;
		}else{
			throw new Exception("您无权执行该操作");
		}
	}

	@Override
	public GroupDiscussionPost editPost(GroupDiscussionPost gdp, long myid)
			throws Exception {
		GroupDiscussion gd = groupDiscussionDAO.selectByPrimaryKey(gdp.getGroupDisId());
		if(gd==null){
			throw new Exception("该主题已经不存在");
		}
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(gd.getGroupId()).andUserIdEqualTo(gd.getCreateUserId());
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		if(gus.get(0).getPermission()==GroupUser.PERMISSION_ADMIN||gus.get(0).getPermission()==GroupUser.PERMISSION_CREATER){
			GroupDiscussionPost record = groupDiscussionPostDAO.selectByPrimaryKey(gdp.getId());
			if(record==null){
				throw new Exception("该回复已经不存在");
			}
			boolean update = false;
			if(!record.getContent().equals(gdp.getContent())){
				record.setContent(gdp.getContent());
				update = true;
			}
			if(!record.getStatus().equals(gdp.getStatus())){
				record.setStatus(gdp.getStatus());
				update = true;
			}
			if(update){
				record.setUpdateTime(new java.util.Date());
				groupDiscussionPostDAO.updateByPrimaryKeyWithBLOBs(record);
			}
			return record;
		}else{
			throw new Exception("您无权执行该操作");
		}
	}

	@Override
	public GroupDiscussionPost postDiscussion(GroupDiscussionPost gdp)
			throws Exception {
		GroupDiscussion gd = groupDiscussionDAO.selectByPrimaryKey(gdp.getGroupDisId());
		if(gd==null){
			throw new Exception("该主题已经不存在");
		}
		GroupUserExample gue = new GroupUserExample();
		gue.createCriteria().andGroupIdEqualTo(gd.getGroupId()).andUserIdEqualTo(gd.getCreateUserId());
		java.util.List<GroupUser> gus = groupUserDAO.selectByExample(gue);
		if(gus.size()==0){
			throw new Exception("该组不存在或者您无权执行该操作");
		}
		gdp.setUpdateTime(new java.util.Date());
		groupDiscussionPostDAO.insert(gdp);
		return gdp;
	}

}
