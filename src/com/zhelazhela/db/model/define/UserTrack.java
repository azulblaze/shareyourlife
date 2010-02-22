package com.zhelazhela.db.model.define;

public class UserTrack {
	private String tag;
	private Long tag_id;
	private Float ratting;
	private Boolean trackprice;
	private java.util.Date track_time;
	private Integer visibility;
	private String user_name;
	private String avatar;
	private Long user_id;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getTag_id() {
		return tag_id;
	}

	public void setTag_id(Long tagId) {
		tag_id = tagId;
	}

	public Float getRatting() {
		return ratting;
	}

	public void setRatting(Float ratting) {
		this.ratting = ratting;
	}

	public Boolean getTrackprice() {
		return trackprice;
	}

	public void setTrackprice(Boolean trackprice) {
		this.trackprice = trackprice;
	}

	public java.util.Date getTrack_time() {
		return track_time;
	}

	public void setTrack_time(java.util.Date trackTime) {
		track_time = trackTime;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

}
