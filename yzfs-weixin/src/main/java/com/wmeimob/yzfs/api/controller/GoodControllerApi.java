package com.wmeimob.yzfs.api.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.GoodServiceApi;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.vo.GoodsVO;

@Controller
@RequestMapping("/good/api")
@CrossOrigin
@Transactional
public class GoodControllerApi {

    @Autowired
    private GoodServiceApi goodServiceApi;
    
    
	
	/**
	 * 根据条件查询商品列表
	 * @return
	 */
	@RequestMapping("/goodList")
	@ResponseBody
	public JSONObject homeSilderList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		List<GoodsVO> goodList;
		int code=404;
		try {
			goodList = goodServiceApi.querySilderListFromWX(request);
			if(goodList!=null && goodList.size()>0){
				code=100;
				data.put("data", goodList);
				data.put("message", "success");
			}else{
				code=200;
			    data.put("data", null);
			    data.put("message", "empty");
			}
		} catch (CustomException e) {
			code=404;
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		data.put("code", code);
		return data;
	}
	
	
	/**
	 * 根据条件查询商品分类列表
	 * @return
	 */
	@RequestMapping(value = "/goodCategoryList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject goodCategoryList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		List<GoodsClass> goodList;
		int code=404;
		try {
			goodList = goodServiceApi.goodCategoryList(request);
			if(goodList!=null && goodList.size()>0){
				code=100;
				data.put("data", goodList);
				data.put("message", "success");
			}else{
				code=200;
			    data.put("data", null);
			    data.put("message", "empty");
			}		
		} catch (CustomException e) {
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		 data.put("code", code);
		return data;
	}
	
	
	/**
	 * 根据商品ID查询商品明细(商品图片列表)
	 * @param request
	 * @param id 商品ID
	 * @param isMade 是否私人定制 true 是  false  否
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryGoodById(HttpServletRequest request,String id,String isMade) {
		JSONObject  data = new JSONObject();
		int code=404;
		boolean isMades=false;
		if(!StringUtils.isEmpty(id)){
			Goods good;
			try {
				if(StringUtils.isEmpty(isMade)){
					isMades=false;
				}else{
					if("0".equals(isMade)){
						isMades=false;
					}else{
						isMades=true;
					}
				}
				good = goodServiceApi.queryGoodsItemFromWX(id,isMades);
				if(good!=null && !StringUtils.isEmpty(good.getId())){
					code=100;
					data.put("data", good);
					data.put("message", "success");
				}else{
					code=200;
				    data.put("data", null);
				    data.put("message", "empty");
				}		
			}catch(CustomException e) {
				code=404;
			    data.put("data", "");
			    data.put("message", e.getMessage());
			}
		}else{
			code=404;
			data.put("data", "data is null");
			data.put("message", "Parameter is not legal");
		}
		 data.put("code", code);
		return data;
	}
	
	
	/**
	 * 根据商品ID查询商品详情文本信息
	 * @return
	 */
	@RequestMapping(value = "/descriptions", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryGoodDetailsById(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		if(!StringUtils.isEmpty(id)){
			String description;
			try {
				description = goodServiceApi.queryGoodDetailsById(id);
				if(!StringUtils.isEmpty(description)){
				  data.put("code", 100);
			      data.put("data", description);
				  data.put("message", "success");
				}else{
				  data.put("code", 200);
			      data.put("data", "");
				  data.put("message", "empty");
				}
			}catch (CustomException e){
				data.put("code", 404);
			    data.put("data", "");
			    data.put("message", e.getMessage());
			}
		}else{
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "Parameter is not legal");
		}
		return data;
	}
	
	/**
	 * 根据商品分类查询商品所有属性
	 * @return
	 */
	@RequestMapping(value = "/queryEcGoodSkuPropertiesFromWX", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryEcGoodSkuPropertiesFromWX(HttpServletRequest request,String classId,String spuId) {
		JSONObject  data = new JSONObject();
		List<Map<String,Object>> returnDate =new ArrayList<Map<String,Object>>();
		if(!StringUtils.isEmpty(classId)){
			try {
				returnDate = goodServiceApi.queryEcGoodSkuPropertiesFromWX(request, classId,spuId);
				if(returnDate !=null && returnDate.size()>0){
				  data.put("code", 100);
			      data.put("data", returnDate);
				  data.put("msg", "success");
				}else{
				  data.put("code", 200);
			      data.put("data", "");
				  data.put("msg", "empty");
				}
			 }catch (CustomException e){
				data.put("code", 404);
			    data.put("data", "");
			    data.put("message", e.getMessage());
			 }
		}else{
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "Parameter is not legal");
		}
		return data;
	}
	
	
	
	/**
	 * 根据商品SKU编码查询SKU信息
	 * @return
	 */
	@RequestMapping(value = "/queryEcGoodSkuFromWX", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryEcGoodSkuFromWX(HttpServletRequest request,String skuCode,String id) {
		JSONObject  data = new JSONObject();
		EcGoodSku sku = new EcGoodSku();
		if(!StringUtils.isEmpty(skuCode)&&!StringUtils.isEmpty(id)){
			try {
				sku = goodServiceApi.queryEcGoodSkuFromWX(request, skuCode,id);
				if(!StringUtils.isEmpty(sku)){
				  data.put("code", 100);
			      data.put("data", sku);
				  data.put("msg", "success");
				}else{
				  data.put("code", 200);
			      data.put("data", "");
				  data.put("msg", "empty");
				}
			}catch (CustomException e){
				data.put("code", 404);
			    data.put("data", "");
			    data.put("message", e.getMessage());
			}
		}else{
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "Parameter is not legal");
		}
		return data;
	}
	
	
	/**
	 *查询所有私人定制属性信息
	 * @return
	 */
	@RequestMapping(value = "/queryEcGoodNeckSkuPropertiesFromWX", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryEcGoodNeckSkuPropertiesFromWX(HttpServletRequest request,String spuId) {
		JSONObject  data = new JSONObject();
		List<Map<String, Object>> returnData =new ArrayList<Map<String, Object>>();
		try {
			returnData = goodServiceApi.queryEcGoodNeckSkuPropertiesFromWX(request,spuId);
			if(returnData !=null && returnData.size()>0){
			  data.put("code", 100);
		      data.put("data", returnData);
			  data.put("msg", "success");
			}else{
			  data.put("code", 200);
		      data.put("data", "");
			  data.put("msg", "empty");
			}
		 }catch (CustomException e){
			data.put("code", 404);
		    data.put("data", "");
		    data.put("message", e.getMessage());
		 }
		return data;
	}
	
	
	/**
	 * 根据商品ID以及SKU编码查询可改装SKU信息
	 * @return
	 */
	@RequestMapping(value = "/queryEcGoodNeckSkuFromWX", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryEcGoodNeckSkuFromWX(HttpServletRequest request,String skuCode,String id) {
		JSONObject  data = new JSONObject();
		EcNeckSku sku = new EcNeckSku();
		if(!StringUtils.isEmpty(skuCode)&&!StringUtils.isEmpty(id)){
			try {
				sku = goodServiceApi.queryEcGoodNeckSkuFromWX(request, skuCode,id);
				if(!StringUtils.isEmpty(sku)){
				  data.put("code", 100);
			      data.put("data", sku);
				  data.put("msg", "success");
				}else{
				  data.put("code", 200);
			      data.put("data", "");
				  data.put("msg", "empty");
				}
			}catch (CustomException e){
				data.put("code", 404);
			    data.put("data", "");
			    data.put("message", e.getMessage());
			}
		}else{
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "Parameter is not legal");
		}
		return data;
	}
	
	
	
}
