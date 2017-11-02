package com.wmeimob.yzfs.api.service;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.model.pay.WxPayNotify;
import com.wmeimob.wechat.model.pay.WxPaySign;
import com.wmeimob.wechat.model.pay.WxRefundResult;
import com.wmeimob.yzfs.api.controller.CoreControllerApi;
import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.GoodsCommentMapper;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.OrderItemSkuMapper;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.OrdersMapper;
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
import com.wmeimob.yzfs.model.Cart;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsComment;
import com.wmeimob.yzfs.model.GoodsCommentPic;
import com.wmeimob.yzfs.model.OrderItemSku;
import com.wmeimob.yzfs.model.OrderItems;
import com.wmeimob.yzfs.model.Orders;
import com.wmeimob.yzfs.model.RightsOrders;
import com.wmeimob.yzfs.model.RightsOrdersLogs;
import com.wmeimob.yzfs.model.ShippingAddrs;
import com.wmeimob.yzfs.model.SysConfigs;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.model.UserAccountLogs;
import com.wmeimob.yzfs.model.UserAccounts;
import com.wmeimob.yzfs.model.UserCards;
import com.wmeimob.yzfs.util.GeneratorSnUtil;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.util.Md5Util;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;
import com.wmeimob.yzfs.vo.UserAccountsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCardsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountsVO;
import com.wmeimob.yzfs.weixin.BalaceFrom;
import com.wmeimob.yzfs.weixin.CheckError;
import com.wmeimob.yzfs.weixin.OrderStatus;
import com.wmeimob.yzfs.weixin.PayMethod;
import com.wmeimob.yzfs.weixin.WeChatUtil;
import com.wmeimob.yzfs.weixin.XmlReaderUtil;

@Service
@Transactional
public class OrderServiceApi {
	
	private static Logger logger = Logger.getLogger(CoreControllerApi.class);
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
	EcGoodSkuMapper ecGoodSkuMapper;
	
	@Autowired
	EcNeckSkuMapper ecNeckSkuMapper;
	
	@Autowired
	CartServiceApi cartServiceApi;
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	OrdersMapper  ordersMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	OrderItemsMapper orderItemsMapper;
	
	@Autowired
	OrderItemSkuMapper orderItemSkuMapper;
	
	@Autowired
	RightsOrdersMapper  rightsOrdersMapper;
	
	@Autowired
	RightsOrdersLogsMapper  rightsOrdersLogsMapper;
	
	@Autowired
	ShippingAddrsMapper shippingAddrsMapper;
	
	@Autowired
	SysConfigsMapper sysConfigsMapper;
	
	@Autowired
	UserAccountsMapper userAccountsMapper;
	
	@Autowired
	UserAccountLogsMapper userAccountLogsMapper;
	
	@Autowired
	UserCardsMapper userCardsMapper;
	
	@Autowired
	UserCardLogsMapper userCardLogsMapper;

	@Autowired
	GoodsCommentMapper goodsCommentMapper;

	@Autowired
	SysConfigsMapper sysConfigMapper;

	@Autowired
	UserCommissionAccountsMapper userCommissionAccountsMapper;
	
	@Autowired
	UserCommissionAccountLogsMapper userCommissionAccountLogsMapper;
	
