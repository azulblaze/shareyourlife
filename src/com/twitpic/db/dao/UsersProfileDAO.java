package com.twitpic.db.dao;

import com.twitpic.db.model.UsersProfile;
import com.twitpic.db.model.UsersProfileExample;
import java.util.List;

public interface UsersProfileDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    void insert(UsersProfile record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByPrimaryKey(UsersProfile record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByPrimaryKeySelective(UsersProfile record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    List<UsersProfile> selectByExample(UsersProfileExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    UsersProfile selectByPrimaryKey(String account);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int deleteByExample(UsersProfileExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int deleteByPrimaryKey(String account);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int countByExample(UsersProfileExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByExampleSelective(UsersProfile record, UsersProfileExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table users_profile
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByExample(UsersProfile record, UsersProfileExample example);
}