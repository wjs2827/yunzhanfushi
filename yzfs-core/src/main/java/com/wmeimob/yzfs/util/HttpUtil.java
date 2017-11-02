package com.wmeimob.yzfs.util;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ConnectException;

public abstract class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String sendPostParams(String sendUrl, String params) {
		String result = "";
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL postUrl = new URL(sendUrl);
			// 打开连接
			connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			// Post 请求不能使用缓存
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
			// String params =URLEncoder.encode(paramsStr,"UTF-8");
			// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
			out.writeBytes(params);
			out.flush();
			out.close(); // flush and close
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.debug("发送" + sendUrl + "请求出现异常！" + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.debug(e.getMessage());
				}
			}
			if (connection != null) {
				connection.disconnect();
			}
		}
		return result;
	}

	/**
	 * 向指定URL发送GET,POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param requestMethod
	 *            请求方法("GET","POST"）
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static InputStream getInputStream(String url, String requestMethod, String param) {
		logger.info("urlString:" + url + param);
		InputStream inputStream = null;
		try {
			String urlNameString = (url).replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
			URL realUrl = new URL(urlNameString);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(requestMethod.toUpperCase());
			if (null != param) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(param.replace("\"", "%22").replace("{", "%7b").replace("}", "%7d").getBytes("UTF-8"));
				outputStream.close();
			}
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			inputStream = connection.getInputStream();
		} catch (Exception e) {
			logger.info("请求超时", e);
			e.printStackTrace();
		}
		return inputStream;
	}

	/**
	 * 向指定URL发送GET,POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param requestMethod
	 *            请求方法("GET","POST"）
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendHttpRequestStr(String url, String requestMethod, String param) {
		logger.info("urlString:" + url + param);
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = (url).replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
			URL realUrl = new URL(urlNameString);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(requestMethod.toUpperCase());
			if (null != param) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(param.replace("\"", "%22").replace("{", "%7b").replace("}", "%7d").getBytes("UTF-8"));
				outputStream.close();
			}
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.info("请求超时", e);
			e.printStackTrace();
		} finally {// 使用finally块来关闭输入流
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		logger.info("result:" + result);
		return result;
	}

	/**
	 * 发起https请求并获取结果
	 *
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			else
				httpUrlConn.setRequestProperty("Content-Type", "application/json");
			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
		} catch (ConnectException e) {
			logger.error("httpsRequest()连接超时", e);
		} catch (Exception e) {
			logger.error("httpsRequest()请求异常", e);
		}
		return jsonObject;
	}

	public static boolean isWxBrowser(HttpServletRequest request) {
		Assert.notNull(request);
		String agent = request.getHeader("User-Agent");
		if (StringUtils.isBlank(agent)) {
			return false;
		}
		return agent.toLowerCase().indexOf("micromessenger") > 0;
	}

	public static boolean isAjax(HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		return requestedWith != null && "XMLHttpRequest".equals(requestedWith);
	}

	/**
	 * 判断是否是文件上传
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isFileUploadRequest(HttpServletRequest request) {
		String contentType = request.getContentType();
		return contentType != null && contentType.contains("multipart/form-data");
	}
	
	public static String doHttpGet(String urlString) {
		try {
			URL url = new URL(urlString);
			InputStream inputStream = url.openStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			StringBuilder stringBuilder = new StringBuilder(1000);

			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				stringBuilder.append(s);
			}

			reader.close();
			inputStream.close();

			return stringBuilder.toString().trim();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String doHttpPost(String urlstr, String params) {
		StringBuffer bufferRes = new StringBuffer();
		HttpURLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			URL url = new URL(urlstr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(65000);
			conn.setReadTimeout(65000);
			HttpURLConnection.setFollowRedirects(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			out = conn.getOutputStream();
			out.write(params.getBytes("UTF-8"));
			out.flush();
			out.close();
			in = conn.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(in,
					"UTF-8"));
			String valueString = null;
			while ((valueString = read.readLine()) != null) {
				bufferRes.append(valueString);
			}
			in.close();
			if (conn != null) {
				conn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return bufferRes.toString();
	}
	
	public static String doGet(String accessUrl, Object o) {
		HttpURLConnection connect = null;
		int code = 0;
		String msg = "";
		try {
			if (accessUrl.indexOf("?") == -1) {
				accessUrl += "?";
			}
			Class<?> cls = o.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				if (f.get(o) != null && !f.get(o).equals("")) {
					accessUrl += "&" + f.getName() + "=" + f.get(o);
				}
			}
			URL url = new URL(accessUrl);
			connect = (HttpURLConnection) url.openConnection();
			connect.setConnectTimeout(10000);
			connect.connect();
			if (connect.getResponseCode() == 200) {
				String json = readContent(connect.getInputStream());
				logger.info("GET:" + json);
				return json;
			}else {
				String json = readContent(connect.getErrorStream());
				logger.error(json);
			}
			code = 500;
		} catch (MalformedURLException e) {
			msg = "不是正确的URL";
			logger.error(msg, e);
		} catch (Exception e) {
			msg = "读取URL时发生错误";
			logger.error(msg, e);
		} finally {
			if (connect != null) {
				connect.disconnect();
			}
		}
		return "{\"code\":" + code + ",\"msg\":\"" + msg + "\"}";
	}
	
	/**
	 * 读取流中的内容，返回String
	 * 
	 * @param is
	 * @return
	 */
	public static String readContent(InputStream is) {
		BufferedReader br;
		StringBuffer content = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			char[] cbuf = new char[1024];
			int size = 0;
			while ((size = br.read(cbuf)) != -1) {
				content.append(cbuf, 0, size);
			}
		} catch (UnsupportedEncodingException e1) {
			logger.error("不支付的编码格式", e1);
		} catch (IOException e) {
			logger.error("在读取数据流时出错.", e);
		}
		return content.toString();
	}
	
	
    /**
     * 获取解析消息包的信息
     * @param request
     * @return
     */
	public static String requestGetBody(HttpServletRequest request){
		String context= "";
		try {
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader bufferedReader = null;
			try {
				InputStream inputStream = request.getInputStream();
				if (inputStream != null) {
					bufferedReader = new BufferedReader(new InputStreamReader(
							inputStream, "UTF-8"));
					char[] charBuffer = new char[128];
					int bytesRead = -1;
					while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
						stringBuilder.append(charBuffer, 0, bytesRead);
					}
				} else {
					stringBuilder.append("");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
			context = stringBuilder.toString();
			return context;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}