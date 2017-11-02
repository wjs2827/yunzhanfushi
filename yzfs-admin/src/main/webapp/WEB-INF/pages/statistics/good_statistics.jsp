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
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>账单管理 | 购物统计</title>

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
<!-- END GLOBAL MANDATORY STYLES -->
<link href="${contextPath}/static/css/datetimepicker.css"
	rel="stylesheet" type="text/css" />
<link href="${contextPath}/static/css/datepicker.css" rel="stylesheet"
	type="text/css" />
<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<link href="${contextPath}/static/css/alert.css" rel="stylesheet" />
<style>
@media ( min-width : 1200px) {
	.container, .navbar-static-top .container, .navbar-fixed-top .container,
		.navbar-fixed-bottom .container {
		width: 30rem !important
	}
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
			<%@include file="/WEB-INF/layouts/menu.jsp"%>
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

							<div class="color-mode-icons icon-color"></div>

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

							<li><a href="#">账单管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">商品统计</a></li>

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
									<i class="icon-edit"></i>商品销售统计
								</div>

								<div class="caption">
									<a href="javascript:excelOut();"><img title="导出订单信息"
										src="${contextPath}/static/image/icon/import.png"
										style="width: 26px; margin-left: 103%;"></a>
								</div>
								<div class="tools">
									<a href="javascript:initGoodStatisList();" class="reload"></a>
									<!--<a href="javascript:;" class="icon-plus white"  id="sample_editable_1_row"></a>-->
								</div>

							</div>

							<div class="portlet-body">
								<form action="" id="goodStatisForm" name="goodStatisForm"
									method="post">
									<input type="hidden" id="sort" name="sort" /> <input
										type="hidden" id="sortType" name="sortType" />
									<div class="controls_over" style="margin-left: -26rem;">
										<img src="${contextPath}/static/image/icon/search.png"
											width="30px;" id="btn_item_search"
											onclick="initGoodStatisList();"
											style="margin-top: -0.02rem; margin-left: 26.5rem;" />
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="goodName" name="goodName" class="m-wrap" size="16"
											type="text" style="height: 17px;" placeholder="商品名称" value="" />
									</div>
									<!-- 		                    <div class="controls_over" style="margin-left:1rem;">
                                	<select class="span3 m-wrap" name="secondClassId" id="secondClassId">
									</select>
                            </div>
		                    <div class="controls_over" style="margin-left:1rem;">
	                             	<select class="span3 m-wrap" name="firstClassId" id="firstClassId" onchange="initSecondClass('','');">
									</select> 
                            </div> -->

									<div class="controls_start">
										<div class="input-append">
											<input id="endTime" name="endTime" class="m-wrap" readonly
												size="16" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="结束日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
									<div class="controls_over">
										<div class="input-append">
											<input id="startTime" name="startTime" class="m-wrap"
												readonly size="16" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="开始日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
								</form>
								<div class="odiv"></div>
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

	<!-- 导出 -->
	<div id="outType" class="modal container hide fade" tabindex="-1">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">购物统计导出</h3>
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
	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>
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

	<!-- END CORE PLUGINS -->
	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/bootstrap-datetimepicker.js"></script>

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
	<script type="text/javascript"
		src="${contextPath}/static/js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script>

    jQuery(document).ready(function() {
        App.init();
        initGoodStatisList();
        //initFirstClass('${params.firstClassId}','${params.secondClassId}');
    });
    
	//初始化一级分类
	function initFirstClass(fid,sid){
		document.getElementById("firstClassId").innerHTML = "";
			$.ajax({
				url:'${contextPath}/admin/classes/selectFirstClass',
				type:'post',
				success:function(result){
					var goodClasses=result.goodClass;
					var html="<option value=''>全部商品一级分类</option>";
					for (var i = 0; i < goodClasses.length; i++) {	
						if(fid==goodClasses[i].id){
						   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
						}else{
						   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
						}
					}
					$("#firstClassId").append(html);
					if(fid !=undefinded && fid !=''){
						initSecondClass(fid,sid);
					}else{
						initGoodStatisList();	
					}
				}
			});		
	}
	
	//加载二级分类
	function initSecondClass(fid,sid){
		document.getElementById("secondClassId").innerHTML = "";
		if(fid ==undefined || fid ==''){
		  fid=$("#firstClassId").val();
		}
			$.ajax({
				url:'${contextPath}/admin/classes/queryErji?parentId='+fid,
				type:'post',
				success:function(result){
					var goodClasses=result.goodClass;
					var html="<option value=''>全部商品二级分类</option>";
					for (var i = 0; i < goodClasses.length; i++) {	
						if(sid==goodClasses[i].id){
							   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
						}else{
							   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
						}
					}
					$("#secondClassId").append(html);
					if(sid !=undefinded && sid !=''){
						initGoodStatisList
					}
				}
			});	
	}

    
	//商品统计信息加载
	function initGoodStatisList(){
		var goodStatisForm=$("form[name=goodStatisForm]");
	       $.ajax({
	    		url:contextPath+"/admin/statis/batchGoodStatisList",
	    		type:"get",
	    		data:goodStatisForm.serialize(),
	    		dataType:"html",
	    		beforeSend: function () {  
	    			onDialog();
	    		},
	    		success:function(response){
	    			$(".odiv").html(response);
	    			TableEditable.init();
	    			var newsTr="<tr><td class='red-text' style='text-align:center' colspan='9'>暂无数据显示!</td></tr>";
	    		    if($(".tbodyClassOne tr").length==0){
	    		    	$(".tbodyClassOne").html("");
	    		        $(".tbodyClassOne").append(newsTr)
	    		    }
	    		    if($(".tbodyClassOne tr").length==1){
	    		    	if($(".dataTables_empty").text()=='数据疯狂加载中...'){
	    		    		$(".tbodyClassOne").html("");
	    		    		$(".tbodyClassOne").append(newsTr);
	    		    	}
	    		    }
	    		},    		
	            complete: function () {  
	    			offDialog();
	    	    },    	    
	    	    error: function (response) {  
	    	        console.info("error: " + data.responseText);  
	    	    } 
	    	});
	 }
    
    //排序触发事件
    function sort(sort,sortType){
    	$("#sort").val(sort);
    	$("#sortType").val(sortType);
        $.ajax({
    		url:"${contextPath}/statis/asynchronous/goodsList",
    		data:$("#goodStatisForm").serialize(),
    		type:"get",
    		dataType:"html",
    		success:function(response){
    			$(".odiv").html("");
    			$(".odiv").html(response);
    			 TableEditable.init();
    			$("#sample_editable_1 tr th").css("textAlign","center");
    			$("#sample_editable_1 tr td").css("textAlign","center");
    		}
    	});
    }
    
    //订单统计导出
    function excelOut(){
    	var temp = document.getElementsByName("restatType");
	  	for(var i=0;i<temp.length;i++)
	  	{
	  	  if(temp[i].checked)
	  	   type= temp[i].value;
	  	}
    	var value;
    	if(type==1){
    	  value="${contextPath}/statis/excelReturnOrderStatisOut";
    	}
    	if(type==2){
    		value="${contextPath}/statis/csvOrderStatisOut";
    	}
        $("#goodStatisForm").attr({"action":value});
       	$("#goodStatisForm").submit();
    }
    
    
</script>

</body>

<!-- END BODY -->

</html>