package com.zhela.android.exception;

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

	public int getAction() {
		return action;
	}
	public String getMessage() {
		return message;
	}
	
}
