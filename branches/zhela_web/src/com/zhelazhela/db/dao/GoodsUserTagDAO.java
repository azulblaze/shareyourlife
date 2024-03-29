package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GoodsUserTag;
import com.zhelazhela.db.model.GoodsUserTagExample;
import com.zhelazhela.db.model.define.UserTagInfo;

import java.util.List;

public interface GoodsUserTagDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int countByExample(GoodsUserTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByExample(GoodsUserTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insert(GoodsUserTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insertSelective(GoodsUserTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    List<GoodsUserTag> selectByExample(GoodsUserTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    GoodsUserTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExampleSelective(GoodsUserTag record, GoodsUserTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExample(GoodsUserTag record, GoodsUserTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKeySelective(GoodsUserTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_user_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKey(GoodsUserTag record);
    
    java.util.List<UserTagInfo> loadUserTagInfos(long userid);
}