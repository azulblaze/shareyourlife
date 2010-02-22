package com.zhelazhela.db.model;

import java.util.Date;

public class GoodsTrack {
	
	public static final int VISIBILITY_SELF = 2;
		
	public static final int VISIBILITY_REG = 1;
	
	public static final int VISIBILITY_ALL = 0;
	
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.user_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long userId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.goods_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long goodsId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.visibility
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Integer visibility;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.ratting
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Float ratting;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.SN
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private String sn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.trackprice
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Boolean trackprice;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Date updateTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column goods_track.goods_tag_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    private Long goodsTagId;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.id
     *
     * @return the value of goods_track.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.id
     *
     * @param id the value for goods_track.id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.user_id
     *
     * @return the value of goods_track.user_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.user_id
     *
     * @param userId the value for goods_track.user_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.goods_id
     *
     * @return the value of goods_track.goods_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.goods_id
     *
     * @param goodsId the value for goods_track.goods_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.visibility
     *
     * @return the value of goods_track.visibility
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.visibility
     *
     * @param visibility the value for goods_track.visibility
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.ratting
     *
     * @return the value of goods_track.ratting
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Float getRatting() {
        return ratting;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.ratting
     *
     * @param ratting the value for goods_track.ratting
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setRatting(Float ratting) {
        this.ratting = ratting;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.SN
     *
     * @return the value of goods_track.SN
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public String getSn() {
        return sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.SN
     *
     * @param sn the value for goods_track.SN
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.trackprice
     *
     * @return the value of goods_track.trackprice
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Boolean getTrackprice() {
        return trackprice;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.trackprice
     *
     * @param trackprice the value for goods_track.trackprice
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setTrackprice(Boolean trackprice) {
        this.trackprice = trackprice;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.update_time
     *
     * @return the value of goods_track.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.update_time
     *
     * @param updateTime the value for goods_track.update_time
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column goods_track.goods_tag_id
     *
     * @return the value of goods_track.goods_tag_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public Long getGoodsTagId() {
        return goodsTagId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column goods_track.goods_tag_id
     *
     * @param goodsTagId the value for goods_track.goods_tag_id
     *
     * @ibatorgenerated Fri Feb 12 23:38:37 CST 2010
     */
    public void setGoodsTagId(Long goodsTagId) {
        this.goodsTagId = goodsTagId;
    }
}