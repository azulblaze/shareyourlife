package com.zhela.android.core.remote.model;

public class RESTCategoryList {
	private int size;
	private java.util.List<RESTCategory> categories;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public java.util.List<RESTCategory> getCategories() {
		return categories;
	}
	public void setCategories(java.util.List<RESTCategory> categories) {
		this.categories = categories;
		this.size = categories.size();
	}
	
	
}
