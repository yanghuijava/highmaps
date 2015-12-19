package com.xyb.highmaps.biz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesUtil {
	
	private static Properties properties = new Properties();
	private static final String DEFAULT_PROPERTIES_FILE = "config.properties";
	
	public static Properties loadProperties(String path) {
		PropertiesUtil pu = new PropertiesUtil();
        Properties prop = new Properties();
        try {
            prop.load(pu.getClass().getResourceAsStream(path));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return prop;
    }

	private static void initProperty(String propertiesFileName) throws Exception {
		if (!properties.isEmpty())
			return;
		InputStream is = null;
		propertiesFileName = StringUtils.defaultString(propertiesFileName, DEFAULT_PROPERTIES_FILE);
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE);
			properties.load(is);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				is = null;
			}
		}
	}

	public static String getProperty(String key) {
		try {
			initProperty(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return StringUtils.trimToNull(properties.getProperty(key));
	}

	public static String getProperty(String key, String defaultValue) {
		String value = getProperty(key);
		return StringUtils.defaultString(value, defaultValue);
	}
	
	public static String getPropertyForm(String key, String propertiesFileName) throws Exception {
		initProperty(propertiesFileName);
		return StringUtils.trimToNull(properties.getProperty(key));
	}

	public static String getPropertyForm(String key, String propertiesFileName, String defaultValue) throws Exception {
		String value = getPropertyForm(key, propertiesFileName);
		return StringUtils.defaultString(value, defaultValue);
	}
	
	public static void main(String[] args) {
		System.out.println(getProperty("contextPath"));
	}
}
