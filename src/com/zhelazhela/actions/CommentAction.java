package com.zhelazhela.actions;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	private String validate_code;
	
	public String list() throws Exception{
		if(page<=0){
			page = 1;
		}
		//CommentList result = commentService.loadComment(comments.getDiscountInfoId(),pagesize, page);
		CommentList result = commentService.loadComment(comments.getDiscountInfoId(),-1, page);
		JSONObject jb = new JSONObject();
		jb.put("size", result.getSize());
		JSONArray ja = new JSONArray();
		ja.addAll(result.getList());
		jb.put("data", ja);
		setValue("json", jb.toString());
		return "json";
	}
	
	public String against() throws Exception{
		Comments result  = commentService.againstComment(c_id);
		JSONObject jb = new JSONObject();
		if(result!=null){
			jb.put("result", "success");
			jb.put("against", result.getAgainstTimes());
			jb.put("support", result.getSupportTimes());
		}else{
			jb.put("result", "fail");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	public String support() throws Exception{
		Comments result  = commentService.supportComment(c_id);
		JSONObject jb = new JSONObject();
		if(result!=null){
			jb.put("result", "success");
			jb.put("against", result.getAgainstTimes());
			jb.put("support", result.getSupportTimes());
		}else{
			jb.put("result", "fail");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	public String submit() throws Exception{
		if(comments==null){
			return null;
		}
		JSONObject jb = new JSONObject();
		if(validate_code==null||!validate_code.equals((String)getSession("comment_submit"))){
			this.clearSession("comment_submit");
			jb.put("msg", "您必须输入正确的验证码才能提交！");
			jb.put("result", "fail");
			setValue("json", jb.toString());
			return "json";
		}
		comments.setIpAddr(getHttpServletRequest().getRemoteAddr());
		if(StringUtils.isBlank(comments.getUserName())){
			comments.setUserName("匿名网友");
		}
		if(comments!=null&&comments.validate()){
			comments = commentService.saveComment(comments);
			jb.put("data", comments);
		}
		if(comments!=null){
			jb.put("result", "success");
			jb.put("msg", "评论成功");
		}else{
			jb.put("result", "fail");
			jb.put("msg", "评论失败");
		}
		setValue("json", jb.toString());
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

	public String getValidate_code() {
		return validate_code;
	}

	public void setValidate_code(String validateCode) {
		validate_code = validateCode;
	}
	
	
}
