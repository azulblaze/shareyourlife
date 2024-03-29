package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.BlogDetailExample;
import java.util.List;

public interface BlogDetailDAO {
    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int countByExample(BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int deleteByExample(BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	void insert(BlogDetail record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	void insertSelective(BlogDetail record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	List<BlogDetail> selectByExampleWithBLOBs(BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	List<BlogDetail> selectByExampleWithoutBLOBs(BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	BlogDetail selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByExampleSelective(BlogDetail record, BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByExampleWithBLOBs(BlogDetail record, BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByExampleWithoutBLOBs(BlogDetail record, BlogDetailExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByPrimaryKeySelective(BlogDetail record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByPrimaryKeyWithBLOBs(BlogDetail record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	int updateByPrimaryKeyWithoutBLOBs(BlogDetail record);

	long insertSelectiveReturnId(BlogDetail record);
	
	java.util.List<String> loadDisCategorys();
}