package com.twitpic.domain;

import java.util.ArrayList;
import java.util.List;

import com.twitpic.db.model.Messages;

public class MessagesInfo {
	
	private List<Messages>	sysMessages;
	private List<Messages> 	userMessages;
	private List<Messages>	sysUnreadMesssages;
	private List<Messages>	userUnreadMessages;
	
	public Integer getSysMessagesCount(){
		return getSysMessages().size();
	}
	
	public Integer getUserMessagesCount(){
		return getUserUnreadMessages().size();
	}
	
	public Integer getSysUnreadMessagesCount(){
		return getSysUnreadMesssages().size();
	}
	
	public Integer getUserUnreadMessagesCount(){
		return getUserUnreadMessages().size();
	}
	
	public List<Messages> getSysMessages() {
		if( this.sysMessages == null )
			this.sysMessages = new ArrayList<Messages>();
		return sysMessages;
	}
	public void setSysMessages(List<Messages> sysMessages) {
		this.sysMessages = sysMessages;
	}
	public List<Messages> getUserMessages() {
		if( this.userMessages == null )
			this.userMessages = new ArrayList<Messages>();
		return userMessages;
	}
	public void setUserMessages(List<Messages> userMessages) {
		this.userMessages = userMessages;
	}
	public List<Messages> getSysUnreadMesssages() {
		if( this.sysUnreadMesssages == null )
			this.sysUnreadMesssages = new ArrayList<Messages>();		
		return sysUnreadMesssages;
	}
	public void setSysUnreadMesssages(List<Messages> sysUnreadMesssages) {
		this.sysUnreadMesssages = sysUnreadMesssages;
	}
	public List<Messages> getUserUnreadMessages() {
		if( this.userUnreadMessages == null )
			this.userUnreadMessages = new ArrayList<Messages>();			
		return userUnreadMessages;
	}
	public void setUserUnreadMessages(List<Messages> userUnreadMessages) {
		this.userUnreadMessages = userUnreadMessages;
	}
	
	
	

}
