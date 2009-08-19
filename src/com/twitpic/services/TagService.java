package com.twitpic.services;

/**
 * <code>TagService.java</code>
 * 
 * @version 1.0, 2009-8-6
 */
public interface TagService {
	
	public java.util.List<com.twitpic.db.model.Tags> load_similar_tag(String keyword,Integer start,Integer size)throws Exception;
	
	public java.util.List<com.twitpic.db.model.Tags> load_user_tag(String keyword,String account,Integer start,Integer size)throws Exception;
	
	public java.util.List<com.twitpic.db.model.Tags> load_picture_tag(Integer id_picture,Integer start,Integer size);
}
