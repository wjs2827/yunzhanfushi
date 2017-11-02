package com.wmeimob.yzfs.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.OrderServiceApi;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.util.GeneratorSnUtil;

@RestController
@RequestMapping("/order/api")
@CrossOrigin
@Transactional
public class OrderControllerApi {

	@Autowired
	private OrderServiceApi orderServiceApi;

	/**
	 * 去结算
	 * 
	 * @param request
	 * @param itemId
	 *            购物车商品明细ID列表
	 * @return
	 */
	@RequestMapping(value = "/settlement", method = RequestMethod.POST)
	public JSONObject settlement(HttpServletRequest request, String itemId) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.settlement(request, itemId);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 立即购买
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/buyNow", method = RequestMethod.POST)
	public JSONObject byNow(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.buyNow(request);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 提交订单
	 * 
	 * @param request
	 * @param itemId
	 *            购物车商品明细ID列表
	 * @return
	 */
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public JSONObject saveOrder(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		// 锁变量
		String snCode = GeneratorSnUtil.generatorSn("ZF");// 支付流水号
		try {
			data = orderServiceApi.saveOrder(request, snCode);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("payNo", "");
			data.put("payMethod", "");
			data.put("message", "error");
		}
		return data;
	}

	/**
	 * 根据订单ID支付未支付的订单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goPay", method = RequestMethod.POST)
	public JSONObject goPay(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		// 锁变量
		String snCode = GeneratorSnUtil.generatorSn("ZF");// 支付流水号
		try {
			data = orderServiceApi.goPay(request, snCode);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("payNo", "");
			data.put("payMethod", "");
			data.put("message", "error");
		}
		return data;
	}

	/**
	 * 取消订单(退库存)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cancleOrder", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject cancleOrder(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		// 锁变量
		String snCode = GeneratorSnUtil.generatorSn("ZF");// 支付流水号
		try {
			data = orderServiceApi.cancleOrder(request, snCode);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 删除订单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/removeOrder", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject removeOrder(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		// 锁变量
		String snCode = GeneratorSnUtil.generatorSn("ZF");// 支付流水号
		try {
			data = orderServiceApi.removeOrder(request, snCode);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 根据订单详情ID查询商品信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryOrderItemInfoById", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryOrderItemInfoById(HttpServletRequest request, String itemId) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.queryOrderItemInfoById(request, itemId);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 确认收货
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/confirmReceipt", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject confirmReceipt(HttpServletRequest request, String orderId) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.confirmReceipt(request, orderId);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;
	}

	/**
	 * 退换货申请
	 * 
	 * @param request
	 * @param snCode
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "/applyReturnOrder", method = RequestMethod.POST)
	public JSONObject applyReturnOrder(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		// 锁变量
		String snCode = GeneratorSnUtil.generatorSn("WQ");// 支付流水号
		try {
			data = orderServiceApi.applyReturnOrder(request, snCode);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", e.getMessage());
			data.put("message", "error!");
			return data;
		}
		return data;

	}

	/**
	 * 去评论
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goCommentByOrderId", method = RequestMethod.GET)
	public JSONObject goCommentByOrderId(HttpServletRequest request, String orderId) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.goCommentByOrderId(request, orderId);
		} catch (Exception e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("payNo", "");
			data.put("payMethod", "");
			data.put("message", "error");
		}
		return data;
	}

	/**
	 * 提交评论保存
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveCommentInfo", method = RequestMethod.POST)
	public JSONObject saveCommentInfo(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = orderServiceApi.saveCommentInfo(request);
		} catch (Exception e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("payNo", "");
			data.put("payMethod", "");
			data.put("message", "error");
		}
		return data;
	}

}
