package com.wmeimob.yzfs.weixin;

import com.wmeimob.yzfs.util.RedisUtil;
import com.wmeimob.wechat.model.basic.WxTicket;
import com.wmeimob.wechat.model.basic.WxTicketType;

public class WxTicketRedisLoader implements com.wmeimob.wechat.loader.WxTicketLoader {

	@Override
	public String get(WxTicketType type) {
		return RedisUtil.getValue(RedisUtil.KEY_JSAPI_TICKET);
	}

	@Override
	public void refresh(WxTicket ticket) {
		RedisUtil.setValue(RedisUtil.KEY_JSAPI_TICKET, ticket.getTicket(), ticket.getExpire() - 1200);
	}

}
