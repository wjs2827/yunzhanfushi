package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.model.Area;

public interface AreaMapper {
	
	/**
	 * 根据等级查询区域列表
	 * @param lv
	 * @return
	 */
	List<Area> selectByPrimaryKey(Area params);
	
	/**
	 * 查询省市区
	 * @return
	 */
	List<Area> queryAreaProvinceList();
	
}