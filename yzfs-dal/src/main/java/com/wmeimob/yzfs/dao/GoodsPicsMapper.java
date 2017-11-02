package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.GoodsPics;

public interface GoodsPicsMapper {
	
    /**
     * 批量添加图片
     * @param goodsPicses
     * @return
     */
    int insertBatch(List<GoodsPics> goodsPicses);
    
    /**
     * 通过商品id查询商品图片标准化
     * @param id
     * @return
     */
    public List<GoodsPics> selectByGoodsId(@Param("id")String id);

    /**
     * 通过商品id删除
     * @param goodsId
     * @return
     */
    public Integer deleteByGoodsId(String goodsId);
    
    /**
     * 克隆图片
     * @param goodsId
     * @return
     */
	int copyPic(@Param("id") String id,@Param("goodId") String goodId);
}