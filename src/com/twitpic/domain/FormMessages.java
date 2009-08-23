package com.twitpic.domain;

public class FormMessages {
	
	private Integer msgListPageIndex 			= 1;
	private Integer unreadMsgListPageIndex		= 1;
	
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
