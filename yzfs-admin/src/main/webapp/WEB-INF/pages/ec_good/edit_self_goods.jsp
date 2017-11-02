<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
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
<meta content="<%=qiniuPath %>" name="qiniuPath" />

<title>商品管理</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="${contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link href="${contextPath}/static/css/bootstrap-responsive.min.css"
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

<link href="${contextPath}/static/css/bootstrap-modal.css"
	rel="stylesheet" type="text/css" />
<link href="${contextPath}/static/themes/default/default.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="${contextPath}/static/image/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/static/media/summernote.css">
<link href="${contextPath}/static/css/alert.css" rel="stylesheet" />

<!-- SKU模块CSS -->
<link href="${contextPath}/static/css/sku/sku.css" rel="stylesheet" />
<style>
.note-editor {
	margin-left: 11rem
}

<!--
多规格默认隐藏-->.dgeDivCss {
	display: none;
}

.input-group-addon {
	border-color: #dddddd;
	background-color: #dddddd;
	padding: 16px 12px;
	font-size: 14px;
	color: #555;
	border: 1px solid #dddddd;
	margin-left: -0.25rem;;
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

			<!-- BEGIN SIDEBAR MENU -->
			<%@include file="/WEB-INF/layouts/menu.jsp"%>

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

							<!-- <div class="color-mode-icons icon-color"></div> -->

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

						<h3 class="page-title"></h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">首页</a> <span
								class="icon-angle-right"> </span></li>

							<li><a href="#">商品管理</a> <span class="icon-angle-right"></span>

							</li>

							<li><a href="#">添加商品</a></li>

						</ul>

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption">
									<i class="icon-reorder"></i>添加商品
								</div>

								<div class="tools">


									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" onclick="refresh()" class="reload"></a>

								</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form class="form-horizontal" id="selfgoods" name="selfgoods"
									onsubmit="return false;">
									<input type="hidden" id="id" name="id"
										value="${goodsInfoVo.id}" /> <input type="hidden"
										id="qiniupath" value="<%=qiniuPath %>" /> <input type="hidden"
										id="desContent" name="desContent" /> <input type="hidden"
										id="spuType" name="spuType"
										<c:if test='${goodsInfoVo.spuType}'>value="1"</c:if>
										<c:if test='${goodsInfoVo.spuType==false}'>value="0"</c:if> />
									<input type="hidden" id="neckTitleLength"
										name="neckTitleLength" value="0" /> <input type="hidden"
										id="neckLength" name="neckLength" value="0" /> <input
										type="hidden" id="isUnifiedSpecs" name="isUnifiedSpecs"
										<c:if test='${goodsInfoVo.isUnifiedSpecs}'>value="1"</c:if>
										<c:if test='${goodsInfoVo.isUnifiedSpecs==false}'>value="0"</c:if> />
									<input type="hidden" id="skuTitleLength" name="skuTitleLength"
										value="0" /> <input type="hidden" id="skuLength"
										name="skuLength" value="0" /> <input type="hidden" id="isSale"
										name="isSale"
										<c:if test='${goodsInfoVo.isSale}'>value="1"</c:if>
										<c:if test='${goodsInfoVo.isSale==false}'>value="0"</c:if> />
									<div class="control-group">
										<label class="control-label">商品排序：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="Number" id="rank"
												name="rank" style="width: 10rem;"
												value="${goodsInfoVo.rank}" onblur="onBlurGoodRank();" /> <span
												class="help-inline" id="goodRankError">排序不填写默认为0</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品编码：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="text" id="spuCode"
												name="spuCode" value="${goodsInfoVo.spuCode}"
												style="width: 10rem;" /> <span class="help-inline"
												id="spuCodeError">必填项</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品分类：</label>
										<div class="controls">
											<select class="span3 m-wrap" name="classesparentId"
												id="parentId" onchange="chooseSecondClass(this.value)"
												onblur="onBlurGoodFirstClass();">
												<option value="0">一级分类</option>
											</select> <select class="span3 m-wrap" name="classesId"
												id="secondClassId" onblur="onBlurGoodSecondClass();"
												onchange="initSkuList(this.value);">
												<option value="0" id="0">二级分类</option>
											</select> <span class="help-inline" id="secondClassIdError">必填项</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品名称：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="text" id="name"
												style="width: 50%" name="name" value="${goodsInfoVo.name}"
												placeholder="请输入商品名称" onblur="onBlurGoodName();" /> <span
												class="help-inline" id="goodNameError">必填项</span>
										</div>
									</div>

									<!-- 是否可改装开始-->
									<div class='control-group'>
										<label class="control-label">商品类型：</label>
										<c:if test="${goodsInfoVo.spuType}">
											<div class="all-guige">
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" id='checkboxrefit'
													name='radioRefit' /><span>不可改装</span> <input type='radio'
													value='1' style="float: left; margin-left: 1px;" checked
													id='checkboxrefit' name='radioRefit' /><span>可改装</span>
											</div>
										</c:if>
										<c:if test="${goodsInfoVo.spuType==false}">
											<div class="all-guige">
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" checked
													id='checkboxrefit' name='radioRefit' /><span>不可改装</span> <input
													type='radio' value='1'
													style="float: left; margin-left: 1px;" id='checkboxrefit'
													name='radioRefit' /><span>可改装</span>
											</div>
										</c:if>
									</div>

									<!-- 可改装开始-->
									<div id="whetherRefitDivClass"
										class="control-group choose_config"
										style='border: 1px solid #e4e4ec;margin-left:12rem;background: #f5f5f5;width: 80%;<c:if test="${goodsInfoVo.spuType==false}">display:none;</c:if>'>

									</div>
									<!-- 可改装 结束-->
									<!--是否可改装生成表格 -->
									<div class="control-group mt10" id="neckTalbe"
										style="<c:if test='${goodsInfoVo.spuType==false}'>display:none;</c:if>margin-left:.8rem;">
										<div class="controls" id="createTable"></div>
									</div>


									<!-- 是否多规格 开始-->
									<div class='control-group'>
										<label class="control-label">商品规格：</label>
										<c:if test="${goodsInfoVo.isUnifiedSpecs}">
											<div class="all-guige">
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" id='checkboxspec'
													name='radioSpec' /><span>统一规格</span> <input type='radio'
													value='1' style="float: left; margin-left: 1px;" checked
													id='checkboxspec' name='radioSpec' /><span>多规格</span>
											</div>
										</c:if>
										<c:if test="${goodsInfoVo.isUnifiedSpecs==false}">
											<div class="all-guige">
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" checked
													id='checkboxspec' name='radioSpec' /><span>统一规格</span> <input
													type='radio' value='1'
													style="float: left; margin-left: 1px;" id='checkboxspec'
													name='radioSpec' /><span>多规格</span>
											</div>
										</c:if>
									</div>
									<!-- 是否多规格结束-->
									<!-- 统一规格开始-->
									<div id="tyspecDiv"
										<c:if test="${goodsInfoVo.isUnifiedSpecs==true}">style="display:none;"</c:if>
										<c:if test="${goodsInfoVo.isUnifiedSpecs==false}">style="display:block;"</c:if>>
										<input type="hidden" id="skuCode" name="skuCode" />
										<div class="control-group">
											<label class="control-label">销售价：</label>
											<div class="controls">
												<input class="span3 m-wrap" type="text" placeholder="请输入销售价"
													id="sku_price" name="sku_price"
													onkeyup="skuPriceOnkeyup('');" /> <span class="help-inline"
													id="skuErrorTitle">必填项</span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">市场价：</label>
											<div class="controls">
												<input class="span3 m-wrap" type="text" id="sku_market"
													name="sku_market" onkeyup="skuMarketOnkeyup('');" /> <span
													class="help-inline" id="skuMarketTitle">选填项</span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">商品库存：</label>
											<div class="controls">
												<input class="span3 m-wrap" type="Number" min="0"
													placeholder="请输入库存" id="sku_stock" name="sku_stock"
													onkeyup="skuStockOnkeyup('');" /> <span class="help-inline"
													id="skuStockTitle">必填项</span>
											</div>
										</div>
									</div>

									<!-- 统一规格 结束-->
									<!-- 多规格开始-->
									<div id="dgespecDiv"
										<c:if test="${goodsInfoVo.isUnifiedSpecs==true}">style="display:block;"</c:if>
										<c:if test="${goodsInfoVo.isUnifiedSpecs==false}">style="display:none;"</c:if>>
										<div>
											<span class="help-block js_nospe_tips">暂无规格数据，请先添加规格</span>
										</div>

										<!-- 规格属性展示开始 -->
										<div style="margin-left: 1rem;" class="skuListClassOne">


										</div>
										<!-- 规格属性展示开始 -->
										<div class="js_add_spe_div add-attr">
											<a class="js_add_spe_btn" href="javascript:addSku();">添加规格</a>
										</div>
										<!-- 添加规格属性开始 -->
										<div class="js_add_spe_form hide js_enter_div"
											style="border: 1px solid #e4e4ec; width: 94%; margin-left: 3%; margin-top: 1rem;">
											<!-- 规格名称开始 -->
											<div class="control-group" style="margin-top: 1rem;">
												<label class="control-label">规格名称</label>
												<div class="controls">
													<input type="text" id="skuVal" name="skuVal" class=""
														data-limit="5" style="width: 50%"> <span
														class="js_limit"><em>0</em>/<span>5</span></span>
												</div>
											</div>
											<!-- 规格名称结束 -->
											<!-- 规格属性值开始 -->
											<div class="control-group" style="margin-top: 1rem;">
												<label class="control-label">属性值</label>
												<div class="controls">
													<input type="text" id="skuItemVal" name="skuItemVal"
														placeholder="请输入属性值"
														class="form-control js_add_spev_input js_custom_input"
														data-limit="15" style="width: 50%"> <span
														class="js_limit"><em>0</em>/<span>15</span></span>
													<button type="button"
														class="skuItemAdd btn btn-default js_spe_speval"
														onclick="addSkuVal('');">添加</button>
												</div>
											</div>
											<!-- 规格属性值结束 -->
											<div
												class="col-sm-11 col-sm-offset-2 error m-t-n-md m-b-xs js_js_spe_spev_error"></div>
											<div class="controls">
												<div class="col-sm-11 col-sm-offset-2 js_spe_spev_show"
													style="margin-bottom: 1rem;" id="specValClass"></div>
											</div>
											<div class="controls" style="margin-bottom: 1rem;">
												<div class="col-sm-5" style="margin-left: 140px;">
													<button type="button"
														class="btn btn-primary btn-sm js_add_spe_save"
														onclick="addSkuValSave('');">确定</button>
													<button type="button"
														class="btn btn-default btn-sm js_add_spe_cancel"
														onclick="cancleSku('');">取消</button>
												</div>
											</div>
										</div>
										<!-- 添加规格属性开结束-->
										<div>
											<span class="help-block-title">规格添加后请勿随意删除，删除后正在使用相应规格的商品在编辑时规格部分将受到影响</span>
										</div>
									</div>
									<!--多规格生成表格 -->
									<div class="control-group mt10" id="skuTalbe"
										style="margin-left: .8rem;">
										<div class="controls" id="createSkuTable"></div>
									</div>
									<!-- 多规格 结束-->
									<div class="control-group">
										<label class="control-label">商品重量：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="text" min="0"
												placeholder="请输入重量" id="weight" name="weight"
												value="${goodsInfoVo.weight}"
												onkeyup="onBlurGoodWeight('');" /> <span
												class="input-group-addon">kg</span> <span
												class="help-inline" id="weightError">选填项默认为0</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">自定义销量：</label>
										<div class="controls">
											<input class="span3 m-wrap" type="Number" min="0"
												placeholder="请输入自定义销量" id="customizeStockCount"
												name="customizeStockCount"
												value="${goodsInfoVo.customizeStockCount}"
												onblur="onBlurGoodcustomizeStockCount();" /> <span
												class="help-inline" id="customizeStockCountError">选填项(默认为0)</span>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品图片：</label>
										<div class="fileupload fileupload-new Add_Img"
											style="margin-left: 11rem; margin-top: 0.1rem"
											data-provides="fileupload">
											<div class="fileupload-new thumbnail"
												style="width: 64px; height: 64px;">
												<span class="btn btn-file"> <span
													class="fileupload-new"> <c:if
															test="${goodsInfoVo.spuKeysValue==''}">
															<img id="spuKeys"
																src="${contextPath}/static/image/add.png"
																style="width: 64px; height: 50px;"
																class="fileupload-new" />
														</c:if> <c:if test="${goodsInfoVo.spuKeysValue!=''}">
															<img id="spuKeys"
																src="<%=qiniuPath %>${goodsInfoVo.spuKeysValue}"
																style="width: 64px; height: 50px;"
																class="fileupload-new" />
														</c:if> <input type="hidden" id="spuKeysValue"
														name="spuKeysValue" value="${goodsInfoVo.spuKeysValue}" />
												</span>
												</span>
											</div>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">商品banner：</label>
										<c:if test="${goodPicList.size()>0}">
											<c:forEach items="${goodPicList}" var="picses" begin="0"
												varStatus="status">
												<div class="infile">
													<div class="Contro" id="contro_${status.index}">
														<input type="hidden" class="default"
															name="goodsPicses[${status.index}].id" /> <input
															type="hidden" class="default"
															name="goodsPicses[${status.index}].picKey"
															value="${picses.picKey}" />
														<div class="fileupload fileupload-new Add_Img"
															data-provides="fileupload">
															<div class="fileupload-new thumbnail"
																style="width: 64px; height: 64px;">
																<span class="btn btn-file"> <span
																	class="fileupload-new"> <img
																		id="img_${status.index}"
																		src="<%=qiniuPath%>${picses.picKey}" alt=""
																		style="width: 64px; height: 50px;"
																		class="fileupload-new" />
																</span>
																</span>
															</div>
														</div>
													</div>
													<div>
														<img class="btn fileupload-deleteImg" alt="删除"
															src="${contextPath}/static/image/delete.png" />
													</div>
												</div>
											</c:forEach>
										</c:if>
										<div class="infile">
											<div class="Contro" id="contro_${goodPicList.size()}">
												<input type="hidden" class="default"
													name="goodsPicses[${goodPicList.size()}].id" /> <input
													type="hidden" class="default"
													name="goodsPicses[${goodPicList.size()}].picKey" />
												<div class="fileupload fileupload-new Add_Img"
													data-provides="fileupload">
													<div class="fileupload-new thumbnail"
														style="width: 64px; height: 64px;">
														<span class="btn btn-file"> <span
															class="fileupload-new"> <img
																id="img_${goodPicList.size()}"
																src="${contextPath}/static/image/add.png" alt=""
																style="width: 64px; height: 50px;"
																class="fileupload-new" /></span>
														</span>
													</div>
												</div>
											</div>
											<div>
												<img class="btn fileupload-deleteImg" alt="删除"
													src="${contextPath}/static/image/delete.png" />
											</div>
										</div>
									</div>
									<input type="hidden" id="ke_qiniu_upload">
									<div class="control-group">
										<label class="control-label">商品详情 ：</label>
										<div id="summernote_1" style="margin-left: 15rem">
											${goodsInfoVo.descriptions}</div>
									</div>
									<!-- 是否立即上架-->
									<div class='control-group'>
										<label class="control-label">是否上架：</label>
										<c:if test="${goodsInfoVo.isSale}">
											<div class="all-guige">
												<input type='radio' value='1'
													style="float: left; margin-left: 1px;" checked
													id='checkboxIsSale' name='checkboxIsSale' /><span>立即上架</span>
												<input type='radio' value='0'
													style="float: left; margin-left: 1px;" id='checkboxIsSale'
													name='checkboxIsSale' /><span>暂不上架</span>
											</div>
										</c:if>
										<c:if test="${goodsInfoVo.isSale==false}">
											<div class="all-guige">
												<input type='radio' value='1'
													style="float: left; margin-left: 1px;" id='checkboxIsSale'
													name='checkboxIsSale' /><span>立即上架</span> <input
													type='radio' value='0'
													style="float: left; margin-left: 1px;" checked
													id='checkboxIsSale' name='checkboxIsSale' /><span>暂不上架</span>
											</div>
										</c:if>
									</div>
									<div class="form-actions">
										<a href="${contextPath}/admin/good/list"><button
												type="button" class="btn">取消</button></a>
										<button type="button" id="save" class="btn blue">保存</button>

									</div>

								</form>

								<!-- END FORM-->

							</div>

						</div>

						<!-- END SAMPLE FORM PORTLET-->

					</div>

				</div>

				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>
	<!-- 加载中 -->
	<div id="publicDiload"></div>
	<div id="ohsnap"></div>

	<!-- 删除弹框结束 -->
	<div id="deleteStatic" style="width: 25rem" class="modal fade"
		tabindex="-1" data-backdrop="static" data-keyboard="false">
		<div class="modal-body">
			<p class="deleteClassTitle"></p>
		</div>
		<div class="modal-footer">
			<button type="button" data-dismiss="modal" class="btn green"
				id="Delete_S_sure">确定</button>
			<button type="button" data-dismiss="modal" class="btn">取消</button>
		</div>
	</div>
	<!-- 删除弹框结束 -->

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

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${contextPath}/static/js/app.js"></script>

	<script src="${contextPath}/static/js/form-components.js"></script>

	<!-- SKU模块JS -->
	<script src="${contextPath}/static/css/sku/sku.js"></script>

	<script src="${contextPath}/static/js/ec_good/edit_insert.js"></script>

	<script type="text/javascript" src="${contextPath}/static/js/ohsnap.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<!-- 七牛upload js -->
	<script type="text/javascript"
		src="${contextPath }/static/js/plupload.full.min.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu.min.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/js/qiniu-init.js"></script>
	<script src="${contextPath}/static/media/summernote.js"
		type="text/javascript"></script>
	<script src="${contextPath}/static/media/components-editors.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
	
	
    //默认加载数据
	jQuery(document).ready(function() {
       ComponentsEditors.init();
	   App.init();
	   initQiniuSpuImg();
	   chooseFirstClass();//一级分类加载
	   loadNecklineInfo();//布料类型加载
	   //初始化七牛上传图片
	   for (var i = 0; i < $(".Contro").length; i++) {
				initUploadQiniu(i);
	   }
	});
	
     
   //加载一级分类
   function chooseFirstClass(){
	   $.ajax({
    	    type: "POST",
    	    url: "${contextPath}/admin/good/listClassVo",
    	    success: function(data){
    	    	$("#parentId").html("");
    	    	$.each(data,function (index,domEle){
    	    			if('${goodsInfoVo.parentId}'!=data[index].id){
    	 		   			$("#parentId").append("<option value="+data[index].id+">"+data[index].name+"</option>");
    	    			}else{
    	    				$("#parentId").append("<option selected value="+data[index].id+">"+data[index].name+"</option>");
    	    			}
    	 		});
    	    }
    	  });
	   if('${goodsInfoVo.parentId}'!=null&&'${goodsInfoVo.parentId}'!=''&&'${goodsInfoVo.parentId}'!=undefined){
		   chooseSecondClass('${goodsInfoVo.parentId}');
	   }else{
		   $("#secondClassId").append("<option value ='0'>二级分类</option>");
	   }
	  
   };
   
		
   //加载二级分类
   function chooseSecondClass(id){
      $("#secondClassId").html("");
      $.ajax({
   		url:"${contextPath}/admin/good/listErji",
   		data:{"id":id},
   		type:'post',
   		success:function(data){
   			    $("#secondClassId").append("<option value ='0'>二级分类</option>");
   			    $.each(data,function (index,domEle){
	    			if('${goodsInfoVo.classesId}'!=data[index].id){
	 		   			$("#secondClassId").append("<option value="+data[index].id+">"+data[index].name+"</option>");
	    			}else{
	    				$("#secondClassId").append("<option selected value="+data[index].id+">"+data[index].name+"</option>");
	    			}
 				});
   			   initSkuList('${goodsInfoVo.classesId}');
   			}
   	    })
     };
	
		
	//初始化富文本编辑器图片上传
	initQiniu("${contextPath}/admin/qiniu_token", "ke_qiniu_upload", function(result) {
		var json=strToJson(result);
		editor.insertHtml('<img src="<%=qiniuPath %>/'+json.key+'" />');
	});


	//图片框点击事件
	$("[class='btn btn-file']").live("click",function(){
		if ($(this).find("img").eq(0).attr("status")=="0") {
			return;
		}
	});
		
		//添加图片框
	function addPic(){
		var controlers=	"<div class='infile'><div class='Contro'><input type='hidden' class='default' /><input type='hidden' class='default' />" +
		"<div class='fileupload fileupload-new Add_Img'>"+
		"<div class='fileupload-new thumbnail' style='width:64px; height:64px;'>" +
		"<span class='btn btn-file'><span class='fileupload-new'>" +
		"<img src='${contextPath}/static/image/add.png' alt=''  style='width:64px; height:50px;' class='fileupload-new'/></span></span>" +
		"</div> <div class='fileupload-preview fileupload-exists thumbnail' style='width: 100%; height: 108px; line-height: 10px;'>" +
		"</div></div></div><img class='btn fileupload-deleteImg' alt='删除' src='${contextPath}/static/image/delete.png'" +
		"</div>";
		
		$(".infile").last().after(controlers);
		
		var l = $(".Contro").length;
		console.log("图片索引："+l);
		$(".Contro").last().attr("id","contro_"+(l-1));
		$(".Contro").last().children("input[type=hidden]").eq(0).attr("name","goodsPicses["+(l-1)+"].id");
		$(".Contro").last().children("input[type=hidden]").eq(1).attr("name","goodsPicses["+(l-1)+"].picKey");
	
		$(".Contro").last().find("img").eq(0).attr("id","img_"+(l-1));
		delPic();
		initUploadQiniu(l-1);
	}
		
	//删除图片
	delPic();
	var length=$(".Contro").length;
	function delPic(){
		$(".fileupload-deleteImg").each(function(m){
			$(".Contro").eq(m).find("img").eq(0).attr("id","img_"+m);
    		$(".Contro").eq(m).attr("id","contro_"+(m));
    		$("#contro_"+m+" input[type=hidden]").eq(0).attr("name","goodsPicses["+m+"].id");
			$("#contro_"+m+" input[type=hidden]").eq(1).attr("name","goodsPicses["+m+"].picKey");
			
			$(this).click(function(){
			 if($("#img_"+m).attr("src")=="${contextPath}/static/image/add.png"){
					return;
			}else{
					$(this).parents(".infile").remove();
				}
			})
		})
	}
	
	//初始化七牛
	function initUploadQiniu(index) {
		initQiniu("${contextPath}/admin/qiniu_token", "contro_"+index, function(result) {
			var json=strToJson(result);
        	$("#img_"+index).attr("src",'<%=qiniuPath %>'+json.key);
        	$("input[name='goodsPicses["+index+"].picKey']").eq(0).val(json.key);
        	if ($("#img_"+index).attr("status")!="1") {
        		$("#img_"+index).attr("status","1");
        		addPic();
			}
		});
	};
	
     //刷新页面
     function refresh() {
		window.location.href="${contextPath}/shop/goods/list";
	}
	</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>