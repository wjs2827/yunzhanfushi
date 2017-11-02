package com.wmeimob.yzfs.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcSkuProperties;

/**
 * Created by WMM07 on 2016/7/27.
 */
public interface SkuService {
	
  /**
   * 根据分类ID查询SKU以及子规格
   * @param id
   * @return
  */
  List<EcSkuProperties> selectByPrimaryKey(String categoryId);

  /**
   * 新增商品SKU属性以及属性值
   * @param request
   * @return
 * @throws CustomException 
   */
  Map<String,Object> addSkuInfo(HttpServletRequest request) throws CustomException;
  
  /**
   * 异步编辑商品SKU子规格属性值
   * @param request
   * @return
 * @throws CustomException 
   */
  Map<String,Object> editSkuInfo(HttpServletRequest request) throws CustomException;
  
  /**
   * 删除商品SKU属性以及属性值
   * @param request
   * @return
 * @throws CustomException 
   */
  Map<String,Object> delSkuInfo(HttpServletRequest request) throws CustomException;
	
	
}
