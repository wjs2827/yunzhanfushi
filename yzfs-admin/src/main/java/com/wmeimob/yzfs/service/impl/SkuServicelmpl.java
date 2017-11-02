package com.wmeimob.yzfs.service.impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.wmeimob.yzfs.dao.EcSkuPropertiesItemMapper;
import com.wmeimob.yzfs.dao.EcSkuPropertiesMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcSkuProperties;
import com.wmeimob.yzfs.model.EcSkuPropertiesItem;
import com.wmeimob.yzfs.service.SkuService;

/**
 * 商品管理
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SkuServicelmpl implements SkuService {
	
	
	@Autowired
	private EcSkuPropertiesMapper ecSkuPropertiesMapper;
	@Autowired
	private EcSkuPropertiesItemMapper ecSkuPropertiesItemMapper;
	
	/**
	 * 根据分类ID查询SKU以及子规格
	 */
	@Override
	public List<EcSkuProperties> selectByPrimaryKey(String categoryId) {
		return ecSkuPropertiesMapper.selectByPrimaryKey(categoryId);
	}
	
	/**
	 *  新增商品SKU属性以及属性值
	 */
	@Override
	public Map<String, Object> addSkuInfo(HttpServletRequest request) throws CustomException {
		Map<String, Object>  map = new HashMap<String,Object>();
		try {
			//获取SKU属性
			EcSkuProperties sku = new EcSkuProperties();
			String skuId = request.getParameter("skuId");//SKUID
			String classesId = request.getParameter("classesId");//分类ID
			String skuName = request.getParameter("skuVal");//SKU属性
			String allSkuItemVal = request.getParameter("allSkuItemVal");//SKU属性值
			String allSkuItemId=request.getParameter("allSkuItemId");//SKU属性ID
			EcSkuPropertiesItem skuItem;
			List<EcSkuPropertiesItem>  list= new ArrayList<EcSkuPropertiesItem>();
			if(StringUtils.isEmpty(skuName)){
				map.put("code", 200);
				map.put("msg", "规格名称不能为空!");
				return map;
			}
			if(StringUtils.isEmpty(allSkuItemVal)){
				map.put("code", 200);
				map.put("msg", "规格属性值不能为空!");
				return map;
			}
			if(StringUtils.isEmpty(skuId)){
				sku.setCategoryId(classesId);
				sku.setSkuName(skuName);
				sku.setIsDeleted(true);
				sku.setIsUsed(true);
				sku.setCreatedAt(new Date());
				sku.setUpdatedAt(new Date());
				ecSkuPropertiesMapper.insertSelective(sku);
				System.out.println(sku.getId());
				if (sku.getId() > 0) {
					//获取SKU属性明细信息参数
					String[] itemValList=allSkuItemVal.split(",");
					for(int i=0;i<itemValList.length;i++){
						skuItem = new EcSkuPropertiesItem();
						skuItem.setEcSkuPropertiesId(sku.getId());//父级规格名称
						skuItem.setName(itemValList[i]);//子级规格名称值
						skuItem.setIsDelete(true);
						skuItem.setCreatedAt(new Date());
						skuItem.setUpdateTime(new Date());
						skuItem.setRank(i+1);
						list.add(skuItem);
					}
					if (ecSkuPropertiesItemMapper.insertBatch(list) > 0) {
						map.put("code", 100);
						return map;
					} else {
						map.put("code", 200);
						map.put("msg", "操作失败!");
						return map;
					}
				} else {
					map.put("code", 200);
					map.put("msg", "操作失败!");
					return map;
				} 
			}else{
				//删除不在该ID范围内的所有属性值
				skuItem = new EcSkuPropertiesItem();
				skuItem.setEcSkuPropertiesId(Integer.parseInt(skuId));
				String[] listItem=allSkuItemId.split(",");
				List<String> list1 = Arrays.asList(listItem);
				List<String> listItem1 = new ArrayList<String>();
				List<String> delList = new ArrayList<String>();
				//查询该父类ID下的所有数据
				listItem1=ecSkuPropertiesItemMapper.selectByPrimaryKeyList(Integer.parseInt(skuId));
			    for (String t : listItem1) {
				      if (!list1.contains(t)) {
				    	  System.out.println("不同的数据："+t);
				    	  delList.add(t);
				      }
				}
			    if(delList!=null && delList.size()>0){
				  ecSkuPropertiesItemMapper.deleteByPrimaryBatch(delList);
			    }
				String[] listId=allSkuItemId.split(",");
				String[] listVal=allSkuItemVal.split(",");
				for(int v=0;v<listId.length;v++){
					if(listId[v].equals("1")){
						skuItem = new EcSkuPropertiesItem();	
						skuItem.setEcSkuPropertiesId(Integer.parseInt(skuId));//父级规格名称
						skuItem.setName(listVal[v]);//子级规格名称值
						skuItem.setIsDelete(true);
						skuItem.setCreatedAt(new Date());
						skuItem.setUpdateTime(new Date());
						skuItem.setRank(v);
						list.add(skuItem);
					}
				}
				if(list !=null && list.size()>0){
				if (ecSkuPropertiesItemMapper.insertBatch(list) > 0) {
					map.put("code", 100);
					return map;
				} else {
					map.put("code", 200);
					map.put("msg", "操作失败!");
					return map;
				}
				}else{
					map.put("code", 100);
					return map;
				}
			}
		} catch (Exception e) {
			throw new CustomException(200,"系统异常");
		}
		
	}

	/**
	 * 异步编辑商品SKU子规格属性值
	 */
	@Override
	public Map<String, Object> editSkuInfo(HttpServletRequest request) throws CustomException {
		Map<String, Object>  map = new HashMap<String,Object>();
		try {
			//获取SKU属性
			EcSkuPropertiesItem skuItem = new EcSkuPropertiesItem();
			int skuId = Integer.parseInt(request.getParameter("skuId"));//分类ID
			String skuItemId = request.getParameter("skuItemId");//SKU属性ID
			String skuItemVal = request.getParameter("skuItemVal");//SKU属性
			skuItem.setEcSkuPropertiesId(skuId);
			skuItem.setName(skuItemVal);
			if(StringUtils.isEmpty(skuItemId)){
				skuItem.setCreatedAt(new Date());
				skuItem.setUpdateTime(new Date());
				skuItem.setIsDelete(true);
				skuItem.setRank(0);//索引排序
				if (ecSkuPropertiesItemMapper.insertSelective(skuItem) > 0) {
					map.put("code", 100);
					return map;
				} else {
					map.put("code", 200);
					map.put("msg", "操作失败!");
					return map;
				}
			}
		}catch (Exception e) {
			throw new CustomException(200,"系统异常");
		}
		return map;
	}

	/**
	 * 异步删除商品SKU属性以及属性值
	 */
	@Override
	public Map<String, Object> delSkuInfo(HttpServletRequest request) throws CustomException {
		Map<String, Object>  map = new HashMap<String,Object>();
		try {
			//获取SKU属性
			int skuId = Integer.parseInt(request.getParameter("skuId"));//分类ID
			if (ecSkuPropertiesMapper.deleteByPrimaryKey(skuId) > 0) {
				if(ecSkuPropertiesItemMapper.deleteByPrimaryKeyByParentId(skuId)>0){
				  map.put("code", 100);
				  return map;
				}else{
				  map.put("code", 200);
				  map.put("msg", "操作失败!");
				  return map;
				}
			} else {
				map.put("code", 200);
				map.put("msg", "操作失败!");
				return map;
			}
		}catch (Exception e) {
			throw new CustomException(200,"系统异常");
		}
	}
}
