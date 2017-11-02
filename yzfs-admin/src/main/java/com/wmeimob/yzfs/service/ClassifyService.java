package com.wmeimob.yzfs.service;
import java.util.List;

import com.wmeimob.yzfs.model.GoodsClass;
import com.wmeimob.yzfs.vo.GoodsClassVO;

/**
 * Created by zhongjing
 *
 * @Date 2016/7/29 11:51
 */
public interface ClassifyService {
	/**
	 * 操作
	 * 
	 * @param GoodsClass
	 * @return
	 */
	public int operateGoods(GoodsClass GoodsClass,String uid);

	/**
	 * 查询
	 * 
	 * @param GoodsClass
	 * @return
	 */
	public List<GoodsClassVO> queryGoodsClassList(GoodsClass GoodsClass);
	
	
    /**
     * 查询总页数
     * @param GoodsClass
     * @return
     */
    public GoodsClass queryGoodsCount(GoodsClass GoodsClass);

	/**
	 * 查询所有的子分类
	 * 
	 * @return
	 */
	List<GoodsClass> listAll();
	
	/**
	 * 查询所有一级分类
	 */
	public List<GoodsClass> selectFirstClass();
	
    /**
     * 查询商品二级分类
     * @param id
     * @return
     */
	public List<GoodsClassVO> queryErji(String id);
	
    /**
     * 根据ID查询分类
     * @param id
     * @return
     */
	public GoodsClassVO queryErjilistById(String id);
}
