package com.twitpic.db.dao;

import com.twitpic.db.model.UsersGroup;
import com.twitpic.db.model.UsersGroupExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UsersGroupDAOImpl extends SqlMapClientDaoSupport implements UsersGroupDAO {

    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public UsersGroupDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int countByExample(UsersGroupExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"users_group.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int deleteByExample(UsersGroupExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"users_group.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int deleteByPrimaryKey(Long id) {
		UsersGroup key = new UsersGroup();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"users_group.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public void insert(UsersGroup record) {
		getSqlMapClientTemplate().insert("users_group.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public void insertSelective(UsersGroup record) {
		getSqlMapClientTemplate().insert(
				"users_group.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	@SuppressWarnings("unchecked")
	public List<UsersGroup> selectByExample(UsersGroupExample example) {
		List<UsersGroup> list = getSqlMapClientTemplate().queryForList(
				"users_group.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public UsersGroup selectByPrimaryKey(Long id) {
		UsersGroup key = new UsersGroup();
		key.setId(id);
		UsersGroup record = (UsersGroup) getSqlMapClientTemplate()
				.queryForObject(
						"users_group.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int updateByExampleSelective(UsersGroup record,
			UsersGroupExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"users_group.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int updateByExample(UsersGroup record, UsersGroupExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"users_group.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int updateByPrimaryKeySelective(UsersGroup record) {
		int rows = getSqlMapClientTemplate().update(
				"users_group.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	public int updateByPrimaryKey(UsersGroup record) {
		int rows = getSqlMapClientTemplate().update(
				"users_group.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table users_group
	 * @ibatorgenerated  Wed Sep 09 16:39:53 CST 2009
	 */
	private static class UpdateByExampleParms extends UsersGroupExample {
		private Object record;

		public UpdateByExampleParms(Object record, UsersGroupExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public long insert_return_id(UsersGroup record) {
		return (Long)getSqlMapClientTemplate().insert("users_group.insert_return_id", record);
	}
}