package com.zhelazhela.cloudblog.domain;

public class ToXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserList login = new UserList();
		login.setResult("1");
		login.addUser(new User());
		String xml = login.toXML();
		System.out.println(xml);
	}

}
