//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));

$(function() {
	App.init();
	TableEditable.init();
 	loadNecklineTypeInfo();
 	loadNecklineFabricTypeInfo();
 	
	//初始化七牛
	 initQiniu(contextPath+"/admin/qiniu_token", "img_key_one", function(result){
        	var json=strToJson(result);
        	$("#img_key_one").attr("src",$("#qiniupath").val()+json.key);
        	$("#hidden_img_key").val(json.key);
     });
	
		//初始化七牛
	 initQiniu(contextPath+"/admin/qiniu_token", "img_key_two", function(result){
        	var json=strToJson(result);
        	$("#img_key_two").attr("src",$("#qiniupath").val()+json.key);
        	$("#hidden_img_key").val(json.key);
     });
});


//领口设置
function editNecklineType(id,name,picKey){
	clearError();
	if(id !=undefined && id!=''){
		$("#necklineType").val(name);
		$("#img_key_one").attr("src",$("#qiniupath").val() + picKey);
		$("#hidden_img_key").val(picKey);
	}else{
		$("#necklineType").val("");
		$("#img_key_one").attr("src",contextPath+'/static/image/add.png');
		$("#hidden_img_key").val("");
	}
	$("#necklineTypeAdd").attr({"onclick":"editNecklineTypeSave('"+id+"')"});
}

////领口设置保存
function editNecklineTypeSave(id){
	var necklineType=$("#necklineType").val();
	var picKey=$("#hidden_img_key").val();
	if(necklineType==undefined || necklineType==''){
		$("#errorHtml1").html("领口类型不能为空!");
		return;
	}
	if(picKey==undefined || picKey==''){
		$("#errorHtml1").html("领口图片不能为空!");
		return;
	}
	$("#necklineTypeAdd").attr({"data-dismiss":"modal"});
	$.ajax({
		url:contextPath+'/admin/neck/insertNecklineType',
		data:{id:id,necklineType:necklineType,picKey:picKey},
		type:'get',
		success:function(result){
			if(result.code==100){
				ohSnap("操作成功!",'black');
				loadNecklineTypeInfo();
			}else{
				ohSnap(result.msg,'black');
				return;
			}
			
		}
	});
}

//布料设置
function editNecklineFabricType(id,name,picKey){
	clearError();
	if(id!=undefined && id!=''){
		$("#necklineFabricType").val(name);
		$("#img_key_two").attr("src",$("#qiniupath").val()+ picKey);
		$("#hidden_img_key").val(picKey);
	}else{
		$("#necklineFabricType").val("");
		$("#img_key_two").attr("src",contextPath+'/static/image/add.png');
		$("#hidden_img_key").val("");
	}
	$("#necklineFabricTypeAdd").attr({"onclick":"editNecklineFabricTypeSave('"+id+"')"});
}
//布料设置保存
function editNecklineFabricTypeSave(id){
	var necklineType=$("#necklineFabricType").val();
	var picKey=$("#hidden_img_key").val();
	if(necklineType==undefined || necklineType==''){
		$("#errorHtml2").html("布料类型不能为空!");
		return;
	}
	if(picKey==undefined || picKey==''){
		$("#errorHtml2").html("布料图片不能为空!");
		return;
	}
	$("#necklineFabricTypeAdd").attr({"data-dismiss":"modal"});
	$.ajax({
		url:contextPath+'/admin/neck/insertNecklineFabricType',
		data:{id:id,necklineType:necklineType,picKey:picKey},
		type:'get',
		success:function(result){
			if(result.code==100){
				ohSnap("操作成功!",'black');
				loadNecklineFabricTypeInfo();
			}else{
				ohSnap(result.msg,'black');
				return;
			}
		}
	});
}


//根据ID删除领口信息
function deleteNeckType(id){
	$("#Delete_S_sure").click(function(){
		$.ajax({
			url:contextPath+'/admin/neck/updateNecklineTypeByParams',
			data:{id:id},
			type:'get',
			success:function(result){
				if(result.code==100){
					ohSnap("删除成功",'black');
					loadNecklineTypeInfo();
				}else{
					ohSnap(result.msg,'black');
					return;
				}
			}
		});
	});
}

//根据ID删除布料信息
function deleteNeckFabricType(id){
	$("#Delete_S_sure").click(function(){
		$.ajax({
			url:contextPath+'/admin/neck/updateNecklineFabricTypeByParams',
			data:{id:id},
			type:'get',
			success:function(result){
				if(result.code==100){
					ohSnap("删除成功",'black');
					loadNecklineFabricTypeInfo();
				}else{
					ohSnap(result.msg,'black');
					return;
				}
				
			}
		});
	});
}

//清空错误标签提示
function clearError(){
	$("#errorHtml1").html("");
	$("#errorHtml2").html("");
}

//领口信息加载
function loadNecklineTypeInfo(){
	   $(".tbodyClassOne").html("");
       $.ajax({
    		url:contextPath+"/admin/neck/queryNecklineTypeList",
    		type:"get",
    		dataType:"html",
    		beforeSend: function () {  
    			onDialog();
    		},
    		success:function(response){
    			$(".tbodyClassOne").html(response);
    		    if($(".tbodyClassOne tr").length==0){
    		        var newsTr="<tr><td class='empty'></td><td class='red-text' style='text-align:center' colspan='3'>暂无数据显示!</td></tr>";
    		        $(".tbodyClassOne").append(newsTr)
    		    }
    		    TableEditable.init();
    		},
            complete: function () {  
    			offDialog();
    	    },
    	    error: function (response) {  
    	        console.info("error: " + data.responseText);  
    	    } 
    	});
 }

//布料信息加载
function loadNecklineFabricTypeInfo(){
	   $(".tbodyClassTwo").html("");
       $.ajax({
    		url:contextPath+"/admin/neck/queryNecklineFabricTypeList",
    		type:"get",
    		dataType:"html",
    		success:function(response){
    			$(".tbodyClassTwo").html(response);
    		    if($(".tbodyClassTwo tr").length==0){
    		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='3'>暂无数据显示!</td></tr>";
    		        $(".tbodyClassTwo").append(newsTr)
    		    }
    		    TableEditable.init();
    		},    		
            complete: function () {  
    			offDialog();
    	    },    	    
    	    error: function (response) {  
    	        console.info("error: " + data.responseText);  
    	    } 
    	});
 }