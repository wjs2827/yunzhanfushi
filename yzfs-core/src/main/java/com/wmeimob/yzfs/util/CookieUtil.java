package com.wmeimob.yzfs.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * cookie 工具类
 */
public class CookieUtil {
	
	/**
	 * 后台管理员信息
	 */
	public static final String KEY_ADMIN_INFO="key_bszf_admin_info";
	
	public static final String KEY_COOKIE_AES="key_bszf_cookie_aes";

	/**
	 * 添加cookie
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static Cookie addCookie(String key, String value) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * 添加cookie
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 *            保存时长
	 * @return
	 */
	public static Cookie addCookie(String key, String value, int expire) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(expire);
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * 获取一个cookie
	 * 
	 * @param key
	 * @return
	 */
	public static Cookie getCookie(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

	/**
	 * 删除cookie
	 */
	public static void deleteCookie(String key) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
