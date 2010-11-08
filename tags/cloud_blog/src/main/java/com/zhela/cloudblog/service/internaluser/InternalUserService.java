package com.zhela.cloudblog.service.internaluser;

import java.io.InputStream;

import com.zhela.cloudblog.model.users.ProviderUser;
import com.zhela.cloudblog.model.users.Users;

public interface InternalUserService {

	public Users getUsers(String account,String password) throws Exception;
	
	public Users insertUsers(String account,String password,String email,String display_name) throws Exception;
	
	public Users updateUsersHeader(String account, InputStream header,String root_path,String filetype) throws Exception;
	
	public Users updateUserPassword(String account,String password,String newPassword) throws Exception;
	
	public java.util.List<ProviderUser> getProviderAccount(String account) throws Exception;
	
	public ProviderUser insertProviderUser(long provider_id,String account,String provider_account,int status,String token,String token_secret,String token_more) throws Exception;
	
	public ProviderUser updateProviderUser(long provider_id,String account,String provider_account,Integer status,String username,String password) throws Exception;
	
	public int delProviderUser(long provider_id,String account,String provider_account) throws Exception;
}
