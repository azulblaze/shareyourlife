package com.twitpic.services.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.twitpic.db.model.Comments;
import com.twitpic.db.model.CommentsExample;
import com.twitpic.db.model.Tags;
import com.twitpic.db.model.TagsExample;
import com.twitpic.domain.Account;
import com.twitpic.domain.FormComment;
import com.twitpic.domain.FormTag;
import com.twitpic.domain.PictureInfo;
import com.twitpic.services.MobilePictureService;

/**
 * 
 * @author sol
 *
 */
public class MobilePictureServiceImpl extends PictureServiceImpl implements MobilePictureService {
	
	private static final Logger LOGGER = Logger.getLogger(MobilePictureServiceImpl.class);

	private Integer more_comments_page_count = 10;
	
	public void setMoreCommentsPageCount(Integer _count){
		this.more_comments_page_count = _count;
	}
	
	@Override
	public Tags Tag(Account account, FormTag formTag) throws Exception {
		
		/*
		 * 用户是否选择了radio按钮上的某个标签,如果是那么将查询出这个标签,
		 * 同时判断用户在新加标签输入框中是否输入了标签名称,如果有,那么优先使用
		 * 输入框中的标签名称来处理.
		 */
		if( formTag.getSelectedTagId() != null ){
			Tags selected_tags = this.tagsDAO.selectByPrimaryKey(formTag.getSelectedTagId());
			if( selected_tags != null ){
				if( StringUtils.isEmpty(formTag.getName()) ){
					formTag.setName(selected_tags.getName());
					
					LOGGER.info("用户是使用radio按钮上的标签来处理");
				}
			}
		}
		
		return super.Tag(account, formTag);
	}

	public List<Comments> loadCommentsLimitWitTopFromPicture(
			PictureInfo pi,
			int count) {
		
		// 设置查询条件
		CommentsExample example = new CommentsExample();
		example.createCriteria()
			   .andAccountEqualTo(pi.getAccount())
			   .andIdPicturesEqualTo(pi.getPictures().getId());
		// 设置排序和限制(mysql语句的)
		example.setOrderByClause("comment_time desc");
		example.setLimit("0, "+count);
		
		return this.commentsDAO.selectByExampleWithBLOBs(example);

	}

	public List<Tags> loadTagsLimitWitTopFromPicture(
			PictureInfo pi, 
			int count) {
		
		// 设置查询条件
		TagsExample example = new TagsExample();
		example.createCriteria()
			   .andAccountEqualTo(pi.getAccount());
		
		// 设置排序和限制(mysql语句的)
		example.setOrderByClause("create_time desc");
		example.setLimit("0, "+count);
		
		return this.tagsDAO.selectByExample(example);
	}

	@Override
	public List<Comments> loadMoreCommentsWithPagableFromPictureId(
			Long pictureId, Integer pageIndex) {
		
		
		
		return null;
	}

	

}