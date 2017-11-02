package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.EcGoodSku;

public interface EcGoodSkuMapper {
	
	/**
	 * 根据商品ID删除SKU规格属性
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(@Param("spuId")String id);
    
    /**
     * 批量新增SKU属性
     * @param record
     * @return
     */
    int insertBatch(@Param("list")List<EcGoodSku> list);
    
    /**
     * 单独新增SKU属性
     * @param record
     * @return
     */
    int insertSelective(EcGoodSku record);

    /**
     * 根据商品ID查询商品规格列表
     * @param id
     * @return
     */
    List<EcGoodSku> selectByPrimaryKey(@Param("spuId")String id);

    /**
     * 修改商品SKU规格
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EcGoodSku record);
    
    /**
     * 修改库存
     * @param record
     * @return
     */
    int updateBySkuStockByParams(EcGoodSku record);
    
    /**
     * 根据SKU编码以及商品ID查询商品SKU
     * @param id
     * @return
     */
    EcGoodSku queryGoodSkuBySkuCode(@Param("skuCode")String skuCode,@Param("spuId")String id);

}