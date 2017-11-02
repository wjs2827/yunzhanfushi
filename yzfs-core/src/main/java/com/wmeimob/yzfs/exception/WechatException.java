package com.wmeimob.yzfs.exception;

import org.springframework.http.HttpStatus;

/**
 * 自定义异常类
 * @author zJun
 */
public class WechatException extends RuntimeException {

	private static final long serialVersionUID = -6244518028589887059L;
	public HttpStatus code;
	public String msg;
	
	public WechatException() {}

	public WechatException(HttpStatus code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public WechatException(String exceptionMsg) {
		super(exceptionMsg);
		this.code = HttpStatus.BAD_REQUEST;
		this.msg = exceptionMsg;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
