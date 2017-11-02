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
<c:forEach items="${list}" var="commiss">
	<tr class="">
		<td>${commiss.nickName}</td>
		<td>${commiss.mobile}</td>
		<td>${commiss.changeAmount}</td>
		<td>${commiss.changeNote}</td>
		<td><fmt:formatDate value="${commiss.updatedAt}"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</c:forEach>
