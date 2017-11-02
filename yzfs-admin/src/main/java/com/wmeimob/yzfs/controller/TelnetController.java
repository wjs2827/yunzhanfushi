package com.wmeimob.yzfs.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.util.SessionUtil;
/**
 * 远程登陆
 */
@Controller
@RequestMapping("/admin/telnet")
public class TelnetController {


	/**
	 * 后台管理系统首页
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse reponse) {
		ModelAndView mv = new ModelAndView("slyder");
		Admin exist =(Admin)request.getSession().getAttribute(SessionUtil.SESSION_ADMIN_INFO);
		String redirectUrl="http://www.baidu.com";
		mv.addObject("redirectUrl",redirectUrl);
		return mv;
	}

}
