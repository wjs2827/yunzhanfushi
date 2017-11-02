package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.EcSkuProperties;
import com.wmeimob.yzfs.service.SkuService;

/**
 * WJS
 * @Date 2016/7/27 11:43
 */
@Controller
@RequestMapping("/admin/sku")
public class SkuController{


	@Autowired
	private SkuService skuService;
	
	
	
	
	/**
	 * 根据分类ID查询SKU以及子规格
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView queryGoodsList(HttpServletRequest request,@Param("classId") String classId,String id){
		ModelAndView mv = new ModelAndView("ec_good/sku_list");
		List<EcSkuProperties> skuList=skuService.selectByPrimaryKey(classId);
		request.setAttribute("skuList", skuList);
		request.setAttribute("spuId", id);
		return mv;
	}
	
	
	/**
	 * 异步新增商品SKU属性以及属性值
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addSkuInfo")
	@ResponseBody
	public Map<String,Object> addSkuInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = skuService.addSkuInfo(request);
		} catch (Exception e) {
			map.put("code", 200);
			map.put("msg", "系统异常!");
		}
		return map;
	}
	
	/**
	 * 异步编辑商品SKU子规格属性值
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editSkuInfo")
	@ResponseBody
	public Map<String,Object> editSkuInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = skuService.editSkuInfo(request);
		} catch (Exception e) {
			map.put("code", 200);
			map.put("msg", "系统异常!");
		}
		return map;
	}
	
	
	/**
	 * 异步删除商品SKU属性以及属性值
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delSkuInfo")
	@ResponseBody
	public Map<String,Object> delSkuInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = skuService.delSkuInfo(request);
		} catch (Exception e) {
			map.put("code", 200);
			map.put("msg", "系统异常!");
		}
		return map;
	}
	
	
}
