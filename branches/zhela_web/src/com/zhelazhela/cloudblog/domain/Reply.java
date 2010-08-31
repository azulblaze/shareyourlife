package com.zhelazhela.cloudblog.domain;

public class Reply {

	private String created_at;
	private String id;
	private String text;
	private String source;
	private User user;
	private Post post;
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String createdAt) {
		created_at = createdAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 回复的微薄
	 * @return
	 */
	public Post getPost() {
		return post;
	}
	/**
	 * 回复的微薄
	 * @param post
	 */
	public void setPost(Post post) {
		this.post = post;
	}
	
}
