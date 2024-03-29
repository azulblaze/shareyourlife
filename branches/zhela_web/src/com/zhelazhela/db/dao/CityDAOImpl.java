package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.City;
import com.zhelazhela.db.model.CityExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CityDAOImpl extends SqlMapClientDaoSupport implements CityDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public CityDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int countByExample(CityExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("city.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int deleteByExample(CityExample example) {
        int rows = getSqlMapClientTemplate().delete("city.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        City key = new City();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("city.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public void insert(City record) {
        getSqlMapClientTemplate().insert("city.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public void insertSelective(City record) {
        getSqlMapClientTemplate().insert("city.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<City> selectByExample(CityExample example) {
        List<City> list = getSqlMapClientTemplate().queryForList("city.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public City selectByPrimaryKey(Long id) {
        City key = new City();
        key.setId(id);
        City record = (City) getSqlMapClientTemplate().queryForObject("city.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int updateByExampleSelective(City record, CityExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("city.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int updateByExample(City record, CityExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("city.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int updateByPrimaryKeySelective(City record) {
        int rows = getSqlMapClientTemplate().update("city.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    public int updateByPrimaryKey(City record) {
        int rows = getSqlMapClientTemplate().update("city.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table city
     *
     * @ibatorgenerated Fri Dec 18 11:08:41 CST 2009
     */
    private static class UpdateByExampleParms extends CityExample {
        private Object record;

        public UpdateByExampleParms(Object record, CityExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}