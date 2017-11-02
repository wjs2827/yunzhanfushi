package com.wmeimob.yzfs.qiniu;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * 七牛Util
 */
public class QiniuUtil {

	public static final String ACCESS_KEY = QiniuConfig.getValue("ACCESS_KEY");
	public static final String SECRET_KEY = QiniuConfig.getValue("SECRET_KEY");
	public static final String BUCKET = QiniuConfig.getValue("BUCKET");
	public static final String IMG_PATH = QiniuConfig.getValue("IMG_PATH");
	public static final String IMAGEMODE = QiniuConfig.getValue("IMAGEMODE");

	private static Logger log = Logger.getLogger("QiniuUtil");

	/**
	 * 获取七牛上传token
	 * 
	 * @return
	 */
	public static Map<String, Object> getAccessToken() {
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		StringMap putPolicy = new StringMap();
		putPolicy.put("returnBody",
				"{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fname\":\"$(fname)\",\"fsize\":$(fsize)}");
		long expireSeconds = 3600;
		String upToken = auth.uploadToken(BUCKET, null, expireSeconds, putPolicy);
		Map<String, Object> map = new HashMap<>();
		map.put("uptoken", upToken);
		return map;
	}

	/**
	 * 将ByteArrayInputStream上传到七牛
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String uploadStream(ByteArrayInputStream inputStream) {
		try {
			Configuration cfg = new Configuration(Zone.zone0());
			UploadManager uploadManager = new UploadManager(cfg);
			Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
			String upToken = auth.uploadToken(BUCKET);
			String key = null;
			Response response = uploadManager.put(inputStream, key, upToken, null, null);
			// 解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			return putRet.key;
		} catch (Exception e) {
			log.error("##########QiniuUtil uploadStream#############", e);
		}
		return "";
	}
}
