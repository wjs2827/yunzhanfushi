package com.wmeimob.yzfs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wmeimob.yzfs.dao.AdminMapper;
import com.wmeimob.yzfs.dao.RoleMapper;
import com.wmeimob.yzfs.dao.RoleMenuMapper;
import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.model.Role;
import com.wmeimob.yzfs.model.RoleMenu;
import com.wmeimob.yzfs.service.RoleMenuService;
import com.wmeimob.yzfs.vo.MenuVO;
import com.wmeimob.yzfs.vo.ResultVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<RoleMenuListVO> listRoleMenu(String roleId) {
		RoleMenu example = new RoleMenu();
		example.setRoleId(roleId);
		List<MenuVO> allMenus = roleMenuMapper.selectByRoleWithStatus(roleId);

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
	public List<Role> listRole() {
		Role example = new Role();
		return roleMapper.selectByExample(example);
	}

	@Override
	public ResultVO removeRole(String roleId) {
		ResultVO result = new ResultVO();
		Role role = roleMapper.selectByPrimaryKey(roleId);
		if (role == null) {
			result.setCode(11);
			result.setMessage("角色不存在");
			return result;
		}
		Admin example = new Admin();
		example.setRoleId(roleId);
		List<Admin> admins = adminMapper.selectByExample(example);
		if (admins.size() > 0) {
			result.setCode(13);
			result.setMessage("该角色下存在管理员");
			return result;
		}
		role.setStatus(false);
		int count = roleMapper.updateByPrimaryKeySelective(role);
		if (count > 0) {
			result.setCode(0);
		} else {
			result.setCode(12);
			result.setMessage("保存数据失败，请重试");
		}
		return result;
	}

	@Override
	@Transactional
	public ResultVO saveRole(String roleName, String description, String menuValue, String roleId) {
		ResultVO result = new ResultVO();
		try {
			Boolean isEdit = false;
			Role role = new Role();
			Date now = new Date();
			if (StringUtils.isNotEmpty(roleId)) {
				isEdit = true;
				role = roleMapper.selectByPrimaryKey(roleId);
				if (role == null) {
					result.setCode(3);
					result.setMessage("角色不存在");
					return result;
				}
			}
			role.setDescription(description);
			role.setName(roleName);
			role.setUpdateTime(now);
			if (isEdit) {
				// 编辑角色
				roleMapper.updateByPrimaryKeySelective(role);
				// 删除之前的权限
				roleMenuMapper.deleteMenuByRoleId(roleId);
			} else {
				// 新增角色
				role.setId(UUID.randomUUID().toString());
				role.setCreateTime(now);
				role.setIsDisable(false);
				role.setIsFixed(false);
				role.setStatus(true);
				roleMapper.insertSelective(role);
			}

			// 保存新的权限
			String[] strMenus = menuValue.split("#");
			for (String menuid : strMenus) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setMenuId(menuid);
				roleMenu.setStatus(true);
				roleMenu.setRoleId(role.getId());
				String rmuuid = UUID.randomUUID().toString();
				roleMenu.setId(rmuuid);
				roleMenu.setUpdateTime(now);
				roleMenu.setUpdateTime(now);
				roleMenuMapper.insert(roleMenu);
			}
			result.setCode(0);
		} catch (Exception e) {
			result.setCode(11);
			result.setMessage("保存失败，请重试");
		}
		return result;
	}

	@Override
	public Role getRoleById(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

}
