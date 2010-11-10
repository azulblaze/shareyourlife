package com.zhela.cloudblog.service.tweet.impl;

import java.io.File;
import java.util.Map;

import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.rest.model.RESTComment;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTCount;
import com.zhela.cloudblog.rest.model.RESTMessage;
import com.zhela.cloudblog.rest.model.RESTMessageList;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.rest.model.RESTUser;
import com.zhela.cloudblog.rest.model.RESTUserList;
import com.zhela.cloudblog.service.provider.ProviderService;
import com.zhela.cloudblog.service.tweet.TweetService;
import com.zhela.cloudblog.service.tweet.provider.ProviderTweetService;

public class TweetServiceImpl implements TweetService {

	@Override
	public RESTTweet selectTweet(String tweetId,ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		RESTTweet tweet = service.getTweet(null, null, tweetId, userconfig.getToken(), userconfig.getTokenSecret(), userconfig.getTokenMore());
		tweet.setComments(service.getTweetComment(null, tweetId, 20, 1,userconfig.getToken(), userconfig.getTokenSecret(), userconfig.getTokenMore()));
		return tweet;
	}

	@Override
	public RESTTweetList selectHomeTweetByProvider(long position,int direction,int size,ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getHomeTimeline(position, direction, size,userconfig.getToken(), userconfig.getTokenSecret(), userconfig.getTokenMore());
	}
	
	@Override
	public RESTTweetList selectUserTweetByProvider(String userId,long position,int direction,int size,ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getUserTimeline(userId,position, direction, size,userconfig.getToken(), userconfig.getTokenSecret(), userconfig.getTokenMore());
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


	@Override
	public RESTComment commentTweet(String id, String commentId, String text,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.commentTweet(id, commentId,text,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public boolean delMessage(String id, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.delMessage(id,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public boolean deleteTweet(String id, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.destoryTweet(id,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public boolean deleteTweetComment(String commentId, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.destoryTweetComment(commentId,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public boolean followUser(String id, boolean follow, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.follow(id, follow,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTUserList getFirends(String userId,long position, int size,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		if(userId==null){
			userId = userconfig.getProviderUserid();
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getFirends(userId, position, size, userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTUserList getFollows(String userId,long position, int size,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		if(userId==null){
			userId = userconfig.getProviderUserid();
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getFollows(userId, position, size,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTTweetList getMentions(long position, int direction, int size,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getMentions(position, direction, size,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTMessageList getMessageInbox(long position, int size,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getMessageInbox(position,size,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTMessageList getMessageOutbox(long position, int size,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getMessageOutbox(position, size,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTCommentList getTweetComment(String id,int size, int position,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getTweetComment(null, id,size,position, userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTCount getUnread(ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getUnread(userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTTweet publishTweet(String text, ProviderUser userconfig,
			File file) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.publishTweet(text,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore(),file);
	}

	@Override
	public RESTTweet publishTweet(String text, ProviderUser userconfig,
			Double latitude, Double longitude, Long replyTweetId)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.publishTweet(text, userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore(), latitude, longitude, replyTweetId);
	}

	@Override
	public boolean resetCounts(String type, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.resetCounts(type,userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}

	@Override
	public RESTMessage sendMessage(String userId, String text,
			ProviderUser userconfig) throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.sendMessage(userId, text, userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
	}
	
	@Override
	public RESTUser selectTweetUser(String userId, ProviderUser userconfig)
			throws Exception {
		Providers _provider = providerService.selectProviderByID(userconfig.getProviderId());
		if(_provider==null){
			throw new Exception("No this provider");
		}
		ProviderTweetService service = getProviderTweetService(_provider.getCode());
		return service.getTweetUser(userId, userconfig.getToken(),userconfig.getTokenSecret(),userconfig.getTokenMore());
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
