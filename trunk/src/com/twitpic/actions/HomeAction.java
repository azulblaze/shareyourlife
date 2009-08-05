package com.twitpic.actions;

import com.twitpic.services.PictureService;

@SuppressWarnings("serial")
public class HomeAction extends BaseAction {
	
	private PictureService pictureService;
	
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
		if(isLogin()){
			this.setValue("pictures", pictureService.loadHomePictures(15));
			return SUCCESS;
		}
		return "welcome";
	}
	
	public String main_more()throws Exception{
		if(isLogin()){
			if(to_id!=null&&to_id.longValue()>0){
				java.util.List<com.twitpic.domain.PictureInfo> pictures = pictureService.loadMoretPictures(to_id, 5);
				this.setValue("pictures", pictures);
			}
			
		}else{
			
		}
		return "json";
	}
	
	public String main_latest()throws Exception{
		if(isLogin()){
			if(from_id!=null&&from_id.longValue()>0){
				java.util.List<com.twitpic.domain.PictureInfo> pictures = pictureService.loadLatestPictures(from_id);
				this.setValue("pictures", pictures);
			}
			
		}else{
			
		}
		return "json";
	}
}
