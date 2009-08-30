package com.twitpic.db.dao;

import com.twitpic.db.model.Permission;
import com.twitpic.db.model.PermissionExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PermissionDAOImpl extends SqlMapClientDaoSupport implements PermissionDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public PermissionDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int countByExample(PermissionExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("permissions.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int deleteByExample(PermissionExample example) {
        int rows = getSqlMapClientTemplate().delete("permissions.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        Permission key = new Permission();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("permissions.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public void insert(Permission record) {
        getSqlMapClientTemplate().insert("permissions.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public void insertSelective(Permission record) {
        getSqlMapClientTemplate().insert("permissions.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<Permission> selectByExample(PermissionExample example) {
        List<Permission> list = getSqlMapClientTemplate().queryForList("permissions.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public Permission selectByPrimaryKey(Long id) {
        Permission key = new Permission();
        key.setId(id);
        Permission record = (Permission) getSqlMapClientTemplate().queryForObject("permissions.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int updateByExampleSelective(Permission record, PermissionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("permissions.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int updateByExample(Permission record, PermissionExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("permissions.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int updateByPrimaryKeySelective(Permission record) {
        int rows = getSqlMapClientTemplate().update("permissions.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    public int updateByPrimaryKey(Permission record) {
        int rows = getSqlMapClientTemplate().update("permissions.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table permissions
     *
     * @ibatorgenerated Sun Aug 30 15:33:51 CST 2009
     */
    private static class UpdateByExampleParms extends PermissionExample {
        private Object record;

        public UpdateByExampleParms(Object record, PermissionExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}