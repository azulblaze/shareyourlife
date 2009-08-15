package com.twitpic.services.impl;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twitpic.db.model.Comments;
import com.twitpic.db.model.Tags;
import com.twitpic.domain.PictureInfo;

public class MobilePictureServiceImplTest extends TestCase {

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

	public void testLoadCommentsLimitWitTopFromPicture() {
		
//		try{
//			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
//			PictureInfo pi = impl.loadPicture((long)2);
//			List<Comments> list = impl.loadCommentsLimitWitTopFromPicture(pi, 2);
//			
//			for (Comments comment : list) {
//				System.out.println(comment.getComment());
//			}
//			
//		}catch(Exception ex){
//			ex.printStackTrace();
//			this.assertFalse("测试失败, "+ex.getMessage(), true);
//		}
		
		for(int i=0; i<10; i++){
			System.out.println(""+i%3);
		}
		
		System.out.println("Over");
	}

	public void testLoadTagsLimitWitTopFromPicture() {
		try{
			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
			PictureInfo pi = impl.loadPicture((long)2);
			List<Tags> list = impl.loadTagsLimitWitTopFromPicture(pi, 2);
			
			for (Tags tag : list) {
				System.out.println(tag.getName());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.assertFalse("测试失败, "+ex.getMessage(), true);
		}
		
		System.out.println("Over");
	}

}
