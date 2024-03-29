package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.User;
import com.zhelazhela.db.model.UserExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public UserDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int countByExample(UserExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("user.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int deleteByExample(UserExample example) {
        int rows = getSqlMapClientTemplate().delete("user.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        User key = new User();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("user.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public void insert(User record) {
        getSqlMapClientTemplate().insert("user.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public void insertSelective(User record) {
        getSqlMapClientTemplate().insert("user.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<User> selectByExample(UserExample example) {
        List<User> list = getSqlMapClientTemplate().queryForList("user.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public User selectByPrimaryKey(Long id) {
        User key = new User();
        key.setId(id);
        User record = (User) getSqlMapClientTemplate().queryForObject("user.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int updateByExampleSelective(User record, UserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int updateByExample(User record, UserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("user.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int updateByPrimaryKeySelective(User record) {
        int rows = getSqlMapClientTemplate().update("user.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    public int updateByPrimaryKey(User record) {
        int rows = getSqlMapClientTemplate().update("user.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table user
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    private static class UpdateByExampleParms extends UserExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public int countAllUser() {
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("user.coutAllUser", null);
        return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> loadAllUserIdByPage(int page, int pagesize) {
		java.util.Map<String, String> map = new java.util.HashMap<String, String>();
		if(pagesize>0){
			map.put("limit", ""+(page-1)*pagesize+","+pagesize);
		}
		List<Long> list = getSqlMapClientTemplate().queryForList("user.loadAllUser", map);
        return list;
	}
}