package com.zhelazhela.db.model.define;

public class UserPriceAddr {
	private Long buy_addr_id;
	private Long price_id;
	private Integer addr_type;
	private String buy_link;
	private String buy_country;
	private String buy_state_province;
	private String buy_city;
	private String buy_addr;
	private Integer addr_status;
	private Float longitude;
	private Float latitude;
	public Long getBuy_addr_id() {
		return buy_addr_id;
	}
	public void setBuy_addr_id(Long buyAddrId) {
		buy_addr_id = buyAddrId;
	}
	public Long getPrice_id() {
		return price_id;
	}
	public void setPrice_id(Long priceId) {
		price_id = priceId;
	}
	public Integer getAddr_type() {
		return addr_type;
	}
	public void setAddr_type(Integer addrType) {
		addr_type = addrType;
	}
	public String getBuy_link() {
		return buy_link;
	}
	public void setBuy_link(String buyLink) {
		buy_link = buyLink;
	}
	public String getBuy_country() {
		return buy_country;
	}
	public void setBuy_country(String buyCountry) {
		buy_country = buyCountry;
	}
	public String getBuy_state_province() {
		return buy_state_province;
	}
	public void setBuy_state_province(String buyStateProvince) {
		buy_state_province = buyStateProvince;
	}
	public String getBuy_city() {
		return buy_city;
	}
	public void setBuy_city(String buyCity) {
		buy_city = buyCity;
	}
	public String getBuy_addr() {
		return buy_addr;
	}
	public void setBuy_addr(String buyAddr) {
		buy_addr = buyAddr;
	}
	public Integer getAddr_status() {
		return addr_status;
	}
	public void setAddr_status(Integer addrStatus) {
		addr_status = addrStatus;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
}
