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
<c:forEach items="${commentVos}" var="vo" begin="0" varStatus="status">
	<tr class="">

		<td>${vo.goodsName}</td>

		<td>${vo.userNickName}</td>

		<td style="width: 250px"><div
				style="width: 250px; margin-right: 0">${vo.content}</div></td>
		<td><c:if test="${vo.grade==1}">
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
			</c:if> <c:if test="${vo.grade==2}">
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
			</c:if> <c:if test="${vo.grade==3}">
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
			</c:if> <c:if test="${vo.grade==4}">
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commKong.png" width="15px;" />
			</c:if> <c:if test="${vo.grade==5}">
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
				<img src="${basePath}/static/image/commZhong.png" width="15px;" />
			</c:if></td>
		<td class="center"><fmt:formatDate value="${vo.createdAt}"
				pattern="yyyy/MM/dd HH:mm" /></td>
		<td>${vo.orderNo}</td>
		<td><c:if test='${vo.status == 1}'>
				<span style="color: #30b030;">启用</span>
			</c:if> <c:if test='${vo.status != 1}'>
				<span style="color: #ff0000;">停用</span>
			</c:if></td>
		<td><c:if test='${vo.status == 1}'>
				<a href="#confirmDown" onclick="confirmUpOrDown('${vo.id}','0')"><img
					src="${basePath}/static/image/error.png" style="width: 17px;" /></a>
			</c:if> <c:if test='${vo.status != 1}'>
				<a href="#confirmDown" onclick="confirmUpOrDown('${vo.id}','1')"><img
					src="${basePath}/static/image/bingo.png" style="width: 17px;" /></a>
			</c:if></td>
	</tr>
</c:forEach>
