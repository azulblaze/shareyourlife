package com.zhela.weibo;

import java.io.File;
import java.util.List;

import weibo4j.Comment;
import weibo4j.Count;
import weibo4j.DirectMessage;
import weibo4j.Paging;
import weibo4j.Status;
import weibo4j.User;
import weibo4j.UserWapper;
import weibo4j.Weibo;
import weibo4j.http.RequestToken;
import weibo4j.http.Response;

public class WeiboService {
	static{
		System.setProperty("weibo4j.oauth.consumerKey", weibo4j.Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret",weibo4j.Weibo.CONSUMER_SECRET);
	}
	Weibo weibo;
	public WeiboService(){
		weibo = new Weibo();
	}

	public void setOAuthAccessToken(String token, String tokenSecret){
		weibo.setOAuthAccessToken(token, tokenSecret);
	}
	
	public Status showStatus(long id) throws Exception{
		return weibo.showStatus(id);
	}
	
	public List<Status> getHomeTimeline() throws Exception{
		return weibo.getHomeTimeline();
	}
	
	public List<Status> getHomeTimeline(Paging paging) throws Exception{
		return weibo.getHomeTimeline(paging);
	}
	public List<Status> getUserTimeline(String userId) throws Exception{
		return weibo.getUserTimeline(userId);
	}
	public List<Status> getUserTimeline(String userId,Paging paging) throws Exception{
		return weibo.getUserTimeline(userId,paging);
	}
	public  List<Status> getMentions() throws Exception{
		return weibo.getMentions();
	}
	public  List<Status> getMentions(Paging paging) throws Exception{
		return weibo.getMentions(paging);
	}
	public List<Comment> getComments(String weiboId) throws Exception {
		return weibo.getComments(weiboId);
	}
	public Status updateStatus(String text, Long replyTweetId, Double latitude, Double longitude) throws Exception{
		return weibo.updateStatus(text, replyTweetId, latitude, longitude);
	}
	public Status updateStatus(String text, Long replyTweetId) throws Exception{
		return weibo.updateStatus(text, replyTweetId);
	}
	public Status updateStatus(String text,Double latitude, Double longitude) throws Exception{
		return weibo.updateStatus(text, latitude, longitude);
	}
	public Status updateStatus(String text) throws Exception{
		return weibo.updateStatus(text);
	}
	public Status uploadStatus(String text, File file) throws Exception {
		return weibo.uploadStatus(text, file);
	}
	public Status destroyStatus(Long weiboId) throws Exception {
		return weibo.destroyStatus(weiboId);
	}
	public Comment updateComment(String text, String weiboId, String commentId) throws Exception {
		return weibo.updateComment(text, weiboId, commentId);
	}
	public Comment destroyComment(long commentId) throws Exception {
		return weibo.destroyComment(commentId);
	}
	public UserWapper getFriendsStatuses(String userId,String position,int size) throws Exception {
		return weibo.getFriendsStatuses(userId, position, size);
	}
	public UserWapper getFollowersStatuses(String userId,String position, int size) throws Exception {
		return weibo.getFollowersStatuses(userId, position, size);
	}
	public List<DirectMessage> getDirectMessages(Paging paging) throws Exception{
		return weibo.getDirectMessages(paging);
	}
	public List<DirectMessage> getSentDirectMessages(Paging paging) throws Exception{
		return weibo.getSentDirectMessages(paging);
	}
	public DirectMessage sendDirectMessage(String userId,String text) throws Exception{
		return weibo.sendDirectMessage(userId, text);
	}
	public DirectMessage destroyDirectMessage(int msgId) throws Exception {
		return weibo.destroyDirectMessage(msgId);
	}
	public User createFriendship(String userId, boolean follow) throws Exception {
		return weibo.createFriendship(userId, follow);
	}
	public RequestToken getOAuthRequestToken() throws Exception {
		return weibo.getOAuthRequestToken();
	}
	public List<Count> getCounts(String ids) throws Exception {
		return weibo.getCounts(ids);
	}
	/**
	 * 
	 * @param type  1--评论数，2--@数，3--私信数，4--关注我的数。 
	 * @return
	 * @throws Exception
	 */
	public boolean resetCounts(String type) throws Exception{
		String addr = "statuses/reset_count.json";
		if(type!=null){
			addr = addr + "?type="+type;
		}
		Response response = weibo.get(weibo.getBaseURL() + addr, true);
		String result = response.asJSONObject().getString("result");
		if(null == result || "".equals(result)||"null".equals(result)){
            return false;
        }
        return Boolean.valueOf(result);
	}
	/**
	 * {"comments":0,"dm":1,"mentions":2,"followers":3}
	 * @return
	 * @throws Exception
	 */
	public Count getUnread() throws Exception {
		return weibo.getUnread();
	}
	
}
