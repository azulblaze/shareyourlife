package com.twitpic.services.impl;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.db.model.Message;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.services.MessageService;

public class MessageServiceImplTest extends TestCase {
	
	private ApplicationContext m_context =  null;

	protected void setUp() throws Exception {
		super.setUp();
		this.m_context = new ClassPathXmlApplicationContext(new String[]{
				"conf/spring/spring-db.xml", "conf/spring/spring-dao.xml", "conf/spring/spring-service.xml"
		});;		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetMessageDAO() {
		
	}

	public void testLoadMessagesForListFromAccountPagable() {
		
		MessageService service = (MessageService)this.m_context.getBean("messageService");
		try {
			List<Message> messages = service.loadMessagesForListFromAccountPagable("solzhang", 1, 10);
			for (Message message : messages) {
				System.out.println(message.getTitle()+" : "+message.getContent());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testLoadMessagesInfoFromAccount() {
		MessageService service = (MessageService)this.m_context.getBean("messageService");
		
		try {
			MessagesInfo info = service.loadMessagesInfoFromAccount("solzhang");
			System.out.println("Total Message Count : "+info.getMessagesCount());;
			System.out.println("Total Unread Message Count : " + info.getUnreadMessageCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testLoadUnreadMessagesForListFromAccountPagable() {
		MessageService service = (MessageService)this.m_context.getBean("messageService");
		try {
			List<Message> messages = service.loadUnreadMessagesForListFromAccountPagable("solzhang", 1, 10);
			for (Message message : messages) {
				System.out.println(message.getTitle()+" : "+message.getContent());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testReadMessage() {
		MessageService service = (MessageService)this.m_context.getBean("messageService");
		try {
			Message msg = service.readMessage("solzhang", 1L);
			System.out.println("message content : " + msg.getContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void testRemoveMessage() {
		
	}

	public void testSendAdminMesssage() {
		
	}

	public void testSendSystemMesssage() {
		
	}

	public void testUpdateMessageStatus() {
		
	}

	public void testSendMessage() {
		
		MessageService service = (MessageService)this.m_context.getBean("messageService");
		
		try {
			service.sendMessage(
					"test", "test", 
					MessagesInfo.MessageType.Site, 
					MessagesInfo.MessageCategory.User, "taro", "solzhang");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
