package com.twitpic.db.dao;

import com.twitpic.db.model.Message;
import com.twitpic.db.model.MessageExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MessageDAOImpl extends SqlMapClientDaoSupport implements MessageDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public MessageDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int countByExample(MessageExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("messages.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int deleteByExample(MessageExample example) {
        int rows = getSqlMapClientTemplate().delete("messages.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int deleteByPrimaryKey(Long id) {
        Message key = new Message();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("messages.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public void insert(Message record) {
        getSqlMapClientTemplate().insert("messages.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public void insertSelective(Message record) {
        getSqlMapClientTemplate().insert("messages.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<Message> selectByExampleWithBLOBs(MessageExample example) {
        List<Message> list = getSqlMapClientTemplate().queryForList("messages.ibatorgenerated_selectByExampleWithBLOBs", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    @SuppressWarnings("unchecked")
    public List<Message> selectByExampleWithoutBLOBs(MessageExample example) {
        List<Message> list = getSqlMapClientTemplate().queryForList("messages.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public Message selectByPrimaryKey(Long id) {
        Message key = new Message();
        key.setId(id);
        Message record = (Message) getSqlMapClientTemplate().queryForObject("messages.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByExampleSelective(Message record, MessageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByExampleWithBLOBs(Message record, MessageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByExampleWithBLOBs", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByExampleWithoutBLOBs(Message record, MessageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByPrimaryKeySelective(Message record) {
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByPrimaryKeyWithBLOBs(Message record) {
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    public int updateByPrimaryKeyWithoutBLOBs(Message record) {
        int rows = getSqlMapClientTemplate().update("messages.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table messages
     *
     * @ibatorgenerated Sat Aug 22 21:50:01 CST 2009
     */
    private static class UpdateByExampleParms extends MessageExample {
        private Object record;

        public UpdateByExampleParms(Object record, MessageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}