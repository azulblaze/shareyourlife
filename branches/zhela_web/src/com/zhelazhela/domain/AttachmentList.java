package com.zhelazhela.domain;

import com.zhelazhela.db.model.Attachments;

public class AttachmentList extends BaseList {
	
	private java.util.List<Attachments> list;

	public java.util.List<Attachments> getList() {
		return list;
	}

	public void setList(java.util.List<Attachments> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
	

}
