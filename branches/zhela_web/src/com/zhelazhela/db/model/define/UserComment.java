package com.zhelazhela.db.model.define;

public class UserComment {
	private long id;
	private long reply_id;
	private long goods_id;
	private String goods_sn;
	private String content;
	private java.util.Date comment_time;
	private Long user_id;
	private String user_name;
	private String avatar;
	private UserComment reply_uc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReply_id() {
		return reply_id;
	}

	public void setReply_id(long replyId) {
		reply_id = replyId;
	}

	public long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(long goodsId) {
		goods_id = goodsId;
	}

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(java.util.Date commentTime) {
		comment_time = commentTime;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserComment getReply_uc() {
		return reply_uc;
	}

	public void setReply_uc(UserComment replyUc) {
		reply_uc = replyUc;
	}

}
