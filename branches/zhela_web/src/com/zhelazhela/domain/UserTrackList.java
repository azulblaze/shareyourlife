package com.zhelazhela.domain;

import com.zhelazhela.db.model.define.UserTrack;

public class UserTrackList extends BaseList {

	public java.util.List<UserTrack> list;

	public java.util.List<UserTrack> getList() {
		return list;
	}

	public void setList(java.util.List<UserTrack> list) {
		this.list = list;
		this.c_size = list.size();
	}
	
}
