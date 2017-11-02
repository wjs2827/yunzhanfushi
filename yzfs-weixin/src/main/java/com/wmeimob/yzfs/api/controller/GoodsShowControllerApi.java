package com.wmeimob.yzfs.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.GoodsShowServiceApi;
import com.wmeimob.yzfs.exception.CustomException;

@Controller
@RequestMapping("/goodsShow/api")
@CrossOrigin
@Transactional
public class GoodsShowControllerApi {

	@Autowired
	private GoodsShowServiceApi goodsShowServiceApi;

	/**
	 * 买家秀列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getGoodsShowList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getGoodsShowList(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = goodsShowServiceApi.getGoodsShowList(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 已完成订单列表（未发布买家秀的）
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOrderItemList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getOrderItemList(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = goodsShowServiceApi.getOrderItemList(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 发布买家秀
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addGoodsShow", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addGoodsShow(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = goodsShowServiceApi.addGoodsShow(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 买家秀详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getGoodsShowDetail", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getGoodsShowDetail(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = goodsShowServiceApi.getGoodsShowDetail(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 买家秀点赞
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/thumbsGoodsShow", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject thumbsGoodsShow(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		try {
			data = goodsShowServiceApi.thumbsGoodsShow(request);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		return data;
	}
}
