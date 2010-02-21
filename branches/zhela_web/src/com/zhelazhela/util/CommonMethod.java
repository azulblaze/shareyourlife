package com.zhelazhela.util;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.zhelazhela.services.ImageService;

/**
 * <code>CommonMethod.java</code>
 * 
 * @author Andy Chen
 * @version 1.0, 2009-3-6
 */
public class CommonMethod {

	private static java.util.Map<String, String> picture_type = new java.util.HashMap<String, String>();

	static {
		picture_type.put("image/png", "png");
		picture_type.put("image/gif", "gif");
		picture_type.put("image/jpeg", "jpg");
		picture_type.put("image/pjpeg", "jpg");
		picture_type.put("image/x-png", "png");
	}

	private CommonMethod() {

	}

	public synchronized String saveImg(File file, String root_path, String dir,
			String filetype) throws Exception {
		// First we save full image to disk

		String base_name = getFileName();
		String path = dir + base_name + "." + filetype;
		File _file = new File(root_path + path);
		File folder = _file.getParentFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}
		try {
			file.renameTo(_file);
		} catch (Exception e) {
			throw new Exception("保存文件失败");
		}
		return path;
	}

	public synchronized String saveLogo(File file, String root_path,
			String dir, String filetype) throws Exception {
		// First we save full image to disk

		String base_name = getLogoName();
		String path = dir + base_name + "." + filetype;
		File _file = new File(root_path + path);
		File folder = _file.getParentFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}
		try {
			file.renameTo(_file);
		} catch (Exception e) {
			throw new Exception("保存文件失败");
		}
		return path;
	}

	public synchronized String[] saveGoodPic(String addr, String root_path,
			String dir) throws Exception {
		// First we save full image to disk
		String filetype = "jpg";
		if (addr.length() > 3) {
			String _addr = addr.toLowerCase();
			if (_addr.endsWith("gif")) {
				filetype = "gif";
			}
			if (_addr.endsWith("png")) {
				filetype = "png";
			}
		}
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(addr);
		get
				.setRequestHeader(
						"User-Agent",
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; zh-CN; rv:1.9.2) Gecko/20100115 Firefox/3.6");
		get
				.setRequestHeader("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		client.executeMethod(get);
		String tmp = get.getResponseHeader("Content-Type").getValue();
		if (tmp != null) {
			if (tmp.toLowerCase().indexOf("gif") >= 0) {
				filetype = "gif";
			}
			if (tmp.toLowerCase().indexOf("png") >= 0) {
				filetype = "png";
			}
		}
		String base_name = getFileName();
		String path = dir + base_name + "." + filetype;
		File storeFile = new File(root_path + path);
		File folder = storeFile.getParentFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}
		FileOutputStream output = new FileOutputStream(storeFile);
		output.write(get.getResponseBody());
		output.close();
		String thumb = dir + base_name + "_thumb." + filetype;
		copy(root_path + path, root_path + thumb);
		File thumbFile = new File(root_path + thumb);
		try {
			ImageService is = (ImageService) Class.forName(
					"com.zhelazhela.services.impl.ImageService"
							+ filetype.toUpperCase()).newInstance();
			is.reSizeImage(thumbFile, root_path + thumb, 100, -1);
			storeFile = new File(root_path + path);
			is.reSizeImage(storeFile, root_path + path, 50, 50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] paths = new String[2];
		paths[0] = path;
		paths[1] = thumb;
		return paths;
	}

	private boolean copy(String fileFrom, String fileTo) {
		try {
			FileInputStream in = new java.io.FileInputStream(fileFrom);
			FileOutputStream out = new FileOutputStream(fileTo);
			byte[] bt = new byte[1024];
			int count;
			while ((count = in.read(bt)) > 0) {
				out.write(bt, 0, count);
			}
			in.close();
			out.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
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

	public synchronized String getLogoName() {
		String tmp = "/";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		tmp = tmp + format.format(calender.getTime());
		tmp = tmp + GenActivtyCode(16);
		return tmp;
	}

	public synchronized void deleteFile(String file) {
		try {
			File _file = new File(file);
			if (_file.exists() && _file.isFile()) {
				_file.delete();
			}
		} catch (Exception e) {

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

	public synchronized String getMD5(String source) {
		if (StringUtils.isBlank(source)) {
			return "";
		}
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public String findCharSet(String str) {
		String tmp_char = str.toLowerCase();
		try {
			if (tmp_char != null) {
				int index = tmp_char.indexOf("charset");
				if (index >= 0) {
					tmp_char = tmp_char.substring(index);
					int index2 = tmp_char.indexOf("=");
					if (index2 >= 0) {
						String tmp = tmp_char.substring(0, index2);
						if (tmp != null
								&& tmp.trim().equals("charset")) {
							tmp_char = tmp_char.substring(index2 + 1).trim();
							index2 = tmp_char.indexOf(" ");
							if (index2 > 0) {
								try {
									String _char = tmp_char.substring(0, index2);
									Charset.forName(_char);
									return _char;
								} catch (Exception e) {

								}
							}

							index2 = tmp_char.indexOf("\"");
							if (index2 > 0) {
								try {
									String _char = tmp_char
											.substring(0, index2);
									Charset.forName(_char);
									return _char;
								} catch (Exception e) {

								}
							}
							if (tmp_char.length() < 50) {
								try {
									String _char = tmp_char;
									Charset.forName(_char);
									return _char;
								} catch (Exception e) {

								}
							}
							return null;
						}
					}
				}
			}

		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String args[]) throws Exception {
		System.out.println("="+CommonMethod.getInstance().findCharSet("charset =   utf-8  \"")+"=");
	}
}
