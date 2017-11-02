package com.wmeimob.yzfs.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wmeimob.yzfs.vo.RoleMenuListVO;


/**
 * 权限认证Util
 */
public class AuthorityUtil {

	/**
	 * 是否被允许
	 * @param url
	 * @return
	 */
	public static boolean isPermit(String url) {
//		List<RoleMenuListVO> menuList = SessionUtil.getValue(FinalSessionKey.KEY_SESSION_ADMIN_MENU);
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//				.getRequest();
//		if (menuList != null && menuList.size() > 0) {
//			for (RoleMenuListVO pm : menuList) {
//				for (RoleMenuListVO m : pm.getMenus()) {
//					if (url.startsWith(request.getContextPath() + m.getParentMenu().getUrl())) {
//						return true;
//					}
//				}
//			}
//		}
		return false;
	}
}
