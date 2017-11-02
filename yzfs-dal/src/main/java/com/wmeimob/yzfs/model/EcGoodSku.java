package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class EcGoodSku {
	
	
    private Integer id;//表ID

    private String spuId;//商品ID

    private String spuCode;//商品编码

    private String skuCode;//SKU编码

    private String skuName;//SKU名称

    private BigDecimal price;//价格
    
    private BigDecimal marketPrice;//市场价

    private String picKey;//SKU图片

    private Integer stockCount;//库存

    private Integer lockCount;//锁定库存

    private Integer saleCount;//销售库存

    private BigDecimal weight;//重量

    private Date createdAt;//创建时间

    private Date updatedAt;//修改时间

    private Boolean isUsed;//是否启用 0 未启用  1启用

    private Boolean status;//是否正常  0禁用  1正常

    private String skujsonvalue;//存储SKU JSON格式数据

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
        this.spuId = spuId == null ? null : spuId.trim();
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode == null ? null : spuCode.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getLockCount() {
        return lockCount;
    }

    public void setLockCount(Integer lockCount) {
        this.lockCount = lockCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSkujsonvalue() {
        return skujsonvalue;
    }

    public void setSkujsonvalue(String skujsonvalue) {
        this.skujsonvalue = skujsonvalue == null ? null : skujsonvalue.trim();
    }

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
}