package com.zhelazhela.services.impl;

import java.util.Date;
import java.util.List;

import com.zhelazhela.db.dao.BlogCommentsDAO;
import com.zhelazhela.db.dao.BlogDetailDAO;
import com.zhelazhela.db.dao.BlogTagDAO;
import com.zhelazhela.db.dao.TagsDAO;
import com.zhelazhela.db.model.BlogComments;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.domain.BlogDetailList;
import com.zhelazhela.services.BlogService;

public class BlogServiceImpl implements BlogService {

	private BlogDetailDAO blogDetailDAO;
	
	private BlogTagDAO blogTagDAO;
	
	private BlogCommentsDAO blogCommentsDAO;
	
	private TagsDAO tagsDAO;
	
	public void setBlogDetailDAO(BlogDetailDAO blogDetailDAO) {
		this.blogDetailDAO = blogDetailDAO;
	}

	public void setBlogTagDAO(BlogTagDAO blogTagDAO) {
		this.blogTagDAO = blogTagDAO;
	}

	public void setBlogCommentsDAO(BlogCommentsDAO blogCommentsDAO) {
		this.blogCommentsDAO = blogCommentsDAO;
	}

	public void setTagsDAO(TagsDAO tagsDAO) {
		this.tagsDAO = tagsDAO;
	}

	@Override
	public boolean delBlog(long id) throws Exception {
		if(blogDetailDAO.deleteByPrimaryKey(id)>0){
			return true;
		}
		return false;
	}

	@Override
	public BlogDetail loadBlogDetail(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogDetailList loadList(int page, int pagesize, String category,
			Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean publishBlog(long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlogDetail saveBlog(BlogDetail record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogDetail updateBlogDetail(BlogDetail record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogComments comment(BlogComments record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogComments> loadComment(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogDetailList loadList(int page, int pagesize, String tag)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
