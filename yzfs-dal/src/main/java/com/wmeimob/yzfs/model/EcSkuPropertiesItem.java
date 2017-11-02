package com.wmeimob.yzfs.model;

import java.util.Date;

public class EcSkuPropertiesItem {
	
    private Integer id;//

    private int ecSkuPropertiesId;//父级skuID
    
    private String listchildrenId;//子规格ID

    private String name;//

    private Date createdAt;//

    private Date updateTime;//

    private Boolean isDelete;//

    private Integer rank;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

	public int getEcSkuPropertiesId() {
		return ecSkuPropertiesId;
	}

	public void setEcSkuPropertiesId(int ecSkuPropertiesId) {
		this.ecSkuPropertiesId = ecSkuPropertiesId;
	}

	public String getListchildrenId() {
		return listchildrenId;
	}

	public void setListchildrenId(String listchildrenId) {
		this.listchildrenId = listchildrenId;
	}
}