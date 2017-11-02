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
<title>北京燕园</title>
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
                    
                    <div class="header">
                      <div class="return"><img src="${contextPath}/static/images/return.png" width="100%"></div>
                      <div class="title">用户绑定</div>
                   </div>
                    <div class="register">
                        <p>
                            <span><img src="${contextPath}/static/images/a7.png" width="100%">注册码</span>
                            <input type="text" placeholder="请输入注册码">
                        </p>
                        <button id="submit">确认</button>
                    </div>
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
          
          $("#submit").click(function(){
        	  var no=$(".register input").val();
        	  if(no!=''){
        		  $.ajax({
  	            	url:'${contextPath}/wx/core/register',
  	            	data:{"no" : no},
  	            	type:"post",
  	            	success:function(result){
  	            		if (result.code==0) {
  	            			window.location.href="${contextPath}/wx/user/firstBasic";
  	    				}else{
  	    					alert(result.msg);
  	    				}
  	            	},
  	            	error:function(){
  	            		alert("系统异常，请重试");
  	            	}
  	            });
        	  }
          });
          
    });
  
</script>
</body>
</html>