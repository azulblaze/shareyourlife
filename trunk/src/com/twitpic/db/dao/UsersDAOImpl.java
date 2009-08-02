package com.twitpic.db.dao;

import com.twitpic.db.model.Users;
import com.twitpic.db.model.UsersExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UsersDAOImpl extends SqlMapClientDaoSupport implements UsersDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public UsersDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public void insert(Users record) {
		getSqlMapClientTemplate()
				.insert("users.abatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int updateByPrimaryKey(Users record) {
		int rows = getSqlMapClientTemplate().update(
				"users.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int updateByPrimaryKeySelective(Users record) {
		int rows = getSqlMapClientTemplate().update(
				"users.abatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	@SuppressWarnings("unchecked")
	public List<Users> selectByExample(UsersExample example) {
		List<Users> list = (List<Users>) getSqlMapClientTemplate()
				.queryForList("users.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public Users selectByPrimaryKey(String account) {
		Users key = new Users();
		key.setAccount(account);
		Users record = (Users) getSqlMapClientTemplate().queryForObject(
				"users.abatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int deleteByExample(UsersExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"users.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int deleteByPrimaryKey(String account) {
		Users key = new Users();
		key.setAccount(account);
		int rows = getSqlMapClientTemplate().delete(
				"users.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int countByExample(UsersExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"users.abatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int updateByExampleSelective(Users record, UsersExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"users.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	public int updateByExample(Users record, UsersExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"users.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table users
	 * @abatorgenerated  Sun Aug 02 21:24:11 CST 2009
	 */
	private static class UpdateByExampleParms extends UsersExample {
		private Object record;

		public UpdateByExampleParms(Object record, UsersExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}