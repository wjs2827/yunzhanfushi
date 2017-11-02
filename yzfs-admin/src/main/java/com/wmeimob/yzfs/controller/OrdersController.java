package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Orders;
import com.wmeimob.yzfs.service.OrdersService;
import org.springframework.util.StringUtils;

/**
 * 订单管理模块
 *
 */
@Controller
@RequestMapping(value={"/admin/orders"})
public class OrdersController{
	
	@Autowired
	private OrdersService ordersService;
	/**
	 * 查询所有订单
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView queryOrder(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("orders/orders_list");
		Orders params = new Orders();
		mv.addObject("params",params);//存储参数
		return mv;
	}
	
	
	/**
	 * 查询订单公共参数处理
	 * @param request
	 * @return
	 */
	public Orders getOrderPublicParams(HttpServletRequest request){
		Orders orderVO = new Orders();
		/*######分页处理开始######*/
		String pageIndex = request.getParameter("pageIndex");
    	String pageSize = request.getParameter("pageSize");
    	//如果每页显示行数为空，则默认为30条
    	if(StringUtils.isEmpty(pageSize))
    		pageSize="15";
    	if(StringUtils.isEmpty(pageIndex))
    		pageIndex="1";
    	orderVO.setPageSize(Integer.parseInt(pageSize));
    	orderVO.setPageIndex((Integer.parseInt(pageIndex)-1)*orderVO.getPageSize());//从第一页开始查询，每页30条
    	/*######分页处理结束######*/
    	/*######参数处理开始######*/
    	//订单开始时间
    	if(!StringUtils.isEmpty(request.getParameter("startTime")))
    	  orderVO.setStartTime(request.getParameter("startTime"));
    	else
    	  orderVO.setStartTime(null);
    	//订单结束时间
    	if(!StringUtils.isEmpty(request.getParameter("endTime")))
      	  orderVO.setEndTime(request.getParameter("endTime"));
      	else
      	  orderVO.setEndTime(null);
    	//订单号
    	String orderNo=request.getParameter("orderNo");
    	if(!StringUtils.isEmpty(orderNo))
    	  orderVO.setOrderNo(orderNo.trim());
    	else
    	  orderVO.setOrderNo("");
    	//快递单号
    	String shippingNo=request.getParameter("shippingNo");
    	if(!StringUtils.isEmpty(shippingNo))
      	  orderVO.setShippingNo(shippingNo.trim());
      	else
      	  orderVO.setShippingNo("");
		Integer status=-1;//订单状态，默认全部
		//如果订单查询状态不为空
		if(!StringUtils.isEmpty(request.getParameter("status"))){
			status=Integer.parseInt(request.getParameter("status"));
		}
		orderVO.setOrderStatus(status);
		//订单商品二级分类ID
    	String  classId=request.getParameter("classId");
    	//下单人
    	String  loginName=request.getParameter("loginName");
    	//收货人
    	String  shippingName=request.getParameter("shippingName");
    	//商品名称
    	String  goodName=request.getParameter("goodName");
    	if(!StringUtils.isEmpty(classId))
    		orderVO.setClassId(classId);
    	else
    		orderVO.setClassId("");
    	if(!StringUtils.isEmpty(loginName))
    		orderVO.setNickName(loginName);
    	else
    		orderVO.setNickName("");
    	if(!StringUtils.isEmpty(shippingName))
    		orderVO.setShippingName(shippingName);
    	else
    		orderVO.setShippingName("");
    	if(!StringUtils.isEmpty(goodName))
    		orderVO.setGoodName(goodName);
    	else
    		orderVO.setGoodName("");
		return orderVO;
		/*######参数处理结束######*/
	}
	
	
	 /**
     * 异步查询订单信息
     * @param request
     * @return
     */
    @RequestMapping("/patchList")
    public ModelAndView queryGoodsClassPatch(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
		Orders params = new Orders();
		//参数处理
		params=getOrderPublicParams(request);
		params.setRefundsStatus(0);
		List<Orders> ordersList=ordersService.queryOrderListByParams(params);
		mv.addObject("ordersList", ordersList);//查询的订单列表信息
		mv.addObject("params", params);//参数信息
        mv.setViewName("orders/order_patch_list");
    	return mv;
    }
    
	/**
	 * 订单详情
	 * @return
	 */
	@RequestMapping("/details")
	public ModelAndView orderDetails(@RequestParam("id")String id){
		ModelAndView mv=new ModelAndView("orders/orders_detail");
		Orders order=ordersService.selectByPrimaryKey(id);
		mv.addObject("order", order);
		return mv;
	}
    
    
	/**
	 * 发货
	*/
	@RequestMapping("/deliver")
	@ResponseBody
	public Map<String, Object> orderDeliver(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			map=ordersService.updateByPrimaryKeySelective(request);
		} catch (CustomException e) {
			map.put("code", e.getCode());
			map.put("msg", e.getMsg());
		}
		return map;
	}
	

	
	
}
