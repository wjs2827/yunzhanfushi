
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

//验证大于0正整数
function checkisNumbersone(str) {
	var pattern = /^\+?[1-9]\d*$/;
	return pattern.test(str);
}

//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
//正确的图片
var imgPath="<img style='width:30px;' src='"+contextPath+"/static/image/icon/isTrue.png'/>";

//初始化七牛上传图片
function initQiniuHeadImage(){
	initQiniu(contextPath+"/admin/qiniu_token", "filePic", function(result){
		var json=strToJson(result);
		$("#picKey").val(json.key);
	 	$("#filePic").attr("src",$("#qiniupath").val()+json.key);
	});
}

//初始化改装版式图片
function initQiniuNeckLineImg(index){
	initQiniu(contextPath+"/admin/qiniu_token", "neckimg-key"+index, function(result){
		var json=strToJson(result);
		$("#neckimg-keys"+index).val(json.key);
	 	$("#neckimg-key"+index).attr("src",$("#qiniupath").val()+json.key);
	});
}

//初始化商品sku图片
function initQiniuSkuImg(index){
	initQiniu(contextPath+"/admin/qiniu_token", "skuImg-key"+index, function(result){
		var json=strToJson(result);
		$("#skuImg-keys"+index).val(json.key);
	 	$("#skuImg-key"+index).attr("src",$("#qiniupath").val()+json.key);
	});
}

//初始化商品图片
function initQiniuSpuImg(){
	initQiniu(contextPath+"/admin/qiniu_token", "spuKeys", function(result){
		var json=strToJson(result);
		$("#spuKeysValue").val(json.key);
	 	$("#spuKeys").attr("src",$("#qiniupath").val()+json.key);
	});
}
var spuCode="";

//提交商品信息
$("#save").click(function (){
	var isTrue=false;
	 $("#desContent").val($(".note-editable").html());
	//验证排序
	if(!onBlurGoodRank())
		return;
	//验证编码
    if(!onBlurSpuCode())
	 return;
	//验证一分类
	if(!onBlurGoodFirstClass())
		return;
	//验证二分类
	if(!onBlurGoodSecondClass())
		return;
	//验证商品名称
	if(!onBlurGoodName())
		return;
	//验证是否可改装 0:不可改装  1：可改装
	var refitType =$("#spuType").val();
	if(refitType=='1'){
	    if($("#createTable tr").length==0){
	    	ohSnap("亲!至少选择一种领口类型和布料组合",'black');
	    	return;
	    }
	    var neckLength=$("#neckLength").val();	
		for(var s=0;s<neckLength;s++){ 
			if(!onBlurNeckSalePrice(s))
				return;
		}
	}
	
	//验证是否多规格 0:统一规格  1：多规格
	var specType =$("#isUnifiedSpecs").val();
	if(specType=='1'){
	    var skuLength=$("#skuLength").val();
	    if(skuLength==undefined || skuLength=='' || skuLength==0){
	    	ohSnap("亲!至少选择一种组合的规格属性",'black');
	    	return;
	    }
		for(var s=0;s<skuLength;s++){ 
			if(!skuPriceOnkeyup(s))
				return;
			if(!skuMarketOnkeyup(s))
				return;
			if(!skuStockOnkeyup(s))
				return;
		}
	}else{
		//校验销售价
        if(!skuPriceOnkeyup('')){
        	return;
        }
        //如果市场价不为空，则校验市场价合法性
        var marketPrice=$("#marketPrice").val();
        if(marketPrice!=undefined && marketPrice!=''){
	        if(!skuMarketOnkeyup('')){
	        	return;
	        }
        }
    	//验证库存
    	if(!skuStockOnkeyup(''))
    		return;
	}
	//验证重量
	if(!onBlurGoodWeight(''))
		return;
	//如果验证成功，提交商品
	var selfgoods = $("form[name=selfgoods]");
	 $("#desContent").val($(".note-editable").html());
	 $(".modal-backdrop").removeClass("none");
	 $.ajax({
		 url:contextPath+"/admin/good/operateGoods",
		 data:selfgoods.serialize(),
		 type:"POST",
 		 beforeSend: function () {  
			onDialog();
		 },
		 success:function(data){
			 offDialog();
			 if(data.code==100){
				 ohSnap(data.msg,'black');
				 setTimeout("queryGoodsList()",1000);//1000为1秒钟,设置为1分钟。  
			 }
			 if(data.code==200){
				 var idName=data.sign;
				 var idError=data.error;
				 var errorMsg=data.msg;
				 $("#"+idError).html(errorMsg);
				 publicOnfocus(idName,idError);
				 return;
			 }else{
				 ohSnap(data.msg,'black');
			 }
		 },
         complete: function () {  
 			offDialog();
 	     },
		 error:function(data){
			 ohSnap("系统异常",'black');
		 }
	 });
 });


