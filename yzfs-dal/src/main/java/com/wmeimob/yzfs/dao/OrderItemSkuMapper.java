package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.OrderItemSku;

public interface OrderItemSkuMapper {
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItemSku record);

    void insertSelective(OrderItemSku record);

    /**
     * 根据多ID查询SKU信息
     * @param id
     * @return
     */
    List<OrderItemSku> selectByPrimaryKey(List<Integer> list);
    
    OrderItemSku queryGoodSkuCodeExist(@Param("skuCode") String skuCode,@Param("spuId") String spuId);

    int updateByPrimaryKeySelective(OrderItemSku record);

    int updateByPrimaryKey(OrderItemSku record);
    
	/**
	 * 根据购物车ID删除购物车商品信息
	 * @param list
	 * @return
	 */
	int deleteSkuCodeByItemId(List<String>  list);
	
	/**
	 * 根据购物车ID删除购物车商品信息
	 * @param list
	 * @return
	 */
	int deleteNeckSkuCodeByItemId(List<String>  list);
}