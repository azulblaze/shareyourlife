package com.twitpic.actions;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.twitpic.domain.Account;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
			pictureService.savePicture(user, root_path, pic, ext_type, description);
			return SUCCESS;
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
	}
}
