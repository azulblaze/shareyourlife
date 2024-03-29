package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.ContactProfile;
import com.zhelazhela.db.model.ContactProfileExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ContactProfileDAOImpl extends SqlMapClientDaoSupport implements ContactProfileDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public ContactProfileDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int countByExample(ContactProfileExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"contact_profile.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int deleteByExample(ContactProfileExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"contact_profile.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int deleteByPrimaryKey(Long id) {
		ContactProfile key = new ContactProfile();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"contact_profile.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public void insert(ContactProfile record) {
		getSqlMapClientTemplate().insert(
				"contact_profile.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public void insertSelective(ContactProfile record) {
		getSqlMapClientTemplate().insert(
				"contact_profile.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<ContactProfile> selectByExample(ContactProfileExample example) {
		List<ContactProfile> list = getSqlMapClientTemplate().queryForList(
				"contact_profile.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public ContactProfile selectByPrimaryKey(Long id) {
		ContactProfile key = new ContactProfile();
		key.setId(id);
		ContactProfile record = (ContactProfile) getSqlMapClientTemplate()
				.queryForObject(
						"contact_profile.ibatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int updateByExampleSelective(ContactProfile record,
			ContactProfileExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"contact_profile.ibatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int updateByExample(ContactProfile record,
			ContactProfileExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"contact_profile.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int updateByPrimaryKeySelective(ContactProfile record) {
		int rows = getSqlMapClientTemplate().update(
				"contact_profile.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	public int updateByPrimaryKey(ContactProfile record) {
		int rows = getSqlMapClientTemplate().update(
				"contact_profile.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table contact_profile
	 * @ibatorgenerated  Sun Feb 14 17:18:03 CST 2010
	 */
	private static class UpdateByExampleParms extends ContactProfileExample {
		private Object record;

		public UpdateByExampleParms(Object record, ContactProfileExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}