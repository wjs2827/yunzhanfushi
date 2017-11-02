package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class SysConfigs {
	
    private String id;//参数设置表ID

    private Integer type;//参数类型   0：阅读有赏  1：抽奖活动

    private String configName;//参数名称

    private BigDecimal configValue;//参数值

    private String configCode;//参数编码

    private Date createdAt;//创建时间

    private Date updatedAt;//修改时间

    private Boolean status;//状态  0：禁用 1 启用

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public BigDecimal getConfigValue() {
        return configValue;
    }

    public void setConfigValue(BigDecimal configValue) {
        this.configValue = configValue;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
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