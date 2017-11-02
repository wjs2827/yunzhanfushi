package com.wmeimob.yzfs.dao;

import com.wmeimob.yzfs.model.UserAccounts;
import com.wmeimob.yzfs.vo.UserAccountsVO;

public interface UserAccountsMapper {

	/**
	 * 新增用户账户信息
	 * @param record
	 * @return
	 */
    int insertSelective(UserAccounts record);

    /**
     * 根据参数查询用户信息
     * @param params
     * @return
     */
    UserAccounts selectByPrimaryKey(UserAccountsVO params);

    /**
     * 编辑用户账户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserAccounts record);

}