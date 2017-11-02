package com.wmeimob.yzfs.api.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.AddressServiceApi;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Area;

@Controller
@RequestMapping("/address/api")
@CrossOrigin
@Transactional
public class AddressControllerApi {

    @Autowired
    private AddressServiceApi addressServiceApi;
    
	
    /**
     * 查询所有地址列表
     */
	@RequestMapping(value = "/queryAddressList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryAddressList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		try {
			data=addressServiceApi.queryAddressList(request);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "error!");
		}
		return data;
	}
	
	
    /**
     * 根据ID查询地址信息
     */
	@RequestMapping(value = "/queryAddressById", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject queryAddressById(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		try {
			data=addressServiceApi.queryAddressById(request,id);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			   data.put("message", "error!");
		}
		return data;
	}
	
    /**
     * 修改或者编辑地址信息
     */
	@RequestMapping(value = "/uddateAddressById", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject uddateAddressById(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		try {
			data=addressServiceApi.uddateAddressById(request);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
    /**
     * 设置为默认地址
     */
	@RequestMapping(value = "/setAddressIsDefault", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject setAddressIsDefault(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		try {
			data=addressServiceApi.setAddressIsDefault(request,id);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
    /**
     * 删除地址
     */
	@RequestMapping(value = "/deleteAddressById", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteAddressById(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		try {
			data=addressServiceApi.deleteAddressById(request,id);
		} catch (CustomException e) {
			data.put("code", 404);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
    
	/**
	 * 省份列表
	 * @return
	 */
	@RequestMapping("/areaInfo")
	@ResponseBody
	public JSONObject queryAreaProvinceList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		try {
			List<Area> list = addressServiceApi.queryAreaProvinceList();
			data.put("code", 100);
			data.put("data", list);
			data.put("message", "success");
			return data;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			data.put("code", 404);
			data.put("data", "data is empty");
			data.put("message", "error");
			return data;
		}
	} 
    
	
}
