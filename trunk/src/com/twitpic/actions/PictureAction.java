package com.twitpic.actions;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.twitpic.db.model.Comments;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormComment;
import com.twitpic.domain.PictureInfo;
import com.twitpic.services.PictureService;
import com.twitpic.util.CommonMethod;
import com.twitpic.util.ConsVar;

/**
 * <code>PictureAction.java</code>
 * 
 * @version 1.0, 2009-8-3
 */
@SuppressWarnings("serial")
public class PictureAction extends BaseAction {
	private File pic;
	private String picContentType;
	private String description;
	private String title;
	private PictureService pictureService;
	private FormComment formComment;
	private Long id_picture;
	

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	
	public void setPic(File pic) {
		this.pic = pic;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public FormComment getFormComment(){
		return formComment;
	}
	
	public void setFormComment(FormComment formComment){
		this.formComment = formComment;
	}
	
	public Long getId_picture() {
		return id_picture;
	}
	public void setId_picture(Long id_picture) {
		this.id_picture = id_picture;
	}
	
	public String upload() throws Exception{
		if(!isLogin()){
			return LOGIN;
		}
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		String submit = this.getRequestParameter("submit");
		if(submit==null||!submit.equals("true")){
			return INPUT;
		}
		try{
			String ext_type = CommonMethod.getInstance().isAllowedPicture(picContentType);
			if(ext_type==null){
				this.addActionError("不支持您上传的文件格式");
				return INPUT;
			}
			System.out.println("file size:"+pic.length());
			Account user = (Account)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
			pictureService.savePicture(user, root_path, pic, ext_type, description,title);
			return SUCCESS;
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
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

	
	public String single_pic() throws Exception{
		if(id_picture!=null&&id_picture.longValue()>0){
			try{
				PictureInfo pi = pictureService.loadPicture(id_picture);
				this.setValue("picture", pi);
			}catch(Exception e){
				this.addActionError(e.getMessage());
			}
			return SUCCESS;
		}
		return ERROR;
	}

}
