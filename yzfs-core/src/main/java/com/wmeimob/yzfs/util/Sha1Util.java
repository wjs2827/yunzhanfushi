package com.wmeimob.yzfs.util;

import java.security.MessageDigest;
import java.util.Formatter;

/**
 * sha1 工具类
 */
public class Sha1Util {

	/**
	 * 签名
	 * 
	 * @param str
	 * @return
	 */
	public static String sign(String str) {
		String signature = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(str.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (Exception e) {

		}
		return signature;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
}
