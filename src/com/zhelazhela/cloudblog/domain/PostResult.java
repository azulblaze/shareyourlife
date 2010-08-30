package com.zhelazhela.cloudblog.domain;

public class PostResult extends BaseBean {

	public PostResult(){
		super("postresult");
	}
	
	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
