package com.wmeimob.yzfs.model;

import java.util.Date;

public class UserCardLogs {
	
	
    private Integer id;

    private int userCardId;
    
    private Byte recordType;

    private String changeType;

    private String orderId;

    private String changeNote;

    private Date changedAt;

    private Integer changePoints;

    private Integer accountPoints;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserCardId() {
		return userCardId;
	}

	public void setUserCardId(int userCardId) {
		this.userCardId = userCardId;
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

    public Integer getChangePoints() {
        return changePoints;
    }

    public void setChangePoints(Integer changePoints) {
        this.changePoints = changePoints;
    }

    public Integer getAccountPoints() {
        return accountPoints;
    }

    public void setAccountPoints(Integer accountPoints) {
        this.accountPoints = accountPoints;
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