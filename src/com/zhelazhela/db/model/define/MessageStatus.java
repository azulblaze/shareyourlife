package com.zhelazhela.db.model.define;

public class MessageStatus {

	/**
	 * 标记消息刚发送,还未被阅读
	 */
	public static final String SEND = "send";
	/**
	 * 标记消息已经被阅读过了
	 */
	public static final String READ = "read";
	/**
	 * 标记消息未读
	 */
	public static final String UNREAD = "unread";
	/**
	 * 标记消息被回复过了
	 */
	public static final String REPLY = "reply";
	/**
	 * 标记消息被处理过了(主要针对好友申请,组申请)
	 */
	public static final String DONE = "done";
}
