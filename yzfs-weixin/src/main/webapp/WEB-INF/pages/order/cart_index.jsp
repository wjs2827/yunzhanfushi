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
                <div class="scroller" style="top: 1.5rem;">
                    <!-- 头部 -->
                    
                    <ul class="card-list hewenqi" id="hewenqi">
                    
                      <c:forEach items="${goodList}" var="good">
                      
	                      <li class="list-li" style="transform: translateX(0px);">
	                        <div class="card-list1">
	                           <div class="list-con">
	                            <img src="<%=qiniuPath %>/${good.picKey }" class="card-goods1">
	                            <div class="list-right">
	                              <p class="list-tit moreOverflowTwo">${good.name }</p>
	                              <div class="list-priceall clearfix">
	                                <div class="list-price">￥<span class="price-num" style="font-size: 0.4rem;">${good.salePoints }</span></div>
	                                <div class="list-btn">
	                                  <img src="${contextPath}/static/images/sub.png" class="sub">
	                                  <div class="list-num">1</div>
	                                  <img src="${contextPath}/static/images/add.png" class="add">  
	                                  <input type="hidden" class="j-input-left" value="8"><!-- 库存数量 -->         
	                                </div>
	                              </div>
	                              <div class="quota"><span>库存：${good.stockCount }</span></div>  
	                              <div class="delete"><img src="${contextPath}/static/images/delete.png"></div>   
	                            </div>
	                           </div>
	                        </div>
	                      </li> 
                        </c:forEach>
                    </ul>
                   
                 <div class="no-goods"><img src="${contextPath}/static/images/kong.png"></div>
                 <div class="highbg"></div>
               </div>
                <div class="header position">
                    <a href="#"><img src="${contextPath}/static/images/goback.png" class="goback"><span class="go-on">继续挑选</span></a>
                    <h2 class="title">购物车</h2>
               </div>
                <div class='ongoing-footer'>
                  <div class='footer-left'>
                      <p><span>共计：</span><em><span class='total-price'>0</span>积分</em></p>
                      <p>可用：${points.cardPoints }积分</p>
                  </div>
                  <div class='footer-right payPoint'>积分支付</div>
               </div>
               <div class="deletebox">
                     <div class="deleteboxcon Vcenter">
                          <p>确认要删除宝贝吗？</p>
                          <div class="btn"><a href="#" class="cancel">取消</a><a href="#" class="confirm">确认</a></div>
                     </div>
                </div>
                <div class="address">
                     <div class="addresscon Vcenter">
                        <h2>收货人信息</h2>
                         <form>
                               <label>
                                    <input type="text" class="text" placeholder="姓名">
                               </label>
                               <label>
                                    <input type="text" class="text" placeholder="手机号">
                               </label>
                               <label>
                                    <select class="text">
                                          <option value="上海">上海</option>
                                    </select>
                               </label>
                               <label>
                                    <select class="text">
                                          <option value="上海">上海</option>
                                    </select>
                               </label>
                               <label>
                                 <select class="text">
                                            <option value="上海">上海</option>
                                  </select>
                              </label>
                              <label>
                                   <textarea placeholder="请输入详细地址" class="area"></textarea>
                              </label>
                              <label>
                                    <button class="cancelbtn">取消</button>
                                    <button class="confirmbtn">确定</button>
                              </label>
                         </form>
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
<script src="${contextPath}/static/js/cart.js"></script>


<!-- 配置滚动条 -->
<script type="text/javascript">
      $(function(){
        setTimeout(function(){
          loadedScroll("#wrapperIndex",false,true);  
        },500);
        if($(".list-li").length==0){
            $(".no-goods").show();
            }

    });


</script>
</body>
</html>