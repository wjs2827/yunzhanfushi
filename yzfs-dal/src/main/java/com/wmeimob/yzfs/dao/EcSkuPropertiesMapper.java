package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.EcSkuProperties;

public interface EcSkuPropertiesMapper {
	
	/**
	 * 根据ID删除该SKU以及子sku属性
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增SKU 
     * @param record
     * @return
     */
    void insertSelective(EcSkuProperties record);

    /**
     * 根据分类ID查询SKU以及子规格
     * @param id
     * @return
     */
    List<EcSkuProperties> selectByPrimaryKey(@Param("categoryId") String categoryId);
}