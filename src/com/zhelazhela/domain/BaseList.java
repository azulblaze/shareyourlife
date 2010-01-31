package com.zhelazhela.domain;

public class BaseList {
	/** 当前页数 */
	protected int page;
	/** 总页数 */
	protected int allpage;
	/** 每页数量 */
	protected int pagesize;
	/** 总数量 */
	protected int size;
	
	protected int c_size;
	
	protected void countPage(){
		if(pagesize>0&&size>0){
			this.allpage = size/pagesize;
			if(size%pagesize>0){
				this.allpage = this.allpage + 1;
			}
		}else{
			allpage = 0;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAllpage() {
		return allpage;
	}

	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
		countPage();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		countPage();
	}

	public int getC_size() {
		return c_size;
	}

	public void setC_size(int cSize) {
		c_size = cSize;
	}
	
	
}
