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

<meta content="<%=qiniuPath %>" name="qiniuPath" />

<title>微友管理 | 帮助说明</title>

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
<link href="${contextPath}/static/themes/default/default.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/media/summernote.css">
<link rel="stylesheet" href="${contextPath}/static/css/alert.css" />

<style>
.operatorImgClass img {
	width: 30px;
	margin-left: 5%;
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

							<img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>微友管理</small>

						</h3>

						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">微友管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="${contextPath}/role/whole">帮助说明</a></li>

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
									<i class="icon-edit"></i>帮助说明
								</div>
							</div>
							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form class="form-horizontal" id="selfgoods" name="selfgoods"
									onsubmit="return false;">
									<input type="hidden" id="qiniupath" value="<%=qiniuPath%>" /> <input
										type="hidden" id="id" name="id" value=" ${manager.id}" /> <input
										type="hidden" id="type" name="type" value="1" />
									<div class="control-group">
										<label class="control-label">标题：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="text" id="title"
												name="title" value="${manager.title}" placeholder="请输入标题"
												onblur="onBlurGoodSpuCode();" /> <span class="help-inline"
												id="titleError">必填项</span>
										</div>
									</div>
									<input type="hidden" id="ke_qiniu_upload" />
									<div class="control-group">
										<label class="control-label">帮助内容 ：</label>
										<div class="controls">
											<div name="descriptions" id="summernote_1">
												${manager.content}</div>
										</div>
									</div>
									<input id="desContent" name="desContent" type="hidden" />
									<div class="form-actions">
										<button type="button" id="save" class="btn blue">保存</button>
									</div>

								</form>

								<!-- END FORM-->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- END PAGE CONTENT -->

	</div>
	<!-- END PAGE CONTAINER-->

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->
	<div id="ohsnap"></div>
	<div class="modal-backdrop fade in none"></div>
	<%@include file="/WEB-INF/layouts/footer.jsp"%>


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

	<!-- 七牛upload js -->
	<script type="text/javascript"
		src="${contextPath }/static/js/plupload.full.min.js"></script>

	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu.min.js"></script>

	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu-init.js"></script>

	<!-- 富文本编辑器 -->
	<script src="${contextPath}/static/media/summernote.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/media/components-editors.js"></script>

	<script src="${contextPath}/static/js/help/help.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        ComponentsEditors.init();
        initQiniuTextarea();
    });
    
    
  //初始化富文本编辑器图片上传
    function initQiniuTextarea(){
    	initQiniu("${contextPath}/admin/qiniu_token", "ke_qiniu_upload", function(result) {
    		var json=strToJson(result);
    		editor.insertHtml('<img src="<%=qiniuPath %>/'+json.key+'" />');
    	});	
    }
  
  
  
</script>

</body>

<!-- END BODY -->

</html>