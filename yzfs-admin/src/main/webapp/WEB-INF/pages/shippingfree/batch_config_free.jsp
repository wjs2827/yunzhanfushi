<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${readList}" var="config">
	<tr class="">
		<td>${config.configName}</td>
		<td>${config.configCode}</td>
		<td>${config.configCode}</td>
		<td><c:if test="${config.status==true}">
				<a data-toggle="modal" href="#rechargeStaticDel"
					onclick="delConfigRecharge('${config.id}','0');"> <img
					title="已开启" src="${contextPath}/static/image/icon/open.png"
					style="width: 30px; margin-left: 5%;">
				</a>
			</c:if> <c:if test="${config.status==false}">
				<a data-toggle="modal" href="#rechargeStaticDel"
					onclick="delConfigRecharge('${config.id}','1');"> <img
					title="已关闭" src="${contextPath}/static/image/icon/dis_open.png"
					style="width: 30px; margin-left: 5%;">
				</a>
			</c:if></td>
	</tr>
</c:forEach>