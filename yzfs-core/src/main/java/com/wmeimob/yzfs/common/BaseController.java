package com.wmeimob.yzfs.common;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wmeimob.yzfs.weixin.WeChatUtil;
import com.wmeimob.yzfs.weixin.WxAccessTokenRedisLoader;
import com.wmeimob.yzfs.weixin.WxTicketRedisLoader;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.core.WeChatBuilder;

/**
 * 父类Controller
 */
public class BaseController {
	
	 public Logger log = Logger.getLogger(this.getClass());

	public static final WeChat WECHAT = WeChatBuilder.newBuilder(WeChatUtil.APP_ID, WeChatUtil.APP_SECRET)
			.wxAccessTokenLoader(new WxAccessTokenRedisLoader()).ticketLoader(new WxTicketRedisLoader()).build();

	/**
	 * 异常处理
	 * 
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler() {
		return "error/error";
	}
}
