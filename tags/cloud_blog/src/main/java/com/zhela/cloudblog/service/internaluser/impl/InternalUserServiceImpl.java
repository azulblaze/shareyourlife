package com.zhela.cloudblog.service.internaluser.impl;

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

public class InternalUserServiceImpl implements InternalUserService {

	@Override
	public ProviderUser addProviderUser(long providerId, String account,
			String userAccount, int status, String token, String tokenSecret,
			String tokenMore) throws Exception {
		ProviderUser record = new ProviderUser();
		record.setAccount(account);
		record.setProviderId(providerId);
		record.setStatus(status);
		record.setToken(token);
		record.setTokenMore(tokenMore);
		record.setTokenSecret(tokenSecret);
		record.setUpdateTime(new java.util.Date());
		record.setUsersAccount(userAccount);
		providerUserDAO.insert(record);
		return record;
	}

	@Override
	public List<ProviderUser> getProviderAccount(String account)
			throws Exception {
		ProviderUserExample pue = new ProviderUserExample();
		pue.createCriteria().andAccountEqualTo(account);
		return providerUserDAO.selectByExample(pue);
	}

	@Override
	public Users getUsers(String account, String password) throws Exception {
		UsersExample ue = new UsersExample();
		ue.createCriteria().andAccountEqualTo(account);
		java.util.List<Users> list = usersDAO.selectByExample(ue);
		if(list.size()>0){
			Users u = list.get(0);
			if(u.getPassword().equals(password)){
				return u;
			}else{
				throw new Exception("Your password is wrong");
			}
		}else{
			throw new Exception("No this account");
		}
	}

	@Override
	public ProviderUser updateProviderUser(long providerId, String account,
			String userAccount, int status, String token, String tokenSecret,
			String tokenMore) throws Exception {
		ProviderUserKey puk = new ProviderUserKey();
		puk.setAccount(account);
		puk.setProviderId(providerId);
		ProviderUser pu = providerUserDAO.selectByPrimaryKey(puk);
		if(pu!=null){
			if(StringUtils.isNotBlank(userAccount)){
				pu.setUsersAccount(userAccount);
			}
		}
		return null;
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
				throw new Exception("Your password is wrong");
			}
		}else{
			throw new Exception("No this account");
		}
	}
	
	private ProviderUserDAO providerUserDAO;
	private UsersDAO usersDAO;

	public void setProviderUserDAO(ProviderUserDAO providerUserDAO) {
		this.providerUserDAO = providerUserDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
