package com.zhelazhela.system.config;
/**
 * <code>SystemConfig.java</code>
 * @version 1.0, 2009-8-3
 */
public class SystemConfig {
	
	private String domain;
	
	private String upload_header;
	
	private long upload_header_maxlength;
	
	private String upload_pic;
	
	private long upload_pic_maxlength;
	
	private String upload_logo;
	
	private String upload_blog_pic;
	
	private String upload_log_maxlength;
	
	private String upload_good_pic;

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the upload_header
	 */
	public String getUpload_header() {
		return upload_header;
	}

	/**
	 * @param upload_header the upload_header to set
	 */
	public void setUpload_header(String upload_header) {
		this.upload_header = upload_header;
	}

	/**
	 * @return the upload_pic
	 */
	public String getUpload_pic() {
		return upload_pic;
	}

	/**
	 * @param upload_pic the upload_pic to set
	 */
	public void setUpload_pic(String upload_pic) {
		this.upload_pic = upload_pic;
	}

	/**
	 * @return the upload_header_maxlength
	 */
	public long getUpload_header_maxlength() {
		return upload_header_maxlength;
	}

	/**
	 * @param upload_header_maxlength the upload_header_maxlength to set
	 */
	public void setUpload_header_maxlength(long upload_header_maxlength) {
		this.upload_header_maxlength = upload_header_maxlength;
	}

	/**
	 * @return the upload_pic_maxlength
	 */
	public long getUpload_pic_maxlength() {
		return upload_pic_maxlength;
	}

	/**
	 * @param upload_pic_maxlength the upload_pic_maxlength to set
	 */
	public void setUpload_pic_maxlength(long upload_pic_maxlength) {
		this.upload_pic_maxlength = upload_pic_maxlength;
	}

	public String getUpload_logo() {
		return upload_logo;
	}

	public void setUpload_logo(String uploadLogo) {
		upload_logo = uploadLogo;
	}

	public String getUpload_log_maxlength() {
		return upload_log_maxlength;
	}

	public void setUpload_log_maxlength(String uploadLogMaxlength) {
		upload_log_maxlength = uploadLogMaxlength;
	}

	public String getUpload_blog_pic() {
		return upload_blog_pic;
	}

	public void setUpload_blog_pic(String uploadBlogPic) {
		upload_blog_pic = uploadBlogPic;
	}

	public String getUpload_good_pic() {
		return upload_good_pic;
	}

	public void setUpload_good_pic(String uploadGoodPic) {
		upload_good_pic = uploadGoodPic;
	}
	
	
	
}
