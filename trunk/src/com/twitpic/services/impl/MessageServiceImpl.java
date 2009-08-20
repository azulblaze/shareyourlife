package com.twitpic.services.impl;

import com.twitpic.db.dao.MessagesDAO;
import com.twitpic.db.model.Messages;
import com.twitpic.domain.Account;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.domain.MessagesInfo.MessageStatus;
import com.twitpic.services.MessageService;

public class MessageServiceImpl implements MessageService {
	
	private MessagesDAO m_msg_dao;
	
	public void setMessagesDAO(MessagesDAO dao){
		this.m_msg_dao = dao;
	}

	@Override
	public MessagesInfo loadUserMessagesInfo(Account account)throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendToUser(Messages msg, Account from, Account to) throws Exception{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessageStatus(Messages messages, MessageStatus status) throws Exception{
		// TODO Auto-generated method stub

	}

}
