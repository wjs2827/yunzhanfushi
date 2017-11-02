//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
$(function() {
	App.init();
	initFirstClass('','','');
	TableAdvanced.init();
	//加载首页分类展示
	loadHomeCategoryInfo();
	$(".dataTables_paginate").empty();
	
	//初始化七牛
	 initQiniu(contextPath+"/admin/qiniu_token", "img_keys", function(result){
        	var json=strToJson(result);
        	$("#img_keys").attr("src",$("#qiniupath").val()+json.key);
        	$("#hidden_img_key").val(json.key);
     });
	
		//初始化七牛
	 initQiniu(contextPath+"/admin/qiniu_token", "img_key_one", function(result){
        	var json=strToJson(result);
        	$("#img_key_one").attr("src",$("#qiniupath").val()+json.key);
        	$("#hidden_img_key").val(json.key);
     });
	 
		
		//初始化七牛
	 initQiniu(contextPath+"/admin/qiniu_token", "home_img_key_one", function(result){
     	var json=strToJson(result);
     	$("#home_img_key_one").attr("src",$("#qiniupath").val()+json.key);
     	$("#hidden_img_key").val(json.key);
  });
});

if($(".tbodyClassOne tr").length==0){
    var newsTr="<tr><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='empty'></td><td class='red-text' style='text-align:center' colspan='9'>暂无数据显示!</td></tr>"
    	$(".tbodyClassOne").append(newsTr)
 }

//清空错误标签提示
function clearError(){
	$("#errorHtml").html("");
	$("#errorHtml1").html("");
}


/*商城首页管理开始*/		

//初始化一级分类
function initFirstClass(fid,sid,pid){
	clearError();
	document.getElementById("firstClassId").innerHTML = "";
		$.ajax({
			url:contextPath+'/admin/classes/selectFirstClass',
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(fid==undefined || fid ==''){
				      html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(fid==goodClasses[i].id){
					   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
					   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#firstClassId").append(html);
				if(sid !=undefined && sid !=''){
					initSecondClass(fid,sid,pid);
				}
			}
		});		
}

//加载二级分类
function initSecondClass(fid,sid,pid){
	clearError();
	document.getElementById("secondClassId").innerHTML = "";
	document.getElementById("select_good").innerHTML = "";
	var id=$("#firstClassId").val();
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId='+fid,
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(sid==undefined || sid ==''){
					   html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(sid==goodClasses[i].id){
						   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
						   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#secondClassId").append(html);
				if(pid !=undefined && pid !=''){
					initClassGoods(sid,pid);
				}
			}
		});	
}

//初始化商品信息
function initClassGoods(sid,goodId){
	clearError();
	document.getElementById("select_good").innerHTML = "";
	 $.ajax({
			url:contextPath+'/admin/good/listGoods',
			data:{"classId":sid},
			type:'post',
			success:function(result){
				var goods=result.goods;
				var html="";
				if(goodId==undefined || goodId ==''){
					   html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goods.length; i++) {
					if (goodId!=null&&goodId==goods[i].id) {
						html+="<option selected value='"+goods[i].id+"'>"+goods[i].name+"</option>";
					} else {
						html+="<option value='"+goods[i].id+"'>"+goods[i].name+"</option>";
					}
					
				}
				$("#select_good").html(html);
			}
		});
	
}



 
//初始化二级级分类
 $("#firstClassId").change(function(){
	 clearError();
	document.getElementById("secondClassId").innerHTML = "";
	document.getElementById("select_good").innerHTML = "";
	var id=$("#firstClassId").val();
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId='+id,
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="<option value=''>--请选择--</option>";
				for (var i = 0; i < goodClasses.length; i++) {					
					html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
				}
				$("#secondClassId").append(html);
			}
		});	
 });

//初始化商品列表
 $("#secondClassId").change(function(){
	clearError();
	document.getElementById("select_good").innerHTML = "";
	//如果type不是商品
	var id=$("#secondClassId").val();
	var goodId="";
	 $.ajax({
			url:contextPath+'/admin/good/listGoods',
			data:{"classId":id},
			type:'post',
			success:function(result){
				var goods=result.goods;
			    var html="";
				for (var i = 0; i < goods.length; i++) {
					if (goodId!=null&&goodId==goods[i].id) {
						html+="<option selected='selected' value='"+goods[i].id+"'>"+goods[i].name+"</option>";
					} else {
						html+="<option value='"+goods[i].id+"'>"+goods[i].name+"</option>";
					}
					
				}
				$("#select_good").html(html);
			}
		});
	 });

