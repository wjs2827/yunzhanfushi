package com.wmeimob.yzfs.vo;

import java.io.Serializable;

/**
 * 后台管理菜单VO
 */
public class MenuVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String url;

	private String parentId;

	private String description;

	private Boolean isDisable;

	private Integer sort;

	private Integer type;

	private Boolean isSelected;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Boolean isDisable) {
		this.isDisable = isDisable;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

}
