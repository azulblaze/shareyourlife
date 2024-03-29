package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.ContactProfile;
import com.zhelazhela.db.model.ContactProfileExample;
import java.util.List;

public interface ContactProfileDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int countByExample(ContactProfileExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int deleteByExample(ContactProfileExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	void insert(ContactProfile record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	void insertSelective(ContactProfile record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	List<ContactProfile> selectByExample(ContactProfileExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	ContactProfile selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int updateByExampleSelective(ContactProfile record,
			ContactProfileExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int updateByExample(ContactProfile record, ContactProfileExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int updateByPrimaryKeySelective(ContactProfile record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	int updateByPrimaryKey(ContactProfile record);
}