package com.twitpic.services.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.services.TagService;

/**
 * <code>TagServiceImplTest.java</code>
 * @version 1.0, 2009-8-20
 */
public class TagServiceImplTest extends TestCase{
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
	
	public void testTags() throws Exception {
		TagService service = (TagService) this.m_context.getBean("tagService");
		java.util.List<com.twitpic.db.model.Tags> tags = service.load_month_tag(1, 10);
		System.out.println(tags.size());
		//System.out.println(tags.get(0).getName());
	}
}
