package com.zhelazhela.services;

import com.zhelazhela.db.model.InboxMessage;
import com.zhelazhela.db.model.OutboxMessage;

public interface UserMessageService {

	/**
	 * 基本的发送消息方法
	 * @param from
	 * @param to
	 * @param subject
	 * @param type
	 * @param status
	 * @param parameter
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public OutboxMessage sendMessage(long from,long to,String subject,int type,String status,String parameter,String message) throws Exception;
	/**
	 * 获取用户收件箱的消息
	 * @param user_id
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public java.util.List<InboxMessage> loadInbox(long user_id,int page,int pagesize) throws Exception;
	/**
	 * 获取用户发件箱的消息
	 * @param user_id
	 * @param page
	 * @param pagesize
	 * @return
	 * @throws Exception
	 */
	public java.util.List<OutboxMessage> loadOutbox(long user_id,int page,int pagesize) throws Exception;
	/**
	 * 删除收件箱中选种的消息
	 * @param ids
	 * @throws Exception
	 */
	public void delInbox(java.util.List<Long> ids) throws Exception;
	/**
	 * 删除发件箱中选种的消息
	 * @param ids
	 * @throws Exception
	 */
	public void delOutbox(java.util.List<Long> ids) throws Exception;
	/**
	 * 清空收件箱
	 * @param user_id
	 * @throws Exception
	 */
	public void clearInbox(long user_id) throws Exception;
	/**
	 * 清空发件箱
	 * @param user_id
	 * @throws Exception
	 */
	public void clearOutbox(long user_id) throws Exception;
	/**
	 * 读取收件箱中的详细消息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public InboxMessage readInBoxMessage(long id) throws Exception;
	/**
	 * 读取发件箱中的详细消息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public OutboxMessage readOutBoxMessage(long id) throws Exception;
	
	/**
	 * 给所有用户发送消息
	 * @throws Exception
	 */
	public void sendAllUser() throws Exception;
	/**
	 * 给指定的用户发送消息
	 * @param user_ids
	 * @throws Exception
	 */
	public void sendUsers(java.util.List<Long> user_ids) throws Exception;
	/**
	 * 用户对用户发送消息
	 * @param source
	 * @param dest
	 * @param content
	 * @throws Exception
	 */
	public void sendFriend(long source,long dest,String content) throws Exception;
	
	/**
	 * 管理员给组用户发送信息
	 * @param user_id
	 * @param group_id
	 * @param content
	 * @throws Exception
	 */
	public void sendGroupMembers(long user_id,long group_id,String content) throws Exception;
	/**
	 * 用户关注用户的时候有时候需要发送信息申请通过
	 * @param source
	 * @param dest
	 * @param content
	 * @throws Exception
	 */
	public void sendCareApply(long source,long dest,String content) throws Exception;
	
	/**
	 * 用户申请加入组
	 * @param source
	 * @param groupid
	 * @param content
	 * @throws Exception
	 */
	public void sendGroupApply(long source,long groupid,String content) throws Exception;
	/**
	 * 用户发送组加入邀请
	 * @param source
	 * @param groupid
	 * @param user_id
	 * @param content
	 * @throws Exception
	 */
	public void sendGroupInvition(long source,long groupid,long user_id,String content) throws Exception;
}
