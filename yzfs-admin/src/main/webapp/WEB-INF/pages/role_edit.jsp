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

<title>系统设置 | 角色管理</title>

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


<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->


<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/jquery.gritter.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/chosen.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/multi-select-metro.css" />

<link href="${contextPath}/static/css/dtree.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/jstree/themes/default/style.min.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/csslect2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<link href="${contextPath}/static/css/dtree.css" rel="stylesheet"
	type="text/css" />

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />

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

			<!-- BEGIN SIDEBAR MENU -->


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

							<!--  <div class="color-mode-icons icon-color"></div> -->

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
						<h3 class="page-title">
							角色编辑<small></small>
						</h3>
						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="index.html">首页</a> <span
								class="icon-angle-right"></span></li>

							<li><a href="#">系统设置</a> <span class="icon-angle-right"></span>

							</li>

							<li><a href="${contextPath}/role/whole">角色管理</a> <span
								class="icon-angle-right"></span></li>

							<li><a href="#">角色编辑</a></li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">
					<div></div>
					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>角色编辑
								</div>
							</div>
							<div class="portlet-body form">

								<!-- BEGIN FORM-->
								<form action="" class="form-horizontal">
									<input type="hidden" name="id" value="${role.id }">
									<div class="control-group" style="margin-top: 1rem">
										<label class="control-label">角色:</label> <input type="text"
											class="m-wrap span2" name="name" style="margin-left: 1.3rem"
											value="${role.name}">
										<div style="width: 37rem; margin-left: 11.5rem;"
											id="role_verify"></div>
									</div>
									<div class="control-group">
										<label class="control-label">描述:</label>
										<textarea id="description" class="m-wrap"
											style="margin-left: 1.3rem; width: 414px;" rows="4" cols="80">${role.description}</textarea>
									</div>
									<div class="control-group"
										style="width: 37rem; margin-top: 1rem;">
										<label class="control-label">分配权限:</label>
										<div id="role_rights" class="tree-demo"
											style="margin-left: 9rem;"></div>
									</div>
									<div class="form-actions">
										<button type="button" class="btn  cancel"
											style="outline: none">取消</button>
										<button type="button" id="btn_role_edit" class="btn blue">保存</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- END PAGE CONTAINER-->

			</div>

			<!-- END PAGE -->
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

	<script src="${contextPath}/static/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!--[if lt IE 9]>

<script src="${contextPath}/static/js/excanvas.min.js"></script>

<script src="${contextPath}/static/js/respond.min.js"></script>

<![endif]-->

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

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

	<script type="text/javascript"
		src="${contextPath}/static/js/jstree/jstree.min.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/js/ui-tree.js"></script>

	<script src="${contextPath}/static/js/bootstrap-modal.js"
		type="text/javascript"></script>

	<script src="${contextPath}/static/js/bootstrap-modalmanager.js"
		type="text/javascript"></script>
	<script src="${contextPath}/static/js/dtree.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="${contextPath}/static/js/select2.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/jquery.dataTables.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>
	<script src="${contextPath}/static/js/ui-jqueryui.js"></script>

	<script src="${contextPath}/static/js/form-components.js"></script>


	<!-- END PAGE LEVEL SCRIPTS -->
	<script>

    jQuery(document).ready(function() {

        // initiate layout and plugins

        App.init();

        FormComponents.init();

        //初始化权限树
        var roleId=$("input[name=id]").val();
        UITree.init(roleId);

        //保存按钮点击事件
        $("#btn_role_edit").click(function(){
        	var nodeSelected = $("a.jstree-clicked", $("#role_rights"));
        	var name=$("input[name=name]").val();
 	        var description=$("#description").val();
        	var menuValue="";
        	nodeSelected.each(function(){
        		var $this = $(this);
        		menuValue += (menuValue == "" ?  $this.parent().attr("id") : ("#"+$this.parent().attr("id"))); 
        	});
        	if(roleId==""||roleId==null||roleId==undefined){
     		   alert("角色不存在");
     		   return;
    	   }
        	if(name==""||name==null||name==undefined){
       		   alert("请填写角色名称");
       		   return;
       	   }
       	   if(menuValue==""||menuValue==null||menuValue==undefined){
       		   alert("请分配权限");
       		   return;
       	   }
		   $.ajax({
			   type: "POST",
			   url: "${contextPath}/admin/role/edit",
			   data: {"roleId":roleId,"name":name,"description":description,"menuValue":menuValue},
			   dataType: "json",
			   success: function(result){
				   if(result.code==0){
				    	alert("修改成功");
				    	window.location.href="${contextPath}/admin/role/list";
				    }else{
						alert(result.message);
				    }	    
				},
			   error:function(){
					alert("系统异常，请重试");
			   }
			}); 
        });
        
        $(".cancel").click(function(){
        	window.history.go(-1);
        });
  });

 
</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>