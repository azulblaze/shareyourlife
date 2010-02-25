package com.zhelazhela.domain;

public class UserPrivate {
	
	public static final int BLOCK_USER  = 1;
	
	private int private_level;
	
	private int private_type;
	
	private boolean valid;
	
	private String notice;

	public int getPrivate_level() {
		return private_level;
	}

	public void setPrivate_level(int privateLevel) {
		private_level = privateLevel;
	}

	public int getPrivate_type() {
		return private_type;
	}

	public void setPrivate_type(int privateType) {
		private_type = privateType;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	
	
}
