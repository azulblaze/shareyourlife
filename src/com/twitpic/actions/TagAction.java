package com.twitpic.actions;

import com.twitpic.db.model.Tags;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormTag;
import com.twitpic.services.PictureService;
import com.twitpic.services.TagService;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class TagAction extends BaseAction {
	private PictureService pictureService;
	private TagService tagService;
	private FormTag formTag;
	private Long id_picture;
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	public FormTag getFormTag(){
		return formTag;
	}
	public void setFormTag(FormTag formTag){
		this.formTag = formTag;
	}
	public Long getId_picture() {
		return id_picture;
	}
	public void setId_picture(Long idPicture) {
		id_picture = idPicture;
	}
	public String tag() throws Exception {
		if(formTag==null||formTag.getNames()==null||formTag.getNames().length<1||formTag.getId_pictures()==null||formTag.getId_pictures()<1){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NONE+"',message:'错误的请求'}");
			return "json";
		}
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		try{
			Account account = loadAccount();
			Tags tags = pictureService.Tag(account, formTag);
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'标记成功',data:'"+tags.to_json()+"'}");
		}catch(Exception e){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_NOTICE+"', "+ConsVar.JSON_ACTION_NOTICE_MSG+":'标记失败,"+e.getMessage()+"'}");
			return "json";
		}
		return "json";
	}
	
	public String load_picture_tag() throws Exception {
		if(id_picture>0){
			java.util.List<com.twitpic.db.model.Tags> tags = tagService.load_picture_tag(id_picture, null, null);
			this.setValue("json", tags);
		}
		return "json";
	}
	
	public String load_user_tag() throws Exception{
		return null;
	}
	
	public String load_similar_tag() throws Exception{
		String keyword = this.getRequestParameter("q");
		if(keyword==null){
			keyword = "";
		}
		java.util.List<com.twitpic.db.model.Tags> tags = tagService.load_similar_tag(keyword, 0, 10);
		String list = "";
		for(com.twitpic.db.model.Tags tag:tags){
			list = list + tag.getName()+"\n";
		}
		this.setValue("json", list);
		return "json";
	}
}
