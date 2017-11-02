package com.wmeimob.yzfs.model;

import java.util.Date;
import java.util.List;

public class EcSkuProperties {
	
    private Integer id;//ID

    private String categoryId;//分类ID

    private String skuName;//父级名称  例如：颜色   尺寸等

    private Boolean isUsed;//是否启用 0未启用 1启用

    private Date createdAt;//创建时间

    private Date updatedAt;//修改时间
    
    private List<EcSkuPropertiesItem> skuItem;

    private Boolean isDeleted;//是否正常 0已删除 1未删除
    
    private int rank;//排序值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<EcSkuPropertiesItem> getSkuItem() {
		return skuItem;
	}

	public void setSkuItem(List<EcSkuPropertiesItem> skuItem) {
		this.skuItem = skuItem;
	}
}