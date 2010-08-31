package com.zhelazhela.cloudblog.domain;

public class ToXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ACK login = new ACK();
		login.setResultCode("1");
		login.setResultDesc("Success");
		//login.addUser(new User());
		String xml = login.toXML();
		System.out.println(xml);
	}

}
