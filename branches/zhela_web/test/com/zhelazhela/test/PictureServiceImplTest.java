package com.zhelazhela.test;


import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.ProgramInfoService;

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
		ProgramInfoService programInfoService = (ProgramInfoService) this.m_context.getBean("programInfoService");
		
		System.out.println(programInfoService.loadProgramInfo(1, 2, null).getList().size());
	}

}
