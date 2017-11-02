package com.wmeimob.yzfs.model;

import java.util.Date;

public class Thumbs {
    private String id;
    private String userId;
    private String goodsShowId;//买家秀id
    private Date createdAt;//创建时间
    private Integer status;//状态 0 禁用 1 启用
    private String headImg;//图片
    
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getGoodsShowId() {
		return goodsShowId;
	}
	public void setGoodsShowId(String goodsShowId) {
		this.goodsShowId = goodsShowId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
}