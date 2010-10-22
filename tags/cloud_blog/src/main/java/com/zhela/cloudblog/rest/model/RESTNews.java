package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="news")
public class RESTNews {

	private RESTProvider provider;
	private RESTUser publisher;
	private String content;
	private long id;
	private String tweetId;
	private java.util.List<RESTImage> images;
	private java.util.List<RESTVideo> videos;
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
	public RESTUser getPublisher() {
		return publisher;
	}
	public void setPublisher(RESTUser publisher) {
		this.publisher = publisher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	
	
}
