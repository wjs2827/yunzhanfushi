package com.wmeimob.yzfs.util;


import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通用工具类
 * @author zJun
 * @date 2016年11月10日 下午2:10:59
 */
public class CommonUtil {
	private static Random random = new Random(System.currentTimeMillis());
	/**
	 * 字符串替换{T} 按顺序替换
	 * @author zJun
	 * @date 2016年11月10日 下午2:07:31
	 */
	public static String connectStr(Object ...args){
		String result = String.valueOf(args[0]);
		for (int i = 1; i < args.length; i++) {
			result = result.replaceFirst("\\{[T]\\}", String.valueOf(args[i]));
		}
		return result;
	}
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception exception) {
		}
		return resultString;
	}
	public static String signature_MD5(Map<String, String> params, String signKey) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (!StringUtils.isEmpty(value) && !"sign".equals(key)) {
				sb.append(key).append("=").append(value).append("&");
			}
		}
		sb.append("key=").append(signKey);
//		System.out.println("微信签名加密前sign===="+sb.toString());
		return MD5Encode(sb.toString()).toUpperCase();
	}

	public static String randomString() {
		StringBuilder sb = new StringBuilder();
		sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		sb.append(String.valueOf(System.currentTimeMillis()).substring(5));
		sb.append(String.valueOf(random.nextInt(90) + 10));
		return sb.toString();
	}

	public static String signature_SHA1(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (!StringUtils.isEmpty(value) && !"sign".equals(key)) {
				if (i == 0) {
					sb.append(key).append("=").append(value);
				} else {
					sb.append("&").append(key).append("=").append(value);
				}
			}
		}
		return SHA1Encode(sb.toString());
	}
	public static String SHA1Encode(String origin) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
		}

		messageDigest.update(origin.getBytes());
		byte messageDigest2[] = messageDigest.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest2.length; i++) {
			String shaHex = Integer.toHexString(messageDigest2[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}
		return hexString.toString();
	}

	public static String map2xml(Map<String, String> map) {

		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append("<").append(entry.getKey()).append("><![CDATA[").append(entry.getValue()).append("]]></")
					.append(entry.getKey()).append(">");
		}
		sb.append("</xml>");
		return sb.toString();
	}
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private static final String chars[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
			"v", "w", "x", "y", "z" };
	public static void main(String[] args) {
		String str = "asdasj{T}1231asda{T}asdfghjk{T}2222";
		System.out.println(connectStr(str, "一", "三", "二"));
	}
}
