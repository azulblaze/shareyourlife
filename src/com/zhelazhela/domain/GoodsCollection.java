package com.zhelazhela.domain;

import org.apache.commons.lang.StringUtils;

public class GoodsCollection {
	
	public String root_path;
	
	public String name;
	
	public String category;
	
	public String source;
	
	public String pic;
		
	public String desc;
	
	public float rate;
	
	public int track_price;
	
	public String tag;
	
	public long tag_id;
	
	public String comment;
	
	public int share;
	
	public int privacy;
	
	public long user_id;
	
	public String goods_type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getTrack_price() {
		return track_price;
	}

	public void setTrack_price(int trackPrice) {
		track_price = trackPrice;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long userId) {
		user_id = userId;
	}

	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tagId) {
		tag_id = tagId;
	}

	public String getRoot_path() {
		return root_path;
	}

	public void setRoot_path(String rootPath) {
		root_path = rootPath;
	}
	
	public boolean isValid(){
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(source)&&(source.startsWith("http://")||source.startsWith("https://"))){
			return true;
		}
		return false;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goodsType) {
		goods_type = goodsType;
	}
	
	
}
