package com.wmeimob.yzfs.vo;

import java.io.Serializable;
import java.util.List;



/**
 * 角色对应的菜单列表VO
 */
public class RoleMenuListVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8400449755503256894L;

	private MenuVO parentMenu;

	private List<RoleMenuListVO> menus;

	public MenuVO getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuVO parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<RoleMenuListVO> getMenus() {
		return menus;
	}

	public void setMenus(List<RoleMenuListVO> menus) {
		this.menus = menus;
	}
}
