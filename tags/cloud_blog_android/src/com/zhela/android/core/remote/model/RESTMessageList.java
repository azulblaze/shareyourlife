package com.zhela.android.core.remote.model;

public class RESTMessageList {
	private java.util.List<RESTMessage> messages;
	private int size;
	public java.util.List<RESTMessage> getMessages() {
		return messages;
	}
	public void setMessages(java.util.List<RESTMessage> messages) {
		this.messages = messages;
		this.size = messages.size();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
