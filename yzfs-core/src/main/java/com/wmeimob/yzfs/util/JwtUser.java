package com.wmeimob.yzfs.util;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements Serializable {

	private static final long serialVersionUID = -955272199747731688L;

	private String id;
	private String openId;
	private String username;
	private String mobile;
	private String password;
	private Date lastPasswordResetDate;

	public JwtUser(String id,String openId, String username,String mobile,Date lastPasswordResetDate) {
		this.id = id;
		this.openId=openId;
		this.mobile=mobile;
		this.username = username;
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOpenId() {
		return openId;
	}


	public void setOpenId(String openId) {
		this.openId = openId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}


	// 这个是自定义的，返回上次密码重置日期
	@JsonIgnore
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

}