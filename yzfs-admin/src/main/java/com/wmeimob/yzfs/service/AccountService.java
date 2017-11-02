package com.wmeimob.yzfs.service;

import java.util.List;

import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.vo.ResultVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;



/**
 * 账户Service
 */
public interface AccountService {

	/**
	 * 通过ID选取管理员
	 * 
	 * @param id
	 * @return
	 */
	Admin selectById(String id);

	/**
	 * 登录
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	ResultVO login(String loginName, String password, String remember);

	/**
	 * 获取角色菜单列表
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleMenuListVO> listRoleMenu(String roleId);

	/**
	 * 修改密码
	 * 
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	ResultVO changePassword(String oldPwd, String newPwd);

	void logout();
}
