<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach items="${userList}" var="user">
	<tr class="">
		<td><img src='${user.headImg}' width="50px;" /></td>
		<td>${user.nickName}</td>
		<td>${user.mobile}</td>
		<td>${user.recommentNickName}</td>
		<td>${user.sumRechargeAmount}</td>
		<td>${user.amount}</td>
		<td>${user.sumPoints}</td>
		<td><fmt:formatDate value="${user.createdAt}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td><a href="#pointsChange" data-toggle="modal"
			onclick="updateUserAmount('${user.id}','${user.sumPoints}','0');">
				<img title="T金变更"
				src="${contextPath}/static/image/icon/edit_account.png"
				style="width: 21px; margin-left: 12%; margin-bottom: 3%;">
		</a></td>
	</tr>
</c:forEach>
