package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="commentList")
public class RESTCommentList {

	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	private java.util.List<RESTComment> comments;
	private RESTTweet tweet;
	private long start;
	private int limit;
	private int size;
	
	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	@XmlElement(name="comments")
	public java.util.List<RESTComment> getComments() {
		return comments;
	}
	public void setComments(java.util.List<RESTComment> comments) {
		this.comments = comments;
		this.size = comments.size();
	}
	public RESTTweet getTweet() {
		return tweet;
	}
	public void setTweet(RESTTweet tweet) {
		this.tweet = tweet;
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
