package com.wmeimob.yzfs.model;

import java.util.Date;
import java.util.List;

public class GoodsClass {
    private String id;

    private String name;

    private String picKey;

    private Integer rank;

    private String parentId;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    private Boolean judge;
    
    private Integer pageSize;//每页显示条数
    
    private Integer pageIndex;//页数
    
    private Integer totalCount;//总页数
    
    private List<GoodsClass> secondCategoryList;//二级分类

    public List<GoodsClass> getSecondCategoryList() {
		return secondCategoryList;
	}

	public void setSecondCategoryList(List<GoodsClass> secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}

	public Boolean getJudge() {
        return judge;
    }

    public void setJudge(Boolean judge) {
        this.judge = judge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicKey() {
        return picKey;
    }

    public void setPicKey(String picKey) {
        this.picKey = picKey == null ? null : picKey.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
    
}