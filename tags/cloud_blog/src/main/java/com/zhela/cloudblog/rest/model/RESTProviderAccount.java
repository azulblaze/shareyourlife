package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="providerAccount")
public class RESTProviderAccount {

	private long providerId;
	private String providerAccount;
	private int status;
	private String token;
	private String tokenSecret;
	private String tokenMore;
	private java.util.Date updateTime;
	public long getProviderId() {
		return providerId;
	}
	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}
	public String getProviderAccount() {
		return providerAccount;
	}
	public void setProviderAccount(String providerAccount) {
		this.providerAccount = providerAccount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}
	public String getTokenMore() {
		return tokenMore;
	}
	public void setTokenMore(String tokenMore) {
		this.tokenMore = tokenMore;
	}
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
