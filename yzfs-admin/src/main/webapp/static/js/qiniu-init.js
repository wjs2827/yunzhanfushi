// 初始化七牛上传图片
function initQiniu(url,btnId, callback) {
	var uploader = Qiniu.uploader({
		runtimes : 'html5,flash,html4', // 上传模式,依次退化
		browse_button : btnId, // 上传选择的点选按钮，**必需**
		uptoken_url : url, // Ajax 请求 uptoken 的
		// Url，**强烈建议设置**（服务端提供）
		get_new_uptoken : true, // 设置上传文件的时候是否每次都重新获取新的 uptoken
		domain : $("#qiniupath").val(), // bucket
		// 域名，下载资源时用到，**必需**
		max_file_size : '4mb', // 最大文件体积限制
	    //flash_swf_url : 'Moxie.swf', //引入 flash,相对路径
		max_retries : 2, // 上传失败最大重试次数
		chunk_size : '1mb', // 分块上传时，每块的体积
		auto_start : true, // 选择文件后自动上传，若关闭需要自己绑定事件触发上传,
		init : {
			'FilesAdded' : function(up, files) {
				plupload.each(files, function(file) {
					// 文件添加进队列后,处理相关的事情
				});
			},
			'BeforeUpload' : function(up, file) {
				// 每个文件上传前,处理相关的事情
			},
			'UploadProgress' : function(up, file) {
				// 每个文件上传时,处理相关的事情
			},
			'FileUploaded' : function(up, file, info) {
				// 每个文件上传成功后,处理相关的事情
				// 其中 info 是文件上传成功后，服务端返回的json，形式如
				// {
				// "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
				// "key": "gogopher.jpg"
				// }
				// 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

				// var domain = up.getOption('domain');
				// var res = parseJSON(info);
				// var sourceLink = domain + res.key; 获取上传成功后的文件的Url
				//alert("上传成功");
				 ohSnap("上传成功", 'black');
				if (callback != undefined) {
					callback(info)
				}
			},
			'Error' : function(up, err, errTip) {
				// 上传出错时,处理相关的事情
				alert(errTip);
			},
			'UploadComplete' : function() {
				// 队列文件处理完毕后,处理相关的事情
			},
			'Key' : function(up, file) {
				// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
				// 该配置必须要在 unique_names: false , save_key: false 时才生效

//				var key = "";
//				// do something with key here
//				return key
			}
		}
	});
}

//json字符串转换为json对象
function strToJson(str) {
	var json = eval('(' + str + ')');
	return json;
}