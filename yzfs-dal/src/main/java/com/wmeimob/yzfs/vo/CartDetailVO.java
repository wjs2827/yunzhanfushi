package com.wmeimob.yzfs.vo;

import java.util.List;

/**
 * 购物车明细VO
 */
public class CartDetailVO {

	private String shopId;

	private String shopName;

	private List<CartOrderItemVO> orderItems;

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<CartOrderItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CartOrderItemVO> orderItems) {
		this.orderItems = orderItems;
	}

}
