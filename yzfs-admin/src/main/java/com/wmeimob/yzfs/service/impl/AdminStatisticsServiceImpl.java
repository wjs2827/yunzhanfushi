package com.wmeimob.yzfs.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.service.AdminStatisticsService;
import com.wmeimob.yzfs.vo.DataStatisticsVO;

@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService {

	
	@Autowired
	private GoodsMapper  goodsMapper;
	
	@Autowired
	private UsersMapper  userMapper;

    /**
     * 商品销售统计
     * @param 
     * @return
     */
	@Override
	public List<DataStatisticsVO> queryGoodStatistics(DataStatisticsVO params) {
		return goodsMapper.queryGoodStatistics(params);
	}
	
    /**
     * 充值统计
     * @param 
     * @return
     */
	@Override
	public List<DataStatisticsVO> queryRechargeStatistics(DataStatisticsVO record) {
		return userMapper.queryRechargeStatistics(record);
	}
	
    /**
     * 佣金统计
     * @param 
     * @return
     */
	@Override
	public List<DataStatisticsVO> queryCommissionStatistics(DataStatisticsVO record) {
		return userMapper.queryCommissionStatistics(record);
	}
	
	

	
}
