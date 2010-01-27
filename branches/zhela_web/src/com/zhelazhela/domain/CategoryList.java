package com.zhelazhela.domain;

import com.zhelazhela.db.model.MerchandiseCategory;

public class CategoryList extends BaseList{
	
	java.util.List<MerchandiseCategory> list;

	public java.util.List<MerchandiseCategory> getList() {
		return list;
	}

	public void setList(java.util.List<MerchandiseCategory> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
	
}
