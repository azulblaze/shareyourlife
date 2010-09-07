package com.zhelazhela.test;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.services.Maintenance;
import com.zhelazhela.db.dao.DiscountNewsDAO;
import com.zhelazhela.db.dao.GoodsCommentDAO;
import com.zhelazhela.db.dao.GoodsPriceDAO;
import com.zhelazhela.db.dao.GoodsTagDAO;
import com.zhelazhela.db.dao.GoodsTrackDAO;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.db.model.DiscountNewsExample;
import com.zhelazhela.db.model.GoodsTag;
import com.zhelazhela.db.model.GoodsTagExample;
import com.zhelazhela.db.model.Tags;
import com.zhelazhela.db.model.define.UserComment;
import com.zhelazhela.db.model.define.UserGoods;
import com.zhelazhela.db.model.define.UserPrice;
import com.zhelazhela.domain.BlogDetailList;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.domain.Mail;
import com.zhelazhela.services.BlogService;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.ProgramInfoService;
import com.zhelazhela.services.UserPrivacyService;
import com.zhelazhela.services.UtilService;
import com.zhelazhela.system.email.MailServices;

public class PictureServiceImplTest extends TestCase {
	
	private ApplicationContext m_context =  null;

	protected void setUp() throws Exception {
		super.setUp();
		//Logger.getInstance("log4j.properties");
		this.m_context = new ClassPathXmlApplicationContext(new String[]{
				"conf/spring/spring-db.xml", "conf/spring/spring-dao.xml", "conf/spring/spring-service.xml"
		});;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoadNewsList() throws Exception {
		//BlogService blogService = (BlogService) this.m_context.getBean("blogService");
		//java.util.List<Tags> list = blogService.loadTopTags(6);
		//System.out.println(list.size());
		//System.out.println(list.get(0).getName()+list.get(0).getCount());
	}
	
	public void testBlog() throws Exception {
		//BlogService blogService = (BlogService) this.m_context.getBean("blogService");
		//BlogDetailList bdl = blogSeqrvice.loadList(1, 2, null, null, null, true, null);
		//System.out.println(bdl.getList().size());
	}
	
	public void testSendMail() throws Exception{
		Maintenance maintenance = (Maintenance) this.m_context.getBean("maintenance");
		Map<String,String> param = new HashMap<String,String>();
		param.put("appkey", "846676903732584882l");
		param.put("serialid", "24dc18324efc92605acf14d78ae94b5b");
		ACK ack = maintenance.getSerialID(param);
		System.out.println(ack.toXML());
		param.put("enc_serialid", "eac1c0465bddb2a2426fda8e3dbadd30");
		param.put("serialid", ack.getResultDesc());
		System.out.println(maintenance.checkSerialID(param).toXML());
	}

	public static void main(String args[]) throws Exception{
		//DecimalFormat df = new DecimalFormat("######0.0");
		//System.out.println(df.format(3.14));
		PictureServiceImplTest t = new PictureServiceImplTest();
		t.setUp();
		t.testSendMail();
	}
}
