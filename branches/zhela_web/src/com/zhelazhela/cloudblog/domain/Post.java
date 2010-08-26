package com.zhelazhela.cloudblog.domain;

public class Post {

	private String created_at;
	private String id;
	private String text;
	private String source;
	private String truncated;
	private String reply_to_post_id;
	private String reply_to_user_id;
	private String reply_to_display_name;
	private String thumb_pic;
	private String middle_pic;
	private String orignal_pic;
	private User user;
	private Post forward_post;
	
	/**
	 * 发布时间
	 * @return
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * 发布时间
	 * @return
	 */
	public void setCreated_at(String createdAt) {
		created_at = createdAt;
	}
	/**
	 * 唯一ID
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 唯一ID
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 微薄内容
	 * @return
	 */
	public String getText() {
		return text;
	}
	/**
	 * 微薄内容
	 * @return
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 来源
	 * @return
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 来源
	 * @return
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 是否截断
	 * @return
	 */
	public String getTruncated() {
		return truncated;
	}
	/**
	 * 是否截断
	 * @return
	 */
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	/**
	 * 回复的微薄ID，可选项
	 * @return
	 */
	public String getReply_to_post_id() {
		return reply_to_post_id;
	}
	/**
	 * 回复的微薄ID，可选项
	 * @return
	 */
	public void setReply_to_post_id(String replyToPostId) {
		reply_to_post_id = replyToPostId;
	}
	/**
	 * 回复的微薄的作者ID，可选项，如果要支持，必须在text的内容里面包含 \@字段
	 * @return
	 */
	public String getReply_to_user_id() {
		return reply_to_user_id;
	}
	/**
	 * 回复的微薄的作者ID，可选项，如果要支持，必须在text的内容里面包含 \@字段
	 * @return
	 */
	public void setReply_to_user_id(String replyToUserId) {
		reply_to_user_id = replyToUserId;
	}
	/**
	 * 回复的微薄的作者名字，可选项，如果要支持，必须在text的内容里面包含 \@字段
	 * @return
	 */
	public String getReply_to_display_name() {
		return reply_to_display_name;
	}
	/**
	 * 回复的微薄的作者名字，可选项，如果要支持，必须在text的内容里面包含 \@字段
	 * @return
	 */
	public void setReply_to_display_name(String replyToDisplayName) {
		reply_to_display_name = replyToDisplayName;
	}
	/**
	 * 内容包含的图像，缩略图
	 * @return
	 */
	public String getThumb_pic() {
		return thumb_pic;
	}
	/**
	 * 内容包含的图像，缩略图
	 * @return
	 */
	public void setThumb_pic(String thumbPic) {
		thumb_pic = thumbPic;
	}
	/**
	 * 内容包含的图像，中等图片
	 * @return
	 */
	public String getMiddle_pic() {
		return middle_pic;
	}
	/**
	 * 内容包含的图像，中等图片
	 * @return
	 */
	public void setMiddle_pic(String middlePic) {
		middle_pic = middlePic;
	}
	/**
	 * 内容包含的图像，原始图片
	 * @return
	 */
	public String getOrignal_pic() {
		return orignal_pic;
	}
	/**
	 * 内容包含的图像，原始图片
	 * @return
	 */
	public void setOrignal_pic(String orignalPic) {
		orignal_pic = orignalPic;
	}
	/**
	 * 作者
	 * @return
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 作者
	 * @return
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 包含的转发的微薄
	 * @return
	 */
	public Post getForward_post() {
		return forward_post;
	}
	/**
	 * 包含的转发的微薄
	 * @return
	 */
	public void setForward_post(Post forwardPost) {
		forward_post = forwardPost;
	}
	
}
