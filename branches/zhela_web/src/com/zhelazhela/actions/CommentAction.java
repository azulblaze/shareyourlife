package com.zhelazhela.actions;

import com.zhelazhela.domain.CommentList;
import com.zhelazhela.services.CommentService;
import com.zhelazhela.db.model.Comments;

@SuppressWarnings("serial")
public class CommentAction extends BaseAction {
	
	private CommentService commentService;
	/** 当前页数 */
	private int page;
	/** 每页显示数量 */
	private int pagesize;
	/** 评论唯一ID */
	private long c_id;
	/** 评论信息 */
	private Comments comments;
	
	public String list() throws Exception{
		if(page<=0){
			page = 1;
		}
		CommentList result = commentService.loadComment(comments.getDiscountInfoId(),pagesize, page);
		setValue("result", result);
		return "json";
	}
	
	public String against() throws Exception{
		long result  = commentService.againstComment(c_id);
		setValue("result", result);
		return "json";
	}
	
	public String support() throws Exception{
		long result  = commentService.supportComment(c_id);
		setValue("result", result);
		return "json";
	}
	
	public String submit() throws Exception{
		if(comments==null){
			return null;
		}
		if(comments!=null&&comments.validate()){
			comments = commentService.saveComment(comments);
		}
		setValue("result",comments);
		return "json";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long cId) {
		c_id = cId;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
}
