package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="commentList")
@XmlType(propOrder={"size","comments"})
public class RESTCommentList {

	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	private java.util.List<RESTComment> comments;
	private int size;
	
	/**
	 * because this is list for one tweet, so no need to add tweet for every comment
	 */
	@XmlElement(name="comments")
	public java.util.List<RESTComment> getComments() {
		return comments;
	}
	public void setComments(java.util.List<RESTComment> comments) {
		this.comments = comments;
		if(comments!=null){
			this.size = comments.size();
		}
	}
	public int getSize() {
		return size;
	}
	
	
}
