package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class ExpressTempDetails {
	
    private Integer id;

    private Integer tempId;
    
    private BigDecimal firstNum;

    private BigDecimal firstPrice;

    private BigDecimal nextNum;

    private BigDecimal nextPrice;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;
    
    private String areaIdList;

    private String areaNameList;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public BigDecimal getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(BigDecimal firstNum) {
        this.firstNum = firstNum;
    }

    public BigDecimal getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(BigDecimal firstPrice) {
        this.firstPrice = firstPrice;
    }

    public BigDecimal getNextNum() {
        return nextNum;
    }

    public void setNextNum(BigDecimal nextNum) {
        this.nextNum = nextNum;
    }

    public BigDecimal getNextPrice() {
        return nextPrice;
    }

    public void setNextPrice(BigDecimal nextPrice) {
        this.nextPrice = nextPrice;
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

	public String getAreaIdList() {
		return areaIdList;
	}

	public void setAreaIdList(String areaIdList) {
		this.areaIdList = areaIdList;
	}

	public String getAreaNameList() {
		return areaNameList;
	}

	public void setAreaNameList(String areaNameList) {
		this.areaNameList = areaNameList;
	}
}