package com.wmeimob.yzfs.util;

import com.wmeimob.yzfs.model.User;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtWechatUser create(User member) {
		return new JwtWechatUser(member);
	}

}