package com.zhelazhela.domain;

import com.zhelazhela.db.model.DiscountNews;

public class DiscountNewsList extends BaseList{
	
	private java.util.List<DiscountNews> list;

	public java.util.List<DiscountNews> getList() {
		return list;
	}

	public void setList(java.util.List<DiscountNews> list) {
		this.list = list;
		this.c_size = list.size();
		for(DiscountNews dn:list){
			dn.removeFatherStr();
		}
	}
	
	
}
