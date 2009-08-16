package com.twitpic.domain;

import com.twitpic.db.model.BaseModel;
import com.twitpic.db.model.Comments;

public class CommentsInfo extends BaseModel{
	
	private Comments comments;
	
	private String name;

	private String account;

	private String picture;

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
