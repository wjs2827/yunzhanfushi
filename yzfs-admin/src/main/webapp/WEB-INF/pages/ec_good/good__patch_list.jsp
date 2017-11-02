<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach items="${goods}" var="good" begin="0" varStatus="status">

	<tr class="">
		<%--  <td><img class="checkedClass" alt="" src="${contextPath}/static/image/kong.png" id="${good.id}" style="width:30px;" onclick="userChecd('${good.id}');"/></td> --%>
		<td>${good.spuCode}</td>
		<td style="width: 200px">${good.name}</td>
		<td>${good.parentName}>${good.classesName}</td>
		<td>${good.stockCount}</td>
		<td>${good.saleCount}</td>
		<td><c:if test='${good.isSale==false}'>
				<span style="color: red;">下架</span>
			</c:if> <c:if test='${good.isSale==true}'>
				<span style="color: green;">上架</span>
			</c:if></td>
		<td>${good.rank}</td>
		<td class="operatorImgClass">
			<%--            <a class="" data-toggle="modal"  href="#copy" onclick="copyGood('${good.id}','${good.name}');">
                <img title="复制商品    " src="${contextPath}/static/image/icon/copy.png" >
           </a> --%> <%--            <a href="${contextPath}/admin/good/detail?id=${good.id}" class="">
                  <img title="商品详情" src="${contextPath}/static/image/icon/items.png" >
           </a>  --%> <c:if test='${good.isSale==true}'>
				<a class=""> <img title="编辑"
					src="${contextPath}/static/image/icon/disable_edit.png">
				</a>
				<a class=""> <img title="上架"
					src="${contextPath}/static/image/icon/dis_s_sale.png">
				</a>
				<a data-toggle="modal" href="#static1"
					onclick="updateIsSale('${good.id}','0');" class=""> <img
					title="下架" src="${contextPath}/static/image/icon/x_sale.png">
				</a>
				<a class=""> <img title="删除"
					src="${contextPath}/static/image/icon/dis_delete.png">
				</a>

			</c:if> <c:if test='${good.isSale==false}'>
				<a class="" href="${contextPath}/admin/good/edit?id=${good.id}">
					<img title="编辑" src="${contextPath}/static/image/icon/edit.png">
				</a>
				<a data-toggle="modal" href="#static1"
					onclick="updateIsSale('${good.id}','1');" class=""> <img
					title="上架" src="${contextPath}/static/image/icon/s_sale.png">
				</a>
				<a class=""> <img title="下架"
					src="${contextPath}/static/image/icon/dis_x_sale.png">
				</a>
				<a class="" data-toggle="modal" href="#static1"
					onclick="updateIsDel('${good.id}');"> <img title="删除"
					src="${contextPath}/static/image/icon/delete.png">
				</a>
			</c:if>
		</td>
	</tr>
</c:forEach>
