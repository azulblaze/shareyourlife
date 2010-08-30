package com.zhelazhela.cloudblog.domain;
/**
 * 
 * @author chennyan
 *
 */
public class User{

	private String id;
	private String account;
	private String display_name;
	private String password;
	private String city;
	private String location;
	private String description;
	private String profile_image_url;
	private String domain;
	private String gender;
	private String follow_count;
	private String fans_count;
	private String post_count;
	private String following;
	
	/**
	 * 唯一ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 唯一ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 登录帐号，可能会和ID一样
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 登录帐号，可能会和ID一样
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 显示的名字
	 */
	public String getDisplay_name() {
		return display_name;
	}
	/**
	 * 显示的名字
	 */
	public void setDisplay_name(String displayName) {
		display_name = displayName;
	}
	/**
	 * 密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 城市代码，或者名字
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 城市代码，或者名字
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 地址
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 地址
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 个人描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 个人描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 头像
	 */
	public String getProfile_image_url() {
		return profile_image_url;
	}
	/**
	 * 头像
	 */
	public void setProfile_image_url(String profileImageUrl) {
		profile_image_url = profileImageUrl;
	}
	/**
	 * 个性化域名
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * 个性化域名
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * 性别
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 性别
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 关注数量
	 */
	public String getFollow_count() {
		return follow_count;
	}
	/**
	 * 关注数量
	 */
	public void setFollow_count(String followCount) {
		follow_count = followCount;
	}
	/**
	 * 粉丝数量
	 */
	public String getFans_count() {
		return fans_count;
	}
	/**
	 * 粉丝数量
	 */
	public void setFans_count(String fansCount) {
		fans_count = fansCount;
	}
	/**
	 * 微薄数量
	 */
	public String getPost_count() {
		return post_count;
	}
	/**
	 * 微薄数量
	 */
	public void setPost_count(String postCount) {
		post_count = postCount;
	}
	/**
	 * 是否关注
	 */
	public String getFollowing() {
		return following;
	}
	/**
	 * 是否关注
	 */
	public void setFollowing(String following) {
		this.following = following;
	}
	
	
}
