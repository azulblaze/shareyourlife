package com.twitpic.services.impl;

import java.util.List;

import com.twitpic.db.dao.TagsDAO;
import com.twitpic.db.model.Tags;
import com.twitpic.db.model.TagsExample;
import com.twitpic.services.TagService;

/**
 * <code>TagServiceImpl.java</code>
 * @version 1.0, 2009-8-19
 */
public class TagServiceImpl implements TagService {

	protected TagsDAO tagsDAO;
	
	@Override
	public List<Tags> load_picture_tag(Integer id_picture, Integer start,
			Integer size) {
		
		return null;
	}

	@Override
	public List<Tags> load_similar_tag(String keyword, Integer start,
			Integer size) throws Exception {
		TagsExample example = new TagsExample();
		example.createCriteria().andNameLike("%"+keyword+"%");
		if(size!=null&&size>0){
			if(start==null){
				start=0;
			}
			example.setLimit(start+","+size);
		}
		List<Tags> tags = tagsDAO.selectByExample(example);
		return tags;
	}

	@Override
	public List<Tags> load_user_tag(String keyword, String account,
			Integer start, Integer size) throws Exception {
		return null;
	}

	/**
	 * @param tagsDAO the tagsDAO to set
	 */
	public void setTagsDAO(TagsDAO tagsDAO) {
		this.tagsDAO = tagsDAO;
	}

}
