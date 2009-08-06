package com.twitpic.util;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.twitpic.services.ImageService;


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
	public synchronized String[] saveImg(File file,String root_path,String dir,int width[],int height[],String filetype)throws Exception{
		//First we save full image to disk
		String path[] = null;
		if(width!=null){
			path = new String[width.length+1];
		}else{
			path = new String[1];
		}
		String base_name = getFileName();
		path[path.length-1] = dir+base_name+"_"+path.length+"."+filetype;
		File _file = new File(root_path+path[path.length-1]);
		File folder = _file.getParentFile();
		if(!folder.exists()){
			folder.mkdirs();
		}
		try{
			file.renameTo(_file);
		}catch(Exception e){
			throw new Exception("保存文件失败");
		}
		//if only save one picture,return path
		if(path.length==1){
			return path;
		}
		//save the resize image
		ImageService is = null;
		try{
			is = (ImageService)Class.forName("com.twitpic.services.impl.ImageService"+filetype.toUpperCase()).newInstance();
		}catch(Exception e){
			
		}
		if(is==null){
			for(int i=(path.length-2);i>=0;i--){
				path[i] = path[path.length-1];
			}
		}else{
			String tmp_path = null;
			for(int i=(path.length-2);i>=0;i--){
				tmp_path = dir+base_name+"_"+(i+1)+"."+filetype;
				if(is.reSizeImage(_file, root_path+tmp_path, width[i], height[i])){
					path[i] = tmp_path;
				}else{
					path[i] = path[path.length-1];
				}
			}
		}
		return path;
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
	
	public synchronized String isAllowedPicture(String type) {
		return picture_type.get(type);
	}

	public static void main(String args[])throws Exception{
		
	}
}
