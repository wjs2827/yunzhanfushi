package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Orders;
public interface OrdersService {

	/**
	 * 查询订单列表信息
	 * 
	 * @return
	 */
	List<Orders> queryOrderListByParams(Orders params);
	
	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
    Orders selectByPrimaryKey(String id);
    
    /**
     * 修改订单信息
     * @param record
     * @return
     * @throws CustomException 
     */
    Map<String, Object> updateByPrimaryKeySelective(HttpServletRequest request) throws CustomException;
	
	
	
}
