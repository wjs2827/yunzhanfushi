package com.wmeimob.yzfs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.OrderItems;

public interface OrderItemsMapper {
	
	/**
	 * 根据参数查询订单明细信息
	 * @param record
	 * @return
	 */
	List<OrderItems> selectOrderItemsByContainerId(OrderItems record);
	
	/**
	 *根据购物车ID查询购物车列表
	 * @param record
	 * @return
	 */
	List<OrderItems> selectCartListByCartIdFromWX(OrderItems record);
	
	/**
	 * WX根据订单ID查询订单详情列表
	 * @param record
	 * @return
	 */
	List<OrderItems> selectCartListByOrderIdFromWX(@Param("containerId") String orderId);
	
	/**
	 * 新增订单详情
	 * @param record
	 * @return
	 */
    int insertSelective(OrderItems record);


    /**
     * 修改订单详情
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderItems record);
    /***
     * 增加订单详情
     * @param orderItemsList
     * @return
     */
	int insertSelectiveByList(List<OrderItems> orderItemsList);
	
	/**
	 * WX查找某商品是否在购物车中
	 * @param orderItems
	 * @return
	 */
	OrderItems selectByOrderItemsByGoodId(OrderItems orderItems);
	
	/**
	 * WX根据商品详情ID查询购物车商品
	 * @param orderItems
	 * @return
	 */
	OrderItems selectOrderItemByIdFromWX(OrderItems orderItems);
	
	/**
	 * 根据订单ID查询订单明细信息
	 * @param id
	 * @return
	 */
	OrderItems selectOrderItemsById(@Param("id") String id);
	
	
	/**
	 * WX根据购物车已经 选中的商品ID查询
	 * @param list
	 * @return
	 */
	List<OrderItems> queryCartGoodListByIdList(List<String>   list);
	
	/**
	 * WX根据购物车ID查询购物车当前数量
	 * @param list
	 * @return
	 */
	List<OrderItems> queryCartNumber(@Param("cartId") String id);
	
	
	/**
	 * 根据购物车ID删除购物车商品信息
	 * @param list
	 * @return
	 */
	int deleteCartByItemId(List<String>  list);
	
	
	/**
	 * 根据购物车ID将购物车商品信息变更为订单详情信息
	 * @param list
	 * @return
	 */
	int updateCartToOrderItemByListId(Map<String,Object> map);

}