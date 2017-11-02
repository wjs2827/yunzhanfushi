package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.ExpressTempArea;

public interface ExpressTempAreaMapper {
	
	/**
	 * 批量新增运费模板区域信息
	 * @param list
	 * @return
	 */
	int insertBatch(@Param("list")List<ExpressTempArea> list);
	
	/**
	 * 根据运费详情ID删除运费下的区域列表
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(@Param("id")Integer id);
    
    /**
     * 根据区域ID查询区域信息
     * @param id
     * @return
     */
    ExpressTempArea selectByPrimaryKey(Integer id);

}