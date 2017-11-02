package com.wmeimob.yzfs.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.dao.GoodsPicsMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.model.GoodsPics;
import com.wmeimob.yzfs.model.SilderPicSettings;
import com.wmeimob.yzfs.service.ClassifyService;
import com.wmeimob.yzfs.service.GoodsService;
import com.wmeimob.yzfs.service.HomeService;
import com.wmeimob.yzfs.vo.GoodsClassVO;
import com.wmeimob.yzfs.vo.GoodsVO;
import com.wmeimob.yzfs.vo.ResultVO;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * wjs
 * @Date 2016/7/27 11:43
 */
@Controller
@RequestMapping("/admin/good")
public class GoodsController{

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsPicsMapper goodsPicsMapper;
	@Autowired
	private ClassifyService GoodsClassService;
	@Autowired
	public HomeService silderPicService;
	
	
	/**
	 * 商品列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView queryGoodsList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("ec_good/goods_manage");
		Goods goods = new Goods();
		mv.addObject("params", goods);//参数设置
		return mv;
	}
	
	/**
	 * 异步查询商品列表
	 * @return
	 */
	@RequestMapping("/initGoodList")
	public ModelAndView batch_list(HttpServletRequest request) {
		Goods goods = new Goods();
		ModelAndView mv = new ModelAndView();
		/*######商品查询参数设置######*/
		goods=publicParamsFromGoods(request);
		List<GoodsVO> GoodsVOs = goodsService.queryGoodsList(goods);
		mv.addObject("goods", GoodsVOs);
		mv.setViewName("ec_good/good__patch_list");
		return mv;
	}
	
	
	
	/**
	 * 查询商品公共参数设置标准化
	 * @param request
	 * @return
	 */
	public Goods publicParamsFromGoods(HttpServletRequest request){
		Goods goods = new Goods();
		String goodName=request.getParameter("goodName");//商品名称
		String isSale=request.getParameter("isSale");//是否上下架 true:上架 false:下架
		String classId=request.getParameter("classId");//商品二级分类
		if (!StringUtils.isEmpty(goodName)) {
			goods.setName(goodName);
		}
		if(!StringUtils.isEmpty(isSale)) {
			if(isSale.equals("0"))
				goods.setIsSale(false);
			else
				goods.setIsSale(true);
	    }
		if (!StringUtils.isEmpty(classId)){
			goods.setClassesId(classId);
	    }else
	    	goods.setClassesId("");
		return goods;
	}
	

