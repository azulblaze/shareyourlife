package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.BlogTag;
import com.zhelazhela.db.model.BlogTagExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BlogTagDAOImpl extends SqlMapClientDaoSupport implements BlogTagDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public BlogTagDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int countByExample(BlogTagExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("blog_tag.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int deleteByExample(BlogTagExample example) {
        int rows = getSqlMapClientTemplate().delete("blog_tag.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        BlogTag key = new BlogTag();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("blog_tag.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public void insert(BlogTag record) {
        getSqlMapClientTemplate().insert("blog_tag.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public void insertSelective(BlogTag record) {
        getSqlMapClientTemplate().insert("blog_tag.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<BlogTag> selectByExample(BlogTagExample example) {
        List<BlogTag> list = getSqlMapClientTemplate().queryForList("blog_tag.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public BlogTag selectByPrimaryKey(Long id) {
        BlogTag key = new BlogTag();
        key.setId(id);
        BlogTag record = (BlogTag) getSqlMapClientTemplate().queryForObject("blog_tag.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int updateByExampleSelective(BlogTag record, BlogTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("blog_tag.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int updateByExample(BlogTag record, BlogTagExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("blog_tag.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int updateByPrimaryKeySelective(BlogTag record) {
        int rows = getSqlMapClientTemplate().update("blog_tag.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    public int updateByPrimaryKey(BlogTag record) {
        int rows = getSqlMapClientTemplate().update("blog_tag.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table blog_tag
     *
     * @ibatorgenerated Wed Jan 27 10:34:47 CST 2010
     */
    private static class UpdateByExampleParms extends BlogTagExample {
        private Object record;

        public UpdateByExampleParms(Object record, BlogTagExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public long insertSelectiveReturnId(BlogTag record) {
		return (Long)getSqlMapClientTemplate().insert("blog_tag.insertSelective_returnId", record);
	}
}