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
import com.wmeimob.yzfs.service.ReturnOrdersService;
import com.wmeimob.yzfs.vo.RightsOrdersVO;
import org.springframework.util.StringUtils;

/**
 * 售后订单管理模块
 *
 */
@Controller
@RequestMapping(value={"/admin/rights"})
public class ReturnOrdersController{
	
	@Autowired
	private ReturnOrdersService returnOrdersService;
	/**
	 * 查询所有退款订单
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView queryOrder(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("rights/return_orders_list");
		RightsOrdersVO params = new RightsOrdersVO();
		mv.addObject("params",params);//存储参数
		return mv;
	}
	
	
	/**
	 * 查询退款订单公共参数处理
	 * @param request
	 * @return
	 */
	public RightsOrdersVO getOrderPublicParams(HttpServletRequest request){
		RightsOrdersVO orderVO = new RightsOrdersVO();
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
    	  orderVO.setRightsOrderNo(orderNo.trim());
    	else
    	  orderVO.setRightsOrderNo("");
		Integer status=-1;//订单状态，默认全部
		//如果订单查询状态不为空
		if(!StringUtils.isEmpty(request.getParameter("status"))){
			status=Integer.parseInt(request.getParameter("status"));
		}
		orderVO.setRefundsStatus(status);
		//订单商品二级分类ID
    	String  classId=request.getParameter("classId");
    	//商品名称
    	String  goodName=request.getParameter("goodName");
    	if(!StringUtils.isEmpty(classId))
    		orderVO.setClassId(classId);
    	else
    		orderVO.setClassId("");
    	if(!StringUtils.isEmpty(goodName))
    		orderVO.setGoodName(goodName);
    	else
    		orderVO.setGoodName("");
		return orderVO;
		/*######参数处理结束######*/
	}
	
	
	 /**
     * 异步查询退款订单信息
     * @param request
     * @return
     */
    @RequestMapping("/patchList")
    public ModelAndView queryGoodsClassPatch(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
    	RightsOrdersVO params = new RightsOrdersVO();
		//参数处理
		params=getOrderPublicParams(request);
		List<RightsOrdersVO> ordersList=returnOrdersService.queryOrderListByParams(params);
		mv.addObject("ordersList", ordersList);//查询的订单列表信息
        mv.setViewName("rights/return_order_patch_list");
    	return mv;
    }
    
	/**
	 * 退款订单详情
	 * @return
	 */
	@RequestMapping("/details")
	public ModelAndView orderDetails(@RequestParam("id")String id){
		ModelAndView mv=new ModelAndView("rights/return_orders_detail");
		RightsOrdersVO params=returnOrdersService.selectByPrimaryKey(id);
		mv.addObject("order", params);
		return mv;
	}
	
	/**
	 * 审核退款
	 * @return
	 */
	@RequestMapping("/refund")
	@ResponseBody
	public Map<String,Object> refund(HttpServletRequest request,String itemId,Integer wqId,String sign) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map=returnOrdersService.refund(itemId,wqId,sign);
		} catch (Exception e) {
			map.put("code", 404);
			map.put("msg", "系统异常");
		}
		return map;
	}
    
	
}
