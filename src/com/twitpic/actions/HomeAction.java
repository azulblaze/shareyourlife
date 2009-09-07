package com.twitpic.actions;

import com.twitpic.services.PictureService;
import com.twitpic.services.TagService;
import com.twitpic.util.ConsVar;

@SuppressWarnings("serial")
public class HomeAction extends BaseAction {
	
	private PictureService pictureService;
	
	private TagService tagService;
	
	private Long to_id;
	
	private Long from_id;
	
	public Long getTo_id() {
		return to_id;
	}

	public void setTo_id(Long toId) {
		to_id = toId;
	}

	public Long getFrom_id() {
		return from_id;
	}

	public void setFrom_id(Long fromId) {
		from_id = fromId;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public String index() throws Exception{
		this.setValue("pictures", pictureService.loadHomePictures(15));
		this.setValue("daykeys", tagService.load_day_tag(0, 10));
		this.setValue("weekkeys", tagService.load_week_tag(0, 10));
		this.setValue("monthkeys", tagService.load_month_tag(0, 10));
		return SUCCESS;
	}
	
	public String welcome() throws Exception{
		return SUCCESS;
	}
	
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	public String main_more()throws Exception{
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		if(to_id!=null&&to_id.longValue()>0){
			java.util.List<com.twitpic.domain.PictureInfo> pictures = pictureService.loadMoretPictures(to_id, 5);
			this.setValue("pictures", pictures);
		}
		return "json";
	}
	
	public String main_latest()throws Exception{
		if(!isLogin()){
			this.setValue(ConsVar.REQUEST_JSON, "{action:'"+ConsVar.JSON_ACTION_REDIRECT+"', "+ConsVar.JSON_ACTION_REDIRECT_ADDR+":'/login.do'}");
			return "json";
		}
		if(from_id!=null&&from_id.longValue()>0){
			java.util.List<com.twitpic.domain.PictureInfo> pictures = pictureService.loadLatestPictures(from_id);
			this.setValue("pictures", pictures);
		}
		return "json";
	}
}
