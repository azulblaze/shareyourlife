package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="tweetList")
@XmlType(propOrder={"size","tweets"})
public class RESTTweetList {

	private java.util.List<RESTTweet> tweets;
	private int size;
	@XmlElement(name="tweets")
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
	
}
