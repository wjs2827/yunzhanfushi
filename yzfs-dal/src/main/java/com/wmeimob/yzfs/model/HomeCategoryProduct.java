package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class HomeCategoryProduct {
	
    private String id;//首页分类商品表ID

    private String homeCategoryId;//首页分类ID
    
    private int type;//分类类型 1 一级分类  2 二级分类 3 三级分类

    private String spuId;//商品ID
    
    private String name;//商品名称
    
    private String spuKey;//首页分类图片key
    
    private BigDecimal markket_price;//市场价
    
    private BigDecimal show_price;//显示价
    
    private int sale_count;//销量

    private Date createdAt;

    private Date updatedAt;
    
    private Boolean isDeleted;//是否删除

    private Integer rank;//排序

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHomeCategoryId() {
        return homeCategoryId;
    }

    public void setHomeCategoryId(String homeCategoryId) {
        this.homeCategoryId = homeCategoryId == null ? null : homeCategoryId.trim();
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId == null ? null : spuId.trim();
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

	public String getSpuKey() {
		return spuKey;
	}

	public void setSpuKey(String spuKey) {
		this.spuKey = spuKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMarkket_price() {
		return markket_price;
	}

	public void setMarkket_price(BigDecimal markket_price) {
		this.markket_price = markket_price;
	}

	public BigDecimal getShow_price() {
		return show_price;
	}

	public void setShow_price(BigDecimal show_price) {
		this.show_price = show_price;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}