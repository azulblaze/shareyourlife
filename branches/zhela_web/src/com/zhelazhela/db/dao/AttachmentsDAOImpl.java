package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.AttachmentsExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AttachmentsDAOImpl extends SqlMapClientDaoSupport implements AttachmentsDAO {

    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public AttachmentsDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int countByExample(AttachmentsExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"attachments.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int deleteByExample(AttachmentsExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"attachments.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int deleteByPrimaryKey(Long id) {
		Attachments key = new Attachments();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"attachments.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public void insert(Attachments record) {
		getSqlMapClientTemplate().insert("attachments.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public void insertSelective(Attachments record) {
		getSqlMapClientTemplate().insert(
				"attachments.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<Attachments> selectByExample(AttachmentsExample example) {
		List<Attachments> list = getSqlMapClientTemplate().queryForList(
				"attachments.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public Attachments selectByPrimaryKey(Long id) {
		Attachments key = new Attachments();
		key.setId(id);
		Attachments record = (Attachments) getSqlMapClientTemplate()
				.queryForObject(
						"attachments.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int updateByExampleSelective(Attachments record,
			AttachmentsExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"attachments.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int updateByExample(Attachments record, AttachmentsExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"attachments.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int updateByPrimaryKeySelective(Attachments record) {
		int rows = getSqlMapClientTemplate().update(
				"attachments.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	public int updateByPrimaryKey(Attachments record) {
		int rows = getSqlMapClientTemplate().update(
				"attachments.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table attachments
	 * @ibatorgenerated  Tue Jan 19 22:21:56 CST 2010
	 */
	private static class UpdateByExampleParms extends AttachmentsExample {
		private Object record;

		public UpdateByExampleParms(Object record, AttachmentsExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public long insertSelectiveReturnId(Attachments record) {
		return (Long)getSqlMapClientTemplate().insert("attachments.insertSelective_returnId", record);
	}
}