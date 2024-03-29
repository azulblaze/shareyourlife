package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.UserPrivacy;
import com.zhelazhela.db.model.UserPrivacyExample;
import java.util.List;

public interface UserPrivacyDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int countByExample(UserPrivacyExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByExample(UserPrivacyExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insert(UserPrivacy record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insertSelective(UserPrivacy record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    List<UserPrivacy> selectByExample(UserPrivacyExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    UserPrivacy selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExampleSelective(UserPrivacy record, UserPrivacyExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExample(UserPrivacy record, UserPrivacyExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKeySelective(UserPrivacy record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_privacy
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKey(UserPrivacy record);
}