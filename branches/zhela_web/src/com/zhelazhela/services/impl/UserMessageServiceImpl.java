package com.zhelazhela.services.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;


import com.zhelazhela.db.dao.GroupUserDAO;
import com.zhelazhela.db.dao.GrouperDAO;
import com.zhelazhela.db.dao.InboxMessageDAO;
import com.zhelazhela.db.dao.OutboxMessageDAO;
import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.dao.UserinfoDAO;
import com.zhelazhela.db.model.GroupUser;
import com.zhelazhela.db.model.GroupUserExample;
import com.zhelazhela.db.model.Grouper;
import com.zhelazhela.db.model.InboxMessage;
import com.zhelazhela.db.model.InboxMessageExample;
import com.zhelazhela.db.model.OutboxMessage;
import com.zhelazhela.db.model.OutboxMessageExample;
import com.zhelazhela.db.model.User;
import com.zhelazhela.db.model.UserExample;
import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.db.model.define.MessageStatus;
import com.zhelazhela.db.model.define.MessageType;
import com.zhelazhela.domain.form.AddFriend;
import com.zhelazhela.services.GroupService;
import com.zhelazhela.services.UserMessageService;
import com.zhelazhela.services.UserRelationService;

public class UserMessageServiceImpl implements UserMessageService {

	private InboxMessageDAO inboxMessageDAO;
	
	private OutboxMessageDAO outboxMessageDAO;
	
	private UserDAO userDAO;
	
	private UserinfoDAO userinfoDAO;
	
	private GrouperDAO grouperDAO;
	
	private GroupUserDAO groupUserDAO;
	
	private UserRelationService userRelationService;
	
	private GroupService groupService;
	
	public void setInboxMessageDAO(InboxMessageDAO inboxMessageDAO) {
		this.inboxMessageDAO = inboxMessageDAO;
	}

	public void setOutboxMessageDAO(OutboxMessageDAO outboxMessageDAO) {
		this.outboxMessageDAO = outboxMessageDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	public void setGrouperDAO(GrouperDAO grouperDAO) {
		this.grouperDAO = grouperDAO;
	}

	public void setGroupUserDAO(GroupUserDAO groupUserDAO) {
		this.groupUserDAO = groupUserDAO;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	public InboxMessage readInBoxMessage(long id) {
		return inboxMessageDAO.selectByPrimaryKey(id);
	}

	@Override
	public OutboxMessage readOutBoxMessage(long id) {
		return outboxMessageDAO.selectByPrimaryKey(id);
	}

	@Override
	public OutboxMessage sendMessage(long from, long to, String subject,
			int type, String status, String parameter, String message,boolean savesendbox)
			throws Exception {
		if(userDAO.selectByPrimaryKey(to)==null){
			throw new Exception("该用户不存在");
		}
		InboxMessage im = new InboxMessage();
		im.setFromId(from);
		im.setUserId(to);
		im.setIsDeleted(false);
		im.setMessage(message);
		im.setMessageType(type);
		im.setParameters(parameter);
		im.setSubject(subject);
		im.setUpdateTime(new java.util.Date());
		OutboxMessage om = new OutboxMessage();
		om.setIsDeleted(false);
		om.setMessage(message);
		om.setMessageStatus(MessageStatus.UNREAD);
		om.setMessageType(type);
		om.setSubject(subject);
		om.setToId(to);
		om.setUpdateTime(new java.util.Date());
		om.setUserId(from);
		inboxMessageDAO.insert(im);
		if(savesendbox){
			outboxMessageDAO.insert(om);
		}
		return om;
	}

	@Override
	public List<InboxMessage> loadInbox(long userId, int page, int pagesize) throws Exception {
		InboxMessageExample example = new InboxMessageExample();
		example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false);
		example.setOrderByClause("update_time asc");
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		return inboxMessageDAO.selectByExample(example);
	}

	@Override
	public List<OutboxMessage> loadOutbox(long userId, int page, int pagesize) throws Exception {
		OutboxMessageExample example = new OutboxMessageExample();
		example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false);
		example.setOrderByClause("update_time asc");
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		return outboxMessageDAO.selectByExample(example);
	}

