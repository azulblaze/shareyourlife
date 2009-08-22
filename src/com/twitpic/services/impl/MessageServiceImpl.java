package com.twitpic.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.twitpic.db.dao.MessageDAO;
import com.twitpic.db.model.Message;
import com.twitpic.db.model.MessageExample;
import com.twitpic.domain.Account;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.domain.MessagesInfo.MessageCategory;
import com.twitpic.domain.MessagesInfo.MessageStatus;
import com.twitpic.domain.MessagesInfo.MessageType;
import com.twitpic.services.MessageService;

public class MessageServiceImpl implements MessageService {
	
	private MessageDAO m_msg_dao;
	
	public void setMessageDAO(MessageDAO dao){
		this.m_msg_dao = dao;
	}

	@Override
	public List<Message> loadMessagesForListFromAccountPagable(
			String account, Integer page_index, Integer page_count)
			throws Exception {
		
		MessageExample example = new MessageExample();
		example.createCriteria().andToUserEqualTo(account);
		example.setOrderByClause("create_time desc");
		example.setLimit( (page_index-1) * page_count + "," + page_count );
		
		return this.m_msg_dao.selectByExampleWithoutBLOBs(example);
	}

	@Override
	public MessagesInfo loadMessagesInfoFromAccount(String account)
			throws Exception {
		
		MessagesInfo info = new MessagesInfo();
		info.setAccount(account);
		
		// 查询所有信息个数
		MessageExample example = new MessageExample();
		example.createCriteria().andToUserEqualTo(account);
		info.setMessagesCount( this.m_msg_dao.countByExample(example) );
		
		// 查询没有读取的信息个数
		example.clear();
		example.createCriteria().andToUserEqualTo(account)
								.andStatusEqualTo(MessagesInfo.MessageStatus.Unread.toString());
		info.setUnreadMessageCount( this.m_msg_dao.countByExample(example));
		
		return info;
	}

	@Override
	public List<Message> loadUnreadMessagesForListFromAccountPagable(
			String account, Integer page_index, Integer page_count)
			throws Exception {
		MessageExample example = new MessageExample();
		example.createCriteria().andToUserEqualTo(account)
								.andStatusEqualTo(MessagesInfo.MessageStatus.Unread.toString());
		example.setOrderByClause("create_time desc");
		example.setLimit( (page_index-1) * page_count + "," + page_count );
		
		return this.m_msg_dao.selectByExampleWithoutBLOBs(example);		
	}

	@Override
	public Message readMessage(String account, Long message_id)
			throws Exception {
		Message msg = this.m_msg_dao.selectByPrimaryKey( message_id );
		updateMessageStatus(message_id, MessagesInfo.MessageStatus.Read);
		return msg;
	}

	@Override
	public void removeMessage(String account, Long message_id)
			throws Exception {
		this.m_msg_dao.deleteByPrimaryKey(message_id);
	}

	@Override
	public void sendAdminMesssage(String title, String msg, String to) throws Exception {
		sendMessage(title, msg, MessagesInfo.MessageType.Site, MessagesInfo.MessageCategory.Admin, MessagesInfo.MessageCategory.Admin.toString(), to);
	}

	@Override
	public void sendSystemMesssage(String title, String msg, String to) throws Exception {
		sendMessage(title, msg, MessagesInfo.MessageType.Site, MessagesInfo.MessageCategory.System, MessagesInfo.MessageCategory.System.toString(), to);
	}

	@Override
	public void updateMessageStatus(Long msg_id, MessageStatus status)
			throws Exception {
		Message msg = new Message();
		msg.setStatus(status.toString());
		MessageExample example = new MessageExample();
		example.createCriteria().andIdEqualTo(msg_id);
		this.m_msg_dao.updateByExampleSelective(msg, example);
	}

	@Override
	public void sendMessage(
			String title, 
			String msg, 
			MessageType type,
			MessageCategory category, 
			String from_account, 
			String to_account)
			throws Exception {
		
		// 检查参数是否正确
		if( StringUtils.isEmpty(msg) 			||
			StringUtils.isEmpty(from_account) 	||
			StringUtils.isEmpty(to_account)  ){
			throw new IllegalArgumentException("发送信息所需的参数无效");
		}
		
		// 如果title没有输入,那么使用 '无'
		if(StringUtils.isEmpty(title))
			title = "无";
		
		// 创建新的message,并填充数据
		Message new_message = new Message();
		new_message.setTitle(title);
		new_message.setContent(msg);
		new_message.setFromUser(from_account);
		new_message.setToUser(to_account);
		new_message.setCreateTime(new Date());
		new_message.setUpdateTime(new Date());
		new_message.setType(type.toString());
		new_message.setCategory(category.toString());
		new_message.setStatus(MessagesInfo.MessageStatus.Unread.toString());
		
		this.m_msg_dao.insertSelective(new_message);
				
	}

}
