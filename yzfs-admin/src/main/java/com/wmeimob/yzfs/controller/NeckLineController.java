/**
 * AdminController.java
 * @author: 杨洲
 * @date: 2016-7-22
 */
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

import com.wmeimob.yzfs.model.NecklineFabricType;
import com.wmeimob.yzfs.model.NecklineType;
import com.wmeimob.yzfs.service.NeckLineService;

@Controller
@RequestMapping("/admin/neck")
public class NeckLineController{
	@Autowired
	private NeckLineService neckLineService;
	
	/**
	 * 查询领口布料列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("neckline_patch/neck_list");
		return mv;
	}
	
	
	/**
	 * 新增或者编辑领口信息 
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertNecklineType")
	@ResponseBody
	public Map<String, Object> insertHomeCategory(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = neckLineService.insertNecklineType(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "操作成功,加载中...");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	
	/**
	 * 新增或者编辑布料信息信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertNecklineFabricType")
	@ResponseBody
	public Map<String, Object> insertNecklineFabricType(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = neckLineService.insertNecklineFabricType(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "操作成功,加载中...");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	/**
	 * 根据参数修改领口信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateNecklineTypeByParams")
	@ResponseBody
	public Map<String, Object> updateNecklineTypeByParams(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = neckLineService.updateNecklineTypeByParams(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "删除成功");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	/**
	 * 根据参数修改布料信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateNecklineFabricTypeByParams")
	@ResponseBody
	public Map<String, Object> updateNecklineFabricTypeByParams(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = neckLineService.updateNecklineFabricTypeByParams(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "删除成功");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	 /**
     * 查询领口信息列表
     * @param request
     * @return
     */
    @RequestMapping("/queryNecklineTypeList")
    public ModelAndView queryNecklineTypeList(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
    	NecklineType params = new NecklineType();
		List<NecklineType> neckLineList=neckLineService.queryNecklineTypeList(params);
		mv.addObject("neckLineList", neckLineList);
        mv.setViewName("neckline_patch/neckline_type_patch");
    	return mv;
    }
    
	 /**
     * 查询布料信息列表
     * @param request
     * @return
     */
    @RequestMapping("/queryNecklineFabricTypeList")
    public ModelAndView queryNecklineFabricTypeList(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
    	NecklineFabricType params = new NecklineFabricType();
		List<NecklineFabricType> neckLineFabricList=neckLineService.queryNecklineFabricTypeList(params);
		mv.addObject("neckLineList", neckLineFabricList);
		  mv.setViewName("neckline_patch/neckline_fabric_type_patch");
    	return mv;
    }
    
    
	 /**
     * 商品添加查询领口以及布料信息列表
     * @param request
     * @return
     */
    @RequestMapping("/queryNecklineInfoListToGood")
    public ModelAndView queryNecklineInfoListToGood(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
    	NecklineType params = new NecklineType();
		List<NecklineType> neckLineListFirst=neckLineService.queryNecklineTypeList(params);
		mv.addObject("neckLineListFirst", neckLineListFirst);
    	NecklineFabricType paramstwo = new NecklineFabricType();
		List<NecklineFabricType> neckLineListSecond=neckLineService.queryNecklineFabricTypeList(paramstwo);
		mv.addObject("neckLineListSecond", neckLineListSecond);
		mv.setViewName("ec_good/neckline_info_patch");
    	return mv;
    }
    
	/**
	 * 根据商品ID查询商品对应的私人定制SKU列表信息
	 * @param request
	 * @param spuId
	 * @param result
	 * @return
	 */
	@RequestMapping("/queryNeckSkuListBySpuId")
	@ResponseBody
	public Map<String,Object> queryNeckSkuListBySpuId(HttpServletRequest request,String spuId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map=neckLineService.queryNeckSkuListBySpuId(spuId);
		return map;
	}

}
