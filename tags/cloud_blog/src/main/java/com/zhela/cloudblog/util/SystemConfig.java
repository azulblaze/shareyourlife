package com.zhela.cloudblog.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * <code>SystemConfig.java</code>
 * @version 1.0, 2009-8-3
 */
public class SystemConfig {
	public static String domain;
	static{
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
			domain = properties.getProperty("domain");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
