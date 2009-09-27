package com.twitpic.services;

public interface FriendService {
	/**
	 * 
	 * @param account who want to create group
	 * @param name  the group's name
	 * @return the group model
	 * @throws Exception
	 */
	public com.twitpic.db.model.Group create_group(String account, String name) throws Exception;
	/**
	 * 
	 * @param account who want to update the group name
	 * @param id the group that want to be updated
	 * @param name the new name that will be apply
	 * @return the group model
	 * @throws Exception
	 */
	public com.twitpic.db.model.Group update_group(String account, Long id, String name) throws Exception;
	/**
	 * If you delete the group, all the users that belong to this group will be deleted
	 * @param account who want to delete the group
	 * @param id the group that will be deleted
	 * @return 
	 * @throws Exception
	 */
	public boolean delete_group(String account, Long id) throws Exception;
	/**
	 * user add friend without group
	 * @param account who want to add the friend
	 * @param friend the friend that will be added
	 * @return
	 * @throws Exception
	 */
	public Integer apply_friend(String account,String friend) throws Exception;

	/**
	 * 
	 * @param account who want to add the friend
	 * @param friend the friend that will be added
	 * @param id_group the friend will be applied to this group
	 * @return
	 * @throws Exception
	 */
	public Integer apply_friend(String account,String friend,Long id_group) throws Exception;
	/**
	 * 
	 * @param account who want to add the friend 
	 * @param friend the friend that will be added
	 * @param name_group the friend will be applied to this group
	 * @return
	 * @throws Exception
	 */
	public Integer apply_friend(String account,String friend,String name_group) throws Exception;
	/**
	 * 
	 * @param account who want to confirm friend 
	 * @param id the friend that will be confirmed
	 * @return
	 * @throws Exception
	 */
	public Integer confirm_friend(String account,Long id) throws Exception;
	/**
	 * 
	 * @param account who want to reject friend 
	 * @param id the friend that will be rejected
	 * @return
	 * @throws Exception
	 */
	public Integer reject_friend(String account,Long id) throws Exception;
	/**
	 * 
	 * @param account who want to delete friend 
	 * @param id the friend that will be deleted
	 * @return
	 * @throws Exception
	 */
	public boolean delete_friend(String account,Long id) throws Exception;
	
	/**
	 * 删除某一好友
	 * @param account
	 * @param friend_account
	 * @return
	 * @throws Exception
	 */
	public boolean delete_friend(String account, String friend_account) throws Exception;
	
}
