package com.wmeimob.yzfs.model;
import java.util.Date;
import java.util.List;

import com.wmeimob.yzfs.vo.HomeCategoryProductVO;


public class HomeCategory {
	
    private String id;//首页分类ID
    
    private String homeCategoryId;

    private String categoryId;//商品分类
    
    private String cateGoryName;//分类名称
    
    private String picKey;//分类图标

    private Integer type;//类型  1 一级分类  2 二级分类  3 三级分类

    private Date createdAt;

    private Date updatedAt;
    
    private Boolean isDeleted;//是否删除

    private Boolean isUse;//是否启用 

    private Integer rank;//排序
    
    private List<HomeCategoryProductVO> homeCategoryProductVo;//首页分类下的商品集合
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Boolean getIsUse() {
        return isUse;
    }

    public void setIsUse(Boolean isUse) {
        this.isUse = isUse;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

	public List<HomeCategoryProductVO> getHomeCategoryProductVo() {
		return homeCategoryProductVo;
	}

	public void setHomeCategoryProductVo(List<HomeCategoryProductVO> homeCategoryProductVo) {
		this.homeCategoryProductVo = homeCategoryProductVo;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public String getCateGoryName() {
		return cateGoryName;
	}

	public void setCateGoryName(String cateGoryName) {
		this.cateGoryName = cateGoryName;
	}

	public String getHomeCategoryId() {
		return homeCategoryId;
	}

	public void setHomeCategoryId(String homeCategoryId) {
		this.homeCategoryId = homeCategoryId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}