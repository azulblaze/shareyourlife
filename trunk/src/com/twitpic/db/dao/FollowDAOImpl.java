package com.twitpic.db.dao;

import com.twitpic.db.model.Follow;
import com.twitpic.db.model.FollowExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class FollowDAOImpl extends SqlMapClientDaoSupport implements FollowDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public FollowDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int countByExample(FollowExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("follows.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int deleteByExample(FollowExample example) {
        int rows = getSqlMapClientTemplate().delete("follows.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        Follow key = new Follow();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("follows.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public void insert(Follow record) {
        getSqlMapClientTemplate().insert("follows.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public void insertSelective(Follow record) {
        getSqlMapClientTemplate().insert("follows.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<Follow> selectByExample(FollowExample example) {
        List<Follow> list = getSqlMapClientTemplate().queryForList("follows.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public Follow selectByPrimaryKey(Long id) {
        Follow key = new Follow();
        key.setId(id);
        Follow record = (Follow) getSqlMapClientTemplate().queryForObject("follows.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int updateByExampleSelective(Follow record, FollowExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("follows.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int updateByExample(Follow record, FollowExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("follows.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int updateByPrimaryKeySelective(Follow record) {
        int rows = getSqlMapClientTemplate().update("follows.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    public int updateByPrimaryKey(Follow record) {
        int rows = getSqlMapClientTemplate().update("follows.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table follows
     *
     * @ibatorgenerated Tue Sep 08 17:33:31 CST 2009
     */
    private static class UpdateByExampleParms extends FollowExample {
        private Object record;

        public UpdateByExampleParms(Object record, FollowExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}