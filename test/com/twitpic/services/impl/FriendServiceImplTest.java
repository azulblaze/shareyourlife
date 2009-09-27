package com.twitpic.services.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.domain.Account;
import com.twitpic.domain.FormLogin;
import com.twitpic.services.AccountService;
import com.twitpic.services.FriendService;

public class FriendServiceImplTest extends TestCase {
	
	private ApplicationContext m_context 		=  	null;
	private FriendService m_service				=	null;
	private AccountService	m_account_service	=	null;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.m_context = new ClassPathXmlApplicationContext(new String[]{
				"conf/spring/spring-db.xml", "conf/spring/spring-dao.xml", "conf/spring/spring-service.xml"
		});
		this.m_account_service 	= (AccountService)this.m_context.getBean("accountService");
		this.m_service 			= (FriendService) this.m_context.getBean("friendService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testApply_friendStringString() {
		
		try{
			FormLogin formLogin = new FormLogin();
			formLogin.setName("solzhang");
			formLogin.setPassword("111111");
			
			Account account = this.m_account_service.user_login(formLogin);
			
			this.m_service.apply_friend(account.getAccount(), "andy");
			
			System.out.println("success");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("over");
		
	}

	public void testApply_friendStringStringLong() {
		
	}

	public void testApply_friendStringStringString() {
		
	}

	public void testConfirm_friend() {
		
	}

	public void testReject_friend() {
		
	}

	public void testCreate_group() {
		
		try{
			FormLogin formLogin = new FormLogin();
			formLogin.setName("solzhang");
			formLogin.setPassword("111111");
			
			Account account = this.m_account_service.user_login(formLogin);
			this.m_service.create_group(account.getAccount(), "亲人");
			this.m_service.create_group(account.getAccount(), "同事");
			this.m_service.create_group(account.getAccount(), "同学");
			System.out.println("Over");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void testDelete_friend() {
		
		try{
			FormLogin formLogin = new FormLogin();
			formLogin.setName("solzhang");
			formLogin.setPassword("111111");
			
			Account account = this.m_account_service.user_login(formLogin);
			
			this.m_service.delete_friend(account.getAccount(),3L);
			
			System.out.println("success");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("over");
		

	}

	public void testDelete_group() {
		try{
			FormLogin formLogin = new FormLogin();
			formLogin.setName("solzhang");
			formLogin.setPassword("111111");
			
			Account account = this.m_account_service.user_login(formLogin);
			this.m_service.delete_group(account.getAccount(), 1L );
			this.m_service.delete_group(account.getAccount(), 2L);
			
			System.out.println("Over");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void testUpdate_group() {
		
	}

}
