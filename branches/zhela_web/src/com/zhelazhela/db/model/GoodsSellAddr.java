package com.zhelazhela.db.model;

import java.util.Date;

public class GoodsSellAddr {
	
	public static final int WEB = 1;
	
	public static final int STREET = 2;

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Long id;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.goods_price_id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Long goodsPriceId;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.addr_type
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Integer addrType;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.buy_link
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private String buyLink;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.buy_country
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private String buyCountry;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.buy_state_province
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private String buyStateProvince;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.buy_city
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private String buyCity;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.buy_addr
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private String buyAddr;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.status
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Integer status;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.longitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Float longitude;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.latitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Float latitude;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column goods_sell_addr.update_time
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	private Date updateTime;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.id
	 * @return  the value of goods_sell_addr.id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.id
	 * @param id  the value for goods_sell_addr.id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.goods_price_id
	 * @return  the value of goods_sell_addr.goods_price_id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Long getGoodsPriceId() {
		return goodsPriceId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.goods_price_id
	 * @param goodsPriceId  the value for goods_sell_addr.goods_price_id
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setGoodsPriceId(Long goodsPriceId) {
		this.goodsPriceId = goodsPriceId;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.addr_type
	 * @return  the value of goods_sell_addr.addr_type
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Integer getAddrType() {
		return addrType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.addr_type
	 * @param addrType  the value for goods_sell_addr.addr_type
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setAddrType(Integer addrType) {
		this.addrType = addrType;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.buy_link
	 * @return  the value of goods_sell_addr.buy_link
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public String getBuyLink() {
		return buyLink;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.buy_link
	 * @param buyLink  the value for goods_sell_addr.buy_link
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setBuyLink(String buyLink) {
		this.buyLink = buyLink;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.buy_country
	 * @return  the value of goods_sell_addr.buy_country
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public String getBuyCountry() {
		return buyCountry;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.buy_country
	 * @param buyCountry  the value for goods_sell_addr.buy_country
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setBuyCountry(String buyCountry) {
		this.buyCountry = buyCountry;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.buy_state_province
	 * @return  the value of goods_sell_addr.buy_state_province
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public String getBuyStateProvince() {
		return buyStateProvince;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.buy_state_province
	 * @param buyStateProvince  the value for goods_sell_addr.buy_state_province
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setBuyStateProvince(String buyStateProvince) {
		this.buyStateProvince = buyStateProvince;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.buy_city
	 * @return  the value of goods_sell_addr.buy_city
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public String getBuyCity() {
		return buyCity;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.buy_city
	 * @param buyCity  the value for goods_sell_addr.buy_city
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setBuyCity(String buyCity) {
		this.buyCity = buyCity;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.buy_addr
	 * @return  the value of goods_sell_addr.buy_addr
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public String getBuyAddr() {
		return buyAddr;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.buy_addr
	 * @param buyAddr  the value for goods_sell_addr.buy_addr
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setBuyAddr(String buyAddr) {
		this.buyAddr = buyAddr;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.status
	 * @return  the value of goods_sell_addr.status
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.status
	 * @param status  the value for goods_sell_addr.status
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.longitude
	 * @return  the value of goods_sell_addr.longitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.longitude
	 * @param longitude  the value for goods_sell_addr.longitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.latitude
	 * @return  the value of goods_sell_addr.latitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.latitude
	 * @param latitude  the value for goods_sell_addr.latitude
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column goods_sell_addr.update_time
	 * @return  the value of goods_sell_addr.update_time
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column goods_sell_addr.update_time
	 * @param updateTime  the value for goods_sell_addr.update_time
	 * @ibatorgenerated  Tue Feb 23 16:51:44 CST 2010
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}