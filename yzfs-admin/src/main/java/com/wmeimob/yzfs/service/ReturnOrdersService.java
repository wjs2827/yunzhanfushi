package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.vo.RightsOrdersVO;
public interface ReturnOrdersService {

	/**
	 * 查询维权订单列表信息
	 * 
	 * @return
	 */
	List<RightsOrdersVO> queryOrderListByParams(RightsOrdersVO params);
	
	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
	RightsOrdersVO selectByPrimaryKey(String id);
	
	/**
	 * 审核退款
	 * @param id
	 * @return
	 * @throws CustomException 
	 */
	Map<String,Object> refund(String itemId,Integer wqId,String sign) throws CustomException;
    
	
}
