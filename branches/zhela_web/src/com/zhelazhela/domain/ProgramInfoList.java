package com.zhelazhela.domain;

import java.util.List;

import com.zhelazhela.db.model.ProgramInfo;

public class ProgramInfoList extends BaseList{
	
	private List<ProgramInfo> list;

	public List<ProgramInfo> getList() {
		return list;
	}

	public void setList(List<ProgramInfo> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
}
