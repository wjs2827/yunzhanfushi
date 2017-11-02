package com.wmeimob.yzfs.api.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.model.pay.WxCompanyPayResult;
import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.OrdersMapper;
import com.wmeimob.yzfs.dao.RechargeRulesMapper;
import com.wmeimob.yzfs.dao.RightsOrdersLogsMapper;
import com.wmeimob.yzfs.dao.RightsOrdersMapper;
import com.wmeimob.yzfs.dao.ShippingAddrsMapper;
import com.wmeimob.yzfs.dao.SysConfigsMapper;
import com.wmeimob.yzfs.dao.UserAccountLogsMapper;
import com.wmeimob.yzfs.dao.UserAccountsMapper;
import com.wmeimob.yzfs.dao.UserCardLogsMapper;
import com.wmeimob.yzfs.dao.UserCardsMapper;
import com.wmeimob.yzfs.dao.UserCommissionAccountLogsMapper;
import com.wmeimob.yzfs.dao.UserCommissionAccountsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Orders;
import com.wmeimob.yzfs.model.RechargeRules;
import com.wmeimob.yzfs.model.RightsOrdersLogs;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.model.UserCommissionAccounts;
import com.wmeimob.yzfs.util.GeneratorSnUtil;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.vo.OrderStatusCount;
import com.wmeimob.yzfs.vo.RightsOrdersVO;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountsVO;
import com.wmeimob.yzfs.weixin.CheckError;
import com.wmeimob.yzfs.weixin.WeChatUtil;
import com.wmeimob.yzfs.weixin.XmlReaderUtil;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class CenterServiceApi {

	private static Logger logger = Logger.getLogger(CenterServiceApi.class);
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
	EcGoodSkuMapper ecGoodSkuMapper;
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	OrdersMapper  ordersMapper;
	
	@Autowired
	OrderItemsMapper orderItemsMapper;
	
	@Autowired
	RightsOrdersMapper rightsOrdersMapper;
	
	@Autowired
	RightsOrdersLogsMapper rightsOrdersLogsMapper;
	
	@Autowired
	ShippingAddrsMapper shippingAddrsMapper;
	
	@Autowired
	SysConfigsMapper sysConfigsMapper;
	
	@Autowired
	RechargeRulesMapper rechargeRulesMapper;
	
	@Autowired
	UserAccountsMapper userAccountsMapper;
	
	@Autowired
	UserAccountLogsMapper userAccountLogsMapper;
	
	@Autowired
	UserCardsMapper userCardsMapper;
	
	@Autowired
	UserCardLogsMapper userCardLogsMapper;
	
	@Autowired
	UserCommissionAccountsMapper userCommissionAccountsMapper;
	
	@Autowired
	UserCommissionAccountLogsMapper userCommissionAccountLogsMapper;
	
	/**
	 * 我的个人中心
	 * @param request
	 * @return
	 */
	public JSONObject myCenter(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		Map<String,Object> map =new HashMap<String,Object>();
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			User user = usersMapper.queryUserAccountInfo(userId);
			OrderStatusCount orderStatusCount = ordersMapper.queryOrderStatusCount(userId);
			if (user == null || StringUtils.isEmpty(user.getId())) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "data is null");
				data.put("message", "user is not exist!");
				return data;
			}
			map.put("user", user);
			map.put("orderCount", orderStatusCount);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", map);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 充值页面
	 * @param request
	 * @return
	 */
	public JSONObject recharge(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "data is null");
				data.put("message", "user is not exist!");
				return data;
			}
			RechargeRules params=null;
			List<RechargeRules> rechargeList = rechargeRulesMapper.selectByPrimaryKey(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", rechargeList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	
	/**
	 * 我的订单列表
	 * @param request
	 * @return
	 */
	public JSONObject ordreList(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		Map<String,Object> map =new HashMap<String,Object>();
		String ordreStatus=maps.get("ordreStatus")+"";//订单状态
		int pageIndex=1;
		int pageSize=20;
		if(StringUtils.isEmpty(maps.get("pageIndex")+"")){
			pageIndex=1;
		}else{
			pageIndex=Integer.parseInt(maps.get("pageIndex").toString());
		}
		if(StringUtils.isEmpty(maps.get("pageSize")+"")){
			pageSize=20;
		}else{
			pageSize=Integer.parseInt(maps.get("pageSize").toString());
		}
		try {
			Orders params = new Orders();
			if(pageIndex>=1){
				params.setPageIndex(pageIndex-1);
			}
			params.setPageSize(pageIndex*pageSize);
			params.setOwnerId(userId);
			if(StringUtils.isEmpty(ordreStatus)){
				params.setOrderStatus(-1);
			}else{
				params.setOrderStatus(Integer.parseInt(ordreStatus));
			}
			List<Orders> orderList=ordersMapper.queryOrderListByParamsFromWX(params);
			OrderStatusCount orderStatusCount = ordersMapper.queryOrderStatusCount(userId);
			map.put("orderList", orderList);
			map.put("orderCount", orderStatusCount);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", map);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 根据订单ID查询我的订单详情
	 * @param request
	 * @return
	 */
	public JSONObject orderItemById(HttpServletRequest request,String orderId) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "");
				data.put("message", "userId is  null!");
				return data;
			}
			if (orderId == null || StringUtils.isEmpty(orderId)) {
				data.put("code", CheckError.SYSTEM_ERROR.value);
				data.put("data", "");
				data.put("message", "orderId is not exist!");
				return data;
			}
			Orders order = ordersMapper.selectOrderItemByOrderIdFromWX(orderId);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", order);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	
	}
	
	
	/**
	 * 我的售后列表
	 * @param request
	 * @return
	 */
	public JSONObject rightsOrdreList(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		int pageIndex=1;
		int pageSize=20;
		if(StringUtils.isEmpty(maps.get("pageIndex")+"")){
			pageIndex=1;
		}else{
			pageIndex=Integer.parseInt(maps.get("pageIndex").toString());
		}
		if(StringUtils.isEmpty(maps.get("pageSize")+"")){
			pageSize=20;
		}else{
			pageSize=Integer.parseInt(maps.get("pageSize").toString());
		}
		try {
			RightsOrdersVO params =new  RightsOrdersVO();
			if(pageIndex>=1){
				params.setPageIndex(pageIndex-1);
			}
			params.setPageSize(pageIndex*pageSize);
			params.setUserId(userId);
			List<RightsOrdersVO> returnOrderList=rightsOrdersMapper.queryRightsOrderList(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", returnOrderList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	
	/**
	 * 根据订单ID查询我的售后订单详情
	 * @param request
	 * @return
	 */
	public JSONObject rightsOrderItemById(HttpServletRequest request,String orderId) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "");
				data.put("message", "userId is  null!");
				return data;
			}
			if (orderId == null || StringUtils.isEmpty(orderId)) {
				data.put("code", CheckError.SYSTEM_ERROR.value);
				data.put("data", "");
				data.put("message", "orderId is not exist!");
				return data;
			}
			RightsOrdersVO rs =new RightsOrdersVO();
		    rs=rightsOrdersMapper.selectByPrimaryKeyById(orderId);
			if(rs !=null &&rs.getId()>0){
				List<RightsOrdersLogs> list=rightsOrdersLogsMapper.selectByPrimaryKey(rs.getId());
				rs.setRightItemsLog(list);
			}
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", rs);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	
	}
	
	
	/**
	 * 我的佣金
	 * @param request
	 * @return
	 */
	public JSONObject myCommission(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", CheckError.IS_NOT_LOGIN.value);
				data.put("data", "data is null");
				data.put("message", "user is not exist!");
				return data;
			}
			UserCommissionAccounts commAccount = userCommissionAccountsMapper.queryCommissionByUserId(userId);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", commAccount);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	
	/**
	 * 我的佣金记录
	 * @param request
	 * @return
	 */
	public JSONObject myCommissionRecord(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		if (userId == null || StringUtils.isEmpty(userId)) {
			data.put("code", CheckError.IS_NOT_LOGIN.value);
			data.put("data", "data is null");
			data.put("message", "user is not exist!");
			return data;
		}
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		String recordType=maps.get("recordType")+"";//记录类型  0支出     1收入
		int pageIndex=1;
		int pageSize=20;
		if(StringUtils.isEmpty(maps.get("pageIndex")+"")){
			pageIndex=0;
		}else{
			pageIndex=Integer.parseInt(maps.get("pageIndex").toString());
		}
		if(StringUtils.isEmpty(maps.get("pageSize")+"")){
			pageSize=20;
		}else{
			pageSize=Integer.parseInt(maps.get("pageSize").toString());
		}
		try {
			UserCommissionAccountLogsVO params=new UserCommissionAccountLogsVO();
			if(pageIndex>=1){
				params.setPageIndex(pageIndex-1);
			}
			params.setPageSize(pageIndex*pageSize);
			params.setUserId(userId);
			if(StringUtils.isEmpty(recordType)){
				params.setRecordType((byte)1);
			}else{
				params.setRecordType((byte)Integer.parseInt(recordType));
			}
			List<UserCommissionAccountLogsVO> commList = userCommissionAccountLogsMapper.queryCommissionListByParams(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", commList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 我的余额记录列表
	 * @param request
	 * @return
	 */
	public JSONObject myBalaceRecord(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		if (userId == null || StringUtils.isEmpty(userId)) {
			data.put("code", CheckError.IS_NOT_LOGIN.value);
			data.put("data", "data is null");
			data.put("message", "user is not exist!");
			return data;
		}
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		int pageIndex=1;
		int pageSize=20;
		if(StringUtils.isEmpty(maps.get("pageIndex")+"")){
			pageIndex=0;
		}else{
			pageIndex=Integer.parseInt(maps.get("pageIndex").toString());
		}
		if(StringUtils.isEmpty(maps.get("pageSize")+"")){
			pageSize=20;
		}else{
			pageSize=Integer.parseInt(maps.get("pageSize").toString());
		}
		try {
			UserAccountLogsVO params=new UserAccountLogsVO();
			if(pageIndex>=1){
				params.setPageIndex(pageIndex-1);
			}
			params.setPageSize(pageIndex*pageSize);
			params.setUserId(userId);
			List<UserAccountLogsVO> accountList =userAccountLogsMapper.queryBalanceListByParams(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", accountList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	
	/**
	 * 我的T金记录列表
	 * @param request
	 * @return
	 */
	public JSONObject myCardLogRecord(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		if (userId == null || StringUtils.isEmpty(userId)) {
			data.put("code", CheckError.IS_NOT_LOGIN.value);
			data.put("data", "data is null");
			data.put("message", "user is not exist!");
			return data;
		}
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		int pageIndex=1;
		int pageSize=20;
		if(StringUtils.isEmpty(maps.get("pageIndex")+"")){
			pageIndex=0;
		}else{
			pageIndex=Integer.parseInt(maps.get("pageIndex").toString());
		}
		if(StringUtils.isEmpty(maps.get("pageSize")+"")){
			pageSize=20;
		}else{
			pageSize=Integer.parseInt(maps.get("pageSize").toString());
		}
		try {
			UserCardLogsVO params=new UserCardLogsVO();
			if(pageIndex>=1){
				params.setPageIndex(pageIndex-1);
			}
			params.setPageSize(pageIndex*pageSize);
			params.setUserId(userId);
			List<UserCardLogsVO> accountList =userCardLogsMapper.myCardLogRecord(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", accountList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value,"SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 提现（企业付款至个人）
	 * 每次至少提现100分（1元）
	 * @param request
	 * @return
	 */
	@Transactional
	public JSONObject withdrawals(HttpServletRequest request) throws CustomException{
		String snCode = GeneratorSnUtil.generatorSn("TX");// 支付流水号-提现
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String openId = jwtTokenUtil.getOpenIDFromToken(token);
		if (userId == null || StringUtils.isEmpty(userId)) {
			data.put("code", CheckError.IS_NOT_LOGIN.value);
			data.put("data", "data is null");
			data.put("message", "user is not exist!");
			return data;
		}
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);
		int sumAmount = Integer.parseInt(maps.get("withdrawals") + "");// 要提现的金额
		if (sumAmount < 100) {// 至少提现1元
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "Withdrawals amount to at least 1 RMB!");
		}

		// 获取用户当前账户的佣金信息
		User user = usersMapper.queryUserAccountInfo(userId);
		BigDecimal commissionHistoryAmount = user.getCommissionHistoryAmount();// 历史总佣金
		BigDecimal commissionWithdrawAmount = user.getCommissionWithdrawAmount();// 累计提现佣金
		BigDecimal commissionAmount = user.getCommissionAmount();// 当前佣金余额
		if (commissionAmount.compareTo(new BigDecimal(sumAmount)) == -1) {// 判断余额是否充足
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "Insufficient cash withdrawal!");
		}
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(WeChatUtil.CERT));// 支付证书文件
//			inputStream = new FileInputStream(new File("E:\\workspace\\yunzhanfushi\\yzfs-weixin\\src\\main\\resources\\config\\apiclient_cert.p12"));// 支付证书文件
		} catch (FileNotFoundException e) {
			logger.debug("########################" + e.getMessage());
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
		}

		// 计算参数和验证签名，并发起付款
		WeChat weChat = WeChatUtil.weChat;
		WxCompanyPayResult wcpr = weChat.pay().wxCompanyPay(sumAmount, "withdrawals", openId, snCode,
				XmlReaderUtil.getLocalIp(request), inputStream);
		// ("WXPAY", notify_url, openId,
		// order.getPayNo(),XmlReaderUtil.getLocalIp(request), sumAmount);
		if (wcpr.getReturnCode().equals("SUCCESS")) {
			logger.debug("Transfers success : " + snCode + "!" + new Date());
			logger.debug("partner_trade_no：" + wcpr.getPartnerTradeNo());
			logger.debug("payment_no：" + wcpr.getPaymentNo());
			logger.debug("payment_time：" + wcpr.getPaymentTime());
			BigDecimal sumAmountBd = new BigDecimal(sumAmount);
			
			// 更新个人佣金账户
			UserCommissionAccountsVO uca = new UserCommissionAccountsVO();
			uca.setId(user.getCommissionId());
			uca.setWithdrawAmount(commissionAmount.add(sumAmountBd));
			uca.setAmount(commissionAmount.subtract(sumAmountBd));
			if (userCommissionAccountsMapper.updateByPrimaryKeySelective(uca) <= 0) {
				throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
			}
			// 增加佣金日志记录
			UserCommissionAccountLogsVO ucal = new UserCommissionAccountLogsVO();
			ucal.setUserAccountId(user.getCommissionId());
			ucal.setRecordType((byte) 0);// 记录类型：0支出，1收入
			ucal.setChangeType("order_commission");// 变动类型。order_commission：订单产生分佣；withdraw：提现。recharge：充值产生分佣
			ucal.setChangeNote("提现");
			ucal.setCreatedAt(new Date());
			ucal.setChangeAmount(sumAmountBd);
			ucal.setAccountAmount(commissionAmount);// 当时帐户余额
			ucal.setCreatedAt(new Date());
			ucal.setStatus(true);
			if (userCommissionAccountLogsMapper.insertSelective(ucal) <= 0) {
				throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
			}
		} else {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, wcpr.getReturnMsg());
		}
		
		data.put("code", CheckError.SUCCESS.value);
		data.put("data", null);
		data.put("message", "success");
		return data;
	}
	
	/**
	 * 获取我的二维码
	 */
	public JSONObject getMyQRCode(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();

		try {
			String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
			String userId = jwtTokenUtil.getIdFromToken(token);
			User user = new User();
			user.setId(userId);
			User r = usersMapper.selectByPrimaryKey(user);
			if (r != null) {
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", r.getQrcodeKey());
				data.put("msg", "success");
			} else {
				data.put("code", CheckError.SYSTEM_ERROR.value);
				data.put("data", "");
				data.put("msg", "error");
			}
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
		}
		return data;
	}
	
	/**
	 * 获取我的余额
	 */
	public JSONObject getMyAccount(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();

		try {
			String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
			String userId = jwtTokenUtil.getIdFromToken(token);
			User r = usersMapper.queryUserAccountInfo(userId);
			if (r != null) {
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", r.getAccountAmount());
				data.put("msg", "success");
			} else {
				data.put("code", CheckError.SYSTEM_ERROR.value);
				data.put("data", "");
				data.put("msg", "error");
			}
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "error");
		}
		return data;
	}
	
	
}
