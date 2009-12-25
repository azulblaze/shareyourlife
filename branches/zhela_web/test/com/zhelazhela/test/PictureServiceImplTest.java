package com.zhelazhela.test;


import java.text.DecimalFormat;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.ProgramInfoService;
import com.zhelazhela.services.UtilService;

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
		DiscountNewsService discountNewsService = (DiscountNewsService) this.m_context.getBean("discountNewsService");
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		System.out.println(calendar.getTime());
		DiscountNewsList dnl = discountNewsService.loadDiscountNewsList(1, 10, null, null, null, calendar.getTime(), "read_times desc");
		System.out.println(dnl.getList().size());
	}

	public static void main(String args[]){
		DecimalFormat df = new DecimalFormat("######0.0");
		System.out.println(df.format(3.14));
	}
}
