package com.wmeimob.yzfs.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.OrdersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Orders;
import com.wmeimob.yzfs.service.OrdersService;

@Service
@Transactional(rollbackFor=Exception.class) 
public class OrdersServiceImpl implements OrdersService{
	
	private Logger log = Logger.getLogger(OrdersServiceImpl.class);
	@Autowired
	private OrdersMapper ordersMapper;
	
	/**
	 * 查询订单列表信息
	 */
	@Override
	public List<Orders> queryOrderListByParams(Orders params) {
		log.debug("查询订单信息");
		return ordersMapper.queryOrderListByParams(params);
	}

	/**
	 * 订单详情
	 */
	@Override
	public Orders selectByPrimaryKey(String id) {
		return ordersMapper.selectOrderItemsById(id);
	}

	/**
	 * 修改订单信息
	 */
	@Override
	public Map<String, Object> updateByPrimaryKeySelective(HttpServletRequest request) throws CustomException {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			Orders params = new Orders();
			params=getPublicParams(request);
			params.setOrderStatus(2);
			if(StringUtils.isEmpty(params.getId())){
				map.put("code", 200);
				map.put("msg", "参数不合法");
			}
			if(StringUtils.isEmpty(params.getShippingVendor())){
				map.put("code", 200);
				map.put("msg", "参数不合法");
			}
			if(StringUtils.isEmpty(params.getShippingNo())){
				map.put("code", 200);
				map.put("msg", "参数不合法");
			}
			if (ordersMapper.updateByPrimaryKeySelective(params) > 0) {
				map.put("code", 100);
				map.put("msg", "操作成功!");
			} else {
				map.put("code", 200);
				map.put("msg", "操作失败!");
			} 
		} catch (Exception e) {
			throw new CustomException(200,"网络异常，请稍后...");
		}
		return  map;
	}
	
	/**
	 * 发货公共参数获取
	 * @param request
	 * @return
	 */
	public Orders getPublicParams(HttpServletRequest request){
		Orders params = new Orders();
		String id= request.getParameter("id");//订单ID
		String company=request.getParameter("company");//快递公司
		String companyNum=request.getParameter("companyNum");//快递单号
		String shippingNote=request.getParameter("shippingNote");//备注
		params.setId(id);
		params.setShippingVendor(company);
		params.setShippingNo(companyNum);
		params.setShippingNote(shippingNote);
		return params;
	}
	

}
