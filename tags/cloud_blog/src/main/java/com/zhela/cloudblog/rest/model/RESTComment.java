package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="comment")
public class RESTComment {

	private String tweetId;
	private String replyUserId;
	private String replyUserName;
	private RESTUser createUser;
	private java.util.Date createDate;
	private String source;
	private String content;
	private String id;
	private RESTCoordinate coordinate;
	
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	public String getReplyUserName() {
		return replyUserName;
	}
	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}
	public RESTUser getCreateUser() {
		return createUser;
	}
	public void setCreateUser(RESTUser createUser) {
		this.createUser = createUser;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RESTCoordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(RESTCoordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
}
