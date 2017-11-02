package com.wmeimob.yzfs.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.exception.WechatException;
import com.wmeimob.yzfs.util.ResponseJSON;

/**
 * 全局异常处理类
 * @author zJun
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { WechatException.class, RuntimeException.class,CustomException.class})
	@ResponseBody
	public String exceptionHandler(RuntimeException e, HttpServletResponse response) throws IOException {
		ResponseJSON result = new ResponseJSON();
		
		if(e instanceof WechatException) {
			WechatException exp = (WechatException) e;
			result.setCode(exp.getCode());
			result.setMessage(exp.getMsg());
			if(!exp.getCode().equals(HttpStatus.FORBIDDEN))
				exp.printStackTrace();
			
			if(exp.getCode().equals(HttpStatus.RESET_CONTENT)){
				response.sendRedirect("/wechat/view/scan.html");
			}
		} else if(e instanceof RuntimeException) {
			result.setCode(HttpStatus.BAD_REQUEST);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return result.toJSONString();
	}
}
