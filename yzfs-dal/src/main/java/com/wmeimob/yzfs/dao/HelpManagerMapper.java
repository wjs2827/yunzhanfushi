package com.wmeimob.yzfs.dao;

import com.wmeimob.yzfs.model.HelpManager;
import com.wmeimob.yzfs.vo.HelpManagerVO;

public interface HelpManagerMapper {
	
	/**
	 * 根据参数修改帮助或者推广页信息
	 * @param record
	 * @return
	 */
	HelpManagerVO queryHelpList(HelpManager record);
	
	/**
	 * 新增帮助或者推广页内容信息
	 * @param record
	 * @return
	 */
    int insertSelective(HelpManager record);
    
    /**
     * 修改帮助或者推广页内容信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(HelpManager record);
}