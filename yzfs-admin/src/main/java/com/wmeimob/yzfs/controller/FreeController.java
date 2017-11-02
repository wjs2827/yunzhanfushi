package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Area;
import com.wmeimob.yzfs.model.ExpressTempDetails;
import com.wmeimob.yzfs.model.ExpressTemplate;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.service.ConfigService;
import com.wmeimob.yzfs.service.FreeService;
import com.wmeimob.yzfs.vo.SysConfigsVO;



@Controller
@RequestMapping("/admin/free")
public class FreeController extends BaseController {

	@Autowired
	private FreeService freeService;
	@Autowired
	private ConfigService configService;
	
	
	/**
	 * 运费模板主页面
	 * @return
	 */
	@RequestMapping("/freeList")
	public ModelAndView freeList() {
		ModelAndView mv = new ModelAndView("shippingfree/free_list");
		ExpressTemplate params=new ExpressTemplate();
		params.setId(100000);
		params=freeService.selectTemplateByPrimaryKey(params);
		mv.addObject("params",params);
    	SysConfigs paramss = new SysConfigs();
    	paramss.setType(1);
		List<SysConfigsVO> readList=configService.queryListByParams(paramss);
		mv.addObject("readList", readList);
		return mv;
	}
	
	
	
	/**
	 * 运费模板主页面
	 * @return
	 */
	@RequestMapping("/batchfreeList")
	public ModelAndView batchfreeList() {
		ModelAndView mv = new ModelAndView("shippingfree/batch_free_list");
		ExpressTempDetails params=new ExpressTempDetails();
		params.setId(100000);
		List<ExpressTempDetails> paramsList=freeService.selectByPrimaryKeyList(params);
		mv.addObject("paramsList",paramsList);
		return mv;
	}
	
	/**
	 * 省份列表
	 * @return
	 */
	@RequestMapping("/pList")
	@ResponseBody
	public Map<String,Object> pList(HttpServletRequest request,Integer lv,Integer pid) {
		Map<String,Object> map = new HashMap<String,Object>();
		Area params = new Area();
		params.setLv(lv);
		params.setPid(pid);
		List<Area> list =freeService.selectByPrimaryKey(params);
		map.put("list",list);
		return map;
	}
	
	/**
	 * 保存运费模板信息
	 * @param request
	 * @param temp
	 * @return
	 */
	@RequestMapping(value = "/saveTemp")
	@ResponseBody
	public Map<String,Object>  saveTemp(HttpServletRequest request,ExpressTemplate temp) {
		Map<String,Object>  result =new HashMap<String,Object> ();
		try {
			result=freeService.saveTemp(request,temp);
		} catch (CustomException e) {
			result.put("code", 200);
			result.put("msg", "系统异常");
		}
		return result;
	}
	
	
}
