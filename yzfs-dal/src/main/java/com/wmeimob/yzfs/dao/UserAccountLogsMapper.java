package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.UserAccountLogs;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;

public interface UserAccountLogsMapper {

	/**
	 * 新增用户余额日志信息
	 * @param record
	 * @return
	 */
    int insertSelective(UserAccountLogs record);

    /**
     * 查询用户余额日志记录
     * @param params
     * @return
     */
    List<UserAccountLogsVO> selectByPrimaryKey(UserAccountLogsVO params);
    
    /**
     * 根据充值流水号查询充值日志记录
     * @param payNo
     * @return
     */
    UserAccountLogsVO queryAccountLogByPayNo(@Param("payNo") String payNo);
    
    /**
     * WX查询用户余额日志记录
     * @param params
     * @return
     */
    List<UserAccountLogsVO> queryBalanceListByParams(UserAccountLogsVO params);
    
    int updateAccountById(@Param("id") String id);
    

}