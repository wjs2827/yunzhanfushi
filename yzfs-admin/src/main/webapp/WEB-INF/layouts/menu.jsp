<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<ul class="page-sidebar-menu">
	<li class="start"><a rel="menu_a_flag"> <i class="icon-home"></i>
			<span class="title">首页</span> <span class="arrow"></span>
	</a></li>

	<!--slideBar-->
	<c:forEach items="${sessionScope.session_yzfs_amdin_menu}"
		var="parentMenu">
		<c:if test="${!empty parentMenu.menus }">
			<li class=""><a href="javascript:;"> <i
					class="icon-download"></i> <span class="title">${parentMenu.parentMenu.name}</span>
					<span class="arrow"></span>
			</a>
				<ul class="sub-menu">
					<c:forEach items="${parentMenu.menus}" var="menu">
						<c:if test="${menu.parentMenu.type==1 }">
							<c:choose>
								<c:when test="${menu.parentMenu.url!= '#'}">
									<li class="city_manage"><a rel="menu_a_flag"
										href="${contextPath}${menu.parentMenu.url}">${menu.parentMenu.name}</a></li>
								</c:when>
								<c:otherwise>
									<li class="city_manage"><a rel="menu_a_flag" href="#">${menu.parentMenu.name}</a></li>
								</c:otherwise>
							</c:choose>
						</c:if>
					</c:forEach>
				</ul></li>
		</c:if>
	</c:forEach>
</ul>
