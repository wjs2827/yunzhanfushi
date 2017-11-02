<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
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

<title>商品管理|商品详情</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

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

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/bootstrap-fileupload.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/jquery.gritter.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/chosen.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/jquery.tagsinput.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/clockface.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/bootstrap-wysihtml5.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/datepicker.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/timepicker.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/colorpicker.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/bootstrap-toggle-buttons.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/daterangepicker.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/datetimepicker.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/multi-select-metro.css" />

<link href="${contextPath}/static/css/bootstrap-modal.css"
	rel="stylesheet" type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed page-footer-fixed">

	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<%@include file="/WEB-INF/layouts/header.jsp"%>
	</div>
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->
			<%@include file="/WEB-INF/layouts/menu.jsp"%>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->


			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">

							<!-- <div class="color-mode-icons icon-color"></div> -->

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								<p>THEME COLOR</p>

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
						<h3 class="page-title">
							<!-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small></small> -->
						</h3>
						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a href="#">首页</a> <span
								class="icon-angle-right"></span></li>
							<li><a href="#">商品管理</a> <span class="icon-angle-right"></span>
							</li>
							<li><a href="#">商品详情</a></li>
						</ul>
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>自营商品
								</div>
								<div class="tools">
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="javascript:;" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<div class="form-horizontal">
									<div class="control-group">
										<label class="control-label">排序：</label> <label
											class="control-label label_one">${goodsInfoVo.rank}</label>
									</div>
									<div class="control-group">
										<label class="control-label">经营类型：</label> <label
											class="control-label label_one">自营</label>
									</div>
									<div class="control-group">
										<label class="control-label">商品一级分类：</label>
										<div class="controls">
											<div class="span3 m-wrap"
												style="padding-top: .5rem; display: block; float: left;">
												${goodsInfoVo.parentName}</div>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品二级分类：</label>
										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.classesName}</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品名称：</label>
										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.name}</div>
									</div>
									<!-- 是否多规格 开始-->
									<div class='control-group'>
										<label class="control-label">商品规格：</label>
										<div class="all-guige">
											<c:if test="${goodsInfoVo.isunifiedSpec==true}">
												<input type='radio' value='1'
													style="float: left; margin-left: 1px;" checked='checked'
													id='checkboxspec' name='isunifiedSpec' />
												<span>统一规格</span>
											</c:if>
											<c:if test="${goodsInfoVo.isunifiedSpec==false}">
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" checked='checked'
													id='checkboxspec' name='isunifiedSpec' />

												<span>多规格</span>
											</c:if>
										</div>
									</div>
									<!-- 是否多规格结束-->
									<c:if test="${goodsInfoVo.isunifiedSpec==true}">
										<!-- 统一规格开始-->
										<c:forEach items="${goodSpecList}" var="specs" begin="0"
											varStatus="status">
											<input type="hidden" id="specId" name="specId"
												value="${specs.id}" />
											<div id="tyspecDiv">
												<div class="control-group">
													<label class="control-label">库存：</label>
													<div class="controls">
														<input class="span3 m-wrap" type="Number"
															placeholder="请输入库存" id="stock_count" name="stock_count"
															value="${specs.stockCount}" onblur="onBlurGoodStock();" />
														<span class="help-inline" id="stockCountError">必填项</span>
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">销售价：</label>
													<div class="controls">
														<input class="span3 m-wrap" type="text"
															placeholder="请输入销售价" id="salePrice" name="salePrice"
															value="${specs.salePrice}" onkeyup="onBlurSalePrice();"
															onblur="onBlurSalePrice();" /> <span class="help-inline"
															id="salePriceError">必填项</span>
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">显示价：</label>
													<div class="controls">
														<input class="span3 m-wrap" type="text"
															value="${goodsInfoVo.showPrice}" disabled id="d_price" />
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">销售积分：</label>
													<div class="controls">
														<input class="span3 m-wrap" type="text"
															placeholder="非必填项，默认为无需积分购买" id="salePoints"
															name="salePoints" onkeyup="onBlurSalePoints();"
															value="${specs.salePoints}" onblur="onBlurSalePoints();" />
														<span class="help-inline" id="salePointsError">如无需积分请填0，价格和积分不能同时为0</span>
													</div>
												</div>
												<div class="control-group">
													<label class="control-label">显示积分：</label>
													<div class="controls">
														<input class="span3 m-wrap" type="text" disabled
															id="d_integrate" value="${goodsInfoVo.showPoints}" />
													</div>
												</div>
											</div>
										</c:forEach>
										<!-- 统一规格 结束-->
									</c:if>
									<c:if test="${goodsInfoVo.isunifiedSpec==false}">
										<!-- 多规格开始-->
										<div id="dgespecDiv">
											<c:forEach items="${goodSpecList}" var="specs" begin="0"
												varStatus="status">
												<div class='control-group gui' id='gui_${status.index}'>
													<div class='controls controls-two'>
														<input type='hidden' id='goodsSpecses${status.index}id'
															name='goodsSpecses[${status.index}].id'
															value='${specs.id}' /> <label class='control-label'>规格名称：</label>
														<input class='span3 m-wrap dspec' type='text'
															placeholder='规格名称' id='goodsSpecses${status.index}name'
															name='goodsSpecses[${status.index}].name'
															value="${specs.name}"
															onblur="onBlurMultipleSpec('${status.index}');" /> <span
															class='help-inline kucun'>库存：</span> <input
															class='span3 m-wrap dspec' type='text' placeholder='库存数量'
															id='goodsSpecses${status.index}stockCount'
															name='goodsSpecses[${status.index}].stockCount'
															value="${specs.stockCount}"
															onblur="onBlurMultipleSpec('${status.index}');" /> <span
															class='help-inline kucun'>价格：</span> <input
															class='span3 m-wrap dspec' type='text' placeholder='销售价格'
															id='goodsSpecses${status.index}salePrice'
															name='goodsSpecses[${status.index}].salePrice'
															value="${specs.salePrice}"
															onblur="onBlurMultipleSpec('${status.index}');" /> <span
															class='help-inline kucun'>积分：</span> <input
															class='span3 m-wrap dspec' type='text' placeholder='销售积分'
															id='goodsSpecses${status.index}salePoints'
															name='goodsSpecses[${status.index}].salePoints'
															value="${specs.salePoints}"
															onkeyup="onBlurMultipleSpec('${status.index}');" />
													</div>
												</div>
											</c:forEach>
											<div class="control-group">
												<c:if
													test="${goodsInfoVo.showPrice !='0.00' && goodsInfoVo.showPrice !='0.0' && goodsInfoVo.showPrice !='0'}">
													<div id="showPriceDiv">
														<label class="control-label">显示价：</label>
														<div class="controls three-control controls-two">
															<select class="span3 m-wrap" id="selectPrice"
																onchange="onblurChangePrice();">
																<c:forEach items="${goodSpecList}" var="specsShowPrice"
																	begin="0" varStatus="status">
																	<option value="${goodsInfoVo.showPrice}"
																		<c:if test="${goodsInfoVo.showPrice==specsShowPrice.salePrice}">selected</c:if>>${specsShowPrice.name}</option>
																</c:forEach>
															</select> <span class="help-inline" id="selectPriceError"></span>
														</div>
													</div>
												</c:if>
												<c:if test="${goodsInfoVo.showPoints !='0'}">
													<div id="showPointsDiv">
														<label class="control-label">显示积分：</label>
														<div class="controls three-control controls-two">
															<select class="span3 m-wrap" id="selectPoints"
																onchange="onblurChangePoints();">
																<c:forEach items="${goodSpecList}" var="specsShowPoints"
																	begin="0" varStatus="status">
																	<option value="${goodsInfoVo.showPoints}"
																		<c:if test="${goodsInfoVo.showPoints==specsShowPoints.salePoints}">selected</c:if>>${specsShowPoints.name}</option>
																</c:forEach>
															</select> <span class="help-inline" id="selectPointsError"></span>
														</div>
													</div>
												</c:if>
											</div>
											<span class="help-inline" id="dgespecError"></span>
										</div>
										<!-- 多规格 结束-->
									</c:if>
									<div class="control-group">
										<label class="control-label">市场价：</label>
										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.markketPrice}</div>
									</div>
									<div class="control-group">
										<label class="control-label">限购数量：</label>
										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.limitedCount}</div>
									</div>
									<div class="control-group">
										<label class="control-label">自定义销量：</label>

										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.customizeStock}</div>
									</div>
									<div class="control-group">
										<label class="control-label">是否单购商品 ：</label>
										<div class="controls" style="padding-top: .5rem;">
											<c:if test="${goodsInfoVo.isSingleOrder==true}">
											是
											</c:if>
											<c:if test="${goodsInfoVo.isSingleOrder==false}">
											否
											</c:if>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品图片 ： </label>
										<c:if test="${goodPicList.size()>0}">
											<c:forEach items="${goodPicList}" var="picses" begin="0"
												varStatus="picsesstatus">
												<div class="Contro" id="contro_${status.index}">
													<div class="fileupload fileupload-new Add_Img">
														<div class="fileupload-new thumbnail"
															style="width: 64px; height: 64px;">
															<span class="btn btn-file"> <span
																class="fileupload-new"> <img
																	src="<%=qiniuPath%>${picses.picKey}" alt=""
																	style="width: 64px; height: 50px;"
																	class="fileupload-new" /></span>
															</span>
														</div>
													</div>
												</div>
											</c:forEach>
										</c:if>
									</div>
									<div class="control-group">
										<label class="control-label">商品详情：</label>
										<div class="controls">${goodsInfoVo.descriptions}</div>
									</div>
									<div class="control-group">
										<label class="control-label">运费：</label>
										<div class="controls" style="padding-top: .5rem;">
											${goodsInfoVo.shippingFee}</div>
									</div>
									<%-- 									<div class="control-group">
										<label class="control-label">奖金比例(%)：</label>
										<div class="controls" style="padding-top:.5rem;">
											${goodsInfoVo.commission}
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">是否上架 ：</label>
										<div class="controls" style="padding-top:.5rem;">
											<c:if test="${goodsInfoVo.isSale==true}">
											是
											</c:if>
											<c:if test="${goodsInfoVo.isSale==false}">
											否
											</c:if>
										</div>
									</div> --%>
									<div class="form-actions">
										<button id="close" class="btn blue" onclick="shut()">关闭</button>
									</div>
									<!-- END FORM-->
								</div>
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
					<!-- END PAGE CONTENT-->
				</div>
			</div>
			<!-- END PAGE CONTAINER-->
			<!-- END PAGE -->
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

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript"
		src="${contextPath}/static/js/ckeditor.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-fileupload.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/chosen.jquery.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/select2.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/wysihtml5-0.3.0.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.tagsinput.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.toggle.buttons.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/clockface.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/date.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/daterangepicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-colorpicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-timepicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.inputmask.bundle.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.input-ip-address-control-1.0.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.multi-select.js"></script>

	<script src="${contextPath}/static/js/bootstrap-modal.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/bootstrap-modalmanager.js"
		type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/form-components.js"></script>

</body>

<!-- END BODY -->
<script type="text/javascript">
   function shut(){
	   window.location.href="${contextPath}/shop/goods/list";
   };

</script>
</html>