//新增商城首页
function addFirstPic(){
	clearError();
	$("#target_type").find("option").eq(0).attr({"selected":"selected"})
	changeType("0");
	$("#picType").val("0");
	$("#firstId").val("");
	$("#img_keys").attr("src",contextPath+'/static/image/add.png');
	$("#input_url").val("");
	$("#rank").val("");
	$("#firstId").val("");
	$("#hidden_img_key").val("")
	document.getElementById("secondClassId").innerHTML = "";
	document.getElementById("select_good").innerHTML = "";
	initFirstClass('','','');
}


//首页首页编辑
function edithome(id,picKey,targetType,targetId,linkUrl,rank){
	clearError();
	changeType(targetType);
	$("#picType").val(0);
	$("#target_type").val(targetType);	
	$("#img_keys").attr("src",$("#qiniupath").val()+ picKey);
	$("#input_url").val(linkUrl);
	$("#rank").val(rank);
	$("#firstId").val(id);
	$("#hidden_img_key").val(picKey)
	$.ajax({
		url:contextPath+'/admin/home/editFirstPage?pid='+targetId,
		type:'post',
		success:function(result){
			var goodClasses=result.goodClass;
			initFirstClass(goodClasses.parentId,goodClasses.id,targetId);
		}
	});	
}

//商城首页编辑保存
$("#User_Usure").unbind("click").click(function() {
	var targetType=$("#target_type").val();
	var targetId;
	var linkUrl;
	var sign=0;
	if(targetType !=undefined && targetType==0){
		targetId=$("#select_good").val();
		if(targetId ==undefined || targetId==''){
		 $("#errorHtml").html("请根据分类选择商品!");
		 sign=1;
		 return;
		}
	}
	if(targetType !=undefined && targetType==2){
		linkUrl=$("#input_url").val();
		if(linkUrl ==undefined || linkUrl ==''){
			 $("#errorHtml").html("请填写链接地址!");
			 sign=1;
			 return;
		}
	}
	if(sign==0){
		$("#User_Usure").attr({"data-dismiss":"modal"});
		$.ajax({
			url :contextPath+'/admin/home/edit',
			data : {id: $("#firstId").val(),
				    picType : $("#picType").val(),
				    picKey : $("#hidden_img_key").val(),
				    targetType : targetType,
				    targetId : targetId,
				    linkUrl :linkUrl,
				    rank:$("#rank").val()
			       },
		 	type:'post',
		 	success:function(result){
		 		if (result.code=="0") {
		 			ohSnap(result.message,'black');
					location.reload();
				} else {
					ohSnap(result.message,'black');
				}
		 		$("#User_Usure").attr({"data-dismiss":""});
		 	},
		 	error:function(){
		 		$("#User_Usure").attr({"data-dismiss":""});
		 		ohSnap('网络异常，请重','black');
		 	}

		});
	 }
 });


//分类切换
function changeType(targetType){
	clearError();
	switch (targetType) {
	//商品
	case '0':
		$("#div_link").css("display","none");
		$("#div_target").css("display","block");
		$("#div_shop").css("display","block");
		$("#first_fenlei").css("display","block");
		$("#second_fenlei").css("display","block");
		$("#div_good").css("display","block");
		break;
   //店铺
	case '1':
	
		$("#div_link").css("display","none");
		$("#div_target").css("display","block");
		$("#div_shop").css("display","block");
		$("#div_good").css("display","none");
		$("#div_fenlei").css("display","none");
		break;
	//链接
	case '2':
		
		$("#div_link").css("display","block");
		$("#div_target").css("display","block");
		$("#div_shop").css("display","none");
		$("#first_fenlei").css("display","none");
		$("#second_fenlei").css("display","none");
		$("#div_good").css("display","none");
		break;
	//分类
	case '3':
		alert();
		$("#div_link").css("display","none");
		$("#div_target").css("display","none");
		$("#div_shop").css("display","none");
		$("#div_good").css("display","none");
		$("#div_fenlei").css("display","block");
		break;
	default:
		break;
	}
}


/*商城首页管理结束*/	


/*商城分类管理开始*/	


//初始化一级分类
function initFirstClassOne(fid,sid){
	clearError();
	document.getElementById("firstClassId").innerHTML = "";
		$.ajax({
			url:contextPath+'/admin/classes/selectFirstClass',
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(fid==undefined || fid ==''){
				      html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(fid==goodClasses[i].id){
					   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
					   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#firstClassIdOne").append(html);
				if(sid !=undefined && sid !=''){
					initSecondClassTwo(fid,sid);
				}
			}
		});		
}

//加载二级分类
function initSecondClassTwo(fid,sid){
	clearError();
	document.getElementById("secondClassId").innerHTML = "";
	var id=$("#firstClassId").val();
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId='+fid,
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(sid==undefined || sid ==''){
					   html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(sid==goodClasses[i].id){
						   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
						   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#secondClassIdTwo").append(html);
			}
		});	
}

