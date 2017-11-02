package com.wmeimob.yzfs.api.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.RegisterServiceApi;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.weixin.CheckError;

@RequestMapping("/register/api")
@CrossOrigin
@Transactional
@RestController
public class RegisterControllerApi{
	
	private static Logger logger = Logger.getLogger(CoreControllerApi.class);

	@Autowired
	private RegisterServiceApi registerServiceApi;

	/**
	 * 注册并绑定用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public JSONObject bangdingUser(HttpServletRequest request){
		JSONObject data = new JSONObject();
		try {
			data=registerServiceApi.bangdingUser(request);
		} catch (CustomException e) {
			logger.debug(new Date()+"######################"+e.getMessage()+" ##########################");
			data.put("code", CheckError.SYSTEM_ERROR.value);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
		return data;
	}
	
    /**
     * 保存支付密码
     * @param request
     * @param promoterCode
     * @return
     */
    @RequestMapping(value="/savePaypasswd",method = RequestMethod.POST)
    public JSONObject savePaypasswd(HttpServletRequest request) {
    	//获取md5密码进行修改保存支付密码
    	JSONObject data = new JSONObject();
    	try {
			data=registerServiceApi.setPayPassword(request);
		} catch (CustomException e) {
			data.put("code", CheckError.SYSTEM_ERROR.value);
			data.put("data", "");
			data.put("message", "Network anomaly");
		}
    	return data;
    }
	
	
}
