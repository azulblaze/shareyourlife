package com.twitpic.util;

public final class ConsVar {
	
	public static String SESSION_USER = "user";
	
	public static String SESSION_ADMIN_USER = "admin_user";
	
	public static String REQUEST_JSON = "json";
	
	/**
	 * means the page should redirect to another address
	 */
	public static String JSON_ACTION_REDIRECT= "redirect";
	/**
	 * the address that need to be redirected
	 */
	public static String JSON_ACTION_REDIRECT_ADDR= "redirect_addr";
	/**
	 * means no need to do any action
	 */
	public static String JSON_ACTION_NONE= "none";
	/**
	 * means the page should give some notice to user
	 */
	public static String JSON_ACTION_NOTICE= "notice";
	/**
	 * the msg that need to be noticed
	 */
	public static String JSON_ACTION_NOTICE_MSG= "notice_msg";
	
	public static int []IMG_WIDTH = {170,500,800};
	
	public static int []IMG_HIGHT = {120,0,0};
}
