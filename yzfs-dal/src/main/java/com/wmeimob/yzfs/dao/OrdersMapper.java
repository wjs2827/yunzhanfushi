package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.Orders;
import com.wmeimob.yzfs.vo.OrderStatusCount;

public interface OrdersMapper {
	/**
	 * 根据订单ID查询订单明细
	 * @param id
	 * @return
	 */
	Orders selectOrderItemsById(@Param("id")String id);
	
	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
    Orders selectByPrimaryKey(String id);
    
    
	/**
	 * 根据订单ID查看订单详情
	 * @param id
	 * @return
	 */
    Orders selectOrderItemByOrderIdFromWX(@Param("orderId")String orderId);
    
	/**
	 * 根据订单号查询订单信息
	 * @param id
	 * @return
	 */
    Orders queryOrderInfoByPayNo(@Param("payNo")String orderNo);
	/**
	 * 查询订单列表信息
	 * @param record
	 * @return
	 */
	List<Orders> queryOrderListByParams(Orders record);
	
	/**
	 * WX查询订单列表信息
	 * @param record
	 * @return
	 */
	List<Orders> queryOrderListByParamsFromWX(Orders record);
	
	/**
	 * 新增订单信息
	 * @param record
	 * @return
	 */
    int insertSelective(Orders record);

    /**
     * 修改订单信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Orders record);
    /**
     * 查询用户订单
     * @param orders
     * @return
     */
	List<Orders> selectOrderListByCondition(Orders orders);
	
	/**
	 * 统计各种状态订单数量
	 * @param userId
	 * @return
	 */
	OrderStatusCount queryOrderStatusCount(@Param("userId") String userId);
    
    

}