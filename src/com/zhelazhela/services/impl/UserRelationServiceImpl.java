package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.BlockUserDAO;
import com.zhelazhela.db.dao.FriendListDAO;
import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.model.BlockUserExample;
import com.zhelazhela.db.model.FriendList;
import com.zhelazhela.db.model.FriendListExample;
import com.zhelazhela.domain.form.AddFriend;
import com.zhelazhela.services.UserRelationService;

public class UserRelationServiceImpl implements UserRelationService {

	private FriendListDAO friendListDAO;
	
	private UserDAO userDAO;
	
	private BlockUserDAO blockUserDAO;
	
	public void setFriendListDAO(FriendListDAO friendListDAO) {
		this.friendListDAO = friendListDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBlockUserDAO(BlockUserDAO blockUserDAO) {
		this.blockUserDAO = blockUserDAO;
	}

	@Override
	public boolean addFriend(AddFriend af) throws Exception {
		// TODO Auto-generated method stub
		if(userDAO.selectByPrimaryKey(af.getD_user_id())!=null){
			BlockUserExample bue = new BlockUserExample();
			bue.createCriteria().andUserIdEqualTo(af.getD_user_id()).andBlockedUserIdEqualTo(af.getS_user_id());
			int size  = blockUserDAO.selectByExample(bue).size();
			if(size>0){
				throw new Exception("该用户不允许您关注他");
			}
			FriendListExample fle = new FriendListExample();
			fle.createCriteria().andUserIdEqualTo(af.getS_user_id()).andFriendIdEqualTo(af.getD_user_id());
			java.util.List<FriendList> fls = friendListDAO.selectByExample(fle);
			size = fls.size();
			if(size>0){
				FriendList fl = fls.get(0);
				if(fl.getStatus().equals(FriendList.STATUS_BLOCK)){
					throw new Exception("该用户不允许您关注他");
				}
				return true;
			}
			FriendList fl = new FriendList();
			fl.setUserId(af.getS_user_id());
			fl.setFriendId(af.getD_user_id());
			fl.setStatus(FriendList.STATUS_WAIT);
			fl.setUpdateTime(new java.util.Date());
			friendListDAO.insert(fl);
			return true;
		}
		throw new Exception("该用户不存在");
	}

	@Override
	public boolean blockFriend(AddFriend af) throws Exception {
		if(userDAO.selectByPrimaryKey(af.getD_user_id())!=null){
			FriendListExample fle = new FriendListExample();
			fle.createCriteria().andUserIdEqualTo(af.getS_user_id()).andFriendIdEqualTo(af.getD_user_id());
			java.util.List<FriendList> fls = friendListDAO.selectByExample(fle);
			if(fls.size()>0){
				FriendList fl = fls.get(0);
				fl.setStatus(FriendList.STATUS_BLOCK);
				fl.setUpdateTime(new java.util.Date());
				//应该给用户发送一条消息：某某用户拒绝您关注他
				if(!fl.getStatus().equals(FriendList.STATUS_BLOCK)){
					friendListDAO.updateByExample(fl, fle);
				}
				return true;
			}
			return false;
		}
		throw new Exception("该用户不存在");
	}
	
	

	@Override
	public boolean delFriend(AddFriend af) throws Exception {
		FriendListExample fle = new FriendListExample();
		fle.createCriteria().andUserIdEqualTo(af.getS_user_id()).andFriendIdEqualTo(af.getD_user_id());
		int row = friendListDAO.deleteByExample(fle);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean allowFriend(AddFriend af) throws Exception {
		FriendListExample fle = new FriendListExample();
		fle.createCriteria().andUserIdEqualTo(af.getS_user_id()).andFriendIdEqualTo(af.getD_user_id());
		java.util.List<FriendList> fls = friendListDAO.selectByExample(fle);
		if(fls.size()>0){
			FriendList fl = fls.get(0);
			fl.setStatus(FriendList.STATUS_SUCCESS);
			fl.setUpdateTime(new java.util.Date());
			//应该给用户发送一条消息：某某用户拒绝您关注他
			if(!fl.getStatus().equals(FriendList.STATUS_SUCCESS)){
				friendListDAO.updateByExample(fl, fle);
			}
			return true;
		}
		return false;
	}

}
