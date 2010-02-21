package com.zhelazhela.domain;

import org.apache.commons.httpclient.URI;

public class GoodsDetail {

	public String name;
	
	public String category;
	
	public String source;
	
	public String source_domain;
	
	public String pic;
	
	public String icon;
		
	public String desc;
	
	public long id;
	
	public String sn;
	
	public GoodCommentList comments;
	
	public int comment_size;
	
	public SNSUserBaseinfoList trackuser;
	
	public int track_size;
	
	public GoodsOfferList offers;
	
	public int offer_size;

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
			URI uri = new URI("http://xx.google.com.cn/dlf/dgflg/test.jsp",false);
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

	public SNSUserBaseinfoList getTrackuser() {
		return trackuser;
	}

	public void setTrackuser(SNSUserBaseinfoList trackuser) {
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
	}

	public int getOffer_size() {
		return offer_size;
	}

	public void setOffer_size(int offerSize) {
		offer_size = offerSize;
	}
	
}
