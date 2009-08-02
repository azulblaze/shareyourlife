package com.twitpic.actions;

@SuppressWarnings("serial")
public class HomeAction extends BaseAction {
	
	public String index() throws Exception{
		return SUCCESS;
	}
	
	public String main() throws Exception{
		if(isLogin()){
			return SUCCESS;
		}
		return LOGIN;
	}
}
