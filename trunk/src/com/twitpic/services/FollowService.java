package com.twitpic.services;

public interface FollowService {
	
	/**
	 * we allow the user follow the others default, means no need the user being followed to confirm the follow.
	 * @param src_account 
	 * @param dest_account
	 * @param function the user's action that will be followed
	 * @return
	 * @throws Exception
	 */
	public com.twitpic.db.model.Follow apply_follow(String src_account,String dest_account,String function) throws Exception;
	/**
	 * 
	 * @param account
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public com.twitpic.db.model.Follow reject_follow(String account,Long id) throws Exception;
	/**
	 * 
	 * @param account
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public com.twitpic.db.model.Follow allow_follow(String account,Long id) throws Exception;
}
