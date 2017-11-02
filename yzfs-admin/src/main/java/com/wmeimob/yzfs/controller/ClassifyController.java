package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.service.ClassifyService;
import com.wmeimob.yzfs.service.GoodsService;
import com.wmeimob.yzfs.vo.GoodsClassVO;
import com.wmeimob.yzfs.vo.ResultVO;

/**
 * 分类管理
 *
 * @Date 2016/7/29 11:17
 */
@Controller
@RequestMapping("/admin/classes")
public class ClassifyController{
	private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private ClassifyService GoodsClassService;
    @Autowired
    private GoodsService goodsService;
    

    /**
     * 查询商品分类
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView queryGoodsList(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
        GoodsClass GoodsClass = new GoodsClass();
    	String pageSize = request.getParameter("pageSize");
    	if(StringUtils.isEmpty(pageSize)){
    		pageSize="30";
    		mv.addObject("pageSize",30);
    	}else{
    		mv.addObject("pageSize",pageSize);
    	}
        GoodsClass.setPageSize(Integer.parseInt(pageSize));
        GoodsClass.setPageIndex(0);
        GoodsClass.setJudge(true);
        List<GoodsClassVO> classVos = GoodsClassService.queryGoodsClassList(GoodsClass);
        GoodsClass = GoodsClassService.queryGoodsCount(GoodsClass);
        mv.addObject("totalCount", GoodsClass.getTotalCount());
        mv.addObject("classVo", classVos);
        mv.setViewName("classify/class_list");
        mv.addObject("pageUrl", "/admin/classes/list");
        return mv;
    }
    
    /**
     * 异步查询分类信息
     * @param request
     * @return
     */
    @RequestMapping("/list/patch")
    public ModelAndView queryGoodsClassPatch(HttpServletRequest request){
    	String pageIndex = request.getParameter("pageIndex");
    	String pageSize = request.getParameter("pageSize");
    	String isSubClass = request.getParameter("issubclass");
    	String parentId = request.getParameter("parentId");
    	ModelAndView mv = new ModelAndView();
    	GoodsClass GoodsClass = new GoodsClass();
    	if(StringUtils.isEmpty(pageSize)){
    		pageSize="30";
    		mv.addObject("pageSize",30);
    	}else{
    		mv.addObject("pageSize",pageSize);
    	}
    	GoodsClass.setPageSize(Integer.parseInt(pageSize));
    	if(StringUtils.isEmpty(pageIndex)){
    		pageIndex="0";
    		mv.addObject("pageIndex",0);
    		GoodsClass.setPageIndex(0);
    	}else{
    		mv.addObject("pageIndex",pageIndex);
    		GoodsClass.setPageIndex((Integer.parseInt(pageIndex)-1)*GoodsClass.getPageSize());
    	}
    	if(!StringUtils.isEmpty(parentId)){
    		GoodsClass.setParentId(parentId);
    		GoodsClass.setPageSize(-1);
    	}else
    		GoodsClass.setJudge(true);
    	
        List<GoodsClassVO> classVos = GoodsClassService.queryGoodsClassList(GoodsClass);
        mv.addObject("classVo", classVos);
        mv.setViewName("classify/good_classic_patch");
        mv.addObject("isSubClass", !StringUtils.isEmpty(isSubClass));
    	return mv;
    }
    
    @RequestMapping("/listAll")
    @ResponseBody
    public Map<String, Object> listAll(){
    	log.info("=====/admin/classes/listAll开始=====");
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("goodClass", GoodsClassService.listAll());
    	log.info("=====/admin/classes/listAll结束=====");
    	return map;
    }
    
    
    
