package com.zhelazhela.test;


import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhelazhela.services.DiscountNewsService;

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

	public void testLoadNewsList() throws Exception {
		DiscountNewsService service = (DiscountNewsService) this.m_context.getBean("discountNewsService");
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		service.loadDiscountNewsList(1, 10, map);
		System.out.println(pics.size());
	}

}
