package com.zhela.android.core.remote.business;

import java.io.File;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.HttpParse;
import com.zhela.android.core.net.NetStatusException;
import com.zhela.android.core.remote.model.RESTComment;
import com.zhela.android.core.remote.model.RESTCommentList;
import com.zhela.android.core.remote.model.RESTCount;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.remote.model.RESTMessage;
import com.zhela.android.core.remote.model.RESTMessageList;
import com.zhela.android.core.remote.model.RESTProviderAccount;
import com.zhela.android.core.remote.model.RESTProviderAccountList;
import com.zhela.android.core.remote.model.RESTProviderList;
import com.zhela.android.core.remote.model.RESTResponse;
import com.zhela.android.core.remote.model.RESTTweet;
import com.zhela.android.core.remote.model.RESTTweetList;
import com.zhela.android.core.remote.model.RESTUser;
import com.zhela.android.core.remote.model.RESTUserList;
import com.zhela.android.core.util.DeviceInfo;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

public class ServiceImpl implements Service {
	private final static String APP_KEY = "8ca4e82e189afbd";
	private final static String FORMAT = ".json";
	public static String BASE_URL = "http://124.14.146.10:8080/cloudblog/api/";
	private static String URL_AuthClient = BASE_URL+ "auth";
	private static String URL_AuthUser = BASE_URL+ "users";
	private static String URL_Providers = BASE_URL+ "providers";
	private static HttpClient httpclient;
	
	public ServiceImpl(){
		URL_AuthClient = BASE_URL+ "auth";
		URL_AuthUser = BASE_URL+ "users";
		URL_Providers = BASE_URL+ "providers";

	}

