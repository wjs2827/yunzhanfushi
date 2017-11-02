package com.wmeimob.yzfs.qiniu;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 七牛配置
 */
public class QiniuConfig {

	private static Logger log = Logger.getLogger(QiniuConfig.class);
	private static Properties props = new Properties();

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("qiniu.properties"));
		} catch (Exception e) {
			log.error("################QiniuConfig", e);
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}
