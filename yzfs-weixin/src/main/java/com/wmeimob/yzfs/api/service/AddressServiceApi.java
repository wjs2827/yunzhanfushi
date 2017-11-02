package com.wmeimob.yzfs.api.service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.dao.AreaMapper;
import com.wmeimob.yzfs.dao.ShippingAddrsMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Area;
import com.wmeimob.yzfs.model.ShippingAddrs;
import com.wmeimob.yzfs.util.CheckUtils;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.vo.ShippingAddrsVO;
import com.wmeimob.yzfs.weixin.CheckError;

@Service
@Transactional
public class AddressServiceApi {
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	ShippingAddrsMapper shippingAddrsMapper;
	
	@Autowired
	AreaMapper areaMapper;
	
	/**
	 * 查询地址列表
	 * @param request
	 * @return
	 */
	public JSONObject queryAddressList(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			ShippingAddrsVO params = new ShippingAddrsVO();
			params.setUserId(userId);
			List<ShippingAddrsVO>  dataList=shippingAddrsMapper.queryAddrsByConditions(params);
			if(dataList !=null && dataList.size()>0){
				data.put("code", 100);
				data.put("message", "success");
				data.put("data", dataList);
			}else{
				data.put("code", 200);
				data.put("message", "data is empty");
				data.put("data", "empty");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new CustomException(404,"error!");
		}
		return data;
	}
	
    
	/**
	 * 根据地址ID查询地址信息
	 * @param request
	 * @return
	 */
	public JSONObject queryAddressById(HttpServletRequest request,String id) throws CustomException{
		JSONObject  data = new JSONObject();
		try {
			ShippingAddrsVO params = new ShippingAddrsVO();
			params.setId(id);
			List<ShippingAddrsVO>  dataList=shippingAddrsMapper.queryAddrsByConditions(params);
			if(dataList !=null && dataList.size()>0){
				data.put("code", 100);
				data.put("message", "success");
				data.put("data", dataList.get(0));
			}else{
				data.put("code", 200);
				data.put("message", "data is empty");
				data.put("data", "empty");
			}
		}catch (Exception e) {
			throw new CustomException(404,"error!");
		}
		return data;
	}
	
