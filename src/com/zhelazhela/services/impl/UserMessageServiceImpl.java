package com.zhelazhela.services.impl;

import java.util.List;

import com.zhelazhela.db.dao.InboxMessageDAO;
import com.zhelazhela.db.dao.OutboxMessageDAO;
import com.zhelazhela.db.dao.UserDAO;
import com.zhelazhela.db.model.InboxMessage;
import com.zhelazhela.db.model.InboxMessageExample;
import com.zhelazhela.db.model.OutboxMessage;
import com.zhelazhela.db.model.OutboxMessageExample;
import com.zhelazhela.services.UserMessageService;

public class UserMessageServiceImpl implements UserMessageService {

	private InboxMessageDAO inboxMessageDAO;
	
	private OutboxMessageDAO outboxMessageDAO;
	
	private UserDAO userDAO;
	
	public void setInboxMessageDAO(InboxMessageDAO inboxMessageDAO) {
		this.inboxMessageDAO = inboxMessageDAO;
	}

	public void setOutboxMessageDAO(OutboxMessageDAO outboxMessageDAO) {
		this.outboxMessageDAO = outboxMessageDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
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
			int type, String status, String parameter, String message)
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
		om.setMessageStatus(OutboxMessage.STATUS_UNREAD);
		om.setMessageType(type);
		om.setSubject(subject);
		om.setToId(to);
		om.setUpdateTime(new java.util.Date());
		om.setUserId(from);
		
		inboxMessageDAO.insert(im);
		outboxMessageDAO.insert(om);
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
	public void sendAllUser() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendCareApply(long source, long dest, String content)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendFriend(long source, long dest, String content)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGroupApply(long source, long groupid, String content)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGroupInvition(long source, long groupid, long userId,
			String content) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGroupMembers(long userId, long groupId, String content)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sendUsers(List<Long> userIds) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
