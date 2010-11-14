package com.zhela.android.core.net;


@SuppressWarnings("serial")
public class NetStatusException extends Exception {
	public NetStatusException() {
		super();
	}
	public NetStatusException(int code,String response) {
		super();
		this.code = code;
		this.response = response;
	}
	private int code;
	private String response;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
