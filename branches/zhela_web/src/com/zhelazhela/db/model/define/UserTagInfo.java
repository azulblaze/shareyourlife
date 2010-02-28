package com.zhelazhela.db.model.define;

public class UserTagInfo {
	
	private Long id;
	
	private Long user_id;
	
	private Long tag_id;
	
	private String tag_name;
	
	private Integer tag_count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

	public Long getTag_id() {
		return tag_id;
	}

	public void setTag_id(Long tagId) {
		tag_id = tagId;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tagName) {
		tag_name = tagName;
	}

	public Integer getTag_count() {
		return tag_count;
	}

	public void setTag_count(Integer tagCount) {
		tag_count = tagCount;
	}
	
}
