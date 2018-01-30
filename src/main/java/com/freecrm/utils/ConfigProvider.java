package com.freecrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//import org.testng.log4testng.Logger;

public class ConfigProvider {

	private static Properties prop = new Properties();
	private static FileInputStream input;
	//private final static Logger logger = Logger.getLogger(ConfigProvider.class);

	static {
		try {
			input = new FileInputStream(Constants.configFilePath);
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Config.properties not found!!!!");
		}
	}
	
	public static String get(String Key) {
		
		String value=null;
		if(Key==null)
			return null;
		
		value = prop.getProperty(Key).trim();
		return value;
	}

}
