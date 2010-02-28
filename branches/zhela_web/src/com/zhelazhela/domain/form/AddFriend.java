package com.zhelazhela.domain.form;

public class AddFriend {

	private long s_user_id;
	
	private long d_user_id;
	
	private String msg;

	public long getS_user_id() {
		return s_user_id;
	}

	public void setS_user_id(long sUserId) {
		s_user_id = sUserId;
	}

	public long getD_user_id() {
		return d_user_id;
	}

	public void setD_user_id(long dUserId) {
		d_user_id = dUserId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isValid(){
		if(s_user_id>0&&d_user_id>0){
			return true;
		}
		return false;
	}
}
