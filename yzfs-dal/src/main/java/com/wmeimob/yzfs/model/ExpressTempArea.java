package com.wmeimob.yzfs.model;

import java.util.Date;

public class ExpressTempArea {
    private Integer id;

    private Integer expressTempDetailsId;
    
    private Integer expressLv;

    private Integer areaId;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpressTempDetailsId() {
        return expressTempDetailsId;
    }

    public void setExpressTempDetailsId(Integer expressTempDetailsId) {
        this.expressTempDetailsId = expressTempDetailsId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

	public Integer getExpressLv() {
		return expressLv;
	}

	public void setExpressLv(Integer expressLv) {
		this.expressLv = expressLv;
	}
}