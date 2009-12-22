package com.zhelazhela.domain;

import com.zhelazhela.db.model.DiscountNews;

public class DiscountNewsList {
	/** 当前页数 */
	private int page;
	/** 每页数量 */
	private int pagesize;
	/** 总数量 */
	private int size;
	/** 当前页数量 */
	private int c_size;
	
	private java.util.List<DiscountNews> list;

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

	public java.util.List<DiscountNews> getList() {
		return list;
	}

	public void setList(java.util.List<DiscountNews> list) {
		this.list = list;
		this.c_size = list.size();
	}

	public int getC_size() {
		return c_size;
	}

	public void setC_size(int cSize) {
		c_size = cSize;
	}
	
	
}