//初始化二级级分类
 $("#firstClassIdOne").change(function(){
	clearError();
	document.getElementById("secondClassIdTwo").innerHTML = "";
	var id=$("#firstClassIdOne").val();
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId='+id,
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="<option value=''>--请选择--</option>";
				for (var i = 0; i < goodClasses.length; i++) {					
					html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
				}
				$("#secondClassIdTwo").append(html);
			}
		});	
 });
//新增商城分类
function addFirstClass(){
	clearError();
	changeFirstClass();
	document.getElementById("firstClassIdOne").innerHTML = "";
	document.getElementById("secondClassIdTwo").innerHTML = "";
	$("#target_type").val(3);	
	$("#picType").val(1);
	$("#firstId").val("");
	$("#classRank").val("");
	$("#img_key_one").attr("src",contextPath+'/static/image/add.png');
	initFirstClassOne('','');
}	



//编辑商城分类
function editFirstClass(id,picKey,targetType,targetId,rank){
	clearError();
	changeFirstClass();
	document.getElementById("firstClassIdOne").innerHTML = "";
	document.getElementById("secondClassIdTwo").innerHTML = "";
	$("#picType").val(1);
	$("#img_key_one").attr("src",$("#qiniupath").val()+ picKey);
	$("#firstId").val(id);
	$("#classRank").val(rank)
	$("#hidden_img_key").val(picKey);
	$.ajax({
		url:contextPath+'/admin/home/editFirstClass?pid='+targetId,
		type:'post',
		success:function(result){
			var goodClasses=result.goodClass;
			initFirstClassOne(goodClasses.parentId,goodClasses.id);
		}
	});	
}


//商城分类编辑保存
$("#class_add").unbind("click").click(function() {
	var firstClassIdOne=$("#firstClassIdOne").val();
	var secondClassIdTwo=$("#secondClassIdTwo").val();
	if(firstClassIdOne !=undefined && firstClassIdOne==''){
		$("#errorHtml1").html("请选择一级分类!");
		return;
	}
	else if(secondClassIdTwo !=undefined && secondClassIdTwo==''){
		$("#errorHtml1").html("请选择二级分类!");
		return;
	}
	else{
		$("#class_add").attr({"data-dismiss":"modal"});
		$.ajax({
			url : contextPath+'/admin/home/edit',
			data : {id: $("#firstId").val(),
			    picType : $("#picType").val(),
			    picKey : $("#hidden_img_key").val(),
			    targetType : 3,
			    targetId :secondClassIdTwo,
			    linkUrl : $("#input_url").val(),
			    rank:$("#classRank").val()
		       },
		 	type:'post',
		 	success:function(result){
		 		if (result.code=="0") {
		 			ohSnap(result.message,'black');
					location.reload();
				} else {
					ohSnap(result.message,'black');
				}
		 		$("#class_add").attr({"data-dismiss":""});
		 	},
		 	error:function(){
		 		$("#User_Usure").attr({"data-dismiss":""});
		 		ohSnap("网络异常，请重试",'black');
		 	}

		});
	}
 });

//隐藏相关文本
function changeFirstClass(){
	$("#div_link").css("display","none");
	$("#div_target").css("display","none");
	$("#div_shop").css("display","none");
	$("#first_fenlei").css("display","block");
	$("#second_fenlei").css("display","block");
	$("#div_good").css("display","none");
}

//删除图片
function del(id){
	$("#Delete_S_sure").unbind("click").click(function() {
		$.ajax({
			url : contextPath+'/admin/home/delete',
			data : { "picId" : id },
		 	type:'post',
		 	success:function(result){
		 		if (result.code=="0") {
		 			ohSnap("删除成功",'black');
					location.reload();
				} else {
					ohSnap(result.message,'black');
				}
		 	},
		 	error:function(){
		 		ohSnap("网络异常，请重试",'black');
		 	}

		});
	});
}

