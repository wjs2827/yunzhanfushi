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
<meta content="<%=qiniuPath %>" name="qiniuPath" />

<title>商城管理 | 运费管理</title>

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

<!-- SKU模块CSS -->
<link href="${contextPath}/static/css/free/free.css" rel="stylesheet" />
<style>
.note-editor {
	margin-left: 11rem
}

<!--
多规格默认隐藏-->.dgeDivCss {
	display: none;
}

.input-group-addon {
	border-color: #dddddd;
	background-color: #dddddd;
	padding: 16px 12px;
	font-size: 14px;
	color: #555;
	border: 1px solid #dddddd;
	margin-left: -0.25rem;;
}

.cities {
	max-height: 234px;
	height: 245px;
	overflow-y: auto;
	border: 1px solid #c8d4e5;
	padding: 5px 10px;
}

ul.js_cities_cxselect, ul.js_cities_cxselect li {
	list-style: none;
}

.modal.fade.in {
	width: 800px;
	margin-left: -400px;
}

.checkbox img {
	width: 25px;
	height: 25px;
}

.org-nodes .tree-expand-close {
	background-position: 0 0;
}

.org-nodes .tree-expand {
	width: 13px;
	height: 13px;
	overflow: hidden;
	margin: 14px 2px 0 -1px;
}

.iconclass {
	float: left;
	width: 16px;
	height: 16px;
	margin-right: 5px;
}

