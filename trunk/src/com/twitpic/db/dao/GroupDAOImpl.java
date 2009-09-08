package com.twitpic.db.dao;

import com.twitpic.db.model.Group;
import com.twitpic.db.model.GroupExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GroupDAOImpl extends SqlMapClientDaoSupport implements GroupDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public GroupDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int countByExample(GroupExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("groups.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int deleteByExample(GroupExample example) {
        int rows = getSqlMapClientTemplate().delete("groups.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        Group key = new Group();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("groups.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public void insert(Group record) {
        getSqlMapClientTemplate().insert("groups.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public void insertSelective(Group record) {
        getSqlMapClientTemplate().insert("groups.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<Group> selectByExample(GroupExample example) {
        List<Group> list = getSqlMapClientTemplate().queryForList("groups.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public Group selectByPrimaryKey(Long id) {
        Group key = new Group();
        key.setId(id);
        Group record = (Group) getSqlMapClientTemplate().queryForObject("groups.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int updateByExampleSelective(Group record, GroupExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("groups.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int updateByExample(Group record, GroupExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("groups.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int updateByPrimaryKeySelective(Group record) {
        int rows = getSqlMapClientTemplate().update("groups.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    public int updateByPrimaryKey(Group record) {
        int rows = getSqlMapClientTemplate().update("groups.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    private static class UpdateByExampleParms extends GroupExample {
        private Object record;

        public UpdateByExampleParms(Object record, GroupExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}