	@Override
	public void clearInbox(long userId) throws Exception {
		InboxMessageExample example = new InboxMessageExample();
		example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false);
		InboxMessage record = new InboxMessage();
		record.setIsDeleted(true);
		record.setUpdateTime(new java.util.Date());
		inboxMessageDAO.updateByExampleSelective(record, example);
	}

	@Override
	public void clearOutbox(long userId) throws Exception {
		OutboxMessageExample example = new OutboxMessageExample();
		example.createCriteria().andUserIdEqualTo(userId).andIsDeletedEqualTo(false);
		OutboxMessage record = new OutboxMessage();
		record.setIsDeleted(true);
		record.setUpdateTime(new java.util.Date());
		outboxMessageDAO.updateByExampleSelective(record, example);
	}

	@Override
	public void delInbox(List<Long> ids) throws Exception {
		InboxMessageExample example = new InboxMessageExample();
		example.createCriteria().andIdIn(ids).andIsDeletedEqualTo(false);
		InboxMessage record = new InboxMessage();
		record.setIsDeleted(true);
		record.setUpdateTime(new java.util.Date());
		inboxMessageDAO.updateByExampleSelective(record, example);
		
	}

	@Override
	public void delOutbox(List<Long> ids) throws Exception {
		OutboxMessageExample example = new OutboxMessageExample();
		example.createCriteria().andIdIn(ids).andIsDeletedEqualTo(false);
		OutboxMessage record = new OutboxMessage();
		record.setIsDeleted(true);
		record.setUpdateTime(new java.util.Date());
		outboxMessageDAO.updateByExampleSelective(record, example);
	}

	@Override
	public void sendAllUser(String subject,String msg) throws Exception {
		new sendHugeMessage(inboxMessageDAO,outboxMessageDAO,userDAO,subject,msg).start();
	}

	@Override
	public void sendCareApply(long source, long dest,String subject, String content)
			throws Exception {
		if(StringUtils.isBlank(subject)){
			Userinfo u = userinfoDAO.selectByPrimaryKey(source);
			subject = "用户 "+u.getName()+" 希望关注您的状态";
		}
		sendMessage(source, dest, subject,
				MessageType.APPLY_CARE, MessageStatus.SEND, null, content,false);
	}

	@Override
	public void sendFriend(long source, long dest,String subject, String content)
			throws Exception {
		sendMessage(source, dest, subject,
				MessageType.GENERAL, MessageStatus.SEND, null, content,true);
	}

	@Override
	public void sendGroupApply(long source, long groupid,String subject, String content)
			throws Exception {
		Grouper g = grouperDAO.selectByPrimaryKey(groupid);
		if(g!=null){
			if(StringUtils.isBlank(subject)){
				Userinfo u = userinfoDAO.selectByPrimaryKey(source);
				subject = "用户 "+u.getName()+" 申请加入您的小组 "+g.getName();
			}
			GroupUserExample example = new GroupUserExample();
			java.util.List<Integer> admin_creater = new java.util.ArrayList<Integer>();
			admin_creater.add(GroupUser.PERMISSION_ADMIN);
			admin_creater.add(GroupUser.PERMISSION_CREATER);
			example.createCriteria().andGroupIdEqualTo(groupid).andPermissionIn(admin_creater);
			java.util.List<GroupUser> gus = groupUserDAO.selectByExample(example);
			java.util.List<Long> guIds = new java.util.ArrayList<Long>();
			for(GroupUser gu:gus){
				guIds.add(gu.getUserId());
			}
			sendUsers(guIds,source,subject,
					MessageType.APPLY_GROUP, MessageStatus.SEND, g.getId()+"", content,false);
		}
		throw new Exception("该组不存在或者已经解散");
	}

	@Override
	public void sendGroupInvition(long source, long groupid, List<Long> userIds,String subject,
			String content) throws Exception {
		Grouper g = grouperDAO.selectByPrimaryKey(groupid);
		if(g!=null){
			Userinfo u = userinfoDAO.selectByPrimaryKey(source);
			if(StringUtils.isBlank(subject)){
				subject = "用户 "+u.getName()+" 邀请您加入他所管理的小组 "+g.getName();
			}
			sendUsers(userIds,source,subject,
					MessageType.IVENT_GROUP, MessageStatus.SEND, groupid+"", content,false);
		}
		throw new Exception("该组不存在或者已经解散");
	}

	@Override
	public void sendGroupMembers(long userId, long groupId,String subject, String content)
			throws Exception {
		Grouper g = grouperDAO.selectByPrimaryKey(groupId);
		if(g!=null){
			GroupUserExample example = new GroupUserExample();
			example.createCriteria().andGroupIdEqualTo(groupId);
			java.util.List<GroupUser> gus = groupUserDAO.selectByExample(example);
			java.util.List<Long> guIds = new java.util.ArrayList<Long>();
			for(GroupUser gu:gus){
				guIds.add(gu.getUserId());
			}
			sendUsers(guIds,userId,subject,
					MessageType.GROUP_MSG, MessageStatus.SEND, g.getId()+"", content,false);
		}
		throw new Exception("该组不存在或者已经解散");
	}
	@Override
	public void sendUsers(List<Long> userIds,long source,String subject,
			int type, String status, String parameter, String message,boolean savesendbox) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andIdIn(userIds);
		java.util.List<User> users = userDAO.selectByExample(example);
		if(users.size()>0){
			for(User u:users){
				InboxMessage im = new InboxMessage();
				im.setFromId(source);
				im.setUserId(u.getId());
				im.setIsDeleted(false);
				im.setMessage(message);
				im.setMessageType(type);
				im.setParameters(parameter);
				im.setSubject(subject);
				im.setUpdateTime(new java.util.Date());
				inboxMessageDAO.insert(im);
			}
			
			OutboxMessage om = new OutboxMessage();
			om.setIsDeleted(false);
			om.setMessage(message);
			om.setMessageStatus(MessageStatus.UNREAD);
			om.setMessageType(type);
			om.setSubject(subject);
			om.setToId(-1l);
			om.setUpdateTime(new java.util.Date());
			om.setUserId(source);
			if(savesendbox){
				outboxMessageDAO.insert(om);
			}
		}else{
			throw new Exception("你要发送得用户均无效");
		}
	}
	
	@Override
	public boolean dealMessage(long msgId, long myId, int action)
			throws Exception {
		InboxMessage im = inboxMessageDAO.selectByPrimaryKey(myId);
		if(im==null){
			throw new Exception("该消息不存在或者已经被删除");
		}
		if(!im.getUserId().equals(myId)){
			throw new Exception("您不具有该消息的操作权限");
		}
		switch(im.getMessageType()){
		case MessageType.APPLY_CARE:
			return ApplyCareMessage(im,action);
		case MessageType.APPLY_GROUP:
			return ApplyGroupMessage(im,action);
		case MessageType.IVENT_GROUP:
			return IventGroupMessage(im,action);
		default:
			break;
		}
		return true;
	}

	/**
	 * 
	 * @param im
	 * @param action >0 ok; <0: block
	 * @return
	 * @throws Exception
	 */
	private boolean ApplyCareMessage(InboxMessage im,int action) throws Exception{
		AddFriend af = new AddFriend();
		af.setD_user_id(im.getFromId());
		af.setS_user_id(im.getUserId());
		af.setMsg(im.getMessage());
		if(action>0){
			return userRelationService.allowFriend(af);
		}else{
			return userRelationService.blockFriend(af);
		}
	}
	/**
	 * 
	 * @param im
	 * @param action >0 ok; <0: block
	 * @return
	 * @throws Exception
	 */
	private boolean ApplyGroupMessage(InboxMessage im,int action) throws Exception{
		Grouper g = grouperDAO.selectByPrimaryKey(Long.parseLong(im.getParameters()));
		if(action>0){
			GroupUser gu = groupService.addUserToGroup(im.getFromId(), Long.parseLong(im.getParameters()), null);
			if(gu!=null){
				sendFriend(im.getUserId(), im.getFromId(),"["+g.getName()+"]通过了您的加入小组申请", "您已经通过申请,加入了["+g.getName()+"]小组. 您现在可以在这个小组发言了.");
				return true;
			}
		}else{
			sendFriend(im.getUserId(), im.getFromId(),"["+g.getName()+"]拒绝了您的加入小组", "非常抱歉,小组["+g.getName()+"]拒绝了您的申请,您可以直接回复该消息,告诉管理员您是谁.");
		}
		return false;
	}
	
	/**
	 * 
	 * @param im
	 * @param action >0 ok; <0: block
	 * @return
	 * @throws Exception
	 */
	private boolean IventGroupMessage(InboxMessage im,int action) throws Exception{
		Userinfo ui = userinfoDAO.selectByPrimaryKey(im.getUserId());
		if(action>0){
			GroupUser gu = groupService.addUserToGroup(im.getUserId(), Long.parseLong(im.getParameters()), null);
			if(gu!=null){
				sendFriend(im.getFromId(), im.getUserId(),"["+ui.getName()+"]接受了申请加入了小组", "用户["+ui.getName()+"]接受了您的邀请,加入了小组.");
				return true;
			}
		}else{
			sendFriend(im.getFromId(), im.getUserId(),"["+ui.getName()+"]拒绝了您的小组邀请", "非常抱歉,用户["+ui.getName()+"]拒绝了您的邀请不想加入小组,您可以直接回复该消息,告诉他您是谁.");
		}
		return false;
	}
	
	class sendHugeMessage extends Thread{
		
		private InboxMessageDAO _inboxMessageDAO;
		
		private OutboxMessageDAO _outboxMessageDAO;
		
		private UserDAO _userDAO;
		
		private int pagesize = 100;
		
		private String msg;
		
		private String subject;
		
		public sendHugeMessage(InboxMessageDAO inboxMessageDAO,OutboxMessageDAO outboxMessageDAO,UserDAO userDAO,String subject,String msg){
			this._inboxMessageDAO = inboxMessageDAO;
			this._outboxMessageDAO = outboxMessageDAO;
			this._userDAO = userDAO;
			this.subject = subject;
			this.msg = msg;
		}
		public void run(){
			int size = _userDAO.countAllUser();
			if(size>0){
				int page = size/pagesize;
				int tmp = size%pagesize;
				if(tmp>0){
					page = page+1;
				}
				tmp = 0;
				for(;tmp<=page;tmp++){
					java.util.List<Long> userids = _userDAO.loadAllUserIdByPage(tmp+1, pagesize);
					for(Long userid:userids){
						InboxMessage im = new InboxMessage();
						im.setFromId(-999l);
						im.setUserId(userid);
						im.setIsDeleted(false);
						im.setMessage(msg);
						im.setMessageType(MessageType.SYSTEM);
						im.setParameters(null);
						im.setSubject(subject);
						im.setUpdateTime(new java.util.Date());
						_inboxMessageDAO.insert(im);
					}
				}
				OutboxMessage om = new OutboxMessage();
				om.setIsDeleted(false);
				om.setMessage(msg);
				om.setMessageStatus(MessageStatus.UNREAD);
				om.setMessageType(MessageType.SYSTEM);
				om.setSubject(subject);
				om.setToId(-1l);
				om.setUpdateTime(new java.util.Date());
				om.setUserId(-999l);
				_outboxMessageDAO.insert(om);
			}
		}
	}

}
