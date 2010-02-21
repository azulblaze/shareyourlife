package com.zhelazhela.domain;

public class SNSUserBaseinfo {

	private long id;
	
	private String name;
	
	private String header;
	
	private float rate;
	
	private String tag;
	
	private int tracks;
	
	private int been_tracks;
	
	private int goods;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	public int getBeen_tracks() {
		return been_tracks;
	}

	public void setBeen_tracks(int beenTracks) {
		been_tracks = beenTracks;
	}

	public int getGoods() {
		return goods;
	}

	public void setGoods(int goods) {
		this.goods = goods;
	}
	
}
