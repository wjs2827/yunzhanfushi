package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.model.NecklineFabricType;
import com.wmeimob.yzfs.model.NecklineType;

/**
 * 管理员表
 */
public interface NeckLineService {
	
	/**
	 * 查询领口信息列表
	 * @param params
	 * @return
	 */
    List<NecklineType> queryNecklineTypeList(NecklineType params);
    
    /**
     * 查询布料信息列表
     * @param params
     * @return
     */
    List<NecklineFabricType> queryNecklineFabricTypeList(NecklineFabricType params);
    
    /**
     * 新增领口信息 
     * @param params
     * @return
     */
    int insertNecklineType(HttpServletRequest request);
    
    /**
     * 新增布料信息信息
     * @param params
     * @return
     */
    int insertNecklineFabricType(HttpServletRequest request);
    
    /**
     * 根据参数修改领口信息
     * @param params
     * @return
     */
    int updateNecklineTypeByParams(HttpServletRequest request);
    
    /**
     * 根据参数修改布料信息
     * @param params
     * @return
     */
    int updateNecklineFabricTypeByParams(HttpServletRequest request);
    
	/**
	 * 根据商品ID查询商品对应的私人定制SKU列表信息
	 * @param goods
	 * @return
	 */
    public Map<String,Object> queryNeckSkuListBySpuId(String spuId);

}
