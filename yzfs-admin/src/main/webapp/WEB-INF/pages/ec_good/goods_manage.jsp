<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>商品管理</title>

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
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<link href="${contextPath}/static/css/alert.css" rel="stylesheet" />
<style>
.operatorImgClass img {
	width: 30px;
	margin-left: 5%;
}
</style>
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

							<%--  <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>商品管理</small> --%>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">基础信息</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">商品管理</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption">
									<i class="icon-edit"></i>商品管理 <a class="icon-plus addGoods"
										title="新增商品" data-toggle="modal"
										href="javascript:window.location.href='add';"
										id="sample_editable_1_goods"> </a>
								</div>
								<div class="tools">
									<a href="javascript:initGoodList();" class="reload"></a>
								</div>

							</div>
							<div class="portlet-body">
								<form action="" id="goodsForm" method="post">
									<div class="bott">

										<span style="width: 14rem" class="Check_Span"><input
											type="text" id="paramGoodName" name="paramGoodName"
											class="find_store_name" placeholder="输入商品编码/商品名称" /> </span> <span>
											<select id="is_sale_value" name="isSale"
											onchange="initGoodList();">
												<option value="">上/下架</option>
												<option value="1">上架</option>
												<option value="0">下架</option>
										</select>
										</span> <span> <select id="secondClassId" name="classId"
											onchange="initGoodList();">
										</select>
										</span> <input type="hidden" id="sale_good_id" name="sale_good_id">
										<%--                             <c:if test="${params.isSale==true}">
                              <button   style="margin-top:0" type="button" class="find_stor btn blue" onclick="batchUpdateIsSale();" >批量下架</button>
                            </c:if>
                            <c:if test="${params.isSale==false}">
                              <button   style="margin-top:0" type="button" class="find_stor btn blue" onclick="batchUpdateIsSale();">批量上架</button>
                              <button   style="margin-top:0" type="button" class="find_stor btn blue" onclick="batchUpdateDel();" >批量删除</button>
                            </c:if> --%>
										<%--                             <c:if test="${params.isSale !=true and params.isSale !=false}">
                              <a  href="javascript:ohSnap('亲!请过滤上架或者下架,并选择批量上架或者下架的商品！','black');"><button style="margin-top:0" type="button" class="find_stor btn blue" >批量上/下架</button></a>
                              <a  href="javascript:ohSnap('亲!请过滤上架商品,并选择批量删除的商品！','black');"><button type="button"   style="margin-top:0" class="find_stor btn blue" >批量删除</button></a>
                            </c:if>
                             <button  href="#outType" data-toggle="modal"  style="margin-top:0" type="button" class="find_stor btn blue">商品导出</button> --%>
										<img src="${contextPath}/static/image/icon/search.png"
											width="30px;" id="btn_item_search"
											style="margin-top: -.5rem; margin-left: 1rem;"
											onclick="initGoodList();" />
									</div>
								</form>
								<table class="table table-striped table-hover table-bordered"
									id="sample_editable_1">
									<thead>
										<tr>
											<%--  <th><img alt="" id="AllChecked" src="${contextPath}/static/image/kong.png" style="width:30px;"/></th> --%>

											<th>商品编号</th>

											<th>商品名称</th>

											<th>商品分类</th>

											<th>当前库存</th>

											<th>实际销量</th>

											<th>状态</th>

											<th>排序值</th>

											<th>操作</th>
										</tr>
									</thead>
									<tbody class="tbodyClassOne">


									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT -->

			</div>
			<div id="full-width" class="modal container hide fade" tabindex="-1">

				<div class="modal-header ADD_GOODS">

					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>

					<h3 class="Header">添加商品</h3>

				</div>

				<div class="modal-footer">

					<button type="button" class=" btn green" id="Add_goods_Sure"
						data-dismiss="modal" onclick="window.location.href='add';">添加自营商品</button>
					<button type="button" class="btn green" id="Add_goods_can_cel"
						data-dismiss="modal" href="#static1" data-toggle="modal">添加代理商品</button>

				</div>

			</div>

			<!-- 是否删除商品 -->
			<div id="static" class="modal hide fade" tabindex="-1"
				data-backdrop="static" data-keyboard="false">
				<div class="modal-body">
					<p>你确定删除此商品吗?</p>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn"
						id="Delete_S_cancel">取消</button>
					<button type="button" data-dismiss="modal" class="btn green"
						id="Delete_S_sure">确定</button>
				</div>
			</div>

			<!-- 是否上下架 -->
			<div id="static1" class="modal hide fade" tabindex="-1"
				data-backdrop="static1" data-keyboard="false">
				<div class="modal-body">
					<p id="titleSale"></p>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal"
						class="btn delete-s-cancel" id="Delete_S_cancel">取消</button>
					<button type="button" data-dismiss="modal" class="btn green"
						id="IsSaleBtn">确定</button>
				</div>
			</div>
		</div>

		<!-- 是否删除商品 -->
		<div id="copy" class="modal hide fade" tabindex="-1"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-body">
				<h5 class="Header" id="copyTitle"></h5>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn green"
					id="confirmCopy">确定</button>
				<button type="button" data-dismiss="modal" class="btn"
					id="Delete_S_cancel">取消</button>
			</div>
		</div>
		<!-- END PAGE -->

	</div>

	<!-- 导出 -->
	<div id="outType" class="modal container hide fade" tabindex="-1">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">确认要商品导出吗?</h3>
		</div>
		<span id="errorHtml3" style="color: red; margin-left: 140px;"></span>
		<div class="modal-footer">
			<button type="button" class="btn green" id="up_user_amount_button"
				onclick="excelOut()">确定</button>
			<button type="button" data-dismiss="modal" class="btn">取消</button>
		</div>
	</div>
	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>
	<!-- END CONTAINER -->

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

	<%-- <script type="text/javascript" src="${contextPath}/static/js/select2.min.js"></script> --%>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.dataTables.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/ec_good/good_list.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        initGoodList();
    });
    
</script>

</body>

<!-- END BODY -->

</html>