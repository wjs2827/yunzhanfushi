package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.RightsOrdersLogs;

public interface RightsOrdersLogsMapper {

	/**
	 * 新增退款进度记录
	 * @param record
	 * @return
	 */
    int insertSelective(RightsOrdersLogs record);

    /**
     * 根据维权订单ID查询维权处理进度明细
     * @param id
     * @return
     */
    List<RightsOrdersLogs> selectByPrimaryKey(@Param("rightsOrderId")Integer id);
}