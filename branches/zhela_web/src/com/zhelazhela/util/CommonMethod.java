package com.zhelazhela.util;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <code>CommonMethod.java</code>
 * 
 * @author Andy Chen
 * @version 1.0, 2009-3-6
 */
public class CommonMethod {
	
	private static java.util.Map<String,String> picture_type = new java.util.HashMap<String,String>();
	
	static{
		picture_type.put("image/png", "png");
		picture_type.put("image/gif", "gif");
		picture_type.put("image/jpeg", "jpg");
		picture_type.put("image/pjpeg", "jpg");
		picture_type.put("image/x-png", "png");
	}

	private CommonMethod() {
		
	}

	private static CommonMethod instance = new CommonMethod();

	public static CommonMethod getInstance() {
		return instance;
	}

	public static CommonMethod newInstance() {
		return new CommonMethod();
	}

	public synchronized String GenActivtyCode(int len) {
		String result = GenRandomStr(10) + System.currentTimeMillis()
				+ GenRandomStr(34);
		result = new String(MIMEBase64.encode(result.getBytes()));
		if (result.length() > len) {
			result = result.substring(0, len);
		}
		return result;
	}

	public synchronized String GenRandomStr(int len) {
		String result = "";
		for (int i = 0; i < len; i++) {
			result = result
					+ MIMEBase64.encodingTable[new Random().nextInt(64)];
		}
		return result;
	}

	public synchronized Color getRandColor(int fc, int bc) {
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

	public synchronized String getFileName() {
		String tmp = "/";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		tmp = tmp + format.format(calender.getTime());
		tmp = tmp + "/" + GenActivtyCode(16);
		return tmp;
	}
	
	public synchronized void deleteFile(String file){
		try{
			File _file = new File(file);
			if(_file.exists()&&_file.isFile()){
				_file.delete();
			}
		}catch(Exception e){
			
		}
	}

	public synchronized boolean validEmail(String email) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.find();
	}
	
	public static void main(String args[])throws Exception{
		
	}
}
