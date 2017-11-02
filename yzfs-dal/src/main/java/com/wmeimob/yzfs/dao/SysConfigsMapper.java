package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.vo.SysConfigsVO;

public interface SysConfigsMapper {
	
	/**
	 * 新增参数设置信息
	 * @param record
	 * @return
	 */
    int insertSelective(SysConfigs record);
    
    /**
     * 根据参数修改参数信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysConfigs record);

    /**
     * 根据参数查询单个参数信息
     * @param id
     * @return
     */
    SysConfigsVO querySysConfigByParams(SysConfigs record);
    
    /**
     * 根据参数查询参数列表信息
     * @param id
     * @return
     */
    List<SysConfigsVO> queryListByParams(SysConfigs record);
    /**
     * 根据config_code 查询参数值
     * @param code
     * @return
     */
    SysConfigs querySysConfigByCode(@Param("configCode")String configCode);

 

}