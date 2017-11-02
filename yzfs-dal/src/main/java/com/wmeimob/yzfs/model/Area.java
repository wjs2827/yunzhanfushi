package com.wmeimob.yzfs.model;

import java.util.Date;
import java.util.List;

public class Area {
	
	
    private Integer id;//区域ID

    private Integer pid;//父级ID

    private String name;//区域名称

    private Integer lv;//级别

    private Date createdAt;

    private Date updatedAt;
    
    private List<Area> cityList;//城市列表
    
    private List<Area> districtList;//区域列表

    public List<Area> getCityList() {
		return cityList;
	}

	public void setCityList(List<Area> cityList) {
		this.cityList = cityList;
	}

	public List<Area> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<Area> districtList) {
		this.districtList = districtList;
	}

	private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
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