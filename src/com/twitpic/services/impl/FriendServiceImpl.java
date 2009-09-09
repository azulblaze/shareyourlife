package com.twitpic.services.impl;

import com.twitpic.db.model.Group;
import com.twitpic.db.model.GroupExample;
import com.twitpic.db.model.UsersGroup;
import com.twitpic.db.model.UsersGroupExample;
import com.twitpic.services.FriendService;

public class FriendServiceImpl implements FriendService {
	
	private com.twitpic.db.dao.GroupDAO groupDAO;
	
	private com.twitpic.db.dao.UsersDAO usersDAO;
	
	private com.twitpic.db.dao.UsersGroupDAO usersGroupDAO;

	public void setGroupDAO(com.twitpic.db.dao.GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public void setUsersDAO(com.twitpic.db.dao.UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void setUsersGroupDAO(com.twitpic.db.dao.UsersGroupDAO usersGroupDAO) {
		this.usersGroupDAO = usersGroupDAO;
	}
	
	@Override
	public Integer apply_friend(String account, String friend) throws Exception {
		UsersGroupExample example = new UsersGroupExample();
		example.createCriteria().andAccountEqualTo(friend).andSrcAccountEqualTo(account);
		java.util.List<UsersGroup> lists = usersGroupDAO.selectByExample(example);
		if(lists.size()>0){
			UsersGroup ug = lists.get(0);
			//if we found that the user relation is not confirmed and applied, we change to applied
			if(ug.getStatus()!=UsersGroup.STATUS_APPLY&&ug.getStatus()!=UsersGroup.STATUS_CONFIRM){
				ug.setStatus(UsersGroup.STATUS_APPLY);
				ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.updateByPrimaryKey(ug);
			}
			return ug.getStatus();
		}
		UsersGroup ug = new UsersGroup();
		ug.setSrcAccount(account);
		ug.setAccount(friend);
		ug.setIdGroups(null);
		ug.setStatus(UsersGroup.STATUS_APPLY);
		ug.setUpdateTime(new java.util.Date());
		ug.setId(usersGroupDAO.insert_return_id(ug));
		return UsersGroup.STATUS_APPLY;
	
	}
	
	@Override
	public Integer apply_friend(String account, String friend, Long idGroup)
			throws Exception {
		Group group = groupDAO.selectByPrimaryKey(idGroup);
		if(group==null||usersDAO.selectByPrimaryKey(friend)==null){
			throw new Exception("错误的请求");
		}
		UsersGroupExample example = new UsersGroupExample();
		example.createCriteria().andAccountEqualTo(friend).andIdGroupsEqualTo(idGroup);
		java.util.List<UsersGroup> lists = usersGroupDAO.selectByExample(example);
		if(lists.size()>0){
			UsersGroup ug = lists.get(0);
			//if we found that the user relation is not confirmed and applied, we change to applied
			if(ug.getStatus()!=UsersGroup.STATUS_APPLY&&ug.getStatus()!=UsersGroup.STATUS_CONFIRM){
				ug.setStatus(UsersGroup.STATUS_APPLY);
				ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.updateByPrimaryKey(ug);
			}
			return ug.getStatus();
		}
		UsersGroup ug = new UsersGroup();
		ug.setAccount(friend);
		ug.setSrcAccount(account);
		ug.setIdGroups(idGroup);
		ug.setStatus(UsersGroup.STATUS_APPLY);
		ug.setUpdateTime(new java.util.Date());
		ug.setId(usersGroupDAO.insert_return_id(ug));
		return UsersGroup.STATUS_APPLY;
	}

	@Override
	public Integer apply_friend(String account, String friend, String nameGroup)
			throws Exception {
		if(usersDAO.selectByPrimaryKey(friend)==null){
			throw new Exception("错误的请求");
		}
		GroupExample ge = new GroupExample();
		ge.createCriteria().andAccountEqualTo(account).andNameEqualTo(nameGroup);
		java.util.List<Group> groups = groupDAO.selectByExample(ge);
		Group group = null;
		if(groups.size()>0){
			group = groups.get(0);
			UsersGroupExample example = new UsersGroupExample();
			example.createCriteria().andAccountEqualTo(friend).andIdGroupsEqualTo(group.getId());
			java.util.List<UsersGroup> lists = usersGroupDAO.selectByExample(example);
			if(lists.size()>0){
				UsersGroup ug = lists.get(0);
				//if we found that the user relation is not confirmed and applied, we change to applied
				if(ug.getStatus()!=UsersGroup.STATUS_APPLY&&ug.getStatus()!=UsersGroup.STATUS_CONFIRM){
					ug.setStatus(UsersGroup.STATUS_APPLY);
					ug.setUpdateTime(new java.util.Date());
					usersGroupDAO.updateByPrimaryKey(ug);
				}
				return ug.getStatus();
			}
		}else{
			group = new Group();
			group.setAccount(account);
			group.setCreateTime(new java.util.Date());
			group.setName(nameGroup);
			group.setId(groupDAO.insert_return_id(group));
		}
		UsersGroup ug = new UsersGroup();
		ug.setSrcAccount(account);
		ug.setAccount(friend);
		ug.setIdGroups(group.getId());
		ug.setStatus(UsersGroup.STATUS_APPLY);
		ug.setUpdateTime(new java.util.Date());
		ug.setId(usersGroupDAO.insert_return_id(ug));
		return UsersGroup.STATUS_APPLY;
	}

	@Override
	public Integer confirm_friend(String account, Long id) throws Exception {
		UsersGroup ug = usersGroupDAO.selectByPrimaryKey(id);
		if(ug!=null&&ug.getAccount().equals(account)){
			if(ug.getStatus()==UsersGroup.STATUS_APPLY){
				ug.setStatus(UsersGroup.STATUS_CONFIRM);
				ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.updateByPrimaryKey(ug);
			}
			//if confirmed, we add the friend by each other
			UsersGroupExample uge = new UsersGroupExample();
			uge.createCriteria().andSrcAccountEqualTo(account).andAccountEqualTo(ug.getSrcAccount());
			java.util.List<UsersGroup> ugs = usersGroupDAO.selectByExample(uge);
			UsersGroup my_ug = null;
			if(ugs.size()>0){
				my_ug = ugs.get(0);
				my_ug.setStatus(UsersGroup.STATUS_CONFIRM);
				my_ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.updateByPrimaryKey(my_ug);
			}else{
				my_ug = new UsersGroup();
				my_ug.setSrcAccount(account);
				my_ug.setAccount(ug.getSrcAccount());
				my_ug.setIdGroups(null);
				my_ug.setStatus(UsersGroup.STATUS_CONFIRM);
				my_ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.insert(my_ug);
			}
			return ug.getStatus();
		}
		throw new Exception("错误的请求");
	}

	@Override
	public Integer reject_friend(String account, Long id) throws Exception {
		UsersGroup ug = usersGroupDAO.selectByPrimaryKey(id);
		if(ug==null){
			throw new Exception("错误的请求");
		}
		if(ug!=null&&ug.getAccount().equals(account)){
			//if the status is apply, set to reject
			if(ug.getStatus()==UsersGroup.STATUS_APPLY){
				ug.setStatus(UsersGroup.STATUS_REJECT);
				ug.setUpdateTime(new java.util.Date());
				usersGroupDAO.updateByPrimaryKey(ug);
			}
			return ug.getStatus();
		}
		throw new Exception("错误的请求");
	}
	
	@Override
	public Group create_group(String account, String name) throws Exception {
		GroupExample example = new GroupExample();
		example.createCriteria().andAccountEqualTo(account).andNameEqualTo(name);
		java.util.List<Group> groups = groupDAO.selectByExample(example);
		if(groups.size()>0){
			throw new Exception("不能创建重复的名字");
		}
		Group group = new Group();
		group.setAccount(account);
		group.setName(name);
		group.setCreateTime(new java.util.Date());
		group.setId(groupDAO.insert_return_id(group));
		return group;
	}

	@Override
	public boolean delete_friend(String account, Long id) throws Exception {
		UsersGroup ug = usersGroupDAO.selectByPrimaryKey(id);
		if(ug==null){
			return false;
		}
		if(ug!=null&&ug.getSrcAccount().equals(account)){
			usersGroupDAO.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete_group(String account, Long id) throws Exception {
		Group group = groupDAO.selectByPrimaryKey(id);
		if(group!=null){
			UsersGroupExample example = new UsersGroupExample();
			example.createCriteria().andIdGroupsEqualTo(id);
			usersGroupDAO.deleteByExample(example);
			groupDAO.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public Group update_group(String account, Long id, String name)
			throws Exception {
		Group group = groupDAO.selectByPrimaryKey(id);
		if(group==null){
			throw new Exception("错误的请求");
		}
		if(group.getName().equals(name)){
			return group;
		}
		GroupExample example = new GroupExample();
		example.createCriteria().andAccountEqualTo(account).andNameEqualTo(name);
		java.util.List<Group> groups = groupDAO.selectByExample(example);
		if(groups.size()>0){
			throw new Exception("不能创建重复的名字");
		}
		group.setName(name);
		group.setCreateTime(new java.util.Date());
		groupDAO.updateByPrimaryKeySelective(group);
		return group;
	}


}
