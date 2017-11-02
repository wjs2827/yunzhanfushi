package com.wmeimob.yzfs.api.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wmeimob.yzfs.dao.GoodsCommentMapper;
import com.wmeimob.yzfs.dao.HomeCategoryMapper;
import com.wmeimob.yzfs.dao.SilderPicSettingsMapper;
import com.wmeimob.yzfs.model.GoodsComment;
import com.wmeimob.yzfs.model.SilderPicSettings;
import com.wmeimob.yzfs.vo.GoodsCommentVO;
import com.wmeimob.yzfs.vo.HomeCategoryVO;
import com.wmeimob.yzfs.vo.SilderPicVO;

@Service
@Transactional(rollbackFor=Exception.class)
public class HomeServiceApi {

	@Autowired
	SilderPicSettingsMapper silderPicMapper;
	
	@Autowired
	HomeCategoryMapper homeCategoryMapper;
	
    @Autowired
    private GoodsCommentMapper commentMapper;
	
	/**
	 * 查询首页轮播图
	 * @param shopId
	 * @return
	 */
	public List<SilderPicVO> querySilderListFromWX(HttpServletRequest request){
		SilderPicSettings params = new SilderPicSettings();
		return silderPicMapper.querySilderListFromWX(params);
	}
	
	/**
	 *  查询首页分类以及商品详情列表
	 */
	public List<HomeCategoryVO> selectHomeCategory(){
		return homeCategoryMapper.selectHomeCategory();
	}
	


    /**
     * 首页查询精彩评论
     */
    public List<GoodsCommentVO> queryCommentsInfo(GoodsComment params) {
        return commentMapper.queryCommentsList(params);
    }
	
}
