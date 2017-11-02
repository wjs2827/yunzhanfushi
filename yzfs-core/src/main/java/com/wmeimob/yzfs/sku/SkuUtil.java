package com.wmeimob.yzfs.sku;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class SkuUtil {
	
	
	/**
	 * 根据页面获取的SKU信息列表转换成JSON格式并返回JSON数据
	 * @return
	 */
	public static String ListSKUTOJSONInfo(List<Map<String,Object>> titleList,List<Map<String,Object>> valList){
		String mapperValue = "";
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			//存储SKU属性列名集合
			List<Map<String, Object>> skuKey = new ArrayList<Map<String, Object>>();
			//单SKU属性列名
			Map<String, Object> mapSkuKey = new HashMap<String, Object>();	
			//存储SKU属性列名开始
			mapSkuKey.put("id", "5001");
			mapSkuKey.put("name", "内存");
			skuKey.add(mapSkuKey);
			mapSkuKey = new HashMap<String, Object>();
			mapSkuKey.put("id", "5002");
			mapSkuKey.put("name", "颜色");
			skuKey.add(mapSkuKey);
			params.put("sku", skuKey);
			//存储SKU属性列名结束
			//存储SKU属性列名值集合
			List<Map<String, Object>> skuValue = new ArrayList<Map<String, Object>>();
			//单SKU属性列名值
			Map<String, Object> mapSkuValue = new HashMap<String, Object>();
			//存储SKU属性列名值开始
			mapSkuValue.put("key", "50010001");
			mapSkuValue.put("val", "64G");
			skuValue.add(mapSkuValue);
			mapSkuValue = new HashMap<String, Object>();
			mapSkuValue.put("key", "50020001");
			mapSkuValue.put("val", "白色");
			skuValue.add(mapSkuValue);
			params.put("skuval", skuValue);
			mapSkuValue = new HashMap<String, Object>();
			mapSkuValue.put("sku_attrs", params);
			//创建对象ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			try {
				//将map数据转换成JSON字符串
				mapperValue = mapper.writeValueAsString(mapSkuValue);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
		}
		return mapperValue;
		
	}
	
	
	/**
	 * 根据页面JSON转换成列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String JSONInfoTOSKU(String mapperValue){
		try {
			JSONObject json = JSONObject.parseObject(mapperValue);
			Map<String, Object> skuParams = json.getJSONObject("sku_attrs");
			List<Map<String, Object>> skuKeys = (List<Map<String, Object>>) skuParams.get("sku");
			List<Map<String, Object>> skuValues = (List<Map<String, Object>>) skuParams.get("skuval");
			for (int k = 0; k < skuKeys.size(); k++) {
				System.out.println("id:" + skuKeys.get(k).get("id"));
				System.out.println("name:" + skuKeys.get(k).get("name"));

			}
			for (int v = 0; v < skuValues.size(); v++) {
				System.out.println("key:" + skuValues.get(v).get("key"));
				System.out.println("val:" + skuValues.get(v).get("val"));

			} 
		} catch (Exception e) {
		}
		System.out.println();
		
		return mapperValue;
		
	}
	
	/**
	 * 根据两个数组找出两个数组不同的数据
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static <T> List<T> compare(T[] t1, T[] t2) {
	    List<T> list1 = Arrays.asList(t1);
	    List<T> list2 = new ArrayList<T>();
	    for (T t : t2) {
	      if (!list1.contains(t)) {
	        list2.add(t);
	      }
	    }
	    return list2;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
