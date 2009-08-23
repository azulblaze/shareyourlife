package com.twitpic.actions.m;

import java.util.List;

import org.apache.log4j.Logger;

import com.twitpic.actions.BaseAction;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormHome;
import com.twitpic.domain.MessagesInfo;
import com.twitpic.domain.PictureInfo;
import com.twitpic.services.MessageService;
import com.twitpic.services.MobilePictureService;
import com.twitpic.services.PictureService;

public class HomeAction extends BaseAction {
	
	private static Logger LOGGER = Logger.getLogger(HomeAction.class);
	
	private PictureService pictureService;
	private MessageService messageService;
	private Integer m_pictures_page_count = 5; 	// 默认为 5 条
	private Integer m_tags_page_count = 9;		// 默认为9条
	private FormHome m_formHome;
	
	public void setMessageService(MessageService _service){
		this.messageService = _service;
	}
	
	public void setFormHome(FormHome _formHome){
		this.m_formHome = _formHome;
	}
	public FormHome getFormHome(){
		return this.m_formHome;
	}
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	
	public void setPicturesPageCount(Integer _count){
		this.m_pictures_page_count = _count;
	}
	
	public void setTagsPageCount(Integer _count){
		this.m_tags_page_count = _count;
	}

	public String index() throws Exception{

			// this.setValue("pictures", pictureService.loadHomePictures(15));
			
			/*
			 *  初始化首页需要显示的数据
			 *  1. 准备茄友的信息情况( 系统信息, 茄友信息 )
			 *  2. 准备需要显示的分页的图片列表以及分页信息
			 *  3. 准备分页的热门标签以及分页信息
			 */
			
			// 准备茄友的信息情况( 系统信息, 茄友信息 )
			prepare_mssage_for_account();
			
			// 准备需要显示的分页的图片列表以及分页信息
			prepare_pictures_pagable_for_account();
			
			// 准备分页的热门标签以及分页信息
			prepare_tags_pagable_for_account();
						
			return SUCCESS;

	}

	/**
	 * 准备分页的热门标签以及分页信息
	 */
	private void prepare_tags_pagable_for_account() {
		

	}

	/**
	 * 准备需要显示的分页的图片列表以及分页信息
	 */
	private void prepare_pictures_pagable_for_account() {
		if( this.m_formHome == null ){
			this.m_formHome = new FormHome();
		}

		List<PictureInfo> pictures = ((MobilePictureService)this.pictureService).loadPicturesPagedForHome(
					this.m_formHome.getPicturesPageIndex(),
					this.m_pictures_page_count
				);
		
		this.setValue("h_pictures_list", pictures);
		this.setValue("h_pictures_pageindex", this.m_formHome.getPicturesPageIndex());		
	}

	/**
	 * 准备茄友的信息情况( 系统信息, 茄友信息 )
	 */
	private void prepare_mssage_for_account() {
		if( isLogin() ){
			Account account = this.loadAccount();
			try {
				MessagesInfo info = this.messageService.loadMessagesInfoFromAccount(account.getAccount());
				this.setValue("h_msgs_count", info.getMessagesCount());
				this.setValue("h_msgs_unread_count", info.getUnreadMessageCount());
			} catch (Exception e) {
				LOGGER.error("获取用户信息情况失败", e);
			}
		}
	}
	
}
