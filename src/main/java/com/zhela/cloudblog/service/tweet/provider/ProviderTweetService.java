package com.zhela.cloudblog.service.tweet.provider;

import java.util.Map;

import com.zhela.cloudblog.rest.model.RESTTweet;

public interface ProviderTweetService {

	public Map<String,String> auth(String name,String password) throws Exception;
	
	public RESTTweet getTweet(String id,String token,String tokenSecret,String tokenMore) throws Exception;
	
	
}
