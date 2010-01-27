package com.zhelazhela.domain;

public class BaseList {
	/** 当前页数 */
	protected int page;
	/** 每页数量 */
	protected int pagesize;
	/** 总数量 */
	protected int size;
	
	protected int c_size;

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

	public int getC_size() {
		return c_size;
	}

	public void setC_size(int cSize) {
		c_size = cSize;
	}
	
	
}
