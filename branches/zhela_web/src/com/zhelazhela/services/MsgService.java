package com.zhelazhela.services;

public interface MsgService {
	
	public void sendAllUser();
	
	public void sendUsers(java.util.List<Long> user_ids);
	
	public void sendFriend(long source,long dest,String content);
	
	public void sendCareMe(long source,String content);
	
	public void sendMecare(long source,String content);
	
	public void sendGroupMembers(long user_id,long group_id,String content);
	
	public void sendCareApply(long source,long dest,String content);
	
	public void sendGroupApply(long source,long groupid,String content);
	
	public void sendGroupInvition(long source,long groupid,long user_id,String content);
}