.pull-right {
	margin-right: 30px;
	border: 1px solid #c8d4e5;
	padding: 5px;
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

						<h3 class="page-title"></h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <span
								class="icon-angle-right"> </span></li>

							<li><a href="#">商城管理</a> <span class="icon-angle-right"></span>

							</li>

							<li><a href="#">运费管理</a></li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-edit"></i>免邮设置
							</div>
							<div class="tools">
								<a href="javascript:refresh();" class="reload"></a>
							</div>
						</div>
						<div class="portlet-body">
							<table class="table table-striped table-hover table-bordered">
								<thead>
									<tr>
										<th>标题</th>
										<th>免邮消费额度</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody class="tbodyClassTwo">
									<c:forEach items="${readList}" var="config">
										<tr class="">
											<td>${config.configName}</td>
											<td><input id="${config.id}" type="hidden"
												value="${config.configValue}" />${config.configValue}</td>
											<td><c:if test="${config.status==true}">
													<a data-toggle="modal" href="#isUsedStatic"
														onclick="configChange('${config.id}','0');"> <img
														title="已开启"
														src="${contextPath}/static/image/icon/open.png"
														style="width: 30px; margin-left: 5%;">
													</a>
												</c:if> <c:if test="${config.status==false}">
													<a data-toggle="modal" href="#isUsedStatic"
														onclick="configChange('${config.id}','1');"> <img
														title="已关闭"
														src="${contextPath}/static/image/icon/dis_open.png"
														style="width: 30px; margin-left: 5%;">
													</a>
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</div>

				<div class="row-fluid">

					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">
								<i class="icon-edit"></i>运费模板设置
							</div>
							<div class="tools"></div>
						</div>

						<div class="portlet-body form">

							<!-- BEGIN FORM-->

							<form class="form-horizontal" id="tempForm" name="tempForm"
								onsubmit="return false;">
								<input type='hidden' id="tempLength" name='tempLength'>
								<input type='hidden' id="isUsed" name='isUsed'>
								<div class="control-group">
									<label class="control-label">模板名称：</label>
									<div class="controls">
										<input class="span3 m-wrap" type="text" id="tempName"
											name="tempName" style="width: 10rem;"
											value="${params.tempName}" /> <span class="help-inline"
											id="expressNameError"></span>
									</div>
								</div>

								<!-- 运费计算方式-->
								<div class='control-group'>
									<label class="control-label">运费计算方式：</label>
									<div class="all-guige">
										<input type='radio' value='0'
											style="float: left; margin-left: 1px;" checked='checked'
											id='checkboxbear' name='checkboxbear' /> <span>买家承担运费</span>
									</div>
								</div>
								<!-- 配送方式-->
								<div class='control-group'>
									<label class="control-label">配送方式：</label>
									<div class="all-guige">
										<input type='radio' value='0'
											style="float: left; margin-left: 1px;" checked='checked'
											id='checkboxtype' name='checkboxtype' /> <span>快递</span>
									</div>
								</div>

								<!-- 计价方式-->
								<div class='control-group'>
									<label class="control-label">计价方式：</label>
									<div class="all-guige">
										<input type='radio' value='0'
											style="float: left; margin-left: 1px;" checked='checked'
											id='checkboxpriceType' name='checkboxpriceType' /> <span>按重量</span>
									</div>
								</div>

								<!--设置可配送区域和运费-->
								<div class='control-group'>
									<label class="control-label">设置可配送区域和运费：</label>
									<div class="controls" id="createTable">
										<table id="process" class="columnList">
											<thead>
												<tr>
													<th width="500" colspan="5">设置可配送区域和运费</th>
												</tr>
												<tr>
													<th width="500">配送区域</th>
													<th width="100">首重(kg)</th>
													<th width="200">运费(元)</th>
													<th width="100">续重(kg)</th>
													<th width="200">运费(元)</th>
												</tr>
											</thead>
											<tbody class="freeTbody">



											</tbody>
											<tfoot>
												<tr>
													<th colspan="5" class="addFreeTR"><a
														href="javascript:;"><img
															src='/yzfs-admin/static/image/icon/fedit.png'
															style='width: 20px; height: 20px;' />设置可配送区域和运费</a></th>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
							</form>
							<div class="form-actions">
								<button type="button" id="save" class="btn blue">保存</button>
							</div>
							<!-- END FORM-->

						</div>

					</div>

					<!-- END SAMPLE FORM PORTLET-->

				</div>


			</div>


			<!-- END PAGE CONTENT-->
		</div>
		<!-- END PAGE CONTAINER-->

	</div>

	<!-- END PAGE -->

	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>

	<!-- 启用规则信息 -->
	<div id="isUsedStatic" class="modal fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p class="isUsedStaticTitle"></p>
		</div>
		<div class="modal-body" style="text-align: center;">
			<p class="sysConfigValue">
				满金额免邮费：<input required="required" />
			</p>
		</div>
		<span class="errorIsUsed" style="color: red; margin-left: 15rem;"></span>
		<div class="modal-footer">
			<button type="button" class="btn green" id="isUsedComfirSave">保存</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>
		</div>
	</div>

	<!-- 设置运费所属区域 -->
	<div id="freeDialog" class="modal fade" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="bootbox-close-button close"
						data-dismiss="modal" aria-hidden="true"></button>
					<h4 class="modal-title">选择可配送区域</h4>
				</div>
				<div class="modal-body">
					<div class="bootbox-body">
						<div class="form-horizontal region_box clearfix"
							style="width: 780px">
							<div class="pull-left ">
								<section class="panel panel-default select_org_lists">
									<header class="panel-heading bg-light">
										可选省、市、区---当前位置:[<span class="current_place"></span>]
									</header>
									<div class="panel-body">
										<div class="pull-left">
											<select size="10" id="provinceId"
												class="form-control province js_province_cxselect"
												style="height: 245px;">

											</select>
										</div>

										<div class="pull-left">
											<ul class="cities js_cities_cxselect">

											</ul>
										</div>
									</div>
								</section>
							</div>
							<div class="pull-right">
								<section class="panel panel-default select_org_lists"
									style="width: 240px; overflow: auto;">
									<div class="panel-body js_select_html" style="height: 302px">
										<div class="root clearfix ">
											<div class="node-item  pull-left"
												style="margin-bottom: 10px;">已选省、市、区</div>
										</div>
										<div class="org-nodes"></div>
									</div>
								</section>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button data-bb-handler="success" type="button" id="saveDistrictId"
						data-dismiss="modal" class="btn btn-primary">确定</button>
					<button type="button" data-dismiss="modal" class="btn">取消</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 删除弹框结束 -->

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
	<script src="${contextPath}/static/css/free/free.js"></script>
	<script src="${contextPath}/static/js/utils.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
	    //默认加载数据
		jQuery(document).ready(function() {  
		   App.init();
		   initProvinceList();
		   batchfreeList();
		});
		
	</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>