	/**
	 * 修改或者编辑地址信息
	 * @param request
	 * @return
	 */
	public JSONObject uddateAddressById(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			ShippingAddrs params =new ShippingAddrs();
			data=this.checkAddres(request,params);
			if(("success").equals(data.get("message"))){
				//如果ID为空则为新增
				if(StringUtils.isEmpty(params.getId())){
					params.setId(UUID.randomUUID().toString());
					params.setUserId(userId);
					params.setCreatedAt(new Date());
					params.setUpdatedAt(new Date());
					params.setStatus(true);
					if(shippingAddrsMapper.insertSelective(params)>0){
						data.put("code", CheckError.SUCCESS.value);
						data.put("data", "");
						data.put("message", "success");
					}
				}else{
					params.setUpdatedAt(new Date());
					if(shippingAddrsMapper.updateByPrimaryKeySelective(params)>0){
						data.put("code", CheckError.SUCCESS.value);
						data.put("data", "");
						data.put("message", "success");
					}
				}
				//该地址是默认地址，则将其他地址变更为非默认地址
				if(params.getIsDefault()){
					params.setUserId(userId);
					if(shippingAddrsMapper.updateAddressIsDefault(params)>0){
                        Log.debug("#####################已成功变更地址为非默认地址");
					}else{
						 Log.debug("#####################没有需要变更的地址");
					}
				}
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", "");
				data.put("message", "success");
				return data;
			}else{
				return data;
			}
		}catch (Exception e) {
			data.put("code", CheckError.SYSTEM_ERROR.value);
			data.put("data", "");
			data.put("message", "error!");
			throw new CustomException(404,"error!");
		}
	}
	
	/**
	 * 校验地址信息是否合法
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONObject checkAddres(HttpServletRequest request,final ShippingAddrs params) throws CustomException{
		JSONObject  data = new JSONObject();
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		try {
			String id =maps.get("id")+"";//地址ID
			String shippingName=maps.get("shippingName")+"";//收货人姓名
			String mobile=maps.get("mobile")+"";//手机号码
			String pId=maps.get("pId")+"";//省份ID
			String cId=maps.get("cId")+"";//城市ID
			String dId=maps.get("dId")+"";//地区ID
			String itemAddress=maps.get("itemAddress")+"";//详细地址
			String isDefault=maps.get("isDefault")+"";//是否默认地址
			if(!StringUtils.isEmpty(id)){
				params.setId(id);
			}
			if(StringUtils.isEmpty(shippingName)){
				data.put("code", CheckError.SHIPPING_NAME_ERROR.value);
				data.put("data", "shippingName is not empty");
				data.put("message", "error");
				return data;
			}else{
				params.setShippingName(shippingName);
			}
			if(StringUtils.isEmpty(mobile)){
				data.put("code", CheckError.MOBILE_ERROR.value);
				data.put("data", "mobile is not empty");
				data.put("message", "error");
				return data;
			}
			if(!StringUtils.isEmpty(mobile) && !CheckUtils.checkMobile(mobile)){
				data.put("code", CheckError.MOBILE_ERROR.value);
				data.put("data", "The cell mobile number is not legal");
				data.put("message", "error");
				return data;
			}else{
				params.setMobile(mobile);
			}
			if(StringUtils.isEmpty(pId)){
				data.put("code", CheckError.PROVINCE_ID_ERROR.value);
				data.put("data", "shippingName is not empty");
				data.put("message", "error");
				return data;
			}else{
				params.setpId(Integer.parseInt(pId));
			}
			if(StringUtils.isEmpty(cId)){
				data.put("code", CheckError.CITY_ID_ERROR.value);
				data.put("data", "shippingName is not empty");
				data.put("message", "error");
				return data;
			}else{
				params.setcId(Integer.parseInt(cId));
			}
			if(StringUtils.isEmpty(dId)){
				data.put("code", CheckError.REGION_ID_ERROR.value);
				data.put("data", "shippingName is not empty");
				data.put("message", "error");
				return data;
			}else{
				params.setdId(Integer.parseInt(dId));
			}
			if(StringUtils.isEmpty(itemAddress)){
				data.put("code", CheckError.ADDRESS_ITEM_ERROR.value);
				data.put("data", "shippingName is not empty");
				data.put("message", "error");
				return data;
			}else{
				params.setShippingAddress(itemAddress);
			}
			if(StringUtils.isEmpty(isDefault) || "0".equals(isDefault)){
				params.setIsDefault(false);
			}else{
				params.setIsDefault(true);
			}
			data.put("code", 0);
			data.put("data", "");
			data.put("message", "success");
			return data;
		}catch (Exception e) {
			data.put("code", CheckError.SYSTEM_ERROR.value);
			data.put("data", "");
			data.put("message", "error!");
			throw new CustomException(404,"error!");
		}
	}
	
	
	
	/**
	 * 设置为默认地址
	 * @param request
	 * @return
	 */
	public JSONObject setAddressIsDefault(HttpServletRequest request,String id) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			ShippingAddrs record =new ShippingAddrs();
			record.setId(id);
			record.setIsDefault(true);
			//将该地址变更为默认地址
			if(shippingAddrsMapper.updateByPrimaryKeySelective(record)>0){
				record.setUserId(userId);
				//将其他地址不包括该地址变更为非默认地址
				if(shippingAddrsMapper.updateAddressIsDefault(record)>0){
					data.put("code", 100);
					data.put("data", "");
					data.put("message", "success");
					return data;
				}
			}
		}catch (Exception e) {
			throw new CustomException(404,"error!");
		}
		return data;
	}
	
	/**
	 * 删除地址
	 * @param request
	 * @return
	 */
	public JSONObject deleteAddressById(HttpServletRequest request,String id) throws CustomException{
		JSONObject  data = new JSONObject();
		try {
			
			ShippingAddrsVO params = new ShippingAddrsVO();
			params.setId(id);
			params.setStatus(false);
			if(shippingAddrsMapper.updateByPrimaryKeySelective(params)>0){
				data.put("code", 100);
				data.put("data", "");
				data.put("message", "success");
				return data;
			}
		}catch (Exception e) {
			throw new CustomException(404,"error!");
		}
		return data;
	}
    
	
	/**
	 * 根据参数查询区域信息列表
	 */
	public List<Area> queryAreaProvinceList() {
		return areaMapper.queryAreaProvinceList();
	}
	
	
	
}
