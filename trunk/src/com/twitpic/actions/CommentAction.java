package com.twitpic.actions;

import com.twitpic.db.model.Comments;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormComment;
import com.twitpic.services.PictureService;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class CommentAction extends BaseAction {
	
	private PictureService pictureService;
	
	private FormComment formComment;
	
	private Long id_comment;
	
	private Long id_picture;
	
	private Integer i_page;
	
	private int page_size = 3;
	
	public Long getId_picture() {
		return id_picture;
	}

	public void setId_picture(Long idPicture) {
		id_picture = idPicture;
	}

	public Integer getI_page() {
		return i_page;
	}

	public void setI_page(Integer iPage) {
		i_page = iPage;
	}

	public void setPage_size(int pageSize) {
		page_size = pageSize;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	
	public FormComment getFormComment(){
		return formComment;
	}
	
	public void setFormComment(FormComment formComment){
		this.formComment = formComment;
	}
	
	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long idComment) {
		id_comment = idComment;
	}
	public String comment() throws Exception {
		if(formComment==null||formComment.getComment()==null||formComment.getComment().trim().length()<1||formComment.getId_pictures()==null||formComment.getId_pictures()<1){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"',message:'错误的请求'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		try{
			Account account = loadAccount();
			Comments comments = pictureService.comment(account, formComment);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'评论成功',data:'"+comments.to_json()+"'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'提交失败,"+e.getMessage()+"'}");
			return "json";
		}
		return "json";
	}
	
	public String delete_comment() throws Exception{
		if(id_comment!=null||id_comment.longValue()<1){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"',message:'错误的请求'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		try{
			Account account = loadAccount();
			pictureService.delComment(account, id_comment);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除成功'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除失败,"+e.getMessage()+"'}");
			return "json";
		}
		return "json";
	}
	
	public String load_comment() throws Exception{
		if(i_page==null||i_page.longValue()<1){
			i_page = 1;
		}
		if(id_picture==null||id_picture.longValue()<1){
			throw new Exception();
		}
		this.setValue("id_picture", id_picture);
		this.setValue("pages", (int)Math.ceil((float)pictureService.countComments(id_picture)/page_size));
		this.setValue("c_page", i_page);
		this.setValue("commentlist", pictureService.loadComments(id_picture, i_page, page_size));
		return SUCCESS;
	}
}
