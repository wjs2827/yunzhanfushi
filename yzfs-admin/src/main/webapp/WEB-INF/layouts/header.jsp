<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head lang="zh-cn">
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class='navbar-inner'>
		<div class='container-fluid'>
			<a href='javascript:;' class='brand hidden-phone ion toggle'
				data-toggle='collapse' data-target='.nav-collapse'> <img
				src='${contextPath}/static/image/sidebar-toggler.jpg'></a> <a
				class='brand Logo_img' href='#'> <a href='javascript:;'
				class='btn-navbar collapsed' data-toggle='collapse'
				data-target='.nav-collapse'></a>
				<ul class='nav pull-right' style="border: none;">
					<li class='dropdown user'><a href='#' class='dropdown-toggle'
						data-toggle='dropdown'> <img alt=''
							src='${contextPath}/static/image/avatar1_small.jpg'
							style='border-radius: 5rem;' /> <span class='username'>${sessionScope.session_yzfs_amdin_info.loginName}</span>
							<i class='icon-angle-down'> </i></a>
						<ul class='dropdown-menu User' style="background: #fefefe"">
							<li id="li_layout_header_changpwd"><a
								href="${contextPath }/change_pwd"><i class='icon-key'></i>
									修改密码</a></li>
							<li id="li_layout_header_logout" contextPath="${contextPath}">
								<a data-toggle="modal" onclick="logout()"><i
									class='icon-user'></i>退出</a>
							</li>
						</ul></li>
				</ul>
		</div>
	</div>
</body>
<script type="text/javascript">
	function logout(){
		if(confirm("确定要退出登录吗？"))
		 {
			window.location.href="${contextPath}/logout";
		 }
	}
</script>
</html>