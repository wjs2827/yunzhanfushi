package com.wmeimob.yzfs.vo;

import java.util.Date;

/**
 * Created by zhongjing
 *
 * @Date 2016/7/29 11:41
 */
public class GoodsClassVO {
    private String id;

    private String name;

    private String picKey;

    private Integer rank;

    private String parentId;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    private String parentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
