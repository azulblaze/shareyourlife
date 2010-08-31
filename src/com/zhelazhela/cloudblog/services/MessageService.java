package com.zhelazhela.cloudblog.services;

import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.domain.MessageList;
import com.zhelazhela.cloudblog.domain.MessageResult;

public interface MessageService {
	/**
	 * 发送消息
	 * message/send
	 * POST
	 * id:用户ID
	 * text:
	 * @param parameters
	 * @return
	 */
	public MessageResult sendmsg(java.util.Map<String,String> parameters);
	
	/**
	 * message/inbox
	 * GET
	 * count:数量
	 * max_id:可选参数，返回小于max_id的微薄
	 * min_id:可选参数，返回大于min_id的微薄
	 * max_id和min_id同时只能有一个有效
	 * @param parameters
	 * @return
	 */
	public MessageList inbox(java.util.Map<String,String> parameters);
	
	/**
	 * message/outbox
	 * GET
	 * count:数量
	 * max_id:可选参数，返回小于max_id的微薄
	 * min_id:可选参数，返回大于min_id的微薄
	 * max_id和min_id同时只能有一个有效
	 * @param parameters
	 * @return
	 */
	public MessageList outbox(java.util.Map<String,String> parameters);
	
	/**
	 * message/del
	 * GET
	 * id:要删除的消息ID
	 * @param parameters
	 * @return
	 */
	public ACK del(java.util.Map<String,String> parameters);
}
