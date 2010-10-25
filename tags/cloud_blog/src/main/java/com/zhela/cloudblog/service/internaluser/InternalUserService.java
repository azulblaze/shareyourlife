package com.zhela.cloudblog.service.internaluser;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.model.users.Users;

public interface InternalUserService {

	public Users getUsers(String account,String password) throws Exception;
	
	public Users updateUserPassword(String account,String password,String newPassword) throws Exception;
	
	public java.util.List<ProviderUser> getProviderAccount(String account) throws Exception;
	
	public ProviderUser addProviderUser(long provider_id,String account,String user_account,int status,String token,String token_secret,String token_more) throws Exception;
	
	public ProviderUser updateProviderUser(long provider_id,String account,String user_account,int status,String token,String token_secret,String token_more) throws Exception;
}
