package com.zhelazhela.cloudblog.domain;

public class Result {
	
	public final static String SUCCESS  = "1";
	
	public final static String FAIL  = "0";
	
	public final static String NEEDLOGIN  = "2";
	
	private String code;
	
	private String description;
	/**
	 * 编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 详细描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 详细描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
