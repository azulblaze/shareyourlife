package com.zhela.android.core.remote.model;

public class RESTCommentList {

	private java.util.List<RESTComment> comments;
	private int size;
	
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
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
