package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tweet")
public class RESTTweet {

	private RESTProvider provider;
	private RESTUser createUser;
	private String id;
	private java.util.Date createDate;
	private String displayDate;
	private String source;
	private String content;
	private RESTTweet forwardTweet;
	private int commentCount;
	private int forwardCount;
	private RESTCommentList comments;
	private java.util.List<RESTImage> images;
	private java.util.List<RESTVideo> videos;
	
	public RESTProvider getProvider() {
		return provider;
	}
	public void setProvider(RESTProvider provider) {
		this.provider = provider;
	}
	public RESTUser getCreateUser() {
		return createUser;
	}
	public void setCreateUser(RESTUser createUser) {
		this.createUser = createUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public RESTTweet getForwardTweet() {
		return forwardTweet;
	}
	public void setForwardTweet(RESTTweet forwardTweet) {
		this.forwardTweet = forwardTweet;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getForwardCount() {
		return forwardCount;
	}
	public void setForwardCount(int forwardCount) {
		this.forwardCount = forwardCount;
	}
	public RESTCommentList getComments() {
		return comments;
	}
	public void setComments(RESTCommentList comments) {
		this.comments = comments;
	}
	public java.util.List<RESTImage> getImages() {
		return images;
	}
	public void setImages(java.util.List<RESTImage> images) {
		this.images = images;
	}
	public java.util.List<RESTVideo> getVideos() {
		return videos;
	}
	public void setVideos(java.util.List<RESTVideo> videos) {
		this.videos = videos;
	}
	public String getDisplayDate() {
		return displayDate;
	}
	
		
}
