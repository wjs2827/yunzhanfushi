package com.wmeimob.yzfs.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.controller.CoreControllerApi;
import com.wmeimob.yzfs.dao.SysConfigsMapper;
import com.wmeimob.yzfs.dao.UserAccountsMapper;
import com.wmeimob.yzfs.dao.UserCardLogsMapper;
import com.wmeimob.yzfs.dao.UserCardsMapper;
import com.wmeimob.yzfs.dao.UserCommissionAccountsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.model.UserAccounts;
import com.wmeimob.yzfs.model.UserCards;
import com.wmeimob.yzfs.model.UserCommissionAccounts;
import com.wmeimob.yzfs.smsUtil.ErrorCode;
import com.wmeimob.yzfs.smsUtil.ResponseCode;
import com.wmeimob.yzfs.util.CheckUtils;
import com.wmeimob.yzfs.util.GeneratorSnUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.util.Md5Util;
import com.wmeimob.yzfs.util.QRCodeUtil;
import com.wmeimob.yzfs.vo.UserAccountsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCardsVO;
import com.wmeimob.yzfs.weixin.BalaceFrom;
import com.wmeimob.yzfs.weixin.CheckError;
import com.wmeimob.yzfs.weixin.WeChatUtil;

@Service
@Transactional
public class RegisterServiceApi {

	private static Logger					logger	= Logger.getLogger(CoreControllerApi.class);

	// 注解用来存取值的REDIS
	@Autowired
	private RedisTemplate<String, Object>	redisTemplate;

	@Autowired
	private JwtTokenUtil					jwtTokenUtil;

	@Autowired
	UsersMapper								userMapper;

	@Autowired
	UserCardsMapper							userCardsMapper;

	@Autowired
	UserCardLogsMapper						userCardLogsMapper;

	@Autowired
	UserAccountsMapper						userAccountsMapper;

	@Autowired
	SysConfigsMapper						sysConfigsMapper;

	@Autowired
	UserCommissionAccountsMapper userCommissionAccountsMapper;
	
	/**
	 * 校验手机号码是否已经注册
	 */
	public String checkMobileExist(String mobile) throws CustomException {
		String responseCode = ErrorCode.UNKNOWN_ERROR;
		try {
			User user = new User();
			user.setMobile(mobile);
			user.setStatus(true);
			List<User> userList = userMapper.queryUserByCondition(user);
			// 根据用户手机号码查询用户是否存在，如果存在，则已经注册，否则未注册
			if (userList != null && userList.size() > 0)
				responseCode = ResponseCode.MOBILE_ALREADY_EXIST;
			else
				responseCode = ResponseCode.SUCCESS;
		} catch (Exception e) {
			throw new CustomException(404, "error");
		}
		return responseCode;
	}

