package com.twitpic.db.dao;

import com.twitpic.db.model.PicturesCollection;
import com.twitpic.db.model.PicturesCollectionExample;
import java.util.List;

public interface PicturesCollectionDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int countByExample(PicturesCollectionExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int deleteByExample(PicturesCollectionExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    void insert(PicturesCollection record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    void insertSelective(PicturesCollection record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    List<PicturesCollection> selectByExample(PicturesCollectionExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    PicturesCollection selectByPrimaryKey(Long id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int updateByExampleSelective(PicturesCollection record, PicturesCollectionExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int updateByExample(PicturesCollection record, PicturesCollectionExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int updateByPrimaryKeySelective(PicturesCollection record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pictures_collection
     *
     * @ibatorgenerated Wed Sep 02 16:12:27 CST 2009
     */
    int updateByPrimaryKey(PicturesCollection record);
}