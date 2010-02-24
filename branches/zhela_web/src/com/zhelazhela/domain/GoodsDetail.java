package com.zhelazhela.domain;

import org.apache.commons.httpclient.URI;
import org.apache.commons.lang.StringUtils;

import com.zhelazhela.db.model.Goods;
import com.zhelazhela.db.model.GoodsSellAddr;
import com.zhelazhela.db.model.define.UserPrice;
import com.zhelazhela.db.model.define.UserPriceAddr;

public class GoodsDetail {

	public String name;
	
	public String category;
	
	public String source;
	
	public String source_domain;
	
	public String buylink;
	
	public String buylink_domain;
	
	public String pic;
	
	public String icon;
		
	public String desc;
	
	public long id;
	
	public String sn;
	
	public GoodCommentList comments;
	
	public int comment_size;
	
	public UserTrackList trackuser;
	
	public int track_size;
	
	public GoodsOfferList offers;
	
	public int offer_size;
	
	public java.util.Date update_time;

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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public GoodCommentList getComments() {
		return comments;
	}

	public void setComments(GoodCommentList comments) {
		this.comments = comments;
	}

	public int getComment_size() {
		return comment_size;
	}

	public void setComment_size(int commentSize) {
		comment_size = commentSize;
	}

	public UserTrackList getTrackuser() {
		return trackuser;
	}

	public void setTrackuser(UserTrackList trackuser) {
		this.trackuser = trackuser;
	}

	public int getTrack_size() {
		return track_size;
	}

	public void setTrack_size(int trackSize) {
		track_size = trackSize;
	}

	public GoodsOfferList getOffers() {
		return offers;
	}

	public void setOffers(GoodsOfferList offers) {
		this.offers = offers;
		if(offers!=null&&offers.getC_size()>0){
			UserPrice up = offers.getList().get(0);
			if(up!=null&&up.getPriceaddr().size()>0){
				UserPriceAddr upa = up.getPriceaddr().get(0);
				if(upa!=null&&upa.getAddr_type()==GoodsSellAddr.WEB){
					setBuylink(upa.getBuy_link());
				}
			}
		}
	}

	public int getOffer_size() {
		return offer_size;
	}

	public void setOffer_size(int offerSize) {
		offer_size = offerSize;
	}
	
	public java.util.Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(java.util.Date updateTime) {
		update_time = updateTime;
	}

	public String getBuylink() {
		return buylink;
	}

	public void setBuylink(String buylink) {
		this.buylink = buylink;
		try{
			URI uri = new URI(buylink,false);
			if(uri!=null){
				this.buylink_domain = uri.getHost();
			}
		}catch(Exception e){
			
		}
	}

	public String getBuylink_domain() {
		return buylink_domain;
	}

	public void setBuylink_domain(String buylinkDomain) {
		buylink_domain = buylinkDomain;
	}

	public void setGoods(Goods g){
		this.category = g.getCategory();
		this.desc = g.getDescription();
		this.icon = g.getIcon();
		this.id = g.getId();
		this.pic = g.getPicture();
		this.sn = g.getSn();
		setSource(g.getSource());
		this.name = g.getTopic();
		this.update_time = g.getUpdateTime();
		if(StringUtils.isNotBlank(g.getBuyLink())){
			setBuylink(g.getBuyLink());
		}
	}
}
