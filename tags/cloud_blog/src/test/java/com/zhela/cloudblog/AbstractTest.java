package com.zhela.cloudblog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractTest {

	private static ApplicationContext applicationContext;
	
	static {
			String[] configs= {
					"context-dao.xml",
					"context-rest.xml",
					"context-service.xml",
					"context-transaction.xml"
				};
			applicationContext = new ClassPathXmlApplicationContext(configs);
		
	}
	
	
	protected Object getBean(String id){
		return applicationContext.getBean(id);
	}
	protected static Object getBeanStatic(String id){
		return applicationContext.getBean(id);
	}
}
	
