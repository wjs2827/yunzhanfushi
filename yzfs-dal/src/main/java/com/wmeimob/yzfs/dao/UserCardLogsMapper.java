package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.vo.UserCardLogsVO;

public interface UserCardLogsMapper {

	/**
	 * 新增会员金币记录
	 * @param record
	 * @return
	 */
    int insertSelective(UserCardLogsVO record);

    /**
     * 查询会员金币记录列表
     * @param record
     * @return
     */
    List<UserCardLogsVO> selectByPrimaryKey(UserCardLogsVO record);
    
    /**
     * WX查询会员金币记录列表
     * @param record
     * @return
     */
    List<UserCardLogsVO> myCardLogRecord(UserCardLogsVO record);
    

}