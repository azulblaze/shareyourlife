package com.twitpic.db.dao;

import com.twitpic.db.model.ViewedPritures;
import com.twitpic.db.model.ViewedPrituresExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ViewedPrituresDAOImpl extends SqlMapClientDaoSupport implements ViewedPrituresDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public ViewedPrituresDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int countByExample(ViewedPrituresExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("viewed_pritures.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int deleteByExample(ViewedPrituresExample example) {
        int rows = getSqlMapClientTemplate().delete("viewed_pritures.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        ViewedPritures key = new ViewedPritures();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("viewed_pritures.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public void insert(ViewedPritures record) {
        getSqlMapClientTemplate().insert("viewed_pritures.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public void insertSelective(ViewedPritures record) {
        getSqlMapClientTemplate().insert("viewed_pritures.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<ViewedPritures> selectByExample(ViewedPrituresExample example) {
        List<ViewedPritures> list = getSqlMapClientTemplate().queryForList("viewed_pritures.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public ViewedPritures selectByPrimaryKey(Long id) {
        ViewedPritures key = new ViewedPritures();
        key.setId(id);
        ViewedPritures record = (ViewedPritures) getSqlMapClientTemplate().queryForObject("viewed_pritures.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int updateByExampleSelective(ViewedPritures record, ViewedPrituresExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("viewed_pritures.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int updateByExample(ViewedPritures record, ViewedPrituresExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("viewed_pritures.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int updateByPrimaryKeySelective(ViewedPritures record) {
        int rows = getSqlMapClientTemplate().update("viewed_pritures.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    public int updateByPrimaryKey(ViewedPritures record) {
        int rows = getSqlMapClientTemplate().update("viewed_pritures.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table viewed_pritures
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    private static class UpdateByExampleParms extends ViewedPrituresExample {
        private Object record;

        public UpdateByExampleParms(Object record, ViewedPrituresExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public long insert_return_id(ViewedPritures record) {
		return (Long)getSqlMapClientTemplate().insert("viewed_pritures.insert_return_id", record);
	}
}