package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="news")
@XmlType(propOrder={"id","messages"})
public class RESTNews {

	private RESTProvider provider;
	private String title;
	private String content;
	private long id;
	private String tweetId;
	private String tweetName;
	private String tweetHeader;
	private long readCount;
	private long publishCount;
	private java.util.Date publishDate;
	private RESTCategoryList categories;

	public RESTProvider getProvider() {
		return provider;
	}
	public void setProvider(RESTProvider provider) {
		this.provider = provider;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getReadCount() {
		return readCount;
	}
	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}
	public long getPublishCount() {
		return publishCount;
	}
	public void setPublishCount(long publishCount) {
		this.publishCount = publishCount;
	}
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	public RESTCategoryList getCategories() {
		return categories;
	}
	public void setCategories(RESTCategoryList categories) {
		this.categories = categories;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTweetId() {
		return tweetId;
	}
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTweetName() {
		return tweetName;
	}
	public void setTweetName(String tweetName) {
		this.tweetName = tweetName;
	}
	public String getTweetHeader() {
		return tweetHeader;
	}
	public void setTweetHeader(String tweetHeader) {
		this.tweetHeader = tweetHeader;
	}
	
}
