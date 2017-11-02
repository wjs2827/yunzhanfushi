<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach items="${ordersList}" var="order">
	<tr class="">
		<td>${order.orderNo}</td>
		<td><fmt:formatDate value="${order.createdAt}"
				pattern="yyyy-MM-dd HH:mm" /></td>
		<td>${order.shippingName}</td>
		<td>￥${order.payAmount}(运费：￥${order.shippingFee})</td>
		<td class="shop_state"><c:if test="${order.orderStatus==0}">
                                                                                           未付款
    </c:if> <c:if test="${order.orderStatus==1}">
                                                                                           待发货
    </c:if> <c:if test="${order.orderStatus==2}">
                                                                                            待收货
    </c:if> <c:if test="${order.orderStatus==3}">
                                                                                            已完成
    </c:if> <c:if test="${order.orderStatus==4}">
                                                                                            已取消
    </c:if></td>
		<td class="operatorImgClass"><c:if test="${order.orderStatus==1}">
				<a class="" data-toggle="modal" href="#static4"
					onclick="deliverGoods('${order.id}')"> <img title="确认发货"
					src="${contextPath}/static/image/icon/delivery.png">
				</a>
			</c:if> <c:if test="${order.orderStatus!=1}">
				<a class=""> <img title="确认发货"
					src="${contextPath}/static/image/icon/dis_delivery.png">
				</a>
			</c:if> <a href="${contextPath}/admin/orders/details?id=${order.id}"
			class=""> <img title="订单详情"
				src="${contextPath}/static/image/icon/items.png">
		</a></td>
	</tr>
	<tr>
		<td colspan="7" class="detail">
			<table class="detail-tab" id="detail-tab"
				style='width: 100%; background: #fff'>
				<c:forEach items="${order.orderItems}" var="orderItem">
					<tr id="table-tr">
						<td style="text-align: left; background: #fff;"><span><img
								alt="${orderItem.goodName}"
								src="<%=qiniuPath%>${orderItem.picKey}"
								style="width: 60px; height: 60px" /></span> <span>${orderItem.goodName}</span>
							<span style="color: #3fa453;">${orderItem.skuProperties}</span> <span>[价格]￥${orderItem.salePrice}x[数量]${orderItem.quantity}</span>
							<span style="color: red;"> 
							<c:if test="${orderItem.refundsStatus==1}">
						                               退款申请
						    </c:if> <c:if test="${orderItem.refundsStatus==2}">
						                              退款中
						    </c:if> <c:if test="${orderItem.refundsStatus==3}">
						                                退款成功
						    </c:if> <c:if test="${orderItem.refundsStatus==4}">
						                               换货申请
						    </c:if> <c:if test="${orderItem.refundsStatus==5}">
						                              已换货
						    </c:if> <c:if test="${orderItem.refundsStatus==6}">
						                               已 拒绝
						    </c:if>
						</span></td>
					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
</c:forEach>

