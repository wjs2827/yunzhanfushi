package com.wmeimob.yzfs.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wmeimob.yzfs.dao.UserAccountLogsMapper;
import com.wmeimob.yzfs.dao.UserCardLogsMapper;
import com.wmeimob.yzfs.dao.UserCardsMapper;
import com.wmeimob.yzfs.dao.UserCommissionAccountLogsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.UserCards;
import com.wmeimob.yzfs.service.UsersService;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCardsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;
import com.wmeimob.yzfs.vo.UserVO;

/**
 *
 * @Date 2016/7/27 11:23
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UsersServiceImpl implements UsersService {
	
	
	@Autowired
	private UsersMapper userMapper;
	
	@Autowired
	private UserCardsMapper  userCardsMapper;
	
	@Autowired
	private UserCardLogsMapper userCardLogsMapper;
	
	@Autowired
	private UserAccountLogsMapper userAccountLogsMapper;
	
	@Autowired
	private UserCommissionAccountLogsMapper userCommissionAccountLogsMapper;

	/**
	 * 查询用户信息列表
	 */
	@Override
	public List<UserVO> selectUserListByParams(UserVO params) {
		return userMapper.selectUserListByParams(params);
	}

	/**
	 * 查询积分流水
	 */
	@Override
	public List<UserCardLogsVO> selectPointsListByParams(UserCardLogsVO params) {
		return userCardLogsMapper.selectByPrimaryKey(params);
	}

	/**
	 * 查询充值列表
	 */
	@Override
	public List<UserAccountLogsVO> selectAccountListByParams(UserAccountLogsVO params) {
		return userAccountLogsMapper.selectByPrimaryKey(params);
	}

	/**
	 * 佣金记录
	 */
	@Override
	public List<UserCommissionAccountLogsVO> selectCommissionListByParams(UserCommissionAccountLogsVO params) {
		return userCommissionAccountLogsMapper.selectByPrimaryKey(params);
	}

	/**
	 * 根据账户信息变更用户信息
	 */
	@Override
	public Map<String, Object> changeUserInfo(UserCardLogsVO params) throws CustomException{
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//根据用户ID查询会员卡信息
			UserCardsVO record = new UserCardsVO();
			record.setUserId(params.getUserId());
			UserCards userCards = userCardsMapper.selectByPrimaryKey(record);
			if (userCards != null && userCards.getId() > 0) {
				record.setId(userCards.getId());
				record.setCardPoints(userCards.getCardPoints() - params.getChangePoints());
				params.setAccountPoints(userCards.getCardPoints());
				if (userCardsMapper.updateByPrimaryKeySelective(record) > 0) {
					//开始记录日志
					params.setChangedAt(new Date());
					params.setUpdatedAt(new Date());
					params.setCreatedAt(new Date());
					params.setUpdatedAt(new Date());
					params.setStatus(true);
					params.setUserCardId(userCards.getId());
					if (userCardLogsMapper.insertSelective(params) > 0) {
						map.put("code", 100);
						map.put("msg", "变更成功");
					} else {
						map.put("code", 404);
						map.put("msg", "系统异常");
					}
				} else {
					map.put("code", 404);
					map.put("msg", "变更失败");
				}
			} else {
				map.put("code", 404);
				map.put("msg", "会员卡不存在");
			} 
		} catch (Exception e) {
			map.put("code", 404);
			map.put("msg", "系统异常");
		}
		return map;
	}

	
	

}
