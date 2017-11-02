package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.RechargeRules;

public interface RechargeRulesMapper {

	/**
	 * 新增规则
	 * @param record
	 * @return
	 */
    int insert(RechargeRules record);

    /**
     * 查询规则
     * @param id
     * @return
     */
    List<RechargeRules> selectByPrimaryKey(RechargeRules record);

    /**
     * 修改规则
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RechargeRules record);
    
    
    /**
     * 新增规则
     * @param record
     * @return
     */
    int insertSelective(RechargeRules record);

    /**
     * 根据ID查询充值套餐
     * @param id
     * @return
     */
    RechargeRules selectByRuleId(@Param("id") String id);

}