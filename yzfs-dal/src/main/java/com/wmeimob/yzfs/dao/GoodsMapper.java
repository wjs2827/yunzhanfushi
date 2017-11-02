package com.wmeimob.yzfs.dao;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsComment;
import com.wmeimob.yzfs.vo.DataStatisticsVO;
import com.wmeimob.yzfs.vo.GoodClassListVO;
import com.wmeimob.yzfs.vo.GoodCommentRateVO;
import com.wmeimob.yzfs.vo.GoodDetailVO;
import com.wmeimob.yzfs.vo.GoodsVO;
import com.wmeimob.yzfs.vo.OrderItemsVO;

public interface GoodsMapper {
	int deleteByPrimaryKey(String id);
	
	/**
	 * 查询商品列表标准化
	 * @param goods
	 * @return
	 */
	List<GoodsVO> queryGoodsList(Goods goods);
	
	
	/**
	 *WX查询商品列表
	 * @param goods
	 * @return
	 */
	List<GoodsVO> queryGoodsListFromWX(Goods goods);
	
	/**
	 * WX查询商品是否存在
	 * @param id
	 * @return
	 */
	Goods queryGoodExistById(@Param("id") String id);
	
	/**
	 * WX根据商品ID查询标准商品信息
	 * @param id
	 * @return
	 */
	Goods queryGoodsItemFromWX(@Param("id") String id);
	
	/**
	 * WX根据商品ID查询私人定制商品信息
	 * @param id
	 * @return
	 */
	Goods queryGoodsItemNeckFromWX(@Param("id") String id);
	
	/**
	 * WX根据商品ID查询商品详情文本信息
	 * @param id
	 * @return
	 */
	Goods queryGoodDetailsById(@Param("id") String id);
	
	
	/**
	 * 验证商品编码是否存在
	 * @param goods
	 * @return
	 */
	List<GoodsVO> queryGoodsListBySpuCodeVerifyExist(Goods goods);

	/**
	 * 新增商品信息标准化
	 * @param record
	 * @return
	 */
	int insertSelective(Goods record);
	
	
	/**
	 * 根据商品ID查询商品信息
	 * 
	 * @param goods
	 * @return
	 */
	GoodsVO queryGoodById(Goods goods);
	
	/**
	 * Admin根据商品ID修改商品标准化
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Goods record);

	

	Goods selectByPrimaryKey(@Param("id") String id);



	int updateByPrimaryKeyWithBLOBs(Goods record);

	int updateByPrimaryKey(Goods record);


	

	/**
	 * 上下架
	 * 
	 * @param id
	 * @return
	 */
	int upAndDownFrame(String id);

	/**
	 * 根据二级分类查询所有的商品
	 * @param
	 * @return
	 */
	List<Goods> selectByShopId(@Param("classesId") String classesId);

	List<GoodsVO> queryShopGoodsRank(GoodsVO good, RowBounds rb);

	List<GoodsVO> homeGoods(GoodsVO good, RowBounds rb);
	
	Integer adminUpAndDown(@Param("id") String id);
	
    /**
     * 平台商品上下架或者删除
     * @param
     * @return
     */
	public Integer updateIsSale(Goods goods);

	// List<GoodsVO> selectByConditions(@Param("rank")String rank);
	/**
	 * 通过goodId查询商品详情(评论，图片，规格)
	 * 
	 * @param goodId
	 * @param userId TODO
	 * @return
	 */
	GoodDetailVO selectGoodDetailById(@Param("goodId")String goodId,@Param("userId") String userId);
	
	/**
	 * 查询商品的评论
	 * 
	 * @param goodId
	 * @return
	 */
	List<GoodsComment> selectGoodComments(@Param("goodId") String goodId, RowBounds rb);

	BigDecimal getMaxShippingFee(List<OrderItemsVO> orderItems);

	/**
	 * 获取类别和商品列表
	 * 
	 * @return
	 */
	List<GoodClassListVO> selectGoodClassList();
	/**
	 * 
	 * @param goodSpecId TODO
	 * @return
	 */
	GoodsVO selectGoodsBySpecId(@Param("goodSpecId") String goodSpecId);
	
	
    /**
     * 商品销售统计
     * @param goods
     * @return
     */
	List<DataStatisticsVO> queryGoodStatistics(DataStatisticsVO params);
	
	/**
	 * 商品好评率
	 * @param goodId
	 * @return
	 */
	GoodCommentRateVO getGoodCommentRate(String goodId);
	
	/**
	 * 商品描述
	 * @param goodId
	 * @return
	 */
	String getGoodDescriptions(@Param("goodId")String goodId);

	/**
	 * 立即购买查询购买的商品
	 * @param
     * @return
     */
	GoodsVO queryBuyNowGood(GoodsVO good);

	int selectLimitedGoodLastCount(@Param("goodId") String goodId, @Param("userId") String userId);
	
	/**
	 * 克隆商品
	 * @param g
     * @return
     */
	int copyGood(@Param("id") String id,@Param("goodId") String goodId);
	
	/**
	 * 根据一级或者二级分类查询所有的商品
	 * @param
	 * @return
	 */
	List<Goods> selectGoodListByCategoryId(GoodsVO params);
}