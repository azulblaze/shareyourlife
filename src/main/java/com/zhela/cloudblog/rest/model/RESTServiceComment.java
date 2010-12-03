package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@XmlRootElement(name="s_comment")
public class RESTServiceComment {
	private long id;
	private String username;
	private String userheader;
	private String content;
	private java.util.Date update_time;
	public String loadJSON(){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
	    .create();
		String result = gson.toJson(this);
		return StringUtils.replace(result,"\\","\\\\");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserheader() {
		return userheader;
	}
	public void setUserheader(String userheader) {
		this.userheader = userheader;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(java.util.Date updateTime) {
		update_time = updateTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
