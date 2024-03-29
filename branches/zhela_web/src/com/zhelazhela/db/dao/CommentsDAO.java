package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.Comments;
import com.zhelazhela.db.model.CommentsExample;
import java.util.List;

public interface CommentsDAO {
    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int countByExample(CommentsExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int deleteByExample(CommentsExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	void insert(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	void insertSelective(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	List<Comments> selectByExample(CommentsExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	Comments selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int updateByExampleSelective(Comments record, CommentsExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int updateByExample(Comments record, CommentsExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int updateByPrimaryKeySelective(Comments record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	int updateByPrimaryKey(Comments record);

	long insertSelectiveReturnId(Comments record);
   
}