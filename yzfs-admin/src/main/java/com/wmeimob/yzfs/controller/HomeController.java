package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.service.ClassifyService;
import com.wmeimob.yzfs.service.GoodsService;
import com.wmeimob.yzfs.service.HomeService;
import com.wmeimob.yzfs.vo.GoodsVO;
import com.wmeimob.yzfs.vo.HomeCategoryVO;


/**
 * 商城首页轮播和分类图片Controller
 */
@Controller
@RequestMapping("/admin/home")
public class HomeController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	public HomeService silderPicService;
	@Autowired
	public GoodsService goodsService;
    @Autowired
    private ClassifyService goodsclassService;

	/**
	 * 首页管理
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home_index/home_index");
		// 轮播图和分类导航图
		mv.addObject("silderPics", silderPicService.listSilderPics("-1"));
		log.info("===============/silder/index complete================");
		return mv;
	}
	
	
	/**
	 * 商城首页编辑赋值
	 * 
	 * @param id
	 * @param picKey
	 * @param targetType
	 * @param content
	 * @return
	 */
	@RequestMapping("/editFirstPage")
	@ResponseBody
	public Map<String, Object> editFirstPage(@RequestParam String pid) {
		//根据商品ID查询商品信息
		Goods goods = new Goods();
		goods.setId(pid);
		List<GoodsVO> goodsVos = goodsService.queryGoodsList(goods);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(goodsVos)&&goodsVos.size()>0){
			map.put("goodClass", goodsclassService.queryErjilistById(goodsVos.get(0).getClassesId()));
		}
		return map;
	}
	

	/**
	 * 商城首页编辑保存
	 * 
	 * @param id
	 * @param picKey
	 * @param targetType
	 * @param content
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Map<String, Object> edit(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String id =request.getParameter("id");
		String picType=request.getParameter("picType");
		String picKey =request.getParameter("picKey");
		System.out.println(request.getParameter("targetType"));
		int targetType=0;
		if(!StringUtils.isEmpty(request.getParameter("targetType")))
		  targetType=Integer.parseInt(request.getParameter("targetType"));
		String targetId=request.getParameter("targetId");
		String linkUrl =request.getParameter("linkUrl");
		Integer rank=0;
		if(!StringUtils.isEmpty(request.getParameter("rank")))
			rank=Integer.parseInt(request.getParameter("rank"));
		boolean picTypes=false;
		if(!StringUtils.isEmpty(picType)&&picType.equals("0"))
			picTypes=false;
		else
			picTypes=true;
		int result=0;
		if(!StringUtils.isEmpty(id)){
		    result = silderPicService.updateSilderPic(id, picKey, targetType, targetId,linkUrl,rank);
			if (result > 0) {
				map.put("code", "0");
				map.put("message", "编辑成功!");
			} else {
				map.put("code", "1");
				map.put("message", "编辑失败，请重试");
			}
		}else{
		    result = silderPicService.addSilderPic(picKey,picTypes, targetType, targetId,linkUrl,rank);
			if (result > 0) {
				map.put("code", "0");
				map.put("message", "新增成功!");
			} else {
				map.put("code", "1");
				map.put("message", "新增失败，请重试");
			}
		}
		log.info("===============/silder/edit================ count:" + result);
		return map;
	}
	
	
	/**
	 * 商城分类编辑赋值
	 * 
	 * @param id
	 * @param picKey
	 * @param targetType
	 * @param content
	 * @return
	 */
	@RequestMapping("/editFirstClass")
	@ResponseBody
	public Map<String, Object> editFirstClass(@RequestParam String pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodClass", goodsclassService.queryErjilistById(pid));
		return map;
	}

	/**
	 * 删除
	 * 
	 * @param picId
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(String picId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.deleteSilderPic(picId);
		log.info("===============/silder/delete================ count:" + result);
		if (result > 0) {
			map.put("code", "0");
		} else {
			map.put("code", "1");
			map.put("message", "删除失败，请重试");
		}
		return map;
	}

	/**
	 * 禁用
	 * 
	 * @param picId
	 * @return
	 */
	public Map<String, Object> disable(String picId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.disableSilderPic(picId);
		log.info("===============/silder/disable================ count:" + result);
		if (result > 0) {
			map.put("code", "0");
		} else {
			map.put("code", "1");
			map.put("message", "禁用失败，请重试");
		}
		return map;
	}
	
	
	//商城首页分类展示以及分类下的商品展示
	
	/**
	 * 根据一级或者二级分类查询所有的商品
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listGoodsByClassId")
	public  Map<String, Object>   listGoodsByClassId(@RequestParam String classId,String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods", goodsService.selectGoodListByCategoryId(classId,type));
		return  map;
	}
	
	/**
	 * 新增首页分类
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertHomeCategory")
	@ResponseBody
	public Map<String, Object> insertHomeCategory(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.insertHomeCategory(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "新增成功,加载中...");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	
	/**
	 * 新增首页分类商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertHomeCategoryProduct")
	@ResponseBody
	public Map<String, Object> insertHomeCategoryProduct(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.insertHomeCategoryProduct(request);
		if (result > 0) {
			map.put("code", "100");
			map.put("msg", "新增成功,加载中...");
		}else{
			map.put("code", "200");
			map.put("msg", "网络异常,请稍后重试!");
		}
		return map;
	}
	
	/**
	 * 根据分类ID移除
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateCategoryById")
	@ResponseBody
	public Map<String, Object> updateCategoryById(HttpServletRequest request,String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.updateCategoryById(id);
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
	 * 根据分类商品ID移除商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteHomeCategoryProduct")
	@ResponseBody
	public Map<String, Object> deleteHomeCategoryProduct(HttpServletRequest request,String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = silderPicService.deleteHomeCategoryProduct(id);
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
     * 异步查询首页分类以及商品展示
     * @param request
     * @return
     */
    @RequestMapping("/queryHomeCategoryPatch")
    public ModelAndView queryHomeCategoryPatch(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
		//首页分类展示
		List<HomeCategoryVO> homeCateList=silderPicService.selectHomeCategory();
		mv.addObject("homeCate", homeCateList);
        mv.setViewName("home_index/home_category_patch");
    	return mv;
    }
}
