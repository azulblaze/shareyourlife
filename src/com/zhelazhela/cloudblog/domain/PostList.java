package com.zhelazhela.cloudblog.domain;

public class PostList extends BaseList {

	public PostList(){
		super("postlist");
	}
	public java.util.List<Post> posts;
	public java.util.List<Post> getPosts() {
		return posts;
	}
	public void setPosts(java.util.List<Post> posts) {
		this.posts = posts;
	}
}
