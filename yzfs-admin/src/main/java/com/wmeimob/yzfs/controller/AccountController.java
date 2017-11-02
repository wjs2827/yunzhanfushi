package com.wmeimob.yzfs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.service.AccountService;
import com.wmeimob.yzfs.util.AES128Util;
import com.wmeimob.yzfs.util.CookieUtil;
import com.wmeimob.yzfs.util.Md5Util;
import com.wmeimob.yzfs.vo.ResultVO;



@Controller
@RequestMapping("")
public class AccountController extends BaseController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private AccountService accountService;

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("account_login");
		// 是否记住密码
		Cookie cookie = CookieUtil.getCookie(CookieUtil.KEY_ADMIN_INFO);
		if (cookie != null) {
			String str = AES128Util.decrypt(CookieUtil.KEY_COOKIE_AES, cookie.getValue());
			if (StringUtils.isNotEmpty(str)) {
				String[] strs = str.split(" ");
				if (strs == null || strs.length == 0) {
					return mv;
				}
				
				String loginName = strs[0];
				String password = strs[1];
				ResultVO result = accountService.login(loginName, password, "1");
				if (result.getCode() == 0) {
					// TODO 修改为请求地址
//					mv.setViewName("show_list");
					mv.setViewName("admin_index");
				}
			}
		}
		return mv;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO login(HttpServletRequest request) {
		ResultVO result = new ResultVO();
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		if (StringUtils.isEmpty(loginName)) {
			result.setCode(1);
			result.setMessage("用户名不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(password)) {
			result.setCode(1);
			result.setMessage("密码不可以为空");
			return result;
		}
		log.debug("##############LoginController login##############loginName:" + loginName + " password:" + password);
		password = Md5Util.Md5(password);
		result = accountService.login(loginName, password, remember);
		return result;
	}

	/**
	 * 进入修改密码页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "change_pwd", method = RequestMethod.GET)
	public ModelAndView changePwd() {
		ModelAndView mv = new ModelAndView("account_change_pwd");
		return mv;
	}

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "change_pwd", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO changePwd(HttpServletRequest request) {
		ResultVO result = new ResultVO();
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		if (StringUtils.isEmpty(oldPwd)) {
			result.setCode(1);
			result.setMessage("旧密码不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(newPwd)) {
			result.setCode(2);
			result.setMessage("新密码不可以为空");
			return result;
		}
		result = accountService.changePassword(oldPwd, newPwd);
		return result;
	}

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("account_login");
		accountService.logout();
		return mv;
	}
}
