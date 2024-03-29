package com.zhelazhela.db.model.define;

import org.apache.commons.httpclient.URI;

/**
 * 商品的信息,用于商品在用户页面的列表,里面包含商品被多少用户关注,商品基本信息,该用户关注商品时使用的标签.
 * @author andy
 *
 */
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
	
	private java.util.List<Long> track_user_id;
	
	private java.util.Date track_time;
	
	private Integer istrack = 0;
	
	private Long myid;
	
	private Integer comment_count;
	
	private Float ratting;

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
		try{
			URI uri = new URI(source,false);
			if(uri!=null){
				this.source_domain = uri.getHost();
			}
		}catch(Exception e){
			
		}
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

	public Long getMyid() {
		return myid;
	}

	public void setMyid(Long myid) {
		this.myid = myid;
	}

	public Integer getComment_count() {
		return comment_count;
	}

	public void setComment_count(Integer commentCount) {
		comment_count = commentCount;
	}

	public Float getRatting() {
		return ratting;
	}

	public void setRatting(Float ratting) {
		this.ratting = ratting;
	}

	public java.util.List<Long> getTrack_user_id() {
		return track_user_id;
	}

	public void setTrack_user_id(java.util.List<Long> trackUserId) {
		track_user_id = trackUserId;
		this.track_count = trackUserId.size();
		if(myid!=null&&myid>0&&track_user_id.contains(myid)){
			istrack = 1;
		}
	}
	
}
