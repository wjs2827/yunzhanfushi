package com.wmeimob.yzfs.util;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.wmeimob.wmcore.util.CodeUtil;

/**
 * 业务编码生成工具类
 */
public class BCodeUtil {

	private static SimpleDateFormat format = new SimpleDateFormat("ssddmmyyMMHHSS");

	/**
	 * 后台管理员添加或者导入用户的编码 admin Member
	 * 
	 * @return
	 */
	public static String AMCode() {
		return "AM" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 现场报名添加的用户编码 sign member
	 * 
	 * @return
	 */
	public static String SMCode() {
		return "SM" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 用户注册生成的用户编码 Member Rgister
	 * 
	 * @return
	 */
	public static String MRCode() {
		return "MR" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 用户报名生成的报名编码 Member sign
	 * 
	 * @return
	 */
	public static String MSCode() {
		return "MS" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 后台管理员报名生成的报名编码 Admin sign
	 * 
	 * @return
	 */
	public static String ASCode() {
		return "AS" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 微信支付 生成的订单 Code
	 * 
	 * @return
	 */
	public static String WPCode() {
		return "WP" + format.format(new Date()) + CodeUtil.getCode(4);
	}

	/**
	 * 后台管理 支付生成的订单Code
	 * 
	 * @return
	 */
	public static String APCode() {
		return "AP" + format.format(new Date()) + CodeUtil.getCode(4);
	}
	
	/**
	 * 生成内购部门的内购码
	 * 
	 * @return
	 */
	public static String IDCode() {
		return "ID" + format.format(new Date()) + CodeUtil.getCode(4);
	}
}
