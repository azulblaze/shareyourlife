package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.FriendList;
import com.zhelazhela.db.model.FriendListExample;
import com.zhelazhela.domain.SNSUserBaseinfo;

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
    
    /**
     * 获得该用户跟踪了哪些用户
     * @param userid
     * @param blocked_user
     * @return
     */
    java.util.List<SNSUserBaseinfo> loadUserTracked(long userid,java.util.List<Long> blocked_user,int page,int pagesize);
    /**
     * 统计用户跟踪用户的数量
     * @param userid
     * @param blocked_user
     * @return
     */
    int countUserTracked(long userid,java.util.List<Long> blocked_user);
    /**
     * 获得该用户被哪些用户跟踪
     * @param userid
     * @param blocked_user
     * @return
     */
    java.util.List<SNSUserBaseinfo> loadUserBeenTracked(long userid,java.util.List<Long> blocked_user,int page,int pagesize);
    /**
     * 统计该用户被跟踪用户的数量
     * @param userid
     * @param blocked_user
     * @return
     */
    int countUserBeenTracked(long userid,java.util.List<Long> blocked_user);
}