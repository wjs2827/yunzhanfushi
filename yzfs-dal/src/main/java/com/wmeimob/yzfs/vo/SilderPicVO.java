package com.wmeimob.yzfs.vo;


/**
 * 首页轮播图和分类导航图片VO
 */
public class SilderPicVO {
	private String id;

	private Boolean picType;

	private String shopId;

	private String picKey;

	private Integer rank;

	private Byte targetType;

	private String targetId;
	
	private String parentId;

	private String targetName;

	private String linkUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getPicType() {
		return picType;
	}

	public void setPicType(Boolean picType) {
		this.picType = picType;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Byte getTargetType() {
		return targetType;
	}

	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
