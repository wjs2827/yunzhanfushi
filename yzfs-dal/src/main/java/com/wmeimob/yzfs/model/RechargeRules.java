package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeRules {
	
    private String id;

    private String remark;//规则说明

    private BigDecimal rechargeAmount;//充值金额

    private BigDecimal attachAmount;//附加金额（赠送金额）

    private BigDecimal commissionRate;//佣金比例

    private Boolean isUsed;//是否使用：0否，1是

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getAttachAmount() {
        return attachAmount;
    }

    public void setAttachAmount(BigDecimal attachAmount) {
        this.attachAmount = attachAmount;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
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