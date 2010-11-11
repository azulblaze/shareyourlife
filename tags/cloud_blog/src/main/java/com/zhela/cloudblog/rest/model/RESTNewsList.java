package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="newsList")
@XmlType(propOrder={"start","limit","size","newses"})
public class RESTNewsList {
	private java.util.List<RESTNews> newses;
	private long start;
	private int limit;
	private int size;
	
	public java.util.List<RESTNews> getNewses() {
		return newses;
	}
	public void setNewses(java.util.List<RESTNews> newses) {
		this.newses = newses;
		this.size = newses.size();
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
