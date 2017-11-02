package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.model.ReadingRewards;
import com.wmeimob.yzfs.model.ReadingRewardsRecord;
import com.wmeimob.yzfs.vo.ReadingRewardsRecordVO;
import com.wmeimob.yzfs.vo.ReadingRewardsVO;

/**
 *  阅读文章service
 */
public interface ReadingRewardsService {


    /**
     * 编辑新增阅读任务信息
     * @param record
     * @return
     */
    Map<String,Object> editAndSaveReadingRewardsInfo(HttpServletRequest request);
    
	/**
	 * 删除或者启用关闭阅读任务
	 * @param record
	 * @return
	 */
    Map<String,Object> isUse(String id,Boolean isUse,Boolean  isDeleted);

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
    List<ReadingRewardsVO> queryReadingRewardsListByParams(ReadingRewards request);
    
    /**
     * 根据参数查询多条阅读记录信息
     * @param id
     * @return
     */
    List<ReadingRewardsRecordVO> queryReadingRewardsRecordListByParams(ReadingRewardsRecord record );
	
	
	

}
