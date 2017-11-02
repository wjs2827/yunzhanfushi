
//图片的绝对路径
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
//打勾的图片
var imgPath="<img style='width:30px;' src='"+contextPath+"/static/image/icon/isTrue.png'/>";


//提交商品信息
$("#save").click(function (){
	var isTrue=false;
	 $("#desContent").val($(".note-editable").html());
	//验证排序
	if(!onBlurTitle())
		return;
	//如果验证成功，提交商品
	var selfgoods = $("form[name=selfgoods]");
	 $("#desContent").val($(".note-editable").html());
	 $.ajax({
		 url:contextPath+"/admin/help/edit",
		 data:selfgoods.serialize(),
		 type:"POST",
		 success:function(data){
			 if(data.code==100){
				 ohSnap(data.msg,'black');
			 }else{
				 ohSnap(data.msg,'black');
			 }
		 },
		 error:function(data){
			 ohSnap("系统异常",'black');
		 }
	 });
 });


//标题校验
function onBlurTitle(){
	 var idName="title";
	 var idError="titleError";
	 if($("#title").val()==undefined || $("#title").val()==0){
		   ohSnap('标题不能为空!','black');
		   publicOnfocus(idName,idError);
		   return false;
	 }else{
	   publicOnRight(idName,idError);
	   $("#"+idError).html(imgPath);
	   return true;
	 }
}




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









