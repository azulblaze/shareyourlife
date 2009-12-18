package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.db.model.ProgramInfoExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ProgramInfoDAOImpl extends SqlMapClientDaoSupport implements ProgramInfoDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public ProgramInfoDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int countByExample(ProgramInfoExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"program_info.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int deleteByExample(ProgramInfoExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"program_info.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int deleteByPrimaryKey(Long id) {
		ProgramInfo key = new ProgramInfo();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"program_info.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public void insert(ProgramInfo record) {
		getSqlMapClientTemplate().insert("program_info.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public void insertSelective(ProgramInfo record) {
		getSqlMapClientTemplate().insert(
				"program_info.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	@SuppressWarnings("unchecked")
	public List<ProgramInfo> selectByExampleWithBLOBs(ProgramInfoExample example) {
		List<ProgramInfo> list = getSqlMapClientTemplate().queryForList(
				"program_info.ibatorgenerated_selectByExampleWithBLOBs",
				example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	@SuppressWarnings("unchecked")
	public List<ProgramInfo> selectByExampleWithoutBLOBs(
			ProgramInfoExample example) {
		List<ProgramInfo> list = getSqlMapClientTemplate().queryForList(
				"program_info.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public ProgramInfo selectByPrimaryKey(Long id) {
		ProgramInfo key = new ProgramInfo();
		key.setId(id);
		ProgramInfo record = (ProgramInfo) getSqlMapClientTemplate()
				.queryForObject(
						"program_info.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByExampleSelective(ProgramInfo record,
			ProgramInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByExampleWithBLOBs(ProgramInfo record,
			ProgramInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByExampleWithBLOBs", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByExampleWithoutBLOBs(ProgramInfo record,
			ProgramInfoExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByPrimaryKeySelective(ProgramInfo record) {
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByPrimaryKeyWithBLOBs(ProgramInfo record) {
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByPrimaryKeyWithBLOBs",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	public int updateByPrimaryKeyWithoutBLOBs(ProgramInfo record) {
		int rows = getSqlMapClientTemplate().update(
				"program_info.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 11:08:41 CST 2009
	 */
	private static class UpdateByExampleParms extends ProgramInfoExample {
		private Object record;

		public UpdateByExampleParms(Object record, ProgramInfoExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}