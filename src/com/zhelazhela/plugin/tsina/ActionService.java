package com.zhelazhela.plugin.tsina;

public interface ActionService {
	
	public final static String INDEX = "http://t.sina.com.cn/";
	
	public boolean login(String name, String password);
}