//验证
function verify(){
	 $("#shop").css({"display":"none"});
	 $("#good").css({"display":"none"});
	 $("#classify").css({"display":"none"});
	 $("#url").css({"display":"none"});
	 $("#picture").css({"display":"none"});
	 changeType($("#target_type").val());
}
function verify1(obj){
	   $("#shop").css({"display":"none"});
	   var button =document.getElementById("User_Usure");
	   button.disabled=true;
	   if(obj==""){
			 $("#shop").css({"display":"block"});;//显
		}else{
			 button.disabled=false;
		} 
}
function verify2(obj){
	   $("#good").css({"display":"none"});
	   var button =document.getElementById("User_Usure");
	   button.disabled=true;
	   if(obj==""){
			 $("#good").css({"display":"block"});;//显
		}else{
			 button.disabled=false;
		} 
}
function verify3(obj){
	   $("#classify").css({"display":"none"});
	   var button =document.getElementById("User_Usure");
	   button.disabled=true;
	   if(obj==""){
			 $("#classify").css({"display":"block"});;//显
		}else{
			 button.disabled=false;
		} 
}
function verify4(obj){
	   $("#url").css({"display":"none"});
	   var button =document.getElementById("User_Usure");
	   button.disabled=true;
	   if(obj==""){
			 $("#url").css({"display":"block"});;//显
		}else{
			 button.disabled=false;
		} 
}
function verify5(){
	   $("#picture").css({"display":"none"});
	   var button =document.getElementById("User_Usure");
	   button.disabled=true;
		var filePic=$("#img_key").attr("src");
		if(filePic==""){
			 $("#picture").css({"display":"block"});;//显
		}else{
			 button.disabled=false;
		}  
}
function verify6(){
   var url=$("#target_type").val();
   var button =document.getElementById("User_Usure");
   button.disabled=true;
   var shop=$("#select_shop").val();
	   var good=$("#select_good").val();
	   var input_url=$("#input_url").val();
	   var select_fenlei=$("#select_fenlei").val();
	   var filePic=$("#img_keys").attr("src");
   if(url=="0"){
	   if(shop!="" && good!="" && filePic !=""){
		   button.disabled=false;
	   }
   }else if(url=="1"){
	   if(shop!="" && filePic!=""){
		   button.disabled=false;
	   }
   }else{
	   if(select_fenlei!="" && filePic!=""){
		   button.disabled=false;
	   }
   } 
}


