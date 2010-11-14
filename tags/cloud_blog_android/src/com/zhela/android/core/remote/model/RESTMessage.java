package com.zhela.android.core.remote.model;

public class RESTMessage {

	private RESTUser sender;
	private RESTUser receiver;
	private String title;
	private String content;
	private java.util.Date sendDate;
	private String displayDate;
	private int status;
	private long replyId;
	private String id;
	public RESTUser getSender() {
		return sender;
	}
	public void setSender(RESTUser sender) {
		this.sender = sender;
	}
	public RESTUser getReceiver() {
		return receiver;
	}
	public void setReceiver(RESTUser receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getDisplayDate() {
		return displayDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getReplyId() {
		return replyId;
	}
	public void setReplyId(long replyId) {
		this.replyId = replyId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}	
	
}
