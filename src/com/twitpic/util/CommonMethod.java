package com.twitpic.util;

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

	/**
	 * array:min thumb large full
	 * of course,if the image's with smaller than given, no need to resize and no need to save a copy, just give the address.
	 * @param file The source file
	 * @param root_path the web content's root path
	 * @param dir upload file's save folder
	 * @param with the images's with array:min thumb large
	 * @param filetype file type,like jpg,gif,bmp...
	 * @return String[] the path that saved
	 * @throws Exception
	 */
	public synchronized String[] saveImg(File file,String root_path,String dir,int with[],String filetype)throws Exception{
		//First we save full image to disk
		String path[] = new String[4];
		String base_name = getFileName();
		path[3] = dir+base_name+"_full."+filetype;
		File _file = new File(root_path+path[4]);
		file.renameTo(_file);
		//Secend:large  check if the picture's with bigger than given,if bigger need to resize, then save
		path[2] = path[3];
		//Secend:thumb  check if the picture's with bigger than given,if bigger need to resize, then save
		path[1] = path[3];
		//Secend:min  check if the picture's with bigger than given,if bigger need to resize, then save
		path[0] = path[3];
		return path;
	}

	public synchronized boolean validEmail(String email) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.find();
	}

}
