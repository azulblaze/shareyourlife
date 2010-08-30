package com.zhelazhela.cloudblog.domain;

public class ReplyResult extends BaseBean{
	
	public ReplyResult(){
		super("replyresult");
	}
	private Post reply_post;
	private Reply reply;

	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	/**
	 * 如果在回复的同时发布微博，该字段不为空
	 * @return
	 */
	public Post getReply_post() {
		return reply_post;
	}
	/**
	 * 如果在回复的同时发布微博，该字段不为空
	 * @param replyPost
	 */
	public void setReply_post(Post replyPost) {
		reply_post = replyPost;
	}
}
