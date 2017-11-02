 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    String qiniuPath = QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach items="${goodList}" var="good">
	<div class='goods1'>
		<img src='<%=qiniuPath %>/${good.picKey }' class='goodsimg' />
		<div class='goodsright'>
			<div class='goodstit moreOverflowTwo'>${good.name }</div>
			<div class='goodsprice'>
				<div class='price'>
					<em class='per-price'>${good.salePoints }</em> 积分
				</div>
				<div class='radio' value="${good.id}"></div>
			</div>
		</div>
	</div>
</c:forEach>