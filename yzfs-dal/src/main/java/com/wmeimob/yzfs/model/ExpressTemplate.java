package com.wmeimob.yzfs.model;

import java.util.Date;

public class ExpressTemplate {
    private Integer id;

    private String tempName;//模板名称

    private Boolean bear;//承担者：0.卖家承担费用、1.买家承担费用

    private int expressType;//快递类型  0.快递 1.EMS   2.平邮   3.空运   4.海运

    private Integer expressPriceType;//计价方式：1.件数、2.重量、3.体积

    private Date createTime;

    private Date updateTime;

    private Boolean isUsed;//是否启用 0 停用  1启用

    private Boolean isDeleted;//是否删除  0 删除 1 未删除

    private Boolean isDefault;//是否默认  0 未默认  1 默认模板
    
    private int tempLength;//模板长度

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName == null ? null : tempName.trim();
    }

    public Boolean getBear() {
        return bear;
    }

    public void setBear(Boolean bear) {
        this.bear = bear;
    }

    public int getExpressType() {
        return expressType;
    }

    public void setExpressType(int expressType) {
        this.expressType = expressType;
    }

    public Integer getExpressPriceType() {
        return expressPriceType;
    }

    public void setExpressPriceType(Integer expressPriceType) {
        this.expressPriceType = expressPriceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

	public int getTempLength() {
		return tempLength;
	}

	public void setTempLength(int tempLength) {
		this.tempLength = tempLength;
	}
}