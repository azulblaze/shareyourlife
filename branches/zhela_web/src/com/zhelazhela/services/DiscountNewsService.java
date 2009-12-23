package com.zhelazhela.services;

import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.domain.DiscountNewsList;

public interface DiscountNewsService {
	
	/**
	 * 存储折扣新闻
	 * @param discountinfo
	 * @return
	 * @throws Exception
	 */
	public DiscountNews saveDiscountNews(DiscountNews discountnews) throws Exception;
	/**
	 * @param id 
	 * @param program_id 折扣商家ID
	 * @param discount_category 折扣类别
	 * @param discount_area 折扣地区
	 * @param discount_start 折扣开始时间
	 * @param discount_end 折扣结束时间
	 * @param info_source 折扣来源
	 * @param info_title 折扣标题
	 * @param info_review 折扣预览内容
	 * @param info_content 折扣详细内容
	 * @return
	 * @throws Exception
	 */
	public DiscountNews editDiscountNews(long id,Long program_id,String discount_category,String discount_area,java.util.Date discount_start, java.util.Date discount_end,String info_source,String info_title,String info_review,String info_content) throws Exception;
	
	public DiscountNews pointContent(long id,int points) throws Exception;
	
	public DiscountNews pointPublish(long id,int points) throws Exception;
	
	public boolean delDiscountNews(long id) throws Exception;
	
	public boolean approveDiscountNews(long id,String approve_user,boolean result) throws Exception;
	/**
	 * 用于异步的更新阅读次数
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public long readDiscountNews(long id) throws Exception;
	
	public long supportDiscountNews(long id) throws Exception;
	
	public DiscountNewsList loadDiscountNewsList(int page,int pagesize,String categorys,String areas,String title,java.util.Date after_approve_time,String orderby) throws Exception;
	
	public DiscountNewsList loadUnReleaseDiscountNewsList(int page,int pagesize,java.util.Map<String,Object> parameters,String categorys,String areas,String title,String orderby) throws Exception;
	
	public DiscountNews viewDiscountNews(long id) throws Exception;
}
