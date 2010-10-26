package com.zhela.cloudblog.service.tweet.impl;

import java.util.Map;

import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.service.provider.ProviderService;
import com.zhela.cloudblog.service.tweet.TweetService;
import com.zhela.cloudblog.service.tweet.provider.ProviderTweetService;

public class TweetServiceImpl implements TweetService {

	@Override
	public RESTTweet selectTweet(long provider_id, String tweetId) throws Exception {
		Providers _provider = providerService.selectProviderByID(provider_id);
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return null;
	}

	@Override
	public RESTTweetList selectTweetByProvider(long provider_id, long start,
			int limit) throws Exception {
		Providers _provider = providerService.selectProviderByID(provider_id);
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return null;
	}

	@Override
	public Map<String, String> selectTweetAccount(long providerId,
			String username, String password) throws Exception {
		Providers _provider = providerService.selectProviderByID(providerId);
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.auth(username, password);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private ProviderService providerService;
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	private ProviderTweetService getProviderTweetService(String provider_code) throws Exception{
		try{
			Object o = Class.forName("com.zhela.cloudblog.service.tweet.provider.impl.ProviderTweetService"+provider_code).newInstance();
			ProviderTweetService service = (ProviderTweetService)o;
			return service;
		}catch(Exception e){
			throw new Exception("cannot support this provider");
		}
	}

}
