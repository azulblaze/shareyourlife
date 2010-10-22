package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="userList")
public class RESTUserList {

	private java.util.List<RESTUser> users;
	private int size;
	public java.util.List<RESTUser> getUsers() {
		return users;
	}
	public void setUsers(java.util.List<RESTUser> users) {
		this.users = users;
		this.size = users.size();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
