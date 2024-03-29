package com.zhela.cloudblog.dao.ourservice.impl;

import com.zhela.cloudblog.dao.ourservice.AnswerDAO;
import com.zhela.cloudblog.model.ourservice.Answer;
import com.zhela.cloudblog.model.ourservice.AnswerExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AnswerDAOImpl extends SqlMapClientDaoSupport implements AnswerDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public AnswerDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int countByExample(AnswerExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("answer.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int deleteByExample(AnswerExample example) {
        int rows = getSqlMapClientTemplate().delete("answer.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int deleteByPrimaryKey(Long id) {
        Answer key = new Answer();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("answer.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public void insert(Answer record) {
        getSqlMapClientTemplate().insert("answer.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public void insertSelective(Answer record) {
        getSqlMapClientTemplate().insert("answer.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<Answer> selectByExampleWithBLOBs(AnswerExample example) {
        List<Answer> list = getSqlMapClientTemplate().queryForList("answer.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    @SuppressWarnings("unchecked")
    public List<Answer> selectByExampleWithoutBLOBs(AnswerExample example) {
        List<Answer> list = getSqlMapClientTemplate().queryForList("answer.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public Answer selectByPrimaryKey(Long id) {
        Answer key = new Answer();
        key.setId(id);
        Answer record = (Answer) getSqlMapClientTemplate().queryForObject("answer.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByExampleSelective(Answer record, AnswerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByExampleWithBLOBs(Answer record, AnswerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByExampleWithoutBLOBs(Answer record, AnswerExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByPrimaryKeySelective(Answer record) {
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByPrimaryKeyWithBLOBs(Answer record) {
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    public int updateByPrimaryKeyWithoutBLOBs(Answer record) {
        int rows = getSqlMapClientTemplate().update("answer.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table answer
     *
     * @ibatorgenerated Thu Dec 16 14:30:38 CST 2010
     */
    private static class UpdateByExampleParms extends AnswerExample {
        private Object record;

        public UpdateByExampleParms(Object record, AnswerExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}