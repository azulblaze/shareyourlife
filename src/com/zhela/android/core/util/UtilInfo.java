package com.zhela.android.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.zhela.android.core.db.Users;

public class UtilInfo {

	public final static int bole_version  = 1;
	public static int usersCount = 0;
	public static Users loginusers;
	
	public static String StringFilter(String str) throws PatternSyntaxException {
		if(str==null){
			return "";
		}
		String regEx = "[^a-zA-Z0-9_]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
