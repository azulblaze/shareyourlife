package com.zhelazhela.db.model.define;

public class UserGoods {
	
	private Long track_id;
	
	private Long goods_id;
	
	private String goods_sn;
	
	private String goods_topic;
	
	private String goods_pic;
	
	private String source;
	
	private String source_domain;
	
	private String tag;
	
	private Integer tag_id;
	
	private Integer track_count;
	
	private java.util.Date track_time;
	
	private Integer istrack;

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goodsId) {
		goods_id = goodsId;
	}

	public String getGoods_sn() {
		return goods_sn;
	}

	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}

	public String getGoods_topic() {
		return goods_topic;
	}

	public void setGoods_topic(String goodsTopic) {
		goods_topic = goodsTopic;
	}

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_pic(String goodsPic) {
		goods_pic = goodsPic;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource_domain() {
		return source_domain;
	}

	public void setSource_domain(String sourceDomain) {
		source_domain = sourceDomain;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getTrack_count() {
		return track_count;
	}

	public void setTrack_count(Integer trackCount) {
		track_count = trackCount;
	}

	public Integer getIstrack() {
		return istrack;
	}

	public void setIstrack(Integer istrack) {
		this.istrack = istrack;
	}

	public java.util.Date getTrack_time() {
		return track_time;
	}

	public void setTrack_time(java.util.Date trackTime) {
		track_time = trackTime;
	}

	public Long getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Long trackId) {
		track_id = trackId;
	}

	public Integer getTag_id() {
		return tag_id;
	}

	public void setTag_id(Integer tagId) {
		tag_id = tagId;
	}
	
	
}
