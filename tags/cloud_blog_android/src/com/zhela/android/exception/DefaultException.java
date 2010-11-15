package com.zhela.android.exception;

import com.zhela.android.core.remote.model.RESTResponse;

@SuppressWarnings("serial")
public class DefaultException extends Exception {
	
	public final static int EXIT = -1;
	
	public final static int ERROR = 0;
	
	public final static int NEEDLOGIN = 1;
	
	public DefaultException(int action,String message){
		super(message);
		this.action =action;
		this.message = message;
	}

	private int action;
	private String message;
	private RESTResponse response;

	public int getAction() {
		return action;
	}
	public String getMessage() {
		return message;
	}
	public RESTResponse getResponse() {
		return response;
	}
	public void setResponse(RESTResponse response) {
		this.response = response;
	}
	
}
