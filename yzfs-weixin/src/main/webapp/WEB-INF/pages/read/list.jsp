<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
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
                  <div class="header ">
                    <div class="return"><img src="${contextPath}/static/images/goback.png" width="100%"></div>
                    <h2 class="title">阅读有赏</h2>
                  </div>
                   <div class="rule">
                       <p>奖励规则：<br/>阅读一篇文章  <span>+${YDYS_001}积分</span>;下级伙伴阅读一篇文章  <span>+${YDYS_002}积分</span>;<br/>每日最多获得 <span>${YDYS_003}积分</span></p>
                   </div>
                   <div class="article">
                        <ul>
                        <c:forEach items="${readList}" var="read">
                         <li class="clearfix">
                              <div class="left"><img src="${contextPath}/static/images/a2.png" width="100%"></div>
                              <div class="center">
                                   <h2 class="moreOverflowTwo">${read.title }</h2>
                                   <p><f:formatDate value="${read.createdAt }" pattern="yyyy-MM-dd"/></p>
                              </div>
                              <c:if test="${read.isRead>0 }">
                              <div class="right"><a href="#" class="active">已领,明天再来</a></div>
                              </c:if>
                              <c:if test="${read.isRead==0 }">
                              <div class="right"><a>点击阅读</a></div>
                              </c:if>
                              <input type="hidden" value="${read.id}" name="id">
                              <input type="hidden" value="${read.link}" name="link">
                          </li>
                          </c:forEach>
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
  
        $(".right").click(function(){
        	var that=$(this);
        	console.log(that.siblings("input[name='id']").val());
        	 $.ajax({
	            	url:'${contextPath}/wx/read/toRead',
	            	data:{"id" : that.siblings("input[name='id']").val()},
	            	type:"post",
	            	success:function(result){
	            		if (result.code==0) {
	            			window.location.href=that.siblings("input[name='link']").val();
	    				}else{
	    					alert(result.msg);
	    				}
	            	},
	            	error:function(){
	            		alert("系统异常，请重试");
	            	}
	            });
        });
</script>
</body>
</html>