// 商品分类展示异步加载
	function loadHomeCategoryInfo(){
		   $(".homeCateContentClass").html("");
	       $.ajax({
    		url:contextPath+"/admin/home/queryHomeCategoryPatch",
    		type:"get",
    		dataType:"html",
    		beforeSend: function () {  
    			onDialog();
    		}, 
    		success:function(response){
    			$(".homeCateContentClass").html(response);
    		    if($(".homeCateContentClass div").length==0){
    		        var newsTr="<tr><td class='red-text' style='text-align:center'>暂无数据显示!</td></tr>"
    		        	$(".homeCateContentClass").append(newsTr)
    		    }else
    		      TableEditable.init();
    		},		
    		complete: function () {  
    			offDialog();
    	    },
    	    error: function (response) {  
    	        console.info("error: " + response.responseText);  
    	    } 
    	});
 }
	
	
	
	
	 //新增分类展示
	function addHomeCate(){
		clearError();
		document.getElementById("homeCateClassOne").innerHTML = "";
		document.getElementById("homeCateClassTwo").innerHTML = "";
		$("#homeCateRank").val("");
		initHomeClassOne('','');
		$("#homeCategorySet").attr({"onclick":"addHomeCateSave()"});
	}
	   
	    //保存新增分类
	function addHomeCateSave(){
		var cateOne=$("#homeCateClassOne").val();
		var cateTwo=$("#homeCateClassTwo").val();
		var homeCateClass='';
		var type='';
		var rank=$("#homeCateRank").val();
		if(cateOne==undefined || cateOne==''){
			$("#homeCateErrorHtml").html("请选择分类!");
			return;
		}
		if(cateTwo !=undefined && cateTwo!=''){
			homeCateClass=cateTwo;
			type=2;
		}else{
			homeCateClass=cateOne;
			type=1;
		}
		$("#homeCategorySet").attr({"data-dismiss":"modal"});
		$.ajax({
			url:contextPath+'/admin/home/insertHomeCategory',
			data:{homeCateClass:homeCateClass,homeCateType:type,homeCateRank:rank},
			type:'post',
			success:function(result){
				if(result.code==100){
					ohSnap(result.msg,'black');
					loadHomeCategoryInfo();
				}else{
					$("#homeCateErrorHtml").html(result.msg);
					return;
				}
				
			}
		});	
		
	}
	    
	    //确认删除分类
	    function deleteCateGory(id){
	    	$("#Delete_S_sure").click(function(){
				$.ajax({
					url:contextPath+'/admin/home/updateCategoryById',
					data:{id:id},
					type:'post',
					success:function(result){
						if(result.code==100){
							loadHomeCategoryInfo();
						}else{
							alert(result.msg);
							return;
						}
						
					}
				});
	    	});
	    	
	    }
	   

 	//新增分类展示商品
	function addHomeCateProduct(id,categoryId,categoryName,type){
		clearError();
		$("#homeCateP").html("");
		$("#homeCateP").html(categoryName);
		$("#hidden_img_key").val("");
		$("#home_img_key_one").attr("src",contextPath+'/static/image/add.png');
		initHomeCateGoods(categoryId,'',type);
		$("#homeCategoryProductSet").attr({"onclick":"addHomeCateProductSave('"+id+"')"});
	}
 	
	//新增分类展示商品保存
	function addHomeCateProductSave(id){
		var cate_select_good=$("#cate_select_good").val();
		var homeCateRankP=$("#homeCateRankP").val();
		var hidden_img_key=$("#hidden_img_key").val();
		if(cate_select_good==undefined || cate_select_good==''){
			$("#homeCatePErrorHtml").html("请选择商品!");
			return;
		}
		if(hidden_img_key==undefined || hidden_img_key==''){
			$("#homeCatePErrorHtml").html("请上传图片!");
			return;
		}
		$("#homeCategoryProductSet").attr({"data-dismiss":"modal"});
		$.ajax({
			url:contextPath+'/admin/home/insertHomeCategoryProduct',
			data:{homeCateId:id,homeCateRankP:homeCateRankP,goodId:cate_select_good,spuKey:hidden_img_key},
			type:'post',
			success:function(result){
				if(result.code==100){
					ohSnap(result.msg,'black');
					loadHomeCategoryInfo();
				}else{
					$("#homeCatePErrorHtml").html(result.msg);
					return;
				}
				
			}
		});	
		
	}
	    
	    //确认删除分类商品
	    function deleteCateProduct(id,name){
	    	$("#Delete_S_sure").click(function(){
				$.ajax({
					url:contextPath+'/admin/home/deleteHomeCategoryProduct',
					data:{id:id},
					type:'post',
					success:function(result){
						if(result.code==100){
							ohSnap(result.msg,'black');
							loadHomeCategoryInfo();
						}else{
							alert(result.msg);
							return;
						}
						
					}
				});
	    	});
	    	
	    }
 	
 	
 	
 	   
	//初始化商品信息
	function initHomeCateGoods(sid,goodId,type){
		clearError();
		document.getElementById("cate_select_good").innerHTML = "";
		 $.ajax({
				url:contextPath+'/admin/home/listGoodsByClassId',
				data:{"classId":sid,type:type},
				type:'post',
				success:function(result){
					var goods=result.goods;
					var html="";
					if(goodId==undefined || goodId ==''){
						   html="<option value=''>--请选择--</option>";
					}
					for (var i = 0; i < goods.length; i++) {
						if (goodId!=null&&goodId==goods[i].id) {
							html+="<option selected value='"+goods[i].id+"'>"+goods[i].name+"</option>";
						} else {
							html+="<option value='"+goods[i].id+"'>"+goods[i].name+"</option>";
						}
						
					}
					$("#cate_select_good").html(html);
				}
			});
		
	}





//初始化一级分类
function initHomeClassOne(fid,sid){
	clearError();
	document.getElementById("homeCateClassOne").innerHTML = "";
		$.ajax({
			url:contextPath+'/admin/classes/selectFirstClass',
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(fid==undefined || fid ==''){
				      html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(fid==goodClasses[i].id){
					   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
					   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#homeCateClassOne").append(html);
				if(sid !=undefined && sid !=''){
					initHomeClassTwo(fid,sid);
				}
			}
		});		
}

//加载二级分类
function initHomeClassTwo(fid,sid){
	clearError();
	document.getElementById("homeCateClassTwo").innerHTML = "";
	var id=$("#firstClassId").val();
		$.ajax({
			url:contextPath+'/admin/classes/queryErji?parentId='+fid,
			type:'post',
			success:function(result){
				var goodClasses=result.goodClass;
				var html="";
				if(sid==undefined || sid ==''){
					   html="<option value=''>--请选择--</option>";
				}
				for (var i = 0; i < goodClasses.length; i++) {	
					if(sid==goodClasses[i].id){
						   html+="<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}else{
						   html+="<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>";
					}
				}
				$("#homeCateClassTwo").append(html);
			}
		});	
}

function refresh() {
	window.location.href=contextPath+"/admin/home/index";
}