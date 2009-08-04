package com.twitpic.services;

import com.twitpic.domain.FormLogin;

public interface AccountService {
	
	public com.twitpic.domain.Account user_login(FormLogin formLogin)throws Exception;
	
	public com.twitpic.domain.Account reg_user(com.twitpic.domain.FormRegister formRegister) throws Exception;
	/**
	 * 
	 * @param ac account
	 * @param at activity code
	 * @return
	 * @throws Exception
	 */
	public boolean act_user(String ac,String at)throws Exception;
	
	public void send_ac_mail(com.twitpic.domain.Account user,String email)throws Exception ;
	
}
