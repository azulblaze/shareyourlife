package com.zhelazhela.services.impl;

import com.zhelazhela.db.dao.BlockUserDAO;
import com.zhelazhela.db.dao.FriendListDAO;
import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.dao.UserinfoDAO;
import com.zhelazhela.db.model.BlockUserExample;
import com.zhelazhela.db.model.FriendList;
import com.zhelazhela.db.model.FriendListExample;
import com.zhelazhela.db.model.UserPrivacy;
import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.domain.form.AddFriend;
import com.zhelazhela.services.UserMessageService;
import com.zhelazhela.services.UserPrivacyService;
import com.zhelazhela.services.UserRelationService;

public class UserRelationServiceImpl implements UserRelationService {

	private FriendListDAO friendListDAO;
	
	private UserDAO userDAO;
	
	private UserinfoDAO userinfoDAO;
	
	private BlockUserDAO blockUserDAO;
	
	private UserMessageService userMessageService;
	
	private UserPrivacyService userPrivacyService;
	
	private final static java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy年MM月DD日 HH:mm:ss");
	
	public void setFriendListDAO(FriendListDAO friendListDAO) {
		this.friendListDAO = friendListDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBlockUserDAO(BlockUserDAO blockUserDAO) {
		this.blockUserDAO = blockUserDAO;
	}

	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	public void setUserPrivacyService(UserPrivacyService userPrivacyService) {
		this.userPrivacyService = userPrivacyService;
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	
	@Override
	public int addFriend(AddFriend af) throws Exception {
		// TODO Auto-generated method stub
		if(userDAO.selectByPrimaryKey(af.getD_user_id())!=null){
			BlockUserExample bue = new BlockUserExample();
			bue.createCriteria().andUserIdEqualTo(af.getD_user_id()).andBlockedUserIdEqualTo(af.getS_user_id());
			int size  = blockUserDAO.selectByExample(bue).size();
			if(size>0){
				throw new Exception("该用户把您列入了黑名单，所以您不能关注他");
			}
			FriendListExample fle = new FriendListExample();
			fle.createCriteria().andUserIdEqualTo(af.getS_user_id()).andFriendIdEqualTo(af.getD_user_id());
			java.util.List<FriendList> fls = friendListDAO.selectByExample(fle);
			size = fls.size();
			if(size>0){
				FriendList fl = fls.get(0);
				if(fl.getStatus().equals(FriendList.STATUS_BLOCK)){
					throw new Exception("该用户不允许您关注他,您可以发消息告诉他您是谁.");
				}
				return -9;
			}
			UserPrivacy up = userPrivacyService.loadUserPrivacy(af.getD_user_id(), UserPrivacyService.TYPE_ALLOW_CARE);
			Userinfo ui = userinfoDAO.selectByPrimaryKey(af.getS_user_id());
			switch(up.getParameter1()){
			case UserPrivacyService.ALLOW_PRAMETER_USER:
				//允许直接关注
				FriendList fl = new FriendList();
				fl.setUserId(af.getS_user_id());
				fl.setFriendId(af.getD_user_id());
				fl.setStatus(FriendList.STATUS_SUCCESS);
				fl.setUpdateTime(new java.util.Date());
				friendListDAO.insert(fl);
				userMessageService.sendFriend(af.getS_user_id(), af.getD_user_id(), "用户["+ui.getName()+"]关注了您", "用户于 "+sdf.format(new java.util.Date())+" ["+ui.getName()+"]关注了您,您可以通过用户设置中的权限来设置是否被关注.");
				return -9;
			case UserPrivacyService.ALLOW_PRAMETER_APPLY:
				//send message to apply
				//userMessageService.sendCareApply(af.getS_user_id(), af.getD_user_id(), "用户["+ui.getName()+"]申请关注您", "用户于 "+sdf.format(new java.util.Date())+" ["+ui.getName()+"]申请关注您的状态,您可以通过用户设置中的权限来设置是否被关注.");
				return UserPrivacyService.ALLOW_PRAMETER_APPLY;
			case UserPrivacyService.ALLOW_PRAMETER_DENEY:
				//send message to tell source that can't be care
				//ui = userinfoDAO.selectByPrimaryKey(af.getD_user_id());
				//userMessageService.sendFriend(af.getD_user_id(), af.getS_user_id(), "用户["+ui.getName()+"]不允许被关注", "用户["+ui.getName()+"]通过设置拒绝被关注,您可以直接回复该消息告诉他您是谁.");
				return UserPrivacyService.ALLOW_PRAMETER_DENEY;
			default:
				throw new Exception("该用户的数据可能有错误");
			}			
		}
		throw new Exception("非常抱歉,发生错误,您不能关注该用户");
	}

	@Override
	public boolean blockFriend(AddFriend af) throws Exception {
		Userinfo ui = userinfoDAO.selectByPrimaryKey(af.getD_user_id());
		if(ui!=null){
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
			}else{
				FriendList fl = new FriendList();
				fl.setStatus(FriendList.STATUS_BLOCK);
				fl.setUpdateTime(new java.util.Date());
				fl.setUserId(af.getS_user_id());
				fl.setFriendId(af.getD_user_id());
				friendListDAO.insert(fl);
				
			}
			userMessageService.sendFriend(af.getD_user_id(), af.getS_user_id(), "用户["+ui.getName()+"]拒绝您关注他", "非常抱歉,您希望关注的用户["+ui.getName()+"]拒绝了您的请求,您可以直接回复该消息告诉您是谁.");
			return true;
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
		Userinfo ui = userinfoDAO.selectByPrimaryKey(af.getD_user_id());
		if(ui==null){
			throw new Exception("该用户不存在");
		}
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
		}else{
			FriendList fl = new FriendList();
			fl.setStatus(FriendList.STATUS_BLOCK);
			fl.setUpdateTime(new java.util.Date());
			fl.setUserId(af.getS_user_id());
			fl.setFriendId(af.getD_user_id());
			friendListDAO.insert(fl);
		}
		userMessageService.sendFriend(af.getD_user_id(), af.getS_user_id(), "用户["+ui.getName()+"]通过您关注他的请求", "恭喜您,您希望关注的用户["+ui.getName()+"]通过了您的请求,现在您可以看到他的状态了.");
		return true;
	}

}
