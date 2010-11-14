package com.zhela.android.core.remote.model;

public class RESTCategory {
	private long id;
	private int rank;
	private String name;
	private String description;
	private String path;
	private java.util.List<RESTCategory> subCategories;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public java.util.List<RESTCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(java.util.List<RESTCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
}
