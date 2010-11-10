package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="messageList")
@XmlType(propOrder={"size","messages"})
public class RESTMessageList {
	/**
	 * if inbox, the receiver will be null in messages, if outbox, the sender will be null in message
	 */
	private java.util.List<RESTMessage> messages;
	private int size;
	/**
	 * if inbox, the receiver will be null in messages, if outbox, the sender will be null in message
	 */
	@XmlElement(name="messages")
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
