package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="coordinate")
public class RESTCoordinate {
	private long longitude;
	private long latitude;
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
}
