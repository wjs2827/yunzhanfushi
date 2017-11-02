<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>订单详情</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="${contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/style-metro.css" rel="stylesheet"
	type="text/css" />

<link href="${contextPath}/static/css/style.css" rel="stylesheet"
	type="text/css" />

<link href="${contextPath}/static/css/style-responsive.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/default.css" rel="stylesheet"
	type="text/css" id="style_color" />

<link href="${contextPath}/static/css/uniform.default.css"
	rel="stylesheet" type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<style>
.item-textarea {
	width: 127%;
	outline: none;
	height: 50px;
	resize: none;
	margin-left: 0%;
}

.LEft {
	margin-right: 20rem;
}

.lable-control {
	margin-left: 10px;
	text-align: left !important;
}
</style>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed  page-footer-fixed">

	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<%@include file="/WEB-INF/layouts/header.jsp"%>
	</div>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->

	<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<%@include file="/WEB-INF/layouts/menu.jsp"%>

		</div>
		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>portlet Settings</h3>

				</div>

				<div class="modal-body">

					<p>Here will be a configuration form</p>

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">

							<!-- <div class="color-mode-icons icon-color"></div> -->

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">



								<ul class="inline">

									<li class="color-black current color-default"
										data-style="default"></li>

									<li class="color-blue" data-style="blue"></li>

									<li class="color-brown" data-style="brown"></li>

									<li class="color-purple" data-style="purple"></li>

									<li class="color-grey" data-style="grey"></li>

									<li class="color-white color-light" data-style="light"></li>

								</ul>

								<label> <span>Layout</span> <select
									class="layout-option m-wrap small">

										<option value="fluid" selected>Fluid</option>

										<option value="boxed">Boxed</option>

								</select>

								</label> <label> <span>Header</span> <select
									class="header-option m-wrap small">

										<option value="fixed" selected>Fixed</option>

										<option value="default">Default</option>

								</select>

								</label> <label> <span>Sidebar</span> <select
									class="sidebar-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

								</select>

								</label> <label> <span>Footer</span> <select
									class="footer-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

								</select>

								</label>

							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER -->

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							<!-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small></small> -->

						</h3>

						<ul class="breadcrumb">
							<li><a style="margin-left: 0rem">当前订单状态</a> <span>：</span></li>
							<c:if test="${order.orderStatus==0}">
								<li><a href="#" style="margin-right: .8rem; color: red">未付款</a>
							</c:if>
							<c:if test="${order.orderStatus==1}">
								<li><a href="#" style="margin-right: .8rem; color: red">待发货</a>
							</c:if>
							<c:if test="${order.orderStatus==2}">
								<li><a href="#" style="margin-right: .8rem; color: red">待收货</a>
							</c:if>
							<c:if test="${order.orderStatus==3}">
								<li><a href="#" style="margin-right: .8rem; color: red">已完成</a>
							</c:if>
							<c:if test="${order.orderStatus==4}">
								<li><a href="#" style="margin-right: .8rem; color: red">已撤消</a>
							</c:if>
							<c:if test="${order.orderStatus==5}">
								<li><a href="#" style="margin-right: .8rem; color: red">已评论</a>
							</c:if>
							<li><a
								href="javascript:window.location.href='${contextPath}/admin/orders/list'"><span
									style='margin-left: 1rem;'>关闭</span></a></li>
						</ul>


						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

					<!-- END PAGE HEADER-->

					<!-- BEGIN PAGE CONTENT-->



					<div class="row-fluid ">

						<div class="span12">

							<!-- BEGIN INLINE TABS PORTLET-->

							<div class="">
								<div class="portlet-body">

									<div class="row-fluid">

										<div class="span12">

											<!--BEGIN TABS-->

											<div class="tabbable tabbable-custom">

												<ul class="nav nav-tabs">

													<li class="active"><a href="#tab_1_1"
														data-toggle="tab">订单信息</a></li>
													<li><a href="#tab_1_3" data-toggle="tab">物流信息</a></li>
												</ul>

												<div class="tab-content">

													<div class="tab-pane active" id="tab_1_1">

														<div class="row-fluid">

															<div class="span12">

																<!-- BEGIN EXAMPLE TABLE PORTLET-->

																<div class="portlet box blue ">
																	<div class="portlet-title white">
																		<div class="caption">
																			<i class="icon-edit"></i>订单信息
																		</div>
																		<div class="tools">
																			<a href="javascript:;" class="reload"></a>
																		</div>
																	</div>
																	<div class="portlet-body">
																		<div class="controls_over">
																			<form action="#" class="form-horizontal">
																				<div class="control-group LEft">
																					<label class="control-label"><span>订单编号：</span></label>
																					<label class="control-label lable-control"><span>${order.orderNo}</span></label>
																				</div>
																				<div class="control-group LEft">
																					<label class="control-label">下单时间：</label> <label
																						class="control-label lable-control"><fmt:formatDate
																							value="${order.createdAt}"
																							pattern="yyyy-MM-dd HH:mm" /></label>
																				</div>
																				<div class="control-group LEft">
																					<label class="control-label">发货时间：</label> <label
																						class="control-label lable-control"><fmt:formatDate
																							value="${order.shippingAt}"
																							pattern="yyyy-MM-dd HH:mm" /></label>
																				</div>
																				<div class="control-group guige LEft">
																					<label class="control-label">收货时间：</label> <label
																						class="control-label lable-control"><fmt:formatDate
																							value="${order.receiptAt}"
																							pattern="yyyy-MM-dd HH:mm" /></label>
																				</div>
																				<div class="control-group guige LEft">
																					<label class="control-label">下&nbsp;&nbsp;单&nbsp;&nbsp;人：</label>
																					<label class="control-label lable-control">${order.shippingName}</label>
																				</div>
																				<div class="control-group guige LEft">
																					<label class="control-label">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
																					<label class="control-label lable-control">${order.mobile}</label>
																				</div>

																			</form>
																		</div>

																		<table
																			class="table table-striped table-hover table-bordered"
																			id="" style="background-color: #eef1ed;">
																			<thead>
																				<tr>
																					<th>商品图片</th>
																					<th>商品名称</th>
																					<th>规格</th>
																					<th>价格</th>
																					<th>数量</th>
																					<th>状态</th>
																				</tr>
																			</thead>
																			<tbody>
																				<c:forEach items="${order.orderItems}" var="goods">
																					<tr class="">
																						<td><img alt="${goods.goodName}"
																							src="<%=qiniuPath%>${goods.picKey}"
																							style="width: 60px; height: 60px" /></td>
																						<td>${goods.goodName}</td>
																						<td><span style="color: #3fa453;">${goods.skuProperties}</span></td>
																						<td>￥${goods.salePrice}</td>
																						<td>x${goods.quantity}</td>
																						<td><span style="color: red;"> <c:if
																									test="${goods.refundsStatus==1}">
																			                               退款申请
																			    </c:if> <c:if test="${goods.refundsStatus==2}">
																			                               商家处理中
																			    </c:if> <c:if test="${goods.refundsStatus==3}">
																			                                退款成功
																			    </c:if> <c:if test="${goods.refundsStatus==4}">
																			                                 拒绝退款
																			    </c:if>
																						</span></td>
																					</tr>
																				</c:forEach>
																			</tbody>
																		</table>
																		<table
																			class="table table-striped table-hover table-bordered"
																			style="background-color: #eef1ed;">
																			<thead>
																				<tr>
																					<th>合计金额：￥<span style="color: red;">${order.payAmount}</span></th>
																					<th>商品金额：￥<span style="color: red;">${order.orderAmount}</span></th>
																					<th>T金抵扣：￥<span style="color: red;">${order.payPoints}</span></th>
																					<th>订单运费：￥<span style="color: red;">${order.shippingFee}</span></th>

																				</tr>
																			</thead>
																		</table>
																	</div>
																</div>
																<!-- END EXAMPLE TABLE PORTLET-->
															</div>

														</div>
													</div>

													<div class="tab-pane" id="tab_1_3">
														<div class="row-fluid">

															<div class="span12">

																<!-- BEGIN EXAMPLE TABLE PORTLET-->

																<div class="portlet box blue ">

																	<div class="portlet-title white">

																		<div class="caption ">
																			<i class="icon-edit"></i>物流信息

																		</div>

																		<div class="tools">


																			<a href="javascript:;" class="reload"></a>

																		</div>

																	</div>

																	<div class="portlet-body">


																		<form action="#" class="form-horizontal Form">
																			<input type="hidden" id="orderId" value="${order.id}" />

																			<div class="control-group LEft">
																				<label class="control-label ">收货人:</label> <label
																					class="control-label lable-control">${order.shippingName}</label>
																			</div>
																			<div class="control-group LEft">
																				<label class="control-label">联系电话:</label> <label
																					class="control-label lable-control">${order.mobile}</label>
																			</div>
																			<div class="control-group guige LEft"
																				style="height: 60px">
																				<label class="control-label">收货地址:</label> <label
																					class="control-label lable-control">${order.pName}${order.cName}${order.dName}${order.shippingAddress}</label>
																			</div>
																			<div class="control-group guige LEft">
																				<label class="control-label">快递公司:</label> <label
																					class="control-label lable-control">${order.shippingVendor}</label>
																			</div>
																			<div class="control-group guige LEft">
																				<label class="control-label">快递单号:</label> <label
																					class="control-label lable-control">${order.shippingNo}</label>
																			</div>
																			<div class="control-group guige LEft"
																				style="height: 60px">
																				<label class="control-label ">发货备注:</label> <label
																					class="control-label lable-control">${order.shippingNote}</label>
																			</div>
																		</form>

																	</div>
																	<div class="portlet-body" id="go_store"
																		style="display: none">


																		<form action="#" class="form-horizontal Form">

																			<div class="control-group">

																				<label
																					style="font-size: 1.5rem; color: rgb(75, 141, 148);">到店自提</label>


																			</div>

																			<div class="control-group ">

																				<label class="control-label ">收货人:</label> <label
																					class="control-label ">${order.shippingName}</label>


																			</div>
																			<div class="control-group ">

																				<label class="control-label ">联系电话:</label> <label
																					class="control-label ">${order.mobile}</label>


																			</div>


																		</form>
																	</div>

																	<!-- END EXAMPLE TABLE PORTLET-->

																</div>

															</div>

														</div>

													</div>
												</div>

												<!--END TABS-->

											</div>


											<!--BEGIN TABS-->



											<!--END TABS-->

										</div>

									</div>



								</div>

							</div>

							<!-- END INLINE TABS PORTLET-->

						</div>

					</div>



					<!-- END PAGE CONTENT-->

				</div>

				<!-- END PAGE CONTAINER-->

			</div>

			<!-- BEGIN PAGE -->

		</div>

		<!-- END CONTAINER -->
	</div>
	<!-- BEGIN FOOTER -->

	<%@include file="/WEB-INF/layouts/footer.jsp"%>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="${contextPath}/static/js/jquery-1.10.1.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${contextPath}/static/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!--[if lt IE 9]>

