package com.twitpic.domain;

import java.util.ArrayList;
import java.util.List;

import com.twitpic.db.model.Messages;

public class MessagesInfo {
	
	private List<Messages>  	messages;
	private List<Messages> 		unreadMessages;

	public List<Messages> getMessages() {
		if( this.messages == null )
			this.messages = new ArrayList<Messages>();
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	
	
	public Integer getMessagesCount(){
		return getMessages().size();
	}

	public List<Messages> getUnreadMessages() {
		if( this.unreadMessages == null )
			this.unreadMessages = new ArrayList<Messages>();
		return unreadMessages;
	}

	public void setUnreadMessages(List<Messages> unreadMessages) {
		this.unreadMessages = unreadMessages;
	}
	
	public Integer getUnreadMessagesCount(){
		return getUnreadMessages().size();
	}
	
	
	

}
