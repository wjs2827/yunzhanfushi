package com.wmeimob.yzfs.vo;
import java.util.List;

import com.wmeimob.yzfs.model.GoodsClass;

/**
 * 商品分类VO
 */
public class GoodClassListVO {
	
	private String paerntId;
	
	private String parentName;
	
	private List<GoodsClass> childClass;
	
	public String getPaerntId() {
		return paerntId;
	}
	public void setPaerntId(String paerntId) {
		this.paerntId = paerntId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<GoodsClass> getChildClass() {
		return childClass;
	}
	public void setChildClass(List<GoodsClass> childClass) {
		this.childClass = childClass;
	}
	
}
