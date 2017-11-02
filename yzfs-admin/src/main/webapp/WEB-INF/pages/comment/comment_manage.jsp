<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<!--<![endif]-->

<!-- BEGIN HEAD -->
<html lang="en">
<head>

<meta charset="utf-8" />

<title>商城管理 | 评价管理</title>

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

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<link href="${contextPath}/static/css/wmpaging/wm-paging_v1.0.css"
	rel="stylesheet" type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<link href="${contextPath}/static/js/DatePicker/skin/WdatePicker.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${contextPath}/static/css/alert.css" />

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

							<!-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small></small> -->

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">商城管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">评价列表</a></li>

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
									<i class="icon-edit"></i>评价列表
								</div>

								<div class="tools">


									<a href="javascript:;" onclick="initCommentList()"
										class="reload"></a>

									<!--<a href="javascript:;" class="icon-plus white"  id="sample_editable_1_row"></a>-->
								</div>

							</div>

							<div class="portlet-body ">
								<form action="" id="commentForm" name="commentForm"
									method="post">
									<div class="controls_over" style="margin-left: -26rem;">
										<img src="${contextPath}/static/image/icon/search.png"
											width="30px;" id="btn_item_search"
											onclick="initCommentList();"
											style="margin-top: -0.02rem; margin-left: 26.5rem;" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="goodName" name="goodName" class="m-wrap" size="16"
											type="text" style="height: 17px;" placeholder="商品名称/订单号"
											value="" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="nickName" name="nickName" class="m-wrap" size="16"
											type="text" style="height: 17px;" placeholder="会员" value="" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<select id="grade" name="grade" style="width: 108px;"
											onchange="initCommentList();">
											<option value="0">全部星级</option>
											<option value="1">一星</option>
											<option value="2">二星</option>
											<option value="3">三星</option>
											<option value="4">四星</option>
											<option value="5">五星</option>
										</select>
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

											<th>商品名称</th>

											<th>会员</th>

											<th>评价内容</th>

											<th>评价等级</th>

											<th>评价时间</th>

											<th>订单编号</th>

											<th>状态</th>

											<th>操作</th>

										</tr>

									</thead>

									<tbody class="commentClass">


									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT -->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>
	<!--微信端显示和隐藏评论-->
	<div id="confirmDown" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<h3 id="confirmTitle"></h3>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>
			<button type="button" data-dismiss="modal" class="btn green"
				id="confirmUsed"></button>
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
		src="${contextPath}/static/js/clockface.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/date.js"></script>

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
	<script src="${contextPath}/static/js/ui-jqueryui.js"></script>
	<script src="${contextPath}/static/js/form-components.js"></script>
	<script src="${contextPath}/static/js/wmpaging/wm-paging_v1.0.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${contextPath}/static/js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        initCommentList();
    });

   //商品列表信息加载
   function initCommentList(){
	   var commentForm=$("form[name=commentForm]")
          $.ajax({
       		url:"${contextPath}/admin/comment/patchList",
       		type:"get",
       		data:commentForm.serialize(),
       		dataType:"html",
       		beforeSend: function () {  
       			onDialog();
       		},
       		success:function(response){
       			$(".commentClass").html(response);
       		    if($(".commentClass tr").length==0){
       		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='8'>暂无数据显示!</td></tr>"
       		        	$(".commentClass").append(newsTr)
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
   
   
   //确认是否微信端显示和隐藏评论
   function  confirmUpOrDown(id,status){
		 $.ajax({
			 url:"${contextPath}/admin/comment/delete",
			 data:{id:id,status:status},
			 type:"POST",
			 dataType:"json",
			 success:function(json){
				 if(json.code==100){
					 ohSnap(json.msg,'black');
					 initCommentList();
				 }else{
					 ohSnap(json.msg,'black');
					 initCommentList();
				 }
			 },
			 error:function(data){
				 ohSnap("系统异常",'black');
			 }
		 });
   }
    
</script>

</body>

<!-- END BODY -->

</html>