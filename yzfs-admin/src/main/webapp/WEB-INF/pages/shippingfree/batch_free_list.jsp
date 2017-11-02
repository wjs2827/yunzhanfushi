<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach items="${paramsList}" var="free" varStatus="status">
	<c:if test="${status.index==0}">
		<tr class="freeTR0">
			<td><img
				<c:if test="${free.isDeleted}">src="/yzfs-admin/static/image/zhong.png"</c:if>
				<c:if test="${free.isDeleted==false}">src="/yzfs-admin/static/image/kong.png"</c:if>
				id="checkAllImgID" style="width: 25px; height: 25px;"
				onclick="checkAllImg();"> 所有地区</td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="firstWeight0" name="firstWeight0" value="${free.firstNum}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="firstPrice0" name="firstPrice0" value="${free.firstPrice}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="secondWeight0" name="secondWeight0" value="${free.nextNum}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="secondPrice0" name="secondPrice0" value="${free.nextPrice}" /></td>
		</tr>
	</c:if>
	<c:if test="${status.index!=0}">
		<tr class="freeTR${status.index}">
			<td>选择可配送区域 <a data-toggle="modal" href="#freeDialog"> <img
					src="/yzfs-admin/static/image/icon/fedit.png"
					style="width: 20px; height: 20px;"
					onclick="editFree('${status.index}')"></a> <img class="delImage"
				src="/yzfs-admin/static/image/icon/fdel.png"
				style="width: 20px; height: 20px;"
				onclick="delFree('${status.index}')"><br> <span
				style="color: rgb(47, 168, 13);" class="errorTitle${status.index}">${free.areaNameList}</span>
				<input type="hidden" id="dataSelectedCID${status.index}"
				name="dataSelectedCID${status.index}" value="${free.areaIdList}">
				<input type="hidden" id="dataSelectedName${status.index}"
				name="dataSelectedName${status.index}" value="${free.areaNameList}"></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="firstWeight${status.index}" name="firstWeight${status.index}"
				value="${free.firstNum}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="firstPrice${status.index}" name="firstPrice${status.index}"
				value="${free.firstPrice}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="secondWeight${status.index}" name="secondWeight${status.index}"
				value="${free.nextNum}" /></td>
			<td><input type="text"
				<c:if test="${free.isDeleted==false}">disabled</c:if>
				id="secondPrice${status.index}" name="secondPrice${status.index}"
				value="${free.nextPrice}" /></td>
		</tr>
	</c:if>
</c:forEach>

