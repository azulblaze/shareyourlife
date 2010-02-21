package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GoodsTag;
import com.zhelazhela.db.model.GoodsTagExample;
import java.util.List;

public interface GoodsTagDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int countByExample(GoodsTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByExample(GoodsTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insert(GoodsTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insertSelective(GoodsTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    List<GoodsTag> selectByExample(GoodsTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    GoodsTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExampleSelective(GoodsTag record, GoodsTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExample(GoodsTag record, GoodsTagExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKeySelective(GoodsTag record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table goods_tag
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKey(GoodsTag record);
}