	/**
	 * 查询所有一级分类
	 */
    @RequestMapping("/selectFirstClass")
    @ResponseBody
    public Map<String, Object> selectFirstClass(){
    	log.info("=====/admin/classes/listAll开始=====");
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("goodClass", GoodsClassService.selectFirstClass());
    	log.info("=====/admin/classes/listAll结束=====");
    	return map;
    }
    
    
	/**
	 * 查询所有二级分类
	 */
    @RequestMapping("/queryErji")
    @ResponseBody
    public Map<String, Object> queryErji(@RequestParam String parentId){
    	log.info("=====/admin/classes/listAll开始=====");
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("goodClass", GoodsClassService.queryErji(parentId));
    	log.info("=====/admin/classes/listAll结束=====");
    	return map;
    }
    

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value= "/delete" , method= RequestMethod.GET)
    @ResponseBody
    public   ResultVO deleteGoods(@RequestParam("categoryOne") String categoryOne,@RequestParam("categoryTwo") String categoryTwo){
    	ResultVO result=new ResultVO();
        GoodsClass GoodsClass = new GoodsClass();
        if(!StringUtils.isEmpty(categoryTwo)&&!categoryTwo.equals("null")){
        	 //判断该二级分类下是否有商品存在
        	 GoodsClass.setId(categoryTwo);
        	 List<Goods> goodList=goodsService.listGoods(categoryTwo);
        	 if(!StringUtils.isEmpty(goodList)&&goodList.size()>0){
        		 result.setCode(0);
        		 result.setMessage("亲!该分类已被商品占用，请勿删除!");
        		 return result;
        	 }
        }else{
        	 GoodsClass.setId(categoryOne);
        	 GoodsClass.setParentId(categoryOne);
        	 List<GoodsClassVO> goodClass=GoodsClassService.queryErji(categoryOne);
        	 if(!StringUtils.isEmpty(goodClass)&&goodClass.size()>0){
        		 result.setCode(0);
        		 result.setMessage("亲!该一级分类下存在二级分类，请删除二级分类再删除该分类!");
        		 return result;
        	 }
        }
       
        GoodsClass.setStatus(false);
        Integer count = GoodsClassService.operateGoods(GoodsClass,"");
        if (count > 0) {
            //说明程序出错了，跳到error页面
   		  result.setCode(200);
   		  result.setMessage("成功删除!");
        }else{
      	  result.setCode(200);
       	  result.setMessage("成功失败!");
        }
        return result;
    }

    /**
     * 新增或者编辑商品分类
     *
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultVO addClasses(HttpServletRequest request,String id,String name,String parentId,String pic) {
    	ResultVO result = new ResultVO();
        GoodsClass GoodsClass = new GoodsClass();
        if(!StringUtils.isEmpty(id)&&!id.equals("null"))
          GoodsClass.setId(id);
        else
          GoodsClass.setId(null);
        if(!StringUtils.isEmpty(name)&&!name.equals("null"))
          GoodsClass.setName(name);
        else
          GoodsClass.setName(null);
        if(!StringUtils.isEmpty(parentId)&&!parentId.equals("null"))
          GoodsClass.setParentId(parentId);
        else
          GoodsClass.setParentId(null);
        if(!StringUtils.isEmpty(pic)&&!pic.equals("null"))
          GoodsClass.setPicKey(pic);
        else
          GoodsClass.setPicKey(null);
        String uid=UUID.randomUUID().toString();
        Integer count = GoodsClassService.operateGoods(GoodsClass,uid);
        if(!StringUtils.isEmpty(id)&&!id.equals("null")){
	        if(count>0){
	       		 result.setCode(0);
	       		 result.setMessage("编辑成功!");
	       		 return result;
	        }else{
	       		 result.setCode(0);
	       		 result.setMessage("编辑失败!");
	       		 return result;
	        }
        }else{
	        if(count>0){
	        	 request.setAttribute("uid", uid);
	       		 result.setCode(0);
	       		 result.setMessage("新增成功!");
	       		 result.setId(uid);
	       		 return result;
	        }else{
	       		 result.setCode(0);
	       		 result.setMessage("新增失败!");
	       		 return result;
	        }
        }
    }


    /**
     * 编辑商品分类
     *
     * @return
     */
    @RequestMapping(value= "/edit" , method= RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String editClass(@RequestParam("id") String id){
        GoodsClass GoodsClass = new GoodsClass();
        GoodsClass.setId(id);
        List<GoodsClassVO> classVos = GoodsClassService.queryGoodsClassList(GoodsClass);
        return JSON.toJSONString((classVos!=null && classVos.size()>0)?classVos.get(0):null);
    }

}
