package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tweetList")
public class RESTTweetList {

	private java.util.List<RESTTweet> tweets;
	private long start;
	private int limit;
	private int size;
	@XmlElement(name="tweets")
	public java.util.List<RESTTweet> getTweets() {
		return tweets;
	}
	public void setTweets(java.util.List<RESTTweet> tweets) {
		this.tweets = tweets;
		this.size = tweets.size();
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
