package com.zhela.android.core.remote.model;

public class RESTUser {
	public final static int RELATION_BEFOLLOWED = 1;
	public final static int RELATION_FOLLOW = 2;
	public final static int RELATION_FRIEND = 3;
	public final static int RELATION_NONE = 0;
	private String id;
	private String account;
	private String name;
	private RESTImage header;
	private String gender;
	private long friendsCount;
	private long befriendsCount;
	private long tweetCount;
	private String webSite;
	private int relation;
	private RESTAddress stayAddress;
	private RESTAddress currentAddress;
	private java.util.Date createDate;
	private java.util.Date tweetDate;
	private String latestTweetId;
	private String description;
	private String latestTweet;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RESTImage getHeader() {
		return header;
	}
	public void setHeader(RESTImage header) {
		this.header = header;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}
	public long getBefriendsCount() {
		return befriendsCount;
	}
	public void setBefriendsCount(long befriendsCount) {
		this.befriendsCount = befriendsCount;
	}
	public long getTweetCount() {
		return tweetCount;
	}
	public void setTweetCount(long tweetCount) {
		this.tweetCount = tweetCount;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public RESTAddress getStayAddress() {
		return stayAddress;
	}
	public void setStayAddress(RESTAddress stayAddress) {
		this.stayAddress = stayAddress;
	}
	public RESTAddress getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(RESTAddress currentAddress) {
		this.currentAddress = currentAddress;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getTweetDate() {
		return tweetDate;
	}
	public void setTweetDate(java.util.Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	public String getLatestTweetId() {
		return latestTweetId;
	}
	public void setLatestTweetId(String latestTweetId) {
		this.latestTweetId = latestTweetId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLatestTweet() {
		return latestTweet;
	}
	public void setLatestTweet(String latestTweet) {
		this.latestTweet = latestTweet;
	}
	
	
}
