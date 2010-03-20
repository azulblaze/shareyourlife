package com.zhelazhela.services;

import com.zhelazhela.db.model.BaseProfile;
import com.zhelazhela.db.model.ContactProfile;
import com.zhelazhela.db.model.Userinfo;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.SNSUserBaseinfo;
import com.zhelazhela.domain.SNSUserBaseinfoList;

public interface UserProfileService {

	/**
	 * 注册用户
	 * @param user
	 * @param recommendUserId
	 * @return
	 * @throws Exception
	 */
	public SNSUser regUser(SNSUser user,long recommendUserId) throws Exception;
	/**
	 * 验证用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean checkUser(SNSUser user) throws Exception;
	/**
	 * 发送激活邮件
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean reSendActMail(SNSUser user) throws Exception;
	
	public SNSUser logUser(SNSUser user) throws Exception;
	/**
	 * 激活用户
	 * @param id
	 * @param code
	 * @return
	 * @throws Exception
	 */
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
	public SNSUserBaseinfoList loadUserWatcher(long user_id,java.util.List<Long> blocked_user,int page,int pagesize) throws Exception;
	/**
	 * 关注他人
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public SNSUserBaseinfoList loadUserWatching(long user_id,java.util.List<Long> blocked_user,int page,int pagesize) throws Exception;
	
	/**
	 * 获取用户基本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BaseProfile loadBaseProfile(long id) throws Exception;
	/**
	 * 编辑用户基本信息
	 * @param bp
	 * @return
	 * @throws Exception
	 */
	public BaseProfile editBaseProfile(BaseProfile bp) throws Exception;
	/**
	 * 回去用户联系信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public java.util.List<ContactProfile> loadContactProfile(long id) throws Exception;
	/**
	 * 删除用户联系信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delContactProfile(long id,long userid) throws Exception;
	/**
	 * 编辑用户联系信息
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public ContactProfile editContactProfile(ContactProfile cp) throws Exception;
	/**
	 * 
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public ContactProfile addContactProfile(ContactProfile cp) throws Exception;
	/**
	 * 编辑基本信息,注意这里如果为NULL的变量不会更新
	 * @param ui
	 * @return
	 * @throws Exception
	 */
	public Userinfo editUserinfo(Userinfo ui) throws Exception;
	
	public boolean updatePassword(long user_id,String newpass) throws Exception;
}
