package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.model.GoodsShow;
import com.wmeimob.yzfs.model.OrderItem;
import com.wmeimob.yzfs.model.Thumbs;

public interface GoodsShowMapper {

	/**
	 * 根据id查询买家秀
	 * 
	 * @param id
	 * @return
	 */
	GoodsShow selectByPrimaryKey(GoodsShow goodsShow);

	/**
	 * WX查询买家秀列表信息
	 * 
	 * @param record
	 * @return
	 */
	List<GoodsShow> queryShowListByParamsFromWX(GoodsShow record);

	/**
	 * 新增买家秀信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(GoodsShow record);

	/**
	 * 修改买家秀信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(GoodsShow record);

	/**
	 * 查询可发布的买家秀订单明细
	 * 
	 * @param GoodsShow
	 * @return
	 */
	List<OrderItem> queryOrderItemListByParamsFromWX(OrderItem param);

	/**
	 * 更新点赞状态
	 * @param id
	 * @return
	 */
	int updateThumbsByPrimaryKeySelective(Thumbs thumbs);
	
	/**
	 * 新增点赞记录
	 * @param thumbs
	 * @return
	 */
	int insertSelectiveThumbs(Thumbs thumbs);
	
	/**
	 * 查询点赞记录
	 * @param thumbs
	 * @return
	 */
	Thumbs selectThumbs(Thumbs thumbs);
	
}