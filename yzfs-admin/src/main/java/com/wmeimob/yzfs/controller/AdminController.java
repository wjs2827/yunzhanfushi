package com.wmeimob.yzfs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.model.Role;
import com.wmeimob.yzfs.qiniu.QiniuUtil;
import com.wmeimob.yzfs.service.AdminService;
import com.wmeimob.yzfs.service.RoleMenuService;
import com.wmeimob.yzfs.vo.AdminVO;
import com.wmeimob.yzfs.vo.ResultVO;

/**
 * 管理后台主页
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private RoleMenuService roleMenuService;

	/**
	 * 后台管理系统首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin_index");
		return mv;
	}

	/**
	 * 七牛Token
	 * 
	 * @return
	 */
	@RequestMapping("/qiniu_token")
	@ResponseBody
	public Map<String, Object> qiniuToken() {
		return QiniuUtil.getAccessToken();
	}

	/**
	 * 管理员列表
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin_list");
		Admin example = new Admin();
		List<AdminVO> admins = adminService.lsitAdmin(example);
		mv.addObject("admins", admins);
		List<Role> roles = roleMenuService.listRole();
		mv.addObject("roles", roles);
		return mv;
	}

	/**
	 * 添加
	 * 
	 * @param adminName
	 * @return
	 */
	@RequestMapping(value = { "/add", "/edit" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultVO save(HttpServletRequest request) {
		ResultVO result = new ResultVO();
		String loginName = request.getParameter("loginName");
		String realName = request.getParameter("realName");
		String mobile = request.getParameter("mobile");
		String roleId = request.getParameter("roleId");
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(loginName)) {
			result.setCode(1);
			result.setMessage("登录名不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(realName)) {
			result.setCode(2);
			result.setMessage("姓名不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(mobile)) {
			result.setCode(1);
			result.setMessage("手机号码不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(roleId)) {
			result.setCode(1);
			result.setMessage("管理员角色不可以为空");
			return result;
		}
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		admin.setMobile(mobile);
		admin.setRealName(realName);
		admin.setRoleId(roleId);
		if (StringUtils.isNotEmpty(id)) {
			admin.setId(id);
		}
		result = adminService.saveAdmin(admin);
		return result;
	}

	/**
	 * post删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO delete(String adminId) {
		ResultVO result = new ResultVO();
		if (StringUtils.isEmpty(adminId)) {
			result.setCode(1);
			result.setMessage("用户不存在");
		}
		result = adminService.removeAdmin(adminId);
		return result;
	}
}
