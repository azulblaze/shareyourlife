package com.zhelazhela.services;

import com.zhelazhela.db.model.Comments;
import com.zhelazhela.domain.CommentList;

public interface CommentService {
	
	public Comments saveComment(Comments comments) throws Exception;
	
	public boolean delComment(Comments comments) throws Exception;
	
	public long supportComment(long id) throws Exception;
	
	public long againstComment(long id) throws Exception;
	
	public CommentList loadComment(int page_size,int page) throws Exception;
	
}
