package com.zhela.android.core.remote.business;

import java.io.File;

import com.zhela.android.core.remote.model.RESTComment;
import com.zhela.android.core.remote.model.RESTCommentList;
import com.zhela.android.core.remote.model.RESTCount;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.remote.model.RESTMessage;
import com.zhela.android.core.remote.model.RESTMessageList;
import com.zhela.android.core.remote.model.RESTProviderAccount;
import com.zhela.android.core.remote.model.RESTProviderAccountList;
import com.zhela.android.core.remote.model.RESTProviderList;
import com.zhela.android.core.remote.model.RESTTweet;
import com.zhela.android.core.remote.model.RESTTweetList;
import com.zhela.android.core.remote.model.RESTUser;
import com.zhela.android.core.remote.model.RESTUserList;
import com.zhela.android.exception.DefaultException;

public interface Service {
	public boolean authClient(String deviceType,String deviceSys,String deviceID) throws DefaultException;
	
	public boolean shutdownApp() throws DefaultException;
	/**
	 * GET /users/{account}/{password}.format
	 * @param account
	 * @param password
	 * @return
	 * @throws DefaultException
	 */
	public RESTInternalUser login(String account,String password) throws DefaultException;
	/**
	 * POST /users/{account}/{password}/{email}/{name}.format
	 * @param account
	 * @param password
	 * @param email
	 * @param name
	 * @return
	 * @throws DefaultException
	 */
	public RESTInternalUser regUser(String account,String password,String email,String name) throws DefaultException;
	
	/**
	 * GET /users/providers.format
	 * @param providerId
	 * @return
	 * @throws DefaultException
	 */
	public RESTProviderAccountList getUserProviderAccount() throws DefaultException;
	
	/**
	 * POST /users/header.format       pamameters: attachmentFile
	 * @param image
	 * @return
	 * @throws DefaultException
	 */
	public RESTInternalUser updateUserHeader(File image)throws DefaultException;
	
	/**
	 * GET /providers.format
	 * @return
	 * @throws DefaultException
	 */
	public RESTProviderList getAllProviders() throws DefaultException;
	
	/**
	 * DELETE /providers/{providerId}.format pamameters: pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @return
	 * @throws DefaultException
	 */
	public boolean delProviderAccount(long providerId,String providerAccount) throws DefaultException;
	
	/**
	 * PUT /providers/{providerId}/{status}.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param status  	STATUS_OK = 1;STATUS_CLOSE = -1;STATuC_NOTAUTH = 0;

	 * @return
	 * @throws DefaultException
	 */
	public boolean updateProviderAccount(long providerId,String providerAccount,int status) throws DefaultException;
	
	/**
	 * POST /providers/{providerId}.format pa=providerAccount  ppass=password
	 * @param providerId
	 * @param providerAccount
	 * @param password
	 * @return
	 * @throws DefaultException
	 */
	public RESTProviderAccount postProviderAccount(long providerId,String providerAccount,String password) throws DefaultException;
	
	/**
	 * GET /providers/tweets/content/hometweet.format pa=providerAccount,s=size,p=position,d=direction
	 * @param providerId
	 * @param providerAccount
	 * @param size
	 * @param position
	 * @param direction
	 * @return
	 * @throws DefaultException
	 */
	public RESTTweetList getHomeTweet(long providerId,String providerAccount,int size,String position,int direction) throws DefaultException;
	
	/**
	 * GET /providers/tweets/content/usertweet/{userId}.format pa=providerAccount,s=size,p=position,d=direction
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @param size
	 * @param position
	 * @param direction
	 * @return
	 * @throws DefaultException
	 */
	public RESTTweetList getUserTweet(long providerId,String providerAccount,String userId,int size,String position,int direction) throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/tweets/content/{tweetId}.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param tweetId
	 * @return
	 * @throws DefaultException
	 */
	public RESTTweet getTweet(long providerId,String providerAccount,String tweetId) throws DefaultException;
	
	/**
	 * DELETE /providers/{providerId}/tweets/content/{tweetId}.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param tweetId
	 * @return
	 * @throws DefaultException
	 */
	public boolean deleteTweet(long providerId,String providerAccount,String tweetId) throws DefaultException;
	
