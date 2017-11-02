package com.wmeimob.yzfs.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.vo.DataStatisticsVO;
import com.wmeimob.yzfs.vo.UserVO;

public interface UsersMapper {
	
	/**
	 * 新增用户信息
	 * @param record
	 * @return
	 */
    int insertSelective(User record);

    /**
     * 根据参数查询用户信息 
     * @param id
     * @return
     */
    User selectByPrimaryKey(User record);
    
    /**
     * 根据用户ID查询用户账户信息 
     * @param id
     * @return
     */
    User queryUserAccountInfo(@Param("userId") String userId);
    
	/**
	 * 查询用户信息以及校验用户是否已经注册 
	 * @param user
	 * @return
	 */
	List<User> queryUserByCondition(User user);

    /**
     * 根据用户ID修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

	/**
	 * 根据参数查询用户里列表信息
	 * @param record
	 * @return
	 */
	List<UserVO> selectUserListByParams(UserVO record);
	
	
    /**
     * 充值统计
     * @param goods
     * @return
     */
	List<DataStatisticsVO> queryRechargeStatistics(DataStatisticsVO params);
	
    /**
     * 佣金统计
     * @param goods
     * @return
     */
	List<DataStatisticsVO> queryCommissionStatistics(DataStatisticsVO params);
	
	
	
}