// 全局变量
var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
sessionStorage.choose="";
/*发送验证码*/
$(".getcode").click(function(){
    var $this = $(this),
        $time = 60;
    if(!$this.hasClass("gray")){
        $this.addClass("gray").html("重新获取（60）");

        showTime();
    }
    function showTime(){
        if($time ==0){
            $this.removeClass("gray").html("获取验证码");
        }else{
            $this.text("重新获取("+$time+")");
            setTimeout(showTime,1000);
            $time--;
        }
    }

})


//$(function(){

  // 初始化数量
      if(sessionStorage.choose==""){
    	  var L=0;
      }else{
    	  var L= sessionStorage.choose.split(",").length;
      }
      console.log("sessionStorage.choose=="+sessionStorage.choose.split(",")+"初始化的选中数量"+L);
//      var L = $(".radiohover").length;
      $(".number").html(L);
  // 初始化总价
      var totalprice=0; 

      function totalprice1(){
        $(".radiohover").each(function(){
           totalprice+=parseInt($(this).siblings(".price").find(".per-price").html())
        })
        $(".total-price").html(totalprice)
      }
      totalprice1();
  // 爱发声 radio
	  var pricenum=$(".total-price").html()
	  $(".radio").each(function(){
	    $(this).click(function(){
	      if($(this).hasClass("radiohover")){
	         $(this).removeClass("radiohover");
	         if(sessionStorage.choose.indexOf($(this).attr("value"))!=-1){
	        	 sessionStorage.choose=sessionStorage.choose.replace($(this).attr("value")+",","");
	          }
	        pricenum=parseInt(pricenum-$(this).siblings(".price").find(".per-price").html())
	        
	            // 数量
		        var m =parseInt($(".number").html())-1 ;
		        if(parseInt(m)<=0){
		        	m=0;
		        }
		        $(".number").html(m);
		        
	      }else{
	        $(this).addClass("radiohover");
	        sessionStorage.choose=sessionStorage.choose+$(this).attr("value")+",";
	        pricenum=parseInt(pricenum+parseInt($(this).siblings(".price").find(".per-price").html()));
	        
	        // 数量
//	      var m = $(".radiohover").length;
	        var m =parseInt($(".number").html())+1 ;
	        $(".number").html(m);
	      }
	
	
	     // radio点击后的总价
	     $(".total-price").html(pricenum)
	    })
	  })





  // 订单页面价钱的计算

  /*1.数量*/
  var accountnum=0;
  var accountprice=0;
  $(".hewenqi-li").each(function(n){
    accountnum+=parseInt($(".hewenqi-li").eq(n).find(".list-btn").html().replace(/[^0-9]/ig,""));
    accountprice+=$(".hewenqi-li").eq(n).find(".list-btn").html().replace(/[^0-9]/ig,"")*parseInt($(".hewenqi-li").eq(n).find(".price-num").html())

  })
  $(".account-price").html(accountprice)
  $(".account-num").html(accountnum);

  // 弹出提货码弹窗
  $(".account-btn2").each(function(){
    $(this).click(function(){
      $(".modal-modal").removeClass("none");
      $(".modal-alert").removeClass("none")
    })
  })
  $(".close").click(function(){
    $(".modal-modal").addClass("none");
    $(".modal-alert").addClass("none")
   })
   // 订单页面tab切换
   $(".account-tab1").each(function(){
    $(this).click(function(){
      $(this).addClass("account-tab1hover").siblings(".account-tab1").removeClass("account-tab1hover")
    })
   })
   
   
   

	$(".ongoingtab").click(function(){
   	var that=$(this);
   	 $.ajax({
        	url:contextPath+"/wx/order/goodPart",
        	data:{"classId" : that.attr("value")},
        	type:"post",
        	dataType:'html',
        	success:function(result){
        			  $(".ongoing-goods1").html("");
        			  $(".ongoing-goods1").html(result);
        			  that.addClass("tabhover").siblings(".ongoingtab").removeClass("tabhover");
        			  
        			  $(".radio").each(function(){
        				  if(sessionStorage.choose.indexOf($(this).attr("value"))!=-1){
        					  $(this).addClass("radiohover");
        				  }
        				    $(this).click(function(){
        				      if($(this).hasClass("radiohover")){
        				         $(this).removeClass("radiohover");
        				         if(sessionStorage.choose.indexOf($(this).attr("value"))!=-1){
        				        	 sessionStorage.choose=sessionStorage.choose.replace($(this).attr("value")+",","");
        				          }
        				        pricenum=parseInt(pricenum-$(this).siblings(".price").find(".per-price").html())
        				        
        				        // 数量
        				        var m =parseInt($(".number").html())-1 ;
        				        if(parseInt(m)<=0){
        				        	m=0;
        				        }
        				        $(".number").html(m);
        				        
        				      }else{
        				        $(this).addClass("radiohover");
        				        sessionStorage.choose=sessionStorage.choose+$(this).attr("value")+",";
        				        pricenum=parseInt(pricenum+parseInt($(this).siblings(".price").find(".per-price").html()));
        				        
        				        // 数量
        					    var m =parseInt($(".number").html())+1 ;
        					    $(".number").html(m);
        				      }
        				
        				     // radio点击后的总价
        				     $(".total-price").html(pricenum)
        				    })
        				  })

        	   },
        	error:function(){
        		alert("系统异常，请重试");
        	}
        });
   	  iScroll.refresh();
   });

  $(".toCart").click(function(){
//	  $("input[name='goodIds']").val(sessionStorage.choose);
//	  $.ajax({
//  		url:contextPath+"/wx/order/toCart",
//  		type:'post',
//  		data:$("form[name='firstBasicForm']").serialize(),
//  		dataType:'html',
//  		success:function(result){
//  			if (result.code==0) {
//					window.location.href="${contextPath}/wx/user/secondBasic";
//				}else{
//					alert(result.message);
//				}
//  			$(".revise").removeAttr("disabled");
//  		}
//  	});
//	  if(parseInt($(".number").html())==0){
		  
//	  }else{
		  window.location.href=contextPath+"/wx/order/toCart?goodIds="+sessionStorage.choose;
//	  }
  });
  
//})


