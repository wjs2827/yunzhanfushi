package com.wmeimob.yzfs.model;

import java.util.Date;

public class UserCards {
	
    private Integer id;

    private String userId;

    private String cardNo;

    private Integer cardPoints;

    private Integer historyUsedPoints;

    private Integer termTime;

    private Date startTime;

    private String packageTypeId;

    private String promoterCode;

    private Boolean isActivated;

    private String snCode;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Integer getCardPoints() {
        return cardPoints;
    }

    public void setCardPoints(Integer cardPoints) {
        this.cardPoints = cardPoints;
    }

    public Integer getHistoryUsedPoints() {
        return historyUsedPoints;
    }

    public void setHistoryUsedPoints(Integer historyUsedPoints) {
        this.historyUsedPoints = historyUsedPoints;
    }

    public Integer getTermTime() {
        return termTime;
    }

    public void setTermTime(Integer termTime) {
        this.termTime = termTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(String packageTypeId) {
        this.packageTypeId = packageTypeId == null ? null : packageTypeId.trim();
    }

    public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode == null ? null : promoterCode.trim();
    }

    public Boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getSnCode() {
        return snCode;
    }

    public void setSnCode(String snCode) {
        this.snCode = snCode == null ? null : snCode.trim();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}