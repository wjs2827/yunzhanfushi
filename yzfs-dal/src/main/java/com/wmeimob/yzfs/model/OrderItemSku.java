package com.wmeimob.yzfs.model;

import java.util.Date;

public class OrderItemSku {
	
    private Integer id;

    private String orderItemSkuName;
    
    private String spuId;//商品ID

	private String skuCode;

    private String picKey;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getSpuId() {
		return spuId;
	}

	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

    public String getOrderItemSkuName() {
        return orderItemSkuName;
    }

    public void setOrderItemSkuName(String orderItemSkuName) {
        this.orderItemSkuName = orderItemSkuName == null ? null : orderItemSkuName.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
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
}