package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders {
	
    private String id;
    
    private List<OrderItems> orderItems;//订单详情
    
    private String shopId;//商铺ID
    
    private String shippingShopName;//商铺名称

    private Boolean orderType;//0单店铺订单，1多店铺订单

    private String parentOrderId;//父订单ID，目前仅适用购物车订单

    private String ownerId;//归属人id（会员id）

    private String orderNo;//订单编号
    
    private Boolean isSelfPicked;//0送货上门，1总店自提

    private String shippingName;//收货人

    private Integer shippingProvince;//收货人所在省ID
    
    private String pName;//省名称

    private Integer shippingCity;//收货人所在城市ID
    
    private String cName;//市名称

    private Integer shippingDistrict;//收货人所在地区ID
    
    private String dName;//区名称

    private String shippingAddress;//收货人详细地址

    private String mobile;//收货人联系电话
    
    private String shippingContact;//提货点联系人

    private BigDecimal shippingFee;//运费
    
    private BigDecimal orderAmount;//订单金额
    
    private BigDecimal payAmount;//支付金额

    private Integer orderPoints;//订单的积分(应支付积分)

    private Integer payPoints;//实际支付积分
    
    private Integer sumQuantity;//单个订单总数量

	private Date payAt;//支付时间

    private String payNo;//支付流水号

    private Integer payType;//支付类型: 1微信支付，2余额支付，3积分支付，4余额和积分，5支付宝

    private Integer repayCount;//重复支付的次数

    private Date receiptAt;//确认收货时间

    private Integer orderStatus;//订单状态：0未付款，1待发货，2待收货，3完成，4撤消，5已评论

    private String userComments;//买家留言

    private String refundsComments;//退货留言

    private Integer refundsStatus;//0未退货，1退货中，2退货成功，3退货失败
    
    private Date refundsAt;//退货时间

    private String refundsReason;//退货原因

    private String shippingVendor;//物流公司

    private String shippingNo;//发货单号

    private Date shippingAt;//发货时间

	private String shippingNote;//发货备注
    
    private Boolean isSettleCommission;//是否结算
    
    private Date settledAt;//结算时间

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;
    
    
    //查询参数
    private String startTime;//创建开始时间
    
    private String endTime;//创建结束时间
    
    private Integer pageSize;//每页显示行数
    
    private Integer pageIndex;//页数
    
    private String classId;//分类ID
    
    private String goodName;//商品名称
    
    private String nickName;//用户昵称
    
    private String[] goodIds;//商品IDS
    
    private Integer[] nums;//商品数量
    
    private BigDecimal oneSettleAmount;

    private BigDecimal twoSettleAmount;

    private BigDecimal getPoints;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShippingShopName() {
		return shippingShopName;
	}

	public void setShippingShopName(String shippingShopName) {
		this.shippingShopName = shippingShopName;
	}

	public Boolean getOrderType() {
		return orderType;
	}

	public void setOrderType(Boolean orderType) {
		this.orderType = orderType;
	}

	public String getParentOrderId() {
		return parentOrderId;
	}

	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Boolean getIsSelfPicked() {
		return isSelfPicked;
	}

	public void setIsSelfPicked(Boolean isSelfPicked) {
		this.isSelfPicked = isSelfPicked;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Integer getShippingProvince() {
		return shippingProvince;
	}

	public void setShippingProvince(Integer shippingProvince) {
		this.shippingProvince = shippingProvince;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(Integer shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getShippingDistrict() {
		return shippingDistrict;
	}

	public void setShippingDistrict(Integer shippingDistrict) {
		this.shippingDistrict = shippingDistrict;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getShippingContact() {
		return shippingContact;
	}

	public void setShippingContact(String shippingContact) {
		this.shippingContact = shippingContact;
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
	
    public Integer getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(Integer sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public Date getPayAt() {
		return payAt;
	}

	public void setPayAt(Date payAt) {
		this.payAt = payAt;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getRepayCount() {
		return repayCount;
	}

	public void setRepayCount(Integer repayCount) {
		this.repayCount = repayCount;
	}

	public Date getReceiptAt() {
		return receiptAt;
	}

	public void setReceiptAt(Date receiptAt) {
		this.receiptAt = receiptAt;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getUserComments() {
		return userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

	public String getRefundsComments() {
		return refundsComments;
	}

	public void setRefundsComments(String refundsComments) {
		this.refundsComments = refundsComments;
	}

	public Integer getRefundsStatus() {
		return refundsStatus;
	}

	public void setRefundsStatus(Integer refundsStatus) {
		this.refundsStatus = refundsStatus;
	}

	public Date getRefundsAt() {
		return refundsAt;
	}

	public void setRefundsAt(Date refundsAt) {
		this.refundsAt = refundsAt;
	}

	public String getRefundsReason() {
		return refundsReason;
	}

	public void setRefundsReason(String refundsReason) {
		this.refundsReason = refundsReason;
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

	public Date getShippingAt() {
		return shippingAt;
	}

	public void setShippingAt(Date shippingAt) {
		this.shippingAt = shippingAt;
	}

	public String getShippingNote() {
		return shippingNote;
	}

	public void setShippingNote(String shippingNote) {
		this.shippingNote = shippingNote;
	}

	public Boolean getIsSettleCommission() {
		return isSettleCommission;
	}

	public void setIsSettleCommission(Boolean isSettleCommission) {
		this.isSettleCommission = isSettleCommission;
	}

	public Date getSettledAt() {
		return settledAt;
	}

	public void setSettledAt(Date settledAt) {
		this.settledAt = settledAt;
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

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String[] getGoodIds() {
		return goodIds;
	}

	public void setGoodIds(String[] goodIds) {
		this.goodIds = goodIds;
	}

	public Integer[] getNums() {
		return nums;
	}

	public void setNums(Integer[] nums) {
		this.nums = nums;
	}

	public BigDecimal getOneSettleAmount() {
		return oneSettleAmount;
	}

	public void setOneSettleAmount(BigDecimal oneSettleAmount) {
		this.oneSettleAmount = oneSettleAmount;
	}

	public BigDecimal getTwoSettleAmount() {
		return twoSettleAmount;
	}

	public void setTwoSettleAmount(BigDecimal twoSettleAmount) {
		this.twoSettleAmount = twoSettleAmount;
	}

	public BigDecimal getGetPoints() {
		return getPoints;
	}

	public void setGetPoints(BigDecimal getPoints) {
		this.getPoints = getPoints;
	}

    
    
}