package com.zhela.cloudblog.service.tweet.provider.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import weibo4j.Comment;
import weibo4j.Count;
import weibo4j.DirectMessage;
import weibo4j.Paging;
import weibo4j.Status;
import weibo4j.User;
import com.zhela.weibo.WeiboService;
import weibo4j.WeiboException;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

import com.zhela.cloudblog.rest.model.RESTComment;
import com.zhela.cloudblog.rest.model.RESTCommentList;
import com.zhela.cloudblog.rest.model.RESTMessage;
import com.zhela.cloudblog.rest.model.RESTMessageList;
import com.zhela.cloudblog.rest.model.RESTTweet;
import com.zhela.cloudblog.rest.model.RESTTweetList;
import com.zhela.cloudblog.rest.model.RESTUserList;
import com.zhela.cloudblog.rest.model.RESTCount;
import com.zhela.cloudblog.service.tweet.provider.ProviderTweetService;

public class ProviderTweetServiceSINA implements ProviderTweetService {
	@Override
	public Map<String, String> auth(String name, String password) throws Exception{
		return authSina(name,password);
	}

	@Override
	public RESTTweet getTweet(WeiboService _weibo,java.util.List<Count> _count,String id, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo;
		if(_weibo!=null){
			weibo = _weibo;
		}else{
			weibo = new WeiboService();
			weibo.setOAuthAccessToken(token, tokenSecret);
		}
		java.util.List<Count> counts = null;
		if(_count!=null){
			counts = _count;
		}
		Status status = weibo.showStatus(Long.parseLong(id));
		RESTTweet tweet = SINAConventor.StatusToREST(status);
		
		RESTTweet forward = null;
		if(status.getRetweetDetails()!=null){
			if(counts==null){
				counts = getCount(weibo,id+","+status.getRetweetDetails().getId());
			}
			forward = getForwardTweet(status.getRetweetDetails(),counts);
			tweet.setForwardTweet(forward);
		}
		if(counts==null){
			counts = getCount(weibo,id);
		}
		setCount(counts,tweet);
		return tweet;
	}
	
	public RESTTweetList getHomeTimeline(long position,int direction,int size, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		java.util.List<Status> status;
		Paging paging = genPaging(position,direction,size);
		if(paging==null){
			 status = weibo.getHomeTimeline();
		}else{
			status = weibo.getHomeTimeline(paging);
		}
		RESTTweetList restlist = new RESTTweetList();
		java.util.List<RESTTweet> list = new java.util.ArrayList<RESTTweet>();
		RESTTweet tmp;
		String ids = getIds(status);
		java.util.List<Count> counts = getCount(weibo,ids);
		for(Status _status:status){
			tmp = SINAConventor.StatusToREST(_status);
			if(_status.getRetweetDetails()!=null){
				tmp.setForwardTweet(getForwardTweet(_status.getRetweetDetails(),counts));
			}
			list.add(tmp);
		}
		restlist.setTweets(list);
		return restlist;
	}
	
	
	public RESTTweetList getUserTimeline(String userId,long position,int direction,int size, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		java.util.List<Status> status;
		Paging paging = genPaging(position,direction,size);
		if(paging==null){
			 status = weibo.getUserTimeline(userId);
		}else{
			 status = weibo.getUserTimeline(userId,paging);
		}
		RESTTweetList restlist = new RESTTweetList();
		java.util.List<RESTTweet> list = new java.util.ArrayList<RESTTweet>();
		RESTTweet tmp;
		String ids = getIds(status);
		java.util.List<Count> counts = getCount(weibo,ids);
		for(Status _status:status){
			tmp = SINAConventor.StatusToREST(_status);
			System.out.println(_status);
			if(_status.getRetweetDetails()!=null){
				tmp.setForwardTweet(getForwardTweet(_status.getRetweetDetails(),counts));
			}
			list.add(tmp);
		}
		restlist.setTweets(list);
		return restlist;
	}
	
