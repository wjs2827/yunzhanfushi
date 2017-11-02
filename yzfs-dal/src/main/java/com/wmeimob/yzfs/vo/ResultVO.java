package com.wmeimob.yzfs.vo;

import java.io.Serializable;

/**
 * 返回结果VO
 */
public class ResultVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350995225150217339L;
	
	private String id;

	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	private String message;

	/**
	 * 数据
	 */
	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
