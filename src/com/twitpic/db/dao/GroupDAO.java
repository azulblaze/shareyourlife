package com.twitpic.db.dao;

import com.twitpic.db.model.Group;
import com.twitpic.db.model.GroupExample;
import java.util.List;

public interface GroupDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int countByExample(GroupExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int deleteByExample(GroupExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    void insert(Group record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    void insertSelective(Group record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    List<Group> selectByExample(GroupExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    Group selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int updateByExampleSelective(Group record, GroupExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int updateByExample(Group record, GroupExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table groups
     *
     * @ibatorgenerated Tue Sep 08 17:06:31 CST 2009
     */
    int updateByPrimaryKey(Group record);
}