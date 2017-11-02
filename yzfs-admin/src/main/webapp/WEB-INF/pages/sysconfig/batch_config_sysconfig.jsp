<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${readList}" var="config">
	<tr class="">
		<td>${config.configCode}</td>
		<td>${config.configName}</td>
		<td><input class="${config.id}" id="${config.id}" type="text"
			value="${config.configValue}" /></td>
		<td><a class="" data-toggle="modal" href="#sysConfigStatic"
			onclick="editSysConfig('${config.id}','${config.configName}','${config.configValue}')">
				<img title="编辑保存" src="${contextPath}/static/image/icon/save.png"
				style="width: 30px; margin-left: 5%;">
		</a></td>
	</tr>
</c:forEach>