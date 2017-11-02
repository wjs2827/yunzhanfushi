<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:choose>
	<c:when test="${not isSubClass }">
		<c:forEach items="${classVo}" var="c" begin="0" varStatus="status">
			<tr class="parentClass" role="row" id="${c.id}">
				<td style="display: none">${c.id}</td>
				<td><i class="icon-plus black black-icon"
					onclick="detailSubClassic('${c.id}')"></i>${c.name}</td>
				<td><img src='<%=qiniuPath %>${c.picKey}'
					style="width: 30px; margin-left: 5%;"></td>
				<td><a class="" data-toggle="modal" href="#cateOne"
					onclick="editCateOne('${c.id}','${c.name}',${c.picKey})"> <img
						title="编辑" src="${contextPath}/static/image/icon/edit.png"
						style="width: 30px; margin-left: 5%;">
				</a> <a class="" data-toggle="modal" href="#static"
					onclick="delCateOne('${c.id}','${c.parentId}')"> <img
						title="删除" src="${contextPath}/static/image/icon/delete.png"
						style="width: 30px; margin-left: 5%;">
				</a> <a class="" data-toggle="modal" href="#cateTwo"
					onclick="editCateTwo('','${c.id}','','')"> <img title="添加子分类"
						src="${contextPath}/static/image/icon/add.png"
						style="width: 30px; margin-left: 5%;">
				</a></td>
			</tr>
			<tr class="fenlei-tr details empty">
				<td class="empty"></td>
				<td class="empty"></td>
				<td colspan="5" class="span-td"></td>
			</tr>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<c:forEach items="${classVo}" var="c" begin="0" varStatus="status">
			<ul id="${c.id }" class="add-fenlei-ul">
				<li>${c.name }</li>
				<li><img src='<%=qiniuPath %>${c.picKey}' style="width: 50px" /></li>
				<li><a data-toggle="modal" href="#cateTwo"
					onclick="editCateTwo('${c.id}','${c.parentId}','${c.name}','${c.picKey}')">
						<img title="编辑" src="${contextPath}/static/image/icon/edit.png"
						style="width: 30px; margin-left: 5%;">
				</a></li>
				<li><a data-toggle="modal" href="#static"
					onclick="delCateOne('${c.parentId}','${c.id}')"> <img
						title="删除" src="${contextPath}/static/image/icon/delete.png"
						style="width: 30px; margin-left: 5%;">
				</a></li>
			</ul>
		</c:forEach>
	</c:otherwise>
</c:choose>
