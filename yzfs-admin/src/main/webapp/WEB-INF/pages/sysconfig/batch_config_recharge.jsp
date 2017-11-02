<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${rechargeList}" var="config">
	<tr class="">
		<td>${config.rechargeAmount}</td>
		<td>${config.remark}</td>
		<td>${config.attachAmount}</td>
		<td><a class="" data-toggle="modal" href="#rechargeStatic"
			onclick="editSysRecharge('${config.id}','${config.rechargeAmount}','${config.attachAmount}','${config.remark}')">
				<img title="编辑" src="${contextPath}/static/image/icon/edit.png"
				style="width: 30px; margin-left: 5%;">
		</a> <c:if test="${config.isUsed==true}">
				<a data-toggle="modal" href="#rechargeStaticDel"
					onclick="delConfigRecharge('${config.id}','0');"> <img
					title="已开启" src="${contextPath}/static/image/icon/open.png"
					style="width: 30px; margin-left: 5%;">
				</a>
				<img title="删除"
					src="${contextPath}/static/image/icon/dis_delete.png"
					style="width: 30px; margin-left: 5%;">
			</c:if> <c:if test="${config.isUsed==false}">
				<a data-toggle="modal" href="#rechargeStaticDel"
					onclick="delConfigRecharge('${config.id}','1');"> <img
					title="已关闭" src="${contextPath}/static/image/icon/dis_open.png"
					style="width: 30px; margin-left: 5%;">
				</a>
				<a class="" data-toggle="modal" href="#rechargeStaticDel"
					onclick="delConfigRecharge('${config.id}','del')"> <img
					title="删除" src="${contextPath}/static/image/icon/delete.png"
					style="width: 30px; margin-left: 5%;">
				</a>
			</c:if></td>
	</tr>
</c:forEach>