package com.wmeimob.yzfs.util;


import org.apache.commons.logging.Log;

/**
 * 通用模块日志工具类
 * @author zJun
 * @date 2016年5月19日 下午3:11:58
 */
public class LogUtil {
	
	private static String begin = "#-------------------------------";
	private static String end 	= "-------------------------------#";
	
	/**
	 * 输出info日志
	 * @author zJun
	 * @date 2016年5月10日 上午1:56:40
	 */
	public static void info(Log log, Object ...message) {
		if(log != null)
			log.info(begin+CommonUtil.connectStr(message)+end);
	}
	
	/**
	 * 输出debug日志
	 * @author zJun
	 * @date 2016年5月19日 下午3:15:33
	 */
	public static void debug(Log log, Object ...message) {
		if(log != null)
			log.debug(begin+CommonUtil.connectStr(message)+end);
	}
	
	/**
	 * 输出debug日志
	 * @author zJun
	 * @date 2016年5月19日 下午3:15:33
	 */
	public static void error(Log log, Object ...message) {
		if(log != null)
			log.error(begin+CommonUtil.connectStr(message)+end);
	}
	
	/**
	 * 输出debug日志
	 * @author zJun
	 * @date 2016年5月19日 下午3:15:33
	 */
	public static void error(Log log, Throwable t, Object ...message) {
		if(log != null)
			log.error(CommonUtil.connectStr(message)+":", t);
	}
	
	/**
	 * 输出warn日志
	 * @author zJun
	 * @date 2016年5月10日 上午1:56:40
	 */
	public static void warn(Log log, Object ...message) {
		if(log != null)
			log.warn(begin+"【警告】："+CommonUtil.connectStr(message)+end);
	}
	
	
}
