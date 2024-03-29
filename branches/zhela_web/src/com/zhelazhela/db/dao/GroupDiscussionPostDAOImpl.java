package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GroupDiscussionPost;
import com.zhelazhela.db.model.GroupDiscussionPostExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class GroupDiscussionPostDAOImpl extends SqlMapClientDaoSupport implements GroupDiscussionPostDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public GroupDiscussionPostDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int countByExample(GroupDiscussionPostExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("group_discussion_post.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByExample(GroupDiscussionPostExample example) {
        int rows = getSqlMapClientTemplate().delete("group_discussion_post.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        GroupDiscussionPost key = new GroupDiscussionPost();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("group_discussion_post.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insert(GroupDiscussionPost record) {
        getSqlMapClientTemplate().insert("group_discussion_post.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void insertSelective(GroupDiscussionPost record) {
        getSqlMapClientTemplate().insert("group_discussion_post.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<GroupDiscussionPost> selectByExampleWithBLOBs(GroupDiscussionPostExample example) {
        List<GroupDiscussionPost> list = getSqlMapClientTemplate().queryForList("group_discussion_post.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<GroupDiscussionPost> selectByExampleWithoutBLOBs(GroupDiscussionPostExample example) {
        List<GroupDiscussionPost> list = getSqlMapClientTemplate().queryForList("group_discussion_post.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public GroupDiscussionPost selectByPrimaryKey(Long id) {
        GroupDiscussionPost key = new GroupDiscussionPost();
        key.setId(id);
        GroupDiscussionPost record = (GroupDiscussionPost) getSqlMapClientTemplate().queryForObject("group_discussion_post.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExampleSelective(GroupDiscussionPost record, GroupDiscussionPostExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExampleWithBLOBs(GroupDiscussionPost record, GroupDiscussionPostExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByExampleWithoutBLOBs(GroupDiscussionPost record, GroupDiscussionPostExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKeySelective(GroupDiscussionPost record) {
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKeyWithBLOBs(GroupDiscussionPost record) {
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public int updateByPrimaryKeyWithoutBLOBs(GroupDiscussionPost record) {
        int rows = getSqlMapClientTemplate().update("group_discussion_post.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table group_discussion_post
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private static class UpdateByExampleParms extends GroupDiscussionPostExample {
        private Object record;

        public UpdateByExampleParms(Object record, GroupDiscussionPostExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}