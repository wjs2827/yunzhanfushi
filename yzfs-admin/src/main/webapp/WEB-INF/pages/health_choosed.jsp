<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<div class="left">
	<p>个人信息</p>
	<div class="control-group">
		<label class="control-label">姓名：</label> <label
			class="control-label label_one textdiv" name="userName">${healthRecordVO.userName}</label>
	</div>
	<div class="control-group">
		<label class="control-label">性别：</label>
		<div class="controls">
			<c:if test="${healthRecordVO.sex==1}">
											男
											</c:if>
			<c:if test="${healthRecordVO.sex==2}">
											女
											</c:if>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">出生年月：</label> <label
			class="control-label label_one"><fmt:formatDate
				value="${healthRecordVO.birthDate}" pattern="yyyy/MM/dd" /></label>
	</div>

	<div class="control-group">
		<label class="control-label">出现认知障碍时间：</label> <label
			class="control-label label_one"><fmt:formatDate
				value="${healthRecordVO.appearTime}" pattern="yyyy/MM/dd" /></label>
	</div>

	<div class="control-group">
		<label class="control-label">首次诊断痴呆时间：</label> <label
			class="control-label label_one"><fmt:formatDate
				value="${healthRecordVO.diagnoseTime}" pattern="yyyy/MM/dd" /></label>
	</div>
	<p>睿耋评价体系</p>
	<div class="control-group">
		<label class="control-label">测评时间：</label> <label
			class="control-label label_one"><fmt:formatDate
				value="${healthRecordVO.mtestAt}" pattern="yyyy/MM/dd" /></label>
	</div>
	<div class="control-group">
		<label class="control-label">记忆力：</label> <label
			class="control-label label_one textdiv" name="memoryNum">${healthRecordVO.memoryNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">语言能力：</label> <label
			class="control-label label_one textdiv" name="expressNum">${healthRecordVO.expressNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">视空间：</label> <label
			class="control-label label_one textdiv" name="viewNum">${healthRecordVO.viewNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">注意力：</label> <label
			class="control-label label_one textdiv" name="attentionNum">${healthRecordVO.attentionNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">定向力：</label> <label
			class="control-label label_one textdiv" name="directionNum">${healthRecordVO.directionNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">计算能力：</label> <label
			class="control-label label_one textdiv" name="countNum">${healthRecordVO.countNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">逻辑能力：</label> <label
			class="control-label label_one textdiv" name="logicNum">${healthRecordVO.logicNum}</label>
	</div>
	<div class="control-group">
		<label class="control-label">照料者负担：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.zaritPoint==null?0:healthRecordVO.zaritPoint}</label>
	</div>

</div>
<div class="right">
	<p>随访测评</p>
	<div class="control-group">
		<label class="control-label">测评时间：</label> <label
			class="control-label label_one"><fmt:formatDate
				value="${healthRecordVO.ftestAt}" pattern="yyyy/MM/dd" /></label>
	</div>
	<div class="control-group">
		<label class="control-label">Mmse：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.mmseScore==null?0:healthRecordVO.mmseScore}</label>
	</div>
	<div class="control-group">
		<label class="control-label">Moca：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.mocaScore==null?0:healthRecordVO.mocaScore}</label>
	</div>
	<div class="control-group">
		<label class="control-label">Adl：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.adlScore==null?0:healthRecordVO.adlScore}</label>
	</div>
	<div class="control-group">
		<label class="control-label">Npi：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.npiScore==null?0:healthRecordVO.npiScore}</label>
	</div>
	<div class="control-group">
		<label class="control-label">总分：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.totalScore==null?0:healthRecordVO.totalScore}</label>
	</div>
	<p></p>
	<p>药物使用（每日剂量）</p>
	<div class="control-group">
		<label class="control-label">多奈哌齐：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.firstMedicine==null?0:healthRecordVO.firstMedicine}</label>
	</div>
	<div class="control-group">
		<label class="control-label">卡巴拉汀：</label> <label
			class="control-label label_one textdiv" name="zaritPoint">${healthRecordVO.secondMedicine==null?0:healthRecordVO.secondMedicine}</label>
	</div>
	<div class="control-group">
		<label class="control-label">石杉碱甲：</label> <label
			class="control-label label_one textdiv">${healthRecordVO.thirdMedicine==null?0:healthRecordVO.thirdMedicine}</label>
	</div>
	<div class="control-group">
		<label class="control-label">盐酸美金刚片：</label> <label
			class="control-label label_one textdiv">${healthRecordVO.forthMedicine==null?0:healthRecordVO.forthMedicine}</label>
	</div>
	<div class="control-group">
		<label class="control-label">奥拉西坦：</label> <label
			class="control-label label_one textdiv">${healthRecordVO.fifthMedicine==null?0:healthRecordVO.fifthMedicine}</label>
	</div>
	<div class="control-group">
		<label class="control-label">银杏叶片：</label> <label
			class="control-label label_one textdiv">${healthRecordVO.sixthMedicine==null?0:healthRecordVO.sixthMedicine}</label>
	</div>
	<c:if
		test="${healthRecordVO.sevName !=null && healthRecordVO.sevName !=''}">
		<div class="control-group">
			<label class="control-label">${healthRecordVO.sevName}：</label> <label
				class="control-label label_one">${healthRecordVO.sevMedicine}</label>
		</div>
	</c:if>
</div>