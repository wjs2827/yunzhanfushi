package com.wmeimob.yzfs.dao;

import com.wmeimob.yzfs.model.UserCards;
import com.wmeimob.yzfs.vo.UserCardsVO;

public interface UserCardsMapper {

	
	/**
	 * 根据参数新增会员卡信息
	 * @param record
	 * @return
	 */
    void insertSelective(UserCardsVO record);

    /**
     * 根据参数查询会员卡信息
     * @param id
     * @return
     */
    UserCards selectByPrimaryKey(UserCardsVO record);

    /**
     * 根据参数修改会员卡信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserCardsVO record);

}