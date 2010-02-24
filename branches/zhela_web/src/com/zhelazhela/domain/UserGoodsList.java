package com.zhelazhela.domain;

import com.zhelazhela.db.model.define.UserGoods;

public class UserGoodsList extends BaseList {
	
	private java.util.List<UserGoods> list;

	public java.util.List<UserGoods> getList() {
		return list;
	}

	public void setList(java.util.List<UserGoods> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
}
