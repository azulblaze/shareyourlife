package com.zhelazhela.services;

import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.SNSUserBaseinfo;
import com.zhelazhela.domain.SNSUserBaseinfoList;

public interface UserProfileService {

	public SNSUser regUser(SNSUser user,long recommendUserId) throws Exception;
	
	public boolean checkUser(SNSUser user) throws Exception;
	
	public boolean reSendActMail(SNSUser user) throws Exception;
	
	public SNSUser logUser(SNSUser user) throws Exception;
	
	public boolean actUser(long id,String code) throws Exception;
	
	public SNSUserBaseinfo loadUserBaseInfo(long id,long myid) throws Exception;
	/**
	 * 统计 被他人关注
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public int countUserWatcher(long user_id) throws Exception;
	/**
	 * 统计 关注他人
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public int countUserWatching(long user_id) throws Exception;
	
	/**
	 * 被他人关注
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public SNSUserBaseinfoList loadUserWatcher(long user_id,java.util.List<Long> blocked_user) throws Exception;
	/**
	 * 关注他人
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public SNSUserBaseinfoList loadUserWatching(long user_id,java.util.List<Long> blocked_user) throws Exception;
}
