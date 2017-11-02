<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.wmeimob.yzfs.qiniu.QiniuConfig"%>
<% 
   String qiniuPath=QiniuConfig.getValue("IMG_PATH");
%>
<c:forEach var="homeCates" items="${homeCate}">
	<div class='addcontent'
		style='clear: both; overflow: hidden; margin-left: 100px; margin-bottom: 20px'>
		<span>分类名称：</span> <select style='float: left'>
			<option>${homeCates.cateGoryName}</option>

		</select>
		<div
			style='padding: 5px 10px; font-size: 16px; float: left; margin-left: 20px'>
			<a id="add_silder_fenlei" data-toggle="modal" href="#homeCateProduct"
				onclick="addHomeCateProduct('${homeCates.id}','${homeCates.categoryId}','${homeCates.cateGoryName}','${homeCates.type}')">
				<img title="设置商品" src="${basePath}/static/image/icon/edit.png"
				style="width: 30px; margin-left: 5%;">
			</a>
		</div>
		<div
			style='padding: 5px 10px; font-size: 16px; float: left; margin-left: 20px'>
			<a class="" data-toggle="modal" href="#static1"
				onclick="deleteCateGory('${homeCates.id}')"> <img title="删除首页分类"
				src="${basePath}/static/image/icon/delete.png"
				style="width: 30px; margin-left: 5%;">
			</a>
		</div>
	</div>

	<div
		style='clear: both; overflow: hidden; margin-left: 100px; margin-bottom: 20px'
		class='addcontent'>
		<span>商品展示：</span>
		<c:forEach var="homeCateProduct"
			items="${homeCates.homeCategoryProductVo}">
			<div class="fileupload fileupload-new Add_Img" style="float: left;"fileupload">
				<img src="<%=qiniuPath %>${homeCateProduct.spuKey}"
					title='${homeCateProduct.name}' style='width: 100px; height: 100px' />
				<p style='text-align: center; font-size: 15px; margin-top: 10px'>
					<a class="" data-toggle="modal" href="#static1"
						onclick="deleteCateProduct('${homeCateProduct.id}','${homeCateProduct.name}')">
						<img title="删除" src="${basePath}/static/image/icon/new_del.png"
						style="width: 30px; margin-left: 5%;">
					</a>
				</p>
			</div>
		</c:forEach>
	</div>
</c:forEach>

