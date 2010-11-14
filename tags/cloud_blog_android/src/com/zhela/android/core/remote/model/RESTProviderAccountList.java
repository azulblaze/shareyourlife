package com.zhela.android.core.remote.model;

public class RESTProviderAccountList {

	private java.util.List<RESTProviderAccount> providerAccounts;
	private int size;
	public java.util.List<RESTProviderAccount> getProviderAccounts() {
		return providerAccounts;
	}
	public void setProviderAccounts(
			java.util.List<RESTProviderAccount> providerAccounts) {
		this.providerAccounts = providerAccounts;
		this.size = providerAccounts.size();
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
