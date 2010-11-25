package com.zhela.cloudblog.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.zhela.cloudblog.rest.BaseResource;

/**
 * <code>SystemConfig.java</code>
 * @version 1.0, 2009-8-3
 */
public class SystemConfig {
	public static String domain;
	static{
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(BaseResource.ROOT_PATH+"WEB-INF/classes/config.properties"));
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
