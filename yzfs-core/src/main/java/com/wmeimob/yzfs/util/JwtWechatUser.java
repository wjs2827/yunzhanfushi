package com.wmeimob.yzfs.util;

import com.wmeimob.yzfs.model.User;

public class JwtWechatUser extends JwtUser {
	private static final long serialVersionUID = 3122663151190357838L;
	
	private User member = null;

	public JwtWechatUser(User member) {
		super(String.valueOf(member.getId()), member.getWxOpenId(),member.getNickName(),member.getMobile(),  member.getCreatedAt());
		this.member = member;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
