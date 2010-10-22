package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="newsList")
public class RESTNewsList {
	private java.util.List<RESTNews> news;
	private long start;
	private int limit;
	private int size;
	public java.util.List<RESTNews> getNews() {
		return news;
	}
	public void setNews(java.util.List<RESTNews> news) {
		this.news = news;
		this.size = news.size();
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
