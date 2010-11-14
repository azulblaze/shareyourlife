package com.zhela.android.core.remote.model;

public class RESTAddress {
	private String country;
	private String province;
	private String city;
	private String address;
	private RESTCoordinate coordinate;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RESTCoordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(RESTCoordinate coordinate) {
		this.coordinate = coordinate;
	}
	
}
