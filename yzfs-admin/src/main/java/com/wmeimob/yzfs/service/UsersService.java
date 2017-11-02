package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;
import com.wmeimob.yzfs.vo.UserVO;

/**
 * Created by WMM07 on 2016/7/27.
 */
public interface UsersService {


	/**
	 * 查询用户信息列表
	 * @return
	 */
    public List<UserVO> selectUserListByParams(UserVO params);
    
	/**
	 * 查询积分流水
	 * @return
	 */
    public List<UserCardLogsVO> selectPointsListByParams(UserCardLogsVO params);
    
	/**
	 * 查询充值列表
	 * @return
	 */
    public List<UserAccountLogsVO> selectAccountListByParams(UserAccountLogsVO params);
    
	/**
	 * 查询佣金列表
	 * @return
	 */
    public List<UserCommissionAccountLogsVO> selectCommissionListByParams(UserCommissionAccountLogsVO params);
    

	/**
	 * 根据账户信息变更用户信息
	 * @return
	 * @throws CustomException 
	 */
    public Map<String,Object> changeUserInfo(UserCardLogsVO params) throws CustomException;
}
