package com.wmeimob.yzfs.service;
import java.util.List;
import com.wmeimob.yzfs.vo.DataStatisticsVO;

public interface AdminStatisticsService {
	
	
	/**
	 * 商品销售统计
	 */
	List<DataStatisticsVO> queryGoodStatistics(DataStatisticsVO params);
	
	
	/**
	 * 充值统计
	 */
	List<DataStatisticsVO> queryRechargeStatistics(DataStatisticsVO record);
	
	
	
	/**
	 * 佣金统计
	 */
	List<DataStatisticsVO> queryCommissionStatistics(DataStatisticsVO record);
	
}
