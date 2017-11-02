package com.wmeimob.yzfs.model;

import java.util.Date;

public class ShippingAddrs {
    private String id;

    private String shippingName;//收货人名称

    private Integer pId;//所在省ID
    
    private String pName;//省份名称

	private Integer cId;//所在城市ID
    
    private String cName;//城市名称

    private Integer dId;//所在区域ID
    
    private String dName;//区域名称

    private String shippingAddress;//详细地址

    private String mobile;//联系电话

    private String userId;//用户ID

    private Boolean isDefault;//是否默认地址

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    public String getId() {
        return id;
    }

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

    public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}
	
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
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

	public void setId(String id) {
		this.id = id;
	}
    
    

}