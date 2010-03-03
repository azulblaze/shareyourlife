package com.zhelazhela.services;

import com.zhelazhela.db.model.UserPrivacy;

public interface UserPrivacyService {
	/**
	 * 是否允许被关注
	 */
	public final static int TYPE_ALLOW_CARE = 1;
	/**
	 * 是否允许查看个人页面
	 */
	public final static int TYPE_ALLOW_VIEW = 2;
	/**
	 * 是否允许被邀请加入组
	 */
	public final static int TYPE_ALLOW_GROUPADD = 3;
	/**
	 * 允许创建的组数量
	 */
	public final static int TYPE_MAX_GROUP = 4;
	/**
	 * 允许所有注册用户
	 */
	public final static int ALLOW_PRAMETER_USER = 1;
	/**
	 * 允许好友
	 */
	public final static int ALLOW_PRAMETER_FRIEND = 2;
	/**
	 * 需要通过消息申请
	 */
	public final static int ALLOW_PRAMETER_APPLY = 3;
	/**
	 * 拒绝
	 */
	public final static int ALLOW_PRAMETER_DENEY = 4;

	public java.util.List<UserPrivacy> loadUserPrivacy(long user_id) throws Exception;
	
	public UserPrivacy loadUserPrivacy(long user_id,int type) throws Exception;
	
	public void initPrivacy(long user_id) throws Exception;
	
	public UserPrivacy addPrivacy(long user_id,int type,int prame1,int prame2) throws Exception;
}