	public RESTTweetList getMentions(long position,int direction,int size, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		java.util.List<Status> status;
		Paging paging = genPaging(position,direction,size);
		if(paging==null){
			 status = weibo.getMentions();
		}else{
			 status = weibo.getMentions(paging);
		}
		for(Status tmp:status){
			System.out.println(tmp.getId()+"#"+tmp);
		}
		RESTTweetList restlist = new RESTTweetList();
		java.util.List<RESTTweet> list = new java.util.ArrayList<RESTTweet>();
		RESTTweet tmp;
		String ids = getIds(status);
		java.util.List<Count> counts = getCount(weibo,ids);
		for(Status _status:status){
			tmp = SINAConventor.StatusToREST(_status);
			if(_status.getRetweetDetails()!=null){
				tmp.setForwardTweet(getForwardTweet(_status.getRetweetDetails(),counts));
			}
			list.add(tmp);
		}
		restlist.setTweets(list);
		return restlist;
	}
	
	public RESTCommentList getTweetComment(WeiboService _weibo,String id, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo;
		if(_weibo!=null){
			weibo = _weibo;
		}else{
			weibo = new WeiboService();
			weibo.setOAuthAccessToken(token, tokenSecret);
		}
		java.util.List<Comment> comments = weibo.getComments(id);
		return SINAConventor.CommentListToREST(comments);
	}
	
