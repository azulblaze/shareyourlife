package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.GroupWall;
import com.zhelazhela.db.model.GroupWallExample;
import java.util.List;

public interface GroupWallDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int countByExample(GroupWallExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByExample(GroupWallExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int deleteByPrimaryKey(Long groupId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insert(GroupWall record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    void insertSelective(GroupWall record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    List<GroupWall> selectByExample(GroupWallExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    GroupWall selectByPrimaryKey(Long groupId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExampleSelective(GroupWall record, GroupWallExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByExample(GroupWall record, GroupWallExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKeySelective(GroupWall record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table group_wall
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    int updateByPrimaryKey(GroupWall record);
}