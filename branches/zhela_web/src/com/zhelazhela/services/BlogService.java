package com.zhelazhela.services;

import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.domain.BlogDetailList;

public interface BlogService {
	
	public BlogDetail saveBlog(BlogDetail record) throws Exception;
	
	public BlogDetail loadBlogDetail(long id) throws Exception;
	
	public BlogDetail updateBlogDetail(BlogDetail record) throws Exception;
	
	public BlogDetailList loadList(int page,int pagesize,String category,java.util.Date start,java.util.Date end) throws Exception;
	
	
}
