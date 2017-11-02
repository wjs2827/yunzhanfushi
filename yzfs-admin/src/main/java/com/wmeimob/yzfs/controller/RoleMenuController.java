package com.wmeimob.yzfs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.model.Role;
import com.wmeimob.yzfs.service.RoleMenuService;
import com.wmeimob.yzfs.vo.ResultVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;

/**
 * 角色和菜单Controller
 */
@Controller
@RequestMapping("/admin/role")
public class RoleMenuController extends BaseController {
	
	@Autowired
	private RoleMenuService roleMenuService;

	/**
	 * 进入角色列表页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("role_list");
		mv.addObject("roles", roleMenuService.listRole());
		return mv;
	}

	/**
	 * Post请求角色列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO list(HttpServletRequest request) {
		ResultVO result = new ResultVO();
		result.setCode(0);
		List<Role> roles = roleMenuService.listRole();
		result.setData(roles);
		return result;
	}

	/**
	 * 进入添加角色的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("role_add");
		return mv;
	}

	/**
	 * 进入编辑页面
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(value = "roleId", required = true) String roleId) {
		ModelAndView mv = new ModelAndView("role_edit");
		Role role = roleMenuService.getRoleById(roleId);
		mv.addObject("role", role);
		return mv;
	}
	
	/**
	 * 获取角色的菜单
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/edit/getMenus", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO getMenus(String roleId) {
		ResultVO result = new ResultVO();
		List<RoleMenuListVO> menuList = roleMenuService.listRoleMenu(roleId);
		result.setCode(0);
		result.setData(menuList);
		return result;
	}


	/**
	 * post添加角色
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/add", "/edit" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultVO save(HttpServletRequest request) {
		ResultVO result = new ResultVO();
		String roleName = request.getParameter("name");
		String description = request.getParameter("description");
		String menuValue = request.getParameter("menuValue");
		if (StringUtils.isEmpty(roleName)) {
			result.setCode(1);
			result.setMessage("角色名称不可以为空");
			return result;
		}
		if (StringUtils.isEmpty(menuValue)) {
			result.setCode(2);
			result.setMessage("角色没有分配权限");
			return result;
		}
		result = roleMenuService.saveRole(roleName, description, menuValue, request.getParameter("roleId"));
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
	public ResultVO delete(String roleId) {
		ResultVO result = new ResultVO();
		if (StringUtils.isEmpty(roleId)) {
			result.setCode(1);
			result.setMessage("角色不存在");
		}
		result = roleMenuService.removeRole(roleId);
		return result;
	}
}
