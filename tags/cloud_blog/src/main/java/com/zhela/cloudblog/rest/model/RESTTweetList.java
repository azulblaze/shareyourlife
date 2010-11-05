package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tweetList")
public class RESTTweetList {

	private java.util.List<RESTTweet> tweets;
	@XmlElement(name="tweets")
	public java.util.List<RESTTweet> getTweets() {
		return tweets;
	}
	public void setTweets(java.util.List<RESTTweet> tweets) {
		this.tweets = tweets;
	}	
}
