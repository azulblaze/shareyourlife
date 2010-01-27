package com.zhelazhela.services;

import com.zhelazhela.db.model.BlogComments;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.domain.BlogDetailList;

public interface BlogService {
	
	public BlogDetail saveBlog(BlogDetail record) throws Exception;
	
	public BlogDetail loadBlogDetail(long id) throws Exception;
	
	public BlogDetail updateBlogDetail(BlogDetail record) throws Exception;
	
	public BlogDetailList loadList(int page,int pagesize,String category,java.util.Date start,java.util.Date end) throws Exception;
	
	public BlogDetailList loadList(int page,int pagesize,String tag) throws Exception;
	
	public boolean publishBlog(long id) throws Exception;
	
	public boolean delBlog(long id) throws Exception;
	
	public BlogComments comment(BlogComments record) throws Exception;
	
	public java.util.List<BlogComments> loadComment(long id) throws Exception;
}
