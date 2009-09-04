package com.twitpic.actions.m;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.twitpic.actions.BaseAction;
import com.twitpic.db.model.Message;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormMessages;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.services.AccountService;
import com.twitpic.services.MessageService;



public class MessageAction extends BaseAction {
	
	private static Logger LOGGER = Logger.getLogger(MessageAction.class);
	
	private MessageService m_message_service;
	private AccountService m_account_service;
	private FormMessages formMessages;
	private Integer msgListPageCount 			= 10;	// 默认为每一页10条
	private Integer unreadMsgListPageCount 		= 10;	// 默认为每一页10条
	
	public void setAccountService(AccountService _service){
		this.m_account_service = _service;
	}
	
	public void setMsgListPageCount(Integer msgListPageCount) {
		this.msgListPageCount = msgListPageCount;
	}

	public void setUnreadMsgListPageCount(Integer unreadMsgListPageCount) {
		this.unreadMsgListPageCount = unreadMsgListPageCount;
	}

	public void setFormMessages(FormMessages _form){
		this.formMessages = _form;
	}
	
	public FormMessages getFormMessages(){
		return this.formMessages;
	}

	public void setMessageService(MessageService _service){
		this.m_message_service = _service;
	}
	
	public String msg_list(){
		
		if(!isLogin()){
			this.addActionMessage("请先登录");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
		
		if (this.formMessages == null){
			this.formMessages = new FormMessages();
		}
		
		try {
			List<Message> msgs = this.m_message_service.loadMessagesForListFromAccountPagable(
					loadAccount().getAccount(), 
					this.formMessages.getMsgListPageIndex(), 
					this.msgListPageCount);
			this.setValue(ActionConstant.ARP_MESSAGE_LIST, msgs);
			
			// 计算总共页面数目
			Integer msg_count = this.m_message_service.loadMessagesForCountFromAccount(loadAccount().getAccount());
			Integer page = msg_count / this.msgListPageCount;
			if( msg_count % this.msgListPageCount != 0 )
				page++;
			this.setValue(ActionConstant.ARP_ITEM_TOTAL_COUNT, msg_count);
			this.setValue(ActionConstant.ARP_PAGE_COUNT, page);
			this.setValue(ActionConstant.ARP_PAGE_INDEX, this.formMessages.getMsgListPageIndex());
			
			this.loadUrlBack();
			
			return SUCCESS;
		} catch (Exception e) {
			LOGGER.error("获取用户消息列表出现异常", e);
			this.addActionMessage("获取用户消息列表出现异常");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}

	}
	
	public String unread_msg_list(){
		
		if(!isLogin()){
			this.addActionMessage("请先登录");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
		
		if (this.formMessages == null){
			this.formMessages = new FormMessages();
		}		
		
		try {
			List<Message> msgs = this.m_message_service.loadUnreadMessagesForListFromAccountPagable(
					loadAccount().getAccount(), 
					this.formMessages.getUnreadMsgListPageIndex(), 
					this.unreadMsgListPageCount);
			this.setValue(ActionConstant.ARP_MESSAGE_UNREAD_LIST, msgs);
			
			// 计算总共页面数目
			Integer msg_count = this.m_message_service.loadUnreadMessagesForCountFromAccount(loadAccount().getAccount());
			Integer page = msg_count / this.unreadMsgListPageCount;
			if( msg_count % this.unreadMsgListPageCount != 0 )
				page++;
			
			this.setValue(ActionConstant.ARP_ITEM_TOTAL_COUNT, msg_count);
			this.setValue(ActionConstant.ARP_PAGE_COUNT, page);
			this.setValue(ActionConstant.ARP_PAGE_INDEX, this.formMessages.getUnreadMsgListPageIndex());
		
			this.loadUrlBack();
			
			return SUCCESS;
		} catch (Exception e) {
			LOGGER.error("获取用户没读消息列表出现异常", e);
			this.addActionMessage("获取用户没读消息列表出现异常");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
	}
	
	public String detail(){
		if(!isLogin()){
			this.addActionMessage("请先登录");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
		
		if (this.formMessages == null ||
			this.formMessages.getSelectedMsgId() == null ){
			this.addActionMessage("消息参数错误");
			return ActionConstant.ACTION_RETURN_MSG_BOX;			
		}
		try {
			Message msg = this.m_message_service.readMessage(
					loadAccount().getAccount(), 
					this.formMessages.getSelectedMsgId());
			if( msg == null ){
				LOGGER.error("读消息失败");
				this.addActionMessage("读消息失败");
				return ActionConstant.ACTION_RETURN_MSG_BOX;
			}
			
			this.setValue("msg", msg);
			this.loadUrlBack();
			
			return SUCCESS;
		} catch (Exception e) {
			LOGGER.error("读消息出现异常", e);
			this.addActionMessage("读消息出现异常");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
	}
	
	public String delete() {
		
		if(!isLogin()){
			this.addActionMessage("请先登录");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
		
		if (this.formMessages == null ||
			this.formMessages.getSelectedMessageID() == null ){
			this.addActionMessage("消息参数错误");
			return ActionConstant.ACTION_RETURN_MSG_BOX;			
		}	
		
		try{
			this.m_message_service.removeMessagesByIDArray( loadAccount(), this.formMessages.getSelectedMessageID());
			this.addActionMessage("成功删除了["+this.formMessages.getSelectedMessageID().length+"]条消息");
		}catch(Exception ex){
			LOGGER.error("删除消息出现异常", ex);
			this.addActionMessage("删除消息出现异常");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		
		return SUCCESS;
	}
	
	public String send_msg(){
		
		if(!isLogin()){
			this.addActionMessage("请先登录");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}	
		
		if(!StringUtils.equalsIgnoreCase(
				this.getRequestParameter("submit"),
				"submit" ) ){
			String action = this.getRequestParameter("a");
			
			// 如果是回复,那么需要准备好 消息接收者和 标题
			if( StringUtils.equals(action, "reply")){
				try{
					Long msg_id = Long.valueOf(this.getRequestParameter("msgid"));
					Message msg = this.m_message_service.loadMessageById(msg_id);
					Account from_account = m_account_service.loadUserByAccount(msg.getFromUser());
					
					this.setValue("msg_receiver_account", from_account.getAccount());
					this.setValue("msg_receiver", from_account.getName());
					this.setValue("msg_title", "回复:"+msg.getTitle());
					
				}catch(Exception ex){
					LOGGER.error("回复信息出现异常",ex);
					this.addActionMessage("回复信息出现异常");
					return ActionConstant.ACTION_RETURN_MSG_BOX;
				}
			}
			return INPUT;
		}else{
			// 发送信息
			try {
				this.m_message_service.sendMessage( 
						this.formMessages.getTitle(), this.formMessages.getMsgContent(), 
						MessagesInfo.MessageType.Site, MessagesInfo.MessageCategory.User, 
						this.loadAccount().getAccount(), this.getRequestParameter("msg_receiver"));
				this.addActionMessage("信息发送成功");
				return ActionConstant.ACTION_RETURN_MSG_BOX;
			} catch (Exception ex) {
				LOGGER.error("回复信息出现异常",ex);
				this.addActionMessage("回复信息出现异常");
				return ActionConstant.ACTION_RETURN_MSG_BOX;
			}
		}
	}
}