	/**
	 * 绑定用户信息
	 */
	@Transactional
	public JSONObject bangdingUser(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		User user = new User();
		String snCode = GeneratorSnUtil.generatorSn("HY");// 支付流水号
		try {
			logger.debug(new Date() + "######################获取Token###########################");
			String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
			String userId = jwtTokenUtil.getIdFromToken(token);
			logger.debug(new Date() + "######################获取用户ID:" + userId + "###########################");
			String WXOPENID = jwtTokenUtil.getOpenIDFromToken(token);
			logger.debug(new Date() + "######################获取用户OPENID:" + WXOPENID + "###########################");
//			String parentWXOPENID = request.getParameter("pOpenId");// 分享着OPENID
//			logger.debug(new Date() + "######################获取用户分享者OPENID:" + parentWXOPENID + "###########################");
			user.setId(userId);
			logger.debug(new Date() + "######################校验用户信息是否合法###########################");
			String mobile = request.getParameter("mobile");// 获取手机号码
			String regCode = request.getParameter("regCode");// 获取验证码
			String code = (String) (redisTemplate.boundValueOps("REGCODE:" + mobile).get());
			logger.debug(new Date() + "######################手机号码：" + mobile + ";验证码：" + regCode + ";缓存中的code:" + code
					+ "###########################");
			// 校验手机号码是否合法
			if (!CheckUtils.checkMobile(mobile)) {
				data.put("code", CheckError.MOBILE_ERROR.value);
				data.put("msg", "The cell phone number is not legal");
				return data;
			} else
				user.setMobile(mobile);
			logger.debug("######################手机号码合法###########################");
			// 验证该手机号是否已经绑定
			String responseCode = ErrorCode.UNKNOWN_ERROR;
			responseCode = this.checkMobileExist(user.getMobile());
			logger.debug(new Date() + "######################手机号码是否已经注册(0000)：" + responseCode
					+ "###########################");
			if (!ResponseCode.SUCCESS.equals(responseCode)) {
				data.put("code", CheckError.MOBILE_EXIST.value);
				data.put("msg", "The phone number already exists!");
				return data;
			}
			logger.debug(new Date() + "######################手机号码未绑定###########################");
			// 校验客户是否填写验证码
			if (StringUtils.isEmpty(regCode)) {
				data.put("code", CheckError.REGION_CODE_EMPTY.value);
				data.put("msg", "Validation code is empty!");
				return data;
			}
			// 校验验证码是否过期
			if (StringUtils.isEmpty(code)) {
				data.put("code", CheckError.REGION_CODE_GQ.value);
				data.put("msg", "Validation code expired!");
				return data;
			}
			logger.debug(new Date() + "######################验证码未过期###########################");
			// 校验验证码是否正确
			if (!code.trim().equals(regCode.trim())) {
				data.put("code", CheckError.REGION_CODE_ERROR.value);
				data.put("msg", "Validation code is error!");
				return data;
			}
			logger.debug(new Date() + "######################验证码和传入验证码一致，验证SUCCESS###########################");
			logger.debug(new Date() + "######################开始修改用户信息###########################");

			// 生成个人二维码
//			pUserId = userId
			String shareUrl = WeChatUtil.WECHAT_VUESITE + "/api" + WeChatUtil.AUTH_URL + "?pUserId="+userId;
			String qrcodeKey = QRCodeUtil.createPersonalQRCode(shareUrl);
			user.setQrcodeKey(qrcodeKey);

//			if (!StringUtils.isEmpty(parentWXOPENID)) {
//				// 查询分享人的id
//				User param = new User();
//				param.setWxOpenId(parentWXOPENID);
//				User parentUser = userMapper.selectByPrimaryKey(param);
//				user.setRecommendUserId(parentUser.getId());
//			}
			
			
			if (userMapper.updateByPrimaryKeySelective(user) > 0) {
				logger.debug(new Date() + "######################客户信息修改成功##########################");
				UserCardsVO userCard = new UserCardsVO();
				userCard.setUserId(userId);
				// 查询该用户下是否存在会员卡
				logger.debug(new Date() + "######################查询该用户下是否存在会员卡##########################");
				UserCards userCarts = userCardsMapper.selectByPrimaryKey(userCard);
				logger.debug(new Date() + "######################查询结束##########################");
				if (userCarts == null) {
					logger.debug(new Date() + "######################会员卡不存在##########################");
					// 判断是否是分享注册
					SysConfigs sysConfigs = null;
					
					User param = new User();
					param.setId(userId);
					User r = userMapper.selectByPrimaryKey(param);
					String parentUserId = r.getRecommendUserId();//此用户推荐人的userId
					
					if (!StringUtils.isEmpty(parentUserId)) {
						// 给自己账户增加T金
						sysConfigs = new SysConfigs();
						sysConfigs = sysConfigsMapper.querySysConfigByCode("YZZCHQYJ_004");
						if (sysConfigs != null && !StringUtils.isEmpty(sysConfigs.getId())
								&& sysConfigs.getConfigValue().compareTo(new BigDecimal(0)) == 1) {
							userCard.setCardPoints(sysConfigs.getConfigValue().intValue());
						}
					} else {
						userCard.setCardPoints(0);
					}
					userCard.setUserId(userId);
					userCard.setCardNo("");
					userCard.setHistoryUsedPoints(0);
					userCard.setTermTime(0);
					userCard.setPackageTypeId("");
					userCard.setPromoterCode("");
					userCard.setSnCode(snCode);// 办卡流水号
					userCard.setIsActivated(true);// 未开卡状态
					userCard.setStatus(true);// 停用状态，待支付成功启用
					logger.debug(new Date() + "######################新增会员卡信息##########################");
					// 办卡
					userCardsMapper.insertSelective(userCard);
					if (userCard.getId() > 0) {
						logger.debug(new Date() + "######################新增会员卡信成功,会员卡ID:" + userCard.getId()
								+ "##########################");
						if (!StringUtils.isEmpty(parentUserId)) {
							logger.debug(new Date() + "######################如果是扫码注册##########################");
							// 新增日志记录
							UserCardLogsVO cartLogParmas = new UserCardLogsVO();
							cartLogParmas.setUserCardId(userCard.getId());
							cartLogParmas.setRecordType((byte) 1);
							cartLogParmas.setChangeType(BalaceFrom.SHARE_REGISTER_POINT.value);
							cartLogParmas.setOrderId("");
							cartLogParmas.setChangeNote("通过分享二维码注册获取");
							cartLogParmas.setChangedAt(new Date());
							cartLogParmas.setChangePoints(userCard.getCardPoints());
							cartLogParmas.setAccountPoints(cartLogParmas.getChangePoints());
							cartLogParmas.setCreatedAt(new Date());
							cartLogParmas.setUpdatedAt(new Date());
							cartLogParmas.setStatus(true);
							logger.debug(new Date() + "######################开始新增T金##########################");
							if (userCardLogsMapper.insertSelective(cartLogParmas) <= 0) {
								throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
							}
							logger.debug(new Date() + "######################新增T金SUCCESS##########################");
						}
					}
				}
				// 创建账户信息
				logger.debug(new Date() + "######################创建账户信息 ##########################");
				UserAccountsVO params = new UserAccountsVO();
				params.setUserId(userId);
				logger.debug(new Date() + "######################查询是否存在账户信息 ##########################");
				UserAccounts userAccounts = userAccountsMapper.selectByPrimaryKey(params);
				if (userAccounts == null || StringUtils.isEmpty(userAccounts.getId())) {
					logger.debug(new Date() + "######################账户不存在 ##########################");
					user = userMapper.queryUserAccountInfo(userId);
					userAccounts = new UserAccounts();
					userAccounts.setId(UUID.randomUUID().toString());
					userAccounts.setUserId(userId);
					userAccounts.setAmount(new BigDecimal(0.00));
					userAccounts.setWithdrawAmount(new BigDecimal(0.00));
					userAccounts.setHistoryAmount(new BigDecimal(0.00));
					userAccounts.setBindOpenId(WXOPENID);
					userAccounts.setBindWxNickname(user.getNickName());
					userAccounts.setBindWxHeadimg(user.getHeadImg());
					userAccounts.setCreatedAt(new Date());
					userAccounts.setUpdatedAt(new Date());
					userAccounts.setStatus(true);
					if (userAccountsMapper.insertSelective(userAccounts) <= 0) {
						throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
					}
					logger.debug(new Date() + "######################新增账户SUCCESS ##########################");
				}
				logger.debug(new Date() + "######################查询是否存在账户信息 ##########################");
				UserCommissionAccounts uca = new UserCommissionAccounts();
				uca.setUserId(userId);
				UserCommissionAccounts userCommissionAccounts = userCommissionAccountsMapper.selectByPrimaryKey(uca);
				if (userCommissionAccounts == null || StringUtils.isEmpty(userCommissionAccounts.getId())) {
					logger.debug(new Date() + "######################账户不存在 ##########################");
					user = userMapper.queryUserAccountInfo(userId);
					userAccounts = new UserAccounts();
					UUID uuid = UUID.randomUUID();
					userCommissionAccounts = new UserCommissionAccounts();
					userCommissionAccounts.setId(uuid.toString());
					userCommissionAccounts.setUserId(userId);
					userCommissionAccounts.setAmount(new BigDecimal(0.00));
					userCommissionAccounts.setWithdrawAmount(new BigDecimal(0.00));
					userCommissionAccounts.setHistoryAmount(new BigDecimal(0.00));
					userCommissionAccounts.setBindOpenId(WXOPENID);
					userCommissionAccounts.setBindWxNickname(user.getNickName());
					userCommissionAccounts.setBindWxHeadimg(user.getHeadImg());
					userCommissionAccounts.setCreatedAt(new Date());
					userCommissionAccounts.setUpdatedAt(new Date());
					userCommissionAccounts.setStatus(true);
					if (userCommissionAccountsMapper.insertSelective(userCommissionAccounts) <= 0) {
						throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
					}
					logger.debug(new Date() + "######################新增佣金账户SUCCESS ##########################");
				}
				logger.debug(new Date() + "######################注册成功 ##########################");
				// 删除指定的key值
				logger.debug(new Date() + "######################删除指定的key值###########################");
				redisTemplate.delete("REGCODE:" + mobile);
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", "");
				data.put("msg", "success");
				return data;
			}
		} catch (Exception e) {
			logger.debug(new Date() + "######################" + e.getMessage() + " ##########################");
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
		}
		return data;
	}

