package com.twitpic.services;
/**
 * <code>PictureService.java</code>
 * @version 1.0, 2009-8-3
 */
public interface PictureService {
	
	public java.util.List<com.twitpic.domain.PictureInfo> load_picturesinfo_by_account(String account)throws java.lang.Exception;
	
	public com.twitpic.domain.PictureInfo savePicture(com.twitpic.domain.Account user,String root_path,java.io.File file,String filetype,String description)throws java.lang.Exception;
	
	/**
	 * Home's pictures list
	 * @param size
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadHomePictures(int size);
	
	/**
	 * Cause user upload the pictures, so we use ajax to get the newest picture to home page
	 * @param from_time
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadLatestPictures(long from_id);
	
	/**
	 * User want to read more pictures
	 * @param to_time
	 * @param size
	 * @return
	 */
	public java.util.List<com.twitpic.domain.PictureInfo> loadMoretPictures(long to_id,int size);
}
