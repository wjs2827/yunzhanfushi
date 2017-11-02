
//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
//分类一级加载
$(function(){
	$.ajax({
		url:contextPath+'/admin/classes/queryErji?parentId=&date='+new Date(),
		dataType:'json',
		success:function(json){
			var goodClasses=json.goodClass;
			$("#secondClassId").append("<option value=''>全部二级分类</option>");
			for(var i=0;i<goodClasses.length;i++){
				if('${params.classesId}'==goodClasses[i].id){
				    $("#secondClassId").append("<option selected value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>");
				}else{
					$("#secondClassId").append("<option value='"+goodClasses[i].id+"'>"+goodClasses[i].name+"</option>");	
				}
			}
		}
	})
})

//商品列表信息加载
function initGoodList(){
       $.ajax({
    		url:contextPath+"/admin/good/initGoodList",
    		type:"get",
    		data:{goodName:$("#paramGoodName").val(),isSale:$("#is_sale_value").val(),classId:$("#secondClassId").val()},
    		dataType:"html",
    		beforeSend: function () {  
    			onDialog();
    		},
    		success:function(response){
    			$(".tbodyClassOne").html(response);
    		    if($(".tbodyClassOne tr").length==0){
    		        var newsTr="<tr><td class='red-text' style='text-align:center' colspan='11'>暂无数据显示!</td></tr>"
    		        	$(".tbodyClassOne").append(newsTr)
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

//单个商品删除
function updateIsDel(id){
  var  isSale=$("#is_sale_value").val();
  $("#titleSale").html("确认要删除该商品吗?");
  $("#IsSaleBtn").attr("onclick","confirmBatchUpdateDel('"+id+"','"+isSale+"')");   
}


//确认删除
function confirmBatchUpdateDel(id,isSale){
 $("#static1").removeClass("in");
	$("#static1").css({"display":"none"});
		$(".modal-backdrop").removeClass('modal-backdrop');
    $.ajax({
    	url: contextPath+"/admin/good/delete",
        data:{id:id},
        dataType:'json',
		beforeSend: function () {  
			onDialog();
		},
        success: function (data) {
        	offDialog();
            if(data.code==100){
            	ohSnap(data.message,'black');
            	initGoodList();
            }else{
            	ohSnap(data.message,'black');
            	initGoodList();
            }
        },
        error: function(data) {
        	ohSnap("error:"+data.responseText,'black');
        }
    });
}

 //刷新页面
 function refresh() {
	 publicSearch();
 }
 	
 
 //公共查询方法
 function publicSearch(){
	$("#goodsForm").attr({"action":contextPath+"/shop/goods/list"}); 
	$("#goodsForm").submit();
 }
 
 //单个商品上下架
 function updateIsSale(id,status){
	 var title;
	 var sign;
	 if(status==1){
		 title="确认要上架该商品吗?";
		 sign=1;
	 }else{
		 title="确认要下架该商品吗?";
		 sign=2;
	 }
	 $("#titleSale").html(title);
	 $("#IsSaleBtn").attr("onclick","confirmUpdateIsSale('"+id+"','"+status+"','"+sign+"','')");
 }
 
 //单个商品上下架
 function confirmUpdateIsSale(id,status,sign,isSale){
	 $("#static1").removeClass("in");
	 $("#static1").css({"display":"none"});
	 $(".modal-backdrop").removeClass('modal-backdrop');
     $.ajax({
         url: contextPath+"/admin/good/updateIsSale",
         data:{isSale:status,id:id,sign:sign},
         dataType:'json',
 		 beforeSend: function () {  
			onDialog();
		 },
         success: function (data) {
        	 offDialog();
             if(data.code==100){
            	 ohSnap(data.message,'black');
            	 initGoodList();
             }else{
            	 ohSnap(data.message,'black');
            	 initGoodList();
             }
         },
         error: function(data) {
        	 ohSnap("error:"+data.responseText,'black');
         }
     });
 }
 
 //批量上下架
  function batchUpdateIsSale(){
	var  isSale=$("#is_sale_value").val();
   	var  allGoodId=$("#sale_good_id").val();
    var sign;
    var title;
    var status;
   	if(allGoodId==undefined || allGoodId==''){
   		var msg;
   		if(isSale !=undefined && isSale !='1'){
   			msg="亲!请选择上架的商品!";
   		}else{
   			msg="亲!请选择下架的商品!";
   		}
   		alert(msg);
   		return;
   	}else{
   		$("#static1").addClass("in");
   		$("#static1").css({"display":"block"});
   		$("body").append('<div class="modal-backdrop fade in"></div>');
   		$(".delete-s-cancel").click(function(){
   			$("#static1").removeClass("in");
       		$("#static1").css({"display":"none"});
   			$(".modal-backdrop").removeClass('modal-backdrop');
   		})
   		if(isSale !=undefined && isSale !='1'){
   			sign=3;
   		    title="确认要批量上架商品吗?";
   		    status=1;
   		}else{
   			sign=4;
   		    title="确认要批量下架商品吗?";
   		    status=0;
   		}
   	    $("#titleSale").html(title);
 	   $("#IsSaleBtn").attr("onclick","confirmUpdateIsSale('"+allGoodId+"','"+status+"','"+sign+"','"+isSale+"')");   
 }
  };
 
 //全选和反选
  $("#AllChecked").click(function(){  
 	 $("#sale_good_id").val("");
 	 var goodId='';
 	/*  var checkboxs=$(".checkedClass"); */
 	 if($("#AllChecked").attr("src")==contextPath+"/static/image/kong.png"){
    	for (var i=0;i<$(".checkedClass").length;i++) {
    	  goodId+=$(".checkedClass").eq(i).attr("id")+",";
    	  $(".checkedClass").eq(i).attr({"src":contextPath+"/static/image/zhong.png"});
    	 }
          $("#AllChecked").attr({"src":contextPath+"/static/image/zhong.png"});
          $("#find_stor").attr("style","block");
 	 }else{
 		 $("#AllChecked").attr({"src":contextPath+"/static/image/kong.png"});
    	 for (var i=0;i<$(".checkedClass").length;i++) {
    	  $(".checkedClass").eq(i).attr({"src":contextPath+"/static/image/kong.png"});
    	 }
    	 $("#find_stor").attr("style","none");
 	 }
 	$("#sale_good_id").val(goodId);
 }); 
 
 //单选
 function userChecd(id){
	 $("#sale_good_id").val("");
	 if($("#"+id).attr("src")==contextPath+"/static/image/kong.png"){
		 $("#"+id).attr({"src":contextPath+"/static/image/zhong.png"});
	 }else{
		 $("#"+id).attr({"src":contextPath+"/static/image/kong.png"});
	 }
 	 var sign=0;
 	 var checkboxs=document.getElementsByName("userCk");
 	 var goodId='';
 	 var sign=0;
     for (var i=0;i<$(".checkedClass").length;i++) {
       if($(".checkedClass").eq(i).attr("src")==contextPath+"/static/image/zhong.png"){
    	   goodId+=$(".checkedClass").eq(i).attr("id")+",";
    	   sign+=1;
       }
 	 }
     if(sign!=$(".checkedClass").length){
       $("#AllChecked").attr({"src":contextPath+"/static/image/kong.png"});
     }else{
       $("#AllChecked").attr({"src":contextPath+"/static/image/zhong.png"});
     }
     if(sign!=0){
    	$("#find_stor").attr("style","block");
     }else{
    	$("#find_stor").attr("style","none");
     }
 	 $("#sale_good_id").val(goodId);
 };
 
 //克隆商品
 function copyGood(id,name){
	 $("#copyTitle").html("你确定要克隆商品【<span style='color:red;'>"+name+"</span>】吗?");
	 $("#confirmCopy").attr("onclick","confirmCopyGood('"+id+"')");   
 }
 //确认克隆商品
 function confirmCopyGood(id){
     $.ajax({
     	url: contextPath+"/shop/goods/copyGoodInfo",
         data:{id:id},
         dataType:'json',
         success: function (json) {
        	 ohSnap(json.msg,'black');
               publicSearch();
         },error:function(json){
        	 ohSnap('网络异常,请稍后再试....','black');
         }
     });
	 
 }
 
 
 //商品导出
 function excelOut(){
     $("#goodsForm").attr({"action":contextPath+"/shop/goods/csvGoodsOut"});
     $("#goodsForm").submit();
 }