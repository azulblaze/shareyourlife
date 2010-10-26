package com.zhela.cloudblog.service.tweet;

import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;

public interface TweetService {

	RESTTweetList selectTweetByProvider(long provider_id,long start,int limit) throws Exception;
	
	RESTTweet selectTweet(long provider_id,String tweetId) throws Exception;
	
	java.util.Map<String,String> selectTweetAccount(long provider_id,String username,String password) throws Exception;
}
