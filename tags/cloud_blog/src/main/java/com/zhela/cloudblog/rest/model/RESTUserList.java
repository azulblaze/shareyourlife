package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="userList")
@XmlType(propOrder={"size","nextCursor","previousCursor","users"})
public class RESTUserList {

	private java.util.List<RESTUser> users;
	private int size;
	private long nextCursor;
	private long previousCursor;
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
	public long getNextCursor() {
		return nextCursor;
	}
	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}
	public long getPreviousCursor() {
		return previousCursor;
	}
	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}
	
	
}
