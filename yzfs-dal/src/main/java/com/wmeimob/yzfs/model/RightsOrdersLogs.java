package com.wmeimob.yzfs.model;

import java.util.Date;

public class RightsOrdersLogs {
	
    private Integer id;

    private Byte logisStatus;//状态 0 买家申请退款（或者换货），待商家处理  1 商家已同意退款（换货） ，1-7个工作日内收到退款 2.商家未同意退款，请致电客服处理  3商家退款 

    private Integer rightsOrderId;//退款订单ID

    private Date createdAt;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getLogisStatus() {
        return logisStatus;
    }

    public void setLogisStatus(Byte logisStatus) {
        this.logisStatus = logisStatus;
    }

    public Integer getRightsOrderId() {
        return rightsOrderId;
    }

    public void setRightsOrderId(Integer rightsOrderId) {
        this.rightsOrderId = rightsOrderId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}