package com.wmeimob.yzfs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmeimob.yzfs.dao.AdminMapper;
import com.wmeimob.yzfs.dao.RoleMenuMapper;
import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.model.RoleMenu;
import com.wmeimob.yzfs.service.AccountService;
import com.wmeimob.yzfs.util.AES128Util;
import com.wmeimob.yzfs.util.CookieUtil;
import com.wmeimob.yzfs.util.Md5Util;
import com.wmeimob.yzfs.util.SessionUtil;
import com.wmeimob.yzfs.vo.MenuVO;
import com.wmeimob.yzfs.vo.ResultVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	public ResultVO login(String loginName, String password, String remember) {
		ResultVO result = new ResultVO();
		Admin example = new Admin();
		example.setLoginName(loginName);
		// 1.账号是否存在
		List<Admin> exists = adminMapper.selectByExample(example);
		if (exists == null || exists.isEmpty()) {
			result.setCode(11);
			result.setMessage("账户不存在");
			return result;
		}
		Admin exist = exists.get(0);
		// 2.账户是否禁用
		if (exist.getIsDisable()) {
			result.setCode(12);
			result.setMessage("账户已被禁用");
			return result;
		}
		// 3.密码是否正确
		if (!password.equals(exist.getPassword())) {
			result.setCode(13);
			result.setMessage("密码不正确");
			return result;
		}
		// 4.加入session
		HttpSession session = SessionUtil.setSession(SessionUtil.SESSION_ADMIN_INFO, exist);
		List<RoleMenuListVO> menus = listRoleMenu(exist.getRoleId());
		SessionUtil.setSession(session, SessionUtil.SESSION_ADMIN_MENU, menus);
		SessionUtil.setSession(session, SessionUtil.SESSION_ADMIN_MENU, menus);

		// 5.记住密码
		if ("1".equals(remember)) {
			String text = loginName + " " + password;
			CookieUtil.addCookie(CookieUtil.KEY_ADMIN_INFO, AES128Util.encrypt(CookieUtil.KEY_COOKIE_AES, text),
					604800);
		}
		result.setCode(0);
		return result;
	}

	@Override
	public List<RoleMenuListVO> listRoleMenu(String roleId) {
		RoleMenu example = new RoleMenu();
		example.setRoleId(roleId);
		List<MenuVO> allMenus = roleMenuMapper.selectByRoleId(roleId);
		RoleMenuListVO rmvo = new RoleMenuListVO();
		MenuVO parentMenu = new MenuVO();
		parentMenu.setId("0");
		rmvo.setParentMenu(parentMenu);
		rmvo.setMenus(new ArrayList<RoleMenuListVO>());
		return buildMenuTree(rmvo, allMenus);
	}

	/**
	 * 构建菜单树
	 * 
	 * @param menuListVO
	 * @return
	 */
	private List<RoleMenuListVO> buildMenuTree(RoleMenuListVO rmvo, List<MenuVO> allMenus) {
		MenuVO menu = rmvo.getParentMenu();
		List<RoleMenuListVO> roleMenuList = rmvo.getMenus();
		for (MenuVO m : allMenus) {
			if (m.getParentId().equals(menu.getId())) {
				RoleMenuListVO mv = new RoleMenuListVO();
				mv.setParentMenu(m);
				mv.setMenus(new ArrayList<RoleMenuListVO>());
				roleMenuList.add(mv);
				buildMenuTree(mv, allMenus);
			}
		}
		return roleMenuList;
	}

	@Override
	public ResultVO changePassword(String oldPwd, String newPwd) {
		Admin admin = SessionUtil.getValue(SessionUtil.SESSION_ADMIN_INFO);
		ResultVO result = new ResultVO();
		oldPwd = Md5Util.Md5(oldPwd);
		if (admin == null) {
			result.setCode(11);
			result.setMessage("用户未登录");
			return result;
		}
		if (!oldPwd.equals(admin.getPassword())) {
			result.setCode(12);
			result.setMessage("密码不正确");
			return result;
		}

		newPwd = Md5Util.Md5(newPwd);
		admin.setPassword(newPwd);
		int count = adminMapper.updateByPrimaryKeySelective(admin);
		if (count > 0) {
			// 编辑成功
			CookieUtil.deleteCookie(CookieUtil.KEY_ADMIN_INFO);
			SessionUtil.delete();
			result.setCode(0);
			return result;
		} else {
			result.setCode(13);
			result.setMessage("系统异常，请重试");
			return result;
		}
	}

	@Override
	public void logout() {
		CookieUtil.deleteCookie(CookieUtil.KEY_ADMIN_INFO);
		SessionUtil.delete();
	}

	@Override
	public Admin selectById(String id) {
		return adminMapper.selectByPrimaryKey(id);
	}
}
