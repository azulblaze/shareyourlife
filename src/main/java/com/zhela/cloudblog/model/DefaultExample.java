package com.zhela.cloudblog.model;

/**
 * some user define method,like limit
 * 
 */
public class DefaultExample {

	/**
	 * limit sql string
	 */
	protected String limit;

	protected String langue;

	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getLimit() {
		return limit;
	}

	/**
	 * you can set the limit string directly
	 * 
	 * @param limit
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}

	/**
	 * if you want to select page 2 and page size is 10, then use (2,10)
	 * 
	 * @param page
	 *            the page you selected
	 * @param pagesize
	 */
	public void setPage(int page, int pagesize) {
		if (page > 0 && pagesize > 0) {
			this.limit = "" + (page - 1) * pagesize + " ," + pagesize;
		}
	}
}
