package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccounts {
    private String id;

    private String userId;

    private BigDecimal amount;

    private BigDecimal withdrawAmount;

    private BigDecimal historyAmount;

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
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        this.bindOpenId = bindOpenId == null ? null : bindOpenId.trim();
    }

    public String getBindWxNickname() {
        return bindWxNickname;
    }

    public void setBindWxNickname(String bindWxNickname) {
        this.bindWxNickname = bindWxNickname == null ? null : bindWxNickname.trim();
    }

    public String getBindWxHeadimg() {
        return bindWxHeadimg;
    }

    public void setBindWxHeadimg(String bindWxHeadimg) {
        this.bindWxHeadimg = bindWxHeadimg == null ? null : bindWxHeadimg.trim();
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