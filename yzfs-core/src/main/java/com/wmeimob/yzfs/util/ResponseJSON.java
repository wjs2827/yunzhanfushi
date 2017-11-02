package com.wmeimob.yzfs.util;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * 返回JSON标准格式
 * @author zJun
 * @date 2016年12月30日 下午6:16:04
 */
public class ResponseJSON implements Serializable {

	private static final long serialVersionUID = -6898746630346161319L;
	
	public static final String ERROR_MESSAGE = "程序异常";

	private Map<String, Object> result = new HashMap<>();

	public ResponseJSON(){
		this.result.put("code", HttpStatus.OK.value());
		this.result.put("message", "操作成功");
	}
	
	/**
	 * @param msg	失败提示
	 */
	public ResponseJSON(String msg) {
		this.result.put("code", HttpStatus.BAD_REQUEST);
		this.result.put("message", msg);
	}
	
	/**
	 * 
	 * @param code	成功或失败代码
	 * @param msg	成功或失败提示
	 * @param data	额外信息
	 */
	public ResponseJSON(HttpStatus code, String msg, Object data) {
		this.result.put("code", code.value());
		this.result.put("message", msg);
		this.result.put("data", data);
	}
	
	/**
	 * 转换JSON字符串
	 * @return
	 * @author zJun
	 * @date 2016年12月30日 下午6:31:57
	 */
	public String toJSONString(){
		try {
			ObjectMapper mapper=new ObjectMapper();
			return mapper.writeValueAsString(this.result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("转换JSON格式失败");
		}
	}
	
	/**
	 * 设置 成功或失败代码
	 * @param code
	 * @author zJun
	 * @date 2016年12月30日 下午6:32:19
	 */
	public void setCode(HttpStatus code) {
		this.result.put("code", code.value());
	}
	
	/**
	 * 获得成功或失败代码
	 * @return
	 * @author zJun
	 * @date 2016年12月30日 下午6:32:34
	 */
	public int getCode(){
		return (int) this.result.get("code");
	}
	
	/**
	 * 设置成功或失败提示信息
	 * @param msg
	 * @author zJun
	 * @date 2016年12月30日 下午6:32:44
	 */
	public void setMessage(String msg) {
		this.result.put("message", msg);
	}
	
	public void put(String key, Object value){
		this.result.put(key, value);
	}

	/**
	 * 获得成功或失败提示信息
	 * @return
	 * @author zJun
	 * @date 2016年12月30日 下午6:32:57
	 */
	public String getMessage(){
		return this.result.get("message").toString();
	}
	
	/**
	 * 设置传送对象信息
	 * @param data
	 * @author zJun
	 * @date 2016年12月30日 下午6:33:18
	 */
	public void setData(Object data) {
		this.result.put("data", data);
	}
	
	public Map<String, Object> getResult(){
		return this.result;
	}

//	/**
//	 * 获得传送对象信息
//	 * @param clazz
//	 * @return
//	 * @author zJun
//	 * @date 2016年12月30日 下午6:33:40
//	 */
//	public <T> T getData(Class<T> clazz){
//		return this.result.getObject("data", clazz);
//	}
//	
//	/**
//	 * 获得传送对象JSON信息
//	 * @return
//	 * @author zJun
//	 * @date 2016年12月30日 下午6:34:53
//	 */
//	public JSONObject getJSONData(){
//		return this.result.getJSONObject("data");
//	}
	
	
}
