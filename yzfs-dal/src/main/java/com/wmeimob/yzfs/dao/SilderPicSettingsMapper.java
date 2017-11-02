package com.wmeimob.yzfs.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.SilderPicSettings;
import com.wmeimob.yzfs.vo.SilderPicVO;

public interface SilderPicSettingsMapper {
	int deleteByPrimaryKey(String id);

	int insert(SilderPicSettings record);

	int insertSelective(SilderPicSettings record);

	SilderPicSettings selectByPrimaryKey(String id);
	
	/**
	 * admin商品下架验证该商品是否存在在轮播图中，如果存在，提示不能下架
	 * @param goodId
	 * @return
	 */
	SilderPicSettings verifyGoodExist(@Param("goodId") String goodId);
	
	int updateByPrimaryKeySelective(SilderPicSettings record);

	int updateByPrimaryKey(SilderPicSettings record);

	/**
	 * shopId搜索SliderPic列表
	 * 
	 * @param shopId
	 * @return
	 */
	List<SilderPicVO> selectByShopId(@Param("shopId") String shopId);
	
	/**
	 * 获取最大rank值
	 * @return
	 */
	Integer selectMaxRank();
	
	
	/**
	 *  WX端查询首页轮播图
	 * @param record
	 * @return
	 */
	List<SilderPicVO> querySilderListFromWX(SilderPicSettings record);
}