<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>系统设置 | 参数设置</title>

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

<link rel="stylesheet" href="${contextPath}/static/css/alert.css" />

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

			<!-- BEGIN SIDEBAR MENU -->

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

							<%--   <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>参数设置</small> --%>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">系统设置</a> <i class="icon-angle-right"></i></li>

							<li><a href="${contextPath}/role/whole">参数设置</a></li>

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
									<i class="icon-edit"></i>充值套餐
								</div>
								<div class="tools">
									<a data-toggle="modal" href="#rechargeStatic"
										class="icon-plus white"
										onclick="editSysRecharge('','','','');"></a> <a
										href="javascript:initSysRechargeRuleList();" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body">
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th>充值金额</th>
											<th>描述</th>
											<th>余额增加</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody class="tbodyClassOne">

									</tbody>
								</table>
							</div>
						</div>


						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-edit"></i>参数设置
								</div>
								<div class="tools">
									<a href="javascript:initSysConfigList();" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body">
								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th>编码</th>
											<th>描述</th>
											<th>参数值</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody class="tbodyClassTwo">

									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- 加载中 -->
		<div id="publicDiload"></div>
		<!-- END PAGE CONTENT -->

	</div>

	<div id="ohsnap"></div>
	<!-- 修改T金设置 -->
	<div id="sysConfigStatic" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p>亲!确认要修改保存该信息?</p>
		</div>
		<div class="modal-body" style="text-align: center;">
			<p class="sysConfigValue"></p>
			<p class="newSysConfigValue"></p>
			<p class="sysConfigType"></p>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn green"
				id="confimSave">保存</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>

		</div>
	</div>

	<!-- 修改充值套餐 -->
	<div id="rechargeStatic" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="rechargeTtile"></h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num" id="rechargeInputClor">
				<span class="user_name">充值金额： <input type="text"
					name="rechargeAmount" id="rechargeAmount" placeholder="充值金额" /></span><br>
				<span class="user_name">充值文字： <input type="text"
					name="remark" id="remark" placeholder="充值文字" /></span><br> <span
					class="user_name">余额增加： <input type="text"
					name="attachAmount" id="attachAmount" placeholder="余额增加" />
				</span>
			</div>
		</div>
		<div id="recharge_err_msg" class="red margin_left"></div>
		<div class="modal-footer">
			<button type="button" data-dismiss="" class="btn green"
				id="btn_recharge_save">确定</button>
			<button type="button" data-dismiss="modal" class="btn_admin_cancel">取消</button>
		</div>
	</div>

	<!--删除或者启用 -->
	<div id="rechargeStaticDel" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p class="isUsedTitle"></p>
		</div>
		<div class="modal-body" style="text-align: center;">
			<p class="sysConfigValue"></p>
			<p class="newSysConfigValue"></p>
			<p class="sysConfigType"></p>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn green"
				id="isUsedSave">保存</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>

		</div>
	</div>
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

<script src="media/js/excanvas.min.js"></script>

<script src="media/js/respond.min.js"></script>

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
		src="${contextPath}/static/js/select2.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.dataTables.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<!-- 系统设置js -->
	<script src="${contextPath}/static/js/sysconfig/sysconfig.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>

	<script>

    jQuery(document).ready(function() {
        App.init();
        //初始化充值规则
        initSysRechargeRuleList();
        //初始化规则
        initSysConfigList();
    });
  
</script>

</body>

<!-- END BODY -->

</html>