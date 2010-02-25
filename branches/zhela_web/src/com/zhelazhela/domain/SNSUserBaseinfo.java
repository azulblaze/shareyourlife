package com.zhelazhela.domain;

import com.zhelazhela.db.model.Userinfo;

public class SNSUserBaseinfo {

	private long id;
	
	private UserPrivate userPrivate;
	
	private String email;
	
	private java.util.Date reg_date;
	
	private java.util.Date last_log;
	
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
	
	public UserPrivate getUserPrivate() {
		return userPrivate;
	}

	public void setUserPrivate(UserPrivate userPrivate) {
		this.userPrivate = userPrivate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(java.util.Date regDate) {
		reg_date = regDate;
	}

	public java.util.Date getLast_log() {
		return last_log;
	}

	public void setLast_log(java.util.Date lastLog) {
		last_log = lastLog;
	}

	public void setUserinfo(Userinfo ui){
		setId(ui.getUserId());
		setHeader(ui.getAvatar());
		setEmail(ui.getEmail());
		setName(ui.getName());
		setReg_date(ui.getRegisteredDate());
		setLast_log(ui.getLastLogin());
	}
}