//商品排序校验
function onBlurGoodRank(){
	 var idName="rank";
	 var idError="goodRankError";
	 if($.trim($("#rank").val())){
		 if(!checkisNumbers($("#rank").val())) {
		   $("#"+idError).html("排序值不合法,必须为正整数!");
		   publicOnfocus(idName,idError);
		   return false;
		 }else{
		   publicOnRight(idName,idError);
		   $("#"+idError).html(imgPath);
		   return true;
		 }
	 }else{
		 $("#rank").val(0);
		 publicOnRight(idName,idError);
		 $("#"+idError).html(imgPath);
		 return true;
	 }
}

//商品编码校验
function onBlurSpuCode(){
	 var idName="spuCode";
	 var idError="spuCodeError";
	 var val=$("#spuCode").val();
	 if (val==undefined || val==0) {
	     $("#"+idError).html("商品编码不能为空!");
	     publicOnfocus(idName,idError);
	     return false;
	 }else{
		 publicOnRight(idName,idError);
		 $("#"+idError).html("");
		 return true;
	 }
}

//商品一级分类校验
function onBlurGoodFirstClass(){
	 var idName="parentId";
	 var idError="secondClassIdError";
	 var val=$("#parentId").val();
	 if (val==undefined || val==0) {
		   $("#"+idError).html("请选择一级分类!");
		   publicOnfocus(idName,idError);
		   return false;
	 }else{
		 publicOnRight(idName,idError);
		 $("#"+idError).html("");
		 return true;
	 }
}

//商品二级分类校验
function onBlurGoodSecondClass(){
	 var idName="secondClassId";
	 var idError="secondClassIdError";
	 var val=$("#secondClassId").val();
	 if (val==undefined || val==0) {
		   $("#"+idError).html("请选择二级分类!");
		   console.log("请选择二级分类!");
		   publicOnfocus(idName,idError);
		   return false;
	 }else{
		 publicOnRight(idName,idError);
		 $("#"+idError).html(imgPath);
		 return true;
	 
	 }
}


//商品名称校验
function onBlurGoodName(){
	 var idName="name";
	 var idError="goodNameError";
	 if(!$.trim($("#name").val())){
		 $("#"+idError).html("商品名称不能为空!");
		 publicOnfocus(idName,idError);
		 return false;
	 }else{
		 publicOnRight(idName,idError);
		 $("#"+idError).html(imgPath);
    	 return true;
     }
}

//商品改装SKU加价校验
function onBlurNeckSalePrice(index){
	 var idName="neck_price"+index;
	 var idError="errorTitle"+index;
     if(!checkisNumberss($("#"+idName).val())) {
	    $("#"+idError).html("最多只保留小数点后2位的正数");
	    publicOnfocus(idName,idError);
	    return false;
     }else{
  		publicOnRight(idName,idError);
    	return true;
     }
}


