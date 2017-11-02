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
import com.wmeimob.yzfs.api.service.CartServiceApi;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.util.GeneratorSnUtil;

@Controller
@RequestMapping("/cart/api")
@CrossOrigin
@Transactional
public class CartControllerApi {

    @Autowired
    private CartServiceApi cartServiceApi;
    
    /**
     * 查询购物车信息
     */
	@RequestMapping(value = "/listCart", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryListCartFromWX(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		//锁变量
		try {
			data=cartServiceApi.queryListCartFromWX(request);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
    
    
    
    
    /**
     * 加入购物车
     * @param request
     * @param skuCode 商品SKU编码
     * @param neckSkuCode 定制SKU编码
     * @param id 商品ID
     * @param number 商品数量
     * @param isMade 是否私人定制   true 是 ； false 或者null  非；
     * @return
     */
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject queryEcGoodSkuFromWX(HttpServletRequest request,String skuCode,String neckSkuCode,String id,Integer number,Boolean isMade) {
		JSONObject  data = new JSONObject();
		if(isMade==null){
			isMade=false;
		}
		//锁变量
		String snCode=GeneratorSnUtil.generatorSn("CR");//支付流水号
		try {
			data=cartServiceApi.addCart(request, skuCode,neckSkuCode,id,number,snCode,isMade);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
	
    /**
     * 购物车数量加减
     * @param request
     * @param itemId 购物车商品明细ID
     * @param number  加减数量
     * @param isAdd 是否加   true 加   false  减
     * @return
     */
	@RequestMapping(value = "/addAndSub", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addAndSub(HttpServletRequest request,String id,Integer number) {
		JSONObject  data = new JSONObject();
		if(id==null){
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "非法的参数!");
			return data;
		}
		try {
			data=cartServiceApi.addAndSub(request, id,number);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
    /**
     * 批量删除购物车信息
     * @param request
     * @param itemId 购物车商品明细ID
     * @return
     */
	@RequestMapping(value = "/deleteCartById", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteCartById(HttpServletRequest request,String itemId) {
		JSONObject  data = new JSONObject();
		if(itemId==null){
			data.put("code", 404);
			data.put("data", "data is null");
			data.put("message", "非法的参数!");
			return data;
		}
		try{
			data=cartServiceApi.deleteCartById(request, itemId);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
	
    /**
     * 查询购物车数量
     * @param request
     * @return
     */
	@RequestMapping(value = "/queryCartNumber", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject deleteCartById(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		try{
			data=cartServiceApi.queryCartNumber(request);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
}
