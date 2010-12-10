package com.zhela.cloudblog.service.internaluser.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.dao.users.ProviderUserDAO;
import com.zhela.cloudblog.dao.users.UsersDAO;
import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.model.users.ProviderUserExample;
import com.zhela.cloudblog.model.users.ProviderUserKey;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.model.users.UsersExample;
import com.zhela.cloudblog.service.internaluser.InternalUserService;
import com.zhela.cloudblog.service.tweet.TweetService;
import com.zhela.cloudblog.util.CommonMethod;

public class InternalUserServiceImpl implements InternalUserService {

	@Override
	public ProviderUser insertProviderUser(long providerId,String account,String providerAccount,String provider_userId, 
			 int status, String token, String tokenSecret,
			String tokenMore) throws Exception {
		ProviderUser record = new ProviderUser();
		record.setAccount(account);
		record.setProviderUserid(provider_userId);
		record.setProviderId(providerId);
		record.setStatus(status);
		record.setToken(token);
		record.setTokenMore(tokenMore);
		record.setTokenSecret(tokenSecret);
		record.setUpdateTime(new java.util.Date());
		record.setProviderAccount(providerAccount);
		providerUserDAO.insert(record);
		//update user.update_time
		Users _user = new Users();
		_user.setAccount(account);
		_user.setUpdateTime(new java.util.Date());
		usersDAO.updateByPrimaryKeySelective(_user);
		return getProviderAccount(account,providerId,providerAccount);
	}

	@Override
	public List<ProviderUser> getProviderAccount(String account)
			throws Exception {
		ProviderUserExample pue = new ProviderUserExample();
		pue.createCriteria().andAccountEqualTo(account);
		return providerUserDAO.selectByExample(pue);
	}
	
	private ProviderUser getProviderAccount(String account,long providerId,String providerAccount)
			throws Exception {
		ProviderUserExample pue = new ProviderUserExample();
		pue.createCriteria().andAccountEqualTo(account).andProviderIdEqualTo(providerId).andProviderAccountEqualTo(providerAccount);
		List<ProviderUser> list = providerUserDAO.selectByExample(pue);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Users getUsers(String account, String password) throws Exception {
		Users u = getUsers(account);
		if(u.getPassword().equals(password)){
			return u;
		}else{
			throw new Exception("密码错误");
		}
	}
	
	private Users getUsers(String account) throws Exception {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andAccountEqualTo(account);
		java.util.List<Users> list = usersDAO.selectByExample(ue);
		if(list.size()>0){
			Users u = list.get(0);
			return u;
		}else{
			throw new Exception("不存在该帐号");
		}
	}

	@Override
	public ProviderUser updateProviderUser(long providerId,String account,String providerAccount,Integer status,String username,String password) throws Exception {
		ProviderUserKey puk = new ProviderUserKey();
		puk.setAccount(account);
		puk.setProviderAccount(providerAccount);
		puk.setProviderId(providerId);
		ProviderUser pu = providerUserDAO.selectByPrimaryKey(puk);
		if(pu!=null){
			if(status!=null){
				pu.setStatus(status);
			}
			if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
				java.util.Map<String,String> result = tweetService.selectTweetAccount(providerId,username,password);
				pu.setToken(result.get("token"));
				pu.setTokenSecret(result.get("tokenSecret"));
				pu.setTokenMore(result.get("tokenMore"));
				pu.setProviderUserid(result.get("userId"));
				
			}
			providerUserDAO.updateByPrimaryKey(pu);
			//update user.update_time
			Users _user = new Users();
			_user.setAccount(account);
			_user.setUpdateTime(new java.util.Date());
			usersDAO.updateByPrimaryKeySelective(_user);
			return pu;
		}else{
			if(password==null){
				return null;
			}
			java.util.Map<String,String> result = tweetService.selectTweetAccount(providerId,username,password);
			return insertProviderUser(providerId,account,
					providerAccount,result.get("userId"),status,result.get("token"),result.get("tokenSecret"),
					result.get("tokenMore"));
		}
	}
	
	@Override
	public Users updateUserPassword(String account, String password,
			String newPassword) throws Exception {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andAccountEqualTo(account);
		java.util.List<Users> list = usersDAO.selectByExample(ue);
		if(list.size()>0){
			Users u = list.get(0);
			if(u.getPassword().equals(password)){
				u.setPassword(newPassword);
				usersDAO.updateByPrimaryKey(u);
				return u;
			}else{
				throw new Exception("原始密码错误");
			}
		}else{
			throw new Exception("不存在该账号");
		}
	}

	@Override
	public Users insertUsers(String account, String password, String email,
			String displayName) throws Exception {
		if(usersDAO.selectByPrimaryKey(account)!=null){
			throw new Exception("帐号已经存在");
		}
		UsersExample ue = new UsersExample();
		ue.createCriteria().andDisplayNameEqualTo(displayName);
		if(usersDAO.selectByExample(ue).size()>0){
			throw new Exception("名字已经存在");
		}
		Users _users = new Users();
		_users.setAccount(account);
		_users.setDisplayName(displayName);
		_users.seteMail(email);
		_users.setHeader(Users.DEFAULT_HEADER);
		_users.setPassword(password);
		_users.setUpdateTime(new java.util.Date());
		usersDAO.insert(_users);
		return getUsers(account);
	}

	@Override
	public Users updateUsersHeader(String account, InputStream header,String root_path,String filetype)
			throws Exception {
		String path;
		CommonMethod commonmethod = CommonMethod.getInstance();
		try{
			Users __users = usersDAO.selectByPrimaryKey(account);
			if(__users!=null&&__users.getHeader()!=null){
				commonmethod.deleteFile(root_path+__users.getHeader());
			}
			path = commonmethod.saveImg(header, root_path, "/upload/header", filetype);
		}catch(Exception e){
			throw new Exception("保持图片失败");
		}
		Users _users = new Users();
		_users.setAccount(account);
		_users.setHeader(path);
		usersDAO.updateByPrimaryKeySelective(_users);
		return _users;
	}

	@Override
	public int delProviderUser(long providerId, String account,
			String providerAccount) throws Exception {
		ProviderUserKey puk = new ProviderUserKey();
		puk.setAccount(account);
		puk.setProviderAccount(providerAccount);
		puk.setProviderId(providerId);
		return providerUserDAO.deleteByPrimaryKey(puk);
	}
	
	
	
	private ProviderUserDAO providerUserDAO;
	private UsersDAO usersDAO;
	private TweetService tweetService;

	public void setProviderUserDAO(ProviderUserDAO providerUserDAO) {
		this.providerUserDAO = providerUserDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public void setTweetService(TweetService tweetService) {
		this.tweetService = tweetService;
	}

}
