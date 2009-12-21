package com.zhelazhela.domain;

import java.util.List;

import com.zhelazhela.db.model.ProgramInfo;

public class ProgramInfoList {
	/** 当前页数 */
	private int page;
	/** 每页数量 */
	private int pagesize;
	/** 总数量 */
	private int size;
	
	private List<ProgramInfo> list;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<ProgramInfo> getList() {
		return list;
	}

	public void setList(List<ProgramInfo> list) {
		this.list = list;
	}
	
	
}