	/**
	 * 校验注册信息是否合法
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	public JSONObject checkRegisterValue(HttpServletRequest request, final User user) {
		JSONObject data = new JSONObject();
		try {
			String mobile = request.getParameter("mobile");// 获取手机号码
			String regCode = request.getParameter("regCode");// 获取验证码
			String code = (String) (redisTemplate.boundValueOps("REGCODE:" + mobile).get());
			logger.debug(new Date() + "######################手机号码：" + mobile + ";验证码：" + regCode + ";缓存中的code:" + code
					+ "###########################");
			// 校验手机号码是否合法
			if (!CheckUtils.checkMobile(mobile)) {
				data.put("code", CheckError.MOBILE_ERROR.value);
				data.put("msg", "The cell phone number is not legal");
				return data;
			} else
				user.setMobile(mobile);
			logger.debug("######################手机号码合法###########################");
			// 验证该手机号是否已经绑定
			String responseCode = ErrorCode.UNKNOWN_ERROR;
			responseCode = this.checkMobileExist(user.getMobile());
			logger.debug(new Date() + "######################手机号码是否已经注册(0000)：" + responseCode
					+ "###########################");
			if (!ResponseCode.SUCCESS.equals(responseCode)) {
				data.put("code", CheckError.MOBILE_EXIST.value);
				data.put("msg", "The phone number already exists!");
				return data;
			}
			logger.debug(new Date() + "######################手机号码未绑定###########################");
			// 校验客户是否填写验证码
			if (StringUtils.isEmpty(regCode)) {
				data.put("code", CheckError.REGION_CODE_EMPTY.value);
				data.put("msg", "Validation code is empty!");
				return data;
			}
			// 校验验证码是否国过期
			if (StringUtils.isEmpty(code)) {
				data.put("code", CheckError.REGION_CODE_GQ.value);
				data.put("msg", "Validation code expired!");
				return data;
			}
			logger.debug(new Date() + "######################验证码未过期###########################");
			// 校验验证码是否正确
			if (!code.trim().equals(regCode.trim())) {
				data.put("code", CheckError.REGION_CODE_ERROR.value);
				data.put("msg", "Validation code is error!");
				return data;
			}
			logger.debug(new Date() + "######################验证码和传入验证码一致，验证SUCCESS###########################");
			data.put("code", 0);
			// 删除指定的key值
			logger.debug(new Date() + "######################删除指定的key值###########################");
			redisTemplate.delete("REGCODE:" + mobile);
		} catch (Exception e) {

		}
		return data;
	}

	/**
	 * 设置支付密码
	 */
	public JSONObject setPayPassword(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		User user = new User();
		try {
			String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
			String payPasswd = request.getParameter("password");
			String userId = jwtTokenUtil.getIdFromToken(token);
			user.setPayPasswd(Md5Util.Md5(payPasswd));
			user.setId(userId);
			user.setUpdatedAt(new Date());
			if (userMapper.updateByPrimaryKeySelective(user) > 0) {
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", "");
				data.put("msg", "success");
			}
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
		}
		return data;
	}

}
