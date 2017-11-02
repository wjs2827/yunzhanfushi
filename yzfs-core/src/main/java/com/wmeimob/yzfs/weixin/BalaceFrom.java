package com.wmeimob.yzfs.weixin;

/**
 * 余额以及T金来源
 * @author WMM08
 *
 */
public enum BalaceFrom {
	
	//下订单产生分佣
	ORDER_COMMISSION ("order_commission"),
	//提现
	WITHDRAW("withdraw"),
	//充值
	RECHARGE("recharge"),
	//退款
	REFUND_ORDER("refund_order"),
	//人工手动修改 
	MANUALLY_BALANCE("manually_balance"),
	//余额支付
	BALANCE_PAYMENT("balance_payment"),
	//微信支付
	WECHAT_PAYMENT("wechat_payment"),
	
	SHARE_REGISTER_POINT("通过扫二维码注册得T金"),
	
	PAY_DEDCUT_POINT("下单抵扣T金"),
	
	ORDER_POINT_RETURN("成功下单所得T金"),
	
	BUYSHOW_POINT("发布买家秀所得T金");
	 
	public String value;
   

    BalaceFrom(String value) {  
        this.value = value; 
    }  
}
