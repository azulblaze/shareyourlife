package com.twitpic.actions;

import java.io.File;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.twitpic.domain.Account;
import com.twitpic.domain.PictureInfo;
import com.twitpic.services.PictureService;
import com.twitpic.services.TagService;
import com.twitpic.system.struts.ProgressMonitor;
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
	private TagService tagService;
	private Long id_picture;
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
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
	
	
	public Long getId_picture() {
		return id_picture;
	}
	public void setId_picture(Long id_picture) {
		this.id_picture = id_picture;
	}
	
	public String upload() throws Exception{
		String file_tag = this.getRequestParameter(ProgressMonitor.SESSION_FILE_TAG);
		if(file_tag==null){
			file_tag = "";
		}else{
			file_tag = file_tag.trim();
		}
		String submit = this.getRequestParameter("submit");
		//if this is load the upload input page
		if(submit==null||!submit.equals("true")){
			clearSession(ProgressMonitor.SESSION_PROGRESS_MONITOR+file_tag);
			if(!isLogin()){
				return LOGIN;
			}
			return INPUT;
		}
		//now we start to deal the file upload,and return JSON object
		ProgressMonitor pm = (ProgressMonitor)getHttpSession().getAttribute(ProgressMonitor.SESSION_PROGRESS_MONITOR+file_tag);
		if(!isLogin()){
			return null;
		}
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		try{
			String ext_type = CommonMethod.getInstance().isAllowedPicture(picContentType);
			if(ext_type==null){
				if(pm!=null){
					pm.setStatus("fail");
					pm.setStatus_msg("不支持您上传的格式");
				}
				return null;
			}
			Account user = (Account)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
			PictureInfo pi = pictureService.savePicture(user, root_path, pic, ext_type, description,title);
			pm.setStatus("done");
			pm.setPictureInfo(pi);
			return null;
		}catch(Exception e){
			pm.setStatus("exception");
			pm.setStatus_msg(e.getMessage());
			return null;
		}
	}
	
	public String single_pic() throws Exception{
		if(id_picture!=null&&id_picture.longValue()>0){
			try{
				PictureInfo pi = pictureService.loadPicture(id_picture);
				this.setValue("picture", pi);
				this.setValue("comments_count", pictureService.countComments(id_picture));
				this.setValue("tags", tagService.load_picture_tag(id_picture, null, null));
			}catch(Exception e){
				this.addActionError(e.getMessage());
				return ERROR;
			}
			return SUCCESS;
		}
		return ERROR;
	}

	public String delete_pic() throws Exception{
		if(id_picture==null||id_picture.longValue()<1){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"',message:'错误的请求'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		try{
			Account account = loadAccount();
			String root_path = ServletActionContext.getServletContext().getRealPath("/");
			pictureService.delPicture(account, id_picture, root_path);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除成功'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'删除失败,"+e.getMessage()+"'}");
			return "json";
		}
		return "json";
	}
	
	public String upload_info() throws Exception{
		/**
		 * JSON obj: state:uploading,done,error   received  size   percents
		 */
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do',state:'error',msg:'请登录后再上传图片'}");
		}
		String file_tag = this.getRequestParameter(ProgressMonitor.SESSION_FILE_TAG);
		if(file_tag==null){
			file_tag = "";
		}else{
			file_tag = file_tag.trim();
		}
		String clear = this.getRequestParameter("clear");
		if(clear!=null&&clear.equals("true")){
			clearSession(ProgressMonitor.SESSION_PROGRESS_MONITOR+file_tag);
			return null;
		}
		ProgressMonitor pm = (ProgressMonitor)getHttpSession().getAttribute(ProgressMonitor.SESSION_PROGRESS_MONITOR+file_tag);
		if(pm!=null){
			JSONObject jo = new JSONObject();
			if(pm.getStatus()==null){
				jo.put("status","unloaded");
			}else{
				jo.put("status",pm.getStatus());
			}
			jo.put("msg", pm.getStatus_msg());
			if(pm.getPictureInfo()!=null){
				jo.put("id_picture", pm.getPictureInfo().getPictures().getId());
				jo.put("min", pm.getPictureInfo().getPictures().getMin());
				jo.put("thumb", pm.getPictureInfo().getPictures().getThumb());
				jo.put("large", pm.getPictureInfo().getPictures().getLarge());
				jo.put("full", pm.getPictureInfo().getPictures().getFull());
			}else{
				jo.put("id_picture", "-1");
			}
			if(!pm.percentComplete().equals("100")){
				this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'上传中...',state:'uploading',size:'"
						+pm.getBytesLength()+"',received:'"+pm.getBytesRead()
						+"',percents:'"+pm.percentComplete()+"',picture:"+jo.toString()+"}");
			}
			if(pm.percentComplete().equals("100")){
				String note_msg = null;
				if(pm.getStatus()!=null&&pm.getStatus().equals("done")){
					note_msg = "上传成功";
				}else{
					note_msg = "上传成功，正在为图片生成缩略图";
				}
				this.setValue(ConsVar.REQUEST_JSON, "{\"action\":\""+ConsVar.JSON_ACTION_NOTICE+"\",\""+ConsVar.JSON_ACTION_NOTICE_MSG+"\":\""+note_msg+"\",\"state\":\"done\",\"size\":\""
						+pm.getBytesLength()+"\",\"received\":\""+pm.getBytesRead()
						+"\",\"percents\":\""+pm.percentComplete()+"\",\"picture\":"+jo.toString()+"}");
			}
		}else{
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"',state:'error',message:'没有上传文件'}");
		}
		return "json";
	}
	
	public String view_times()throws Exception{
		String back_url = (String)getHttpServletRequest().getHeader("Referer");
		if(back_url!=null&&back_url.trim().length()>0){
			if(id_picture!=null&&id_picture>0){
				this.setValue("json", "{info:"+pictureService.add_view_times(id_picture)+"}");
				return "json";
			}
		}
		return "error";
	}
}
