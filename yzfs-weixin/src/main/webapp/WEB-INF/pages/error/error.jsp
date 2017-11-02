<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="keywords" content="ppt手机站" />
<meta name="description" content="ppt手机站" />
<title>出错了</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<script src="${contextPath}/static/js/flexible.js"></script>
<link rel="stylesheet" href="${contextPath}/static/css/swiper.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/style.css"/>
<script src="${contextPath}/static/js/jquery.js"></script>
<script src="${contextPath}/static/js/swiper.min.js"></script>

</head>
<body>
<div>
    <div>
        <img src="${contextPath}/static/image/error.png" style=""/>
        <span>出错了</span>
        <span><a href="javascript:window.location.reload();">点击刷新</a></span>
    </div>
</div>
<script src="${contextPath}/static/js/swiper.animate.min.js"></script>
<script src="${contextPath}/static/js/iscroll.js"></script>
<script src="${contextPath}/static/js/main.js"></script>
</body>
</html>