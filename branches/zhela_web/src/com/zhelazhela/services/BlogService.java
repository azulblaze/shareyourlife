package com.zhelazhela.services;

import com.zhelazhela.db.model.BlogDetail;

public interface BlogService {
	
	public BlogDetail saveBlog(BlogDetail record) throws Exception;
	
	public BlogDetail loadBlogDetail(long id) throws Exception;
	
	public BlogDetail updateBlogDetail(BlogDetail record) throws Exception;
	
	
}
