package com.wmeimob.yzfs.util;


import javax.servlet.http.HttpServletRequest;

/**
 * 根据HttpServletRequest获取ip地址
 * @author zJun
 * @date 2016年5月9日 下午11:43:46
 */
public class IPRequestUtil {

	/**
	 * 获取访问IP地址
	 * @param request
	 * 			访问请求
	 * @return
	 * 			IP地址
	 */
	public static final String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!ifRealIp(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (!ifRealIp(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(!ifRealIp(ip)){
			ip =  request.getHeader("x-forwarded-for") ;
		}
		if (!ifRealIp(ip)) {
			ip = request.getRemoteAddr();
		}		
		return ip;
	}

	private static boolean ifRealIp(String ip){
		if(ip == null){
			return false;
		}
		if(ip.trim().length() == 0){
			return false;
		}
		if("unknown".equalsIgnoreCase(ip)){
			return false;
		}
		if("127.0.0.1".equals(ip)){
			return false;
		}
		if(ip.split("\\.").length != 4){
			return false;
		}
		return true;
	}
}
