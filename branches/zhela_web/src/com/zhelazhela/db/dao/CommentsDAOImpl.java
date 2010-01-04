package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.Comments;
import com.zhelazhela.db.model.CommentsExample;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CommentsDAOImpl extends SqlMapClientDaoSupport implements CommentsDAO {

    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public CommentsDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int countByExample(CommentsExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"comments.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int deleteByExample(CommentsExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"comments.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int deleteByPrimaryKey(Long id) {
		Comments key = new Comments();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"comments.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public void insert(Comments record) {
		getSqlMapClientTemplate().insert("comments.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public void insertSelective(Comments record) {
		getSqlMapClientTemplate().insert(
				"comments.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<Comments> selectByExample(CommentsExample example) {
		List<Comments> list = getSqlMapClientTemplate().queryForList(
				"comments.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public Comments selectByPrimaryKey(Long id) {
		Comments key = new Comments();
		key.setId(id);
		Comments record = (Comments) getSqlMapClientTemplate().queryForObject(
				"comments.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int updateByExampleSelective(Comments record, CommentsExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"comments.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int updateByExample(Comments record, CommentsExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"comments.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int updateByPrimaryKeySelective(Comments record) {
		int rows = getSqlMapClientTemplate().update(
				"comments.ibatorgenerated_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	public int updateByPrimaryKey(Comments record) {
		int rows = getSqlMapClientTemplate().update(
				"comments.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table comments
	 * @ibatorgenerated  Mon Jan 04 20:52:15 CST 2010
	 */
	private static class UpdateByExampleParms extends CommentsExample {
		private Object record;

		public UpdateByExampleParms(Object record, CommentsExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public long insertSelectiveReturnId(Comments record) {
		return  (Long)getSqlMapClientTemplate().insert("comments.insertSelective_returnId", record);
	}

}