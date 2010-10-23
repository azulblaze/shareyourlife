package com.zhela.cloudblog.tweet;

import org.junit.Test;

import com.zhela.cloudblog.AbstractTest;
import com.zhela.cloudblog.service.provider.ProviderService;
public class TweetTest extends AbstractTest {
	
	
	@Test
	public void testNewsInsert() throws Exception{
		ProviderService ps = (ProviderService)getBean("providerService");
		System.out.println(ps.selectAllProviders().size());
	}
	
}
