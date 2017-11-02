package com.wmeimob.yzfs.model;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 可改装商品SKU属性
 * @author WMM08
 */
public class EcNeckSku {

    private int id;//表ID
    
    private String spuId;//商品ID
    
    private String spuCode;//商品编码
    
    private String skuCode;//SKU编码
    
    private String skuName;//商品可改装SKU名称  例如 ：V领-花布
    
    private String skuJsonValue;//商品SKU JSON数据
    
    private String neckKey;//领口类型图片key
    
    private String fabricKey;//布料图片key
    
    private String picKey;//衣服图片key
    
    private BigDecimal salePrice;//加价
    
    private Date createdAt;//创建时间
    
    private Date updatedAt;//修改时间
    
    private Boolean status;//状态 0 禁用  1 正常

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpuId() {
		return spuId;
	}

	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
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

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public String getNeckKey() {
		return neckKey;
	}

	public void setNeckKey(String neckKey) {
		this.neckKey = neckKey;
	}

	public String getFabricKey() {
		return fabricKey;
	}

	public void setFabricKey(String fabricKey) {
		this.fabricKey = fabricKey;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSkuJsonValue() {
		return skuJsonValue;
	}

	public void setSkuJsonValue(String skuJsonValue) {
		this.skuJsonValue = skuJsonValue;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

    
    

}