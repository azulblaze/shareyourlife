package com.zhela.cloudblog.service.tweet.provider;

import java.util.Map;

import weibo4j.Count;
import com.zhela.weibo.WeiboService;

import com.zhela.cloudblog.rest.model.RESTComment;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTMessage;
import com.zhela.cloudblog.rest.model.RESTMessageList;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.rest.model.RESTUserList;
import com.zhela.cloudblog.rest.model.RESTCount;

public interface ProviderTweetService {

	/**
	 * 
	 * @param id: the userId
	 * @param follow: true-follow, false-break
	 * @param token:user token
	 * @param tokenSecret: user tokensecret
	 * @param tokenMore:user token more
	 * @return boolean: true-success, false-fail
	 * @throws Exception
	 */
	boolean follow(String id, boolean follow, String token, String tokenSecret,
			String tokenMore) throws Exception;

	/**
	 * 
	 * @param id: the message id
	 * @param token:
	 * @param tokenSecret
	 * @param tokenMore
	 * @return boolean: true-success, false-fail
	 * @throws Exception
	 */
	boolean delMessage(String id, String token, String tokenSecret,
			String tokenMore) throws Exception;

	/**
	 * 
	 * @param userId: dest user ID
	 * @param text: message content
	 * @param token:
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTMessage sendMessage(String userId, String text, String token,
			String tokenSecret, String tokenMore) throws Exception;
	/**
	 * 
	 * @param position: should be message ID
	 * @param size: the page size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return RESTMessageList : message list
	 * @throws Exception
	 */
	RESTMessageList getMessageOutbox(long position, int size, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param position: should be message ID
	 * @param size: the page size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return RESTMessageList : message list
	 * @throws Exception
	 */
	RESTMessageList getMessageInbox(long position, int size, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param id: user ID
	 * @param position: cursor
	 * @param size: the page size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return RESTUserList
	 * @throws Exception
	 */
	RESTUserList getFollows(String id, long position, int size, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param id: user ID
	 * @param position: cursor
	 * @param size: the page size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return RESTUserList
	 * @throws Exception
	 */
	RESTUserList getFirends(String id, long position, int size, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param commentId: comment ID
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	boolean destoryTweetComment(String commentId, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param id: tweet ID
	 * @param commentId:reply comment ID
	 * @param text: content
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTComment commentTweet(String id, String commentId, String text,
			String token, String tokenSecret, String tokenMore)
			throws Exception;

	/**
	 * 
	 * @param id: the tweet ID
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	boolean destoryTweet(String id, String token, String tokenSecret,
			String tokenMore) throws Exception;

	/**
	 * 
	 * @param text: tweet content
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @param file: the image upload
	 * @return
	 * @throws Exception
	 */
	RESTTweet publishTweet(String text, String token, String tokenSecret,
			String tokenMore, java.io.File file) throws Exception;

	/**
	 * 
	 * @param text: tweet content
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @param latitude:latitude
	 * @param longitude:longitude
	 * @param replyTweetId:reply tweet ID
	 * @return
	 * @throws Exception
	 */
	RESTTweet publishTweet(String text, String token, String tokenSecret,
			String tokenMore, Double latitude, Double longitude,
			Long replyTweetId) throws Exception;

	/**
	 * 
	 * @param _weibo: the Weibo
	 * @param id: the tweet ID
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTCommentList getTweetComment(WeiboService _weibo, String id,int size, int position, String token,
			String tokenSecret, String tokenMore) throws Exception;

	/**
	 * 
	 * @param position: the message ID
	 * @param direction: the direct
	 * @param size:page size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTTweetList getMentions(long position, int direction, int size,
			String token, String tokenSecret, String tokenMore)
			throws Exception;

	/**
	 * 
	 * @param userId
	 * @param position
	 * @param direction
	 * @param size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTTweetList getUserTimeline(String userId, long position, int direction,
			int size, String token, String tokenSecret, String tokenMore)
			throws Exception;

	/**
	 * 
	 * @param position
	 * @param direction
	 * @param size
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTTweetList getHomeTimeline(long position, int direction,
			int size, String token, String tokenSecret, String tokenMore)
			throws Exception;

	/**
	 * 
	 * @param _weibo: can be null
	 * @param _count
	 * @param id
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	RESTTweet getTweet(WeiboService _weibo, java.util.List<Count> _count, String id,
			String token, String tokenSecret, String tokenMore)
			throws Exception;

	/**
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	Map<String, String> auth(String name, String password) throws Exception;

	/**
	 * 
	 * @param type  1--评论数，2--@数，3--私信数，4--关注我的数。
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return
	 * @throws Exception
	 */
	boolean resetCounts(String type,String token, String tokenSecret,
			String tokenMore) throws Exception ;
	/**
	 * 
	 * @param token
	 * @param tokenSecret
	 * @param tokenMore
	 * @return {"comments":0,"dm":1,"mentions":2,"followers":3},dm-direct message
	 * @throws Exception
	 */
	RESTCount getUnread(String token, String tokenSecret,
			String tokenMore)throws Exception;
}
