package com.twitpic.services;

import com.twitpic.domain.FormLogin;

/**
 * <code>AdminService.java</code>
 * @version 1.0, 2009-8-12
 */
public interface AdminService {
	
	public com.twitpic.db.model.Admins user_login(FormLogin formLogin)throws Exception;
	
	public com.twitpic.domain.PictureInfoList loadPictures(long from,long to,int size);
	
	public boolean deletePictures(String root_path,Long id_picture);
	
	public boolean disablePictures(Long id_picture);
	
	public boolean disableUser(String account);
	
}
