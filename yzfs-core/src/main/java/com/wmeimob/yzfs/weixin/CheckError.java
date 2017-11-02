package com.wmeimob.yzfs.weixin;

/**
 * 校验错误返回码
 * @author WMM08
 *
 */
public enum CheckError {
	//成功
    SUCCESS(100),
	//系统异常
    SYSTEM_ERROR(404),
    //未登录
    IS_NOT_LOGIN(403),
	//收货人
	SHIPPING_NAME_ERROR(1000),
	//省份ID
	PROVINCE_ID_ERROR(1001),
	//城市ID
	CITY_ID_ERROR(1002),
	//区域ID
	REGION_ID_ERROR(1003),
	//手机号码不合法
	MOBILE_ERROR(1004),
	//余额支付
	ADDRESS_ITEM_ERROR(1005),
	//手机号码已经存在或者为空
	MOBILE_EXIST(200),
	//手机验证码过期
	REGION_CODE_GQ(3001),
	//手机验证码为空
	REGION_CODE_EMPTY(3002),
	//手机验证码错误
	REGION_CODE_ERROR(3003);
	 
	public int value;
   
    CheckError(int value) {  
        this.value = value; 
    }  
}
