package com.zhelazhela.domain;

import java.util.List;

import com.zhelazhela.db.model.BlogDetail;

public class BlogDetailList extends BaseList{
	
	private List<BlogDetail> list;

	public List<BlogDetail> getList() {
		return list;
	}

	public void setList(List<BlogDetail> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
}
