<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<c:forEach items="${skuList}" var="sku" begin="0" varStatus="status">
	<div id="js_specifications${sku.id}" class="js_specifications">
		<h3 style='display: none;' class="SkuFather_Title">${sku.skuName}</h3>
		<p class="js_specifica${sku.id}" data-name="${sku.skuName}"
			data-id="${sku.id}" id="sku${sku.skuName}">
			<strong>${sku.skuName}</strong> <a
				href="javascript:editSku('${sku.id}');"
				class="m-l text-info js_specifica_edit" data-id="${sku.id}">编辑</a>
			<%--  <c:if test="${empty spuId}"> --%>
			<a href="#deleteStatic" data-toggle="modal"
				class="m-l text-info js_specifica_del" data-name="${sku.skuName}"
				data-id="${sku.id}"
				onclick="deleteSkuVal('${sku.id}','${sku.skuName}');">删除</a>
			<%--  </c:if> --%>
		</p>
		<div id="specvals${sku.id}" data-id="${sku.id}" data-toggle="specvals"
			class="m-b">
			<label class="checkbox-inline input-s-sm${status.index}"
				id="spe_${sku.id}"> <%--  <c:if test="${sku.skuItem.size()>0}"> --%>
				<c:forEach items="${sku.skuItem}" var="skuItem" begin="0"
					varStatus="status">
					<input type="checkbox" class="checkbox sku_check_item"
						style='margin-left: 0.5rem;' name="${skuItem.id}"
						value="${skuItem.id}" title="${skuItem.name}">${skuItem.name}
                 <input id="${skuItem.id}" type="hidden"
						value="${skuItem.name}" />
				</c:forEach> <%--  </c:if> --%>
			</label>
		</div>
		<!-- 添加规格属性开始 -->
		<div class="js_add_spe_form${sku.id} hide js_enter_div"
			style="border: 1px solid #e4e4ec; width: 94%; margin-left: 3%; margin-top: 1rem;">
			<!-- 规格名称开始 -->
			<div class="control-group" style="margin-top: 1rem;">
				<label class="control-label">${sku.skuName}</label> <input
					type="hidden" id="skuVal${sku.id}" name="skuVal${sku.id}"
					value="${sku.skuName}">
			</div>
			<!-- 规格名称结束 -->
			<!-- 规格属性值开始 -->
			<div class="control-group" style="margin-top: 1rem;">
				<label class="control-label">属性值</label>
				<div class="controls">
					<input type="text" id="skuItemVal${sku.id}"
						name="skuItemVal${sku.id}" placeholder="请输入属性值"
						class="form-control js_add_spev_input js_custom_input"
						data-limit="15" style="width: 50%"> <span class="js_limit"><em>0</em>/<span>15</span></span>
					<button type="button"
						class="skuItemAdd btn btn-default js_spe_speval"
						onclick="addSkuVal('${sku.id}');">添加</button>
				</div>
			</div>
			<!-- 规格属性值结束 -->
			<div
				class="col-sm-11 col-sm-offset-2 error m-t-n-md m-b-xs js_js_spe_spev_error"></div>
			<div class="controls">
				<div class="col-sm-11 col-sm-offset-2 js_spe_spev_show"
					style="margin-bottom: 1rem;" id="specValClass${sku.id}">
					<c:forEach items="${sku.skuItem}" var="skuItem" begin="0"
						varStatus="status">
						<span class="js_specvals_result${sku.id}"
							style='margin-left: 1rem;' data-myid="${skuItem.id}"
							data-name='${skuItem.name}' id='${skuItem.name}${sku.id}'>${skuItem.name}
							<%--  <c:if test="${empty spuId}"> --%> <i
							style='margin-left: .5rem; width: 30px;' data-speid='' data-id=''>
								<img class='removeSpec${sku.id}' style='width: 20px;'
								src='/yzfs-admin/static/image/icon/new_del.png'>
						</i> <%--  </c:if> --%>
						</span>
					</c:forEach>
				</div>
			</div>
			<div class="controls" style="margin-bottom: 1rem;">
				<div class="col-sm-5" style="margin-left: 140px;">
					<button type="button"
						class="btn btn-primary btn-sm js_add_spe_save"
						onclick="addSkuValSave('${sku.id}');">确定</button>
					<button type="button"
						class="btn btn-default btn-sm js_add_spe_cancel"
						onclick="cancleSku('${sku.id}');">取消</button>
				</div>
			</div>
		</div>
		<!-- 添加规格属性开结束-->
	</div>
	<div class="line line-dashed line-lg pull-in js_nospe_tips"></div>
</c:forEach>
