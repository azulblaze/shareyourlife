package com.zhelazhela.domain;


import org.apache.commons.lang.StringUtils;

import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.util.CommonMethod;

public class SNSUser {
		
	private boolean md5 = false;
	
	private String mdpass;
	
	private long id;
	
	private String account;
	
	private String password;
	
	private String repassword;
	
	private String name;
	
	private String email;
	
	private String activity;
		
	private long questionid;
	
	private String answer;
	
	private String avatar;
	
	private String avatar_pic;
	
	private java.util.Date reg_date;
	
	private java.util.Date last_log;
	
	private int reg_level = 0;
	
	private java.util.List<Long> block_user;
	
	private java.util.List<Long> been_blocked;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getMdpass() {
		if(!md5){
			mdpass = CommonMethod.newInstance().getMD5(password);
		}
		return mdpass;
	}

	public boolean isValid(){
		if(StringUtils.isBlank(account)||StringUtils.isBlank(name)||StringUtils.isBlank(email)||StringUtils.isBlank(password)||StringUtils.isBlank(repassword)||(!password.equals(repassword))){
			return false;
		}
		return true;
	}

	public long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getReg_level() {
		return reg_level;
	}

	public void setReg_level(int regLevel) {
		reg_level = regLevel;
	}

	public java.util.List<Long> getBlock_user() {
		return block_user;
	}

	public void setBlock_user(java.util.List<Long> blockUser) {
		block_user = blockUser;
	}

	public java.util.List<Long> getBeen_blocked() {
		return been_blocked;
	}

	public void setBeen_blocked(java.util.List<Long> beenBlocked) {
		been_blocked = beenBlocked;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar_pic() {
		return avatar_pic;
	}

	public void setAvatar_pic(String avatarPic) {
		avatar_pic = avatarPic;
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

	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof SNSUser){			
			Long _id = ((SNSUser) arg0).getId();
			return _id.equals(this.id);
		}
		return false;
	}
	
	public void setUserinfo(Userinfo ui){
		setId(ui.getUserId());
		setAvatar(ui.getAvatar());
		setAvatar_pic(ui.getAvatarPic());
		setEmail(ui.getEmail());
		setName(ui.getName());
		setReg_date(ui.getRegisteredDate());
		setLast_log(ui.getLastLogin());
	}
}
