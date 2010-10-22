package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="providerList")
public class RESTProviderList {

	private java.util.List<RESTProvider> providers;
	private long start;
	private int limit;
	private int size;
	
	@XmlElement(name="providers")
	public java.util.List<RESTProvider> getProviders() {
		return providers;
	}
	public void setProviders(java.util.List<RESTProvider> providers) {
		this.providers = providers;
		this.size = providers.size();
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