//商品sku规格销售价校验
function skuPriceOnkeyup(index){
	 var idName="sku_price"+index;
	 var idError="skuErrorTitle"+index;
     if(!checkisNumberss($("#"+idName).val())) {
	    $("#"+idError).html("最多只保留小数点后2位的正数");
	    publicOnfocus(idName,idError);
	    return false;
     }else{
  		publicOnRight(idName,idError);
    	return true;
     }
}

//商品sku规格市场价校验
function skuMarketOnkeyup(index){
	 var idName="sku_market"+index;
	 var idError="skuMarketTitle"+index;
     if(!checkisNumberss($("#"+idName).val())) {
	    $("#"+idError).html("最多只保留小数点后2位的正数");
	    publicOnfocus(idName,idError);
	    return false;
     }else{
  		publicOnRight(idName,idError);
    	return true;
     }
}

//商品sku规格库存校验
function skuStockOnkeyup(index){
	 var idName="sku_stock"+index;
	 var idError="skuStockTitle"+index;
	 if(!checkisNumbersone($("#"+idName).val())) {
	   $("#"+idError).html("必须为大于0正整数!");
	   publicOnfocus(idName,idError);
	   return false;
	 }else{
		 publicOnRight(idName,idError);
		 if(index=''){
			 $("#"+idError).html(imgPath); 
		 }
	     return true;
	 }
}


//商品统一规格或者多规格重量校验
function onBlurGoodWeight(index){
	 var idName="weight"+index;
	 var idError="weightError"+index;
	 if(!checkisNumberss($("#"+idName).val())) {
	   $("#"+idError).html("最多只保留小数点后2位的正数");
	   publicOnfocus(idName,idError);
	   return false;
	 }else{
		 publicOnRight(idName,idError);
		 if(index=''){
			 $("#"+idError).html(imgPath); 
		 }
	     return true;
	 }
}

//商品自定义销量校验
function onBlurGoodcustomizeStockCount(){
	 var idName="customizeStockCount";
	 var idError="customizeStockCountError";
	 if(!checkisNumbers($("#"+idName).val())) {
	   $("#"+idError).html("必须为大于0正整数!");
	   publicOnfocus(idName,idError);
	   return false;
	 }else{
		 publicOnRight(idName,idError);
		 $("#"+idError).html(imgPath); 
	     return true;
	 }
}



//判断是否可改装
$("input[name=radioRefit]").on("click",function(){
	  var type;
	  var temp = document.getElementsByName("radioRefit");
	  for(var i=0;i<temp.length;i++)
	  {
		if(temp[i].checked)
		type= temp[i].value;
	  }
	  $("#spuType").val(type);
	  //如果是1 则为统一规格,0为多规格
	  if(type=='1'){
		  $("#whetherRefitDivClass").css("display","block");
		  $("#neckTalbe").css("display","block"); 
	  }else{
		  $("#whetherRefitDivClass").css("display","none"); 
		  $("#neckTalbe").css("display","none"); 
	  }
});

//布料信息加载
function loadNecklineInfo(){
	   $("#whetherRefitDivClass").html("");
       $.ajax({
		url:contextPath+"/admin/neck/queryNecklineInfoListToGood",
		type:"get",
		dataType:"html",
		success:function(response){
			$("#whetherRefitDivClass").html(response);
  		}
  	});
}

//判断是否填写多规格
$("input[name=radioSpec]").on("click",function(){
	  var type;
	  var temp = document.getElementsByName("radioSpec");
	  for(var i=0;i<temp.length;i++)
	  {
		if(temp[i].checked)
		type= temp[i].value;
	  }
	  $("#isUnifiedSpecs").val(type);
	  //如果是0则为统一规格,1为多规格
	  if(type=='0'){
		  $("#tyspecDiv").css("display","block");
		  $("#dgespecDiv").css("display","none");
		  $("#createSkuTable").css("display","none");
	  }else{
		 $("#tyspecDiv").css("display","none");
		 $("#dgespecDiv").css("display","block");
		 $("#createSkuTable").css("display","block");
	  }
});

