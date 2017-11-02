var contextPath = $("link[rel=stylesheet]").first().attr("href");
var host = window.location.host;
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
console.log("打印路径："+contextPath+"######"+host);
// 初始化微信配置
$.ajax({
	url : contextPath+'/core/wx_jssdk_config',
	type : 'post',
	data : {
		"url" : window.location.href
	},
	success : function(result) {
		wx.config({
			debug : false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			appId : result.appId, // 必填，公众号的唯一标识
			timestamp : result.timestamp, // 必填，生成签名的时间戳
			nonceStr : result.nonceStr, // 必填，生成签名的随机串
			signature : result.signature,// 必填，签名，见附录1
			jsApiList : [ "onMenuShareTimeline", "onMenuShareAppMessage"]
		});
		
		wx.ready(function () {		
			var commonTitile ="仲夏趣玩季，欢乐总动员";
			var commonContent ="辰山植物园＋创客公益市集＋潮流科技＋亲子运动＋爱秀舞台＝？";
			var commonLogo = "http://" + host + contextPath + "/wechat/image/logo.png";
			var commonUrl=window.location.href;
			
			var shareTitle= $("meta[name=share_title]").attr("content");
			var shareLogo = $("meta[name=share_logo]").attr("content");
			var shareContent = $("meta[name=share_content]").attr("content");
			var shareUrl ="http://" + host+ $("meta[name=share_url]").attr("content");
			
			if (shareTitle==null||shareTitle==""||shareTitle==undefined) {
				shareTitle=commonTitile;
			}
			if (shareLogo==null||shareLogo==""||shareLogo==undefined) {
				shareLogo=commonLogo;
			}
			if (shareContent==null||shareContent==""||shareContent==undefined) {
				shareContent=commonContent;
			}
			if (shareUrl==null||shareUrl==""||shareUrl==undefined) {
				shareUrl=commonUrl;
			}
			
			// 分享给朋友
			wx.onMenuShareAppMessage({
			    title: shareTitle, // 分享标题
			    desc: shareContent, // 分享描述
			    link: shareUrl, // 分享链接
			    imgUrl: shareLogo, // 分享图标
			    type: 'link', // 分享类型,music、video或link，不填默认为link
			    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
			    success: function () { 
			        // 用户确认分享后执行的回调函数
//			       alert("share friend ok");
			    },
			    cancel: function () { 
			        // 用户取消分享后执行的回调函数
			    	//alert("share friend cancel");
			    }
			});
	
			// 分享到朋友圈
			wx.onMenuShareTimeline({
				title : shareTitle, // 分享标题
				link : shareUrl, // 分享链接
				imgUrl : shareLogo, // 分享图标
				success : function() {
					// 用户确认分享后执行的回调函数
					//alert("share friendship ok");
				},
				cancel : function() {
					// 用户取消分享后执行的回调函数
					//alert("share friendship cancel");
				}
			});
		});
	}
});

