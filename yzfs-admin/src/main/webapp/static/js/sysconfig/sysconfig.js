
//验证正整数或者小数点
function checkisNumber(str) {
	var pattern = /^[\+\-]?[0-9]\d*(\.\d*)?$/;
	return pattern.test(str);
}

//验证正整数或者小数点
function checkisNumberss(str) {
	var pattern = /^[\+\-]?[0-9]\d*(\.\d*)?$/;
	return pattern.test(str);
}
//验证正整数
function checkisNumbers(str) {
	var pattern = /^\+?[0-9]\d*$/;
	return pattern.test(str);
}

//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
var newsTr="<tr><td class='red-text' style='text-align:center' colspan='4'>暂无数据显示!</td></tr>";


//异步初始化金币设置列表
function initSysConfigList(){
    $.ajax({
		url:contextPath+"/admin/config/batchConfigSysConfig",
		type:"get",
		dataType:"html",
		success:function(response){
			$(".tbodyClassTwo").html(response);
			TableEditable.init();
			if($('.tbodyClassTwo tr').length==0){
			    $('.tbodyClassTwo').append(newsTr)
			 }
		},
		complete: function () {  
			offDialog();
	    },
	    error: function (response) {  
	        console.info("error: " + data.responseText);  
	    }  
	});
}

//修改参数信息
function editSysConfig(id,name,value){
	var newValue=$("."+id).val();
	$(".sysConfigType").html("参数类型【"+name+"】");
	$(".sysConfigValue").html("原参数值【"+value+"】");
	$(".newSysConfigValue").html("新参数值【"+newValue+"】");
	$("#confimSave").attr({"onclick":"editSysConfigSave('"+id+"','"+name+"','"+newValue+"')"});
}

//确认修改参数信息
function editSysConfigSave(id,name,newValue){
    $.ajax({
		url:contextPath+"/admin/config/editReadListByParams",
		data:{id:id,value:newValue},
		type:"post",
		dataType:"json",
		success:function(json){
			if(json.code==100){
				ohSnap(json.msg,'black');
				initSysConfigList();
			}else{
				ohSnap(json.msg,'black');
				$("#"+id).css({"border-color":"#ff0000"});
				$("#"+id).focus();
			}
		}
	});
}

//异步初始化充值套餐
function initSysRechargeRuleList(sign){
    $.ajax({
		url:contextPath+"/admin/config/batchConfigRecharge",
		type:"get",
		dataType:"html",
		beforeSend: function () {  
			onDialog();
		}, 
		success:function(response){
			$(".tbodyClassOne").html(response);
			TableEditable.init();
			if($('.tbodyClassOne tr').length==0){
			    $('.tbodyClassOne').append(newsTr)
			}
		},	    
	    error: function (response) {  
	        console.info("error: " + data.responseText);  
	    } 
	});
}


//修改或者新增充值套餐信息
function editSysRecharge(id,rechargeAmount,attachAmount,remark){
	cleanError();
	if(id ==undefined || id==''){
		$("#rechargeInputClor").find("input").css({"border-color":"#ff0000"});
		$(".rechargeTtile").text("新增充值规则");
	}else{
		$("#rechargeInputClor").find("input").css({"border-color":"#4aaf00"});
		$(".rechargeTtile").text("修改充值规则");
	}
	$("#rechargeAmount").val(rechargeAmount);
	$("#attachAmount").val(attachAmount);
	$("#remark").val(remark);
	$("#btn_recharge_save").attr({"onclick":"editSysRechargeSave('"+id+"')"});
}

//确认修改参数信息
function editSysRechargeSave(id){
	var rechargeAmount=$("#rechargeAmount").val();
	var attachAmount=$("#attachAmount").val();
	var remark=$("#remark").val();
	if(rechargeAmount ==undefined || rechargeAmount==''){
		$("#recharge_err_msg").html("亲!充值金额不能为空!");
		$("#rechargeAmount").focus();
		$("#rechargeAmount").css({"border-color":"#ff0000"});
		return;
	}else{
		if(!checkisNumberss(rechargeAmount)){
			$("#recharge_err_msg").html("亲!充值金额不合法(100或者100.00)!");
			$("#rechargeAmount").focus();
			$("#rechargeAmount").css({"border-color":"#ff0000"});
			return;
		}else{
			$("#rechargeAmount").css({"border-color":"#4aaf00"});
		}
	}
	if(remark ==undefined || remark==''){
		$("#recharge_err_msg").html("亲!充值文字不能为空!");
		$("#remark").focus();
		$("#remark").css({"border-color":"#ff0000"});
		return;
	}else{
		$("#remark").css({"border-color":"#4aaf00"});
	}
	if(attachAmount ==undefined || attachAmount==''){
		$("#recharge_err_msg").html("亲!增加余额不能为空!");
		$("#attachAmount").focus();
		$("#attachAmount").css({"border-color":"#ff0000"});
		return;
	}else{
		if(!checkisNumberss(attachAmount)){
			$("#recharge_err_msg").html("亲!增加余额不合法(100或者100.00)!");
			$("#attachAmount").focus();
			$("#attachAmount").css({"border-color":"#ff0000"});
			return;
		}else{
			$("#attachAmount").css({"border-color":"#4aaf00"});
		}
	}
	cleanError();
    $.ajax({
		url:contextPath+"/admin/config/editConfigRecharge",
		data:{id:id,rechargeAmount:rechargeAmount,attachAmount:attachAmount,remark:remark},
		type:"post",
		dataType:"json",
		success:function(json){
			if(json.code==100){
				$(".btn_admin_cancel").trigger("click");
				ohSnap(json.msg,'black');
				initSysRechargeRuleList();
				initSysConfigList();
				$("#btn_recharge_save").attr({"data-dismiss":""});
			}else{
				$("#recharge_err_msg").html(json.msg);
				$("#"+id).css({"border-color":"#ff0000"});
				$("#"+id).focus();
			}
		}
	});
}

//删除或者启用停用充值规则
function delConfigRecharge(id,value){
	if(value=='del'){
		$(".isUsedTitle").text("确认要删除吗?");
	}
	if(value=='0'){
		$(".isUsedTitle").text("确认要停用吗?");
	}
	if(value=='1'){
		$(".isUsedTitle").text("确认要启用吗?");
	}
	$("#isUsedSave").attr({"onclick":"delConfigRechargeSave('"+id+"','"+value+"')"});
}

//确认删除或者启用停用充值规则
function delConfigRechargeSave(id,value){
    $.ajax({
		url:contextPath+"/admin/config/delConfigRecharge",
		data:{id:id,value:value},
		type:"post",
		dataType:"json",
		success:function(json){
			if(json.code==100){
				ohSnap(json.msg,'black');
				initSysRechargeRuleList();
				initSysConfigList();
			}else{
				ohSnap(json.msg,'black');
			}
		}
	});
}

//清空错误
function cleanError(){
	$("#recharge_err_msg").html("");
}













