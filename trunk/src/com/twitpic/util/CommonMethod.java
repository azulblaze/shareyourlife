package com.twitpic.util;

import java.awt.Color;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <code>CommonMethod.java</code>
 * 
 * @author  Andy Chen
 * @version 1.0, 2009-3-6
 */
public class CommonMethod {
	
	public synchronized static String GenActivtyCode(int len){
		String result =  GenRandomStr(10)+System.currentTimeMillis() + GenRandomStr(34);
		result = new String(MIMEBase64.encode(result.getBytes()));
		if(result.length()>len){
			result = result.substring(0,len);
		}
		return result;
	}
	
	public synchronized static String GenRandomStr(int len){
		String result = "";
		for(int i=0;i<len;i++){
			result = result + MIMEBase64.encodingTable[new Random().nextInt(64)];
		}
		return result;
	}
	
	public synchronized static  Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	public static void main(String args[]){
		//for(int i=0;i<10;i++){
			System.out.println(CommonMethod.getEmailAcitivity("http://www.go.com/"));
		//}
	}
	
	@SuppressWarnings("deprecation")
	public static String getEmailAcitivity(String addr){
		String result = Email_Activity.replaceAll("acitivity_addr",addr);
		result = result.replaceAll("Time",new java.util.Date().toLocaleString());
		return result;
	}
	
	public static boolean validEmail(String email){
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.find();
	}
	
	private static String Email_Activity = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
											+"<html xmlns=\"http://www.w3.org/1999/xhtml\">"
											+"<head>"
											+"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
											+"<title>易效项目管理系统 - 索普科技</title>"
											+"<style>"
											+"body{"
											+"	font-size:12px;"
											+"	font-family:Verdana, Geneva, sans-serif;"
											+"}"
											+"</style>"
											+"</head>"
											+"<body>"
											+"<div>"
											+"<pre>"
											+"    亲爱的用户："
											+""
											+"    由于您的注册邮箱将成为您享受服务的保证之一，请认证新注册邮。"
											+"    请立即点击如下链接，完成认证邮箱的操作："
											+""
											+"    <a href=\"acitivity_addr\">acitivity_addr</a>"
											+""
											+"    （如果您无法点击以上的链接，请直接将此链接复制到浏览器的地址栏后，再进行访问）"
											+"      "
											+""
											+""
											+"    索普科技"
											+"    Time"
											+"</pre>"
											+"</div>"
											+"</body>"
											+"</html>";
}
