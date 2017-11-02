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
<title>换购纪录</title>
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
            <div class="wrapper" id="wrapper" style="bottom: 0">
                <div class="scroller"  id="scroller" >
                    <!-- 头部 -->
                   <div id="pullDown">
                    <span class="pullDownIcon"></span><span class="pullDownLabel">下拉刷新...</span>
                  </div>
                  <div class="orderlist">
                       <ul  id="orderlistboth">
                         <li>
                             <h1>2016/8/15 12:50:00 <span>未发货</span></h1>
                             <div class="ordergoods">
                                   <ul>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                             <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                             <p>红色  ML<span>x1</span></p>
                                             <h3>450积分</h3>
                                         </div>
                                     </li>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                            <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                            <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                   </ul>
                                   <div class="unpaidmes">
                                        <p>共2件 合计：900积分</p>
                                   </div>
                                   <div class="address">
                                       <h2>孙小美<span>13636709355</span></h2>
                                       <p>上海上海市宝山区长江南路1888号</p>
                                   </div>
                              </div>
                         </li>
                         <li>
                             <h1>2016/8/15 12:50:00 <span>已发货</span></h1>
                             <div class="ordergoods">
                                   <ul>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                             <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                             <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                            <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                            <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                   </ul>
                                   <div class="unpaidmes">
                                        <p>共2件 合计：900积分</p>
                                   </div>
                                   <div class="address">
                                       <h2>孙小美<span>13636709355</span></h2>
                                       <p>上海上海市宝山区长江南路1888号</p>
                                   </div>
                                   <div class="unpaidmes" style="border-top: 1px solid #d8d8d8; margin-top: 0;padding: 0.2rem 0">
                                        <p><a href="#">运单信息</a></p>
                                   </div>
                              </div>
                         </li>
                         
                       </ul>
                  </div> 
                  <div class="orderlist" style="display: none;">
                       <ul id="orderlistPayment">
                         <li>
                             <h1>2016/8/15 12:50:00 <span>已发货</span></h1>
                             <div class="ordergoods">
                                   <ul>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                             <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                             <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                            <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                            <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                   </ul>
                                   <div class="unpaidmes">
                                        <p>共2件 合计：900积分</p>
                                   </div>
                                   <div class="address">
                                       <h2>孙小美<span>13636709355</span></h2>
                                       <p>上海上海市宝山区长江南路1888号</p>
                                   </div>
                                   <div class="unpaidmes" style="border-top: 1px solid #d8d8d8; margin-top: 0;padding: 0.2rem 0">
                                        <p><a href="#">运单信息</a></p>
                                   </div>
                              </div>
                         </li>
                       </ul>
                  </div> 
                  <div class="orderlist" style="display: none;">
                       <ul id="orderlistdelivery">
                         <li>
                             <h1>2016/8/15 12:50:00 <span>未发货</span></h1>
                             <div class="ordergoods">
                                   <ul>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                             <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                             <p>红色  ML<span>x1</span></p>
                                             <h3>450积分</h3>
                                         </div>
                                     </li>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                            <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                            <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                   </ul>
                                   <div class="unpaidmes">
                                        <p>共2件 合计：900积分</p>
                                   </div>
                                   <div class="address">
                                       <h2>孙小美<span>13636709355</span></h2>
                                       <p>上海上海市宝山区长江南路1888号</p>
                                   </div>
                              </div>
                         </li>
                         <li>
                             <h1>2016/8/15 12:50:00 <span>已发货</span></h1>
                             <div class="ordergoods">
                                   <ul>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                             <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                             <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                     <li class="clearfix">
                                         <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div>
                                         <div class="right">
                                            <h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2>
                                            <p>红色  ML<span>x1</span></p>
                                             <h3><small>￥</small>800</h3>
                                         </div>
                                     </li>
                                   </ul>
                                   <div class="unpaidmes">
                                        <p>共2件 合计：900积分</p>
                                   </div>
                                   <div class="address">
                                       <h2>孙小美<span>13636709355</span></h2>
                                       <p>上海上海市宝山区长江南路1888号</p>
                                   </div>
                                   <div class="unpaidmes" style="border-top: 1px solid #d8d8d8; margin-top: 0;padding: 0.2rem 0">
                                        <p><a href="#">运单信息</a></p>
                                   </div>
                              </div>
                         </li>
                       </ul>
                  </div> 
                  <div id="pullUp">
                    <span class="pullUpIcon"></span><span class="pullUpLabel">上拉加载更多...</span>
                  </div>
                </div>
                
             </div>
            
                <div class="ordertitle" id="0">
                     <ul>
                         <li class="check">全部</li>
                         <li>已发货</li>
                         <li>未发货</li>
                       </ul>
                </div>
                <div class="deletebox cancel-order-con delete-order-con">
                     <div class="deleteboxcon Vcenter">
                          <p>确认要取消该订单吗？</p>
                          <div class="btn"><a href="#" class="cancel">取消</a><a href="#" class="confirm">确认</a></div>
                     </div>
                </div>
          </section>
       </div>
    </div>
</div>

<script src="${contextPath}/static/js/swiper.animate.min.js"></script>
<script src="${contextPath}/static/js/iscroll2.js"></script>
<script src="${contextPath}/static/js/fresh.js"></script>
<script src="${contextPath}/static/js/orderlist.js"></script>

<!-- 配置滚动条 -->
<script type="text/javascript">

        var myScroll;
            $(".ordertitle li").click(function(){
            $(".ordertitle li").eq($(this).index()).addClass("check").siblings().removeClass('check');
             $(".orderlist").hide().eq($(this).index()).show();
             var id = $(this).index();
             $('.ordertitle').attr('id', id);
             myScroll.refresh(); 
            });
        

</script>
</body>
</html>