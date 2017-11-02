package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.EcSkuPropertiesItem;

public interface EcSkuPropertiesItemMapper {
	
	/**
	 * 根据ID删除属性 
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKeyById(Integer id);
    
    /**
     * 根据父级ID删除属性
     * @param id
     * @return
     */
    int deleteByPrimaryKeyByParentId(Integer id);
    
    /**
     * 根据父级ID以及传入的子ID删除属性
     * @param id
     * @return
     */
    int deleteByPrimaryBatch(List<String> list);

    /**
     * 根据参数新增SKU属性值 
     * @param record
     * @return
     */
    int insertSelective(EcSkuPropertiesItem record);
    
    /**
     * 批量新增可改装SKU属性
     * @param record
     * @return
     */
    int insertBatch(@Param("list")List<EcSkuPropertiesItem> list);
    
    /**
     * 根据父级ID查询SKU属性值 
     * @param id
     * @return
     */
    List<String> selectByPrimaryKeyList(@Param("ecSkuPropertiesId")Integer ecSkuPropertiesId);
    
    /**
     * 根据父级ID查询SKU属性值 
     * @param id
     * @return
     */
    List<EcSkuPropertiesItem> selectByPrimaryKey(EcSkuPropertiesItem params);

}