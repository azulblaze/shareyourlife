package com.zhela.cloudblog.dao.provider.impl;

import com.zhela.cloudblog.dao.provider.ProvidersDAO;
import com.zhela.cloudblog.model.provider.Providers;
import com.zhela.cloudblog.model.provider.ProvidersExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ProvidersDAOImpl extends SqlMapClientDaoSupport implements ProvidersDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public ProvidersDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int countByExample(ProvidersExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("providers.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int deleteByExample(ProvidersExample example) {
        int rows = getSqlMapClientTemplate().delete("providers.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        Providers key = new Providers();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("providers.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public void insert(Providers record) {
        getSqlMapClientTemplate().insert("providers.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public void insertSelective(Providers record) {
        getSqlMapClientTemplate().insert("providers.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<Providers> selectByExample(ProvidersExample example) {
        List<Providers> list = getSqlMapClientTemplate().queryForList("providers.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public Providers selectByPrimaryKey(Long id) {
        Providers key = new Providers();
        key.setId(id);
        Providers record = (Providers) getSqlMapClientTemplate().queryForObject("providers.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int updateByExampleSelective(Providers record, ProvidersExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("providers.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int updateByExample(Providers record, ProvidersExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("providers.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int updateByPrimaryKeySelective(Providers record) {
        int rows = getSqlMapClientTemplate().update("providers.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    public int updateByPrimaryKey(Providers record) {
        int rows = getSqlMapClientTemplate().update("providers.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table providers
     *
     * @ibatorgenerated Wed Nov 10 13:20:00 CST 2010
     */
    private static class UpdateByExampleParms extends ProvidersExample {
        private Object record;

        public UpdateByExampleParms(Object record, ProvidersExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}