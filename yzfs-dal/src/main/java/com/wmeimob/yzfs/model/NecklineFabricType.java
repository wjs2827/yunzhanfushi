package com.wmeimob.yzfs.model;

import java.util.Date;

public class NecklineFabricType {
	
    private String id;//布料 ID

    private String fabricName;//布料名称

    private String picKey;//布料图片

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;//是否删除 0 删除 1未删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName == null ? null : fabricName.trim();
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}