//初始化SKU列表
function initSkuList(id){
   var classId="";
   if(id!=undefined && id!=null &&id!='')
	   classId=id;
   else
	   classId=$("#secondClassId").val();
   $.ajax({
	 url:contextPath+"/admin/sku/list",
	 type:"get",
	 data:{classId:classId},
	 dataType:"html",
	 success:function(response){
		 $(".skuListClassOne").html(response);
		 $(".js_add_spe_form").addClass("hide");
		 $(".js_add_spe_div").removeClass("hide");
		 if($(".skuListClassOne div").length==0){
			 $(".skuListClassOne").addClass("hide");
			 $(".help-block").removeClass("hide");
		 }else{
			 $(".skuListClassOne").removeClass("hide");
			 $(".help-block").addClass("hide");
		 }
	 }
  });
}


//添加SKU属性值
function addSku(){
	var classId=$("#secondClassId").val();
	if(classId==0){
		ohSnap("请先选择商品二级分类!",'black');
		return;
	}
	$(".m-l").addClass("hide");
	$("#skuVal").val("");
	$("#skuItemVal").val("");
	$("#specValClass").html("");
	$(".js_add_spe_form").removeClass("hide");
	$(".js_add_spe_div").addClass("hide");
}
//取消SKU属性值
function  cancleSku(skuId){
	$(".m-l").removeClass("hide");
	$(".js_add_spe_form"+skuId).addClass("hide");
	$(".js_add_spe_div"+skuId).removeClass("hide");
	$(".js_specifica"+skuId).removeClass("hide");
	$("#specvals"+skuId).removeClass("hide");
	$(".js_add_spe_div").removeClass("hide");

}


//添加保存SKU属性值
function addSkuVal(skuId){
 console.log("属性值ID:"+skuId);
 var val=$("#skuItemVal"+skuId).val();
 console.log("属性值："+val);
 var parentSpanVal=$("#"+val+skuId).data("name");
 console.log("######"+parentSpanVal);
 if(val==undefined || val==''){
	ohSnap("亲!属性值不能为空!",'black');
	publicOnfocus("skuItemVal",'');
	return;
 }
 if(parentSpanVal==val){
	ohSnap("亲!【"+val+"】属性值已经存在!",'black');
	publicOnfocus("skuItemVal",'');
	return;
 }
 var spanVal="<span class='js_specvals_result"+skuId+"' style='margin-left:1rem;' data-myid='1' data-name='"+val+"' id='"+val+skuId+"'>"+val+"<i  style='margin-left:.5rem;width:30px; dispaly：inline-block' data-speid=' ' data-id=' '><img  class='removeSpec"+skuId+"' style='width:20px;' src='/yzfs-admin/static/image/icon/new_del.png'/></i></span>";
 var span=$("#specValClass"+skuId).children("span").last();
 if(span.length==0){
	 $("#specValClass"+skuId).append(spanVal); 
 }else{
	 $("#specValClass"+skuId).children("span").last().after(spanVal);
 }
 //移除已经添加的SKU属性值
 $(".removeSpec"+skuId).click(function (){
	 $(this).parent("i").parent("span").remove();
 })
}




