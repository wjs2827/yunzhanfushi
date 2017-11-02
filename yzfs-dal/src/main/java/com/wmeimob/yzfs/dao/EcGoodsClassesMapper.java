package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.vo.GoodsClassVO;

public interface EcGoodsClassesMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    GoodsClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);

    /**
     * 查询
     * @param GoodsClass
     * @return
     */
    List<GoodsClassVO> queryGoodsClassList(GoodsClass GoodsClass);
    
    
    /**
     * 查询总页数
     * @param GoodsClass
     * @return
     */
    GoodsClass queryGoodsCount(GoodsClass GoodsClass);
    
    /**
     * 查询所有的子分类
     * @return
     */
    List<GoodsClass> selectAll();
    
    /**
     * 查询所有的一级分类
     * @return
     */
    List<GoodsClass> selectFirstClass();
    
    /**
     * 查询商品二级分类
     * @param id
     * @return
     */
	List<GoodsClassVO> queryErjilist(@Param("id")String id);
	
    /**
     * 根据ID查询分类
     * @param id
     * @return
     */
	GoodsClassVO queryErjilistById(@Param("id")String id);
	
	
    /**
     * 根据条件查询商品一级和二级分类列表
     * @param GoodsClass
     * @return
     */
    List<GoodsClass> queryCategoryListFromWX();
}