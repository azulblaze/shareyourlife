package com.zhelazhela.services;

import com.zhelazhela.domain.SNSUser;

public interface UserProfileService {

	public SNSUser regUser(SNSUser user,long recommendUserId) throws Exception;
	
	public boolean checkUser(SNSUser user) throws Exception;
	
	public boolean reSendActMail(SNSUser user) throws Exception;
	
	public SNSUser logUser(SNSUser user) throws Exception;
	
	public boolean actUser(long id,String code) throws Exception;
}