	/**
	 * 新增商品跳转到新增商品页面标准化
	 * @return
	 */
	@RequestMapping(value = "/add")
	public ModelAndView addGoods() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ec_good/add_self_goods");
		return mv;
	}
	
	/**
	 * 根据商品ID查询商品信息编辑商品标准化
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView editGoods(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		//获取商品ID存入实体类中
		Goods goods = new Goods();
		goods.setId(id);
		//获取商品详情信息
		GoodsVO goodInfo = goodsService.queryGoodById(goods);
		//商品图片列表
		List<GoodsPics> goodPicList = goodsPicsMapper.selectByGoodsId(id);
		mv.addObject("goodsInfoVo", goodInfo);//商品信息
		mv.addObject("goodPicList", goodPicList);//商品图片列表
		mv.setViewName("ec_good/edit_self_goods");//商品编辑页面
		return mv;
	}
	
	

	/**
	 * 新增或者编辑商品信息标准化
	 * @return
	 */
	@RequestMapping("/operateGoods")
	@ResponseBody
	public Map<String,Object> addGoods(HttpServletRequest request, @ModelAttribute Goods goods, BindingResult result) {
		Map<String,Object> map = new HashMap<String,Object>();
		goods.setDescriptions(request.getParameter("desContent"));
		try {
			map=goodsService.operateGoods(goods,request);
		} catch (CustomException e) {
			
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 根据商品ID查询商品对应的SKU列表信息
	 * @param request
	 * @param spuId
	 * @param result
	 * @return
	 */
	@RequestMapping("/queryGoodSkuBySpuId")
	@ResponseBody
	public Map<String,Object> queryGoodSkuBySpuId(HttpServletRequest request,String spuId) {
		Map<String,Object> map = new HashMap<String,Object>();
		EcGoodSku sku=goodsService.queryGoodSkuBySpuId(spuId);
		map.put("sku", sku);
		return map;
	}
	
	/**
	 * 根据商品ID查询商品对应的SKU列表信息
	 * @param request
	 * @param spuId
	 * @param result
	 * @return
	 */
	@RequestMapping("/queryGoodSkuListBySpuId")
	@ResponseBody
	public Map<String,Object> queryGoodSkuListBySpuId(HttpServletRequest request,String spuId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map=goodsService.queryGoodSkuListBySpuId(spuId);
		return map;
	}
	

	/**
	 * 根据商品ID删除商品信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public ResultVO deleteGoods(@RequestParam("id") String id) {
		ResultVO rs = new ResultVO();
		try {
			rs=goodsService.deleteGoodById(id);
		} catch (CustomException e) {
			rs.setCode(200);
			rs.setMessage("删除失败");
		}
		return rs;
	}
	
	
	
	/**
	 * 平台商品上下架
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/updateIsSale")
	@ResponseBody
	public ResultVO updateIsSale(String id,Boolean isSale,String sign) {
		ResultVO rs =new ResultVO();
		try {
			
			Goods goods = new Goods();
			String[] goodIds = id.split(",");
			for (int i = 0; i < goodIds.length; i++) {
				goods.setId(goodIds[i]);
				goods.setStatus(true);
				goods.setIsSale(isSale);
				String msg = "";
				SilderPicSettings silder = new SilderPicSettings();
				silder = silderPicService.verifyGoodExist(goods.getId());
				if (!StringUtils.isEmpty(silder) && silder.getTotlalCount() > 0 && isSale.equals("0")) {
					rs.setCode(0);
					rs.setMessage("亲!商品【" + silder.getpName() + "】已经成功设置为微信首页轮播图链接商品，请修改再下架!");
					return rs;
				}else {
					if (goodsService.updateIsSale(goods)) {
						if (!StringUtils.isEmpty(sign)) {
							rs.setCode(200);
							if (sign.equals("1"))
								msg = "上架成功";
							if (sign.equals("2"))
								msg = "下架成功";
							if (sign.equals("3"))
								msg = "批量上架成功";
							if (sign.equals("4"))
								msg = "批量下架成功";
							rs.setMessage(msg);
							return rs;
						}
					} else {
						if (!StringUtils.isEmpty(sign)) {
							rs.setCode(200);
							if (sign.equals("1"))
								msg = "上架失败";
							if (sign.equals("2"))
								msg = "下架失败";
							if (sign.equals("3"))
								msg = "批量上架失败";
							if (sign.equals("4"))
								msg = "批量下架失败";
							rs.setMessage(msg + ",请重试!");
							return rs;
						}
					}
				}
			} 
		} catch (Exception e) {
			rs.setCode(200);
			rs.setMessage(e.getMessage());
		}
		return rs;
	}


	/**
	 * 查询主分类
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/listClassVo", method = RequestMethod.POST)
	@ResponseBody
	public List<GoodsClassVO> listClassVo() {
		GoodsClass param = new GoodsClass();
		param.setJudge(true);
		List<GoodsClassVO> classVo = GoodsClassService.queryGoodsClassList(param);
		return classVo;
	}
	
	/**
	 * 查询商品二级分类
	 */
	@RequestMapping(value = "/listErji", method = RequestMethod.POST)
	@ResponseBody
	public List<GoodsClassVO> listErji(@RequestParam("id") String id) {
		List<GoodsClassVO> classEj = GoodsClassService.queryErji(id);
		return classEj;
	}

	
	/**
	 * 验证商品编码是否存在
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/verifySpuCode")
	@ResponseBody
	public Map<String,Object> verifySpuCode(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("spuCode") String spuCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Goods goods = new Goods();
			goods.setId(id);
			goods.setSpuCode(spuCode);
			map = goodsService.queryGoodsListBySpuCodeVerifyExist(goods);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("code", 200);
			map.put("msg", "系统异常!");
		}
		return map;
	}
	
	/**
	 * 根据分类查询商品
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/listGoods")
	public Map<String, Object> listGoods(@RequestParam String classId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods", goodsService.listGoods(classId));
		return map;
	}
	
	
	
	  /** 
	    * CSV商品管理导出标准化
	    * @param path 
	    * @throws IOException  
	    * @throws WriteException  
	    * @throws RowsExceededException  
	    * @throws BiffException 
	    */  
	   @RequestMapping("csvGoodsOut")
	   public  void csvOrderStatisOut(HttpServletRequest request,HttpServletResponse response) throws IOException, RowsExceededException, WriteException, BiffException{  
		        //创建Excel; 
		 	    String fileName="商品列表"+new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+".csv";  
				response.reset();
			    response.setHeader("Content-disposition",
						"attachment; filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
				response.setContentType("application/octet-stream");
				OutputStream os = response.getOutputStream();
				/*######商品查询参数设置######*/
				Goods goods = new Goods();
				goods=publicParamsFromGoods(request);
				List<GoodsVO> list = goodsService.queryGoodsList(goods);
				String str = setGoodsCSVData(list).toString();
				try {
					byte[] srtbyte = null;
					srtbyte = str.getBytes("GBK");
			        os.write(srtbyte);
            os.flush();
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					os.flush();
					os.close();
				}
	   } 
	
	
	/**
	 * 商品管理CSV导出存储数据标准化
	 * @return
	 */
	public StringBuilder setGoodsCSVData(List<GoodsVO> list){
	 	StringBuilder sbf = new StringBuilder();
	 	SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		sbf.append("商品排序,商品名称,分类,销售价,当前库存,实际销量,运费,上|下架,上下架时间\n");
	 	for (int i = 0; i < list.size(); i++) {
	 	 //商品排序
       if(!StringUtils.isEmpty(list.get(i).getRank()))
       	sbf.append(list.get(i).getRank()+",");
       else
       	sbf.append(",");
       //商品名称
       if(!StringUtils.isEmpty(list.get(i).getName()))
       	sbf.append(list.get(i).getName().toString()+",");
       else
       	sbf.append(",");
       //商品分类
       if(!StringUtils.isEmpty(list.get(i).getClassesName()))
       	sbf.append(list.get(i).getClassesName().toString()+",");
       else
       	sbf.append(",");
       //当前库存
       if(!StringUtils.isEmpty(list.get(i).getStockCount()))
       	sbf.append(list.get(i).getStockCount()+",");
       else
       	sbf.append("0,");
       //实际销量
       if(!StringUtils.isEmpty(list.get(i).getSaleCount()))
       	sbf.append(list.get(i).getSaleCount()+",");
       else
       	sbf.append("0,");
       //上下架
       if(!StringUtils.isEmpty(list.get(i).getIsSale())){
      	 if(list.get(i).getIsSale())
      	   sbf.append("上架,");
      	 else
      	   sbf.append("下架,"); 
       }else
       	sbf.append("下架,");
       //上架时间
       if(!StringUtils.isEmpty(list.get(i).getUpdatedAt()))
       	sbf.append(myFmt.format(list.get(i).getUpdatedAt())+"\n");
       else
       	sbf.append("\n");
		} 
	 	return sbf;
	}
}
