package com.wmeimob.yzfs.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wmeimob.yzfs.model.EcNeckSku;

/**
 * 可改装商品SKU管理Mapper
 * @author WMM08
 *
 */

public interface EcNeckSkuMapper {
	
	/**
	 * 根据商品ID删除之前的SKU属性
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(String spuId);


    /**
     * 新增可改装SKU属性
     * @param record
     * @return
     */
    int insertSelective(EcNeckSku record);
    
    /**
     * 批量新增可改装SKU属性
     * @param record
     * @return
     */
    int insertBatch(@Param("list")List<EcNeckSku> list);

    /**
     * 根据参数查询列表
     * @param record
     * @return
     */
    List<EcNeckSku> selectByPrimaryKey(@Param("spuId")String id);

    /**
     * 根据参数修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EcNeckSku record);
    
    /**
     * 根据SKU编码以及商品ID查询可改装商品SKU
     * @param id
     * @return
     */
    EcNeckSku queryGoodNeckSkuBySkuCode(@Param("skuCode")String skuCode,@Param("spuId")String id);

}