package com.twitpic.services;

/**
 * <code>PictureService.java</code>
 * @version 1.0, 2009-8-3
 */
public interface PictureService {
	
	public java.util.List<com.twitpic.domain.PictureInfo> load_picturesinfo_by_account(String account)throws java.lang.Exception;
	
	public com.twitpic.domain.PictureInfo savePicture(com.twitpic.domain.Account user,String root_path,java.io.File file,String filetype,String description,String title)throws java.lang.Exception;
	
	/**
	 * Home's pictures list
	 * @param size
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadHomePictures(int size)throws Exception;
	
	/**
	 * Cause user upload the pictures, so we use ajax to get the newest picture to home page
	 * @param from_time
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadLatestPictures(long from_id)throws Exception;
	
	/**
	 * User want to read more pictures
	 * @param to_time
	 * @param size
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadMoretPictures(long to_id,int size)throws Exception;
	
	public com.twitpic.db.model.Comments comment(com.twitpic.domain.Account account,com.twitpic.domain.FormComment formComment)throws Exception;
	
	public boolean delComment(com.twitpic.domain.Account account,Long id_comment)throws Exception;
	
	public com.twitpic.db.model.Tags Tag(com.twitpic.domain.Account account,com.twitpic.domain.FormTag formTag)throws Exception;
	
	public com.twitpic.domain.PictureInfo loadPicture(long id_picture)throws Exception;
	
	public boolean delPicture(com.twitpic.domain.Account account,Long id_picture,String root_path)throws Exception;
}
