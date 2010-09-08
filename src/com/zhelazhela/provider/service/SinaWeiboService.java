package com.zhelazhela.provider.service;

import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import weibo4j.Status;
import weibo4j.Weibo;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

public class SinaWeiboService implements WeiboService {

	public Map<String, String> auth(Map<String, String> param) {
		try {
			System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
			System.setProperty("weibo4j.oauth.consumerSecret",Weibo.CONSUMER_SECRET);
			Weibo weibo = new Weibo();
			// set callback url, desktop app please set to null
			// http://callback_url?oauth_token=xxx&oauth_verifier=xxx
			RequestToken requestToken = weibo.getOAuthRequestToken();
			System.out.println("Got request token.");
			System.out.println("Request token: " + requestToken.getToken());
			System.out.println("Request token secret: " + requestToken.getTokenSecret());
			AccessToken accessToken = null;
			while (null == accessToken) {
				String pin = getPinCode(requestToken.getAuthorizationURL(),param);
				System.out.println("pin: " + pin);
				try {
					accessToken = requestToken.getAccessToken(pin);
				} catch (WeiboException te) {
					if (401 == te.getStatusCode()) {
						System.out.println("Unable to get the access token.");
					} else {
						te.printStackTrace();
					}
				}
			}
			System.out.println("Got access token.");
			System.out.println("Access token: " + accessToken.getToken());
			System.out.println("Access token secret: " + accessToken.getTokenSecret());
			weibo.setToken(accessToken.getToken(), accessToken.getTokenSecret());

			Status status = weibo.updateStatus("测试消息from zhela ");
			System.out.println("Successfully updated the status to [" + status.getText() + "].");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception te) {
			System.out.println("Failed to get timeline: " + te.getMessage());
		} 
		return null;
	}
	
	private String getPinCode(String url,Map<String,String> user) throws Exception{
		HttpClient hc = new HttpClient();
		GetMethod get = new GetMethod("http://api.t.sina.com.cn/oauth/authorize?action=submit&"+url.substring(url.indexOf("?")+1)+"&oauth_callback=none&from=null&userId="+URLEncoder.encode(user.get("userId"),"utf-8")+"&passwd="+URLEncoder.encode(user.get("passwd"),"utf-8"));
		setHeader(get);
		hc.executeMethod(get);
		String str = get.getResponseBodyAsString();
		/*
		PostMethod pm = new PostMethod("http://api.t.sina.com.cn/oauth/authorize");//url.substring(0,url.indexOf("?"))
		setHeader(pm);
		pm.setParameter("action", "submit");
		pm.setParameter("oauth_token", url.substring(url.indexOf("?")+1));
		pm.setParameter("oauth_callback", "none");
		pm.setParameter("from", "turnuser");
		pm.setParameter("userId", user.get("userId"));
		pm.setParameter("passwd", user.get("passwd"));
		pm.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		hc.executeMethod(pm);
		System.out.println(pm.getStatusCode());
		System.out.println(pm.getResponseBodyAsString());
		*/
		String tag = "获取到授权码：";
		int index = str.indexOf(tag);
		if(index>0){
			str = str.substring(tag.length()+index);
			index = str.indexOf("</p>");
			if(index>0){
				str = str.substring(0,index);
				System.out.println(str);
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

	public static void main(String args[]) throws Exception{
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret",Weibo.CONSUMER_SECRET);
		Weibo weibo = new Weibo();
		weibo.setToken("fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7");
		//Status status = weibo.updateStatus("再来测试消息，大家可以忽略。");
		//System.out.println("Successfully updated the status to [" + status.getText() + "].");
		java.util.List<Status> status = weibo.getFriendsTimeline();
		System.out.println(status.size());
		for(Status statu:status){
			System.out.println(statu.getText());
		}
	}
}
