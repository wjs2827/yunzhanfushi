package com.wmeimob.yzfs.service;

import java.util.List;

import com.wmeimob.yzfs.model.Role;
import com.wmeimob.yzfs.vo.ResultVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;


/**
 * 菜单Service
 */
public interface RoleMenuService {

	/**
	 * 获取角色菜单列表(后台管理菜单)
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleMenuListVO> listRoleMenu(String roleId);

	/**
	 * 通过roleId查询role
	 * 
	 * @param roleId
	 * @return
	 */
	Role getRoleById(String roleId);

	/**
	 * 获取所有的角色
	 * 
	 * @return
	 */
	List<Role> listRole();

	/**
	 * 保存编辑或者新增的角色
	 * 
	 * @return
	 */
	ResultVO saveRole(String roleName, String description, String menuValue, String roleId);

	/**
	 * 删除一个角色
	 * 
	 * @param roleId
	 * @return
	 */
	ResultVO removeRole(String roleId);
}
