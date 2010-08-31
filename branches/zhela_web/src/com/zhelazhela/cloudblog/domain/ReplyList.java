package com.zhelazhela.cloudblog.domain;

public class ReplyList extends BaseList {

	public ReplyList(){
		super("replylist");
	}
	
	public java.util.List<Reply> replys;
	
	public java.util.List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(java.util.List<Reply> replys) {
		this.replys = replys;
	}
	
}
