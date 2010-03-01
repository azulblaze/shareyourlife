package com.zhelazhela.services;

import com.zhelazhela.db.model.InboxMessage;
import com.zhelazhela.db.model.OutboxMessage;

public interface UserMessageService {

	public OutboxMessage sendMessage(long from,long to,String subject,int type,String status,String parameter,String message) throws Exception;
	
	public java.util.List<InboxMessage> loadInbox(long user_id,int page,int pagesize);
	
	public java.util.List<OutboxMessage> loadOutbox(long user_id,int page,int pagesize);
	
	public void delInbox(java.util.List<Long> ids);
	
	public void delOutbox(java.util.List<Long> ids);
	
	public void clearInbox(long user_id);
	
	public void clearOutbox(long user_id);
	
	public InboxMessage readInBoxMessage(long id);
	
	public OutboxMessage readOutBoxMessage(long id);
}
