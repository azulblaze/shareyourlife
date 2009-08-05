package com.twitpic.domain;

/**
 * <code>FormUserProfile.java</code>
 * 
 * @version 1.0, 2009-8-5
 */
public class FormUserProfile {
	private String location;
	private String signature;
	private String self_introduction;
	private Integer theme;
	private String oldpassword;
	private String password1;
	private String password2;

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the self_introduction
	 */
	public String getSelf_introduction() {
		return self_introduction;
	}

	/**
	 * @param self_introduction
	 *            the self_introduction to set
	 */
	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}

	/**
	 * @return the theme
	 */
	public Integer getTheme() {
		return theme;
	}

	/**
	 * @param theme
	 *            the theme to set
	 */
	public void setTheme(Integer theme) {
		this.theme = theme;
	}

	/**
	 * @return the oldword1
	 */
	public String getOldpassword() {
		return oldpassword;
	}

	/**
	 * @param oldword1
	 *            the oldword1 to set
	 */
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	/**
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1
	 *            the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2
	 *            the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
