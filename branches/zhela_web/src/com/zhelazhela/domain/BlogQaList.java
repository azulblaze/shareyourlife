package com.zhelazhela.domain;

import com.zhelazhela.db.model.BlogQa;

public class BlogQaList extends BaseList {
	
	private java.util.List<BlogQa> list;

	public java.util.List<BlogQa> getList() {
		return list;
	}

	public void setList(java.util.List<BlogQa> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
}
