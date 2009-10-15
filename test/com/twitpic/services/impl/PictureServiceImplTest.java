package com.twitpic.services.impl;


import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.domain.Account;
import com.twitpic.services.PictureService;

public class PictureServiceImplTest extends TestCase {
	
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

	public void testLoadHomePic() throws Exception {
		PictureService service = (PictureService) this.m_context.getBean("pictureService");
		java.util.List<com.twitpic.domain.PictureInfo> pics = service.loadLatestPictures(0);
		System.out.println(pics.size());
	}
	/**
	public void testSavePicture() {
		
		PictureService service = (PictureService) this.m_context.getBean("pictureService");
		UsersDAO user_dao = (UsersDAO) this.m_context.getBean("usersDAO");
		Users user = user_dao.selectByPrimaryKey("solzhang");
		
		try {
			
			service.savePicture(user, "c:/", new File("c:/jason.jpg"), "jpg", "just test");
			
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("ERROR");
		}
	}
	**/
	
	public void testLoadCurrentActiveAccount(){
		PictureService service = (PictureService) this.m_context.getBean("pictureService");
		List<Account> accounts = service.load_current_active_accounts(10);
		for (Account account : accounts) {
			System.out.println(account.getPicture());
		}
	}
}
