package com.wmeimob.yzfs.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wmeimob.yzfs.dao.EcGoodsClassesMapper;
import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.service.ClassifyService;
import com.wmeimob.yzfs.vo.GoodsClassVO;

/**
 * Created by zhongjing
 *
 * @Date 2016/7/29 11:56
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private EcGoodsClassesMapper goodsClassMapper;

    @Override
    @Transactional
    public int operateGoods(GoodsClass GoodsClass,String uid) {
        Integer count = 0;
        if(GoodsClass.getId()==null || GoodsClass.getId().isEmpty()){
            GoodsClass.setId(uid);
            GoodsClass.setStatus(true);
            GoodsClass.setParentId(GoodsClass.getParentId());
            count = goodsClassMapper.insert(GoodsClass);
        }else{
            count = goodsClassMapper.updateByPrimaryKeySelective(GoodsClass);
        }
        return count;
    }

    @Override
    public List<GoodsClassVO> queryGoodsClassList(GoodsClass GoodsClass) {
        return goodsClassMapper.queryGoodsClassList(GoodsClass);
    }
    
    
    /**
     * 查询总页数
     * @param GoodsClass
     * @return
     */
    @Override
    public GoodsClass queryGoodsCount(GoodsClass GoodsClass) {
        return goodsClassMapper.queryGoodsCount(GoodsClass);
    }


	@Override
	public List<GoodsClass> listAll() {
		List<GoodsClass> GoodsClass=goodsClassMapper.selectAll();
		return GoodsClass;
	}
	
	/**
	 * 查询所有一级分类
	 */
	@Override
	public List<GoodsClass> selectFirstClass() {
		List<GoodsClass> GoodsClass=goodsClassMapper.selectFirstClass();
		return GoodsClass;
	}

	/**
	 * 根据上级分类ID查询所有二级分类
	 */
	@Override
	public List<GoodsClassVO> queryErji(String id) {		
		return goodsClassMapper.queryErjilist(id);
	}
	
	/**
	 * 根据ID查询分类
	 */
	@Override
	public GoodsClassVO queryErjilistById(String id) {		
		return goodsClassMapper.queryErjilistById(id);
	}
}
