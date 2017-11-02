package com.wmeimob.yzfs.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.RechargeRules;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.service.ConfigService;
import com.wmeimob.yzfs.vo.SysConfigsVO;



/**
 *   参数配置Controller
 */
@Controller
@RequestMapping("/admin/config")
public class ConfigController{


	@Autowired
	private ConfigService configService;
	
	/**
	 * 参数设置页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("sysconfig/config_list");
		return mv;
	}
	
	
	/**
	 * 异步查询充值规则
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchConfigRecharge")
	public ModelAndView batchConfigRecharge(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("sysconfig/batch_config_recharge");
		RechargeRules params = new RechargeRules();
		List<RechargeRules> rechargeList=configService.queryRechargeRuleList(params);
		mv.addObject("rechargeList", rechargeList);
		return mv;
	}
	
	/**
	 * 编辑充值规则
	 * @param request
	 * @return
	 */
	@RequestMapping("/editConfigRecharge")
	@ResponseBody
	public Map<String, Object> editConfigRecharge(HttpServletRequest request) {
		return configService.editConfigRecharge(request);
	}
	
	/**
	 * 删除或者启用停用充值规则
	 * @param request
	 * @return
	 */
	@RequestMapping("/delConfigRecharge")
	@ResponseBody
	public Map<String, Object> delConfigRecharge(HttpServletRequest request) {
		return configService.delConfigRecharge(request);
	}
	
	/**
	 * 异步查询金币设置规则
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchConfigSysConfig")
	public ModelAndView batchConfigSysConfig(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("sysconfig/batch_config_sysconfig");
    	SysConfigs params = new SysConfigs();
		List<SysConfigsVO> readList=configService.queryListByParams(params);
		mv.addObject("readList", readList);
		return mv;
	}
	
	
	
	/**
	 * 编辑参数设置信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/editReadListByParams")
	@ResponseBody
	public Map<String, Object> editReadListByParams(HttpServletRequest request) {
		return configService.updateByPrimaryKeySelective(request);
	}

	
}
