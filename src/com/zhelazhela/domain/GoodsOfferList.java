package com.zhelazhela.domain;

import com.zhelazhela.db.model.define.UserPrice;

public class GoodsOfferList extends BaseList {
	private java.util.List<UserPrice> list;

	public java.util.List<UserPrice> getList() {
		return list;
	}

	public void setList(java.util.List<UserPrice> list) {
		this.list = list;
		this.c_size = list.size();
	}
}
