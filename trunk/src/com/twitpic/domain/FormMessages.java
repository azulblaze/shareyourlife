package com.twitpic.domain;

public class FormMessages {
	
	private Integer msgListPageIndex 			= 1;
	private Integer unreadMsgListPageIndex		= 1;
	private Long selectedMsgId					= null;
	private String[] selectedMessageID			= null;
	
	private String receiver						= null;
	private String title						= null;
	private String msgContent					= null;
	
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String[] getSelectedMessageID() {
		return selectedMessageID;
	}
	public void setSelectedMessageID(String[] selectedMessageID) {
		this.selectedMessageID = selectedMessageID;
	}
	public Long getSelectedMsgId() {
		return selectedMsgId;
	}
	public void setSelectedMsgId(Long selectedMsgId) {
		this.selectedMsgId = selectedMsgId;
	}
	public Integer getMsgListPageIndex() {
		return msgListPageIndex;
	}
	public void setMsgListPageIndex(Integer _msgListPageIndex) {
		if( _msgListPageIndex < 1 )
			_msgListPageIndex = 1;
		this.msgListPageIndex = _msgListPageIndex;
	}
	public Integer getUnreadMsgListPageIndex() {
		return unreadMsgListPageIndex;
	}
	public void setUnreadMsgListPageIndex(Integer _unreadMsgListPageIndex) {
		if( _unreadMsgListPageIndex < 1 ){
			_unreadMsgListPageIndex = 1;
		}
		this.unreadMsgListPageIndex = _unreadMsgListPageIndex;
	}

}
