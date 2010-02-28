package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GoodsUserTag;
import com.zhelazhela.db.model.GoodsUserTagExample;
import com.zhelazhela.db.model.define.UserTagInfo;

import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GoodsUserTagDAOImpl extends SqlMapClientDaoSupport implements GoodsUserTagDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public GoodsUserTagDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int countByExample(GoodsUserTagExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("goods_user_tag.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByExample(GoodsUserTagExample example) {
        int rows = getSqlMapClientTemplate().delete("goods_user_tag.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        GoodsUserTag key = new GoodsUserTag();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("goods_user_tag.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insert(GoodsUserTag record) {
        getSqlMapClientTemplate().insert("goods_user_tag.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insertSelective(GoodsUserTag record) {
        getSqlMapClientTemplate().insert("goods_user_tag.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<GoodsUserTag> selectByExample(GoodsUserTagExample example) {
        List<GoodsUserTag> list = getSqlMapClientTemplate().queryForList("goods_user_tag.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public GoodsUserTag selectByPrimaryKey(Long id) {
        GoodsUserTag key = new GoodsUserTag();
        key.setId(id);
        GoodsUserTag record = (GoodsUserTag) getSqlMapClientTemplate().queryForObject("goods_user_tag.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExampleSelective(GoodsUserTag record, GoodsUserTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("goods_user_tag.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExample(GoodsUserTag record, GoodsUserTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("goods_user_tag.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKeySelective(GoodsUserTag record) {
        int rows = getSqlMapClientTemplate().update("goods_user_tag.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKey(GoodsUserTag record) {
        int rows = getSqlMapClientTemplate().update("goods_user_tag.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private static class UpdateByExampleParms extends GoodsUserTagExample {
        private Object record;

        public UpdateByExampleParms(Object record, GoodsUserTagExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<UserTagInfo> loadUserTagInfos(long userid) {
		java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
		map.put("user_id", userid);
		List<UserTagInfo> list = getSqlMapClientTemplate().queryForList("goods_user_tag.loadUserTagInfoByUser", map);
        return list;
	}
}