package com.wmeimob.yzfs.weixin;

import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.core.WeChatBuilder;

public class WeChatUtil {

	public static final String APP_ID = WeChatConfig.getValue("wechat.AppID");
	public static final String APP_SECRET = WeChatConfig.getValue("wechat.AppSecret");
	public static final String WECHAT_WEBSET = WeChatConfig.getValue("wechat.WebSite");
	public static final String WECHAT_VUESITE = WeChatConfig.getValue("wechat.VueSite");
	public static final String AUTH_URL = WeChatConfig.getValue("wechat.AuthUrl");
	public static final String WECHAT_WEBPATH= WeChatConfig.getValue("wechat.WetPath");
	public static final String PAYCALLBlack = WeChatConfig.getValue("wechat.PayCallBlack");//下单支付回调
	public static final String RECHARGECALLBlack = WeChatConfig.getValue("wechat.RechargeCallBlack");//充值回调
	public static final String MCHID = WeChatConfig.getValue("wechat.MchId");
	public static final String MCHKEY = WeChatConfig.getValue("wechat.MchKey");
	public static final String CERT = WeChatConfig.getValue("wechat.CERT");
	public static final String TOKEN = WeChatConfig.getValue("wechat.TOKEN");
	
	//** 微信API *//*
	public static final WeChat weChat = WeChatBuilder.newBuilder(APP_ID, APP_SECRET)
			.wxMch(MCHID, MCHKEY).build();
	
    public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //获取用户基本信息 500000次/日
    public static final String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public static final String GET_USER_INFO_BASE = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public static final String GET_OPENID="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String GET_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE#wechat_redirect";
    public static String GET_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

    public static final String RED_PACKET = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

    public static final String OPEN_GET_CODE ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&component_appid=COMPONENT_APPID#wechat_redirect";
    
    public static final String OPEN_GET_OPENID = "https://api.weixin.qq.com/sns/oauth2/component/access_token?appid=APPID&code=CODE&grant_type=authorization_code&component_appid=COMPONENT_APPID&component_access_token=COMPONENT_ACCESS_TOKEN";
    public static final String GET_COMPONENT_TOKEN="https://api.weixin.qq.com/cgi-bin/component/api_component_token";
    public static final String REFRESH_AUTHORIZER_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=COMPONENT_ACCESS_TOKEN";

    public static final String SEND_CUSTOM_MSG="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

    public static final String SEND_TEMPLATE_MSG="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    public static final String GET_TEMPLATE_ID = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    public static final String GET_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
}
