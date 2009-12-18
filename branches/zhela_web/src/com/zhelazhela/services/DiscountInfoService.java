package com.zhelazhela.services;

import com.zhelazhela.db.model.DiscountInfo;

public interface DiscountInfoService {
	
	/**
	 * 存储折扣新闻
	 * @param discountinfo
	 * @return
	 * @throws Exception
	 */
	public DiscountInfo saveDiscountInfo(DiscountInfo discountinfo) throws Exception;
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
	public DiscountInfo editDiscountInfo(long id,Long program_id,String discount_category,String discount_area,java.util.Date discount_start, java.util.Date discount_end,String info_source,String info_title,String info_review,String info_content) throws Exception;
	
	public DiscountInfo pointContent(long id,int points) throws Exception;
	
	public DiscountInfo pointPublish(long id,int points) throws Exception;
	
	public boolean delDiscountInfo(long id) throws Exception;
	
	public boolean approveDiscountInfo(long id,String approve_user) throws Exception;
		
	public long readDiscountInfo(long id) throws Exception;
	
	public long supportDiscountInfo(long id) throws Exception;
	
}
