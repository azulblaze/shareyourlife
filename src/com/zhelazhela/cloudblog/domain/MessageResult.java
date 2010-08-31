package com.zhelazhela.cloudblog.domain;

public class MessageResult extends BaseBean {

	public MessageResult(){
		super("messageresult");
	}
	
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
}
