package com.zhela.android.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.zhela.android.core.db.model.ProviderAccount;
import com.zhela.android.core.db.model.User;

public class UtilInfo {

	public final static int bole_version  = 1;
	public static int usersCount = 0;
	public static User loginusers;
	public static List<ProviderAccount> provider_account; 
	private final static String regex_str = "[a-zA-Z_0-9-]+";
	private final static String regex_email = "[a-z_0-9]+@[a-z_0-9]+.[a-z]+";
	private final static String regex_pass = "[a-zA-Z_0-9`~!@#$%^&*()+-=|{}':;',\\[\\].<>/?]*";
	private final static String regex_name = "[^`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]*";
	public static boolean StringFilter(String str) throws PatternSyntaxException {
		if(str==null){
			return false;
		}
		Pattern p = Pattern.compile(regex_str);
		Matcher m = p.matcher(str);
		return m.matches();
	}
	public static boolean NameFilter(String name) throws PatternSyntaxException {
		if(name==null){
			return false;
		}
		Pattern p = Pattern.compile(regex_name);
		Matcher m = p.matcher(name);
		return m.matches();
	}
	public static boolean EmailFilter(String email) {
		if(email==null){
			return false;
		}
		Pattern p = Pattern.compile(regex_email);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static boolean PasswordFilter(String pass){
		if(pass==null){
			return false;
		}
		Pattern p = Pattern.compile(regex_pass);
		Matcher m = p.matcher(pass);
		return m.matches();
	}
	
	public static synchronized void addProviderAccount(ProviderAccount tmp){
		if(provider_account==null){
			provider_account = new ArrayList<ProviderAccount>();
		}
		if(!provider_account.contains(tmp)){
			provider_account.add(tmp);
		}
	}
}
