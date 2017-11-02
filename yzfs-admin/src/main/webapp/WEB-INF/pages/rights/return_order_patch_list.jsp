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
		<td>${order.rightsOrderNo}</td>
		<td><fmt:formatDate value="${order.createdAt}"
				pattern="yyyy-MM-dd HH:mm" /></td>
		<td>${order.nickName}</td>
		<td>￥${order.returnAmount}</td>
		<td class="shop_state">
		<c:if test="${order.orderStatus==0}">
                                         未付款
	    </c:if> 
	    <c:if test="${order.orderStatus==1}">
	                              待发货
	    </c:if> 
	    <c:if test="${order.orderStatus==2}">
	                              待收货
	    </c:if> 
	    <c:if test="${order.orderStatus==3}">
	                               已完成
	    </c:if> 
	    <c:if test="${order.orderStatus==4}">
	                               已取消
	    </c:if>
	    <c:if test="${order.orderStatus==5}">
	                               交易关闭
	    </c:if>
    </td>
		<td class="operatorImgClass">
				<c:if test="${order.refundsStatus==1}">
					<c:if test="${order.type}">
						<a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','TKSH')"> <img title="审核"
							src="${contextPath}/static/image/icon/SH.png">
						</a>
					</c:if>
					<c:if test="${!order.type}">
						<a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','CHSH')"> <img title="审核"
							src="${contextPath}/static/image/icon/SH.png">
						</a>
					</c:if>
					<a class=""><img title="确认退款退货" src="${contextPath}/static/image/icon/distk.png"></a>
					<a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','REFUSE')"> <img title="驳回"
							src="${contextPath}/static/image/icon/dis_refuse.png">
					</a>
				</c:if> 
				<c:if test="${order.refundsStatus==2}">
					<a class=""><img title="审核" src="${contextPath}/static/image/icon/DISSH.png"></a>
					<a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','TKQR')"> <img title="确认退款"
							src="${contextPath}/static/image/icon/tk.png">
					</a>
                    <a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','REFUSE')"> <img title="驳回"
							src="${contextPath}/static/image/icon/refuse.png">
					</a>
				</c:if>
				<c:if test="${order.refundsStatus==3}">
				    <a class=""><img title="审核" src="${contextPath}/static/image/icon/DISSH.png"></a>
					<a class=""><img title="确认退款退货" src="${contextPath}/static/image/icon/distk.png"></a>
					<a class=""><img title="驳回" src="${contextPath}/static/image/icon/dis_refuse.png"></a>
				</c:if>
				<c:if test="${order.refundsStatus==4}">
				    <a class=""><img title="审核" src="${contextPath}/static/image/icon/DISSH.png"></a>
					<a class="" data-toggle="modal" href="#refundStatic"
						onclick="refund('${order.orderItemId}','QRCH')"> <img title="确认换货"
						src="${contextPath}/static/image/icon/tk.png">
					</a>
                    <a class="" data-toggle="modal" href="#refundStatic"
							onclick="refund('${order.orderItemId}','REFUSE')"> <img title="驳回"
							src="${contextPath}/static/image/icon/refuse.png">
					</a>
				</c:if>
				<c:if test="${order.refundsStatus==5}">
				    <a class=""><img title="审核" src="${contextPath}/static/image/icon/DISSH.png"></a>
					<a class=""><img title="确认退货" src="${contextPath}/static/image/icon/distk.png"></a>
					<a class=""><img title="驳回" src="${contextPath}/static/image/icon/dis_refuse.png"></a>
				</c:if>
				<c:if test="${order.refundsStatus==6}">
				    <a class=""><img title="审核" src="${contextPath}/static/image/icon/DISSH.png"></a>
					<a class=""><img title="确认退货" src="${contextPath}/static/image/icon/distk.png"></a>
					<a class=""><img title="驳回" src="${contextPath}/static/image/icon/dis_refuse.png"></a>
				</c:if>
				<a href="${contextPath}/admin/rights/details?id=${order.id}"
				class=""> <img title="维权订单详情"
					src="${contextPath}/static/image/icon/items.png">
			    </a>
		    </td>
	</tr>
	<tr>
		<td colspan="7" class="detail">
			<table class="detail-tab" id="detail-tab"
				style='width: 100%; background: #fff'>
				<tr id="table-tr">
					<td style="text-align: left; background: #fff;"><span><img
							alt="${order.goodName}" src="<%=qiniuPath%>${order.picKey}"
							style="width: 60px; height: 60px" /></span> <span>${order.goodName}</span>
						<span style="color: #3fa453;">${order.skuProperties}</span> <span>￥${order.salePrice}</span>
						<span>x${order.quantity}</span> 
						<span> 
						<c:if test="${order.type}">
			                                                退款
			            </c:if> 
			            <c:if test="${!order.type}">
			                                                换货
			            </c:if>
						</span> 
						<span style="color: red;"> 
						<c:if test="${order.refundsStatus==1}">
					                               待审核
					    </c:if> 
					    <c:if test="${order.refundsStatus==2}">
					                              待退款
					    </c:if> 
					    <c:if test="${order.refundsStatus==3}">
					                                退款成功
					    </c:if> 
					    <c:if test="${order.refundsStatus==4}">
					                               待换货
					    </c:if> 
					    <c:if test="${order.refundsStatus==5}">
					                              已换货
					    </c:if> 
					    <c:if test="${order.refundsStatus==6}">
					                               已拒绝
					    </c:if>
					</span></td>
				</tr>
			</table>
		</td>
	</tr>
</c:forEach>

