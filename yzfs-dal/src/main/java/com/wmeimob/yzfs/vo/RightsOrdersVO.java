package com.wmeimob.yzfs.vo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.wmeimob.yzfs.model.RightsOrders;
import com.wmeimob.yzfs.model.RightsOrdersLogs;

public class RightsOrdersVO extends RightsOrders{
	
	 //查询参数
	private String shippingName;//收货人
	
	private String mobile;//手机
	
	private String pName;//省份
	
	private String cName;//城市
	
	private String dName;//区域
	
	private String shippingAddress;//详细地址
	
	private String orderNo;//订单编号
	 
	private Date orderTime;//下单时间
	
	private Date payTime;//支付时间
	
    private Date shippingAt;//发货时间

	private Date receiptAt;//确认收货时间
	
    private String shippingVendor;//物流公司

    private String shippingNo;//发货单号
    
    private String userComments;//下单留言
    
    private BigDecimal shippingFee;//运费
    
    private BigDecimal orderAmount;//订单金额
    
    private BigDecimal payAmount;//支付金额

    private Integer orderPoints;//订单的积分(应支付积分)

    private Integer payPoints;//实际支付积分
	
	private String userId;//用户ID
	
	private String nickName;//客户昵称
	
	private String goodName;//商品名称
	
	private String picKey;//商品图片

	private String skuProperties;//商品属性
    
    private String neckProperties;//私人订制属性
	
	private BigDecimal salePrice;//销售价格
	
	private Integer quantity;//商品数量
	
	private BigDecimal returnAmount;//退款金额
	
	private Integer refundsStatus;//退款订单状态 0未退货，1退款申请，2商家处理中，3退款成功，4退款失败
	
	private Integer  orderStatus;//订单状态
   
    private String startTime;//创建开始时间
    
    private String endTime;//创建结束时间
    
    private Integer pageSize;//每页显示行数
    
    private Integer pageIndex;//页数
    
    private String classId;//分类ID
    
	private List<RightsOrdersLogs> rightItemsLog;//退款进度明细列表信息

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getShippingAt() {
		return shippingAt;
	}

	public void setShippingAt(Date shippingAt) {
		this.shippingAt = shippingAt;
	}

	public Date getReceiptAt() {
		return receiptAt;
	}

	public void setReceiptAt(Date receiptAt) {
		this.receiptAt = receiptAt;
	}

	public String getShippingVendor() {
		return shippingVendor;
	}

	public void setShippingVendor(String shippingVendor) {
		this.shippingVendor = shippingVendor;
	}

	public String getShippingNo() {
		return shippingNo;
	}

	public void setShippingNo(String shippingNo) {
		this.shippingNo = shippingNo;
	}
	
	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	
	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getOrderPoints() {
		return orderPoints;
	}

	public void setOrderPoints(Integer orderPoints) {
		this.orderPoints = orderPoints;
	}

	public Integer getPayPoints() {
		return payPoints;
	}

	public void setPayPoints(Integer payPoints) {
		this.payPoints = payPoints;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	
	
    public String getSkuProperties() {
		return skuProperties;
	}

	public void setSkuProperties(String skuProperties) {
		this.skuProperties = skuProperties;
	}

	public String getNeckProperties() {
		return neckProperties;
	}

	public void setNeckProperties(String neckProperties) {
		this.neckProperties = neckProperties;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	public Integer getRefundsStatus() {
		return refundsStatus;
	}

	public void setRefundsStatus(Integer refundsStatus) {
		this.refundsStatus = refundsStatus;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public List<RightsOrdersLogs> getRightItemsLog() {
		return rightItemsLog;
	}

	public void setRightItemsLog(List<RightsOrdersLogs> rightItemsLog) {
		this.rightItemsLog = rightItemsLog;
	}

	

	
}