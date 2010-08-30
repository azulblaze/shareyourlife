package com.zhelazhela.cloudblog.domain;

public class ForwardResult extends BaseBean{

	public ForwardResult(){
		super("forwardresult");
	}
	
	private Post post;
	private Reply reply;

	/**
	 * 如果在转发的同时评论微博，该字段不为空
	 * @return
	 */
	public Reply getReply() {
		return reply;
	}
	/**
	 * 如果在转发的同时评论微博，该字段不为空
	 * @return
	 */
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
