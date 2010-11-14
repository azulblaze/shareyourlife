package com.zhela.android.core.remote.model;

public class RESTTweetList {

	private java.util.List<RESTTweet> tweets;
	private int size;
	public java.util.List<RESTTweet> getTweets() {
		return tweets;
	}
	public void setTweets(java.util.List<RESTTweet> tweets) {
		this.tweets = tweets;
		if(tweets!=null){
			this.size = tweets.size();
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
