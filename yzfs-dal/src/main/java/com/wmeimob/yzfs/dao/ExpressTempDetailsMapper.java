package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.ExpressTempDetails;

public interface ExpressTempDetailsMapper {
	
	
    /**
     * 批量新增运费模板信息列表
     * @param record
     * @return
     */
    int insertBatch(@Param("list")List<ExpressTempDetails> list);
    
    /**
     * 根据运费模板ID查询所有运费信息详情列表
     * @param id
     * @return
     */
    List<ExpressTempDetails> selectByPrimaryKeyList(Integer id);
    
    /**
     * 根据运费详情ID查询运费信息
     * @param id
     * @return
     */
    ExpressTempDetails selectByPrimaryKey(Integer id);
    
    
	/**
	 * 根据运费详情ID删除运费信息
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(@Param("id")Integer id);


    /**
     * 单个新增运费详情信息
     * @param record
     * @return
     */
    int insertSelective(ExpressTempDetails record);

   

    /**
     * 根据运费详情信息编辑 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ExpressTempDetails record);

}