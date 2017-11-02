package com.wmeimob.yzfs.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.model.RechargeRules;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.vo.SysConfigsVO;

/**
 *  参数配置service
 */
public interface ConfigService {

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
    Map<String, Object> updateByPrimaryKeySelective(HttpServletRequest request);

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
     * 根据参数查询充值规则列表列表信息
     * @param id
     * @return
     */
    List<RechargeRules> queryRechargeRuleList(RechargeRules record);
    
    /**
     * 根据参数修改参数信息
     * @param record
     * @return
     */
    Map<String, Object> editConfigRecharge(HttpServletRequest request);
    
    /**
     * 删除或者启用停用充值规则
     * @param record
     * @return
     */
    Map<String, Object> delConfigRecharge(HttpServletRequest request);
	

}