	@Override
	public RESTInternalUser login(String account, String password)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTInternalUser response;
			response = hp.getResponse(HttpParse.METHOD_GET, (URL_AuthUser+"/"+getUTF_8(account)+"/"+getUTF_8(password)+FORMAT), null, null, null, RESTInternalUser.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,e.getMessage());
			}else{
				DefaultException de = new DefaultException(DefaultException.NEEDLOGIN,e.getMessage());
				RESTResponse response = new RESTResponse();
				response.setStatus(e.getCode()+"");
				response.setDescription(e.getMessage());
				de.setResponse(response);
				throw de;
			}
		}
	}

	@Override
	public boolean authClient(String deviceType,
			String deviceSys, String deviceID) throws DefaultException {
		httpclient = new DefaultHttpClient();
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_GET, URL_AuthClient+"/"+APP_KEY+FORMAT, null, null, null, RESTResponse.class);
			String encKey = response.getDescription();
			encKey = getUTF_8(getEncStr(encKey));
			deviceType = getUTF_8(deviceType);
			deviceSys = getUTF_8(deviceSys);
			deviceID = getUTF_8(deviceID);
			response = hp.getResponse(HttpParse.METHOD_GET, 
					URL_AuthClient+"/"+encKey+"/"+deviceType+"/"+deviceSys+"/"+deviceID+FORMAT,
					null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else{
				throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
			}
		}
	}

	@Override
	public boolean shutdownApp() throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			@SuppressWarnings("unused")
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_AuthClient+FORMAT, null, null, null, RESTResponse.class);
		}catch(NetStatusException e){
		}
		return true;
	}

	@Override
	public boolean createRelation(long providerId, String providerAccount,
			String userId, int type) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_POST, URL_Providers+"/"+providerId+"/relations/followuser"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&userId="+getUTF_8(userId)+"&type="+type, null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return createRelation(providerId,providerAccount,userId,type);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	}

	@Override
	public boolean delProviderAccount(long providerId, String providerAccount)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_Providers+"/"+providerId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return delProviderAccount(providerId,providerAccount);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteComment(long providerId, String providerAccount,
			String commentId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_Providers+"/"+providerId+"/tweets/comments/"+commentId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return deleteComment(providerId,providerAccount,commentId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteTweet(long providerId, String providerAccount,
			String tweetId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_Providers+"/"+providerId+"/tweets/content/"+tweetId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return deleteTweet(providerId,providerAccount,tweetId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	}

	@Override
	public boolean delteMessage(long providerId, String providerAccount,
			String msgId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_DELETE, URL_Providers+"/"+providerId+"/messages/"+msgId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return delteMessage(providerId,providerAccount,msgId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	}

	@Override
	public RESTProviderList getAllProviders() throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTProviderList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+FORMAT, null, null, null, RESTProviderList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getAllProviders();
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTCommentList getCommentByTweet(long providerId,
			String providerAccount, String tweetId, int size, int page)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTCommentList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/comments"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&tweetId="+tweetId+"&p="+page+"&s="+size, null, null, null, RESTCommentList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getCommentByTweet(providerId,providerAccount,tweetId,size,page);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTCount getCount(long providerId, String providerAccount)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTCount response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/counts"+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTCount.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getCount(providerId,providerAccount);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTUserList getFollows(long providerId, String providerAccount,
			String userId, int size, String position, int direction)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTUserList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/relations/follow"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&d="+direction+"&p="+position+"&s="+size, null, null, null, RESTUserList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getFollows(providerId,providerAccount,userId,size,position,direction);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTUserList getFriends(long providerId, String providerAccount,
			String userId, int size, String position, int direction)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTUserList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/relations/friend"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&d="+direction+"&p="+position+"&s="+size, null, null, null, RESTUserList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getFriends(providerId,providerAccount,userId,size,position,direction);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTTweetList getHomeTweet(long providerId, String providerAccount,
			int size, String position, int direction) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTTweetList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/content/hometweet"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&d="+direction+"&p="+position+"&s="+size, null, null, null, RESTTweetList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getHomeTweet(providerId,providerAccount,size,position,direction);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTTweetList getMentions(long providerId, String providerAccount,
			int size, String position, int direction) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTTweetList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/mentions"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&d="+direction+"&p="+position+"&s="+size, null, null, null, RESTTweetList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getMentions(providerId,providerAccount,size,position,direction);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTMessageList getMsgInbox(long providerId, String providerAccount,
			int size, String position) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTMessageList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/messages/inbox"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&p="+position+"&s="+size, null, null, null, RESTMessageList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getMsgInbox(providerId,providerAccount,size,position);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTMessageList getMsgOutbox(long providerId,
			String providerAccount, int size, String position)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTMessageList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/messages/outbox"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&p="+position+"&s="+size, null, null, null, RESTMessageList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getMsgOutbox(providerId,providerAccount,size,position);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTTweet getTweet(long providerId, String providerAccount,
			String tweetId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTTweet response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/content/"+tweetId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTTweet.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getTweet(providerId,providerAccount,tweetId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	
	}

	@Override
	public RESTUser getUserInfo(long providerId, String providerAccount,
			String userId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTUser response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/users/"+userId+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTUser.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getUserInfo(providerId,providerAccount,userId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTProviderAccountList getUserProviderAccount()
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTProviderAccountList response = hp.getResponse(HttpParse.METHOD_GET, URL_AuthUser+"/providers"+FORMAT, null, null, null, RESTProviderAccountList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getUserProviderAccount();
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTTweetList getUserTweet(long providerId, String providerAccount,
			String userId, int size, String position, int direction)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTTweetList response = hp.getResponse(HttpParse.METHOD_GET, URL_Providers+"/"+providerId+"/tweets/content/usertweet/"+userId+FORMAT+"?pa="+getUTF_8(providerAccount)+"&d="+direction+"&p="+position+"&s="+size, null, null, null, RESTTweetList.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return getUserTweet(providerId,providerAccount,userId,size,position,direction);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTComment postCommentByTweet(long providerId,
			String providerAccount, String tweetId, String text,
			String replyComentId) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		String commentId = "";
		if(replyComentId!=null){
			commentId="&commentId="+replyComentId;
		}
		try{
			RESTComment response = hp.getResponse(HttpParse.METHOD_POST, URL_Providers+"/"+providerId+"/tweets/comments"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&tweetId="+tweetId+"&text="+getUTF_8(text)+commentId, null, null, null, RESTComment.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return postCommentByTweet(providerId,providerAccount,tweetId,text,replyComentId);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTProviderAccount postProviderAccount(long providerId, String providerAccount,
			String password) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTProviderAccount response = hp.getResponse(HttpParse.METHOD_POST, URL_Providers+"/"+providerId+FORMAT+"?pa="+getUTF_8(providerAccount)+"&ppass="+password, null, null, null, RESTProviderAccount.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return postProviderAccount(providerId,providerAccount,password);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTTweet postTweet(long providerId, String providerAccount,
			String text, Double latitude, Double longitude, Long replyTweetId,
			File image) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("pa", providerAccount);
		parameters.put("text", getUTF_8(text));
		if(latitude!=null){
			parameters.put("latitude", Double.toString(latitude));
		}
		if(longitude!=null){
			parameters.put("longitude", Double.toString(longitude));
		}
		if(replyTweetId!=null&&replyTweetId>0){
			parameters.put("replyTweetId", Long.toString(replyTweetId));
		}
		try{
			RESTTweet response = hp.getResponse(HttpParse.METHOD_MULTIPARTPOST, URL_Providers+"/"+providerId+"/tweets/content"+FORMAT, parameters, image, "attachmentFile", RESTTweet.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return postTweet(providerId,providerAccount,text,latitude,longitude,replyTweetId,image) ;
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public boolean reSetCount(long providerId, String providerAccount,
			int type) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_PUT, URL_Providers+"/"+providerId+"/tweets/counts"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&type="+type, null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return reSetCount(providerId,providerAccount,type);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;
	
	}

	@Override
	public RESTInternalUser regUser(String account, String password,
			String email, String name) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTInternalUser response = hp.getResponse(HttpParse.METHOD_POST, URL_AuthUser+"/"+getUTF_8(account)+"/"+getUTF_8(password)+"/"+getUTF_8(email)+"/"+getUTF_8(name)+FORMAT, null, null, null, RESTInternalUser.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					return regUser(account,password,email,name);
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public RESTMessage sendMessage(long providerId, String providerAccount,
			String userId, String messageText) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTMessage response = hp.getResponse(HttpParse.METHOD_POST, URL_Providers+"/"+providerId+"/messages"+FORMAT+"?pa="+getUTF_8(providerAccount)+"&userId="+getUTF_8(userId)+"&messageText="+getUTF_8(messageText), null, null, null, RESTMessage.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return sendMessage(providerId,providerAccount,userId,messageText);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	@Override
	public boolean updateProviderAccount(long providerId,
			String providerAccount, int status) throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTResponse response = hp.getResponse(HttpParse.METHOD_PUT, URL_Providers+"/"+providerId+"/"+status+FORMAT+"?pa="+getUTF_8(providerAccount), null, null, null, RESTResponse.class);
			if(response.getDescription().equals("Success")){
				return true;
			}
			return false;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return updateProviderAccount(providerId,providerAccount,status);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return false;

	}

	@Override
	public RESTInternalUser updateUserHeader(File image)
			throws DefaultException {
		HttpParse hp = new HttpParse(httpclient);
		try{
			RESTInternalUser response = hp.getResponse(HttpParse.METHOD_MULTIPARTPOST, URL_AuthUser+"/header"+FORMAT, null,image,"attachmentFile", RESTInternalUser.class);
			return response;
		}catch(NetStatusException e){
			if(e.getCode()==-1){
				throw new DefaultException(DefaultException.EXIT,"网络链接错误");
			}else if(e.getCode()==401){
				if(authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
					if(login(UtilInfo.loginusers.account,UtilInfo.loginusers.account_password)!=null){
						return updateUserHeader(image);
					}else{
						throw new DefaultException(DefaultException.NEEDLOGIN,"帐号登录失败");
					}
				}else{
					throw new DefaultException(DefaultException.EXIT,"客户端验证失败");
				}
			}
		}
		return null;
	}

	
	
	
	
	

	private String getEncStr(String serialid){
		String md5 = getMD5Str(serialid);
		char md5_array[] = md5.toCharArray();
		md5 = "";
		int len = md5_array.length;
		char tmp;
		for(int i=0;i<len;i++){
			if(i%3==0&&(i+2)<len){
				tmp = md5_array[i];
				md5_array[i] = md5_array[i+2];
				md5_array[i+2] = tmp;
			}
			if(i%2==0&&(i+1)<len){
				tmp = md5_array[i];
				md5_array[i] = md5_array[i+1];
				md5_array[i+1] = tmp;
			}
			md5 = md5+md5_array[i];
		}
		return md5;
	}
	
	private String getMD5Str(String str) {  
        MessageDigest messageDigest = null;  
        try {  
            messageDigest = MessageDigest.getInstance("MD5");  
            messageDigest.reset();  
            messageDigest.update(str.getBytes("UTF-8"));  
        } catch (Exception e) {  
        }
        byte[] byteArray = messageDigest.digest();  
        StringBuffer md5StrBuff = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
        return md5StrBuff.toString();  
    }

	private String getUTF_8(String str){
		try{
			return java.net.URLEncoder.encode(str);
		}catch(Exception e){
			return null;
		}
	}
}
