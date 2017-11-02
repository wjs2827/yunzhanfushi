package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.vo.GoodsVO;
import com.wmeimob.yzfs.vo.ResultVO;

/**
 * Created by WMM07 on 2016/7/27.
 */
public interface GoodsService {
    /**
     * 添加商品
     * @param goodsInfoVo
     * @return
     * @throws CustomException 
     */
    public Map<String,Object> operateGoods(Goods goods,HttpServletRequest request) throws CustomException;


	/**
	 * 查询商品列表标准化
	 * @return
	 */
    public List<GoodsVO> queryGoodsList(Goods goods);
    
	/**
	 * 验证商品编码是否存在
	 * @param goods
	 * @return
	 */
    public Map<String,Object> queryGoodsListBySpuCodeVerifyExist(Goods goods);
    
    /**
     * 根据一级或者二级分类查询所有的商品
     * @param classId
     * @param type
     * @return
     */
    public List<Goods> selectGoodListByCategoryId(String classId,String type);
    
	/**
	 * 根据商品ID查询商品信息
	 * 
	 * @param goods
	 * @return
	 */
	public GoodsVO queryGoodById(Goods goods);
    
    /**
     * 根据分类ID查询商品
     * @param shopId
     * @return
     */
    public List<Goods> listGoods(String classId);
    
	/**
	 * 根据商品ID查询商品对应的SKU列表信息
	 * @param goods
	 * @return
	 */
    public Map<String,Object> queryGoodSkuListBySpuId(String spuId);
    
    
	/**
	 * 根据商品ID查询商品对应的统一SKU信息
	 * @param goods
	 * @return
	 */
    public EcGoodSku queryGoodSkuBySpuId(String spuId);
    
    
	/**
	 * 根据商品ID删除商品信息
	 * @param goods
	 * @return
	 * @throws CustomException 
	 */
    public ResultVO deleteGoodById(String spuId) throws CustomException;
    
	/**
	 * 上下架商品
	 * @param goods
	 * @return
	 * @throws CustomException 
	 */
    public boolean updateIsSale(Goods goods) throws CustomException;
    

}
