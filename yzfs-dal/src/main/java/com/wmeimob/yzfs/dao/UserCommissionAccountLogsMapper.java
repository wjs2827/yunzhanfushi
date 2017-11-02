package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;

public interface UserCommissionAccountLogsMapper {

	/**
	 * 新增用户佣金日志记录
	 * @param record
	 * @return
	 */
    int insertSelective(UserCommissionAccountLogsVO record);

    /**
     * Admin查询用户佣金日志记录信息
     * @param params
     * @return
     */
    List<UserCommissionAccountLogsVO> selectByPrimaryKey(UserCommissionAccountLogsVO params);
    
    /**
     * WX查询用户佣金日志记录信息
     * @param params
     * @return
     */
    List<UserCommissionAccountLogsVO> queryCommissionListByParams(UserCommissionAccountLogsVO params);
}