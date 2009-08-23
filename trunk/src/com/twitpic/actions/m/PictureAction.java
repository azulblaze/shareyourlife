package com.twitpic.actions.m;

import java.io.File;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.twitpic.actions.BaseAction;
import com.twitpic.db.model.Comments;
import com.twitpic.db.model.Tags;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormComment;
import com.twitpic.domain.FormMoreComments;
import com.twitpic.domain.FormTag;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.domain.PictureInfo;
import com.twitpic.services.MessageService;
import com.twitpic.services.MobilePictureService;
import com.twitpic.services.PictureService;
import com.twitpic.services.impl.MobilePictureServiceImpl;
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
	
	private static Logger LOGGER = Logger.getLogger(PictureAction.class);
	
	private File pic;
	private String picContentType;
	private String description;
	private String title;
	private PictureService pictureService;
	private FormComment formComment;
	private FormTag formTag;
	private FormMoreComments formMoreComments;
	
	/**
	 * 更多标签页面中一页标签列表的记录数目,默认为10条
	 */
	private Integer more_tags_page_count = 10;
	
	public void setMoreTagsPageCount(Integer _count){
		this.more_tags_page_count = _count;
	}
	public Integer getMoreTagsPageCount(){
		return this.more_tags_page_count;
	}
	
	public FormMoreComments getFormMoreComments() {
		return formMoreComments;
	}

	public void setFormMoreComments(FormMoreComments formMoreComments) {
		this.formMoreComments = formMoreComments;
	}

	private Long id_picture;
	private Long id_comment;
	
	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long idComment) {
		id_comment = idComment;
	}

	public void setMobilePictureService(PictureService pictureService) {
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
	public FormTag getFormTag(){
		return formTag;
	}
	public void setFormTag(FormTag formTag){
		this.formTag = formTag;
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
				this.addActionMessage("请先登录");
				return ActionConstant.ACTION_RETURN_MSG_BOX;
			}
			return INPUT;
		}
		if(!isLogin()){
			return null;
		}
		String root_path = ServletActionContext.getServletContext().getRealPath("/");
		try{
			String ext_type = CommonMethod.getInstance().isAllowedPicture(picContentType);
			if(ext_type==null){
				this.addActionMessage("不支持您上传的格式");
				return ActionConstant.ACTION_RETURN_MSG_BOX;
			}
			Account user = (Account)this.getHttpSession().getAttribute(ConsVar.SESSION_USER);
			PictureInfo pi = pictureService.savePicture(user, root_path, pic, ext_type, description,title);
			this.addActionMessage("恭喜,上传成功");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}catch(Exception e){
			LOGGER.error("手机图片上传失败, "+e.getMessage(), e);
			this.addActionMessage("上传失败,请联系网站管理员");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
	}
	
	public String comment() throws Exception {
		if(formComment==null||formComment.getComment()==null||formComment.getComment().trim().length()<1||formComment.getId_pictures()==null||formComment.getId_pictures()<1){
			this.addActionMessage("错误的请求");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		if(!isLogin()){
			this.addActionMessage("请先登录后在发表评论");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		try{
			Account account = loadAccount();
			Comments comments = pictureService.comment(account, formComment);
		}catch(Exception e){
			LOGGER.error( "评论提交失败, "+ e.getMessage(), e);
			this.addActionMessage("发表评论失败, 请联系网站管理员");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		

		this.addActionMessage("恭喜,发表评论成功");
		return ActionConstant.ACTION_RETURN_MSG_BOX;
	}
	
	public String more_comments() throws Exception{
		
		if(!isLogin()){
			this.addActionMessage("请先登录后在才能评论");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}		
		
		// 检查该请求的输入参数是否合法, 如果pageIndex没有输入,那么
		// 默认为使用第一个页面(索引为0的页面)
		if( formMoreComments == null ||
			formMoreComments.getPictureId() == null || 
			formMoreComments.getPictureId() < 1){
			this.addActionMessage("错误的请求");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
				
		// 获取翻页信息,如果没有任何翻页信息,那么默认为第一页
		if( formMoreComments.getPageIndex() == null || 
			formMoreComments.getPageIndex() < 0 ){
			formMoreComments.setPageIndex(0);
		}

		List<Comments> paged_comments = ((MobilePictureService)pictureService).loadMoreCommentsWithPagableFromPictureId(
					formMoreComments.getPictureId(),
					formMoreComments.getPageIndex()
				);
		
		// 获取评论总数
		Integer comments_total_count = ((MobilePictureService)pictureService).loadMoreCommentsTotelCountFromPictureId(
				formMoreComments.getPictureId());
		
		// 计算页面数量
		Integer page_record_count = ((MobilePictureService)pictureService).getMoreCommentsPageCount();
		Integer page_count = comments_total_count / page_record_count;
		if( comments_total_count % page_record_count > 0 ){
			page_count ++;
		}
		
		if( paged_comments != null && paged_comments.size() > 0 ){
			this.setValue(ActionConstant.ARP_MORE_COMMENTS_LIST_PICTURE_ID, formMoreComments.getPictureId());
			this.setValue(ActionConstant.ARP_MORE_COMMENTS_LIST, paged_comments);
			this.setValue(ActionConstant.ARP_MORE_COMMENTS_LIST_PAGE_INDEX, formMoreComments.getPageIndex());
			this.setValue(ActionConstant.ARP_MORE_COMMENTS_LIST_PAGE_COUNT, page_count);
			this.setValue(ActionConstant.ARP_MORE_COMMENTS_LIST_TOTAL_COUNT, comments_total_count);
		}
		
		return SUCCESS;
	}
	
	public String tag() throws Exception {
		
		// 判断该请求的输入的参数是否合法?
		if(	formTag	==	null						||	
			(StringUtils.isEmpty(formTag.getName()) && formTag.getSelectedTagId() == null)	||
			formTag.getId_pictures() == null		||
			formTag.getId_pictures()<1 ){
			this.addActionMessage("错误的请求");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		if(!isLogin()){
			this.addActionMessage("请先登录后在发表评论");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		try{
			Account account = loadAccount();
			Tags tags = pictureService.Tag(account, formTag);
		}catch(Exception e){
			LOGGER.error( "标签提交失败, "+ e.getMessage(), e);
			this.addActionMessage("提交标签失败,请联系网站管理员");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		
		this.addActionMessage("恭喜,提交标签成功");
		return ActionConstant.ACTION_RETURN_MSG_BOX;
	}
	
	/**
	 * 该action响应用户查询更多tags的请求, tags中需要标识出它所包含的picture的数目
	 * @return
	 * @throws Exception
	 */
	public String more_tags() throws Exception{
		
		if(!isLogin()){
			this.addActionMessage("请先登录后在才能设置标签");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}		
		
		// 获取当前登录的用户
		Account login_account = loadAccount();
		
		// 判断该请求的输入的参数是否合法?
		if(	formTag	==	null						||	
			formTag.getId_pictures() == null		||
			formTag.getId_pictures()<1 ){
			this.addActionMessage("错误的请求");
			return ActionConstant.ACTION_RETURN_MSG_BOX;
		}
		
		// 获取翻页信息,如果没有任何翻页信息,那么默认为第一页
		if( formTag.getPageIndex() == null || 
			formTag.getPageIndex() < 0 ){
			formTag.setPageIndex(0);
		}
		
		// 获取指定的一页的tags信息(该信息包含对应图片数目)
		List<Tags> paged_tags = ((MobilePictureService)pictureService).loadTagsWithPictureCountPagableFromAccount(
								login_account.getAccount(),
								formTag.getPageIndex(), 
								more_tags_page_count);
		
		// 获取tags总数
		Integer tags_total_count = ((MobilePictureService)pictureService).getTagsCountFromAccount(
									login_account.getAccount());
		
		// 计算页面数量
		Integer page_record_count = this.more_tags_page_count;
		Integer page_count = tags_total_count / page_record_count;
		if( tags_total_count % page_record_count > 0 ){
			page_count ++;
		}
		
		if( paged_tags != null && paged_tags.size() > 0 ){
			this.setValue(ActionConstant.ARP_MORE_TAGS_LIST_PICTURE_ID, formTag.getId_pictures());
			this.setValue(ActionConstant.ARP_MORE_TAGS_LIST, paged_tags);
			this.setValue(ActionConstant.ARP_MORE_TAGS_LIST_PAGE_INDEX, formTag.getPageIndex());
			this.setValue(ActionConstant.ARP_MORE_TAGS_LIST_PAGE_COUNT, page_count);
			this.setValue(ActionConstant.ARP_MORE_TAGS_LIST_TOTAL_COUNT, tags_total_count);
		}
		
		return SUCCESS;
	}	

	
	/**
	 * 该action用来响应用户显示某一图片信息,包含一些评论和标签
	 * @return
	 * @throws Exception
	 */
	public String single_pic() throws Exception{
		if(id_picture!=null&&id_picture.longValue()>0){
			try{
				
				// 获取图片信息
				PictureInfo pi = pictureService.loadPicture(id_picture);
				this.setValue("picture", pi);
				
				// 获取前n个评论
				List<Comments> comments = ((MobilePictureServiceImpl) pictureService).loadCommentsLimitWitTopFromPicture(pi , 5);
				this.setValue("comments", comments);
				
				// 获取前n个标签
				Account account = loadAccount();
				if(account!=null){
					List<Tags> tags = ((MobilePictureServiceImpl) pictureService).loadTagsLimitWitTopFromPicture(pi , 6,account.getAccount());
					this.setValue("tags", tags);
				}
				
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
	
}
