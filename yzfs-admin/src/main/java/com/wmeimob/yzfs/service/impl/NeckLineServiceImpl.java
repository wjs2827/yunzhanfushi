package com.wmeimob.yzfs.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.NecklineTypeMapper;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.NecklineFabricType;
import com.wmeimob.yzfs.model.NecklineType;
import com.wmeimob.yzfs.service.NeckLineService;

@Service
@Transactional
public class NeckLineServiceImpl implements NeckLineService {

	@Autowired
	private NecklineTypeMapper  necklineTypeMapper;
	@Autowired
	private EcNeckSkuMapper  ecNeckSkuMapper;
	
	/**
	 * 查询领口信息列表
	 * @param params
	 * @return
	 */
	public List<NecklineType> queryNecklineTypeList(NecklineType params){
		return necklineTypeMapper.queryNecklineTypeList(params);
	}
    
    /**
     * 查询布料信息列表
     * @param params
     * @return
     */
	public List<NecklineFabricType> queryNecklineFabricTypeList(NecklineFabricType params){
		return necklineTypeMapper.queryNecklineFabricTypeList(params);
	}
    
    /**
     * 编辑领口信息 
     * @param params
     * @return
     */
	public int insertNecklineType(HttpServletRequest request){
		NecklineType params = new NecklineType();
		params=getPublicNecklineTypeParams(request);
		if(!StringUtils.isEmpty(params.getId())){
			return necklineTypeMapper.updateNecklineTypeByParams(params);
		}else{
			return necklineTypeMapper.insertNecklineType(params);
		}
	}
	
	/**
	 * 新增领口公共参数
	 * @param request
	 * @return
	 */
	public  NecklineType getPublicNecklineTypeParams(HttpServletRequest request){
		NecklineType params = new NecklineType();
		String id=request.getParameter("id");//首页分类ID
		String necklineType =request.getParameter("necklineType");//首页分类商品ID
		String picKey =request.getParameter("picKey");//首页分类商品图片key
		params.setId(id);
		params.setNeckName(necklineType);
		params.setPicKey(picKey);
		params.setIsDeleted(true);//是否删除
		params.setCreatedAt(new Date());
		params.setUpdatedAt(new Date());
		return params;
	}
	
    
    /**
     * 编辑布料信息
     * @param params
     * @return
     */
	public int insertNecklineFabricType(HttpServletRequest request){
		NecklineFabricType params = new NecklineFabricType();
		params=getPublicNecklineFabricParams(request);
		if(!StringUtils.isEmpty(params.getId())){
			return necklineTypeMapper.updateNecklineFabricTypeByParams(params);
		}else{
			return necklineTypeMapper.insertNecklineFabricType(params);
		}
	}
	
	/**
	 * 新增布料公共参数
	 * @param request
	 * @return
	 */
	public  NecklineFabricType getPublicNecklineFabricParams(HttpServletRequest request){
		NecklineFabricType params = new NecklineFabricType();
		String id=request.getParameter("id");//首页分类ID
		String necklineType =request.getParameter("necklineType");//首页分类商品ID
		String picKey =request.getParameter("picKey");//首页分类商品图片key
		params.setId(id);
		params.setFabricName(necklineType);
		params.setPicKey(picKey);
		params.setIsDeleted(true);//是否删除
		params.setCreatedAt(new Date());
		params.setUpdatedAt(new Date());
		return params;
	}
	

    
    /**
     * 根据参数修改领口信息
     * @param params
     * @return
     */
	public int updateNecklineTypeByParams(HttpServletRequest request){
		NecklineType params = new NecklineType();
		params.setId(request.getParameter("id"));
		params.setIsDeleted(false);//是否删除
		params.setUpdatedAt(new Date());
		return necklineTypeMapper.updateNecklineTypeByParams(params);
	}
    
    /**
     * 根据参数修改布料信息
     * @param params
     * @return
     */
	public int updateNecklineFabricTypeByParams(HttpServletRequest request){
		NecklineFabricType params = new NecklineFabricType();
		params.setId(request.getParameter("id"));
		params.setIsDeleted(false);//是否删除
		params.setUpdatedAt(new Date());
		return necklineTypeMapper.updateNecklineFabricTypeByParams(params);
	}
	
	/**
	 * 根据商品ID查询商品对应的SKU列表信息
	 */
	@Override
	public Map<String, Object> queryNeckSkuListBySpuId(String spuId) {
		List<EcNeckSku> skuList=ecNeckSkuMapper.selectByPrimaryKey(spuId);
		//解析JSON数据
		//获取标题MAP集合
		return JSONInfoTOSKU(skuList);
	}
	
	
	/**
	 * JSON转换成列表
	 * @return
	 */
	public  Map<String, Object> JSONInfoTOSKU(List<EcNeckSku> skuList){
		Map<String, Object> mapTitle = new HashMap<String,Object>();
		List<Map<String, Object>> mapItemValueList = new ArrayList<Map<String,Object>>();
		try {
			Map<String, Object> mapItemValue = null;
			for(EcNeckSku sku:skuList){
				if(!StringUtils.isEmpty(sku.getSkuCode())){
					System.out.println(sku.getSkuCode());
					String[] arraySku=sku.getSkuCode().split("_");
					for(int i=0;i<arraySku.length;i++)
					{
						mapItemValue = new HashMap<String, Object>();
						int idx=0;
						if(mapItemValueList!=null && mapItemValueList.size()>0){
							for(Map<String, Object> map:mapItemValueList){
								if(map.containsValue(arraySku[i])){
									idx++;
								}
							}
							if(idx==0){
								mapItemValue.put("key",arraySku[i]);
							}else{
								mapItemValue.put("key","empty");
							}
						}else{
							mapItemValue.put("key", arraySku[i]);
						}
						if(!mapItemValue.get("key").equals("empty")){
							mapItemValueList.add(mapItemValue);
						}
					}
				}
			}
			mapTitle.put("skuValueList", mapItemValueList);
			mapTitle.put("skuList", skuList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mapTitle;
	}
}
