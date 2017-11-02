package com.wmeimob.yzfs.api.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.model.pay.WxPaySign;
import com.wmeimob.yzfs.api.wxutils.WXUtil;
import com.wmeimob.yzfs.api.wxutils.XmlAnalysisUtil;
import com.wmeimob.yzfs.dao.RechargeRulesMapper;
import com.wmeimob.yzfs.dao.UserAccountLogsMapper;
import com.wmeimob.yzfs.dao.UserAccountsMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.RechargeRules;
import com.wmeimob.yzfs.model.UserAccountLogs;
import com.wmeimob.yzfs.model.UserAccounts;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.vo.UserAccountsVO;
import com.wmeimob.yzfs.weixin.BalaceFrom;
import com.wmeimob.yzfs.weixin.PayMethod;
import com.wmeimob.yzfs.weixin.WeChatUtil;
import com.wmeimob.yzfs.weixin.XmlReaderUtil;

@Service
@Transactional(rollbackFor=Exception.class)
public class RechargeServiceApi{

    private Logger logger = Logger.getLogger(RechargeServiceApi.class);
    
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private UserAccountsMapper userAccountsMapper;

    @Autowired
    private UserAccountLogsMapper userAccountLogsMapper;

    @Autowired
    private RechargeRulesMapper rechargeRulesMapper;


    
	/**
	 * 根据套餐充值
	 * @param rechargeId 套餐类型ID
	 * @return
	 */
    public JSONObject membership_Management(String rechargeId,String snCode,HttpServletRequest request) throws CustomException{
    	logger.error("=================充值套餐ID="+rechargeId+"&&&账户流水号："+snCode+"==========================");
	    JSONObject   data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String openId=jwtTokenUtil.getOpenIDFromToken(token);
        try {
			synchronized (snCode) {
				if (userId == null || StringUtils.isEmpty(userId)) {
					logger.error("=================用户不存在：" + userId + "==========================");
					data.put("code", 403);
					data.put("data", "data is null");
					data.put("message", "user is not exist!");
					return data;
				}
				UserAccountsVO params = new UserAccountsVO();
				params.setUserId(userId);
				UserAccounts userAccount = userAccountsMapper.selectByPrimaryKey(params);
				if (userAccount == null || StringUtils.isEmpty(userAccount.getId())) {
					logger.error("=================账户不存在==========================");
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "balance is not exist!");
					return data;
				}
				//根据充值套餐类型查询充值套餐
				RechargeRules rchargeRule = rechargeRulesMapper.selectByRuleId(rechargeId);
				if (rchargeRule == null || StringUtils.isEmpty(rchargeRule.getId())) {
					logger.error("=================套餐不存在==========================");
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "rchargeRule is not exist!");
					return data;
				}
				//记录变更日志记录
				UserAccountLogs ual = new UserAccountLogs();
				ual.setId(UUID.randomUUID().toString());
				ual.setAccountAmount(userAccount.getAmount());//原账户余额
				ual.setStatus(false);// 充值成功之后，更新为true
				ual.setUserAccountId(userAccount.getId());// 用户账户id
				ual.setRecordType((byte) 0);
				ual.setChangeType(BalaceFrom.RECHARGE.value);
				ual.setOrderId(rechargeId);//订单ID
				ual.setChangedAt(new Date());
				ual.setChangeAmount(rchargeRule.getRechargeAmount().add(rchargeRule.getAttachAmount()));//变化金额=充值金额+赠送金额
				ual.setRechargePackageName("充值");//套餐名称
				ual.setAttachAmount(rchargeRule.getAttachAmount());// 附加金额
				ual.setFromUserId(userId);//消费者
				ual.setPayType((byte) PayMethod.WECHAT_PAYMENT.value);
				ual.setPayAmount(rchargeRule.getRechargeAmount());// 实际充值金额
				ual.setPayNo(snCode);//支付流水号，回掉后用来判断充值的那条记录
				ual.setPromoterCode("");//门店邀请码
				ual.setCreatedAt(new Date());
				ual.setUpdatedAt(new Date());
				if(userAccountLogsMapper.insertSelective(ual) > 0) {
//	        	    //计算参数和验证签名
// 					String resultXml = null;
// 					try {
// 						String notify_url=WeChatUtil.WECHAT_WEBSET+WeChatUtil.PAYCALLBlack;
// 						resultXml = WXUtil.getUnifiedorderXml(request,openId,  ual.getPayNo(), ual.getPayAmount(),notify_url);
// 					} catch (Exception e) {
// 						e.printStackTrace();
// 					}
// 					Map<String, Object> map1 = new HashMap<String, Object>();
// 					map1 = XmlAnalysisUtil.xmlAnalysisUtil(resultXml);
// 					if(map1.get("return_code").equals("SUCCESS")){
// 						if(map1.get("prepay_id")!=null&&!map1.get("prepay_id").toString().isEmpty()){
// 							WxPaySign wxPay =WXUtil.wxCreateOrder(map1);
// 							data.put("code", 100);
// 							data.put("data",wxPay);
// 							data.put("payNo",  ual.getPayNo());
// 							data.put("payMethod", ual.getPayType());
// 							data.put("message", "success");
// 							return data;
// 						}
// 					}
 					
 					//计算参数和验证签名
 					WeChat weChat = WeChatUtil.weChat;
 					
 					//prod
 					String notify_url = WeChatUtil.WECHAT_WEBSET +WeChatUtil.RECHARGECALLBlack;
 					int sumAmount = rchargeRule.getRechargeAmount().multiply(new BigDecimal(100)).intValue();
 					
 					//test
// 					String notify_url = "http://18e38222d4.iask.in/yzfs-weixin/api" +WeChatUtil.RECHARGECALLBlack;
// 					int sumAmount = 1;//1分钱
 					WxPaySign paySign = weChat.pay().wxJSOrder("WXPAY", notify_url, openId, ual.getPayNo(),
 							XmlReaderUtil.getLocalIp(request), sumAmount);
 					data.put("code", 100);
 					data.put("data", paySign);
 					data.put("payNo", "");
 					data.put("payMethod", ual.getPayType());
 					data.put("message", "success");
				}else{
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "error");
				}
			} 
		} catch (Exception e) {
			throw new  CustomException(404,"SYSTEM IS ERROR!");
		}
		return data;
    }

}
