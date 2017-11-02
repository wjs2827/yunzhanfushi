package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.model.RoleMenu;
import com.wmeimob.yzfs.vo.MenuVO;

public interface RoleMenuMapper {
	int deleteByPrimaryKey(String id);

	int insert(RoleMenu record);

	int insertSelective(RoleMenu record);

	RoleMenu selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(RoleMenu record);

	int updateByPrimaryKey(RoleMenu record);

	/**
	 * 通过roleID查询
	 * 
	 * @param roleId
	 * @return
	 */
	List<MenuVO> selectByRoleId(String roleId);

	/**
	 * 通过roleID查询,并判断是否被选中 isSelected
	 * 
	 * @param roleId
	 * @return
	 */
	List<MenuVO> selectByRoleWithStatus(String roleId);

	/**
	 * 删除角色下的所有权限
	 * 
	 * @param roleId
	 * @return
	 */
	int deleteMenuByRoleId(String roleId);

}