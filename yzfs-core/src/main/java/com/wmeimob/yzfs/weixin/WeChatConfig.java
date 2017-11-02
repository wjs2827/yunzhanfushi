package com.wmeimob.yzfs.weixin;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 微信配置
 */
public class WeChatConfig {

	private static Logger log = Logger.getLogger(WeChatConfig.class);
	private static Properties props = new Properties();

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("wechat.properties"));
		} catch (Exception e) {
			log.error("############WexinConfig##########", e);
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}
