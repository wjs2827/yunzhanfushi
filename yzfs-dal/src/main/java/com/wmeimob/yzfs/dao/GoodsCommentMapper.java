package com.wmeimob.yzfs.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.GoodsComment;
import com.wmeimob.yzfs.model.GoodsCommentPic;
import com.wmeimob.yzfs.vo.GoodsCommentVO;

public interface GoodsCommentMapper {
	int deleteByPrimaryKey(String id);

	int insert(GoodsComment record);

	int insertSelective(GoodsComment record);
	
	/**
	 * 新增评论图片列表
	 * @param listPic
	 * @return
	 */
	int insertCommentPicList(List<GoodsCommentPic> listPic);

	GoodsComment selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(GoodsComment record);

	int updateByPrimaryKey(GoodsComment record);

	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	public List<GoodsCommentVO> queryCommentsInfo(Map<String, Object> map);

	/**
	 * 显示或者隐藏评论
	 * @param id
	 * @return
	 */
	public Integer deleteComments(GoodsCommentVO params);

	/**
	 * 插入评论
	 * 
	 * @param goodsCommentList
	 * @return
	 */
	int insertEvaluates(ArrayList<GoodsComment> goodsCommentList);
	
	/**
	 * 查看该订单明细是否已经评价
	 * @param goodsCommentList
	 * @return
	 */
	ArrayList<GoodsComment> selectByOrderItemsIds(@Param("list")ArrayList<GoodsComment> goodsCommentList);
	
	/**
	 * WX首页查询精彩评论
	 * @param goodsCommentList
	 * @return
	 */
	List<GoodsCommentVO> queryCommentsList(GoodsComment params);
	
	/**
	 * WX首页查询精彩评论图片列表
	 * @param goodsCommentList
	 * @return
	 */
	List<GoodsCommentPic> queryCommentsPicList(GoodsCommentPic params);
}