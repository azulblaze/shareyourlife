package com.twitpic.services;


import java.util.List;

import com.twitpic.db.model.Message;
import com.twitpic.domain.Account;
import com.twitpic.domain.MessagesInfo;

public interface MessageService {
	
	/**
	 * 发送信息
	 * @param title					信息标题
	 * @param msg					信息内容
	 * @param type					信息类型, 参考MessagesInfo.MessageType 
	 * @param category				信息分类, 参考MessagesInfo.MessageCategory
	 * @param from					信息发送者
	 * @param to					信息接收者
	 * @throws Exception
	 */
	public void sendMessage(
			String title, 
			String msg, 
			MessagesInfo.MessageType type, 
			MessagesInfo.MessageCategory category,
			String from_account, 
			String to_account) 
	throws Exception ;
	
	public void sendSystemMesssage(String title, String msg, String to) throws Exception;
	
	public void sendAdminMesssage(String title, String msg, String to) throws Exception;
	
	public MessagesInfo loadMessagesInfoFromAccount(String account) throws Exception ;
	
	public List<Message> loadMessagesForListFromAccountPagable(String account, Integer page_index, Integer page_count)throws Exception;
	
	public Integer loadMessagesForCountFromAccount(String account);
	
	public List<Message> loadUnreadMessagesForListFromAccountPagable(String account, Integer page_index, Integer page_count)throws Exception;

	public Integer loadUnreadMessagesForCountFromAccount(String account);
	
	public void updateMessageStatus(Long msg_id, MessagesInfo.MessageStatus status) throws Exception ;
	
	public Message readMessage(String account, Long message_id) throws Exception;
	
	public void removeMessage(String account, Long message_id) throws Exception;

	public void sendAddCommentMessage(Long id, String from, String to) throws Exception;

	public void removeMessagesByIDArray(Account loadAccount,String[] selectedMessageID) throws Exception;
}