	/**
	 * MEDIA POST /providers/{providerId}/tweets/content.format pa=providerAccount,text=text,latitude=latitude,longitude=longitude,replyTweetId=replyTweetId,attachmentFile=image
	 * @param providerId
	 * @param providerAccount
	 * @param text
	 * @param latitude
	 * @param longitude
	 * @param replyTweetId
	 * @return
	 * @throws DefaultException
	 */
	public RESTTweet postTweet(long providerId,String providerAccount,String text,Double latitude,Double longitude,Long replyTweetId,File image) throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/relations/follow.format pa=providerAccount,s=size,p=position,d=direction
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @param size
	 * @param position
	 * @param direction
	 * @return
	 */
	public RESTUserList getFollows(long providerId,String providerAccount,String userId,int size,String position,int direction)throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/relations/friend.format pa=providerAccount,s=size,p=position,d=direction
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @param size
	 * @param position
	 * @param direction
	 * @return
	 */
	public RESTUserList getFriends(long providerId,String providerAccount,String userId,int size,String position,int direction) throws DefaultException;
	
	/**
	 * POST /{providerId}/relations/followuser.format pa=providerAccount,userId=userId,type=type
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @param type : >0 build, <= break
	 * @return
	 * @throws DefaultException
	 */
	public boolean createRelation(long providerId,String providerAccount,String userId,int type) throws DefaultException;
	
	/**
	 * DELETE /providers/{providerId}/messages/{msgId}.format  pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param msgId
	 * @return
	 * @throws DefaultException
	 */
	public boolean delteMessage(long providerId,String providerAccount,String msgId)throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/messages/inbox.format pa=providerAccount,s=size,p=position
	 * @param providerId
	 * @param providerAccount
	 * @param size
	 * @param position
	 * @return
	 * @throws DefaultException
	 */
	public RESTMessageList getMsgInbox(long providerId,String providerAccount,int size,String position)throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/messages/outbox.format pa=providerAccount,s=size,p=position
	 * @param providerId
	 * @param providerAccount
	 * @param size
	 * @param position
	 * @return
	 * @throws DefaultException
	 */
	public RESTMessageList getMsgOutbox(long providerId,String providerAccount,int size,String position)throws DefaultException;
	
	/**
	 * POST /providers/{providerId}/messages.format pa=providerAccount,userId=userId,messageText=messageText
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @param messageText
	 * @return
	 * @throws DefaultException
	 */
	public RESTMessage sendMessage(long providerId,String providerAccount,String userId,String messageText)throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/tweets/mentions.format pa=providerAccount,s=size,p=position,d=direction
	 * @param providerId
	 * @param providerAccount
	 * @param size
	 * @param position
	 * @param direction
	 * @return
	 * @throws DefaultException
	 */
	public RESTTweetList getMentions(long providerId,String providerAccount,int size,String position,int direction) throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/tweets/counts.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @return
	 * @throws DefaultException
	 */
	public RESTCount getCount(long providerId,String providerAccount)throws DefaultException;
	
	/**
	 * PUT /providers/{providerId}/tweets/counts.format  pa=providerAccount,type=type
	 * @param providerId
	 * @param providerAccount
	 * @param type 1--评论数，2--@数，3--私信数，4--关注我的数。
	 * @return
	 * @throws DefaultException
	 */
	public boolean reSetCount(long providerId,String providerAccount,int type)throws DefaultException;
	/**
	 * DELETE /providers/{providerId}/tweets/comments/{commentId}.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param commentId
	 * @return
	 * @throws DefaultException
	 */
	public boolean deleteComment(long providerId,String providerAccount,String commentId) throws DefaultException;
	/**
	 * GET /providers/{providerId}/tweets/comments.format pa=providerAccount,tweetId=tweetId,p=page,s=size
	 * @param providerId
	 * @param providerAccount
	 * @param tweetId
	 * @param size
	 * @param page
	 * @return
	 * @throws DefaultException
	 */
	public RESTCommentList getCommentByTweet(long providerId,String providerAccount,String tweetId,int size,int page)throws DefaultException;
	
	/**
	 * POST /providers/{providerId}/tweets/comments.format pa=providerAccount,tweetId=tweetId,text=text,commentId=replyComentId
	 * @param providerId
	 * @param providerAccount
	 * @param tweetId
	 * @param text
	 * @param replyComentId
	 * @return
	 * @throws DefaultException
	 */
	public RESTComment postCommentByTweet(long providerId,String providerAccount,String tweetId,String text,String replyComentId)throws DefaultException;
	
	/**
	 * GET /providers/{providerId}/users/{userId}.format pa=providerAccount
	 * @param providerId
	 * @param providerAccount
	 * @param userId
	 * @return
	 * @throws DefaultException
	 */
	public RESTUser getUserInfo(long providerId,String providerAccount,String userId)throws DefaultException;
}
