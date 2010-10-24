package com.zhela.cloudblog.service.tweet.impl;

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
		return null;
	}
	
	
	private ProviderService providerService;
	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
	

	private ProviderTweetService getProviderTweetService(String provider_code) throws ClassNotFoundException{
		Object o = Class.forName("ProviderTweetService"+provider_code);
		ProviderTweetService service = (ProviderTweetService)o; 
		return service;
	}
}
