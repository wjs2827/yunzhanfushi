<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head lang="en">
    <title>支付测试</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
</head>
<body>
<div class="html">
   <input type="button" onclick="pays();" value="支付吧"/>
</div>
</body>
<script src="http://tita.wmeimob.com/api/static/js/jquery.js"></script>
<script src="http://tita.wmeimob.com/api/static/js/jquery.min.js"></script>
<script>

function pays(){
	$.ajax({
		url:"http://tita.wmeimob.com/api/core/auth/payTestSave",
		type:"POST",
		success:function(data){
			if("100"==data.code){
				var wxPaySign=data.data;
				console.log("appId："+wxPaySign.appId);
				console.log("timeStamp："+wxPaySign.timeStamp);
				console.log("nonceStr："+wxPaySign.nonceStr);
				console.log("package："+wxPaySign.package);
				console.log("paySign："+wxPaySign.paySign);
				checkForPay(wxPaySign);
			}else{
				clickFlag = true;
				alert(data.msg);
			}
		},
		error:function(data){
			clickFlag = true;
			alert("系统异常！");
		}
	})	
	
	
}

		


function checkForPay(paySign){
	 if(typeof WeixinJSBridge == "undefined") {
		if(document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady', onBridgeReady,
					false);
		}else if(document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	 }else{
		onBridgeReady(paySign);
	}
}

function onBridgeReady(paySign) {
		WeixinJSBridge.invoke('getBrandWCPayRequest', {
			"appId" :paySign.appId, //公众号名称，由商户传入     
			"timeStamp" : paySign.timeStamp, //时间戳，自1970年以来的秒数     
			"nonceStr" : paySign.nonceStr, //随机串     
			"package" : paySign.package,
			"signType" : "MD5", //微信签名方式：     
			"paySign" : paySign.paySign
		//微信签名 
		}, function(res) {
			if (res.err_msg == "get_brand_wcpay_request:ok") {// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
//				"/order/orderDetails?orderId="+orderId;
			      alert("支付付成功");
			}else if (res.err_msg == "get_brand_wcpay_request：cancel") {// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
//				"/order/orderDetails?orderId="+orderId;
				  alert("支付失败");
			}else{
			} 
		});
	}
</script>
</html>