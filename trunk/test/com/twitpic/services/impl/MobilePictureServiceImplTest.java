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
		
		try{
			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
			PictureInfo pi = impl.loadPicture((long)2);
			List<Comments> list = impl.loadCommentsLimitWitTopFromPicture(pi, 2);
			
			for (Comments comment : list) {
				System.out.println(comment.getComment());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.assertFalse("测试失败, "+ex.getMessage(), true);
		}

		System.out.println("Over");
	}

	public void testLoadTagsLimitWitTopFromPicture() {
		try{
			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
			PictureInfo pi = impl.loadPicture((long)2);
			List<Tags> list = impl.loadTagsLimitWitTopFromPicture(pi, 2,"andy");
			
			for (Tags tag : list) {
				System.out.println(tag.getName());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.assertFalse("测试失败, "+ex.getMessage(), true);
		}
		
		System.out.println("Over");
	}

	public void testLoadMoreCommentsWithPagableFromPictureId(){
		try{
			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
			List<Comments> list = impl.loadMoreCommentsWithPagableFromPictureId((long)3, 1);
			
			for (Comments comment:list) {
				System.out.println(comment.getComment());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.assertFalse("测试失败, "+ex.getMessage(), true);
		}
		
		System.out.println("Over");
	}
	
	public void testLoadTagsWithPictureCountPagableFromAccount(){
		try{
			MobilePictureServiceImpl impl = (MobilePictureServiceImpl)m_context.getBean("mPictureService");
			List<Tags> list = impl.loadTagsWithPictureCountPagableFromAccount("solzhang", 0, 10);
			
			for (Tags tag:list) {
				System.out.println(tag.getName()+"("+tag.getPictureCount()+")");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.assertFalse("测试失败, "+ex.getMessage(), true);
		}
		
		System.out.println("Over");		
		
	}
}