<script src="${contextPath}/static/js/excanvas.min.js"></script>

<script src="${contextPath}/static/js/respond.min.js"></script>

<![endif]-->

	<script src="${contextPath}/static/js/jquery.slimscroll.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.blockui.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.cookie.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/jquery.uniform.min.js"
		type="text/javascript"></script>

	<!-- END CORE PLUGINS -->
	<script type="text/javascript"
		src="${contextPath}/static/js/select2.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.dataTables.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<script src="${contextPath}/static/js/app.js"></script>
	<script src="${contextPath}/static/js/table-editable.js"></script>
	<script src="${contextPath}/static/js/ui-jqueryui.js"></script>
	<script src="${contextPath}/static/js/form-components.js"></script>
	<script src="${contextPath}/static/js/table-advanced.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        TableEditable.init();
        UIJQueryUI.init();
        TableAdvanced.init();
    });
    

</script>
	<script type="text/javascript">
//发货
function orderDeliver(){
	var id=$("#orderId").val();
	var company=$("#logisCompany").val();
    var companyNum=$("#logisNumber").val();
    var shippingNote=$("#shippingNote").val();
    if(company ==undefined || company==''){
    	alert("请选择物流公司!");
    	return;
    }else{
		$.ajax({
			 url:"${contextPath}/shop/orders/deliver",
			 data:{id:id,company:company,companyNum:companyNum,shippingNote:shippingNote},
	         dataType: "json",
			  success: function(date){
				  if(date==true){
				    	alert("修改成功");
				    }else{
				    	alert("修改失败");
				    }			    
				  }
			});
    }
}
</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>