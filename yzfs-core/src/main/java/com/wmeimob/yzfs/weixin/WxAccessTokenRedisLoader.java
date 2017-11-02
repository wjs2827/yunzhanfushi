package com.wmeimob.yzfs.weixin;

import com.wmeimob.yzfs.util.RedisUtil;
import com.wmeimob.wechat.model.basic.WxAccessToken;

public class WxAccessTokenRedisLoader implements com.wmeimob.wechat.loader.WxAccessTokenLoader {

	@Override
	public String get() {
		return RedisUtil.getValue(RedisUtil.KEY_ACCESS_TOKEN);
	}

	@Override
	public void set(WxAccessToken accessToken) {
		RedisUtil.setValue(RedisUtil.KEY_ACCESS_TOKEN, accessToken.getAccessToken(), accessToken.getExpire() - 1200);
	}

	@Override
	public void remove() {
		RedisUtil.setValue(RedisUtil.KEY_ACCESS_TOKEN, "");
	}
}
