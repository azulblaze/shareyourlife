package com.twitpic.domain;

import com.twitpic.db.model.Users;
import com.twitpic.db.model.UsersProfile;

public class Account extends com.twitpic.db.model.BaseModel{
	
	private String account;
	
	private String name;
	
	private String picture;
	
	private Integer status;
	
	private java.util.Date regTime;
	
	private java.util.Date loginTime;
	
	private Integer theme;
	
	private String signature;
	
	private String self_introduction;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getRegTime() {
		return regTime;
	}

	public void setRegTime(java.util.Date regTime) {
		this.regTime = regTime;
	}

	public java.util.Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getTheme() {
		return theme;
	}

	public void setTheme(Integer theme) {
		this.theme = theme;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSelf_introduction() {
		return self_introduction;
	}

	public void setSelf_introduction(String selfIntroduction) {
		self_introduction = selfIntroduction;
	}
	
	public void setUsers(Users user){
		this.setAccount(user.getAccount());
		this.setName(user.getName());
		this.setRegTime(user.getRegTime());
		this.setStatus(user.getStatus());
	}
	
	public void setUsersProfile(UsersProfile up){
		this.setPicture(up.getPicture());
		this.setSelf_introduction(up.getSelfIntroduction());
		this.setLoginTime(up.getLoginTime());
		this.setSignature(up.getSignature());
		this.setTheme(up.getTheme());
	}
}
