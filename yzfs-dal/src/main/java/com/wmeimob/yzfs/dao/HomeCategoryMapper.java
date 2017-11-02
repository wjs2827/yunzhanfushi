package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.HomeCategory;
import com.wmeimob.yzfs.model.HomeCategoryProduct;
import com.wmeimob.yzfs.vo.HomeCategoryVO;

public interface HomeCategoryMapper {
    
	/**
	 * 查询首页分类以及各首页分类下的商品
	 * @return
	 */
    List<HomeCategoryVO> selectHomeCategory();
    
	/**
	 * 查询首页分类以及各首页分类下的商品
	 * @return
	 */
    int insertHomeCateGory(HomeCategory params);
    
	/**
	 * 查询首页分类以及各首页分类下的商品
	 * @return
	 */
    int insertHomeCateGoryProduct(HomeCategoryProduct params);
    
	/**
	 * 根据分类ID移除
	 */
    int updateCategoryById(@Param("id") String id);
    
	/**
	 * 根据分类商品ID移除商品
	 * @return
	 */
    int updateCategoryProductById(@Param("id") String id);
    
    
}