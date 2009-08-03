package com.twitpic.actions;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.twitpic.db.model.Users;
import com.twitpic.services.PictureService;
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
	private String picFileName;
	private String imageFileName;
	private String description;
	private PictureService pictureService;
	

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	
	public void setPic(File pic) {
		this.pic = pic;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public String getImageFileName() {
		return imageFileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
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
			System.out.println(picContentType);
			Users user = (Users)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
			pictureService.savePicture(user, root_path, pic, getExtention(picFileName), description);
			return SUCCESS;
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
	}
}
