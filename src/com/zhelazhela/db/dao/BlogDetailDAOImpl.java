package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.BlogDetailExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BlogDetailDAOImpl extends SqlMapClientDaoSupport implements BlogDetailDAO {

    /**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public BlogDetailDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int countByExample(BlogDetailExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"blog_detail.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int deleteByExample(BlogDetailExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"blog_detail.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int deleteByPrimaryKey(Long id) {
		BlogDetail key = new BlogDetail();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"blog_detail.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public void insert(BlogDetail record) {
		getSqlMapClientTemplate().insert("blog_detail.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public void insertSelective(BlogDetail record) {
		getSqlMapClientTemplate().insert(
				"blog_detail.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<BlogDetail> selectByExampleWithBLOBs(BlogDetailExample example) {
		List<BlogDetail> list = getSqlMapClientTemplate()
				.queryForList(
						"blog_detail.ibatorgenerated_selectByExampleWithBLOBs",
						example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<BlogDetail> selectByExampleWithoutBLOBs(
			BlogDetailExample example) {
		List<BlogDetail> list = getSqlMapClientTemplate().queryForList(
				"blog_detail.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public BlogDetail selectByPrimaryKey(Long id) {
		BlogDetail key = new BlogDetail();
		key.setId(id);
		BlogDetail record = (BlogDetail) getSqlMapClientTemplate()
				.queryForObject(
						"blog_detail.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByExampleSelective(BlogDetail record,
			BlogDetailExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByExampleWithBLOBs(BlogDetail record,
			BlogDetailExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByExampleWithBLOBs", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByExampleWithoutBLOBs(BlogDetail record,
			BlogDetailExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByPrimaryKeySelective(BlogDetail record) {
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByPrimaryKeyWithBLOBs(BlogDetail record) {
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByPrimaryKeyWithBLOBs",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	public int updateByPrimaryKeyWithoutBLOBs(BlogDetail record) {
		int rows = getSqlMapClientTemplate().update(
				"blog_detail.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table blog_detail
	 * @ibatorgenerated  Wed Jan 27 11:07:17 CST 2010
	 */
	private static class UpdateByExampleParms extends BlogDetailExample {
		private Object record;

		public UpdateByExampleParms(Object record, BlogDetailExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public long insertSelectiveReturnId(BlogDetail record) {
		return (Long)getSqlMapClientTemplate().insert("blog_detail.insertSelective_returnId", record);
	}
}