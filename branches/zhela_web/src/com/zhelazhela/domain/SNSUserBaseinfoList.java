package com.zhelazhela.domain;

public class SNSUserBaseinfoList extends BaseList{
	
	private java.util.List<SNSUserBaseinfo> list;

	public java.util.List<SNSUserBaseinfo> getList() {
		return list;
	}

	public void setList(java.util.List<SNSUserBaseinfo> list) {
		this.list = list;
		this.c_size = list.size();
	}

}
