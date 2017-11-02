package com.wmeimob.yzfs.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.WechatException;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.util.JwtTokenUtil;

/**
 * 微信拦截器
 * 
 * @author wjs
 */
@Component
public class WxInterceptor implements HandlerInterceptor {

	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
    private UsersMapper usersMapper;
	
	private static Log log = LogFactory.getLog(WxInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	/**
	 * 微信授权拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String authToken = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String requestMethod = request.getMethod();//提交方式
		String requestURI = request.getRequestURI();//方法路径
		boolean isAuth=false;
		log.debug("##############################请求来自："+request.getRemoteAddr());
		//如果是支付成功回调的请求，则通过
		if (requestURI.indexOf("Call") > -1) {
			return true;
		}
		log.debug("##############################头部传入的token身份识别："+authToken);
		if (authToken != null && !StringUtils.isEmpty(authToken)) {
			log.debug("##############################根据Token获取用户ID");
			String userId = jwtTokenUtil.getIdFromToken(authToken);
			log.debug("##############################用户ID："+userId);
			User user=new User();
			if(!StringUtils.isEmpty(userId)){
				log.debug("##############################根据用户ID开始获取用户信息");
			    user=usersMapper.queryUserAccountInfo(userId);
				log.debug("##############################获取用户信息结束");
			}else{
				log.debug("##############################用户不存在");
	          	response.setStatus(HttpStatus.FORBIDDEN.value());
            	throw new WechatException(HttpStatus.FORBIDDEN, "未授权");
			}
			//授权过期
			log.debug("##############################Token授权是否过期");
			if (!jwtTokenUtil.isTokenExpired(authToken)) {
				if(user==null || StringUtils.isEmpty(user.getId())){
					log.debug("##############################用户不存在");
		          	response.setStatus(HttpStatus.FORBIDDEN.value());
	            	throw new WechatException(HttpStatus.FORBIDDEN, "未授权");
				}
				if ((!"GET".equals(requestMethod) && (requestURI.contains("/order/api") || requestURI.contains("/center/api")))){
					log.debug("##############################判断是否注册");
					if(StringUtils.isEmpty(user.getMobile())){
						System.out.println("######MOBILE:"+user.getMobile());
						//未注册
			          	response.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
		            	throw new WechatException(HttpStatus.PAYMENT_REQUIRED, "未注册");
					}else{
						isAuth=true;
						return isAuth;
					}
				}else{
					isAuth=true;
					return isAuth;
				}
			} else {
	          	response.setStatus(HttpStatus.FORBIDDEN.value());
            	throw new WechatException(HttpStatus.FORBIDDEN, "未授权");
			}
		}
      	response.setStatus(HttpStatus.FORBIDDEN.value());
    	throw new WechatException(HttpStatus.FORBIDDEN, "未授权");
	}

}
