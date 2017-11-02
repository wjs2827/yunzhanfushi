package com.wmeimob.yzfs.dao;
import java.util.List;

import com.wmeimob.yzfs.model.NecklineFabricType;
import com.wmeimob.yzfs.model.NecklineType;
public interface NecklineTypeMapper {
	
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
	 * WX查询领口信息列表
	 * @param params
	 * @return
	 */
    List<NecklineType> queryNecklineTypeListFromWX(List<String> list);
    
    /**
     * WX查询布料信息列表
     * @param params
     * @return
     */
    List<NecklineFabricType> queryNecklineFabricTypeListFromWX(List<String> list);
    
    /**
     * 新增领口信息 
     * @param params
     * @return
     */
    int insertNecklineType(NecklineType params);
    
    /**
     * 新增布料信息信息
     * @param params
     * @return
     */
    int insertNecklineFabricType(NecklineFabricType params);
    
    /**
     * 根据参数修改领口信息
     * @param params
     * @return
     */
    int updateNecklineTypeByParams(NecklineType params);
    
    /**
     * 根据参数修改布料信息
     * @param params
     * @return
     */
    int updateNecklineFabricTypeByParams(NecklineFabricType params);
    
}