	public RESTTweet publishTweet(String text, String token, String tokenSecret,
			String tokenMore, Double latitude, Double longitude,Long replyTweetId) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		Status status;
		if(replyTweetId!=null&&replyTweetId>0){
			if(latitude!=null){
				status = weibo.updateStatus(text, replyTweetId, latitude, longitude);
			}else{
				status = weibo.updateStatus(text, replyTweetId);
			}
		}else{
			if(latitude!=null){
				status = weibo.updateStatus(text,latitude, longitude);
			}else{
				status = weibo.updateStatus(text);
			}
		}
		return SINAConventor.StatusToREST(status);
	}
	
	public RESTTweet publishTweet(String text, String token, String tokenSecret,
			String tokenMore, java.io.File file) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		Status status = weibo.uploadStatus(text, file);
		return SINAConventor.StatusToREST(status);
	}
	
	public boolean destoryTweet(String id, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		Status status = weibo.destroyStatus(Long.parseLong(id));
		if(status!=null){
			return true;
		}
		return false;
	}
	
	public RESTComment commentTweet(String id,String commentId,String text, String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		return SINAConventor.CommentToREST(weibo.updateComment(text, id, commentId));
	}
	
	public boolean destoryTweetComment(String commentId,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		if(weibo.destroyComment(Long.parseLong(commentId))!=null){
			return true;
		}
		return false;
	}
	
	public RESTUserList getFirends(String id,long position,int size,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		return SINAConventor.UserToREST(weibo.getFriendsStatuses(id, position+"", size));
	}
	
	public RESTUserList getFollows(String id,long position,int size,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		return SINAConventor.UserToREST(weibo.getFollowersStatuses(id, position+"", size));
	}
	/**
	 * position: the message id
	 * size:pagesize
	 */
	public RESTMessageList getMessageInbox(long position,int size,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		Paging paging = genPaging(position,1,size);
		List<DirectMessage> messages = weibo.getDirectMessages(paging);
		RESTMessageList list = new RESTMessageList();
		java.util.List<RESTMessage> msgs = new java.util.ArrayList<RESTMessage>();
		for(DirectMessage msg:messages){
			RESTMessage rest = SINAConventor.MessageToREST(msg);
			msgs.add(rest);
		}
		list.setMessages(msgs);
		list.setStart(position);
		list.setType(RESTMessageList.TYPE_INBOX);
		return list;
	}
	
	/**
	 * position: the message id
	 * size:pagesize
	 */
	public RESTMessageList getMessageOutbox(long position,int size,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		Paging paging = genPaging(position,1,size);
		List<DirectMessage> messages = weibo.getSentDirectMessages(paging);
		RESTMessageList list = new RESTMessageList();
		java.util.List<RESTMessage> msgs = new java.util.ArrayList<RESTMessage>();
		for(DirectMessage msg:messages){
			RESTMessage rest = SINAConventor.MessageToREST(msg);
			msgs.add(rest);
		}
		list.setMessages(msgs);
		list.setStart(position);
		list.setType(RESTMessageList.TYPE_OUTBOX);
		return list;
	}
	
	public RESTMessage sendMessage(String userId,String text,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		DirectMessage message = weibo.sendDirectMessage(userId, text);
		return SINAConventor.MessageToREST(message);
	}
	
	public boolean delMessage(String id,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		DirectMessage message = weibo.destroyDirectMessage(Integer.parseInt(id));
		if(message!=null){
			return true;
		}
		return false;
	}
	public boolean follow(String id,boolean follow,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		User user = weibo.createFriendship(id, follow);
		if(user!=null){
			return true;
		}
		return false;
	}
	public boolean resetCounts(String type,String token, String tokenSecret,
			String tokenMore) throws Exception {
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		return weibo.resetCounts(type);
	}
	public RESTCount getUnread(String token, String tokenSecret,
			String tokenMore)throws Exception{
		WeiboService weibo = new WeiboService();
		weibo.setOAuthAccessToken(token, tokenSecret);
		return SINAConventor.CountToREST(weibo.getUnread());
	}
	

	private Map<String, String> authSina(String username,String password) throws Exception{
		try {
			WeiboService weibo = new WeiboService();
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
	static{
		System.setProperty("weibo4j.oauth.consumerKey", weibo4j.Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret",weibo4j.Weibo.CONSUMER_SECRET);
	}
	private String getPinCode(String url,String username,String password) throws Exception{
		HttpClient hc = new HttpClient();
		GetMethod get = new GetMethod("http://api.t.sina.com.cn/oauth/authorize?action=submit&"+url.substring(url.indexOf("?")+1)+"&oauth_callback=none&from=null&userId="+URLEncoder.encode(username,"utf-8")+"&passwd="+URLEncoder.encode(password,"utf-8"));
		setHeader(get);
		hc.executeMethod(get);
		String str = getFromZip(get);
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
	private String getFromZip(HttpMethod hm) throws Exception{
		InputStream is = hm.getResponseBodyAsStream();
	      GZIPInputStream gzin = new GZIPInputStream(is);
	      InputStreamReader isr = new InputStreamReader(gzin, "utf-8");
	      java.io.BufferedReader br = new java.io.BufferedReader(isr);
	      String tempbf;
	      StringBuffer sb =new StringBuffer(); 
	      while((tempbf=br.readLine())!=null){
	       sb.append(tempbf);
	       sb.append("\r\n");
	      }
	      isr.close();
	      gzin.close();
	      return sb.toString();
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
	private String getIds(java.util.List<Status> status){
		if(status!=null&&status.size()>0){
			String tmp = "";
			for(Status _status:status){
				tmp = tmp+","+_status.getId();
				if(_status.getRetweetDetails()!=null){
					tmp = tmp+","+_status.getRetweetDetails().getId();
				}
			}
			if(tmp.length()>0){
				return tmp.substring(1);
			}
			return null;
		}
		return null;
	}
	private void setCount(java.util.List<Count> counts,RESTTweet tweet){
		if(tweet!=null&&counts!=null){
			for(Count _count:counts){
				if(_count.get.equals(tweet.getId())){
					tweet.setCommentCount(_count.getComments());
					tweet.setForwardCount(_count.getRt());
					return;
				}
			}
		}
	}

	private Paging genPaging(long position,int direction,int size){
		Paging paging = new Paging();
		if(position>=0){
			if(direction==1){
				paging.setSinceId(position);
			}
			if(direction==-1){
				paging.setMaxId(position);
			}
		}
		paging.setCount(size);
		return paging;
	}
	private RESTTweet getForwardTweet(Status status,java.util.List<Count> counts) throws Exception {
		RESTTweet tweet = SINAConventor.StatusToREST(status);
		setCount(counts,tweet);
		return tweet;
	}

	private java.util.List<Count> getCount(WeiboService weibo,String ids){
		if(ids==null||ids.length()<1){
			return null;
		}
		try{
			java.util.List<Count> list = weibo.getCounts(ids);
			if(list.size()>0){
				return list;
			}
		}catch(Exception e){
			
		}
		return null;
	}
	
	public static void main(String args[]) throws Exception{
		ProviderTweetService ptss = new ProviderTweetServiceSINA();
		//boolean result = ptss.resetCounts("2", "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		ptss.getUnread("fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		//System.out.println(result);
		//ptss.getUnread("fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);		ptss.getUnread("fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		//ptss.getMentions(664357259, 1, 5, "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		//ptss.sendMessage("1708317373", "我用程序给你发消息，哈哈", "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		//ptss.getMessageOutbox( 36716787,10, "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		//ptss.getTimeline("6520780175", "fdbcad19eb31e8167be26108d6b94004", "2511fd402388db7ec2d34076c1bce0f7", null);
		
	}
}