//确认添加保存SKU属性以及属性值
function addSkuValSave(skuId){
	var classId=$("#secondClassId").val();
	if(classId==0){
		ohSnap("请先选择商品二级分类!",'black');
		return;
	}
	//校验规格名称是否填写
	var skuVal=$("#skuVal"+skuId).val();
	var id="skuVal";
	if(skuId ==undefined && skuId==''){
	if(skuVal ==undefined || skuVal==''){
		ohSnap("亲!请填写规格名称!",'black');
		publicOnfocus(id,'');
		return;
	}
	}
	
	 var parentSkuVal=$("#sku"+skuVal).data("name");
	 if(parentSkuVal==skuVal){
		ohSnap("亲!【"+parentSkuVal+"】属性已经存在!",'black');
		publicOnfocus(id,'');
		return;
	 }
	var allSkuItemId = "";
    var allSkuItemVal = "";
    $("span[class=js_specvals_result"+skuId+"]").each(function (i) {
        var skuItemVal = $(this).data("name");
        var skuItemId = $(this).data("myid");
        if(skuItemVal!=undefined &&skuItemVal!=''){
        	 allSkuItemVal += skuItemVal + ",";
        }
        if(skuItemId!=undefined &&skuItemId!=''){
        	allSkuItemId += skuItemId + ",";
        }
    });
    var id="skuItemVal";
    if(allSkuItemVal ==undefined || allSkuItemVal ==''){
		ohSnap("亲!至少填写一个规格属性值!",'black');
		publicOnfocus(id,'');
		return;
    }
    
	//开始新增商品SKU属性以及属性值
	$.ajax({
		 url:contextPath+"/admin/sku/addSkuInfo",
		 data:{skuId:skuId,classesId:classId,skuVal:skuVal,allSkuItemId:allSkuItemId,allSkuItemVal:allSkuItemVal},
		 type:"post",
 		 beforeSend: function () {  
			onDialog();
		 },
		 success:function(data){
			 //异步加载SKU属性列表
			 if(data.code==100){
				 offDialog();
				 if(skuId !=undefined && skuId!=''){
					 ohSnap("编辑成功",'black');
				 }else{
					 ohSnap("新增成功",'black');
				 }
				 initSkuList(); 
			 }else{
				 
			 }
		 },
		 error:function(data){
			 ohSnap("系统异常",'black');
		 }
	 });
}

function  editSku(skuId){
	$(".js_specifica"+skuId).addClass("hide");
	$("#specvals"+skuId).addClass("hide");
	$(".js_add_spe_form"+skuId).removeClass("hide");
	$(".js_add_spe_div").addClass("hide");
	$(".m-l").addClass("hide");
	 //移除已经添加的SKU属性值
	 $(".removeSpec"+skuId).click(function (){
		 $(this).parent("i").parent("span").remove();
	 })
}


//删除SKU
function deleteSkuVal(id,name){
	$(".deleteClassTitle").text("确认要删除规格【"+name+"】,以及所属的规格值吗?");
	$("#Delete_S_sure").attr({"onclick":"deleteSkuValSave('"+id+"')"});
	
}

//确认删除SKU属性以及子属性值
function deleteSkuValSave(id){
	//开始新增商品SKU属性以及属性值
	$.ajax({
		 url:contextPath+"/admin/sku/delSkuInfo",
		 data:{skuId:id},
		 type:"post",
 		 beforeSend: function () {  
			onDialog();
		 },
		 success:function(data){
			 //异步加载SKU属性列表
			 if(data.code==100){
				 offDialog();
				 initSkuList(); 
			 }else{
				 
			 }
		 },
		 error:function(data){
			 ohSnap("系统异常",'black');
		 }
	 });
}


//判断是否立即上架
$("input[name=checkboxIsSale]").on("click",function(){
	  var type;
	  var temp = document.getElementsByName("checkboxIsSale");
	  for(var i=0;i<temp.length;i++)
	  {
		if(temp[i].checked)
		type= temp[i].value;
	  }
	  $("#isSale").val(type);
});


//获取光标的公共方法
function publicOnfocus(id,idError){
	 $("#"+id).css({"border-color":"#ff0000"});
	 $("#"+idError).css({"color":"#ff0000"});
	 $("#"+id).focus();
}

//显示正确赋值
function publicOnRight(id,idError){
	 $("#"+id).css({"border-color":"#4aaf00"});
	 $("#"+idError).html("");
}

//查询商品列表
function queryGoodsList(){
	 window.location.href=contextPath+"/admin/good/list";
}








