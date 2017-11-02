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
			<th>累计可用奖金：<span style="color: #ab0d0d;">${allSumRechargeAmount}</span></th>
			<th>累计奖金：<span style="color: #ab0d0d;">￥${allSumAttachAmount}</span></th>
			<th>累计已提现奖金：<span style="color: #ab0d0d;">￥${allSumAccountAmount}</span></th>
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
			<th>可用奖金</th>
			<th>累计奖金</th>
			<th>已提现奖金</th>
		</tr>
	</thead>
	<tbody class="tbodyClassOne">
		<c:forEach items="${list}" var="commissStatis">
			<tr class="">
				<td><img src="${commissStatis.headImg}"
					style="width: 60px; height: 60px" /></td>
				<td>${commissStatis.nickName}</td>
				<td>${commissStatis.mobile}</td>
				<td>￥${commissStatis.sumCommissionAccountAmount}</td>
				<td>￥${commissStatis.sumCommissonAmount}</td>
				<td>￥${commissStatis.sumWithdrawAmount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>