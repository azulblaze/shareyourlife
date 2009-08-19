package com.twitpic.services;


import com.twitpic.db.model.Messages;
import com.twitpic.domain.Account;
import com.twitpic.domain.MessagesInfo;

public interface MesssageService {
	
	public void sendToUser(Messages msg, Account from, Account to);
	
	public MessagesInfo loadUserMessagesInfo();

}
