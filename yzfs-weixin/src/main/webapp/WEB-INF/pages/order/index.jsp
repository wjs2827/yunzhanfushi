<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    String qiniuPath = QiniuConfig.getValue("IMG_PATH");
%>
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
<title>积分换购</title>
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
                <div class="scroller" style="top: 1.2rem;">
                    <!-- 头部 -->
                  <div class='ongoingall clearfix'>
                      
                       <div class='ongoing-right'>
                           <div class='ongoing-rightall'>
                              <div class='ongoing-goods1'>
                                <c:forEach items="${goodList}" var="good">
	                                 <div class='goods1'>
	                                    <img src='<%=qiniuPath %>/${good.picKey }' class='goodsimg'/>
	                                    <div class='goodsright'>
	                                      <div class='goodstit moreOverflowTwo'>${good.name }</div>
	                                      <div class='goodsprice'>
	                                         <div class='price'><em class='per-price'>${good.salePoints }</em> 积分</div>
	                                         <div  class='radio' value="${good.id}"></div>
	                                      </div>
	                                    </div>
	                                 </div>
                                </c:forEach>
                              </div>
                           </div>
                       </div>
                     </div>
                <div class="highbg"></div>
               </div>
               <div class="header position">
                    <h2 class="title">换购区</h2>
               </div>
                <div class='ongoing-left positionleft'>
                          <div class='ongoing-leftall'>
                            <c:forEach items="${classList }" var="cla">
                              <div class='ongoingtab' value="${cla.id}">${cla.name}</div>
                            </c:forEach>
                          </div>
                       </div>
          
               <div class='ongoing-footer'>
                  <div class='footer-left'>
                      <p><span>共计：</span><em><span class='total-price'>0</span>积分</em></p>
                      <p>可用：${points.cardPoints}积分</p>
                  </div>
                  <div class='footer-right toCart'><img src='${contextPath}/static/images/cart.png' class='totalcart'  width="100%"/>(<span class='number'>0</span>件)</div>
               </div>
               
                <form name="firstBasicForm" onsubmit="return false;">
                   <input type="hidden" value="" name="goodIds">
                </form>
                
             </div>
          </section>
       </div>
    </div>
</div>

<script src="${contextPath}/static/js/swiper.animate.min.js"></script>
<script src="${contextPath}/static/js/iscroll.js"></script>
<script src="${contextPath}/static/js/main.js"></script>
<script src="${contextPath}/static/js/index.js"></script>

<!-- 配置滚动条 -->
<script type="text/javascript">
        $(function(){
          setTimeout(function(){
            loadedScroll("#wrapperIndex",false,true);  
          },500);
          $(".ongoing-leftall div").eq(0).addClass("tabhover");
    });
        
     
        
  
</script>
</body>
</html>