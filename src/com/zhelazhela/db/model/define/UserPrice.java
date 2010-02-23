package com.zhelazhela.db.model.define;

public class UserPrice {
	private Long id;
	private Long goods_id;
	private String goods_sn;
	private Long user_id;
	private String user_name;
	private String user_avatar;
	private Float price;
	private String topic;
	private Long cert_id;
	private String cert_name;
	private String cert_icon;
	private String cert_description;
	private String cert_parameter;
	private java.util.Date cert_date;
	private java.util.List<UserPriceAddr> priceaddr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goodsId) {
		goods_id = goodsId;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long userId) {
		user_id = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String userAvatar) {
		user_avatar = userAvatar;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Long getCert_id() {
		return cert_id;
	}
	public void setCert_id(Long certId) {
		cert_id = certId;
	}
	public String getCert_name() {
		return cert_name;
	}
	public void setCert_name(String certName) {
		cert_name = certName;
	}
	public String getCert_icon() {
		return cert_icon;
	}
	public void setCert_icon(String certIcon) {
		cert_icon = certIcon;
	}
	public String getCert_description() {
		return cert_description;
	}
	public void setCert_description(String certDescription) {
		cert_description = certDescription;
	}
	public String getCert_parameter() {
		return cert_parameter;
	}
	public void setCert_parameter(String certParameter) {
		cert_parameter = certParameter;
	}
	public java.util.Date getCert_date() {
		return cert_date;
	}
	public void setCert_date(java.util.Date certDate) {
		cert_date = certDate;
	}
	public java.util.List<UserPriceAddr> getPriceaddr() {
		return priceaddr;
	}
	public void setPriceaddr(java.util.List<UserPriceAddr> priceaddr) {
		this.priceaddr = priceaddr;
	}
	public String getGoods_sn() {
		return goods_sn;
	}
	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}
	
	
}
