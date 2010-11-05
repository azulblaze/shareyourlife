package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coordinate")
public class RESTCoordinate {
	private double longitude;
	private double latitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
}
