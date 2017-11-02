package com.wmeimob.yzfs.model;

import java.util.Date;

public class RightsOrders {
	
    private Integer id;

    private String orderItemId;//订单明细ID

    private String rightsOrderNo;//退款订单号

    private Date createdAt;//申请时间

    private Date updatedAt;
    
    private Date auditAt;//审核时间
    
    private Date returnAt;//退货时间
    
	private String remark;//备注
	
	private String rejectReason;//退货原因

    private Boolean type;//0 退款 1 换货

    private Boolean status;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId == null ? null : orderItemId.trim();
    }

    public String getRightsOrderNo() {
        return rightsOrderNo;
    }

    public void setRightsOrderNo(String rightsOrderNo) {
        this.rightsOrderNo = rightsOrderNo == null ? null : rightsOrderNo.trim();
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
    
    public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Date getAuditAt() {
		return auditAt;
	}

	public void setAuditAt(Date auditAt) {
		this.auditAt = auditAt;
	}

	public Date getReturnAt() {
		return returnAt;
	}

	public void setReturnAt(Date returnAt) {
		this.returnAt = returnAt;
	}

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}