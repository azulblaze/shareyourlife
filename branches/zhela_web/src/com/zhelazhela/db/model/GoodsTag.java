package com.zhelazhela.db.model;

import java.util.Date;

public class GoodsTag {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_tag.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_tag.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private String name;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_tag.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Date updateTime;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_tag.id
     *
     * @return the value of goods_tag.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_tag.id
     *
     * @param id the value for goods_tag.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_tag.name
     *
     * @return the value of goods_tag.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_tag.name
     *
     * @param name the value for goods_tag.name
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_tag.update_time
     *
     * @return the value of goods_tag.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_tag.update_time
     *
     * @param updateTime the value for goods_tag.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}