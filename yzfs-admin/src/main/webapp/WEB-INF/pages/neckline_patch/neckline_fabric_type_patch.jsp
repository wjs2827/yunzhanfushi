<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach var="neckLine" items="${neckLineList}">
	<tr>
		<td>${neckLine.fabricName}</td>
		<td><img src="<%=qiniuPath %>${neckLine.picKey}"
			style="width: 50px" /></td>
		<td><a class="" data-toggle="modal" href="#neckline_fabric_type"
			onclick="editNecklineFabricType('${neckLine.id}','${neckLine.fabricName}',
					'${neckLine.picKey}')">
				<img title="编辑" src="${contextPath}/static/image/icon/edit.png"
				style="width: 30px; margin-left: 5%;">
		</a> <a class="" data-toggle="modal" href="#static1"
			onclick="deleteNeckFabricType('${neckLine.id}')"> <img title="删除"
				src="${contextPath}/static/image/icon/delete.png"
				style="width: 30px; margin-left: 5%;">
		</a></td>
	</tr>
</c:forEach>

