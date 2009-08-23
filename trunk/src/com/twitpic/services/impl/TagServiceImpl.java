package com.twitpic.services.impl;

import java.util.Calendar;
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
	
	/**
	 * @param tagsDAO the tagsDAO to set
	 */
	public void setTagsDAO(TagsDAO tagsDAO) {
		this.tagsDAO = tagsDAO;
	}
	
	@Override
	public List<Tags> load_picture_tag(Long id_picture, Integer start,
			Integer size) {
		return tagsDAO.selectTagsFromPicture(id_picture, start, size);
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
	public List<Tags> load_user_tag(String keyword, String account,Integer start, Integer size) throws Exception {
		return tagsDAO.selectTagsFromAcount(account, keyword, start, size);
	}

	@Override
	public List<Tags> load_day_tag(Integer start, Integer size) {
		return tagsDAO.selectTagsWithTime(getDayDate(), 1, 10);
	}

	@Override
	public List<Tags> load_month_tag(Integer start, Integer size) {
		return tagsDAO.selectTagsWithTime(getMonthDate(), 1, 10);
	}

	@Override
	public List<Tags> load_week_tag(Integer start, Integer size) {
		return tagsDAO.selectTagsWithTime(getWeekDate(), 1, 10);
	}

	private java.util.Date getDayDate(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	private java.util.Date getWeekDate(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return c.getTime();
	}
	
	private java.util.Date getMonthDate(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
}
