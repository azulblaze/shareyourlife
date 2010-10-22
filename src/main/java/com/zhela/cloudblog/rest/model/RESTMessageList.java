package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="messageList")
public class RESTMessageList {

	public final static int TYPE_ALL = 0;
	public final static int TYPE_INBOX = 1;
	public final static int TYPE_OUTBOX = 2;
	/**
	 * if inbox, the receiver will be null in messages, if outbox, the sender will be null in message
	 */
	private java.util.List<RESTMessage> messages;
	private long start;
	private int limit;
	private int size;
	private int type;
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
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
