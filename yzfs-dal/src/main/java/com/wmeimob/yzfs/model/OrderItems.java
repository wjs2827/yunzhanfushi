package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItems {
	
    private String id;
    
    private int payType;//1微信支付，2余额支付，3积分支付，4支付宝
    
    private String orderId;//订单ID
    
	private String orderNo;//订单号
    
    private String payNo;//支付流水号
    
    private String userId;//用户ID
    
	private BigDecimal returnAmount;//退款金额

	private Boolean containerType;//0订单，1购物车

    private String containerId;//容器ID，由容器类型决定。容器类型为0时，表示订单ID。容器类型为1时，表示购物车ID
    
    private Boolean isMade;//是否私人定制   true  是  false  非

    private String goodId;//商品ID
    
    private String skuCode;//商品已选择SKU编码
    
    private String neckSkuCode;//可改装商品SKU编码
    
	private int stockCount;//SKU库存
    
	private int goodSpecId;//多规格ID
    
    private int goodNeckId;//可改装ID

	private String goodName;//商品名称
    
    private String picKey;//商品图片
    
    private String spuCode;//商品编码
    
    private String skuProperties;//商品属性
    
    private String neckProperties;//私人订制属性

	private BigDecimal salePrice;//商品价格
    
    private BigDecimal farePrice;//加价金额
    
    private Integer salePoint;//销售积分
    
    private BigDecimal commission;//分佣
    
    private BigDecimal getPoints;//得到T金

	private Integer quantity;//商品数量
    
    private Integer refundsStatus;//退款状态

    private BigDecimal shippingFee;//运费

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;
    
    public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
    public String getNeckSkuCode() {
		return neckSkuCode;
	}

	public void setNeckSkuCode(String neckSkuCode) {
		this.neckSkuCode = neckSkuCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}
	
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Boolean getContainerType() {
		return containerType;
	}

	public void setContainerType(Boolean containerType) {
		this.containerType = containerType;
	}
	
	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public Boolean getIsMade() {
		return isMade;
	}

	public void setIsMade(Boolean isMade) {
		this.isMade = isMade;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public int getGoodSpecId() {
		return goodSpecId;
	}

	public void setGoodSpecId(int goodSpecId) {
		this.goodSpecId = goodSpecId;
	}

	public int getGoodNeckId() {
		return goodNeckId;
	}

	public void setGoodNeckId(int goodNeckId) {
		this.goodNeckId = goodNeckId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getSkuProperties() {
		return skuProperties;
	}

	public void setSkuProperties(String skuProperties) {
		this.skuProperties = skuProperties;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	
    public String getNeckProperties() {
		return neckProperties;
	}

	public void setNeckProperties(String neckProperties) {
		this.neckProperties = neckProperties;
	}

	public BigDecimal getFarePrice() {
		return farePrice;
	}

	public void setFarePrice(BigDecimal farePrice) {
		this.farePrice = farePrice;
	}

	public Integer getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(Integer salePoint) {
		this.salePoint = salePoint;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getGetPoints() {
		return getPoints;
	}

	public void setGetPoints(BigDecimal getPoints) {
		this.getPoints = getPoints;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getRefundsStatus() {
		return refundsStatus;
	}

	public void setRefundsStatus(Integer refundsStatus) {
		this.refundsStatus = refundsStatus;
	}

	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
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