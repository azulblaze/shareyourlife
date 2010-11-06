package com.zhela.cloudblog.service.tweet;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.rest.model.RESTComment;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTCount;
import com.zhela.cloudblog.rest.model.RESTMessage;
import com.zhela.cloudblog.rest.model.RESTMessageList;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.rest.model.RESTUserList;

public interface TweetService {

	/**
	 * 
	 * @param provider_id
	 * @param position
	 * @param direction  -1: decrease, 1: increase
	 * @param size
	 * @param userconfig
	 * @return
	 * @throws Exception
	 */
	RESTTweetList selectHomeTweetByProvider(long position,int direction,int size,ProviderUser userconfig) throws Exception;
	/**
	 * Select tweet
	 * @param tweetId
	 * @param userconfig
	 * @return
	 * @throws Exception
	 */
	RESTTweet selectTweet(String tweetId,ProviderUser userconfig) throws Exception;
	/**
	 * create token for account
	 * @param provider_id
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	java.util.Map<String,String> selectTweetAccount(long provider_id,String username,String password) throws Exception;
	/**
	 * 
	 * @param userId
	 * @param position
	 * @param direction
	 * @param size
	 * @param userconfig
	 * @return
	 * @throws Exception
	 */
	RESTTweetList selectUserTweetByProvider(String userId,long position,int direction,int size,ProviderUser userconfig) throws Exception;
	
	/**
	 * 
	 * @param id: the userId
	 * @param follow: true-follow, false-break
	 * @return boolean: true-success, false-fail
	 * @throws Exception
	 */
	boolean followUser(String id, boolean follow,ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param id: the message id
	 * @return boolean: true-success, false-fail
	 * @throws Exception
	 */
	boolean delMessage(String id,ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param userId: dest user ID
	 * @param text: message content
	 * @return
	 * @throws Exception
	 */
	RESTMessage sendMessage(String userId, String text,ProviderUser userconfig) throws Exception;
	/**
	 * 
	 * @param position: should be message ID
	 * @param size: the page size
	 * @return RESTMessageList : message list
	 * @throws Exception
	 */
	RESTMessageList getMessageOutbox(long position, int size,ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param position: should be message ID
	 * @param size: the page size
	 * @return RESTMessageList : message list
	 * @throws Exception
	 */
	RESTMessageList getMessageInbox(long position, int size, ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param position: cursor
	 * @param size: the page size
	 * @return RESTUserList
	 * @throws Exception
	 */
	RESTUserList getFollows(long position, int size, ProviderUser userconfig) throws Exception;

	/**
	 *  
	 * @param position: cursor
	 * @param size: the page size
	 * @return RESTUserList
	 * @throws Exception
	 */
	RESTUserList getFirends(long position, int size,ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param commentId: comment ID
	 * @return
	 * @throws Exception
	 */
	boolean deleteTweetComment(String commentId, ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param id: tweet ID
	 * @param commentId:reply comment ID
	 * @param text: content
	 * @return
	 * @throws Exception
	 */
	RESTComment commentTweet(String id, String commentId, String text,
			ProviderUser userconfig)
			throws Exception;

	/**
	 * 
	 * @param id: the tweet ID
	 * @return
	 * @throws Exception
	 */
	boolean deleteTweet(String id,ProviderUser userconfig) throws Exception;

	/**
	 * 
	 * @param text: tweet content
	 * @param file: the image upload
	 * @return
	 * @throws Exception
	 */
	RESTTweet publishTweet(String text, ProviderUser userconfig, java.io.File file) throws Exception;

	/**
	 * 
	 * @param text: tweet content
	 * @param latitude:latitude
	 * @param longitude:longitude
	 * @param replyTweetId:reply tweet ID
	 * @return
	 * @throws Exception
	 */
	RESTTweet publishTweet(String text, ProviderUser userconfig, Double latitude, Double longitude,
			Long replyTweetId) throws Exception;

	/**
	 * 
	 * @param id: the tweet ID
	 * @return
	 * @throws Exception
	 */
	RESTCommentList getTweetComment(String id, ProviderUser userconfig) throws Exception;

	/**
	 * get '@username
	 * @param position: the message ID
	 * @param direction: the direct
	 * @param size:page size
	 * @return
	 * @throws Exception
	 */
	RESTTweetList getMentions(long position, int direction, int size,
			ProviderUser userconfig)
			throws Exception;

	/**
	 * 
	 * @param type  1--评论数，2--@数，3--私信数，4--关注我的数。
	 * @return
	 * @throws Exception
	 */
	boolean resetCounts(String type,ProviderUser userconfig) throws Exception ;
	/**
	 * 
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return {"comments":0,"dm":1,"mentions":2,"followers":3},dm-direct message
	 * @throws Exception
	 */
	RESTCount getUnread(ProviderUser userconfig)throws Exception;
}
