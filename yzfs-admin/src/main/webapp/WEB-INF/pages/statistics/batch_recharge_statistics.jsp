<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<table class="table table-striped table-hover table-bordered"
	style="background-color: #819e7d;">
	<thead>
		<tr>
			<th>累计充值金额：<span style="color: #ab0d0d;">${allSumRechargeAmount}</span></th>
			<th>累计赠送金额：<span style="color: #ab0d0d;">￥${allSumAttachAmount}</span></th>
			<th>账户累计金额：<span style="color: #ab0d0d;">￥${allSumRechargeAmount+allSumAttachAmount}</span></th>
		</tr>

	</thead>
</table>
<table class="table table-striped table-hover table-bordered"
	id="sample_editable_1">
	<thead>
		<tr>
			<th>用户头像</th>
			<th>用户昵称</th>
			<th>用户手机</th>
			<th>累计充值金额</th>
			<th>累计赠送金额</th>
			<th>累计账户余额</th>
		</tr>
	</thead>
	<tbody class="tbodyClassOne">
		<c:forEach items="${list}" var="rechargeStatis">
			<tr class="">
				<td><img src="${rechargeStatis.headImg}"
					style="width: 60px; height: 60px" /></td>
				<td>${rechargeStatis.nickName}</td>
				<td>${rechargeStatis.mobile}</td>
				<td>￥${rechargeStatis.sumRechargeAmount}</td>
				<td>￥${rechargeStatis.sumAttachAmount}</td>
				<td>￥${rechargeStatis.sumRechargeAmount+rechargeStatis.sumAttachAmount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>