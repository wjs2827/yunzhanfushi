package com.wmeimob.yzfs.vo;

import java.math.BigDecimal;

import com.wmeimob.yzfs.model.User;

public class UserVO extends User{
	
	private String recommentNickName;//推广人名称
	
	private BigDecimal sumRechargeAmount;//充值金额
	
	private BigDecimal amount;//余额
	
	private Integer sumPoints;//金币
	
	private String startTime;//开始时间
	
	private String endTime;//结束时间
	
	private Boolean changeType;//变更类型
	
	private String changeReson;//变更原因
	
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

	public String getRecommentNickName() {
		return recommentNickName;
	}

	public void setRecommentNickName(String recommentNickName) {
		this.recommentNickName = recommentNickName;
	}

	public BigDecimal getSumRechargeAmount() {
		return sumRechargeAmount;
	}

	public void setSumRechargeAmount(BigDecimal sumRechargeAmount) {
		this.sumRechargeAmount = sumRechargeAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getSumPoints() {
		return sumPoints;
	}

	public void setSumPoints(Integer sumPoints) {
		this.sumPoints = sumPoints;
	}

	public Boolean getChangeType() {
		return changeType;
	}

	public void setChangeType(Boolean changeType) {
		this.changeType = changeType;
	}

	public String getChangeReson() {
		return changeReson;
	}

	public void setChangeReson(String changeReson) {
		this.changeReson = changeReson;
	}
	
	

}
