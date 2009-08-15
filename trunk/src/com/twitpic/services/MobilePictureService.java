package com.twitpic.services;

import java.util.List;

import com.twitpic.db.model.Comments;
import com.twitpic.db.model.Tags;
import com.twitpic.domain.PictureInfo;

public interface MobilePictureService {
	
	public List<Comments> loadCommentsLimitWitTopFromPicture(
			PictureInfo pi,
			int count);	
	
	public List<Tags> loadTagsLimitWitTopFromPicture(
			PictureInfo pi, 
			int count) ;	
	
	public List<Comments> loadMoreCommentsWithPagableFromPictureId(
			Long pictureId, Integer pageIndex);
}
