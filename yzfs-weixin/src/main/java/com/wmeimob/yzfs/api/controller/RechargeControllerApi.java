package com.wmeimob.yzfs.api.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.RechargeServiceApi;
import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.util.GeneratorSnUtil;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;

@RestController
@RequestMapping("/recharge/api")
@CrossOrigin
public class RechargeControllerApi extends BaseController {
	
	@Autowired
	private RechargeServiceApi rechargeService;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	/**
	 * 充值
	 * @param request
	 * @param rechargeId
	 * @param promoterCode
	 * @return
	 */
	@RequestMapping(value="/saveRecharge",method = RequestMethod.POST)
	public JSONObject rechargeTest(HttpServletRequest request,String rechargeId) {
		JSONObject data = new JSONObject();
	    //第一步：根据套餐类型ID查询该套餐是否可用
		if (StringUtils.isBlank(rechargeId)) {
			String xmlString = HttpUtil.requestGetBody(request);
			if(StringUtils.isEmpty(xmlString)){
				data.put("code", 200);
				data.put("msg", "error");
				return data;
			}
			Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
			rechargeId=maps.get("rechargeId")+"";//商品ID
			if (StringUtils.isBlank(rechargeId)) {
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "rechargeId is not exist!");
				return data;
			}
		}
		//锁变量
		String snCode=GeneratorSnUtil.generatorSn("CZ");//支付流水号
		try {
			data = rechargeService.membership_Management(rechargeId,snCode,request);
		} catch (CustomException e) {
			data.put("code", 403);
			data.put("data", "data is null");
			data.put("message", "user is not exist!");
			return data;
		}
		if ("success".equals(data.get("msg"))) {
			//统一下单
		}
		return data;
	
	}
	
	
}
