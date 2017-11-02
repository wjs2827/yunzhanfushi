package com.wmeimob.yzfs.model;

public class OrderItem {

	private String id;
	private String goodId;
	private String name;
	private String orderItemSkuName;
	private String quantity;
	private String salePrice;
	private String spuKeys;
	
	private String userId;
	// 查询参数
	private Integer pageSize;// 每页显示行数
	private Integer pageIndex;// 页数
	

	public String getSpuKeys() {
		return spuKeys;
	}

	public void setSpuKeys(String spuKeys) {
		this.spuKeys = spuKeys;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderItemSkuName() {
		return orderItemSkuName;
	}

	public void setOrderItemSkuName(String orderItemSkuName) {
		this.orderItemSkuName = orderItemSkuName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

}