package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.db.model.MerchandiseCategoryExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MerchandiseCategoryDAOImpl extends SqlMapClientDaoSupport implements MerchandiseCategoryDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public MerchandiseCategoryDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int countByExample(MerchandiseCategoryExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"merchandise_category.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int deleteByExample(MerchandiseCategoryExample example) {
		int rows = getSqlMapClientTemplate()
				.delete("merchandise_category.ibatorgenerated_deleteByExample",
						example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int deleteByPrimaryKey(Long id) {
		MerchandiseCategory key = new MerchandiseCategory();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"merchandise_category.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public void insert(MerchandiseCategory record) {
		getSqlMapClientTemplate().insert(
				"merchandise_category.ibatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public void insertSelective(MerchandiseCategory record) {
		getSqlMapClientTemplate().insert(
				"merchandise_category.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	@SuppressWarnings("unchecked")
	public List<MerchandiseCategory> selectByExample(
			MerchandiseCategoryExample example) {
		List<MerchandiseCategory> list = getSqlMapClientTemplate()
				.queryForList(
						"merchandise_category.ibatorgenerated_selectByExample",
						example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public MerchandiseCategory selectByPrimaryKey(Long id) {
		MerchandiseCategory key = new MerchandiseCategory();
		key.setId(id);
		MerchandiseCategory record = (MerchandiseCategory) getSqlMapClientTemplate()
				.queryForObject(
						"merchandise_category.ibatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int updateByExampleSelective(MerchandiseCategory record,
			MerchandiseCategoryExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate()
				.update(
						"merchandise_category.ibatorgenerated_updateByExampleSelective",
						parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int updateByExample(MerchandiseCategory record,
			MerchandiseCategoryExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"merchandise_category.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int updateByPrimaryKeySelective(MerchandiseCategory record) {
		int rows = getSqlMapClientTemplate()
				.update(
						"merchandise_category.ibatorgenerated_updateByPrimaryKeySelective",
						record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	public int updateByPrimaryKey(MerchandiseCategory record) {
		int rows = getSqlMapClientTemplate().update(
				"merchandise_category.ibatorgenerated_updateByPrimaryKey",
				record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table merchandise_category
	 * @ibatorgenerated  Fri Dec 25 12:43:45 CST 2009
	 */
	private static class UpdateByExampleParms extends
			MerchandiseCategoryExample {
		private Object record;

		public UpdateByExampleParms(Object record,
				MerchandiseCategoryExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public long insertSelectiveReturnId(MerchandiseCategory record) {
		return (Long)getSqlMapClientTemplate().insert(
				"merchandise_category.insertSelective_returnId", record);
	}
}