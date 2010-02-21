package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.FriendList;
import com.zhelazhela.db.model.FriendListExample;
import java.util.List;

public interface FriendListDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    int countByExample(FriendListExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    int deleteByExample(FriendListExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    void insert(FriendList record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    void insertSelective(FriendList record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    List<FriendList> selectByExample(FriendListExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    int updateByExampleSelective(FriendList record, FriendListExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table friend_list
     *
     * @ibatorgenerated Fri Feb 12 23:38:36 CST 2010
     */
    int updateByExample(FriendList record, FriendListExample example);
}