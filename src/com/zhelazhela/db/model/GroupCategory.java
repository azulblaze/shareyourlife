package com.zhelazhela.db.model;

import java.util.Date;

public class GroupCategory {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column group_category.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column group_category.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private String name;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column group_category.description
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private String description;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column group_category.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Date updateTime;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column group_category.id
     *
     * @return the value of group_category.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column group_category.id
     *
     * @param id the value for group_category.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column group_category.name
     *
     * @return the value of group_category.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column group_category.name
     *
     * @param name the value for group_category.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column group_category.description
     *
     * @return the value of group_category.description
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column group_category.description
     *
     * @param description the value for group_category.description
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column group_category.update_time
     *
     * @return the value of group_category.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column group_category.update_time
     *
     * @param updateTime the value for group_category.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}