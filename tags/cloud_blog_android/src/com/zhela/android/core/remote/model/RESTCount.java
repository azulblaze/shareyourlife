package com.zhela.android.core.remote.model;

public class RESTCount {
	private long comments;
	private long retweet;
	private long message;
	private long mentions;
	private long followers;
	public long getComments() {
		return comments;
	}
	public void setComments(long comments) {
		this.comments = comments;
	}
	public long getRetweet() {
		return retweet;
	}
	public void setRetweet(long retweet) {
		this.retweet = retweet;
	}
	public long getMessage() {
		return message;
	}
	public void setMessage(long message) {
		this.message = message;
	}
	public long getMentions() {
		return mentions;
	}
	public void setMentions(long mentions) {
		this.mentions = mentions;
	}
	public long getFollowers() {
		return followers;
	}
	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
}
