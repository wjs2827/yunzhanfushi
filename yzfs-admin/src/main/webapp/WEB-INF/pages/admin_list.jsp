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
<html lang="zh_cn">

<head>

<meta charset="utf-8" />

<title>系统设置 | 用户管理</title>

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

			<jsp:include page="/WEB-INF/layouts/menu.jsp"></jsp:include>
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

							<%-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>用户管理</small> --%>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">系统设置</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">用户管理</a></li>

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
									<i class="icon-edit"></i>用户管理
								</div>

								<div class="tools">


									<a href="${contextPath}/admin/list" class="reload"></a> <a
										class="icon-plus white" id="a_admin_add" data-toggle="modal"
										href="#ful-width"></a>
								</div>
							</div>

							<div class="portlet-body">


								<table class="table table-striped table-hover table-bordered"
									id="sample_editable_1">

									<thead>

										<tr>
											<th>登录名</th>

											<th>姓名</th>

											<th>角色</th>

											<th>手机号</th>

											<th>操作</th>

										</tr>

									</thead>

									<tbody id="tb_admin_list">

										<c:forEach var="admin" items="${admins}">
											<tr class="">
												<td adminId="${admin.id }">${admin.loginName }</td>
												<td>${admin.realName }</td>
												<td roleId="${admin.roleId }">${admin.roleName }</td>
												<td>${admin.mobile }</td>
												<td><c:if test="${!admin.isFixed }">
														<a href="#ful-width" data-toggle="modal" class=""> <img
															title="编辑"
															src="${contextPath}/static/image/icon/edit.png"
															style="width: 30px; margin-left: 5%;">
														</a>
														<a href="#static" data-toggle="modal" class=""> <img
															title="删除"
															src="${contextPath}/static/image/icon/delete.png"
															style="width: 30px; margin-left: 5%;">
														</a>
													</c:if></td>
											</tr>
										</c:forEach>


									</tbody>

								</table>
								<div id="static" class="modal hide fade" tabindex="-1"
									data-backdrop="static" data-keyboard="false">

									<div class="modal-body">

										<p>你确定删除此用户么?</p>

									</div>

									<div class="modal-footer">

										<button type="button" data-dismiss="modal" class="btn"
											id="Delete_S_cancel">取消</button>

										<button type="button" data-dismiss="modal" class="btn green"
											id="Delete_S_sure_admin">确定</button>

									</div>

								</div>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT -->
				<div id="ful-width" class="modal container hide fade" tabindex="-1">

					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>

						<h3 class="Header"></h3>

					</div>

					<div class="modal-body">
						<div class="modal-body_Num">
							<span class="user_name"> 登录名: <input type="text"
								name="loginName" required="required" placeholder="登录名" /></span><br>
							<span class="user_name"> 姓&nbsp;&nbsp;&nbsp;&nbsp;名: <input
								type="text" required="required" name="realName" placeholder="姓名" /></span><br>
							<span> 角色: <select id="slt_admin_role">
									<c:forEach var="role" items="${roles}">
										<option value="${role.id }">${role.name }</option>
									</c:forEach>
							</select></span><br> <span class="user_phone">手机号: <input type="text"
								name="mobile" required="required" placeholder="手机号" />
							</span>
						</div>
					</div>
					<div id="admin_err_msg" class="red margin_left"></div>
					<div class="modal-footer">
						<button type="button" class="btn green" id="btn_admin_save">确定</button>
						<button type="button" data-dismiss="modal"
							class="btn_admin_cancel">取消</button>
					</div>

				</div>
			</div>

			<!-- END PAGE CONTAINER-->

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

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
	
			App.init();
	
			TableEditable.init();
	
			//添加按钮的点击事件
			$("#a_admin_add").click(function() {
				$("input[name=loginName]").val("");
				$("input[name=realName]").val("");
				$("input[name=mobile]").val("");
				$("#btn_admin_save").unbind("click").click(function() {
					saveAdmin("add","");
				});
			});

		});
			//点击编辑按钮
			$(".btn_admin_edit").click(function(){
				var $this=$(this);
				var tds= $this.parents("tr").find("td");
				var loginName=tds.eq(0).html();
				var adminId=tds.eq(0).attr("adminId");
				var realName=tds.eq(1).html();
				var roleId=tds.eq(2).attr("roleId");
				var mobile=tds.eq(3).html();
				$("input[name=loginName]").val(loginName);
				$("input[name=realName]").val(realName);
				$("input[name=mobile]").val(mobile);
				$("#slt_admin_role").val(roleId);
				
				$("#btn_admin_save").unbind("click").click(function() {
					saveAdmin("edit",adminId);
				});
			});

		//保存管理员
		function saveAdmin(action,id){
			var isOk=true;
			//判断是否为空
			$("input[required=required]").each(function(){
				var value=$(this).val();
				if(value==""||value==undefined||value==null){
					$("#admin_err_msg").html($(this).attr("placeholder")+"不可以为空");
					 isOk=false;
					return false;
				}
			});
			if(!isOk){
				return;
			}
	   		var loginName=$("input[name=loginName]").val();
	   		var realName=$("input[name=realName]").val();
	   		var mobile=$("input[name=mobile]").val();
	   		var roleId=$("#slt_admin_role").val();
	   		if(!Express.Mobile.test(mobile)){
	   			$("#admin_err_msg").html("手机号码格式不正确");
	   			return;
			}
	   		//保存管理员
	   		var data={ "loginName" : loginName,"realName" : realName,"roleId" : roleId,"mobile" : mobile};
	   		if(action=="edit"){
				data["id"]=id;
			}
	   		$.ajax({
				url : "${contextPath}/admin/"+action,
				data : data,
				type : 'post',
				success : function(result) {
					if (result.code == 0) {
						alert("操作成功");
						location.reload();
					} else {
						alert(result.message);
					}
				},
				error : function() {
					alert("系统异常，请重试");
				}
			});
		}
		
	    //删除按钮点击事件
        $(".btn_admin_delete").click(function(){
            var tr=$(this).parents("tr");
        	var tds=tr.find("td");
        	var adminId=tds.eq(0).attr("adminId");
      	    $("#Delete_S_sure_admin").unbind("click").click(function(){
	   		    $.ajax({
	   			  type: "post",
	   			  url:"${contextPath}/admin/delete",
	   			  data:{adminId:adminId},
	   	          dataType: "json",
	   			  success: function(result){
	   				  if(result.code==0){
	   					  tr.remove();
					  }else{
					      alert(result.message);
					  }			    
				   },
				   error:function(){
					 alert("系统异常，请重试");
	 		  	   }
	   			});
      	  });
        }); 
	</script>
</body>

<!-- END BODY -->

</html>