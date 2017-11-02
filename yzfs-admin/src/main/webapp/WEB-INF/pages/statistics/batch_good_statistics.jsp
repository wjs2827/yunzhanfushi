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
			<th>销售数量总计：<span style="color: #ab0d0d;">${allSumSellCount}</span></th>
			<th>销售金额总计：<span style="color: #ab0d0d;">￥${allSumSellAmount}</span></th>
			<th>T金抵扣金额总计：<span style="color: #ab0d0d;">￥${allSumSellPoints}</span></th>
			<th>退货数量总计：<span style="color: #ab0d0d;">${allSumBackCount}</span></th>
			<th>退货金额总计：<span style="color: #ab0d0d;">￥${allSumBackAmount}</span></th>
		</tr>

	</thead>
</table>
<table class="table table-striped table-hover table-bordered"
	id="sample_editable_1">
	<thead>
		<tr>
			<th>商品分类</th>
			<th>商品名称</th>
			<th>规格图片</th>
			<th>商品规格</th>
			<th>销售数量</th>
			<th>销售金额</th>
			<th>T金抵扣金额</th>
			<th>退货数量</th>
			<th>退货金额</th>
		</tr>
	</thead>
	<tbody class="tbodyClassOne">
		<c:forEach items="${list}" var="goodStatis">
			<tr class="">
				<td>${goodStatis.firstName}>${goodStatis.secondName}</td>
				<td>${goodStatis.goodName}</td>
				<td><img alt="${orderItem.goodName}"
					src="<%=qiniuPath%>${goodStatis.picKey}"
					style="width: 60px; height: 60px" /></td>
				<td>${goodStatis.skuName}</td>
				<td>${goodStatis.saleCount}</td>
				<td>￥${goodStatis.saleAmount}</td>
				<td>￥${goodStatis.deductibleAmount}</td>
				<td>${goodStatis.refundCount}</td>
				<td>￥${goodStatis.refundAmount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>