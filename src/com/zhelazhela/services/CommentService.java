package com.zhelazhela.services;

import com.zhelazhela.db.model.Comments;
import com.zhelazhela.domain.CommentList;

public interface CommentService {
	
	public Comments saveComment(Comments comments) throws Exception;
	
	public boolean delComment(long id) throws Exception;
	
	public Comments supportComment(long id) throws Exception;
	
	public Comments againstComment(long id) throws Exception;
	
	public CommentList loadComment(long n_id, int page_size,int page) throws Exception;
	
}
