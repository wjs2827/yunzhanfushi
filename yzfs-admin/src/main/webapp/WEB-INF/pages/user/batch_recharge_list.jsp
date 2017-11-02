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
<c:forEach items="${list}" var="recharge">
	<tr class="">
		<td>${recharge.nickName}</td>
		<td>${recharge.mobile}</td>
		<td>${recharge.changeAmount}</td>
		<td>${recharge.attachAmount}</td>
		<td>${recharge.changeAmount+recharge.attachAmount}</td>
		<td>${recharge.payNo}</td>
		<td><fmt:formatDate value="${recharge.updatedAt}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>
