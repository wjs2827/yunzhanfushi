package com.wmeimob.yzfs.vo;

import java.math.BigDecimal;

/**
 * 购物车商品明细
 */
public class CartOrderItemVO {
	private String orderItemId;
	private String goodId;
	private String goodName;
	private String goodPic;
	private BigDecimal salePrice;
	private String goodSpecId;
	private String specName;
	private Integer quantity;
	private Integer limitedCount;
	private Integer salePoints;
	private Integer lastCount;

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodPic() {
		return goodPic;
	}

	public void setGoodPic(String goodPic) {
		this.goodPic = goodPic;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getGoodSpecId() {
		return goodSpecId;
	}

	public void setGoodSpecId(String goodSpecId) {
		this.goodSpecId = goodSpecId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLimitedCount() {
		return limitedCount;
	}

	public void setLimitedCount(Integer limitedCount) {
		this.limitedCount = limitedCount;
	}

	public Integer getSalePoints() {
		return salePoints;
	}

	public void setSalePoints(Integer salePoints) {
		this.salePoints = salePoints;
	}

	public Integer getLastCount() {
		return lastCount;
	}

	public void setLastCount(Integer lastCount) {
		this.lastCount = lastCount;
	}
	

}
