package com.wmeimob.yzfs.util;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

/**
 * AES加密Util
 */
public class AES128Util {

	private static Logger log = Logger.getLogger("AES128Util");
	
	private static final String STR_AES_IV = "akejiawmeimobaes";

	/**
	 * 加密
	 * 
	 * @param key
	 * @param text
	 *            待加密的明文
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String key, String text) {
		try {
			SecretKeySpec skeySpec = getKey(key);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(STR_AES_IV.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			return Base64.encodeBase64String(encrypted);
		} catch (Exception e) {
			log.error("#############AES128Util encrypt#############", e);
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param key
	 * @param text
	 *            待解密的密文
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String key, String text) {
		try {
			SecretKeySpec skeySpec = getKey(key);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(STR_AES_IV.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted = Base64.decodeBase64(text);
			byte[] original = cipher.doFinal(encrypted);
			String originalString = new String(original);
			return originalString;
		} catch (Exception e) {
			log.error("#############AES128Util encrypt#############", e);
		}
		return null;
	}

	private static SecretKeySpec getKey(String strKey) {
		byte[] arrTmp = strKey.getBytes();
		byte[] arr = new byte[16];
		for (int i = 0; i < arrTmp.length && i < arr.length; i++) {
			arr[i] = arrTmp[i];
		}
		SecretKeySpec skeySpec = new SecretKeySpec(arr, "AES");
		return skeySpec;
	}
	
}
