package com.wmeimob.yzfs.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.EcGoodsClassesMapper;
import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.EcSkuPropertiesMapper;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.NecklineTypeMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.EcSkuProperties;
import com.wmeimob.yzfs.model.EcSkuPropertiesItem;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.vo.GoodsVO;

@Service
@Transactional(rollbackFor=Exception.class)
public class GoodServiceApi {

	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	EcGoodsClassesMapper ecGoodsClassesMapper;
	
	@Autowired
	EcGoodSkuMapper ecGoodSkuMapper;
	
	@Autowired
    EcSkuPropertiesMapper ecSkuPropertiesMapper;
	
	@Autowired
	private NecklineTypeMapper  necklineTypeMapper;
	
	@Autowired
	private EcNeckSkuMapper  ecNeckSkuMapper;
	
	/**
	 * 根据条件查询商品列表
	 * @param shopId
	 * @return
	 */
	public List<GoodsVO> querySilderListFromWX(HttpServletRequest request) throws CustomException{
		Goods params = new Goods();
		List<GoodsVO> list =null;
		try {
			String classId = request.getParameter("classesId");//商品二级分类
			String name = request.getParameter("name");//商品名称
			params.setClassesId(classId);
			params.setName(name);
			list = goodsMapper.queryGoodsListFromWX(params);
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return list;
	}
	
	
	/**
	 * 根据条件查询商品列表
	 * @param shopId
	 * @return
	 */
	public Goods queryGoodsItemFromWX(String id,Boolean isMade) throws CustomException{
		Goods params = new Goods();
		try {
			params.setId(id);
			
			//标准商品
			if(!isMade){
			   params=goodsMapper.queryGoodsItemFromWX(id);
			}else{
			//私人定制商品
			  params=goodsMapper.queryGoodsItemNeckFromWX(id);
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return params;
	}
	
	/**
	 * 根据商品ID查询商品富文本信息
	 * @param shopId
	 * @return
	 */
	public String queryGoodDetailsById(String id) throws CustomException{
		Goods params = new Goods();
		try {
			params.setId(id);
			params = goodsMapper.queryGoodDetailsById(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (params != null)
			return params.getDescriptions();
		else
			return null;
	}
	
	
	/**
	 *  根据条件查询商品分类列表
	 * @param shopId
	 * @return
	 */
	public List<GoodsClass> goodCategoryList(HttpServletRequest request) throws CustomException{
		return ecGoodsClassesMapper.queryCategoryListFromWX();
	}
	
	/**
	 * 根据商品分类查询商品所有属性
	 * @param shopId
	 * @return
	 */
	public List<Map<String,Object>> queryEcGoodSkuPropertiesFromWX(HttpServletRequest request,String classId,String spuId) throws CustomException{
		List<Map<String,Object>> returnDate =new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> data =null;
		Map<String,Object> datas =null;
		//查询某分类下属性列表
		List<EcSkuProperties> list=ecSkuPropertiesMapper.selectByPrimaryKey(classId);
		//查询商品下属性ID列表
		List<Map<String,Object>> itemList=queryEcGoodSkuListFromWX(request,spuId);
		for(EcSkuProperties sku:list){
			for(Map<String,Object> itemSku:itemList){
				System.out.println(itemSku.get("skuId"));
				System.out.println(sku.getId());
				if(itemSku.get("skuId").equals(sku.getId().toString())){
					data =new ArrayList<Map<String,Object>>();
					for(EcSkuPropertiesItem itemProperties:sku.getSkuItem()){
						datas =new HashMap<String,Object>();
						for(Map<String,Object> itemsSku:itemList){
							if(itemsSku.get("skuId").equals(itemProperties.getId().toString())){
								datas.put("key", itemProperties.getId());
								datas.put("val", itemProperties.getName());
								data.add(datas);
							}
						}
					}
					datas =new HashMap<String,Object>();
					datas.put("key", sku.getId());
					datas.put("val", sku.getSkuName());
					datas.put("item", data);
				}
			}
			returnDate.add(datas);
		}
		return returnDate;
	}
	
	
	
	/**
	 * 根据商品ID查询商品SKU列表
	 * @param shopId
	 * @return
	 */
	public List<Map<String,Object>> queryEcGoodSkuListFromWX(HttpServletRequest request,String spuId) throws CustomException{
		List<Map<String,Object>> skuList= new ArrayList<Map<String,Object>>();
		List<EcGoodSku> list =null;
		Map<String, Object> returnDate = null;
		try {
			list = ecGoodSkuMapper.selectByPrimaryKey(spuId);
			//解析JSON数据
			if(list!=null && list.size()>0){
				for(EcGoodSku sku:list){
					if(sku!=null && !StringUtils.isEmpty(sku.getSkuCode())){
						String[] skuCodeArry=sku.getSkuCode().split("_");
						for(int i=0;i<skuCodeArry.length;i++){
							int idx=0;
							returnDate = new HashMap<String, Object>();
							if(skuList!=null && skuList.size()>0){
								for(Map<String,Object> map:skuList){
									if(map.get("skuId").equals(skuCodeArry[i])){
										idx++;
									}
								}
						    }
							if(idx==0){
								returnDate.put("skuId", skuCodeArry[i]);
								skuList.add(returnDate);
								
							}
					}
				 }
					
				}
				
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return skuList;
	}
	
	/**
	 * 根据商品SKU编码查询SKU信息
	 * @param shopId
	 * @return
	 */
	public EcGoodSku queryEcGoodSkuFromWX(HttpServletRequest request,String spuCode,String id) throws CustomException{
		EcGoodSku sku =null;
		try {
			sku = ecGoodSkuMapper.queryGoodSkuBySkuCode(spuCode,id);
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return sku;
	}
	
	
	/**
	 * 根据商品分类查询商品所有属性
	 * @param shopId
	 * @return
	 */
	public List<Map<String, Object>> queryEcGoodNeckSkuPropertiesFromWX(HttpServletRequest request,String spuId) throws CustomException{
		List<Map<String, Object>> returnDates=new ArrayList<Map<String, Object>>();
		Map<String, Object> returnDate = new HashMap<String, Object>();
		List<String> itemList=queryEcGoodNeckSkuListFromWX(request,spuId);
		returnDate.put("neckLine",necklineTypeMapper.queryNecklineTypeListFromWX(itemList));
		returnDates.add(returnDate);
		returnDate = new HashMap<String, Object>();
		returnDate.put("neckFabric",necklineTypeMapper.queryNecklineFabricTypeListFromWX(itemList));
		returnDates.add(returnDate);
		return returnDates;
	}
	
	
	/**
	 *  根据商品ID查询商品可改装SKU属性ID
	 * @param shopId
	 * @return
	 */
	public List<String>  queryEcGoodNeckSkuListFromWX(HttpServletRequest request,String spuId) throws CustomException{
		List<String> returnList=new ArrayList<String>();
		List<Map<String,Object>> skuList= new ArrayList<Map<String,Object>>();
		List<EcNeckSku> list =null;
		Map<String, Object> returnDate = null;
		try {
			list=ecNeckSkuMapper.selectByPrimaryKey(spuId);
			//解析JSON数据
			if(list!=null && list.size()>0){
				for(EcNeckSku sku:list){
					if(sku!=null && !StringUtils.isEmpty(sku.getSkuCode())){
						String[] skuCodeArry=sku.getSkuCode().split("_");
						for(int i=0;i<skuCodeArry.length;i++){
							int idx=0;
							returnDate = new HashMap<String, Object>();
							if(skuList!=null && skuList.size()>0){
								for(Map<String,Object> map:skuList){
									if(map.get("neckId").equals(skuCodeArry[i])){
										idx++;
									}
								}
						    }
							if(idx==0){
								returnDate.put("neckId", skuCodeArry[i]);
								skuList.add(returnDate);
								returnList.add(skuCodeArry[i]);
							}
					}
				 }
					
				}
				
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return returnList;
	}
	
	
	/**
	 * 根据商品ID以及SKU编码查询可改装SKU信息
	 * @param shopId
	 * @return
	 */
	public EcNeckSku queryEcGoodNeckSkuFromWX(HttpServletRequest request,String spuCode,String id) throws CustomException{
		EcNeckSku sku =null;
		try {
			sku = ecNeckSkuMapper.queryGoodNeckSkuBySkuCode(spuCode,id);
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return sku;
	}
	
	
	
	
	
	
}
