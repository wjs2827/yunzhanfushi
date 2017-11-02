package com.wmeimob.yzfs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.ReadingRewards;
import com.wmeimob.yzfs.model.ReadingRewardsRecord;
import com.wmeimob.yzfs.vo.ReadingRewardsRecordVO;
import com.wmeimob.yzfs.vo.ReadingRewardsVO;

/**
 * admin 阅读文章获取积分
 * @author WMM08
 *
 */
public interface ReadingRewardsMapper {

	/**
	 * 新增阅读任务信息
	 * @param record
	 * @return
	 */
    int insertSelective(ReadingRewards record);
    

    /**
     * 根据参数修改阅读任务信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ReadingRewards record);

    /**
     * 根据参数查询单个阅读任务信息
     * @param id
     * @return
     */
    ReadingRewardsVO queryReadingRewardsByParams(ReadingRewards record);
    
    /**
     * 根据参数查询阅读任务列表信息
     * @param id
     * @return
     */
    List<ReadingRewardsVO> queryReadingRewardsListByParams(ReadingRewards record);
    
    
	/**
	 * 新增阅读记录信息
	 * @param record
	 * @return
	 */
    int insertSelectiveReadRecord(ReadingRewardsRecord record);
    
    
    /**
     * 根据参数查询多条阅读记录信息
     * @param id
     * @return
     */
    List<ReadingRewardsRecordVO> queryReadingRewardsRecordListByParams(ReadingRewardsRecord record);

    /***
     * 查询用户阅读列表
     * @param openId
     * @return
     */
	List<ReadingRewardsVO> selectReadListByOpenId(@Param("openId")String openId);
    /***
     * 查询当天的阅读记录    
     * @param recordVO
     * @return
     */
	List<ReadingRewardsRecordVO> queryReadingRewardsRecordListToday(ReadingRewardsRecordVO recordVO);
    
}