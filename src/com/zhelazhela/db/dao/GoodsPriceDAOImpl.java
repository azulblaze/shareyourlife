package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GoodsPrice;
import com.zhelazhela.db.model.GoodsPriceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GoodsPriceDAOImpl extends SqlMapClientDaoSupport implements GoodsPriceDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public GoodsPriceDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int countByExample(GoodsPriceExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"goods_price.ibatorgenerated_countByExample", example);
		return count;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int deleteByExample(GoodsPriceExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"goods_price.ibatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int deleteByPrimaryKey(Long id) {
		GoodsPrice key = new GoodsPrice();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"goods_price.ibatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public void insert(GoodsPrice record) {
		getSqlMapClientTemplate().insert("goods_price.ibatorgenerated_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public void insertSelective(GoodsPrice record) {
		getSqlMapClientTemplate().insert(
				"goods_price.ibatorgenerated_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsPrice> selectByExample(GoodsPriceExample example) {
		List<GoodsPrice> list = getSqlMapClientTemplate().queryForList(
				"goods_price.ibatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public GoodsPrice selectByPrimaryKey(Long id) {
		GoodsPrice key = new GoodsPrice();
		key.setId(id);
		GoodsPrice record = (GoodsPrice) getSqlMapClientTemplate()
				.queryForObject(
						"goods_price.ibatorgenerated_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int updateByExampleSelective(GoodsPrice record,
			GoodsPriceExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"goods_price.ibatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int updateByExample(GoodsPrice record, GoodsPriceExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"goods_price.ibatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int updateByPrimaryKeySelective(GoodsPrice record) {
		int rows = getSqlMapClientTemplate().update(
				"goods_price.ibatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	public int updateByPrimaryKey(GoodsPrice record) {
		int rows = getSqlMapClientTemplate().update(
				"goods_price.ibatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table goods_price
	 * @ibatorgenerated  Sun Feb 14 23:42:49 CST 2010
	 */
	private static class UpdateByExampleParms extends GoodsPriceExample {
		private Object record;

		public UpdateByExampleParms(Object record, GoodsPriceExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}