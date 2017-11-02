package com.wmeimob.yzfs.service.impl;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.model.pay.WxRefundResult;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.RightsOrdersLogsMapper;
import com.wmeimob.yzfs.dao.RightsOrdersMapper;
import com.wmeimob.yzfs.dao.UserAccountLogsMapper;
import com.wmeimob.yzfs.dao.UserAccountsMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.OrderItems;
import com.wmeimob.yzfs.model.RightsOrdersLogs;
import com.wmeimob.yzfs.model.UserAccountLogs;
import com.wmeimob.yzfs.model.UserAccounts;
import com.wmeimob.yzfs.service.ReturnOrdersService;
import com.wmeimob.yzfs.util.GeneratorSnUtil;
import com.wmeimob.yzfs.vo.RightsOrdersVO;
import com.wmeimob.yzfs.vo.UserAccountsVO;
import com.wmeimob.yzfs.weixin.BalaceFrom;
import com.wmeimob.yzfs.weixin.PayMethod;
import com.wmeimob.yzfs.weixin.WeChatUtil;

@Service
@Transactional(rollbackFor=Exception.class) 
public class ReturnOrdersServiceImpl implements ReturnOrdersService{
	
	private static Logger logger = Logger.getLogger(ReturnOrdersServiceImpl.class);
	
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	
	@Autowired
	private RightsOrdersMapper rightsOrdersMapper;
	
	@Autowired
	UserAccountsMapper userAccountsMapper;
	
	@Autowired
	UserAccountLogsMapper userAccountLogsMapper;
	
	@Autowired
	private RightsOrdersLogsMapper rightsOrdersLogsMapper;
	
	/**
	 * 查询维权订单列表信息
	 */
	@Override
	public List<RightsOrdersVO> queryOrderListByParams(RightsOrdersVO params) {
		return rightsOrdersMapper.selectByPrimaryKey(params);
	}

	/**
	 * 根据维权ID查询维权进度明细信息
	 */
	@Override
	public RightsOrdersVO selectByPrimaryKey(String id) {
		RightsOrdersVO rs = new RightsOrdersVO();
		rs=rightsOrdersMapper.selectByPrimaryKeyById(id);
		if(rs !=null &&!StringUtils.isEmpty(rs.getId())){
			List<RightsOrdersLogs> list=rightsOrdersLogsMapper.selectByPrimaryKey(rs.getId());
			rs.setRightItemsLog(list);
		}
		return rs;
	}

