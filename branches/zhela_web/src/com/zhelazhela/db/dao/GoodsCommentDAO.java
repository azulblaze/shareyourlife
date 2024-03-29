package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GoodsComment;
import com.zhelazhela.db.model.GoodsCommentExample;
import com.zhelazhela.db.model.define.UserComment;

import java.util.List;

public interface GoodsCommentDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int countByExample(GoodsCommentExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int deleteByExample(GoodsCommentExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	void insert(GoodsComment record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	void insertSelective(GoodsComment record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	List<GoodsComment> selectByExample(GoodsCommentExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	GoodsComment selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int updateByExampleSelective(GoodsComment record,
			GoodsCommentExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int updateByExample(GoodsComment record, GoodsCommentExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int updateByPrimaryKeySelective(GoodsComment record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_comment
	 * @ibatorgenerated  Mon Feb 15 01:04:29 CST 2010
	 */
	int updateByPrimaryKey(GoodsComment record);
	
	java.util.List<UserComment> loadUserComment(long goods_id,String goods_sn,int page,int pagesize);
	
	UserComment loadComment(long id) throws Exception;
	
	int countUserComment(long goods_id,String goods_sn);
}