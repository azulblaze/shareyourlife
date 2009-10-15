package com.twitpic.services;

/**
 * <code>TagService.java</code>
 * 
 * @version 1.0, 2009-8-6
 */
public interface TagService {
	
	public java.util.List<com.twitpic.db.model.Tags> load_similar_tag(String keyword,Integer start,Integer size)throws Exception;
	
	public java.util.List<com.twitpic.db.model.Tags> load_user_tag(String keyword,String account,Integer start,Integer size)throws Exception;
	
	public java.util.List<com.twitpic.db.model.Tags> load_picture_tag(Long id_picture,Integer start,Integer size);
	
	public java.util.List<com.twitpic.db.model.Tags> load_day_tag(Integer start,Integer size);
	
	public java.util.List<com.twitpic.db.model.Tags> load_week_tag(Integer start,Integer size);
	
	public java.util.List<com.twitpic.db.model.Tags> load_month_tag(Integer start,Integer size);
	
	public java.util.List<com.twitpic.db.model.Tags> load_pop_tags(Integer size);
}
