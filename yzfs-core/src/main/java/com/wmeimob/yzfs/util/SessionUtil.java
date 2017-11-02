package com.wmeimob.yzfs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil {

	private static Logger log = Logger.getLogger("SessionUtil");

	public static final String SESSION_WX_OPENID = "session_yzfs_wx_user";

	public static final String SESSION_ADMIN_INFO = "session_yzfs_amdin_info";
	
	public static final String SESSION_ADMIN_MENU = "session_yzfs_amdin_menu";
	

	/**
	 * 设置session
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static HttpSession setSession(String key, Object value) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		return session;
	}

	/**
	 * 设置Session的值
	 * 
	 * @param session
	 * @param key
	 * @param value
	 * @return
	 */
	public static void setSession(HttpSession session, String key, Object value) {
		session.setAttribute(key, value);
	}

	/**
	 * 获取值
	 * 
	 * @param key
	 * @return
	 */
	public static <T> T getValue(String key) {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			HttpSession session = request.getSession();
			Object o = session.getAttribute(key);
			if (o != null) {
				return (T) session.getAttribute(key);
			}
		} catch (Exception e) {
			log.error("#############SessionUtil getValue##############", e);
		}

		return null;
	}

	/**
	 * 获取值
	 * 
	 * @param key
	 * @return
	 */
	public static <T> T getValue(HttpSession session, String key) {
		try {
			return (T) session.getAttribute(key);
		} catch (Exception e) {
			log.error("#############SessionUtil SessionUtil##############", e);
		}
		return null;
	}

	/**
	 * 删除session
	 */
	public static void delete() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
