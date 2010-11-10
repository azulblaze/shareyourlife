package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="providerList")
@XmlType(propOrder={"size","providers"})
public class RESTProviderList {

	private java.util.List<RESTProvider> providers;
	private int size;
	
	@XmlElement(name="providers")
	public java.util.List<RESTProvider> getProviders() {
		return providers;
	}
	public void setProviders(java.util.List<RESTProvider> providers) {
		this.providers = providers;
		this.size = providers.size();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
