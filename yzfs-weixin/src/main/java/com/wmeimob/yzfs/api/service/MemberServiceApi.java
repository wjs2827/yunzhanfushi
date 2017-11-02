package com.wmeimob.yzfs.api.service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wmeimob.wechat.model.user.WxUserInfoBase;
import com.wmeimob.yzfs.dao.CartMapper;
import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.OrderItemSkuMapper;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.vo.UserVO;

@Service
@Transactional(rollbackFor=Exception.class)
public class MemberServiceApi {

	@Autowired
	EcGoodSkuMapper ecGoodSkuMapper;
	
	@Autowired
	EcNeckSkuMapper ecNeckSkuMapper;
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	OrderItemsMapper orderItemsMapper;
	
	@Autowired
	OrderItemSkuMapper orderItemSkuMapper;
	
	
	/**
	 * 用户授权信息保存或者更新
	 * @param request
	 * @param pUserId 推荐人的UserId
	 * @return
	 */

	public User saveUserInfo(WxUserInfoBase userInfoBase,String pUserId) throws CustomException{
		UserVO params=new UserVO();
		User user=null;
		try {
			params.setWxOpenId(userInfoBase.getOpenId());//用户ID
			params.setProvince(userInfoBase.getProvince());//省份
			params.setCity(userInfoBase.getCity());//城市
			params.setNickName(userInfoBase.getNickName());//昵称
			params.setLoginName(userInfoBase.getNickName());//登录昵称
			params.setHeadImg(userInfoBase.getHeadImgUrl());//头像
			//性别
			if(userInfoBase.equals("1"))
				params.setSex(true);
			else{
				params.setSex(false);
			}
			user = usersMapper.selectByPrimaryKey(params);
			if(user!=null && !StringUtils.isEmpty(user.getId())){
				params.setId(user.getId());
				user=params;
				user.setUpdatedAt(new Date());
				//如果用户存在，则修改用户信息
				usersMapper.updateByPrimaryKeySelective(user);
			}else{
				//新增用户信息
				user =new User();
				user=params;
				user.setCreatedAt(new Date());
				user.setUpdatedAt(new Date());
				user.setId(UUID.randomUUID().toString());
				user.setRecommendUserId(pUserId);
				usersMapper.insertSelective(user);
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return user;
	}
	
	
	
	public List<User> checkMobileExist(User user){
		return usersMapper.queryUserByCondition(user);
	}
    
    
    
	
	
	
	
	
}