	/**
	 * 审核退款
	 */
	@Override
	public Map<String, Object> refund(String itemId,Integer wqId, String sign) throws CustomException {
		Map<String, Object> map =new HashMap<String,Object>();
		if(StringUtils.isEmpty(sign) || StringUtils.isEmpty(itemId)){
			map.put("code", 404);
			map.put("msg", "参数错误");
			return map;
		}
		String snCode=GeneratorSnUtil.generatorSn("TK");//支付流水号
		synchronized (snCode) {
		try {
			//验证订单明细是否存在
			OrderItems orderItems = new OrderItems();
			orderItems = orderItemsMapper.selectOrderItemsById(itemId);
			RightsOrdersLogs logParams = null;
			if (orderItems != null && !StringUtils.isEmpty(orderItems.getId())) {
				logParams = new RightsOrdersLogs();
				logParams.setRightsOrderId(wqId);
				logParams.setCreatedAt(new Date());
				logParams.setStatus(true);
				orderItems = new OrderItems();
				orderItems.setId(itemId);
				//退款和退货审核
				if ("TKSH".equals(sign) || "CHSH".equals(sign)) {
					logParams.setLogisStatus((byte) 1);
					if ("TKSH".equals(sign)) {
						logParams.setLogisStatus((byte) 1);
						orderItems.setRefundsStatus(2);
					}
					if ("CHSH".equals(sign)) {
						orderItems.setRefundsStatus(4);
					}
					if (orderItemsMapper.updateByPrimaryKeySelective(orderItems) > 0) {
						if (rightsOrdersLogsMapper.insertSelective(logParams) > 0) {
							map.put("code", 100);
							map.put("msg", "审核通过");
							return map;
						}
					}
				}
				//换货和驳回
				if ("QRCH".equals(sign) || "REFUSE".equals(sign)) {
					String msg = "";
					if ("QRCH".equals(sign)) {
						logParams.setLogisStatus((byte) 3);
						msg = "换货成功";
						orderItems.setRefundsStatus(5);
					}
					if ("REFUSE".equals(sign)) {
						logParams.setLogisStatus((byte) 2);
						msg = "驳回成功";
						orderItems.setRefundsStatus(6);
					}
					if (orderItemsMapper.updateByPrimaryKeySelective(orderItems) > 0) {
						if (rightsOrdersLogsMapper.insertSelective(logParams) > 0) {
							map.put("code", 100);
							map.put("msg", msg);
							return map;
						}
					}
				}
				//确认退款
				if ("TKQR".equals(sign)) {
					//判断支付方式，如果是余额支付，则退回余额，如果是微信支付，则调用微信退款接口原路退回
					//如果是微信支付
					if (orderItems.getPayType() == 1) {
						UserAccountsVO account = new UserAccountsVO();
						account.setUserId(orderItems.getUserId());
						UserAccounts userAccount = userAccountsMapper.selectByPrimaryKey(account);
						if (userAccount != null && !StringUtils.isEmpty(userAccount.getId())) {
							userAccount.setAmount(userAccount.getAmount().add(orderItems.getReturnAmount()));
							if (userAccountsMapper.updateByPrimaryKeySelective(userAccount) > 0) {
								logger.debug("#############################账户余额变更成功");
								//记录日志记录
								//记录变更日志记录
								UserAccountLogs ual = new UserAccountLogs();
								ual.setId(UUID.randomUUID().toString());
								ual.setAccountAmount(userAccount.getAmount());//原账户余额
								ual.setStatus(true);// 充值成功之后，更新为true
								ual.setUserAccountId(userAccount.getId());// 用户账户id
								ual.setRecordType((byte) 0);
								ual.setChangeType(BalaceFrom.REFUND_ORDER.value);
								ual.setOrderId(orderItems.getOrderId());//订单ID
								ual.setChangedAt(new Date());
								ual.setChangeAmount(orderItems.getReturnAmount());//退款金额
								ual.setRechargePackageName("申请售后余额退款");//套餐名称
								ual.setAttachAmount(new BigDecimal(0));// 附加金额
								ual.setFromUserId(orderItems.getUserId());//消费者
								ual.setPayType((byte) PayMethod.BALANCE_PAYMENT.value);
								ual.setPayAmount(orderItems.getReturnAmount());// 实际充值金额
								ual.setPayNo(snCode);//支付流水号，回掉后用来判断充值的那条记录
								ual.setPromoterCode("");//门店邀请码
								ual.setCreatedAt(new Date());
								ual.setUpdatedAt(new Date());
								if (userAccountLogsMapper.insertSelective(ual) > 0) {
									logger.debug("#############################日志记录成功");
									orderItems.setRefundsStatus(3);
									if (orderItemsMapper.updateByPrimaryKeySelective(orderItems) > 0) {
										logParams.setLogisStatus((byte) 3);
										if (rightsOrdersLogsMapper.insertSelective(logParams) > 0) {
											map.put("code", 100);//退款成功
											map.put("msg", "退款成功");
											return map;
										}
									}
								} else {
									logger.debug("#############################日志记录失败");
									map.put("code", 404);
									map.put("msg", "退款失败!");
									return map;
								}
							} else {
								logger.debug("#############################账户余额变更失败");
								map.put("code", 404);
								map.put("msg", "退款失败!");
								return map;
							}
						} else {
							logger.debug("#############################账户不存在");
							map.put("code", 404);
							map.put("msg", "退款失败，账户不存在!");
							return map;
						}
					}
					//如果是余额支付
					if (orderItems.getPayType() == 2) {
						//取消成功，调用退款接口
						WeChat weChat = WeChatUtil.weChat;
						InputStream inputStream = null;
						Integer totalFee = Integer
								.parseInt(orderItems.getReturnAmount().multiply(new BigDecimal(100)) + "");
						Integer refundFee = Integer
								.parseInt(orderItems.getReturnAmount().multiply(new BigDecimal(100)) + "");
						WxRefundResult refundResult = weChat.pay().wxRefund(orderItems.getOrderNo(),
								orderItems.getPayNo(), totalFee, refundFee, inputStream);
						if ("SUCCESS".equals(refundResult.getReturnCode())
								&& "SUCCESS".equals(refundResult.getResultCode())) {
							orderItems.setRefundsStatus(3);
							if (orderItemsMapper.updateByPrimaryKeySelective(orderItems) > 0) {
								logParams.setLogisStatus((byte) 3);
								if (rightsOrdersLogsMapper.insertSelective(logParams) > 0) {
									map.put("code", 100);//退款成功
									map.put("msg", "退款成功");
									return map;
								}
							}
						} else {
							map.put("code", 404);//退款失败
							map.put("msg", "退款失败!");
							return map;
						}
					}
				}
			} else {
				map.put("code", 404);
				map.put("msg", "订单明细不存在!");
				return map;
			} 
		} catch (Exception e) {
			 throw new  CustomException(404,"异常");
		}
		}
		return map;
	}


}
