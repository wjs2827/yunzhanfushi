package com.wmeimob.yzfs.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneratorSnUtil {
	
	/**
	 * 生成sn码
	 * @param sn
	 * @return
	 */
	public static String generatorSn(String sn) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		sn += df.format(now);
		Random random = new Random();
		int num = (int) (random.nextDouble() * (100000 - 10000) + 10000);
		return sn += num;
	}
	
	
	/**
	 * 根据ID生成SN码
	 * @param id
	 * @return
	 */
	public static String generatorSnById(String id){
		String base = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";  
		Random random = new Random();   
		StringBuffer sb = new StringBuffer();   
		sb.append(id);
        sb.append(base.charAt(random.nextInt(base.length())));
	    while (sb.length() < 8 ) {
			sb.append(random.nextInt(10));
		}
	    return sb.toString();     
	}
	
	public static void main(String[] args) {
		String sn = "";
		Set<String> set = new HashSet<String>();
		for(int i=1; i<1000000; i++){
			sn = generatorSnById("");
			set.add(sn);
		}
		System.out.println(set.size());
	}
	
}
