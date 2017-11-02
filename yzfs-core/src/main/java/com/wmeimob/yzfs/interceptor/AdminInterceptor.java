package com.wmeimob.yzfs.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.util.SessionUtil;
import com.wmeimob.yzfs.vo.MenuVO;
import com.wmeimob.yzfs.vo.RoleMenuListVO;

/**
 * 管理后台拦截器
 * 
 * @param
 */
public class AdminInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger("AdminInterceptor");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request = new XssHttpServletRequestWrapper(request);
		List<RoleMenuListVO> roleMenuList = SessionUtil.getValue(SessionUtil.SESSION_ADMIN_MENU);
		Admin admin = SessionUtil.getValue(SessionUtil.SESSION_ADMIN_INFO);
		log.debug("##########AdminInterceptor url##########:" + request.getRequestURI());
		if (admin == null || roleMenuList == null) {
			String redirectUrl = request.getContextPath() + "/login";
			response.sendRedirect(redirectUrl);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	/**
	 * 构建菜单树
	 * 
	 * @param menuListVO
	 * @return
	 */
	@SuppressWarnings("unused")
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

}
