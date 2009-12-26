package com.zhelazhela.services.impl;

import java.util.List;

import com.zhelazhela.db.dao.CommentsDAO;
import com.zhelazhela.db.model.Comments;
import com.zhelazhela.db.model.CommentsExample;
import com.zhelazhela.domain.CommentList;
import com.zhelazhela.services.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentsDAO commentsDAO;
	
	@Override
	public Comments againstComment(long id) throws Exception {
		Comments comment = commentsDAO.selectByPrimaryKey(id);
		if(comment!=null){
			comment.setAgainstTimes(comment.getAgainstTimes()+1);
			commentsDAO.updateByPrimaryKey(comment);
			return comment;
		}
		return null;
	}

	@Override
	public boolean delComment(long id) throws Exception {
		int result  = commentsDAO.deleteByPrimaryKey(id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public CommentList loadComment(long n_id, int pageSize, int page) throws Exception {
		CommentsExample example = new CommentsExample();
		example.createCriteria().andDiscountInfoIdEqualTo(n_id);
		if(pageSize>0){
			example.setLimit(""+(page-1)*pageSize+","+pageSize);
		}
		List<Comments> list = commentsDAO.selectByExample(example);
		int size = commentsDAO.countByExample(example);
		CommentList cl = new CommentList();
		cl.setList(list);
		cl.setPage(page);
		cl.setPagesize(pageSize);
		cl.setSize(size);
		return cl;
	}

	@Override
	public Comments saveComment(Comments comments) throws Exception {
		long result = commentsDAO.insertSelectiveReturnId(comments);
		if(result>0){
			return commentsDAO.selectByPrimaryKey(result);
		}
		return null;
	}

	@Override
	public Comments supportComment(long id) throws Exception {
		Comments comment = commentsDAO.selectByPrimaryKey(id);
		if(comment!=null){
			comment.setSupportTimes(comment.getSupportTimes()+1);
			commentsDAO.updateByPrimaryKey(comment);
			return comment;
		}
		return null;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}

}
