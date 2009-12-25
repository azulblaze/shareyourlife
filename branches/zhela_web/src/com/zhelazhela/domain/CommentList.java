package com.zhelazhela.domain;

import java.util.List;

import com.zhelazhela.db.model.Comments;

public class CommentList {
	/** 评论列表 */
	List<Comments> list;
	/** 当前页数 */
	private int page;
	/** 每页数量 */
	private int pagesize;
	/** 总数量 */
	private int size;
	
	private int c_size;

	public List<Comments> getList() {
		return list;
	}

	public void setList(List<Comments> list) {
		this.list = list;
		this.c_size = list.size();
	}

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
