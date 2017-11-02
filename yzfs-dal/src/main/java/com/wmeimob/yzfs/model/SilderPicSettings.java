package com.wmeimob.yzfs.model;

import java.util.Date;

public class SilderPicSettings {
    private String id;

    private Boolean picType;

    private String shopId;

    private String picKey;

    private Integer rank;

    private Byte targetType;

    private String targetId;

    private String linkUrl;

    private Boolean isDisabled;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;
    
    private Integer totalCount;//总数量
    
    private String pName;//商品名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
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
        this.targetId = targetId == null ? null : targetId.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	public Integer getTotlalCount() {
		return totalCount;
	}

	public void setTotlalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
    
    
}