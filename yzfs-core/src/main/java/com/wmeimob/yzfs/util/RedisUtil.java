package com.wmeimob.yzfs.util;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoader;

/**
 * Redis工具类
 */
public class RedisUtil {

	public static final String PREFIX_USER_INFO = "bszf:wx:user:";
	public static final String PREFIX_MOBILE_CODE = "bszf:wx:mobile:";
	public static final String KEY_ACCESS_TOKEN = "bszf:wx:accesstoken";
	public static final String KEY_AUTH_TOKEN = "bszf:wx:authtoken";
	public static final String KEY_REFRESH_TOKEN = "bszf:wx:refreshtoken";
	public static final String KEY_JSAPI_TICKET = "bszf:wx:jsapiticket";

	@SuppressWarnings("unchecked")
	private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) ContextLoader
			.getCurrentWebApplicationContext().getBean("stringJdkRedisTemplate");

	/**
	 * 获取Object值
	 * 
	 * @param key
	 * @return
	 */
	public static <T> T getObject(String key) {
		Assert.notNull(key, "key is null.");
		return (T) redisTemplate.boundValueOps(key).get();
	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		Assert.notNull(key, "key is null.");
		return (String) redisTemplate.boundValueOps(key).get();
	}

	/**
	 * 缓存String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, String value) {
		Assert.notNull(key, "key is null.");
		Assert.notNull(value, "value is null.");
		redisTemplate.boundValueOps(key).set(value);
	}

	/**
	 * 缓存Object
	 * 
	 * @param key
	 * @param value
	 */
	public static void setValue(String key, Object value) {
		Assert.notNull(key, "key is null.");
		Assert.notNull(value, "value is null.");
		redisTemplate.boundValueOps(key).set(value);
	}

	/**
	 * 设置一个redis有效期的value，时间单位是秒
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 *            时长 单位秒
	 */
	public static void setValue(String key, String value, long timeout) {
		Assert.notNull(key, "key is null.");
		Assert.notNull(value, "value is null.");
		redisTemplate.boundValueOps(key).set(value, timeout, TimeUnit.SECONDS);
	}

	/**
	 * 设置一个redis有效期的value，时间单位是秒
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 *            时长 单位秒
	 */
	public static void setValue(String key, Object value, long timeout) {
		Assert.notNull(key, "key is null.");
		Assert.notNull(value, "value is null.");
		redisTemplate.boundValueOps(key).set(value, timeout, TimeUnit.SECONDS);
	}

}
