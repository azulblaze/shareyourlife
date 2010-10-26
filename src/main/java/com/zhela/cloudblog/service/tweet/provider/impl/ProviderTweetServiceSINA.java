package com.zhela.cloudblog.service.tweet.provider.impl;

import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.service.tweet.provider.ProviderTweetService;

public class ProviderTweetServiceSINA implements ProviderTweetService {
	static{
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret",Weibo.CONSUMER_SECRET);
	}
	@Override
	public Map<String, String> auth(String name, String password) throws Exception{
		return authSina(name,password);
	}

	@Override
	public RESTTweet getTweet(String id, String token, String tokenSecret,
			String tokenMore) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	static{
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret",Weibo.CONSUMER_SECRET);
	}

	public Map<String, String> authSina(String username,String password) throws Exception{
		try {
			Weibo weibo = new Weibo();
			RequestToken requestToken = weibo.getOAuthRequestToken();
			AccessToken accessToken = null;
			int runTimes = 0;
			while (null == accessToken&&runTimes<2) {
				runTimes ++;
				String pin = getPinCode(requestToken.getAuthorizationURL(),username,password);
				try {
					accessToken = requestToken.getAccessToken(pin);
				} catch (WeiboException te) {
					throw new Exception("unable to valid your account");
				}
			}
			Map<String,String> result = new java.util.HashMap<String, String>();
			result.put("token", accessToken.getToken());
			result.put("tokenSecret", accessToken.getTokenSecret());
			return result;
		} catch (Exception te) {
			throw new Exception("unable to valid your account");
		} 
	}
	
	private String getPinCode(String url,String username,String password) throws Exception{
		HttpClient hc = new HttpClient();
		GetMethod get = new GetMethod("http://api.t.sina.com.cn/oauth/authorize?action=submit&"+url.substring(url.indexOf("?")+1)+"&oauth_callback=none&from=null&userId="+URLEncoder.encode(username,"utf-8")+"&passwd="+URLEncoder.encode(password,"utf-8"));
		setHeader(get);
		hc.executeMethod(get);
		String str = get.getResponseBodyAsString();
		String tag = "获取到授权码：";
		int index = str.indexOf(tag);
		if(index>0){
			str = str.substring(tag.length()+index);
			index = str.indexOf("</p>");
			if(index>0){
				str = str.substring(0,index);
				return str;
			}
		}
		return "";
	}
	
	private void setHeader(HttpMethod hm){
		hm.setRequestHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.9) Gecko/20100824 Firefox/3.6.9 ( .NET CLR 3.5.30729)");
		hm.setRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		hm.setRequestHeader("Accept-Language","en-us,en;q=0.5");
		hm.setRequestHeader("Accept-Encoding","gzip,deflate");
		hm.setRequestHeader("Accept-Charset","ISO-8859-1,utf-8;q=0.7,*;q=0.7");
		hm.setRequestHeader("Keep-Alive","115");
		hm.setRequestHeader("Connection","keep-alive");
		hm.setRequestHeader("Referer","url");
	}
	
}
