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
<c:forEach items="${list}" var="points">
	<tr class="">

		<td>${points.nickName}</td>
		<td>${points.mobile}</td>
		<td><c:if test="${points.recordType==0}">
				<span style='color: #ff5208;'>-</span>
			</c:if> <c:if test="${points.recordType==1}">
				<span style='color: #24cd24;'>+</span>
			</c:if> ${points.changePoints}</td>
		<td>${points.changeNote}</td>
		<td><fmt:formatDate value="${points.updatedAt}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>
