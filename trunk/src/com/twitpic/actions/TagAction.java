package com.twitpic.actions;

import com.twitpic.db.model.Tags;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormTag;
import com.twitpic.services.PictureService;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class TagAction extends BaseAction {
	private PictureService pictureService;
	private FormTag formTag;
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	public FormTag getFormTag(){
		return formTag;
	}
	public void setFormTag(FormTag formTag){
		this.formTag = formTag;
	}
	public String tag() throws Exception {
		if(formTag==null||formTag.getName()==null||formTag.getName().trim().length()<1||formTag.getId_pictures()==null||formTag.getId_pictures()<1){
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

}
