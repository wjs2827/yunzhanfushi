package com.wmeimob.yzfs.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.SilderPicSettings;
import com.wmeimob.yzfs.vo.HomeCategoryVO;
import com.wmeimob.yzfs.vo.SilderPicVO;


/**
 * 轮播图片和分类图片Service
 */
public interface HomeService {

	/**
	 * 获取列表
	 * 
	 * @param shopId
	 * @return
	 */
	List<SilderPicVO> listSilderPics(String shopId);

	/**
	 * 更新SilderPic
	 * 
	 * @param id
	 *            图片Id
	 * @param picKey
	 *            七牛图片key
	 * @param targetType
	 *            指向物品类别 0商品，1店铺，2链接，3分类
	 * @param targetId
	 *            根据类别插入不同的数据
	 * @param linkUrl
	 *            targetType为2时 插入linkUrl
	 * @return
	 */
	int updateSilderPic(String id, String picKey, int targetType, String targetId, String linkUrl,Integer rank);

	/**
	 * 删除SilderPic
	 * 
	 * @param picId
	 * @return
	 */
	int deleteSilderPic(String picId);

	/**
	 * 禁用
	 * 
	 * @param picId
	 * @return
	 */
	int disableSilderPic(String picId);

	/**
	 * 添加图片
	 * 
	 * @param picKey
	 *            图片key
	 * @param picType
	 *            图片类别 false轮播图 true分类导航
	 * @param targetType
	 *            指向物品类别 0商品，1店铺，2链接，3分类
	 * @param targetId
	 *            根据类别插入不同的数据
	 * @param linkUrl
	 *            targetType为2时 插入linkUrl
	 * @return
	 */
	int addSilderPic(String picKey, Boolean picType, int targetType, String targetId, String linkUrl,Integer rank);
	
	/**
	 * admin商品下架验证该商品是否存在在轮播图中，如果存在，提示不能下架
	 * @param goodId
	 * @return
	 */
	SilderPicSettings verifyGoodExist(@Param("goodId") String goodId);
	
	
	//最新功能

	/**
	 * 查询首页分类以及各分类下的商品
	 * @return
	 */
	List<HomeCategoryVO> selectHomeCategory();
	
	/**
	 * 新增首页分类
	 * @param request
	 * @return
	 */
	int insertHomeCategory(HttpServletRequest request);
	
	/**
	 * 新增首页分类商品
	 * @param request
	 * @return
	 */
	int insertHomeCategoryProduct(HttpServletRequest request);
	
	
	/**
	 * 根据分类ID移除
	 * @param id
	 * @return
	 */
	int updateCategoryById(String id);
	
	/**
	 * 根据分类商品ID移除商品
	 * @param id
	 * @return
	 */
	int deleteHomeCategoryProduct(String id);
}
