package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserCommissionAccountLogs {
    private String id;

    private String userAccountId;

    private Byte recordType;

    private String changeType;

    private String userAccountLogId;

    private String changeNote;

    private Date changedAt;

    private BigDecimal changeAmount;

    private BigDecimal accountAmount;

    private Byte withdrawType;

    private String withdrawNo;

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

    public String getUserAccountLogId() {
        return userAccountLogId;
    }

    public void setUserAccountLogId(String userAccountLogId) {
        this.userAccountLogId = userAccountLogId == null ? null : userAccountLogId.trim();
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

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Byte getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Byte withdrawType) {
        this.withdrawType = withdrawType;
    }

    public String getWithdrawNo() {
        return withdrawNo;
    }

    public void setWithdrawNo(String withdrawNo) {
        this.withdrawNo = withdrawNo == null ? null : withdrawNo.trim();
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