package com.wmeimob.yzfs.vo;

import java.math.BigDecimal;

public class DataStatisticsVO {
	
	private String firstName;//一级分类
	
	private String firstClassId;//一级分类ID
	
	private String secondClassId;//二级分类ID
	
	private String secondName;//二级分类
	
	private String goodName;//商品名称
	
	private String skuName;//商品规格
	
	private String picKey;//商品图片
	
	private Integer saleCount;//销售数量
	
	private BigDecimal saleAmount;//销售金额
	
	private BigDecimal deductibleAmount;//金币抵扣金额
	
	private Integer refundCount;//退货数量
	
	private BigDecimal refundAmount;//退货金额
	
	private String userId;//用户ID
	
	private String headImg;//用户头像
	
	private String mobile;//用户手机号码
	
	private String nickName;//用户昵称
	
	private BigDecimal sumRechargeAmount;//累计充值金额
	
	private BigDecimal  sumAttachAmount;//累计赠送金额
	
	private BigDecimal sumAccountAmount;//累计增加余额
	
	private BigDecimal sumCommissionAccountAmount;//账户可用佣金
	
	private BigDecimal sumCommissonAmount;//累计佣金
	
	private BigDecimal  sumWithdrawAmount;//累计提现金额
	
	private String startTime;//开始时间
	
	private String  endTime;//结束时间
	
	private String sortType;//排序值
	
	private Boolean sort;//0 降序 1升序
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(BigDecimal deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	public Integer getRefundCount() {
		return refundCount;
	}

	public void setRefundCount(Integer refundCount) {
		this.refundCount = refundCount;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public BigDecimal getSumRechargeAmount() {
		return sumRechargeAmount;
	}

	public void setSumRechargeAmount(BigDecimal sumRechargeAmount) {
		this.sumRechargeAmount = sumRechargeAmount;
	}

	public BigDecimal getSumAttachAmount() {
		return sumAttachAmount;
	}

	public void setSumAttachAmount(BigDecimal sumAttachAmount) {
		this.sumAttachAmount = sumAttachAmount;
	}

	public BigDecimal getSumAccountAmount() {
		return sumAccountAmount;
	}

	public void setSumAccountAmount(BigDecimal sumAccountAmount) {
		this.sumAccountAmount = sumAccountAmount;
	}

	public BigDecimal getSumCommissionAccountAmount() {
		return sumCommissionAccountAmount;
	}

	public void setSumCommissionAccountAmount(BigDecimal sumCommissionAccountAmount) {
		this.sumCommissionAccountAmount = sumCommissionAccountAmount;
	}

	public BigDecimal getSumCommissonAmount() {
		return sumCommissonAmount;
	}

	public void setSumCommissonAmount(BigDecimal sumCommissonAmount) {
		this.sumCommissonAmount = sumCommissonAmount;
	}

	public BigDecimal getSumWithdrawAmount() {
		return sumWithdrawAmount;
	}

	public void setSumWithdrawAmount(BigDecimal sumWithdrawAmount) {
		this.sumWithdrawAmount = sumWithdrawAmount;
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

	public String getFirstClassId() {
		return firstClassId;
	}

	public void setFirstClassId(String firstClassId) {
		this.firstClassId = firstClassId;
	}

	public String getSecondClassId() {
		return secondClassId;
	}

	public void setSecondClassId(String secondClassId) {
		this.secondClassId = secondClassId;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public Boolean getSort() {
		return sort;
	}

	public void setSort(Boolean sort) {
		this.sort = sort;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	
	
	
	
	
	
}
