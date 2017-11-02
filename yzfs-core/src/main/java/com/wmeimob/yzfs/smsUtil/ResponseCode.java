package com.wmeimob.yzfs.smsUtil;

public class ResponseCode {
	//成功通用
	public final static String SUCCESS = "0000";
	//失败通用
	public final static String FAILED = "9999";
	//参数为空
	public final static String VALUE_EMPTY = "0001";
	//查找结果为空
	public final static String RESULT_EMPTY = "0001";
	
	//校验用户手机号返回码
	public final static String MOBILE_ALREADY_EXIST = "1000";//手机号已经被注册
	public final static String MOBILE_REGISTER_TIMES = "1001";//手机号被多人注册
	public final static String MOBILE_EMPTY = "1002";//手机号码为空
	public final static String VALID_EMPTY = "1003";//手机号码为空
	
	public final static String VALID_CODE_SEND_SUCCESS = "1004";//发送验证码成功
	public final static String VALID_CODE_ERROR = "1005";//发送验证码成功
	
	public final static String MOBILE_CHECK_ERROR = "1006";//发送验证码成功
}
