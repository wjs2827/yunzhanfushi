package com.wmeimob.yzfs.api.wxutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.wmeimob.yzfs.util.Md5Util;

/**
 * 微信MD5生成签名
 * 
 * @author Dreams
 *
 */
public class WXMD5signUtil {

	public static Logger log = Logger.getLogger("wxMD5signUtil");

	/**
	 * 微信支付签名
	 * 
	 * @param list
	 *            待排序参数列表
	 * @param secretKey
	 *            商户密钥
	 */
	public static String wxPaySign(Object o, String secretKey) {
		String result = "";
		try {
			ArrayList<String> list = new ArrayList<String>();
			Class cls = o.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				if (f.get(o) != null && f.get(o) != "") {
					if ("package2".equals(f.getName())) {
						list.add("package=" + f.get(o) + "&");
					}else{
						list.add(f.getName() + "=" + f.get(o) + "&");
					}
				}
			}
			int size = list.size();
			String[] arrayToSort = list.toArray(new String[size]);
			Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(arrayToSort[i]);
			}
			result = sb.toString();
			result += "key=" + secretKey;
			log.debug("Sign Before MD5:" + result);
			
			result=MD5Util.encrypt(result).toUpperCase();
			log.debug("Sign Result:" + result);
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}
}
