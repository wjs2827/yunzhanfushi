<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:forEach items="${codeList}" var="code" begin="0" varStatus="status">

	<tr class="">

		<td>${code.registerNo }</td>
		<td>${code.batchNum}</td>
		<td><c:if test="${code.isBound}">
                                   已绑定
            </c:if> <c:if test="${!code.isBound}">
                                   未绑定
            </c:if></td>

		<td><fmt:formatDate value='${code.createdAt }'
				pattern="yyyy-MM-dd" />
		<td><a href="#static" data-toggle="modal"
			class="btn blue delete Delete_btn  btn_admin_delete">删除</a></td>
	</tr>
</c:forEach>