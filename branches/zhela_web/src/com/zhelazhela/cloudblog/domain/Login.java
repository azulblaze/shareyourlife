package com.zhelazhela.cloudblog.domain;
/**
 * 登录后返回的对象
 * @author chennyan
 *
 */
public class Login extends BaseBean {

	public Login(){
		super("login");
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
