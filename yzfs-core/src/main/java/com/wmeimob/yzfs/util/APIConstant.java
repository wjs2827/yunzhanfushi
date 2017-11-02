package com.wmeimob.yzfs.util;

import java.io.InputStream;
import java.util.PropertyResourceBundle;

import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.core.WeChatBuilder;


/**
 * 常量
 * 
 * @author zJun
 */
public class APIConstant {

	/** 微信用户 OPENID */
	public final static String OPENID = "WECHAT_OPENID";

	public final static String COOKIE_JUMP_URL = "COOKIE_JUMP_URL";

	/** member存储在session中的KEY */
	public final static String SESSION_MEMBER_KEY = "SESSION_MEMBER_KEY";

	/** 发送短信验证码key开头 */
	public final static String SMS_MESSAGE_BEGIN_KEY = "SMS_";

	/** 读取配置文件 */
	public static PropertyResourceBundle property = (PropertyResourceBundle) PropertyResourceBundle
			.getBundle("wechat");

	/** 微信API */
	public static final WeChat weChat = WeChatBuilder.newBuilder(getAppId(), getAppSecret())
			.wxMch(getMchId(), getMchKey()).build();

	public static String getAppId() {
		return property.getString("wechat.appid");
	}

	public static String getAppSecret() {
		return property.getString("wechat.AppSecret");
	}

	public static String getMchId() {
		return property.getString("wechat.mchid");
	}

	public static String getMchKey() {
		return property.getString("wechat.mchkey");
	}

	/**
	 * 获取证书文件流
	 * 
	 * @return
	 */
	public static InputStream getCertStream() {
		InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/wxcert.p12");
		return fis;
	}

}
