package com.twitpic.system.config;
/**
 * <code>SystemConfig.java</code>
 * @version 1.0, 2009-8-3
 */
public class SystemConfig {
	
	private String domain;
	
	private String upload_header;
	
	private String upload_pic;

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
	
	
	
}
