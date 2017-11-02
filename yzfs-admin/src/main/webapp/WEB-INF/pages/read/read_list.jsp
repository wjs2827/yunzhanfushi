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

<title>阅读有赏 | 阅读任务</title>

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

							<img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>阅读任务</small>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">阅读有赏</a> <i class="icon-angle-right"></i></li>

							<li><a href="${contextPath}/role/whole">阅读任务</a></li>

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
									<i class="icon-edit"></i>阅读任务
								</div>
								<div class="tools">
									<a data-toggle="modal" href="#editRead" class="icon-plus white"
										onclick="editReadInfo('','','')"></a> <a
										href="javascript:window.location.reload();" class="reload"></a>
								</div>
							</div>
							<div class="portlet-body">
								<form action="" id="submitForm" method="post">
									<div class="controls_start">
										<div class="input-append date form_datetime Check_Span">
											<input id="startTime" name="startTime" class="m-wrap"
												readonly size="16" value="${params.startTime}" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="开始日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
									<div class="controls_over">
										<div class="input-append date form_datetime Check_Span">
											<input id="endTime" name="endTime" class="m-wrap" readonly
												size="16" value="${params.endTime}" type="text"
												onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
												placeholder="结束日期" value="" /> <span class="add-on"><i
												class="icon-calendar"></i></span>
										</div>
									</div>
									<div class="controls_over" style="margin-left: 1rem;">
										<input id="paramTitle" name="paramTitle" class="m-wrap"
											value="${params.title}" size="16" type="text"
											placeholder="文章标题" value="" />
									</div>
									<img src="${contextPath}/static/image/icon/search.png"
										width="30px;" id="btn_item_search"
										style="margin-top: .98rem; margin-left: 1rem;" />
								</form>
								<table class="table table-striped table-hover table-bordered"
									id="sample_editable_1">
									<thead>
										<tr>
											<th>创建时间</th>
											<th>文章标题</th>
											<th>文章链接</th>
											<th>发布状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody class="tbodyClassOne">
										<c:forEach items="${readList}" var="read">
											<tr class="">
												<td><fmt:formatDate value="${read.createdAt}"
														pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td>${read.title}</td>
												<td>${read.link}</td>
												<td><a data-toggle="modal" href="#sysConfigStatic"
													onclick="openClick('${read.id}','0','open');"> <c:if
															test="${read.isUse==true}">
															<img title="已开启"
																src="${contextPath}/static/image/icon/open.png"
																style="width: 30px; margin-left: 5%;">
														</c:if>
												</a> <a data-toggle="modal" href="#sysConfigStatic"
													onclick="openClick('${read.id}','1','open');"> <c:if
															test="${read.isUse==false}">
															<img title="已关闭"
																src="${contextPath}/static/image/icon/dis_open.png"
																style="width: 30px; margin-left: 5%;"
																onclick="openClick('${read.id}','1','open');">
														</c:if>
												</a></td>
												<td><a class="" data-toggle="modal" href="#editRead"
													onclick="editReadInfo('${read.id}','${read.title}','${read.link}')">
														<img title="编辑保存"
														src="${contextPath}/static/image/icon/edit.png"
														style="width: 30px; margin-left: 5%;">
												</a> <c:if test="${read.isUse==false}">
														<a class="" data-toggle="modal" href="#sysConfigStatic"
															onclick="openClick('${read.id}','0','dele');"> <img
															title="删除"
															src="${contextPath}/static/image/icon/delete.png"
															style="width: 30px; margin-left: 5%;">
														</a>
													</c:if> <c:if test="${read.isUse==true}">
														<img title="删除"
															src="${contextPath}/static/image/icon/dis_delete.png"
															style="width: 30px; margin-left: 5%;">
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- END PAGE CONTENT -->
		<div id="ohsnap"></div>
	</div>

	<!-- END PAGE CONTAINER-->

	<div id="sysConfigStatic" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p class="titleClass"></p>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn green"
				id="confimSave">保存</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="Delete_S_cancel">取消</button>

		</div>
	</div>

	<div id="editRead" class="modal hide fade" tabindex="-1"
		data-backdrop="static" data-keyboard="false">
		<!-- 编辑页面 -->
		<div class="modal-header" style="">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header"></h3>
		</div>
		<div class="modal-body" style="padding: 0;">
			<input type="hidden" id="id" value="${pickVO.id}">
			<div class="modal-body_Num" style="margin-top: 2rem">
				<div id="div_fenlei" style="margin-left: .7rem">
					文章标题: <input type="text" id="title" value="" placeholder="请输入文章标题"
						onfocus="clearError();" />
				</div>
				<div id="div_fenlei" style="margin-left: .7rem">
					文章链接: <input type="text" id="link" value="" placeholder="请输入文章链接"
						onfocus="clearError();" />
				</div>
				<span id="errorHtml" style="color: red; margin-left: 83px;"></span>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn green" id="up_user_button">确定</button>
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
        TableEditable.init();
    });
 	
 	//确认修改参数信息
 	function openClick(id,value,sign){
 		var isUse=1;
 		var isDeleted=1;
 		if('open'==sign){
 			isUse=value;
 			if(value=='0'){
 				$(".titleClass").html("亲!确认要停用吗?");
 			}else{
 				$(".titleClass").html("亲!确认要启用吗?");
 			}
 		}else{
 			isDeleted=0;
 			$(".titleClass").html("亲!确认要删除吗?");
 		}
 		$("#confimSave").click(function(){
  	       $.ajax({
	    		url:"${contextPath}/admin/read/isUse",
	    		data:{id:id,isUse:isUse,isDeleted:isDeleted},
	    		type:"post",
	    		dataType:"json",
	    		success:function(json){
	    			ohSnap(json.msg,'black');
	    			window.location.reload();
	    			
	    		}
	    	});
 			
 		})
 		
 	}
 	
 	//编辑新增
 	function editReadInfo(id,title,link){
 		console.log(2)
 		clearError();
 		if(id ==undefined || id==''){
 		   $(".Header").html("新增文章信息");
 		   $("#title").val("");
		   $("#link").val("");
 	    }else{
 		   $(".Header").html("编辑文章信息");
 		   $("#title").val(title);
 		   $("#link").val(link);
 		} 	
 		$("#up_user_button").attr({"onclick":"editReadInfoSave('"+id+"')"});
			
 	}
 	
 	//编辑新增保存
	function editReadInfoSave(id){ 		    
		var title=$("#title").val();
		var link=$("#link").val();
	    if(title==undefined || title==''){
	    	$("#errorHtml").html("亲!文章标题不能为空!");
	    	return;
	    }
	    if(link==undefined || link==''){
	    	$("#errorHtml").html("亲!文章链接不能为空!");
	    	return;
	    }
	    $.ajax({
   		url:"${contextPath}/admin/read/edit",
   		data:{id:id,title:title,link:link},
   		type:"post",
   		dataType:"json",
   		success:function(json){
   			   $("#errorHtml").html(json.msg);
   			   if(json.code=='100'){
   			     $("#up_user_button").attr({"data-dismiss":"modal"});
   				   window.location.reload();
   			   }else{
   				   
   			   }
   		  }
		});
	}
 	
 	function clearError(){
 		$("#errorHtml").html("");
 	}
 	
 	$("#btn_item_search").click(function(){
 		$("#submitForm").submit();
 	});
 	
    if($('tbody tr').length==0){
        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='5'>暂无数据显示!</td></tr>"
        	$('tbody').append(newsTr)
     }
  
</script>

</body>

<!-- END BODY -->

</html>