	/**
	 * 去结算
	 * @param request
	 * @return
	 */
	public JSONObject settlement(HttpServletRequest request,String itemId) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		Map<String,Object> map = null;
		String snCode=GeneratorSnUtil.generatorSn("wxback");
		synchronized (snCode) {
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 403);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			//判断参数是否合法
			if(StringUtils.isEmpty(itemId)){
				data.put("code", 404);
				data.put("data", "");
				data.put("message", "Invalid argument!");
				return data;
			}
			//查询T金抵扣规则
			SysConfigs sysConfigs=sysConfigsMapper.querySysConfigByCode("YZJBDKBL_002");
			//查询用户账户信息
			User user=usersMapper.queryUserAccountInfo(userId);
			//账户余额
			BigDecimal accountAmount=new BigDecimal(0);
			//账户T金
			int accountPoints=0;
			if(user !=null){
				//判断是否注册
				if(StringUtils.isEmpty(user.getMobile())){
					data.put("code", 402);
					data.put("data", "error");
					data.put("message", "User not registered!");
					return data;
				}
				accountAmount=user.getAccountAmount();
				accountPoints=user.getAccountPoints();
			}else{
				data.put("code", 404);
				data.put("data", "error");
				data.put("message", "User not exist!");
			}
			//根据用户ID查询用户默认地址列表
			ShippingAddrs shippingAddrs=shippingAddrsMapper.queryAddrsByUserIdAndisDefault(userId);
			map = new HashMap<String,Object>();
			if(shippingAddrs !=null && !StringUtils.isEmpty(shippingAddrs.getId())){
				map.put("address", shippingAddrs);
			}else{
				map.put("address", "empty");
			}
			String[] itemIds=itemId.split(",");
			List<String> paramsList= new ArrayList<String>();
			for(int i=0;i<itemIds.length;i++){
			    //根据明细ID查询已选中的商品
				paramsList.add(itemIds[i]);
		    }
		    List<OrderItems> orderItemList=orderItemsMapper.queryCartGoodListByIdList(paramsList);
		    if(orderItemList==null || orderItemList.size()==0){
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "Invalid argument!");
				return data;
		    }
		    //计算商品总金额
		    BigDecimal orderAmount=this.getOrderAmount(orderItemList);
			//免运费
		    BigDecimal shippingFree=new BigDecimal(0);
			map.put("shippingFree", shippingFree);
			//商品信息列表
			map.put("orderItemList",orderItemList);
		    //能抵扣的T金
		    BigDecimal deductPoints=new BigDecimal(0);
		    //能抵扣的兑换金额
		    BigDecimal deductAmount=new BigDecimal(0);
			if(sysConfigs!=null && (sysConfigs.getConfigValue().compareTo(new BigDecimal(1))==1 && sysConfigs.getConfigValue().compareTo(new BigDecimal(100))==-1)){
	            //计算百分比
				BigDecimal Percentage=sysConfigs.getConfigValue().divide(new BigDecimal(100));
				if(accountPoints>0){
					//查询T金抵扣规则
					//计算能抵扣金额
					deductAmount=this.getOrderPoints(orderAmount,Percentage);
					//计算抵扣金额等比T金
					sysConfigs=new SysConfigs();
					sysConfigs=sysConfigsMapper.querySysConfigByCode("YZJBJZBL_003");
					if(sysConfigs!=null && (sysConfigs.getConfigValue().compareTo(new BigDecimal(0))==1)){
						deductPoints=deductAmount.multiply(new BigDecimal(sysConfigs.getConfigValue()+"")).setScale(0, BigDecimal.ROUND_HALF_UP);
					}
	           }
		     }
            map.put("deductPoints",deductPoints);
            map.put("deductAmount",deductAmount);
            map.put("accountAmount",accountAmount);
            map.put("accountPoints",accountPoints);
            map.put("orderAmount", orderAmount);
            map.put("sumAmount", orderAmount.add(shippingFree));
        	data.put("code", 100);
			data.put("message", "success");
			data.put("data", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new  CustomException(404,"Network anomaly");
		}
		}
		return data;
	}
	
	
	/**
	 * 立即购买
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONObject buyNow(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		if(StringUtils.isEmpty(xmlString)){
			data.put("code", 200);
			data.put("msg", "error");
			logger.debug("#############################xmlString："+xmlString);
			return data;
		}
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		String goodId=maps.get("goodId")+"";//商品ID
		String skuCode=maps.get("skuCode")+"";//商品SKU_CODE
		String neckSkuCode=maps.get("neckSkuCode")+"";//商品NECK_SKU_CODE
		String isMade=maps.get("isMade")+"";//是否私人定制
		EcGoodSku sku =null;
		EcNeckSku neckSku =null;
		Goods good=null;
		String snCode=GeneratorSnUtil.generatorSn("wxback");
		synchronized (snCode) {
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 403);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			//判断参数是否合法
			if(StringUtils.isEmpty(goodId)){
				data.put("code", 404);
				data.put("data", "");
				data.put("message", "goodId is null!");
				return data;
			}
			if (!StringUtils.isEmpty(goodId)) {
				//根据商品ID查询商品信息
				good = goodsMapper.queryGoodExistById(goodId);
				if (good == null || StringUtils.isEmpty(good.getSpuCode())) {
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "非法的参数!");
					return data;
				}
			}
			//判断参数是否合法
			if(StringUtils.isEmpty(skuCode)){
				data.put("code", 404);
				data.put("data", "");
				data.put("message", "skuCode is null!");
				return data;
			}
			//判断参数是否合法
			if(StringUtils.isEmpty(isMade)){
				data.put("code", 404);
				data.put("data", "");
				data.put("message", "isMade argument!");
				return data;
			}
			//是否私人定制
			Boolean isMades=false;
			if(isMade.equals("1")){
				isMades=true;
				neckSku=ecNeckSkuMapper.queryGoodNeckSkuBySkuCode(neckSkuCode, goodId);
				if (neckSku == null || StringUtils.isEmpty(neckSku.getSkuCode())) {
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "定制SKU不存在!");
					return data;
				}
			}
			//根据商品ID和SKU编码查询商品SKU信息
			sku = ecGoodSkuMapper.queryGoodSkuBySkuCode(skuCode, goodId);
			if (sku == null || StringUtils.isEmpty(sku.getSkuCode())) {
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "商品SKU不存在!");
				return data;
			}
			//验证库存是否满足
			int quantity=1;
			if(sku.getStockCount() - (sku.getLockCount()+sku.getSaleCount())-quantity > 0) {
				//查询购物车 ，如果不存在，则创建购物车
				Cart cart =cartServiceApi.getUserCart(userId);
				//购物车信息
				OrderItems oi = new OrderItems();
				oi.setContainerId(cart.getId());
				oi.setGoodId(goodId);
				oi.setSkuCode(skuCode);
				oi.setNeckSkuCode(neckSkuCode);
				oi.setIsMade(isMades);
				int count = 0;
				int goodNeckId=0;
				int goodSpecId=0;
				//根据商品ID和购物车ID查询当前购物车商品列表
				oi= orderItemsMapper.selectByOrderItemsByGoodId(oi);
				if (oi!=null) {
					if (quantity >= sku.getStockCount()) {
						oi.setQuantity(sku.getStockCount());
					} else {
						oi.setQuantity(quantity);
					}
					count = orderItemsMapper.updateByPrimaryKeySelective(oi);
				}else{
					oi = new OrderItems();
					oi.setContainerId(cart.getId());
					oi.setGoodId(goodId);
					oi.setSalePrice(sku.getPrice());
					oi.setSalePoint(0);
					oi.setQuantity(quantity);
					oi.setShippingFee(new BigDecimal(0));
					oi.setCommission(new BigDecimal(0));
					oi.setGetPoints(new BigDecimal(0));
					oi.setRefundsStatus(0);
					// false 订单； true 购物车
					oi.setContainerType(true);
					oi.setStatus(true);
					//商品SKU信息
					OrderItemSku skuProperties = new OrderItemSku();
					skuProperties.setCreatedAt(new Date());
					skuProperties.setUpdatedAt(new Date());
					skuProperties.setStatus(true);
					//是否私人定制
					if(isMades){
						oi.setFarePrice(neckSku.getSalePrice());
						skuProperties.setOrderItemSkuName(neckSku.getSkuName());//定制名称
						skuProperties.setSpuId(goodId);
						skuProperties.setSkuCode(neckSkuCode);//定制编码
						skuProperties.setPicKey(neckSku.getPicKey());//定制图片
						//新增可改装信息
						orderItemSkuMapper.insertSelective(skuProperties);
						goodNeckId=skuProperties.getId();
					}
					skuProperties.setOrderItemSkuName(sku.getSkuName());//SKU名称
					skuProperties.setSpuId(goodId);
					skuProperties.setSkuCode(skuCode);//SKU编码
					skuProperties.setPicKey(sku.getPicKey());//SKU商品图片
					//新增SKU信息
					orderItemSkuMapper.insertSelective(skuProperties);
					goodSpecId = skuProperties.getId();
					oi.setId(UUID.randomUUID().toString());
					oi.setGoodSpecId(goodSpecId);
					oi.setGoodNeckId(goodNeckId);
					oi.setCreatedAt(new Date());
					oi.setUpdatedAt(new Date());
					oi.setIsMade(isMades);
					//新增购物车信息
					count = orderItemsMapper.insertSelective(oi);
				}
				if (count > 0) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("itemId", oi.getId());
		        	data.put("code", 100);
					data.put("message", "success");
					data.put("data", map);
					return data;
				} else {
					data.put("code", 200);
					data.put("data", "error");
					data.put("message", "Network anomaly!");
					return data;
				}
			}else{
				data.put("code", 300);
				data.put("data", "stock is  empty");
				data.put("message", "库存不足!");
				return data;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new  CustomException(404,"Network anomaly");
		}
		}
	}
	
	
	/**
	 * 提交订单
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONObject saveOrder(HttpServletRequest request,String snCode) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String mobile = jwtTokenUtil.getMobileFromToken(token);//下单人手机号码
		String openId=jwtTokenUtil.getOpenIDFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		if(StringUtils.isEmpty(xmlString)){
			data.put("code", 200);
			data.put("msg", "error");
			logger.debug("#############################xmlString："+xmlString);
			return data;
		}
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		String payPasswd=maps.get("payPasswd")+"";//支付密码
		synchronized (snCode) {
		try {
			//查询用户账户信息
			User user=usersMapper.queryUserAccountInfo(userId);
			//账户余额
			BigDecimal accountAmount=new BigDecimal(0);
			//账户T金
			int accountPoints=0;
			if(user !=null){
				//判断是否注册
				if(StringUtils.isEmpty(user.getMobile())){
					data.put("code", 402);
					data.put("data", "error");
					data.put("message", "User not registered!");
					return data;
				}
				accountAmount=user.getAccountAmount();
				accountPoints=user.getAccountPoints();
			}else{
				data.put("code", 404);
				data.put("data", "");
				data.put("message", "balance is not exist !");
				return data;
			}
			//支付方式  : 1微信支付，2余额支付，3积分支付，4余额和积分，5支付宝',
            String payType=maps.get("payType")+"";	
            if(StringUtils.isEmpty(payType)){
				data.put("code", 200);
				data.put("data", "");
				data.put("message", "Please choose payment method!");
				return data;
            }
			if(!StringUtils.isEmpty(payType) && "2".equals(payType)){
				if(StringUtils.isEmpty(user.getPayPasswd())){
					data.put("code", 401);
					data.put("data", "");
					data.put("message", "No payment password set!");
					return data;
				}
				if(!Md5Util.Md5(payPasswd).equals(user.getPayPasswd())){
					data.put("code", 405);
					data.put("data", "");
					data.put("message", "No payment password set!");
					return data;
				}
			}
			//订单实体类(生成订单)
			Orders  order =new Orders();
			//判断用户是否有效
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 403);
				data.put("data", "data is null");
				data.put("message", "Invalid user!");
				return data;
			}
			//地址ID
			String addressId=maps.get("addressId")+"";
			//判断参数是否合法
			if(StringUtils.isEmpty(addressId)){
				data.put("code", 200);
				data.put("data", "");
				data.put("message", "Address is argument!");
				return data;
			}
			//已选择商品ID是否存在
            String itemId=maps.get("itemId")+"";
			//判断参数是否合法
			if(StringUtils.isEmpty(itemId)){
				data.put("code", 200);
				data.put("data", "");
				data.put("message", "Invalid argument!");
				return data;
			}
			//根据用户ID查询用户默认地址列表
			ShippingAddrs shippingAddrs=shippingAddrsMapper.selectByPrimaryKey(addressId);
			if(shippingAddrs==null || StringUtils.isEmpty(shippingAddrs.getId())){
				data.put("code", 406);
				data.put("data", "");
				data.put("message", "Address argument!");
				return data;
			}
			//是否使用T金(0 未选择使用  1 已选择使用)
			String[] itemIds=itemId.split(",");
			String isUsePoints=maps.get("isUsePoints")+"";
			List<String> paramsList= new ArrayList<String>();
			for(int i=0;i<itemIds.length;i++){
			    //根据明细ID查询已选中的商品
				paramsList.add(itemIds[i]);
		    }
			//查询商品明细
		    List<OrderItems> orderItemList=orderItemsMapper.queryCartGoodListByIdList(paramsList);
		    if(orderItemList==null || orderItemList.size()==0){
				data.put("code", 200);
				data.put("data", "");
				data.put("message", "order is not exist !");
				return data;
		    }
		    //计算商品总金额
		    BigDecimal orderAmount=this.getOrderAmount(orderItemList);
		    //能抵扣的T金
		    BigDecimal deductPoints=new BigDecimal(0);
		    //能抵扣的兑换金额
		    BigDecimal deductAmount=new BigDecimal(0);
		    if(!StringUtils.isEmpty(isUsePoints)&&"1".equals(isUsePoints)&&orderAmount.compareTo(new BigDecimal(0))==1){
			    SysConfigs sysConfigs=sysConfigsMapper.querySysConfigByCode("YZJBDKBL_002");
				if(sysConfigs!=null && (sysConfigs.getConfigValue().compareTo(new BigDecimal(1))==1 && sysConfigs.getConfigValue().compareTo(new BigDecimal(100))==-1)){
		            //计算百分比
					BigDecimal Percentage=sysConfigs.getConfigValue().divide(new BigDecimal(100));
					if(accountPoints>0){
						//查询T金抵扣规则
						//计算能抵扣金额
						deductAmount=this.getOrderPoints(orderAmount,Percentage);
						//计算抵扣金额等比T金
						sysConfigs=new SysConfigs();
						sysConfigs=sysConfigsMapper.querySysConfigByCode("YZJBJZBL_003");
						if(sysConfigs!=null && (sysConfigs.getConfigValue().compareTo(new BigDecimal(0))==1)){
							deductPoints=deductAmount.multiply(new BigDecimal(sysConfigs.getConfigValue()+"")).setScale(0, BigDecimal.ROUND_HALF_UP);
						}
		           }
			     }
		    }
			//免运费
		    BigDecimal shippingFree=new BigDecimal(0);
			if(!StringUtils.isEmpty(payType) && "2".equals(payType)){
				if(accountAmount.compareTo(orderAmount.add(deductAmount).add(shippingFree))==-1){
					data.put("code", 404);
					data.put("data", "");
					data.put("message", "Insufficient balance of account!");
					return data;
				}
			}
			//锁库
			EcGoodSku goodSku=null;
			for(OrderItems items:orderItemList){
				goodSku=new EcGoodSku();
				goodSku=ecGoodSkuMapper.queryGoodSkuBySkuCode(items.getSkuCode(),items.getGoodId());
				goodSku.setLockCount(goodSku.getLockCount()+items.getQuantity());
				if(ecGoodSkuMapper.updateBySkuStockByParams(goodSku)>0){
					logger.debug("锁库成功");
				}else{
					logger.debug("锁库失败");
				}
			}
			String remark =maps.get("remark")+"";//下单备注
			order.setId(UUID.randomUUID().toString());//订单ID
			order.setOrderType(false);//0单店铺订单，1多店铺订单
	        order.setOwnerId(userId);//用户ID
	        order.setOrderNo(GeneratorSnUtil.generatorSn("YZFS"));//订单号
	        order.setMobile(mobile);//下单人手机号码
	        order.setPayNo(snCode);//支付流水
	        order.setShippingFee(shippingFree);//运费
	        order.setOrderAmount(orderAmount);//商品总金额
	        order.setOrderPoints(Integer.parseInt(deductPoints+""));//订单T金
	        order.setPayPoints(deductAmount.intValue());//订单T金兑换后金额
	        order.setPayAmount(orderAmount.subtract(deductAmount));//实际支付金额
	        order.setShippingName(shippingAddrs.getShippingName());//收货人
	        order.setMobile(shippingAddrs.getMobile());
	        order.setShippingProvince(shippingAddrs.getpId());//省份ID
	        order.setShippingCity(shippingAddrs.getcId());//城市ID
	        order.setShippingDistrict(shippingAddrs.getdId());//地区ID
	        order.setShippingAddress(shippingAddrs.getShippingAddress());//详细地址
	        order.setRepayCount(0);//提交次数
	        order.setOrderStatus(OrderStatus.REQUIRED_UNPAID.value);//订单状态(未支付)
	        if(!StringUtils.isEmpty(payType) && "2".equals(payType)){
	           order.setPayType(PayMethod.BALANCE_PAYMENT.value);//余额支付
	        }else{
	           order.setPayType(PayMethod.WECHAT_PAYMENT.value);//微信支付
	        }
	        order.setShippingNote(remark);
	        order.setCreatedAt(new Date());
	        order.setUpdatedAt(new Date());
	        order.setStatus(true);
	        if(ordersMapper.insertSelective(order)>0){
        	    	//将购物车变更为商品详情信息
            	    Map<String,Object> map =new HashMap<String,Object>();
            	    map.put("containerId", order.getId());
            	    map.put("list", paramsList);
            	    if(orderItemsMapper.updateCartToOrderItemByListId(map)>0){
        	         //余额支付
        	         if(!StringUtils.isEmpty(payType) && "2".equals(payType)){
							data.put("code", 100);
							data.put("data", "");
							data.put("payNo", order.getPayNo());
							data.put("payMethod", order.getPayType());
							data.put("message", "success");
							return data;
        	         }else{//微信支付
        	        	    //计算参数和验证签名
//        	        	    logger.debug(new Date()+"##################################开始计算微信支付参数和验证签名##########################################");
//	     					String resultXml = null;
//	     					try {
//	     						String notify_url=WeChatUtil.WECHAT_WEBSET+WeChatUtil.PAYCALLBlack;
//	     						logger.debug(new Date()+"##################################回掉地址："+notify_url+"##########################################");
//	     						resultXml = WXUtil.getUnifiedorderXml(request,openId, order.getPayNo(), order.getPayAmount(),notify_url);
//	     					} catch (Exception e) {
//	     						e.printStackTrace();
//	     					}
//	     					Map<String, Object> map1 = new HashMap<String, Object>();
//	     					logger.debug(new Date()+"##################################验证签名返回结果："+resultXml+"##########################################");
//	     					map1 = XmlAnalysisUtil.xmlAnalysisUtil(resultXml);
//	     					logger.debug(new Date()+"##################################解析XML结果："+map1+"##########################################");
//	     					if(map1.get("return_code").equals("SUCCESS")){
//	     						if(map1.get("prepay_id")!=null&&!map1.get("prepay_id").toString().isEmpty()){
//	     							WxPaySign wxPay=WXUtil.wxCreateOrder(map1);
//	     							data.put("code", 100);
//	     							data.put("data",wxPay);
//	     							data.put("payNo", order.getPayNo());
//	     							data.put("payMethod", order.getPayType());
//	     							data.put("message", "success");
//	     						}
//	     					}
//        					return data;
     					//计算参数和验证签名
     					WeChat weChat = WeChatUtil.weChat;
     					
     					//prod
     					String notify_url = WeChatUtil.WECHAT_WEBSET +WeChatUtil.PAYCALLBlack;
     					int sumAmount = order.getPayAmount().multiply(new BigDecimal(100)).intValue();
     					
     					//test
//     					String notify_url = "http://18e38222d4.iask.in/yzfs-weixin/api" +WeChatUtil.PAYCALLBlack;
//     					int sumAmount = 1;//1分钱
     					WxPaySign paySign = weChat.pay().wxJSOrder("WXPAY", notify_url, openId, order.getPayNo(),
     							XmlReaderUtil.getLocalIp(request), sumAmount);
     					data.put("code", 100);
     					data.put("data", paySign);
     					data.put("payNo", "");
     					data.put("payMethod", order.getPayType());
     					data.put("message", "success");
     					return data;
        	         }
        		    }else{
        		    	throw new  CustomException(404,"Network anomaly");
        		    }
	        }else{
	        	throw new  CustomException(404,"Network anomaly");
	        }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new  CustomException(404,"Network anomaly");
		}
		}
	}
	
	
	/**
	 * 根据购物车商品信息计算商品总金额
	 * 
	 * @param orderItemList
	 * @return
	 */
	public BigDecimal getOrderAmount(List<OrderItems> orderItemList) {
		BigDecimal orderAmount = new BigDecimal(0);
		if (orderItemList != null && orderItemList.size() > 0) {
			for (OrderItems item : orderItemList) {
				//单价 = 商品价格 + 加价金额
				BigDecimal currPrice = item.getSalePrice().add(item.getFarePrice());
				//单个订单项的价格  = 单价 * 数量
				BigDecimal currAmount = currPrice.multiply(new BigDecimal(item.getQuantity()));
				orderAmount = orderAmount.add(currAmount);
			}
		}
		return orderAmount;
	}

	/**
	 *根据商品总金额计算能抵扣金额
	 * @param orderItemList
	 * @return
	 */
	public BigDecimal getOrderPoints(BigDecimal orderAmount,BigDecimal Percentage){
		//查询T金抵扣规则
		return orderAmount.multiply(Percentage);
	}
	
	/**
	 * 微信支付回调业务处理
	 * @param request
	 * @param snCode
	 * @return
	 * @throws CustomException
	 */
	public JSONObject wxCallbackDeal(HttpServletRequest request, WxPayNotify notify ) throws CustomException{
		JSONObject data =new JSONObject();
		String snCode=GeneratorSnUtil.generatorSn("wxback");
		synchronized (snCode) {
        try {
			Orders order = ordersMapper.queryOrderInfoByPayNo(notify.getOutTradeNo());
			if (order != null && !StringUtils.isEmpty(order.getId())) {
				data=this.backDealOrder(order);
			}else{
				data.put("code", 200);
				data.put("msg", "error");
				logger.debug("#############################订单不存在");
				return data;
			} 
		} catch (Exception e) {
			logger.debug("#############################系统异常");
			throw new CustomException(200,"error");
		}
	 }
		return data;
		
	}
	
	/**
	 * 微信充值回调业务处理
	 * @param request
	 * @param snCode
	 * @return
	 * @throws CustomException
	 */
	public JSONObject wxRechargeCallback(HttpServletRequest request, WxPayNotify notify ) throws CustomException{
		JSONObject data =new JSONObject();
		String snCode=GeneratorSnUtil.generatorSn("czback");
		synchronized (snCode) {
        try {
        	UserAccountLogsVO userAccountLogsVO=userAccountLogsMapper.queryAccountLogByPayNo(notify.getOutTradeNo());
        	if(userAccountLogsVO !=null && !StringUtils.isEmpty(userAccountLogsVO.getId())){
        		//给账户增加金额
    			//查询账户信息扣除支付金额
    			UserAccountsVO params =new UserAccountsVO();
    			params.setId(userAccountLogsVO.getUserAccountId());
    			UserAccounts userAccount=userAccountsMapper.selectByPrimaryKey(params);
    			if(userAccount!=null && !StringUtils.isEmpty(userAccount.getId())){
    				userAccount.setAmount(userAccount.getAmount().add(userAccountLogsVO.getChangeAmount()));
    				if(userAccountsMapper.updateByPrimaryKeySelective(userAccount)>0){
    					logger.debug("#############################账户余额变更成功");
    					//将充值日志状态变更已经充值
    					if(userAccountLogsMapper.updateAccountById(userAccountLogsVO.getId())>0){
    						logger.debug(new Date()+"#############################日志变更成功");
        					data.put("code", 100);
        					data.put("msg", "success");
    					}else{
    						logger.debug(new Date()+"#############################日志变更失败");
        					data.put("code", 404);
        					data.put("msg", "error");
    					}
    				}else{
    					logger.debug(new Date()+"##############################账户余额变更失败");
    					data.put("code", 404);
    					data.put("msg", "sucerrorcess");
    				}
    			}
        	}else{
        		logger.debug(new Date()+"##############################账户不存在");
				data.put("code", 404);
				data.put("msg", "error");
        	}
		} catch (Exception e) {
			logger.debug("#############################系统异常");
			throw new CustomException(404,"error");
		}
	 }
		return data;
		
	}
	
	/**
	 * 余额支付回掉业务处理
	 * @param request
	 * @param snCode
	 * @return
	 * @throws CustomException
	 */
	@SuppressWarnings("unchecked")
	public JSONObject BalanceCallbackDeal(HttpServletRequest request) throws CustomException{
		JSONObject data =new JSONObject();
		String snCode=GeneratorSnUtil.generatorSn("balanceback");
		synchronized (snCode) {
        try {
    		String xmlString = HttpUtil.requestGetBody(request);
    		if(StringUtils.isEmpty(xmlString)){
				data.put("code", 200);
				data.put("msg", "error");
				logger.debug("#############################xmlString："+xmlString);
				return data;
    		}
    		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
			Orders order = ordersMapper.queryOrderInfoByPayNo(maps.get("payNo")+"");
			if (order != null && !StringUtils.isEmpty(order.getId())) {
				data=this.backDealOrder(order);
			}else{
				data.put("code", 200);
				data.put("msg", "error");
				logger.debug("#############################订单不存在");
				return data;
			} 
		} catch (Exception e) {
			logger.debug("#############################系统异常");
			throw new CustomException(200,"error");
		}
		}
        return data;
	}
	
	//订单支付回掉业务处理公共方法
	@Transactional
	public JSONObject backDealOrder(Orders order) throws CustomException{
		JSONObject data =new JSONObject();
		if (order != null && !StringUtils.isEmpty(order.getId())) {
			// 查询账户信息扣除支付金额
			UserAccountsVO params = new UserAccountsVO();
			params.setUserId(order.getOwnerId());
			UserAccounts userAccount = userAccountsMapper.selectByPrimaryKey(params);
			if (userAccount != null && !StringUtils.isEmpty(userAccount.getId())) {
				// 支付方式: 1微信支付，2余额支付，3积分支付，4支付宝
				int payType = order.getPayType();
				BigDecimal oldAmount = userAccount.getAmount();// 原余额
				if (payType == 1) {// 1微信支付

				} else if (payType == 2) {// 2余额支付
					BigDecimal currAmount = oldAmount.subtract(order.getPayAmount()); // 当前余额
					if (currAmount.compareTo(new BigDecimal(0)) < 0) {// 余额不足
						throw new CustomException(200, "Balance is not enough!");
					}
					userAccount.setAmount(currAmount);// 减去后的余额
					if (userAccountsMapper.updateByPrimaryKeySelective(userAccount) > 0) {
						logger.debug("#############################账户余额变更成功");
						// 记录变更日志记录
						UserAccountLogs ual = new UserAccountLogs();
						ual.setId(UUID.randomUUID().toString());
						ual.setAccountAmount(userAccount.getAmount());// 原账户余额
						ual.setStatus(true);// 充值成功之后，更新为true
						ual.setUserAccountId(userAccount.getId());// 用户账户id
						ual.setRecordType((byte) 0);
						ual.setChangeType("order_commission");
						ual.setOrderId(order.getId());// 订单ID
						ual.setChangedAt(new Date());
						ual.setChangeAmount(order.getPayAmount());// 支付金额
						ual.setRechargePackageName("下单扣除余额");// 套餐名称
						ual.setAttachAmount(new BigDecimal(0.00));// 附加金额
						ual.setFromUserId(order.getOwnerId());// 消费者
						ual.setPayType((byte) 2);
						ual.setPayAmount(order.getPayAmount());// 实际充值金额
						ual.setPayNo(order.getPayNo());// 支付流水号，回掉后用来判断充值的那条记录
						ual.setPromoterCode("");// 门店邀请码
						ual.setCreatedAt(new Date());
						ual.setUpdatedAt(new Date());
						if (userAccountLogsMapper.insertSelective(ual) > 0) {
							logger.debug(new Date() + "#############################余额日志变更成功");
							if (order.getOrderPoints() > 0) {
								// 扣除抵扣积分
								UserCardsVO cardParams = new UserCardsVO();
								cardParams.setUserId(order.getOwnerId());
								UserCards card = userCardsMapper.selectByPrimaryKey(cardParams);
								if (card != null && card.getId() > 0) {
									// 记录积分抵扣日志
									UserCardLogsVO cardLogParams = new UserCardLogsVO();
									cardLogParams.setUserCardId(card.getId());
									cardLogParams.setRecordType((byte) 0);
									cardLogParams.setChangeType("order_pay");// 订单支付
									cardLogParams.setOrderId(order.getId());// 订单ID
									cardLogParams.setChangeNote(BalaceFrom.PAY_DEDCUT_POINT.value);
									cardLogParams.setChangedAt(new Date());
									cardLogParams.setChangePoints(order.getOrderPoints());
									cardLogParams.setAccountPoints(card.getCardPoints());
									cardLogParams.setCreatedAt(new Date());
									cardLogParams.setUpdatedAt(new Date());
									cardLogParams.setStatus(true);
									if (userCardLogsMapper.insertSelective(cardLogParams) > 0) {
										logger.debug(new Date() + "#############################积分日志变更成功");
									} else {
										logger.debug(new Date() + "#############################积分日志变更失败");
										throw new CustomException(200, "Failed to update UserCardLogs!");
									}
								}
							} else {
								logger.debug(new Date() + "#############################抵扣积分为0");
							}
						} else {
							logger.debug(new Date() + "#############################余额日志变更失败");
							throw new CustomException(200, "Failed to update UserAccountsLogs!");
						}
					} else {
						throw new CustomException(200, "Failed to update UserAccount!");
					}
				}
				logger.debug("#############################开始变更订单状态为已支付");
				order.setOrderStatus(OrderStatus.SHIPMENT_PENDING.value);
				order.setUpdatedAt(new Date());
				if (ordersMapper.updateByPrimaryKeySelective(order) > 0) {
					data.put("code", 100);
					data.put("msg", "success");
					logger.debug("#############################订单状态变更成功");
					return data;
				} else {
					logger.debug("#############################订单状态变更失败");
					throw new CustomException(200, "Failed to update order status!");
				}
			}
		}else{
			logger.debug("#############################订单不存在");
        	throw new CustomException(200, "Order is not exist!");
		} 
		return data;
	}
	
	
	/**
	 * 立即支付
	 * @param request
	 * @param snCode
	 * @param orderId
	 * @return
	 * @throws CustomException
	 */
	public JSONObject goPay(HttpServletRequest request,String snCode) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String openId=jwtTokenUtil.getOpenIDFromToken(token);
		synchronized (snCode) {
			try {
				//判断用户是否有效
				if (userId == null || StringUtils.isEmpty(userId)) {
					data.put("code", 403);
					data.put("data", "data is null");
					data.put("message", "Invalid user!");
					return data;
				}
				String xmlString = HttpUtil.requestGetBody(request);
	    		if(StringUtils.isEmpty(xmlString)){
					data.put("code", 200);
					data.put("msg", "error");
					logger.debug("#############################xmlString："+xmlString);
					return data;
	    		}
	    		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
				String orderId = maps.get("orderId")+"";
				Orders order = ordersMapper.selectOrderItemsById(orderId);
				if (order != null && !StringUtils.isEmpty(order.getId())) {
					//计算参数和验证签名
					WeChat weChat = WeChatUtil.weChat;
					
					//prod
 					String notify_url = WeChatUtil.WECHAT_WEBSET +WeChatUtil.PAYCALLBlack;
 					int sumAmount = order.getPayAmount().multiply(new BigDecimal(100)).intValue();
 					
 					//test
// 					String notify_url = "http://18e38222d4.iask.in/yzfs-weixin/api" +WeChatUtil.PAYCALLBlack;
// 					int sumAmount = 1;//1分钱
 					
					WxPaySign paySign = weChat.pay().wxJSOrder("WXPAY", notify_url, openId, order.getPayNo(),
							XmlReaderUtil.getLocalIp(request), sumAmount);
					data.put("code", 100);
					data.put("data", paySign);
					data.put("payNo", "");
					data.put("payMethod", order.getPayType());
					data.put("message", "success");
					return data;
				} else {
					throw new  CustomException(404,"Network anomaly");
				} 
			} catch (Exception e) {
				throw new  CustomException(404,"Network anomaly");
			}
		}
	}
	
	
	/**
	 * 删除订单
	 * @param request
	 * @param snCode
	 * @return
	 * @throws CustomException
	 */
	public JSONObject removeOrder(HttpServletRequest request,String snCode) throws CustomException{
		JSONObject data = new JSONObject();
		String xmlString = HttpUtil.requestGetBody(request);
		if(StringUtils.isEmpty(xmlString)){
			data.put("code", 200);
			data.put("msg", "error");
			return data;
		}
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		String orderId=maps.get("orderId")+"";//订单id
		Orders o = ordersMapper.selectByPrimaryKey(orderId);
		
		if(o.getOrderStatus() == OrderStatus.REQUIRED_UNPAID.value || o.getOrderStatus() == OrderStatus.REQUIRED_CANCLE.value){
			//删除订单
			Orders order = new Orders();
			order.setId(orderId);
			order.setOrderStatus(OrderStatus.REQUIRED_REMOVE.value);
			if(ordersMapper.updateByPrimaryKeySelective(order) > 0) {
				data.put("code", 100);//删除成功
				data.put("data", "");
				data.put("message", "success!");
				return data;
			}else{
				data.put("code", 404);//删除失败
				data.put("data", "");
				data.put("message", "error!");
				return data;
			}
		}else{
			data.put("code", 404);//失败
			data.put("data", "order can not be remove!");
			data.put("message", "error!");
			return data;
		}
		
	}
	
	/**
	 * 取消订单
	 * @param request
	 * @return
	 */
	public JSONObject cancleOrder(HttpServletRequest request,String snCode) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		if(StringUtils.isEmpty(xmlString)){
			data.put("code", 200);
			data.put("msg", "error");
			logger.debug("#############################xmlString："+xmlString);
			return data;
		}
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		String orderId=maps.get("orderId")+"";//订单id
		
		synchronized (snCode) {
			try {
				if (StringUtils.isEmpty(userId)) {
					data.put("code", 403);//未登录
					data.put("data", "");
					data.put("message", "error!");
					return data;
				}
				if (StringUtils.isEmpty(orderId)) {
					data.put("code", 200);//参数错误
					data.put("data", "");
					data.put("message", "error!");
					return data;
				}
				//根据ID查询订单信息
				Orders params = ordersMapper.selectByPrimaryKey(orderId);
				if (params.getOrderStatus() == OrderStatus.REQUIRED_CANCLE.value) {
					data.put("code", 201);//订单已经取消
					data.put("data", "");
					data.put("message", "error!");
					return data;
				}
				//WX根据订单ID查询订单详情列表
				List<OrderItems> orderItemList=orderItemsMapper.selectCartListByOrderIdFromWX(params.getId());
				if(orderItemList==null || orderItemList.size()==0){
					data.put("code", 404);
					data.put("data", "");
					data.put("message", "error!");
					return data;
				}
				//退还库存
				EcGoodSku goodSku=null;
				for(OrderItems items:orderItemList){
					goodSku=new EcGoodSku();
					goodSku=ecGoodSkuMapper.queryGoodSkuBySkuCode(items.getSkuCode(),items.getGoodId());
					goodSku.setLockCount(goodSku.getLockCount()-items.getQuantity());
					if(ecGoodSkuMapper.updateBySkuStockByParams(goodSku)>0){
						logger.debug("退还库存成功");
					}else{
						logger.debug("退还库存失败");
					}
				}
				//如果未支付，只退还库存
				if(params.getOrderStatus() == OrderStatus.REQUIRED_UNPAID.value) {
					params.setId(orderId);
					params.setOrderStatus(OrderStatus.REQUIRED_CANCLE.value);
					if(ordersMapper.updateByPrimaryKeySelective(params) > 0) {
						data.put("code", 100);//取消成功
						data.put("data", "");
						data.put("message", "success!");
						return data;
					}else{
						data.put("code", 404);//取消成功
						data.put("data", "");
						data.put("message", "error!");
						return data;
					}
				}
				//如果已支付，未发货，退款退库存
				if(params.getOrderStatus() == OrderStatus.SHIPMENT_PENDING.value) {
					params.setId(orderId);
					params.setOrderStatus(OrderStatus.REQUIRED_CANCLE.value);
					if (ordersMapper.updateByPrimaryKeySelective(params)>0) {
						//如果是余额支付，直接退余额
						if(params.getPayType()==2){
							UserAccountsVO account =new UserAccountsVO();
			    			account.setUserId(params.getOwnerId());
			    			UserAccounts userAccount=userAccountsMapper.selectByPrimaryKey(account);
			    			if(userAccount!=null && !StringUtils.isEmpty(userAccount.getId())){
			    				userAccount.setAmount(userAccount.getAmount().add(params.getPayAmount()));
			    				if(userAccountsMapper.updateByPrimaryKeySelective(userAccount)>0){
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
			    					ual.setOrderId(params.getId());//订单ID
			    					ual.setChangedAt(new Date());
			    					ual.setChangeAmount(params.getPayAmount());//退款金额
			    					ual.setRechargePackageName("取消订单退余额");//套餐名称
			    					ual.setAttachAmount(new BigDecimal(0));// 附加金额
			    					ual.setFromUserId(userId);//消费者
			    					ual.setPayType((byte) PayMethod.BALANCE_PAYMENT.value);
			    					ual.setPayAmount(params.getPayAmount());// 实际充值金额
			    					ual.setPayNo(snCode);//支付流水号，回掉后用来判断充值的那条记录
			    					ual.setPromoterCode("");//门店邀请码
			    					ual.setCreatedAt(new Date());
			    					ual.setUpdatedAt(new Date());
			    					if(userAccountLogsMapper.insertSelective(ual) > 0) {
			    						logger.debug("#############################日志记录成功");
										data.put("code", 100);//退款成功
										data.put("data", "");
										data.put("message", "success!");
										return data;
			    					}else{
			    						logger.debug("#############################日志记录失败");
										data.put("code", 404);//退款成功
										data.put("data", "");
										data.put("message", "error!");
										return data;
			    					}
			    				}else{
			    					logger.debug("#############################账户余额变更失败");
									data.put("code", 404);//退款成功
									data.put("data", "");
									data.put("message", "error!");
									return data;
			    				}
			    			}else{
			    				logger.debug("#############################账户不存在");
								data.put("code", 404);//退款成功
								data.put("data", "");
								data.put("message", "error!");
								return data;
			    			}
						}
						//如果是微信支付，调用微信退款接口，开始退款
						if(params.getPayType()==1){
							//取消成功，调用退款接口
							WeChat weChat = WeChatUtil.weChat;
							InputStream inputStream = null;
							Integer totalFee =Integer.parseInt(params.getPayAmount().multiply(new BigDecimal(100))+"");
							Integer refundFee =Integer.parseInt(params.getPayAmount().multiply(new BigDecimal(100))+"");
							WxRefundResult refundResult=weChat.pay().wxRefund(params.getOrderNo(), params.getPayNo(), totalFee,refundFee,inputStream);
							if("SUCCESS".equals(refundResult.getReturnCode())&&"SUCCESS".equals(refundResult.getResultCode())){
								data.put("code", 100);//退款成功
								data.put("data", refundResult);
								data.put("message", "success!");
								return data;
							}else{
								data.put("code", 404);//退款失败
								data.put("data", "");
								data.put("message", "error!");
								return data;
							}
						}
					}
				}
			} catch (Exception e) {
				throw new  CustomException(404,"Network anomaly");
			}
		}
		return data;
	}
	
	/**
	 * 根据商品详情ID查询订单信息
	 * @param request
	 * @param itemId
	 * @return
	 * @throws CustomException
	 */
	public JSONObject queryOrderItemInfoById(HttpServletRequest request,String itemId) throws CustomException{
		JSONObject  data = new JSONObject();
		try {
			String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
			String userId = jwtTokenUtil.getIdFromToken(token);
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 403);
				data.put("data", "data is null");
				data.put("message", "userId is null!");
				return data;
			}
			if (StringUtils.isEmpty(itemId)) {
				data.put("code", 404);
				data.put("data", "itemId is null");
				data.put("message", "error!");
				return data;
			}
			OrderItems orderItem = orderItemsMapper.selectOrderItemsById(itemId);
			if(orderItem !=null && !StringUtils.isEmpty(orderItem.getId())){
				data.put("code", 100);
				data.put("data",orderItem);
				data.put("message", "success");
				return data;
			}else{
				data.put("code", 404);
				data.put("data", "orderItem is null");
				data.put("message", "error!");
				return data;
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
	}
	
	/**
	 * 确认收货
	 * @param request
	 * @param itemId
	 * @return
	 * @throws CustomException
	 */
	public JSONObject confirmReceipt(HttpServletRequest request,String orderId) throws CustomException{
		JSONObject  data = new JSONObject();
		try {
			String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
			String userId = jwtTokenUtil.getIdFromToken(token);
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 403);
				data.put("data", "data is null");
				data.put("message", "userId is null!");
				return data;
			}
			if (StringUtils.isEmpty(orderId)) {
				String xmlString = HttpUtil.requestGetBody(request);
				if(StringUtils.isEmpty(xmlString)){
					data.put("code", 200);
					data.put("data", "orderId is null");
					data.put("msg", "error");
					logger.debug("#############################xmlString："+xmlString);
					return data;
				}
				Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
				orderId=maps.get("orderId")+"";//订单id
				if (StringUtils.isEmpty(orderId)) {
					data.put("code", 404);
					data.put("data", "orderId is null");
					data.put("message", "error!");
					return data;
				}
				
			}
			Orders orders = ordersMapper.selectByPrimaryKey(orderId);
			if(orders !=null && !StringUtils.isEmpty(orders.getId())){
				//订单是否为已发货状态
				if(orders.getOrderStatus()==OrderStatus.REQUIRED_RECEIVED.value){
					//标记订单为已收货状态
					orders.setOrderStatus(OrderStatus.REQUIRED_FINISHED.value);
					orders.setReceiptAt(new Date());
					orders.setUpdatedAt(new Date());
					if(ordersMapper.updateByPrimaryKeySelective(orders)>0){
						//给推荐人增加佣金
						//1.查询佣金比率
						BigDecimal amountRate = sysConfigMapper.querySysConfigByCode("YZYJHQBL_005").getConfigValue();
						//2.计算要增加的金额
						BigDecimal orderPrice = orders.getPayAmount();//订单金额
						BigDecimal addAmount = orderPrice.multiply(amountRate);//要增加的金额
						//2.查询推荐人的userid
						User p = new User();
						p.setId(userId);
						User orderUser = usersMapper.selectByPrimaryKey(p);
						String tjrUserId = orderUser.getRecommendUserId();//推荐人id
						//3.查询推荐人的当前历史佣金
						User tjrUser = usersMapper.queryUserAccountInfo(tjrUserId);
						BigDecimal historyAmount = tjrUser.getCommissionHistoryAmount();//推荐人的历史总佣金
						//4.为推荐人增加佣金
						UserCommissionAccountsVO uca = new UserCommissionAccountsVO();
						uca.setId(tjrUser.getCommissionId());
						uca.setHistoryAmount(historyAmount.add(addAmount));
						if (userCommissionAccountsMapper.updateByPrimaryKeySelective(uca) <= 0) {
							throw new  CustomException(CheckError.SYSTEM_ERROR.value,"error");
						}
						//5.增加佣金记录
						UserCommissionAccountLogsVO ucal = new UserCommissionAccountLogsVO();
						ucal.setUserAccountId(tjrUser.getCommissionId());
						ucal.setRecordType((byte) 1);//记录类型：0支出，1收入
						ucal.setChangeType("order_commission");//变动类型：order_commission 订单产生分佣，withdraw 提现， recharge 充值产生分佣
						ucal.setChangeNote("订单产生分佣");
						ucal.setCreatedAt(new Date());
						ucal.setChangeAmount(addAmount);
						ucal.setAccountAmount(historyAmount);//当时帐户余额
						ucal.setCreatedAt(new Date());
						ucal.setStatus(true);
						if (userCommissionAccountLogsMapper.insertSelective(ucal) <= 0) {
							throw new  CustomException(CheckError.SYSTEM_ERROR.value,"error");
						} 
						data.put("code", 100);
						data.put("data","");
						data.put("message", "success");
						return data;
					}
				}else{
					data.put("code", 1001);
					data.put("data","");
					data.put("message", "orderId is recepit");
					return data;
				}
			}else{
				data.put("code", 404);
				data.put("data", "orders is null");
				data.put("message", "error!");
				return data;
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return data;
	}
	
	
	/**
	 * 申请售后
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONObject applyReturnOrder(HttpServletRequest request,String snCode) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		if(StringUtils.isEmpty(xmlString)){
			data.put("code", 404);
			data.put("msg", "requestBody is null");
			logger.debug("#############################xmlString："+xmlString);
			return data;
		}
		if (StringUtils.isEmpty(userId)) {
			data.put("code", 403);//未登录
			data.put("data", "");
			data.put("message", "error!");
			return data;
		}
		Map<String,Object> maps = (Map<String,Object>)JSON.parse(xmlString); 
		synchronized (snCode) {
			try {
				String itemId=maps.get("itemId")+"";//订单明细ID
				if(StringUtils.isEmpty(itemId)){
					data.put("code", 404);
					data.put("data", "itemId is null");
					data.put("message", "error!");
					return data;
				}
				OrderItems orderItem = orderItemsMapper.selectOrderItemsById(itemId);
				if(orderItem ==null || StringUtils.isEmpty(orderItem.getId())){
					data.put("code", 404);
					data.put("data","orderItem is null");
					data.put("message", "error");
					return data;
				}
				if(orderItem !=null && orderItem.getRefundsStatus()!=0){
					data.put("code", 1001);
					data.put("data","The goods have been applied for after sale");
					data.put("message", "error");
					return data;
				}
				String remark=maps.get("remark")+"";//退换货说明
				String type=maps.get("type")+"";//0 退款 1换货
				if(StringUtils.isEmpty(type)){
					data.put("code", 404);
					data.put("data","type is null");
					data.put("message", "error");
					return data;
				}
				//增加售后申请记录
				RightsOrders params =new RightsOrders();
				params.setOrderItemId(itemId);
				params.setRightsOrderNo(snCode);
				params.setCreatedAt(new Date());
				params.setUpdatedAt(new Date());
				params.setRemark(remark);
				if("0".equals(type)){
					params.setType(false);
				}else if("1".equals(type)){
					params.setType(true);
				}
				params.setStatus(true);
				
				rightsOrdersMapper.insertSelective(params);
				if(params.getId() == null || params.getId() <= 0){
					throw new  CustomException(404,"Network anomaly");
				}
				//记录日志记录
				RightsOrdersLogs rightlog =new RightsOrdersLogs();
				rightlog.setLogisStatus((byte) OrderStatus.RETURN_APPLY.value);
				rightlog.setRightsOrderId(params.getId());
				rightlog.setCreatedAt(new Date());
				rightlog.setStatus(true);
				if(rightsOrdersLogsMapper.insertSelective(rightlog) <= 0){
					throw new  CustomException(404,"Network anomaly");
				}
				OrderItems param = new OrderItems();
				param.setId(itemId);
				//0未退货，1退款申请，2商家处理中，3退款成功，4待换货5已换货6已拒绝
				if("0".equals(type)){//0 退款 1换货
					param.setRefundsStatus(1);
				}else if("1".equals(type)){
					param.setRefundsStatus(4);
				}
				if(orderItemsMapper.updateByPrimaryKeySelective(param) <= 0 ){
					throw new  CustomException(404,"Network anomaly");
				}
				data.put("code", 100);
				data.put("data","");
				data.put("message", "success");
				return data;
			} catch (Exception e) {
				throw new  CustomException(404,"Network anomaly");
			}
		}
	}
	
	/**
	 * 去评论
	 * @param request
	 * @param orderId
	 * @return
	 */
	public JSONObject goCommentByOrderId(HttpServletRequest request,String orderId) throws CustomException{
		JSONObject  data = new JSONObject();
		try {
			//WX根据订单ID查询订单详情列表
			List<OrderItems> orderItemList = orderItemsMapper.selectCartListByOrderIdFromWX(orderId);
			data.put("code", 100);
			data.put("data", orderItemList);
			data.put("message", "success");
			return data;
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
	}
	
	/**
	 * 提交评论保存
	 * @param request
	 * @param orderId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public JSONObject saveCommentInfo(HttpServletRequest request) throws CustomException{
		JSONObject data =new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String snCode=GeneratorSnUtil.generatorSn("balanceback");
		synchronized (snCode) {
        try {
    		String xmlString = HttpUtil.requestGetBody(request);
    		if(StringUtils.isEmpty(xmlString)){
				data.put("code", 404);
				data.put("msg", "error");
				logger.debug("#############################xmlString："+xmlString);
				return data;
    		}
    		GoodsComment record =null;
    		GoodsCommentPic commPic=null;
    		List<GoodsCommentPic> listPic=null;
    		Map<String,Object> mapone= (Map<String,Object>)JSON.parse(xmlString); 
    		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
    		maps=(List<Map<String, Object>>) mapone.get("data");
    		String single = mapone.get("single")+"";//是否匿名 1是 0否
    		for(Map<String,Object> map:maps){
	    		//新增评论返回ID
	    		record =new GoodsComment();
	    		record.setId(UUID.randomUUID().toString().replace("-", ""));
	    		record.setUserId(userId);
	    		record.setOrderItemId(map.get("orderId")+"");
	    		record.setContent(map.get("content")+"");
	    		record.setReplyTo("");
	    		record.setGrade((byte) Integer.parseInt(map.get("level")+""));
	    		record.setCreatedAt(new Date());
	    		record.setUpdatedAt(new Date());
	    		record.setIsWonderful(false);
	    		record.setStatus(true);
	    		if(single.equals("1")){
	    			record.setSingle(true);
	    		} else {
	    			record.setSingle(false);
	    		}
	    		
	    		listPic=new ArrayList<GoodsCommentPic>();
	    		if(goodsCommentMapper.insertSelective(record)>0){
	    			if(!StringUtils.isEmpty(map.get("picKey")+"")){
	    				String[] picKeyList=map.get("picKey").toString().split(",");
		    			for(int i=0;i<picKeyList.length;i++){
			    			commPic= new GoodsCommentPic();
			    			commPic.setId(UUID.randomUUID().toString().replace("-", ""));
			    			commPic.setCommentId(record.getId());
			    			commPic.setPicKey(picKeyList[i]);
			    			commPic.setCreatedAt(new Date());
			    			commPic.setUpdatedAt(new Date());
			    			commPic.setStatus(true);
			    			listPic.add(commPic);
		    			}
		    			//新增评论图片信息
		    			goodsCommentMapper.insertCommentPicList(listPic);
	    			}
	    		}
    	  }
		  data.put("code", 100);
		  data.put("data","");
		  data.put("message", "success");
		  return data;
		} catch (Exception e) {
			logger.debug("#############################系统异常");
			throw new CustomException(404,"error");
		}
		}
	}

	public JSONObject payTest(HttpServletRequest request){
		    JSONObject  data = new JSONObject();
		    String snCode=GeneratorSnUtil.generatorSn("ZF");//支付流水号
			//计算参数和验证签名
			WeChat weChat = WeChatUtil.weChat;
			String notify_url =WeChatUtil.WECHAT_WEBSET+WeChatUtil.PAYCALLBlack;
			int sumAmount = 1;
			WxPaySign paySign = weChat.pay().wxJSOrder("WXPAY", notify_url, "osR-s0ysOAC6YbuAcdNNXul8Yg_E", snCode,
					XmlReaderUtil.getLocalIp(request), sumAmount);
			data.put("code", 100);
			data.put("data", paySign);
			data.put("payNo", "");
			data.put("payMethod", "2");
			data.put("message", "success");
			return data;
	}
	
}
