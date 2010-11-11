package com.zhela.cloudblog.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="categoryList")
@XmlType(propOrder={"size","categories"})
public class RESTCategoryList {
	private int size;
	private java.util.List<RESTCategory> categories;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@XmlElement(name="categories")
	public java.util.List<RESTCategory> getCategories() {
		return categories;
	}
	public void setCategories(java.util.List<RESTCategory> categories) {
		this.categories = categories;
		this.size = categories.size();
	}
	
	
}
