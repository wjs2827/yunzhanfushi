package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.RightsOrders;
import com.wmeimob.yzfs.vo.RightsOrdersVO;

public interface RightsOrdersMapper {
	
	/**
	 * 新增维权订单信息
	 * @param record
	 * @return
	 */
    void insertSelective(RightsOrders record);
    
    /**
     * 根据参数查询维权订单列表
     * @param record
     * @return
     */
    List<RightsOrdersVO> selectByPrimaryKey(RightsOrders record);
    
    
    /**
     * 根据参数查询维权订单列表
     * @param record
     * @return
     */
    List<RightsOrdersVO> queryRightsOrderList(RightsOrdersVO record);
    
    /**
     * 根据维权ID查询维权信息
     * @param id
     * @return
     */
    RightsOrdersVO selectByPrimaryKeyById(@Param("ID") String id); 
    
    /**
     * 根据订单项查询维权信息
     * @param id
     * @return
     */
    RightsOrders selectByOrderItemId(@Param("ID") String id); 

    /**
     * 根据参数修改维权信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RightsOrders record);

}