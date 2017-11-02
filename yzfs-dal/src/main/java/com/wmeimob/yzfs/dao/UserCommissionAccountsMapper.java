package com.wmeimob.yzfs.dao;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.UserCommissionAccounts;
import com.wmeimob.yzfs.vo.UserCommissionAccountsVO;

public interface UserCommissionAccountsMapper {

	/**
	 * 新增用户佣金信息
	 * @param record
	 * @return
	 */
    int insertSelective(UserCommissionAccounts record);

    /**
     * 查询用户佣金信息
     * @param params
     * @return
     */
    UserCommissionAccounts selectByPrimaryKey(UserCommissionAccounts params);

    /**
     * 根据参数修改用户佣金信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserCommissionAccountsVO record);
    
    /**
     * 根据用户ID查询用户佣金信息
     * @param userId
     * @return
     */
    UserCommissionAccounts queryCommissionByUserId(@Param("userId") String userId);

}