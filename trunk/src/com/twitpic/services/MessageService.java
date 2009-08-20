package com.twitpic.services;


import com.twitpic.db.model.Messages;
import com.twitpic.domain.Account;
import com.twitpic.domain.MessagesInfo;

public interface MessageService {
	
	/**
	 * 通用消息发送
	 * @param msg	 消息
	 * @param from	发送者
	 * @param to	接收者
	 */
	public void sendToUser(Messages msg, Account from, Account to) throws Exception ;
	
	
	/**
	 * 获取用户自己的消息信息
	 * @return
	 */
	public MessagesInfo loadUserMessagesInfo(Account account) throws Exception ;

	
	/**
	 * 设置信息状态
	 * @param messages
	 * @param status
	 */
	public void updateMessageStatus(Messages messages, MessagesInfo.MessageStatus status) throws Exception ;
	
}
