package com.zhelazhela.cloudblog.domain;

public class MessageList extends BaseList {

	public MessageList(){
		super("messagelist");
	}
	
	private java.util.List<Message> messages;

	public java.util.List<Message> getMessages() {
		return messages;
	}

	public void setMessages(java.util.List<Message> messages) {
		this.messages = messages;
	}
	
}
