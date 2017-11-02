package com.wmeimob.yzfs.api.controller;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.core.WxException;
import com.wmeimob.wechat.model.basic.WxAuthAccessToken;
import com.wmeimob.wechat.model.basic.WxJsSdkConfig;
import com.wmeimob.wechat.model.pay.WxPayNotify;
import com.wmeimob.wechat.model.user.WxUserInfoBase;
import com.wmeimob.yzfs.api.service.MemberServiceApi;
import com.wmeimob.yzfs.api.service.OrderServiceApi;
import com.wmeimob.yzfs.api.service.RegisterServiceApi;
import com.wmeimob.yzfs.api.smsUtil.AliyunSmsUtil;
import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.OrdersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.qiniu.QiniuUtil;
import com.wmeimob.yzfs.smsUtil.ErrorCode;
import com.wmeimob.yzfs.smsUtil.ResponseCode;
import com.wmeimob.yzfs.smsUtil.SmsUtils;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.util.JwtUserFactory;
import com.wmeimob.yzfs.util.JwtWechatUser;
import com.wmeimob.yzfs.weixin.CheckError;
import com.wmeimob.yzfs.weixin.WeChatUtil;

@Controller
@RequestMapping("/core/auth")
@CrossOrigin
@Transactional
public class CoreControllerApi extends BaseController {
	
	private static Logger logger = Logger.getLogger(CoreControllerApi.class);
	
	
	//注解用来存取值的REDIS
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	MemberServiceApi  memberServiceApi;
	
	@Autowired
	RegisterServiceApi  registerServiceApi;
	
	@Autowired
	OrderServiceApi  orderServiceApi;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	OrdersMapper  ordersMapper;
	
	@Autowired
	OrderItemsMapper orderItemsMapper;
	
	
	
	/**
	 * 登录
	 * @param response
	 * @param pUserId 分享人的userid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login")
	public String login(HttpServletResponse response,HttpSession session,String pUserId) throws IOException {
		String appid =WeChatUtil.APP_ID;
		String webSite = WeChatUtil.WECHAT_WEBSET;
		String url = WeChatUtil.GET_CODE_URL.replaceAll("APPID", appid);
		if (StringUtils.isEmpty(pUserId)) {
			url = url.replaceAll("REDIRECT_URI", URLEncoder.encode(webSite.trim() + "/core/auth/saveOpenId", "utf-8"));
		} else {
			url = url.replaceAll("REDIRECT_URI", URLEncoder.encode(webSite.trim() + "/core/auth/saveOpenId?pUserId=" + pUserId, "utf-8"));
		}
		
		log.debug("###############################回掉地址信息:"+url+"#################################");
		return "redirect:" + url;
	}
	
	
	/**
	 * 设置openId
	 */
	@RequestMapping("/saveOpenId")
	public String saveOpenId(String code, HttpServletResponse response, HttpServletRequest request, HttpSession session,String pUserId) {
		WeChat weChat = WeChatUtil.weChat;
		log.debug("########################回调开始授权#####################");
		//获取用户授权信息
		WxAuthAccessToken auth = weChat.basic().authAccessToken(code);
		String openId = auth.getOpenId();
		//获取用户基本信息
		WxUserInfoBase userInfoBase=weChat.user().userInfoBase(openId);
		//根据用户微信OPENID查询用户信息
		User user=new User();
		try {
			user = memberServiceApi.saveUserInfo(userInfoBase,pUserId);
		} catch (CustomException e) {
			e.printStackTrace();
		}
		JwtWechatUser users = JwtUserFactory.create(user);
		final String token = jwtTokenUtil.generateToken(users);
		log.debug("########################授权信息token:"+token);
		log.debug("########################授权信息是否过期:"+jwtTokenUtil.isTokenExpired(token));
		log.debug(WeChatUtil.WECHAT_VUESITE+ "/wechatLogin/" + token);
		return "redirect:" +WeChatUtil.WECHAT_VUESITE+"/wechatLogin?token=" + token;
	}
	
