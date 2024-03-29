package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.UserPrivacy;
import com.zhelazhela.db.model.UserPrivacyExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserPrivacyDAOImpl extends SqlMapClientDaoSupport implements UserPrivacyDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public UserPrivacyDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int countByExample(UserPrivacyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("user_privacy.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByExample(UserPrivacyExample example) {
        int rows = getSqlMapClientTemplate().delete("user_privacy.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        UserPrivacy key = new UserPrivacy();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("user_privacy.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insert(UserPrivacy record) {
        getSqlMapClientTemplate().insert("user_privacy.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insertSelective(UserPrivacy record) {
        getSqlMapClientTemplate().insert("user_privacy.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<UserPrivacy> selectByExample(UserPrivacyExample example) {
        List<UserPrivacy> list = getSqlMapClientTemplate().queryForList("user_privacy.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public UserPrivacy selectByPrimaryKey(Long id) {
        UserPrivacy key = new UserPrivacy();
        key.setId(id);
        UserPrivacy record = (UserPrivacy) getSqlMapClientTemplate().queryForObject("user_privacy.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExampleSelective(UserPrivacy record, UserPrivacyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user_privacy.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExample(UserPrivacy record, UserPrivacyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user_privacy.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKeySelective(UserPrivacy record) {
        int rows = getSqlMapClientTemplate().update("user_privacy.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKey(UserPrivacy record) {
        int rows = getSqlMapClientTemplate().update("user_privacy.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private static class UpdateByExampleParms extends UserPrivacyExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserPrivacyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}