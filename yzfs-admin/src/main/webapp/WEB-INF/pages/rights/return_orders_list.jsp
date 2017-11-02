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

<title>商城管理 | 订单管理</title>

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

<link href="${contextPath}/static/css/wmpaging/wm-paging_v1.0.css"
	rel="stylesheet" type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />

<link rel="stylesheet" href="${contextPath}/static/css/alert.css" />

<style>
.operatorImgClass img {
	width: 30px;
	margin-left: 5%;
}

#table-tr img {
	display: block;
	margin-left: 40%;
}

#table-tr span {
	width: 10%;
	display: block;
	float: left
}

#table-tr {
	border-bottom: 1px solid #ddd;
	text-align: center;
}

#table-tr span {
	margin-left: 0
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
							<%-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>订单管理</small> --%>
						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">商城管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="${contextPath}/role/whole">售后管理</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>
				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-edit"></i>售后列表
								</div>
								<div class="caption">
									<a href="javascript:excelOut();"><img title="导出订单信息"
										src="${contextPath}/static/image/icon/import.png"
										style="width: 26px; margin-left: 103%;"></a>
								</div>
								<div class="tools">
									<a href="javascript:initOrderList();" onclick="refresh()" class="reload"></a>
								</div>
							</div>

							<div class="portlet-body">

								<form action="" name="orderForm" id="orderForm" method="post">
									<input type="hidden" id="orderId" name="orderId" value="" /> <input
										type="hidden" id="pageSize" name="pageSize" value="" />
									<div class="controls_over" style="margin-left: -26rem;">
										<img src="${contextPath}/static/image/icon/search.png"
											width="30px;" id="btn_item_search" onclick="initOrderList();"
											style="margin-top: -0.02rem; margin-left: 26.5rem;" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="goodName" name="goodName" class="m-wrap" size="16"
											type="text" style="height: 17px;" placeholder="商品名称/维权单号"
											value="" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<select id="status" name="status" style="width: 108px;"
											onchange="initOrderList();">
											<option value="">全部订单状态</option>
											<option value="1">待退款</option>
											<option value="2">退款中</option>
											<option value="3">已退款</option>
											<option value="4">待换货</option>
											<option value="5">已换货</option>
											<option value="6">已拒绝</option>
										</select>
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<select name="classId" id="secondClassId"
											onchange="initOrderList();">
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
									id="orderTablePages">
									<thead>
										<tr style="background-color: #f9f9f9;">
											<th>维权编号</th>
											<th>申请时间</th>
											<th>客户</th>
											<th>金额</th>
											<th>状态</th>
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
					<!-- 分页开始 -->
					<div class="total-dans"></div>
					<div id="wmeimob-common-paging" style="margin-bottom: 5rem">
					</div>
				</div>

				<!-- END PAGE CONTENT -->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>

	<!-- 是否退款或者拒绝 -->
	<div id="refundStatic" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p class="titleRetund"></p>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>
			<button type="button" data-dismiss="modal" class="btn green"
				id="Delete_S_sure">确定</button>
		</div>
	</div>

	<!-- 导入文件 页面开始-->
	<div id="cateTwo" style="width: 600px"
		class="modal container hide fade" tabindex="-1">
		<div class="modal-header ADD_GOODS">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">批量发货Excel导入</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<span class="pass erji_goods"></span><span style="float: left">请选择导入文件：</span>
				<div class="fileupload fileupload-new Add_Img"
					style="float: left; margin-top: -.9rem" data-provides="fileupload">
					<form id="inputOrderForm" name="inputOrderForm"
						action="${contextPath}/admin/orders/shipmentDeliver" method="post"
						ENCTYPE="multipart/form-data">
						<input id="inputOrderFile" name="inputOrderFile" type="file"
							class=""></input>
					</form>
				</div>
			</div>
		</div>
		<div class="modal-body_Num">
			<span id="fileError" style="text-align: center; color: red;"></span>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn green" id="fileUploads"
				data-dismiss="modal">确定</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="goods_cancel">取消</button>
		</div>
	</div>
	<!-- 导入文件 页面结束-->

	<!-- 导出 -->
	<div id="outType" class="modal container hide fade" tabindex="-1">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">订单导出</h3>
		</div>
		<div class="modal-body" style="padding: 0; margin-top: 2rem">
			<div class="modal-body_Num">
				<div id="div_fenlei" style="margin-left: 1.6rem">
					<input type="radio" style="float: left; margin-left: 1px;"
						value="1" checked name="restatType" id="restatType">&nbsp;&nbsp;XLS格式
					<input type="radio" style="float: left; margin-left: 1px;"
						value="2" name="restatType" id="restatType">&nbsp;&nbsp;CSV格式
				</div>
			</div>
			<span id="errorHtml3" style="color: red; margin-left: 140px;"></span>
			<div class="modal-footer">
				<button type="button" class="btn green" id="up_user_amount_button"
					onclick="excelOut()">确定</button>
				<button type="button" data-dismiss="modal" class="btn">取消</button>
			</div>
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
		src="${contextPath}/static/js/bootstrap-colorpicker.js"></script>


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
        TableEditable.init();
        initOrderList();
 		var paging = new WmPaging({el:"wmeimob-common-paging",totalCount:parseInt(10),pageSize:parseInt('${params.pageSize}'),dataLoad:function(pageIndex, pageSize){
 			$(".tbodyClassOne").html("");  
 			$.ajax({
 		    		url:"${contextPath}/admin/rights/patchList",
 		    		data:{pageIndex:pageIndex,
 		    			pageSize:pageSize,
 		    			startDate:'${params.startTime}',
 		    			stopDate:'${params.endTime}',
 		    			status:'${params.refundsStatus}',
 		    			orderNo:'${params.rightsOrderNo}',
 		    			classId:'${params.classId}',
 		    			loginName:'${params.nickName}',
 		    			goodName:'${params.goodName}'
 		    			},
 		    		type:"get",
 		    		dataType:"html",
 		    		beforeSend: function () {  
 		    			onDialog();
 		    		},
 		    		success:function(response){
 		    			$(".tbodyClassOne").html(response);
 		    		    if($(".tbodyClassOne tr").length==0){
 		    		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='6'>暂无数据显示!</td></tr>"
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
		}}); 
		paging.init();
		//初始化快递公司信息
		//initlogisCompany();
    });
    
	//分类一级加载
	$(function(){
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId=&date='+new Date(),
			dataType:'json',
			success:function(json){
				var goodClasses=json.goodClass;
				$("#secondClassId").append("<option value=''>全部二级分类</option>");
				for(var i=0;i<goodClasses.length;i++){
					if('${params.classId}'==goodClasses[i].id){
					    $("#secondClassId").append("<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>");
					}else{
						$("#secondClassId").append("<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>");	
					}
				}
			}
		})
			  
	});
	
	//退款订单信息加载
	function initOrderList(){
		 $(".tbodyClassOne").html("");
		  var orderForm = $("form[name=orderForm]");
          $.ajax({
	    		url:"${contextPath}/admin/rights/patchList",
	    		data:orderForm.serialize(),
	    		type:"get",
	    		dataType:"html",
	    		beforeSend: function () {  
	    			onDialog();
	    		},
	    		success:function(response){
	    			$(".tbodyClassOne").html(response);
	    		    if($(".tbodyClassOne tr").length==0){
	    		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='11'>暂无数据显示!</td></tr>"
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

	<script type="text/javascript">

//退款
function refund(id,sign) {
	if(sign=='TKSH' || sign=='CHSH'){
		$(".titleRetund").text("确认要审核吗?");
	}
	if(sign=='TKQR'){
		$(".titleRetund").text("确认要退款吗?");
	}
	if(sign=='TKQR'){
		$(".titleRetund").text("确认要退款吗?");
	}
	if(sign=='QRCH'){
		$(".titleRetund").text("确认要换货吗?");
	}
	if(sign=='REFUSE'){
		$(".titleRetund").text("确认要驳回吗?");
	}
	$("#Delete_S_sure").attr({"onclick":"comfirmRetund('"+id+"','"+sign+"')"});
	

}

//确认退款
function comfirmRetund(itemId,sign){
    $.ajax({
		url:"${contextPath}/admin/rights/refund",
		data:{itemId:itemId,sign:sign},
		type:"post",
		dataType:"json",
		beforeSend: function () {  
			onDialog();
		},
		success:function(json){
			if(json.code==100){
				ohSnap(json.msg,"black");
			}else{
				ohSnap(json.msg,"black");
			}
			initOrderList();
		},    		
        complete: function () {  
			offDialog();
	    },    	    
	    error: function (json) {  
	        console.info("error: " + json.responseText);  
	    } 
	});
}


//清空错误标签提示
function clearError(){
	$("#errorHtml").html("");
}

</script>

</body>

<!-- END BODY -->

</html>