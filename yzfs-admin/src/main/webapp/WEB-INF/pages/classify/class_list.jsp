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

<html lang="en">
<head>

<meta charset="utf-8" />

<title>基础信息 | 分类管理</title>

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

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/css/select2_metro.css" />

<link rel="stylesheet" href="${contextPath}/static/css/DT_bootstrap.css" />

<link href="${contextPath}/static/css/wmpaging/wm-paging_v1.0.css"
	rel="stylesheet" type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<link href="${contextPath}/static/css/alert.css" rel="stylesheet" />


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

							<li><i class="icon-home"></i> <a href="#">首页</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="#">基础信息</a> <i class="icon-angle-right"></i></li>

							<li><a href="#">分类管理</a></li>

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
									<i class="icon-edit"></i>分类管理
								</div>

								<div class="tools">
									<a class="icon-plus white" data-toggle="modal" title="新增一级分类"
										href="#cateOne" id="sample_editable_1_goods"
										onclick="editCateOne('','','')"></a> <a href="javascript:;"
										onclick="refresh()" title="刷新" class="reload"></a>
								</div>

							</div>

							<div class="portlet-body">
								<input type="hidden" id="qiniupath" />
								<table class="table table-striped table-hover table-bordered"
									id="sample_editable_1">

									<thead>

										<tr>
											<th style="display: none">分类编号</th>
											<th>分类管理</th>
											<th>LOGO</th>
											<th>操作</th>
										</tr>

									</thead>

									<tbody>
										<c:forEach items="${classVo}" var="c" begin="0"
											varStatus="status">
											<tr class="parentClass" role="row" id="${c.id}">
												<td style="display: none">${c.id}</td>
												<td><i class="icon-plus black black-icon"
													onclick="detailSubClassic('${c.id}')"></i><span>${c.name}</span></td>
												<td><img src='<%=qiniuPath %>${c.picKey}'
													style="width: 30px; margin-left: 5%;"></td>
												<td><a class="" data-toggle="modal" href="#cateOne"
													onclick="editCateOne('${c.id}','${c.name}','${c.picKey}')">
														<img title="编辑"
														src="${contextPath}/static/image/icon/edit.png"
														style="width: 30px; margin-left: 5%;">
												</a> <a class="" data-toggle="modal" href="#static"
													onclick="delCateOne('${c.id}','${c.parentId}')"> <img
														title="删除"
														src="${contextPath}/static/image/icon/delete.png"
														style="width: 30px; margin-left: 5%;">
												</a> <a class="" data-toggle="modal" href="#cateTwo"
													onclick="editCateTwo('','${c.id}','','')"> <img
														title="添加子分类"
														src="${contextPath}/static/image/icon/add.png"
														style="width: 30px; margin-left: 5%;">
												</a></td>
											</tr>
											<tr class="fenlei-tr details empty">
												<td class="empty"></td>

												<td class="empty"></td>
												<td colspan="5" class="span-td"></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
							<div id="wmeimob-common-paging">
								<select class="all-paging" id="totalCounts"
									onchange="pageingShow();">
									<option <c:if test="${pageSize==30}">selected</c:if> value="30">30</option>
									<option <c:if test="${pageSize==25}">selected</c:if> value="25">25</option>
									<option <c:if test="${pageSize==20}">selected</c:if> value="20">20</option>
									<option <c:if test="${pageSize==15}">selected</c:if> value="15">15</option>
									<option <c:if test="${pageSize==10}">selected</c:if> value="10">10</option>
									<option <c:if test="${pageSize==5}">selected</c:if> value="5">5</option>
								</select>
							</div>

						</div>

						<div id="static" class="modal hide fade" tabindex="-1"
							data-backdrop="static" data-keyboard="false">

							<div class="modal-body">

								<p>你确定删除此分类管理么?</p>

							</div>

							<div class="modal-footer">
								<button type="button" data-dismiss="modal" class="btn green"
									id="Delete_S_sure">确定</button>
								<button type="button" data-dismiss="modal" class="btn"
									id="Delete_S_cancel">取消</button>

							</div>

						</div>
					</div>

				</div>

				<!-- END EXAMPLE TABLE PORTLET-->

			</div>

		</div>

		<!-- END PAGE CONTENT -->
	</div>
	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>
	<!-- 编辑一级分类 -->
	<div id="cateOne" class="modal container hide fade" tabindex="-1"
		style="width: 500px">
		<div class="modal-header ADD_GOODS">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header" id="firstClassH3">编辑一级分类</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<span class="pass erji_goods">一级分类 : <input type="text"
					placeholder="请输入汉字、字母、数字组成" id="firstName" onfocus="clearError();" /></span><br>
			</div>
			<div class="fileupload fileupload-new Add_Img"
				style="margin-left: 10rem; margin-top: -.9rem"
				data-provides="fileupload">
				<div class="fileupload-new thumbnail"
					style="width: 64px; height: 64px;">
					<span class="btn btn-file"> <span class="fileupload-new">
							<img id="firstfilePic" src="${contextPath}/static/image/add.png"
							onclick="clearError();" alt="" style="width: 64px; height: 50px;"
							class="fileupload-new" />
					</span>
					</span>
				</div>
			</div>
		</div>

		<span id="errorHtml" style="color: red; margin-left: 188px;"></span>
		<div class="modal-footer">
			<input type="hidden" id="goodsId" value="" />
			<button type="button" class="btn green" id="goodsClass_sure">确定</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="goods_cancel">取消</button>
		</div>
	</div>

	<!-- 编辑二级分类 -->
	<div id="cateTwo" class="modal container hide fade" tabindex="-1"
		style="width: 500px">
		<div id="ohsnap"></div>
		<div class="modal-header ADD_GOODS">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true"></button>
			<h3 class="Header" id="secondClassH3">编辑二级分类</h3>
		</div>
		<div class="modal-body">
			<div class="modal-body_Num">
				<span class="pass erji_goods">二级分类 ：<input type="text"
					placeholder="请输入汉字、字母、数字组成" id="secondName" onfocus="clearError();" /></span><br>
			</div>
			<div class="modal-body_Num">
				<span class="pass erji_goods"> <span style="float: left">分类图标(90*90)
						：</span>
					<div class="fileupload fileupload-new Add_Img"
						style="float: left; margin-top: -.9rem" data-provides="fileupload">
						<div class="fileupload-new thumbnail"
							style="width: 64px; height: 64px;">
							<span class="btn btn-file"> <span class="fileupload-new">
									<img id="filePic" src="${contextPath}/static/image/add.png"
									onclick="clearError();" alt=""
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
			<button type="button" class="btn green" id="goodsClass_sure1">确定</button>
			<button type="button" data-dismiss="modal" class="btn"
				id="goods_cancel">取消</button>
		</div>
	</div>


	<!-- END PAGE CONTAINER-->

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
	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<script type="text/javascript">
	$("#qiniupath").val('<%=qiniuPath %>');
	</script>
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
		src="${contextPath}/static/js/jquery.dataTables.js"></script>

	<script type="text/javascript"
		src="${contextPath}/static/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/table-editable.js"></script>

	<script src="${contextPath}/static/js/wmpaging/wm-paging_v1.0.js"
		type="text/javascript"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>

	<script>
		var pic = "";
		var firstPic="";
		jQuery(document).ready(function() {
			detailSubClassic();
		    App.init();
		    //TableEditable.init();
		    
		    initQiniu("${contextPath}/admin/qiniu_token", "firstfilePic", function(result){
				var json=strToJson(result);
				firstPic=json.key;
	        	$("#firstfilePic").attr("src",'<%=qiniuPath %>'+firstPic);
			});
		    
			initQiniu("${contextPath}/admin/qiniu_token", "filePic", function(result){
				var json=strToJson(result);
				pic=json.key;
	        	$("#filePic").attr("src",'<%=qiniuPath %>'+pic);
			});
			
			var paging = new WmPaging({el:"wmeimob-common-paging",totalCount:parseInt("${totalCount}"),pageSize:parseInt("${pageSize}"),dataLoad:function(pageIndex, pageSize){
				$.ajax({
		    		url:"${contextPath}/admin/classes/list/patch",
		    		data:{pageIndex:pageIndex,pageSize:pageSize},
		    		type:"get",
		    		dataType:"html",
		    		beforeSend: function () {  
		    			onDialog();
		    		},
		    		success:function(response){
		    			$("#sample_editable_1 > tbody").html(response);
		    			detailSubClassic();
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
			$(".wmeimob-common-paging").css("margin-top","1%")
			
		});
		
	    if($('tbody tr').length==0){
	        var newsTr="<tr><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='red-text' style='text-align:center' colspan='9'>暂无数据显示!</td></tr>"
	        	$('tbody').append(newsTr)
	     }
		function detailSubClassic(That){
		/* 	$(".black-icon").click(function(){ */
		    	if($("#"+That).next(".fenlei-tr").hasClass("empty")){
		    		$("#"+That).next(".fenlei-tr").removeClass("empty");
		    	    $("#"+That).find('.black-icon').addClass("icon-minus");
		    		
		    	}else{
		    	
		    		$("#"+That).next(".fenlei-tr").addClass("empty");
		    		$("#"+That).find('.black-icon').removeClass("icon-minus");
		    	}
		   
		    	var id = $("#"+That).children("td:first").html();
		    	var subTd = $("#"+That).next(".fenlei-tr").find("td.span-td");
		    	$.ajax({
		    		url:"${contextPath}/admin/classes/list/patch",
		    		data:"parentId="+id+"&issubclass=true",
		    		type:"get",
		    		dataType:"html",
		    		success:function(response){
		    			subTd.html(response);
		    		}
		    	});
		/*     }); */
		}
		
		
		
		//给确认按钮赋值
		function editCateOne(id,name,picKey){
			clearError();
			if(id !=undefined && id !=null && id !=''){
				$("#firstClassH3").html("编辑一级分类");
			}else
				$("#firstClassH3").html("新增一级分类");
			$("#goodsClass_sure").attr("onclick","saveFirstClass('"+id+"','')");
			$("#firstName").val(name);
			firstPic="";
			$("#firstfilePic").val(picKey);
			if(picKey!=undefined && picKey!=''){
			  $("#firstfilePic").attr("src",'<%=qiniuPath %>'+picKey);
			  firstPic=picKey;
			}else{
				 $("#firstfilePic").attr("src",'${contextPath}/static/image/add.png');
			}
		}
		
		
		
		//编辑一级分类保存
		function saveFirstClass(id,parentId){
			var firstName=$("#firstName").val();
			var firstPics=$("#firstfilePic").val();
			var sign=0;
			if(firstName==undefined || firstName==''){
				$("#errorHtml").html("一级分类不能为空!");
				sign=1;
				return;
			}
			if(firstPics==undefined || firstPics==''){
				$("#errorHtml").html("一级分类图标不能为空!");
				sign=1;
				return;
			}
			if(sign==0){
				$("#goodsClass_sure").attr({"data-dismiss":"modal"});
				$.ajax({
					type: 'POST',
					url: "${contextPath}/admin/classes/add",
					data : {id:id,name:firstName,pic:firstPic},
					success: function (data) {
						ohSnap(data.message,'black');
						if(id!=undefined && id !=''){	
							$("#"+id).find("td").eq(1).find("span").html(firstName);
							$("#"+id).find("td").eq(2).find("img").attr("src",'<%=qiniuPath %>'+firstPic);
							$("#"+id).find("td").eq(3).html("<a class='' data-toggle='modal' href='#cateOne' onclick=\"editCateOne('"+id+"','"+firstName+"')\"><img title='编辑' src='${contextPath}/static/image/icon/edit.png' style='width:30px;margin-left:5%;'></a>"
							+"<a class='' data-toggle='modal' href='#static' onclick=\"delCateOne('"+id+"','')\"><img title='删除' src='${contextPath}/static/image/icon/delete.png' style='width:30px;margin-left:5%'></a>"
							+"<a class='' data-toggle='modal' href='#cateTwo' onclick=\"editCateTwo('','"+id+"','','')\"><img title='添加子分类' src='${contextPath}/static/image/icon/add.png' style='width:30px;margin-left:5%;'></a>");
						}else{
							$(".fenlei-tr").last().after("<tr class='parentClass' role='row' id='"+data.id+"'>"
							+"<td style='display: none'>"+data.id+"</td>"
							+"<td><i class='icon-plus black black-icon' onclick=\"detailSubClassic('"+data.id+"')\"></i><span>"+firstName+"</span></td>"
							+"<td><img src=''  style='width:30px;margin-left:5%;'></td>"
							+"<td><a class='' data-toggle='modal' href='#cateOne' onclick=\"editCateOne('"+data.id+"','"+firstName+"')\"><img title='编辑' src='${contextPath}/static/image/icon/edit.png' style='width:30px;margin-left:5%;'></a>"
							+"<a class='' data-toggle='modal' href='#static' onclick=\"delCateOne('"+data.id+"','')\"><img title='删除' src='${contextPath}/static/image/icon/delete.png' style='width:30px;margin-left:5%'></a>"
							+"<a class='' data-toggle='modal' href='#cateTwo' onclick=\"editCateTwo('','"+data.id+"','','')\"><img title='添加子分类' src='${contextPath}/static/image/icon/add.png' style='width:30px;margin-left:5%;'></a></td></tr>"
						    +"<tr class='fenlei-tr details empty'>"
							+"<td class='empty'></td>"
							+"<td class='empty'></td>"
							+"<td colspan='5' class='span-td'>"
							+"</td>"
							+"</tr>"); 
							refresh();
						}
						$("#goodsClass_sure").attr({"data-dismiss":""});
					},
					error: function(data) {
						$("#goodsClass_sure").attr({"data-dismiss":""});
					}
				});
			}
		}
		
		//给确认按钮赋值
		function editCateTwo(id,parentId,name,picKey){
			clearError();
			if(id !=undefined && id !=null && id !=''){
				$("#secondClassH3").html("编辑二级分类");
			}else
				$("#secondClassH3").html("新增二级分类");
			pic="";
			$("#goodsClass_sure1").attr("onclick","saveSecondClass('"+id+"','"+parentId+"')");
			$("#secondName").val(name);
			if(picKey!=undefined && picKey!=''){
			  $("#filePic").attr("src",'<%=qiniuPath %>'+picKey);
			  pic=picKey;
			}else{
				 $("#filePic").attr("src",'${contextPath}/static/image/add.png');
			}
		}
		
		//编辑二级分类保存
		function saveSecondClass(id,parentId){
			var firstName=jQuery("#secondName").val();
			var sign=0;
			if(firstName==undefined || firstName==''){
				$("#errorHtml1").html("二级分类不能为空!");
				sign=1;
				return;
			}
			if(pic==undefined || pic==''){
				$("#errorHtml1").html("二级分类图标不能为空!");
				sign=1;
				return;
			}
			if(sign==0){
				$("#goodsClass_sure1").attr({"data-dismiss":"modal"});
				$.ajax({
					type: 'POST',
					url: "${contextPath}/admin/classes/add",
					data : {id:id,name:firstName,parentId:parentId,pic:pic},
					success: function (data) {
						ohSnap(data.message,'black');
						if(id!=undefined && id !=''){
							$("#"+id).find("li").eq(0).html(firstName);
							$("#"+id).find("li").eq(1).find("img").attr("src",'<%=qiniuPath %>'+pic);
							$("#"+id).find("li").eq(2).html('<a data-toggle="modal" href="#cateTwo" onclick="editCateTwo("'+id+'","'+parentId+'","'+name+'","'+pic+'")"><img title="编辑" src="${contextPath}/static/image/icon/edit.png" style="width:30px;margin-left:5%;"></a>');
							$("#"+id).find("li").eq(3).html('<a data-toggle="modal" href="#cateTwo" onclick="delCateOne("'+parentId+'","'+id+'")"><img title="删除" src="${contextPath}/static/image/icon/delete.png" style="width:30px;margin-left:5%;"></a>');
						}else{
							$(".add-fenlei-ul").last().after("<ul id='"+data.id+"' class='add-fenlei-ul'><li>"+firstName
							+"</li><li><img src='' style='width: 50px'/></li>"
							+"<li><a data-toggle='modal' href='#cateTwo' onclick=\"editCateTwo(('"+data.id+"','"+parentId+"','"+firstName+"','"+pic+"')\"><img title='编辑' src='${contextPath}/static/image/icon/edit.png' style='width:30px;margin-left:5%;'></a></li>"
							+"<li><a data-toggle='modal' href='#static' onclick=\"delCateOne('"+parentId+"','"+data.id+"')\"><img title='删除' src='${contextPath}/static/image/icon/delete.png' style='width:30px;margin-left:5%'></a></li></ul>");
							$("#"+data.id).find("li").eq(1).find("img").attr("src",'<%=qiniuPath %>'+pic);
						}
						$("#goodsClass_sure1").attr({"data-dismiss":""});
					},
					error: function(data) {
						$("#goodsClass_sure1").attr({"data-dismiss":""});
					}
				});
			}
		}
		

		//清楚错误标签提示
		function clearError(){
			$("#errorHtml").html("");
			$("#errorHtml1").html("");
		}
		
		//给删除确认按钮赋值
		function delCateOne(id,parentId){
			$("#Delete_S_sure").attr("onclick","del('"+id+"','"+parentId+"')");
		}
		
		
		//确认删除
		function del(categoryOne,categoryTwo){
			$.ajax({
    			url: '${contextPath}/admin/classes/delete?categoryOne='+categoryOne+'&categoryTwo='+categoryTwo,
    			dataType:'json',
    			success:function(json){
    				ohSnap(json.message,'black');
					if(categoryTwo !=undefined && categoryTwo !=''){
					  /* window.location.href="${contextPath}/admin/classes/list"; */
					   /*删除分类不用加载  移除页面的ul标签  */
					   if(json.code !=0){
					      $("#"+categoryTwo).remove();
					   }
    			     }else{
    			    	 if(json.code !=0){
    			    		$("#"+categoryOne).next("tr").remove();
    			            $("#"+categoryOne).remove();
    			    	  }
					 }
						  
    			}
    		});
		}
		
		
		//每页显示条数事件
		function pageingShow(){
			window.location.href="${contextPath}${pageUrl}?pageSize="+$("#totalCounts").val();
			
		}
		
		function refresh() {
			window.location.href="${contextPath}/admin/classes/list";
		}
	</script>

</body>


</html>