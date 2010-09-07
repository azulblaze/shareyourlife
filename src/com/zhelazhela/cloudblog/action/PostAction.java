package com.zhelazhela.cloudblog.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.zhelazhela.cloudblog.services.PostService;

@SuppressWarnings("serial")
public class PostAction extends BaseAction {
	private String id;
	private String text;
	private String max_id;
	private String min_id;
	private String count;
	private String to_user_id;
	private String is_some;
	private File pic;
	private String picContentType;
	private PostService postService;
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
	public String getMax_id() {
		return max_id;
	}
	public void setMax_id(String maxId) {
		max_id = maxId;
	}
	public String getMin_id() {
		return min_id;
	}
	public void setMin_id(String minId) {
		min_id = minId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	public String getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(String toUserId) {
		to_user_id = toUserId;
	}
	public String getIs_some() {
		return is_some;
	}
	public void setIs_some(String isSome) {
		is_some = isSome;
	}
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	public String delPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("postid", id);
		setValue(XML,postService.delpost(param));
		return SUCCESS;
	}
	
	public String delReply() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("replyid", id);
		setValue(XML,postService.delreply(param));
		return SUCCESS;
	}
	
	public String followPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		setValue(XML,postService.followpost(param));
		return SUCCESS;
	}
	
	public String forwardPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("forward_to_post_id", id);
		param.put("reply_to_user_id", to_user_id);
		param.put("post", text);
		param.put("is_reply", is_some);
		setValue(XML,postService.forward(param));
		return SUCCESS;
	}
	
	public String post() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("post", text);
		if(pic!=null){
			String pic_addr = "";
			param.put("pic", pic_addr);
		}
		setValue(XML,postService.post(param));
		return SUCCESS;
	}
	
	public String publicPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		setValue(XML,postService.publicpost(param));
		return SUCCESS;
	}
	
	public String replyPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("reply_to_post_id", id);
		param.put("reply_to_user_id", to_user_id);
		param.put("post", text);
		param.put("is_post", is_some);
		setValue(XML,postService.reply(param));
		return SUCCESS;
	}
	
	public String singlePost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("postid", id);
		setValue(XML,postService.singlelist(param));
		return SUCCESS;
	}
	
	public String userPost() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("userid", id);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		setValue(XML,postService.publicpost(param));
		return SUCCESS;
	}
	
	public String userReply() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		setValue(XML,postService.getreply(param));
		return SUCCESS;
	}
	
	public String sentReply() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		setValue(XML,postService.sentreply(param));
		return SUCCESS;
	}
	
	public String postReply() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("provider", provider);
		param.put("count", count);
		param.put("max_id", max_id);
		param.put("min_id", min_id);
		param.put("postid", id);
		setValue(XML,postService.postreply(param));
		return SUCCESS;
	}
}
