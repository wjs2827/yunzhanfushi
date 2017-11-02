package com.wmeimob.yzfs.api.wxutils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Md5加密工具类
 * 
 */
public class MD5Util {
	private static MessageDigest md = null;
	private static char[] hexChars = new char[] { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("系统不支持MD5加密", e);
		}
	}

	/**
	 * 加密方法
	 * 
	 * @param content 要加密的内容
	 * @return 返回加密后的结果
	 */
	public static String encrypt(String content) {
		// 将要加密的字符串内容转变为数组，然后计算得出十六进制字符串
		byte[] byteArr = null;
		try {
			byteArr = content.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("系统不支持utf-8编码格式", e);
		}
		md.update(byteArr);
		byteArr = md.digest();
		String hexStr = "";
		// 对数组循环拼接字符串
		// 把byte数组里的每一个元素都转换成十六进制形式字符串，拼接起来
		for (int i = 0; i < byteArr.length; i++) {
			int a = (byteArr[i] & 0xff) / 16;
			int b = (byteArr[i] & 0xff) % 16;
			hexStr = hexStr + hexChars[a] + hexChars[b];
		}
		return hexStr;
	}

	public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	public static void main(String[] args) {
		System.out.println(SHA1("jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VLNQr1hp_zQoLoawvaZJdGZqauupGZbxit8gyjjLdIQz485UbFUnXzl-TBEysrqlkg&noncestr=shihui&timestamp=1433907271&url=http://www.wyerp.com/shareView"));
	}
	
}