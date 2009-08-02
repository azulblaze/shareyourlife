package com.twitpic.db.dao;

import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesExample;
import java.util.List;

public interface PicturesDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    void insert(Pictures record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByPrimaryKey(Pictures record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByPrimaryKeySelective(Pictures record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    List<Pictures> selectByExample(PicturesExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    Pictures selectByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int deleteByExample(PicturesExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int countByExample(PicturesExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByExampleSelective(Pictures record, PicturesExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table pictures
     *
     * @abatorgenerated Sun Aug 02 17:41:31 CST 2009
     */
    int updateByExample(Pictures record, PicturesExample example);
}