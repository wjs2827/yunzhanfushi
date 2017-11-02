package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccountLogs {
	
    private String id;

    private String userAccountId;

    private Byte recordType;

    private String changeType;

    private String orderId;

    private String changeNote;

    private Date changedAt;

    private BigDecimal changeAmount;

    private String rechargePackageName;

    private String promoterCode;

    private BigDecimal accountAmount;

    private BigDecimal attachAmount;

    private String fromUserId;

    private Byte payType;

    private Date payAt;

    private BigDecimal payAmount;

    private String payNo;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId == null ? null : userAccountId.trim();
    }

    public Byte getRecordType() {
        return recordType;
    }

    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getChangeNote() {
        return changeNote;
    }

    public void setChangeNote(String changeNote) {
        this.changeNote = changeNote == null ? null : changeNote.trim();
    }

    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public String getRechargePackageName() {
        return rechargePackageName;
    }

    public void setRechargePackageName(String rechargePackageName) {
        this.rechargePackageName = rechargePackageName == null ? null : rechargePackageName.trim();
    }

    public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode == null ? null : promoterCode.trim();
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public BigDecimal getAttachAmount() {
        return attachAmount;
    }

    public void setAttachAmount(BigDecimal attachAmount) {
        this.attachAmount = attachAmount;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Date getPayAt() {
        return payAt;
    }

    public void setPayAt(Date payAt) {
        this.payAt = payAt;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
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