package com.wmeimob.yzfs.service.impl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.HomeCategoryMapper;
import com.wmeimob.yzfs.dao.SilderPicSettingsMapper;
import com.wmeimob.yzfs.model.HomeCategory;
import com.wmeimob.yzfs.model.HomeCategoryProduct;
import com.wmeimob.yzfs.model.SilderPicSettings;
import com.wmeimob.yzfs.service.HomeService;
import com.wmeimob.yzfs.util.UUIDUtil;
import com.wmeimob.yzfs.vo.HomeCategoryVO;
import com.wmeimob.yzfs.vo.SilderPicVO;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	SilderPicSettingsMapper silderPicMapper;

	@Autowired
	HomeCategoryMapper homeCategoryMapper;
	
	@Override
	public List<SilderPicVO> listSilderPics(String shopId) {
		return silderPicMapper.selectByShopId(shopId);
	}

	@Override
	public int updateSilderPic(String id, String picKey, int targetType, String targetId, String linkUrl,Integer rank) {
		SilderPicSettings silderPic = silderPicMapper.selectByPrimaryKey(id);
		silderPic.setTargetType((byte) targetType);
		silderPic.setUpdatedAt(new Date());
		silderPic.setPicKey(picKey);
		silderPic.setRank(rank);

		switch (targetType) {
		case 0: // 商品
			silderPic.setTargetId(targetId);
			break;
		case 1: // 店铺
			silderPic.setTargetId(targetId);
			break;
		case 2: // 链接
			silderPic.setLinkUrl(linkUrl);
			break;
		case 3: // 分类
			silderPic.setTargetId(targetId);
			break;
		default:
			break;
		}
		return silderPicMapper.updateByPrimaryKey(silderPic);
	}

	@Override
	public int deleteSilderPic(String picId) {
		SilderPicSettings SilderPic = silderPicMapper.selectByPrimaryKey(picId);
		SilderPic.setStatus(false);
		SilderPic.setUpdatedAt(new Date());
		return silderPicMapper.updateByPrimaryKey(SilderPic);
	}

	@Override
	public int disableSilderPic(String picId) {
		SilderPicSettings SilderPic = silderPicMapper.selectByPrimaryKey(picId);
		SilderPic.setIsDisabled(true);
		SilderPic.setUpdatedAt(new Date());
		return silderPicMapper.updateByPrimaryKey(SilderPic);
	}

	@Override
	public int addSilderPic(String picKey, Boolean picType, int targetType, String targetId, String linkUrl,Integer rank) {
		SilderPicSettings silderPic = new SilderPicSettings();
		Date date = new Date();
		silderPic.setCreatedAt(date);
		silderPic.setId(UUID.randomUUID().toString());
		silderPic.setIsDisabled(false);
		silderPic.setPicKey(picKey);
		silderPic.setPicType(picType);
		silderPic.setTargetType((byte) targetType);
		silderPic.setShopId("-1");
		silderPic.setUpdatedAt(date);
		silderPic.setStatus(true);
//		Integer rank = silderPicMapper.selectMaxRank();
		silderPic.setRank(rank);
		switch (targetType) {
		case 0: // 商品
			silderPic.setTargetId(targetId);
			break;
		case 1: // 店铺
			silderPic.setTargetId(targetId);
			break;
		case 2: // 链接
			silderPic.setLinkUrl(linkUrl);
			break;
		case 3: // 分类
			silderPic.setTargetId(targetId);
			break;
		default:
			break;
		}
		return silderPicMapper.insert(silderPic);
	}

	/**
	 * admin商品下架验证该商品是否存在在轮播图中，如果存在，提示不能下架
	 */
	@Override
	public SilderPicSettings verifyGoodExist(String goodId) {
		return silderPicMapper.verifyGoodExist(goodId);
	}
	
	
	/**
	 * 查询首页分类以及各分类下的商品
	 */
	@Override
	public List<HomeCategoryVO> selectHomeCategory(){
		return homeCategoryMapper.selectHomeCategory();
	}
	
	/**
	 * 新增首页分类
	 * @param request
	 * @return
	 */
	@Override
	public int insertHomeCategory(HttpServletRequest request){
		HomeCategory params=new  HomeCategory();
		params=getPublicHomeCategoryParams(request);
		return homeCategoryMapper.insertHomeCateGory(params);
	}
	
	/**
	 * 首页分类公共参数
	 * @param request
	 * @return
	 */
	public  HomeCategory getPublicHomeCategoryParams(HttpServletRequest request){
		HomeCategory params = new HomeCategory();
		String homeCateClass=request.getParameter("homeCateClass");//首页分类ID
		String type =request.getParameter("homeCateType");//首页分类类型
		String rank =request.getParameter("homeCateRank");//首页分类排序
		params.setId(UUIDUtil.generateUUID());
		params.setCategoryId(homeCateClass);
		if(StringUtils.isEmpty(type))
			params.setType(1);
		else
			params.setType(Integer.parseInt(type));
		if(StringUtils.isEmpty(rank))
			params.setRank(1);
		else
			params.setRank(Integer.parseInt(rank));
		params.setIsUse(true);//是否启用
		params.setIsDeleted(true);//是否删除
		params.setCreatedAt(new Date());
		params.setUpdatedAt(new Date());
		return params;
	}
	
	/**
	 * 新增首页分类商品
	 * @param request
	 * @return
	 */
	@Override
	public int insertHomeCategoryProduct(HttpServletRequest request){
		HomeCategoryProduct params = new HomeCategoryProduct();
		params=getPublicHomeCategoryProductParams(request);
		return homeCategoryMapper.insertHomeCateGoryProduct(params);
	}
	
	/**
	 * 首页分类商品公共参数
	 * @param request
	 * @return
	 */
	public  HomeCategoryProduct getPublicHomeCategoryProductParams(HttpServletRequest request){
		HomeCategoryProduct params = new HomeCategoryProduct();
		String homeCateId=request.getParameter("homeCateId");//首页分类ID
		String goodId =request.getParameter("goodId");//首页分类商品ID
		String spuKey =request.getParameter("spuKey");//首页分类商品图片key
		String rank =request.getParameter("homeCateRankP");//排序
		params.setId(UUIDUtil.generateUUID());
		params.setHomeCategoryId(homeCateId);
		params.setSpuId(goodId);
		params.setSpuKey(spuKey);
		if(StringUtils.isEmpty(rank))
			params.setRank(0);
		else
			params.setRank(Integer.parseInt(rank));
		params.setIsDeleted(true);//是否删除
		params.setCreatedAt(new Date());
		params.setUpdatedAt(new Date());
		return params;
	}
	
	/**
	 * 根据分类ID移除
	 */
	@Override
	public int updateCategoryById(@Param("id") String id){
		return homeCategoryMapper.updateCategoryById(id);
    }
	
	/**
	 * 根据分类商品ID移除商品
	 * @param id
	 * @return
	 */
	@Override
	public int deleteHomeCategoryProduct(String id){
		return homeCategoryMapper.updateCategoryProductById(id);
	}


}
