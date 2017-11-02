package com.wmeimob.yzfs.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.RechargeRulesMapper;
import com.wmeimob.yzfs.dao.SysConfigsMapper;
import com.wmeimob.yzfs.model.RechargeRules;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.service.ConfigService;
import com.wmeimob.yzfs.util.CheckUtils;
import com.wmeimob.yzfs.vo.SysConfigsVO;



/**
 * 参数配置实现类
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ConfigServiceImpl implements ConfigService {
	
	 @Autowired
	 private  SysConfigsMapper sysConfigsMapper;
	 
	 @Autowired
	 private  RechargeRulesMapper rechargeRulesMapper;

	/**
	 * 新增参数设置信息
	 * @param record
	 * @return
	 */
	@Override
	public int insertSelective(SysConfigs record) {
		return sysConfigsMapper.insertSelective(record);
	}

    /**
     * 根据参数修改参数信息
     * @param record
     * @return
     */
	@Override
	public Map<String, Object> updateByPrimaryKeySelective(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysConfigs record = new SysConfigs();
			String id = request.getParameter("id");//表ID
			String value = request.getParameter("value");//参数值
			String status=request.getParameter("status");
			if (StringUtils.isEmpty(value)) {
				map.put("code", "200");
				map.put("msg", "亲!参数值不能为空!");
				return map;
			} else {
				if (!CheckUtils.IsIntDoubleInteger(value)) {
					map.put("code", "200");
					map.put("msg", "亲!参数不合法!");
					return map;
				}
			}
			if(!StringUtils.isEmpty(status)){
				if("0".equals(status)){
					record.setStatus(false);
				}else{
					record.setStatus(true);
				}
			}
			record.setId(id);
			record.setConfigValue(new BigDecimal(value));
			record.setUpdatedAt(new Date());
			int result = sysConfigsMapper.updateByPrimaryKeySelective(record);
			if (result > 0) {
				map.put("code", "100");
				map.put("msg", "操作成功");
			} else {
				map.put("code", "200");
				map.put("msg", "网络异常,请稍后重试!");
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

    /**
     * 根据参数查询单个参数信息
     * @param id
     * @return
     */
	@Override
	public SysConfigsVO querySysConfigByParams(SysConfigs record) {
		return sysConfigsMapper.querySysConfigByParams(record);
	}

    /**
     * 根据参数查询参数列表信息
     * @param id
     * @return
     */
	@Override
	public List<SysConfigsVO> queryListByParams(SysConfigs record) {
		return sysConfigsMapper.queryListByParams(record);
	}
	
    /**
     * 根据参数查询充值规则列表列表信息
     * @param id
     * @return
     */
	@Override
	public  List<RechargeRules> queryRechargeRuleList(RechargeRules record){
    	return rechargeRulesMapper.selectByPrimaryKey(record);
    }
	
    /**
     * 根据参数修改参数信息
     * @param record
     * @return
     */
	@Override
	public Map<String, Object> editConfigRecharge(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			RechargeRules record = new RechargeRules();
			String id = request.getParameter("id");//表ID
			String rechargeAmount = request.getParameter("rechargeAmount");//充值金额
			String remark = request.getParameter("remark");//备注
			String attachAmount = request.getParameter("attachAmount");//增加余额
			if (StringUtils.isEmpty(rechargeAmount)) {
				map.put("code", "200");
				map.put("msg", "亲!充值金额不能为空!");
				return map;
			} else {
				if (!CheckUtils.IsIntDoubleInteger(rechargeAmount)) {
					map.put("code", "200");
					map.put("msg", "亲!充值金额不合法!");
					return map;
				}
			}
			if (StringUtils.isEmpty(remark)) {
				map.put("code", "200");
				map.put("msg", "亲!充值文字不能为空!");
				return map;
			}
			if (StringUtils.isEmpty(attachAmount)) {
				map.put("code", "200");
				map.put("msg", "亲!增加余额不能为空!");
				return map;
			} else {
				if (!CheckUtils.IsIntDoubleInteger(attachAmount)) {
					map.put("code", "200");
					map.put("msg", "亲!增加余额不合法!");
					return map;
				}
			}
			record.setId(id);
			record.setRechargeAmount(new BigDecimal(rechargeAmount));
			record.setAttachAmount(new BigDecimal(attachAmount));
			record.setRemark(remark);
			if (!StringUtils.isEmpty(record.getId())) {
				record.setUpdatedAt(new Date());
				int result = rechargeRulesMapper.updateByPrimaryKeySelective(record);
				if (result > 0) {
					map.put("code", "100");
					map.put("msg", "修改成功");
				} else {
					map.put("code", "200");
					map.put("msg", "网络异常,请稍后重试!");
				}
			} else {
				record.setId(UUID.randomUUID().toString().replace("-", ""));
				record.setCreatedAt(new Date());
				record.setIsUsed(false);
				record.setStatus(true);
				int result = rechargeRulesMapper.insertSelective(record);
				if (result > 0) {
					map.put("code", "100");
					map.put("msg", "新增成功");
				} else {
					map.put("code", "200");
					map.put("msg", "网络异常,请稍后重试!");
				}
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	
	
    /**
     * 启用或修改删除充值规则
     * @param record
     * @return
     */
	@Override
	public Map<String, Object> delConfigRecharge(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			RechargeRules record = new RechargeRules();
			String id = request.getParameter("id");//表ID
			String value = request.getParameter("value");//充值金额
			record.setId(id);
			if (!StringUtils.isEmpty(value)&&"del".equals(value)){
				record.setUpdatedAt(new Date());
				record.setStatus(false);
				record.setIsUsed(false);
				int result = rechargeRulesMapper.updateByPrimaryKeySelective(record);
				if (result > 0) {
					map.put("code", "100");
					map.put("msg", "删除成功");
				} else {
					map.put("code", "200");
					map.put("msg", "网络异常,请稍后重试!");
				}
			}else{
				record.setUpdatedAt(new Date());
				String msg="";
				if(!StringUtils.isEmpty(value)&&"0".equals(value)){
					record.setIsUsed(false);
					msg="停用成功";
				}else{
					record.setIsUsed(true);
					msg="启用成功";
				}
				int result = rechargeRulesMapper.updateByPrimaryKeySelective(record);
				if (result > 0) {
					map.put("code", "100");
					map.put("msg", msg);
				} else {
					map.put("code", "200");
					map.put("msg", "网络异常,请稍后重试!");
				}
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

	
}
