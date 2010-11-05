package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="commentList")
public class RESTCommentList {

	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	private java.util.List<RESTComment> comments;
	
	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	@XmlElement(name="comments")
	public java.util.List<RESTComment> getComments() {
		return comments;
	}
	public void setComments(java.util.List<RESTComment> comments) {
		this.comments = comments;
	}
	
	
}
