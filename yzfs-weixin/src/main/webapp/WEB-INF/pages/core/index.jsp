<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>微友之家</title>
<script src="${contextPath}/static/js/flexible.js"></script>
<script src="${contextPath}/static/js/jquery.js"></script>
<script src="${contextPath}/static/js/swiper.min.js"></script>
<link rel="stylesheet" href="${contextPath}/static/css/swiper.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/static/css/style.css"/>
</head>
<body>
<div class="iphone4 swiper-container" id="indexSwiper">
    <div class="swiper-wrapper">
       <div class="swiper-slide">
          <section class="sectionBox">
            <div class="wrapper" id="wrapperIndex">
                <div class="scroller">
                    <!-- 头部 -->
                 <div class="personaluser mt">
                         <img src="${user.headImg==null?'${contextPath}/static/images/a8.png':user.headImg }" width="100%" class="userphoto" >
                         <p><span>${user.nickName }</span><em><img src="${contextPath}/static/images/a1.png" width="100%">积分：50</em></p>
                         <em class="sign">积分换礼</em>
                      
                 </div>
                <div class="mylist mt">
                    <ul>
                      <li><a href="${contextPath}/wx/read/list"><span><img src="${contextPath}/static/images/p1.png" width="100%"></span>阅读有赏
                      <em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                      <li><a href="积分抽奖.html"><span><img src="${contextPath}/static/images/p2.png" width="100%"></span>积分抽奖
                      <em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                      <li><a href="${contextPath}/wx/order/list"><span><img src="${contextPath}/static/images/p3.png" width="100%"></span>换购记录
                      <em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em><i>1</i></a></li>
                      <li><a href="我邀请的伙伴.html"><span><img src="${contextPath}/static/images/p4.png" width="100%"></span>我邀请的伙伴
                      <em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                      <li><a href="中奖记录.html"><span><img src="${contextPath}/static/images/p5.png" width="100%"></span>中奖记录
                      <em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                    </ul>
                </div>
                <div class="mylist">
                    <ul>
                      <li><a href="${contextPath}/wx/core/share"><span><img src="${contextPath}/static/images/p6.png" width="100%"></span>分享与推广<em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                      <li><a href="${contextPath}/wx/core/intro"><span><img src="${contextPath}/static/images/p7.png" width="100%"></span>帮助说明<em><img src="${contextPath}/static/images/rightarrow.png" width="100%"></em></a></li>
                    </ul>
                </div>
               </div>
             </div>
          </section>
       </div>
    </div>
</div>

<script src="${contextPath}/static/js/swiper.animate.min.js"></script>
<script src="${contextPath}/static/js/iscroll.js"></script>
<script src="${contextPath}/static/js/main.js"></script>


<!-- 配置滚动条 -->
<script type="text/javascript">
        $(function(){
          setTimeout(function(){
            loadedScroll("#wrapperIndex",false,true);  
          },500);
    });
        $(".sign").click(function(){
        	window.location.href="${contextPath}/wx/order/index";
        });
</script>
</body>
</html>