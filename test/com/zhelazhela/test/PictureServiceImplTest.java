package com.zhelazhela.test;


import java.text.DecimalFormat;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhelazhela.db.dao.DiscountNewsDAO;
import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.db.model.DiscountNewsExample;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.ProgramInfoService;
import com.zhelazhela.services.UtilService;

public class PictureServiceImplTest extends TestCase {
	
	private ApplicationContext m_context =  null;

	protected void setUp() throws Exception {
		super.setUp();
		Logger.getInstance("log4j.properties");
		this.m_context = new ClassPathXmlApplicationContext(new String[]{
				"conf/spring/spring-db.xml", "conf/spring/spring-dao.xml", "conf/spring/spring-service.xml"
		});;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoadNewsList() throws Exception {
		UtilService utilService = (UtilService) this.m_context.getBean("utilService");
		java.util.List<String> list =  new java.util.ArrayList<String>(utilService.loadCategorys("dd"));
		list = new java.util.ArrayList<String>(utilService.loadAreas("a,b,c"));
		System.out.println(list.toString());
	}

	public static void main(String args[]){
		DecimalFormat df = new DecimalFormat("######0.0");
		System.out.println(df.format(3.14));
	}
}
