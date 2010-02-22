package com.zhelazhela.domain;

import com.zhelazhela.db.model.define.UserComment;

public class GoodCommentList extends BaseList {

	private java.util.List<UserComment> list;

	public java.util.List<UserComment> getList() {
		return list;
	}

	public void setList(java.util.List<UserComment> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
	
}
