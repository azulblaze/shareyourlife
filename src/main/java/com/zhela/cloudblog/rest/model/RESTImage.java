package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name="image")
@XmlType(propOrder={"thumb","middle","orignal"})
public class RESTImage {

	private String thumb;
	private String middle;
	private String orignal;
	
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getMiddle() {
		return middle;
	}
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	public String getOrignal() {
		return orignal;
	}
	public void setOrignal(String orignal) {
		this.orignal = orignal;
	}
	
	
}
