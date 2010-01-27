package com.zhelazhela.domain;

import java.util.List;

import com.zhelazhela.db.model.Comments;

public class CommentList extends BaseList{
	/** 评论列表 */
	List<Comments> list;

	public List<Comments> getList() {
		return list;
	}

	public void setList(List<Comments> list) {
		this.list = list;
		this.c_size = list.size();
	}

}
