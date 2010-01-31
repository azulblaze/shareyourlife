package com.zhelazhela.services;

import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.BlogComments;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.BlogQa;
import com.zhelazhela.db.model.Tags;
import com.zhelazhela.domain.AttachmentList;
import com.zhelazhela.domain.BlogDetailList;
import com.zhelazhela.domain.BlogQaList;

public interface BlogService {
	
	public BlogDetail saveBlog(BlogDetail record,String tags) throws Exception;
	
	public BlogDetail loadBlogDetail(long id) throws Exception;
	
	public BlogDetail updateBlogDetail(BlogDetail record,String tags) throws Exception;
	
	public BlogDetailList loadList(int page,int pagesize,String category,java.util.Date start,java.util.Date end,Boolean published,Boolean staticed) throws Exception;
	
	public BlogDetailList loadList(int page,int pagesize,String tag) throws Exception;
	
	public boolean publishBlog(long id,String rootpath) throws Exception;
	
	public boolean delBlog(long id) throws Exception;
	
	public BlogComments comment(BlogComments record) throws Exception;
	
	public java.util.List<BlogComments> loadComment(long id) throws Exception;
	
	public java.util.List<Tags> loadTopTags(int size) throws Exception;
	
	public java.util.List<String> loadCategorys() throws Exception;
	
	public void Question(BlogQa bq) throws Exception;
	
	public BlogQaList loadBlogQaList(int page,int pagesize) throws Exception;
	
	public boolean delQuestion(long id) throws Exception;
	
	public Attachments uploadPic(Attachments am, String path, String ext_type, java.io.File pic) throws Exception;
	
	public boolean delPic(long id,String path) throws Exception;
	
	public AttachmentList loadBlogPic(int page,int pagesize) throws Exception;
}