    /**
     * 微信下单支付回调
     */
    @RequestMapping(value="/wxPayCallback")
    public void wxPayCallback(HttpServletRequest request, HttpServletResponse response) {
        // 获取收到的报文
        try {
        	log.debug("################获取body消息#############################");
            String xmlString = HttpUtil.requestGetBody(request);
            log.debug("################xmlString="+xmlString+"#############################");
            // 签名认证
            WeChat weChat = WeChatUtil.weChat;
            WxPayNotify notify = weChat.pay().wxNotify(xmlString);
            log.debug("################resultCode:"+notify.getResultCode()+"returnCode:"+notify.getReturnCode()+"#############################");
            if("SUCCESS".equals(notify.getReturnCode())&&"SUCCESS".equals(notify.getResultCode())){
            	log.debug("################签名验证成功#############################");
            	log.debug("################签名验证成功#############################");
	            //变更订单信息以及库存
	    	    //1变更订单状态为支付状态
	            JSONObject data =new JSONObject();
	            data=orderServiceApi.wxCallbackDeal(request, notify);
	            if(data.get("msg").equals("success")){
		            //告诉微信服务器，我收到信息了，不要在调用回调action了
		            String sx = "<xml>";
		            sx += "<return_code><![CDATA[SUCCESS]]></return_code>";
		            sx += "<return_msg><![CDATA[OK]]></return_msg>";
		            sx += "</xml>";
		            response.getWriter().write(sx);
		            response.setContentType("text/xml");
		            response.getWriter().flush();
	            }
            }else{
            	log.debug("################签名验证失败#############################");
            }
        } catch (WxException e) {
            log.error("====HomeController callback error ,e==" + e);
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    /**
     * 微信充值支付回调
     */
    @RequestMapping("/rechargeCallback")
    public void rechargeCallback(HttpServletRequest request, HttpServletResponse response) {
        // 获取收到的报文
        try {
        	log.debug("################获取body消息#############################");
            String xmlString = HttpUtil.requestGetBody(request);
            log.debug("################xmlString="+xmlString+"#############################");
            // 签名认证
            WeChat weChat = WeChatUtil.weChat;
            WxPayNotify notify = weChat.pay().wxNotify(xmlString);
            log.debug("################resultCode:"+notify.getResultCode()+"returnCode:"+notify.getReturnCode()+"#############################");
            if("SUCCESS".equals(notify.getReturnCode())&&"SUCCESS".equals(notify.getResultCode())){
            	log.debug("################签名验证成功#############################");
            //变更订单信息以及库存
    	    //1变更订单状态为支付状态
            JSONObject data =new JSONObject();
            data=orderServiceApi.wxRechargeCallback(request, notify);
            if(data.get("msg").equals("success")){
	            //告诉微信服务器，我收到信息了，不要在调用回调action了
	            String sx = "<xml>";
	            sx += "<return_code><![CDATA[SUCCESS]]></return_code>";
	            sx += "<return_msg><![CDATA[OK]]></return_msg>";
	            sx += "</xml>";
	            response.getWriter().write(sx);
	            response.setContentType("text/xml");
	            response.getWriter().flush();
            }
	          }else{
	        	log.debug("################签名验证失败#############################");
	        }
        } catch (WxException e) {
            log.error("====HomeController callback error ,e==" + e);
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 余额支付回调
     */
    @RequestMapping(value="/balaceCallBack",method = RequestMethod.POST)
    public void balaceCallBack(HttpServletRequest request, HttpServletResponse response) {
        try {
            //变更订单信息以及库存
    	    //1变更订单状态为支付状态
            JSONObject data =new JSONObject();
            data=orderServiceApi.BalanceCallbackDeal(request);
            if(data.get("msg").equals("success")){
            	log.error("====余额支付回掉成功######################!");
            }
        } catch (WxException e) {
            log.error("====余额支付回掉失败" + e);
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * 发送短信验证码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sendSmsCode",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject sendSmsCode(HttpServletRequest request,@Param("mobile") String mobile){
		logger.debug("###################第一步：发送短信到【"+mobile+"】手机上############################");
		JSONObject json = new JSONObject();
        String responseCode = ErrorCode.UNKNOWN_ERROR;
        logger.debug("###################第二步：发送前编码【"+responseCode+"】############################");
        try {
            if (StringUtils.isBlank(mobile)) {
                responseCode = ResponseCode.MOBILE_EMPTY;
                json.put("code",ResponseCode.MOBILE_EMPTY);
    			json.put("msg", "mobile can not be null");
            }else{
            	logger.debug("###################第三步：开始校验手机是否绑定############################");
                responseCode = registerServiceApi.checkMobileExist(mobile);
                logger.debug("###################第四步：校验结果【"+responseCode+"】############################");
                if (ResponseCode.SUCCESS.equals(responseCode)) {
                	//如果不存在，发送短信验证码
            		String regCode= SmsUtils.getCode();
            		logger.debug("###################第五步：开始发送短信############################");
            		//验证该手机号是否已经绑定
            		SendSmsResponse sendSmsResponse=AliyunSmsUtil.sendSms(mobile,regCode);
        			if (sendSmsResponse != null && !StringUtils.isEmpty(sendSmsResponse.getRequestId())
        					&& "OK".equals(sendSmsResponse.getCode())) {
            			logger.debug("###################验证码：【"+regCode+"】发送成功并开始存值到redis############################");
            			redisTemplate.boundValueOps("REGCODE:"+mobile).set(regCode, 60*5, TimeUnit.SECONDS);
            			logger.debug("###################存值成功############################");
            			json.put("code",CheckError.SUCCESS.value);
            			json.put("msg", "success");
            			return json;
            		}else{
            			json.put("code",CheckError.SYSTEM_ERROR.value);
            			json.put("msg", "亲!短信发送太频繁哦!");
            			return json;
            		}
                }else{
        			json.put("code",CheckError.MOBILE_EXIST.value);
        			json.put("msg", "亲!该手机号码已经绑定!");
        			return json;
                }
            }
        } catch (Exception e) {
            logger.error("user checkMobileAndCardId error , info =" + e);
			json.put("code",CheckError.SUCCESS.value);
			json.put("msg", "error");
			return json;
        }
        return json;
	}
	
	/**
	 * 七牛Token
	 * 
	 * @return
	 */
	@RequestMapping("/qiniuToken")
	@ResponseBody
	public JSONObject qiniuToken() {
		JSONObject data = new JSONObject();
		Map<String,Object> map = new HashMap<String,Object>();
		map=QiniuUtil.getAccessToken();
		data.put("code", 100);
		data.put("data", map);
		data.put("message", "success");
		return data;
	}
	
	/**
     * 计算微信扫一扫签名时间戳等参数
     * @param request
     * @param promoterCode
     * @return
     */
	@RequestMapping("/getSdkConfig")
	@ResponseBody
	public JSONObject getSDKConfig(HttpServletRequest request,String url){
		JSONObject data = new JSONObject();
		WeChat weChat = WeChatUtil.weChat;
		log.debug("########################开始获取JSTOKEN#####################");
		WxJsSdkConfig wxJsSdkConfig=weChat.jssdk().config(url);
		data.put("code", 100);
		data.put("data", wxJsSdkConfig);
		data.put("message", "success");
        return data;
	}
	
    /**
     * 支付测试
     * @param request
     * @param itemId 购物车商品明细ID列表
     * @return
     */
	@RequestMapping(value = "/payTest")
	public ModelAndView payTest(HttpServletRequest request) {
		ModelAndView mv =new ModelAndView("recharge");
		return mv;
	}
	
	
    /**
     * 支付测试
     * @param request
     * @param itemId 购物车商品明细ID列表
     * @return
     */
	@RequestMapping(value = "/payTestSave",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject saveOrder(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		//锁变量
		data=orderServiceApi.payTest(request);
		return data;
	}
	

}
