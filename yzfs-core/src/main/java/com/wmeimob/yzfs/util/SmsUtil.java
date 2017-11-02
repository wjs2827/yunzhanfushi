package com.wmeimob.yzfs.util;

import java.util.HashMap;
import java.util.Map;

import com.wmeimob.wmcore.network.HttpUtil;
import com.wmeimob.wmcore.util.JsonUtil;

/**
 * 短信工具类
 */
public class SmsUtil {
	private static final String URL_SMS_SEND = "http://new.yxuntong.com/emmpdata/sms/Submit"; // 短信发送地址
	private static final String ACCOUNT = "204813"; // 用户名
	private static final String PASSWORD = "-3kgK!*z"; // 密码
	private static final String SIGN = "【上海博华】"; // 短信签名
	private static final String TOKEN = "111111";// 安全验证key
	private static final String TYPE = "json";// 格式

	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 * @param content
	 */
	public static void send(String phone, String content) {
		Map<String, Object> map = new HashMap<>();
		// 消息map
		Map<String, Object> msgMap = new HashMap<>();
		msgMap.put("account", ACCOUNT);
		msgMap.put("password", Md5Util.Md5(PASSWORD));
		msgMap.put("phones", phone);
		msgMap.put("content", content);
		msgMap.put("sign", SIGN);

		String message = JsonUtil.DEFAULT.toJson(msgMap);
		map.put("message", JsonUtil.DEFAULT.toJson(msgMap));
		String sid = Sha1Util.sign(TOKEN + "&" + message);
		map.put("sid", sid);
		map.put("type", TYPE);
		String resp = HttpUtil.doPostFrom(URL_SMS_SEND, map);
		System.err.println(resp);
	}
}
