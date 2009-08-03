package com.twitpic.services;
/**
 * <code>PictureService.java</code>
 * @version 1.0, 2009-8-3
 */
public interface PictureService {
	
	public java.util.List<com.twitpic.domain.PictureInfo> load_picturesinfo_by_account(String account)throws java.lang.Exception;
	
	public com.twitpic.domain.PictureInfo savePicture(com.twitpic.db.model.Users user,String root_path,java.io.File file,String filetype,String description)throws java.lang.Exception;
	
}
