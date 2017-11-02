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
<!-- 选择信息 -->
<div class="controls" style='margin-left: .8rem;'>
	<h3 class="Father_Title">领口类型</h3>
	<br />
	<ul class="Father_Item Father_Item0">
		<!--   <li><label><input id="Checkbox0" type="checkbox" class="checkbox check_all" value="全选">&nbsp;全选</label></li> -->
		<c:forEach var="first" items="${neckLineListFirst}">
			<li><label> <input id="Checkbox0" type="checkbox"
					class="checkbox check_item" name="${first.id}" value="${first.id}">&nbsp;${first.neckName}
					<input id="${first.id}" type="hidden" value="${first.neckName}" />
					<input id="${first.id}key" type="hidden" value="${first.picKey}" />
			</label></li>
		</c:forEach>
	</ul>
	<br>
	<h3 class="Father_Title">布料类型</h3>
	<br />
	<ul class="Father_Item Father_Item1">
		<!--  <li><label><input id="Checkbox0" type="checkbox" class="checkbox check_all" value="全选">&nbsp;全选</label></li> -->
		<c:forEach var="second" items="${neckLineListSecond}">
			<li><label> <input id="Checkbox1" type="checkbox"
					class="checkbox check_item" name="${second.id}"
					value="${second.id}">&nbsp;${second.fabricName} <input
					id="${second.id}" type="hidden" value="${second.fabricName}" /> <input
					id="${second.id}key" type="hidden" value="${second.picKey}" />
			</label></li>
		</c:forEach>
	</ul>
	<br>
</div>

