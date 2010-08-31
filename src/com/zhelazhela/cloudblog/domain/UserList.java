package com.zhelazhela.cloudblog.domain;

public class UserList extends BaseBean {

	public UserList(){
		super("userlist");
	}
	private String cursor = "0";
	public java.util.List<User> users;

	public java.util.List<User> getUsers() {
		return users;
	}

	public void setUsers(java.util.List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user){
		if(users==null){
			users = new java.util.ArrayList<User>();
		}
		users.add(user);
	}
	
	public void removeUser(User user){
		if(users!=null){
			users.remove(users);
		}
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	
}
