package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="comment")
public class RESTComment {

	private RESTTweet tweet;
	private RESTUser createUser;
	private java.util.Date createDate;
	private String source;
	private String content;
	public RESTTweet getTweet() {
		return tweet;
	}
	public void setTweet(RESTTweet tweet) {
		this.tweet = tweet;
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
	
	
}
