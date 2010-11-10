package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="tweet")
@XmlType(propOrder={"id","commentCount","forwardCount","commentCount","forwardId","source","content","images","videos","displayDate","createDate","createUser","corrdinate","forwardTweet"})
public class RESTTweet {

	private RESTUser createUser;
	private String id;
	private java.util.Date createDate;
	private String displayDate;
	private String source;
	private String content;
	private RESTTweet forwardTweet;
	private long forwardId;
	private long commentCount;
	private long forwardCount;
	private RESTCommentList comments;
	private java.util.List<RESTImage> images;
	private java.util.List<RESTVideo> videos;
	private RESTCoordinate corrdinate;
	
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
	public long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	public long getForwardCount() {
		return forwardCount;
	}
	public void setForwardCount(long forwardCount) {
		this.forwardCount = forwardCount;
	}
	public RESTCommentList getComments() {
		return comments;
	}
	public void setComments(RESTCommentList comments) {
		this.comments = comments;
		if(comments!=null&&comments.getComments()!=null){
			this.commentCount = comments.getComments().size();
		}
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
	public RESTCoordinate getCorrdinate() {
		return corrdinate;
	}
	public void setCorrdinate(RESTCoordinate corrdinate) {
		this.corrdinate = corrdinate;
	}
	public long getForwardId() {
		return forwardId;
	}
	public void setForwardId(long forwardId) {
		this.forwardId = forwardId;
	}
	
	
		
}
