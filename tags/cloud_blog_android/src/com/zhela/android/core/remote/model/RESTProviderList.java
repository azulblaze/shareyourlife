package com.zhela.android.core.remote.model;

public class RESTProviderList {

	private java.util.List<RESTProvider> providers;
	private int size;
	
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
