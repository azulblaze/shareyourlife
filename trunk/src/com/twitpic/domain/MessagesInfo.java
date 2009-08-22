package com.twitpic.domain;


public class MessagesInfo {
	
	private Integer 	messagesCount;
	private Integer 	unreadMessageCount;
	private String 		account;
	
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getMessagesCount() {
		return messagesCount;
	}

	public void setMessagesCount(Integer messagesCount) {
		this.messagesCount = messagesCount;
	}

	public Integer getUnreadMessageCount() {
		return unreadMessageCount;
	}

	public void setUnreadMessageCount(Integer unreadMessageCount) {
		this.unreadMessageCount = unreadMessageCount;
	}

	/**
	 * 信息状态
	 * @author sol
	 *
	 */
	public enum MessageStatus{
		Unread,		// 没有读
		Read		// 已读
	}
	
	/**
	 * 信息类型
	 * @author sol
	 *
	 */
	public enum MessageType{
		Sms,		// 短信息
		Mms,		// 彩信
		Email,		// 电子邮件
		Site		// 站内信息
	}
	
	/**
	 * 信息分类
	 * @author sol
	 *
	 */
	public enum MessageCategory{
		System,		//	 系统信息
		Admin,		//	管理员信息
		User		//	用户信息
	}

}
