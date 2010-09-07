package com.zhelazhela.cloudblog.action;

import java.util.HashMap;
import java.util.Map;


import com.zhelazhela.cloudblog.domain.Login;
import com.zhelazhela.cloudblog.services.UserService;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 4067991638401150992L;
	private String account;
	private String password;
	private String id;
	private String cursor;
	private String count;
	private UserService userService;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("account", account);
		param.put("password", password);
		Login login = userService.login(param);
		if(login.getResultCode().equals(com.zhelazhela.cloudblog.domain.Result.SUCCESS)){
			saveSession(PROVIDER_PRE+provider,com.zhelazhela.cloudblog.domain.Result.SUCCESS);
		}
		setValue(XML,login.toXML());
		return SUCCESS;
	}

	public String logout() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		setValue(XML,userService.logout(param).toXML());
		return SUCCESS;
	}
	
	public String track() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		setValue(XML,userService.track(param).toXML());
		return SUCCESS;
	}
	
	public String cancel() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		setValue(XML,userService.track(param).toXML());
		return SUCCESS;
	}
	
	public String follow() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		param.put("cursor", cursor);
		param.put("count", count);
		setValue(XML,userService.follow(param).toXML());
		return SUCCESS;
	}
	
	public String fans() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		param.put("cursor", cursor);
		param.put("count", count);
		setValue(XML,userService.follow(param).toXML());
		return SUCCESS;
	}
}
