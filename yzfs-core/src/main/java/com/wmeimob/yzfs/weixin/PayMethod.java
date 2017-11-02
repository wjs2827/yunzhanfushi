package com.wmeimob.yzfs.weixin;

/**
 * 支付方式枚举
 * @author WMM08
 *
 */
public enum PayMethod {
	
	//微信支付
	WECHAT_PAYMENT(1,"WECHAT_PAYMENT"),
	//余额支付
	BALANCE_PAYMENT(2,"BALANCE_PAYMENT"),
	//积分支付
	INTEGRAL_PAYMENT(3,"INTEGRAL_PAYMENT"),
	//支付宝支付
	ALIPAY_PAYMENT(4,"ALIPAY_PAYMENT");

	
	public int value;
    public String msg;  
   

    PayMethod(int value,String msg) {  
        this.value = value; 
        this.msg=msg;
    }  
}
