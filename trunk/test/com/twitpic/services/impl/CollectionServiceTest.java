package com.twitpic.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.db.model.Collection;
import com.twitpic.services.CollectionService;

import junit.framework.TestCase;

public class CollectionServiceTest extends TestCase {
	private ApplicationContext m_context =  null;
	
	private CollectionService collectionService;

	protected void setUp() throws Exception {
		super.setUp();
		this.m_context = new ClassPathXmlApplicationContext(new String[]{
				"conf/spring/spring-db.xml", "conf/spring/spring-dao.xml", "conf/spring/spring-service.xml"
		});;
		collectionService = (CollectionService)this.m_context.getBean("collectionService");
	}

	public void testBindCollection()throws Exception{
		System.out.println(collectionService.bind_collection("sol", 4l, 4l));
	}


	public void testCreateCollection() throws Exception{
		Collection collection = new Collection();
		collection.setName("美女");
		collection.setDescription("漂亮得美女哦");
		collectionService.create_collection("sol", collection);
	}
	
}
