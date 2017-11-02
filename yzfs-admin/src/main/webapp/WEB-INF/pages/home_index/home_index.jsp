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

<title>基础信息 | 首页设置</title>

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

<style>
.table-striped tbody>tr:nth-child(odd)>td, .table-striped tbody>tr:nth-child(odd)>th
	{
	background: #fff;
}

.portlet-body.blue, .portlet.blue {
	background: none !important;
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

							<%-- <img src="${contextPath}/static/image/elogo.png" class="LOGO"><small>首页设置</small> --%>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">基础信息</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">首页设置</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->


				<div class="row-fluid ">


					<div class="span12">

						<!-- BEGIN TAB PORTLET-->

						<div class="portlet box blue tabbable">

							<div class="portlet-title">
								<input type="hidden" id="qiniupath" value="<%=qiniuPath %>" />
								<div class="caption">
									<i class="icon-reorder"></i>商城首页 <span
										style="margin-left: 4rem">图片建议分辨率375*258</span>
								</div>

								<div class="tools">
									<a class="icon-plus white" title="新增" id="add_silder_lunbo"
										data-toggle="modal" href="#ful-width" onclick="addFirstPic();">
									</a> <a href="javascript:refresh();" class="reload"></a>
								</div>

							</div>

							<div class="portlet-body">

								<table
									class="table table-striped table-bordered table-hover table-full-width"
									id="slider_index">

									<thead>

										<tr>
											<th>排序</th>
											<th>图片</th>
											<th>类型</th>
											<th>${silderPic.getTargetType()==0 ? "商品" : silderPic.getTargetType()==1 ? "店铺" :"链接"}
											</th>
											<th>操作</th>
										</tr>
									</thead>

									<tbody class="tbodyClassOne">

										<c:forEach var="silderPic" items="${silderPics }">
											<c:if test="${!silderPic.getPicType() }">
												<tr>
													<td>${silderPic.rank}</td>
													<td><img src="<%=qiniuPath %>${silderPic.getPicKey()}"
														style="width: 50px" /></td>
													<td>${silderPic.getTargetType()==0 ? "商品" : silderPic.getTargetType()==1 ? "店铺" :"链接"}</td>
													<td>${silderPic.getTargetType()==2 ? silderPic.getLinkUrl(): silderPic.getTargetName() }</td>
													<td><a name="${ silderPic}" class=""
														data-toggle="modal" href="#ful-width"
														onclick="edithome('${silderPic.id}','${silderPic.picKey }',
															'${silderPic.targetType }','${silderPic.targetId }','${silderPic.linkUrl}','${silderPic.rank}')">
															<img title="编辑"
															src="${contextPath}/static/image/icon/edit.png"
															style="width: 30px; margin-left: 5%;">
													</a> <a class="" data-toggle="modal" href="#static1"
														onclick="del('${silderPic.getId()}')"> <img title="删除"
															src="${contextPath}/static/image/icon/delete.png"
															style="width: 30px; margin-left: 5%;">
													</a></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>

								</table>
							</div>
						</div>
						<!-- 商品分类展示 -->

						<div class="portlet box blue tabbable">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i> 分类展示 <span
										style="margin-left: 4rem"></span>
								</div>
								<div class="tools">
									<a class="icon-plus white" title="新增" id="add_silder_fenlei"
										data-toggle="modal" href="#home_cate" onclick="addHomeCate()"></a>
									<a href="javascript:loadHomeCategoryInfo();" class="reload"></a>
								</div>

							</div>
							<div class="portlet-body">
								<div id="div_fenlei" class='div_fenlei'>
									<div class='addcontentall'>
										<div class="homeCateContentClass"></div>
									</div>
								</div>

							</div>
						</div>

					</div>
				</div>


				<!-- END TAB PORTLET-->

			</div>

			<!-- END PAGE CONTENT-->

		</div>

		<!-- END PAGE CONTAINER-->

	</div>

	<!-- END PAGE -->
	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<!-- 商城首页编辑开始 -->
	<input type="hidden" id="hidden_img_key" value="">
	<input type="hidden" id="firstId" value="">
	<input type="hidden" id="picType" value="">
	<div id="ful-width" class="modal container hide fade" tabindex="-1"
		style="width: 30rem">
		<div id="ohsnap"></div>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">商城首页编辑</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<div id="div_target">
					<span class="Margin-left">链接类型：</span> <select id="target_type"
						onchange="verify()">
						<option value="0">商品</option>
						<option value="2">链接</option>
					</select>
				</div>
				<div id="first_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">一级分类：</span>
					<select id="firstClassId">
					</select>
				</div>
				<div id="second_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">二级分类：</span>
					<select id="secondClassId">
					</select>
				</div>
				<div id="div_good">
					<span class="Margin-left" style="margin-left: -1.8rem">分类商品：
					</span> <select id="select_good">
					</select>
				</div>
				<div id="div_link">
					<span class="Margin-left">链接地址：</span><input type="url"
						id="input_url" onfocus="clearError();" />
				</div>
				<div id="">
					<span class="Margin-left" style="margin-left: 4px">排序：</span><input
						type="Number" style="width: 175px" id="rank">
				</div>
				<div class="modal-body_Num">
					<span style="float: center">图标</span> <span class="pass erji_goods">
						<div class="fileupload fileupload-new Add_Img"
							style="float: center; margin-top: -.9rem"
							data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 64px; height: 64px;">
								<span class="btn btn-file"> <span class="fileupload-new">
										<img id="img_keys" src="${contextPath}/static/image/add.png"
										style="width: 64px; height: 50px;" class="fileupload-new" />
								</span>
								</span>
							</div>
						</div>

					</span><br>
				</div>
				<input type="hidden" id="hidden_img_key" value=""> <input
					type="hidden" id="firstId" value=""> <input type="hidden"
					id="picType" value=""> <br>
			</div>
		</div>
		<span id="errorHtml" style="color: red; margin-left: 188px;"></span>
		<div class="modal-footer">
			<button type="button" class="btn green" id="User_Usure">确定</button>
			<button type="button" data-dismiss="modal" class="btn">取消</button>
		</div>
	</div>
	<!-- 商城首页编辑结束 -->

	<!-- 商城分类编辑开始 -->
	<div id="ful-class" class="modal container hide fade" tabindex="-1"
		style="width: 30rem">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">商城分类编辑</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<div id="first_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">一级分类：</span>
					<select id="firstClassIdOne">
					</select>
				</div>
				<div id="second_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">二级分类：</span>
					<select id="secondClassIdTwo" onchange="clearError();">
					</select>
				</div>
				<div id="">
					<span class="Margin-left" style="margin-left: 4px;">排序：</span><input
						type="Number" id="classRank" style="width: 175px">
				</div>
				<div class="modal-body_Num">
					<span style="float: center">分类图标</span> <span
						class="pass erji_goods">
						<div class="fileupload fileupload-new Add_Img"
							style="float: center; margin-top: -.9rem"
							data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 64px; height: 64px;">
								<span class="btn btn-file"> <span class="fileupload-new">
										<img id="img_key_one"
										src="${contextPath}/static/image/add.png"
										style="width: 64px; height: 50px;" class="fileupload-new" />
								</span>
								</span>
							</div>
						</div>
					</span><br>
				</div>
			</div>
			<span id="errorHtml1" style="color: red; margin-left: 188px;"></span>
			<div class="modal-footer">
				<button type="button" class="btn green" id="class_add">确定</button>
				<button type="button" data-dismiss="modal" class="btn">取消</button>
			</div>
		</div>
	</div>
	<!-- 商城分类编辑结束 -->

	<!-- 商城删除弹框结束 -->
	<div id="static1" style="width: 25rem" class="modal hide fade"
		tabindex="-1" data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p>你确定删除吗?</p>
		</div>
		<div class="modal-footer">

			<button type="button" data-dismiss="modal" class="btn green"
				id="Delete_S_sure">确定</button>
			<button type="button" data-dismiss="modal" class="btn">取消</button>
		</div>
	</div>
	<!-- 商城删除弹框结束 -->



	<!-- 商城分类展示编辑开始 -->
	<div id="home_cate" class="modal container hide fade" tabindex="-1"
		style="width: 30rem">
		<div id="ohsnap"></div>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">分类设置</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<div id="first_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">一级分类：</span>
					<select id="homeCateClassOne"
						onchange="initHomeClassTwo(this.value,'')">
					</select>
				</div>
				<div id="second_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">二级分类：</span>
					<select id="homeCateClassTwo" onchange="clearError();">
					</select>
				</div>
				<div id="">
					<span class="Margin-left" style="margin-left: 4px;">排序：</span><input
						type="Number" id="homeCateRank" style="width: 175px">
				</div>
			</div>
			<span id="homeCateErrorHtml" style="color: red; margin-left: 188px;"></span>
			<div class="modal-footer">
				<button type="button" class="btn green" data-dismiss=""
					id="homeCategorySet">确定</button>
				<button type="button" data-dismiss="modal" class="btn">取消</button>
			</div>
		</div>
	</div>
	<!-- 商城分类展示编辑结束 -->

	<!-- 商城分类下商品设置编辑开始 -->
	<div id="homeCateProduct" class="modal container hide fade"
		tabindex="-1" style="width: 30rem">
		<div id="ohsnap"></div>
		<input type="hidden" id="homeCateId">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header">分类商品设置</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<div id="first_fenlei">
					<span class="Margin-left" style="margin-left: -1.8rem">分类名称：</span>
					<span id="homeCateP"></span>
				</div>
				<div id="div_good">
					<span class="Margin-left" style="margin-left: -1.8rem">分类商品：
					</span> <select id="cate_select_good">
					</select>
				</div>
				<div id="">
					<span class="Margin-left" style="margin-left: 4px">排序：</span><input
						type="Number" style="width: 175px" id="homeCateRankP">
				</div>
				<div class="modal-body_Num">
					<span style="float: center">商品LOGO</span> <span
						class="pass erji_goods">
						<div class="fileupload fileupload-new Add_Img"
							style="float: center; margin-top: -.9rem"
							data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 64px; height: 64px;">
								<span class="btn btn-file"> <span class="fileupload-new">
										<img id="home_img_key_one"
										src="${contextPath}/static/image/add.png"
										style="width: 64px; height: 50px;" class="fileupload-new" />
								</span>
								</span>
							</div>
						</div>
					</span><br>
				</div>
			</div>
		</div>
		<span id="homeCatePErrorHtml" style="color: red; margin-left: 188px;"></span>
		<div class="modal-footer">
			<button type="button" data-dismiss="" class="btn green"
				id="homeCategoryProductSet">确定</button>
			<button type="button" data-dismiss="modal" class="btn">取消</button>
		</div>
	</div>

	<!-- 商城分类下商品设置编辑结束 -->

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
	<!-- 七牛upload js -->
	<script type="text/javascript"
		src="${contextPath }/static/js/plupload.full.min.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu.min.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu-init.js"></script>

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
		src="${contextPath}/static/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-advanced.js"></script>
	<script src="${contextPath}/static/js/table-editable.js"></script>
	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/js/home_index/homeindex.js"></script>

</body>

<!-- END BODY -->

</html>