<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!-- BEGIN HEAD -->
<html lang="en">
<head>
<meta charset="utf-8" />
<title>注册码管理</title>
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

<link href="${contextPath}/static/css/bootstrap-fileupload.css"
	rel="stylesheet" type="text/css" />

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

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/bootstrap-fileupload.css" />

<link rel="stylesheet"
	href="${contextPath}/static/css/wmpaging/wm-paging_v1.0.css" />
</head>
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

							<img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>注册码管理</small>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">注册码管理</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">注册码管理</a></li>

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
									<i class="icon-edit"></i>注册码管理
								</div>
								<div class="tools">
									<a href="javascript:window.location.reload();" class="reload"></a>
									<a class="icon-plus white" data-toggle="modal"
										id="sample_editable_1_goods" href="#ful-width"></a>
								</div>

							</div>

							<div class="portlet-body">

								<div class="controls_start ">
									<div class="input-append date form_datetime Check_Span">
										<input id="startDate" name="startDate" class="m-wrap" readonly
											size="16" type="text" placeholder="开始日期" value="" /> <span
											class="add-on"><i class="icon-calendar"></i></span>
									</div>
								</div>
								<div class="controls_over">
									<div class="input-append date form_datetime Check_Span">

										<input id="stopDate" name="stopDate" class="m-wrap" readonly
											size="16" type="text" placeholder="结束日期" value="" /> <span
											class="add-on"><i class="icon-calendar"></i></span>
									</div>
								</div>

								<button type="button" class="btn blue" id="export"
									style="margin-top: 0.8rem">导出excel</button>
								<button type="button" class="btn blue" id="btn_item_search"
									style="margin-top: .8rem">搜索</button>
								<span class="Check_Span"><input type="text"
									placeholder="生产批次" id="batchNum" value="${batchNum}" />
									<div id="checkuserphone" class="checkpro ckeck"></div> </span> <span>
									<select class="" onchange="changeType(this)">
										<c:if test="${type!=3 and type!=2}">
											<option value="1" selected="selected">全部</option>
											<option value="2">已绑定</option>
											<option value="3">未绑定</option>
										</c:if>
										<c:if test="${type==2}">
											<option value="1">全部</option>
											<option value="2" selected="selected">已绑定</option>
											<option value="3">未绑定</option>
										</c:if>
										<c:if test="${type==3}">
											<option value="1">全部</option>
											<option value="2">已绑定</option>
											<option value="3" selected="selected">未绑定</option>
										</c:if>
								</select>
								</span>

								<table class="table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th>注册码</th>
											<th>生产批次</th>
											<th>状态</th>
											<th>生成时间</th>
											<th>操作</th>

										</tr>

									</thead>

									<tbody>

										<c:forEach items="${codeList}" var="code" begin="0"
											varStatus="status">

											<tr class="">

												<td>${code.registerNo }</td>
												<td>${code.batchNum}</td>
												<td><c:if test="${code.isBound}">
                                           		 已绑定
                                         </c:if> <c:if test="${!code.isBound}">
                                           		未绑定
                                         </c:if></td>

												<td><fmt:formatDate value='${code.createdAt }'
														pattern="yyyy-MM-dd" />
												<td><a href="#static" data-toggle="modal"
													class="btn blue delete Delete_btn  btn_admin_delete">删除</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>

								</table>

							</div>
							<div id="wmeimob-common-paging" style="margin-bottom: 5rem">
							</div>

							<!-- END EXAMPLE TABLE PORTLET-->

						</div>

					</div>

					<!-- END PAGE CONTENT -->

				</div>

				<div id="static" class="modal hide fade" tabindex="-1"
					data-backdrop="static" data-keyboard="false">

					<div class="modal-body">

						<h4>你确定删除此注册码么?</h4>

					</div>

					<div class="modal-footer">

						<button type="button" data-dismiss="modal" class="btn"
							id="Delete_S_cancel">取消</button>

						<button type="button" data-dismiss="modal" class="btn green"
							id="Delete_S_sure">确定</button>

					</div>

				</div>

				<div id="ful-width" class="modal container hide fade" tabindex="-1">

					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>

						<h3 class="Header">新增注册码</h3>

					</div>

					<div class="modal-body">
						<div class="modal-body_Num">
							<span class="user_name"> 生成数量: <input type="number"
								name="codeNum" required="required" placeholder="数量" />
							</span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn green" id="btn_admin_save">确定</button>
						<button type="button" data-dismiss="modal"
							class="btn_admin_cancel">取消</button>
					</div>

				</div>

			</div>

			<!-- END PAGE -->

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

		<!-- END CORE PLUGINS -->

		<!-- BEGIN PAGE LEVEL PLUGINS -->

		<script type="text/javascript"
			src="${contextPath}/static/js/select2.min.js"></script>

		<script type="text/javascript"
			src="${contextPath}/static/js/jquery.dataTables.js"></script>

		<script type="text/javascript"
			src="${contextPath}/static/js/DT_bootstrap.js"></script>

		<script type="text/javascript"
			src="${contextPath}/static/js/bootstrap-datepicker.js"></script>

		<script type="text/javascript"
			src="${contextPath}/static/js/bootstrap-datetimepicker.js"></script>

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

		<script src="${contextPath}/static/js/table-advanced.js"></script>

		<script src="${contextPath}/static/js/table-editable.js"></script>

		<script src="${contextPath}/static/js/wmpaging/wm-paging_v1.0.js"
			type="text/javascript"></script>
		<script>

    jQuery(document).ready(function() {

        App.init();
        TableAdvanced.init();
        TableEditable.init();
        $(".form_datetime").datepicker({format: 'yyyy-mm-dd'});
        
        var paging = new WmPaging({el:"wmeimob-common-paging",totalCount:parseInt('${totalCount}'),pageSize:parseInt('${pageSize}'),dataLoad:function(pageIndex, pageSize){
            $.ajax({
   	    		url:"${contextPath}/admin/code/list_patch",
   	    		data:{
   	    			pageIndex:pageIndex,
   	    			pageSize:pageSize,
   	    			batchNum:'${batchNum}',
   	    			startDate:'${startDate}',
   	    			stopDate:'${stopDate}',
   	    			type:'${type}'
   	    			},
   	    		type:"get",
   	    		dataType:"html",
   	    		success:function(response){
   	    			$(".table> tbody").html(response);
   	    		}
   	    	}); 
   		}});
   		paging.init();
   		
        
        //搜索
        $("#btn_item_search").click(function(){
        	var batchNum=$("#batchNum").val();
        	var startDate=$("#startDate").val();
        	var stopDate=$("#stopDate").val();
        	window.location.href="${contextPath}/admin/code/list?batchNum="+batchNum+"&startDate="+startDate+"&stopDate="+stopDate;
        });
      
        
        /*新增*/
        $("#btn_admin_save").live('click', function(e){
           var codeNum=$("input[name='codeNum']").val();
           var reg=/^([1-9]\d*|[0]{1,1})$/; 
           if(codeNum=='' || !reg.test(codeNum)){
        	   alert("数字输入不正确，请重输");
           }else{
	            $.ajax({
	            	url:'${contextPath}/admin/code/add',
	            	data:{"codeNum" : codeNum},
	            	type:"post",
	            	success:function(result){
	            		if (result.code==0) {
	            			window.location.reload();
	    				}else{
	    					alert(result.msg);
	    				}
	            	},
	            	error:function(){
	            		alert("系统异常，请重试");
	            	}
	            });
           }
        });
        
    });
    //删除
    $(".btn_admin_delete").click(function(){
    	var that=$(this);
    	var no=$(this).parents("tr").find("td").eq(0).html();
    	$("#Delete_S_sure").click(function(){
    		 $.ajax({
	            	url:'${contextPath}/admin/code/delete',
	            	data:{"no" : no},
	            	type:"post",
	            	success:function(result){
	            		if (result.code==0) {
	            			window.location.reload();
	    				}else{
	    					alert(result.msg);
	    				}
	            	},
	            	error:function(){
	            		alert("系统异常，请重试");
	            	}
	            });
    	});
    });
    
    
    function changeType(that){
    	var type=$(that).val();
    	var batchNum=$("#batchNum").val();
    	var startDate=$("#startDate").val();
    	var stopDate=$("#stopDate").val();
    	window.location.href="${contextPath}/admin/code/list?batchNum="+batchNum+"&startDate="+startDate+"&stopDate="+stopDate+"&type="+type;
    }
</script>
</body>

<!-- END BODY -->

</html>