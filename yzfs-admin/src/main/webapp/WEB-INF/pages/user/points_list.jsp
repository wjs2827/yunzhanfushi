<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>会员管理 | T金记录</title>

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

							<%--    <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>T金记录</small> --%>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">会员管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="${contextPath}/role/whole">T金记录</a></li>

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
									<i class="icon-edit"></i>T金记录
								</div>
								<div class="tools">
									<a href="javascript:window.location.reload();" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body">
								<form action="" id="submitForm" name="submitForm" method="post">
									<div class="controls_over" style="margin-left: -26rem;">
										<img src="${contextPath}/static/image/icon/search.png"
											width="30px;" id="btn_item_search" onclick="initList();"
											style="margin-top: -0.02rem; margin-left: 26.5rem;" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="nickName" name="nickName" class="m-wrap" size="16"
											type="text" style="height: 17px;" placeholder="用户名/手机号码"
											value="" />
									</div>
									<div class="controls_start">
										<div class="input-append date form_datetime Check_Span">
											<input id="endTime" name="endTime" class="m-wrap" readonly
												size="16" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="结束日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
									<div class="controls_over">
										<div class="input-append date form_datetime Check_Span">
											<input id="startTime" name="startTime" class="m-wrap"
												readonly size="16" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="开始日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
								</form>
								<table class="table table-striped table-hover table-bordered"
									id="sample_editable_1">
									<thead>
										<tr>
											<th>用户名</th>
											<th>手机号</th>
											<th>T金变更</th>
											<th>原因</th>
											<th>变更时间</th>
										</tr>
									</thead>
									<tbody class="tbodyClassOne">

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- END PAGE CONTENT -->

	</div>
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>
	<!-- END PAGE CONTAINER-->

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

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>
	<!-- 新时间插件 -->
	<script type="text/javascript"
		src="${basePath}/static/js/DatePicker/WdatePicker.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        initList();
        TableEditable.init();
    });
    
    //列表信息加载
    function initList(){
 	   var submitForm=$("form[name=submitForm]")
           $.ajax({
        		url:"${contextPath}/admin/user/batchPointsList",
        		type:"get",
        		data:submitForm.serialize(),
        		dataType:"html",
        		beforeSend: function () {  
        			onDialog();
        		},
        		success:function(response){
        			$(".tbodyClassOne").html(response);
        		    if($(".tbodyClassOne tr").length==0){
        		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='5'>暂无数据显示!</td></tr>"
        		        	$(".tbodyClassOne").append(newsTr)
        		    }else
        		      TableEditable.init();
        		},    		
                complete: function () {  
        			offDialog();
        	    },    	    
        	    error: function (response) {  
        	        console.info("error: " + data.responseText);  
        	    } 
        	});
     }
 	
  
</script>

</body>

<!-- END BODY -->

</html>