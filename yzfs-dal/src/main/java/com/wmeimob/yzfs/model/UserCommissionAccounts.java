package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserCommissionAccounts {
	
    private String id;

    private String userId;

    private BigDecimal amount;//账户佣金

    private BigDecimal withdrawAmount;//提现佣金
    
    private BigDecimal todayAmount;//今日获得佣金

    private BigDecimal historyAmount;//历史累计佣金（不包含提现佣金）

	private String bindOpenId;

    private String bindWxNickname;

    private String bindWxHeadimg;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public BigDecimal getTodayAmount() {
		return todayAmount;
	}

	public void setTodayAmount(BigDecimal todayAmount) {
		this.todayAmount = todayAmount;
	}

	public BigDecimal getHistoryAmount() {
		return historyAmount;
	}

	public void setHistoryAmount(BigDecimal historyAmount) {
		this.historyAmount = historyAmount;
	}

	public String getBindOpenId() {
		return bindOpenId;
	}

	public void setBindOpenId(String bindOpenId) {
		this.bindOpenId = bindOpenId;
	}

	public String getBindWxNickname() {
		return bindWxNickname;
	}

	public void setBindWxNickname(String bindWxNickname) {
		this.bindWxNickname = bindWxNickname;
	}

	public String getBindWxHeadimg() {
		return bindWxHeadimg;
	}

	public void setBindWxHeadimg(String bindWxHeadimg) {
		this.bindWxHeadimg = bindWxHeadimg;
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