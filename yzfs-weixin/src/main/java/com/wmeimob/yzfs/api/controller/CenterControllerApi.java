package com.wmeimob.yzfs.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.CenterServiceApi;
import com.wmeimob.yzfs.exception.CustomException;

@RestController
@RequestMapping("/center/api")
@CrossOrigin
@Transactional
public class CenterControllerApi {

	@Autowired
	private CenterServiceApi centerServiceApi;

	/**
	 * 我的个人中心
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myCenter", method = RequestMethod.GET)
	public JSONObject settlement(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.myCenter(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 充值
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public JSONObject recharge(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.recharge(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的订单列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ordreList", method = RequestMethod.POST)
	public JSONObject ordreList(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.ordreList(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 根据订单ID查询我的订单详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderItemById", method = RequestMethod.GET)
	public JSONObject orderItemById(HttpServletRequest request, String orderId) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.orderItemById(request, orderId);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的售后列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/rightsOrdreList", method = RequestMethod.POST)
	public JSONObject rightsOrdreList(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.rightsOrdreList(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 根据订单ID查询我的售后订单详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/rightsOrderItemById", method = RequestMethod.GET)
	public JSONObject RightsOrderItemById(HttpServletRequest request, String id) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.rightsOrderItemById(request, id);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的佣金
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myCommission", method = RequestMethod.GET)
	public JSONObject myCommission(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.myCommission(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的佣金记录列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myCommissionRecord", method = RequestMethod.POST)
	public JSONObject myCommissionRecord(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.myCommissionRecord(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的余额记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myBalaceRecord", method = RequestMethod.POST)
	public JSONObject myBalaceRecord(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.myBalaceRecord(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 我的T金记录列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/myCardLogRecord", method = RequestMethod.POST)
	public JSONObject myCardLogRecord(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.myCardLogRecord(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 提现
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/withdrawals", method = RequestMethod.POST)
	public JSONObject withdrawals(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.withdrawals(request);
			data.put("code", 100);
			data.put("message", "test ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 获取我的二维码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMyQRCode", method = RequestMethod.GET)
	public JSONObject getMyQRCode(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.getMyQRCode(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 获取我的余额
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMyAccount", method = RequestMethod.GET)
	public JSONObject getMyAccount(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = centerServiceApi.getMyAccount(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
