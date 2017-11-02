/**
 * 
 */
$(function(){
	UploadQiniu.scanUploadDiv();

});

var UploadQiniu = {
	basePath:"", tokenurl:"",
	scanUploadDiv:function(){
		var _this = this;
		$("div[rel='upload-qiniu']").each(function(i){
			var basePath = $(this).attr("basepath");
			if(basePath == null){
				throw new Error("Please set property [basepath] for upload-qiniu.");
			}
			var tokenurl = $(this).attr("tokenurl");
			if(tokenurl == null || tokenurl == ""){
				throw new Error("Please set property [tokenurl] for upload-qiniu.");
			}
			_this.basePath = basePath;
			_this.tokenurl = tokenurl;
			_this.initUploadContainer(this,i);
		});
	},
	initUploadContainer:function(el, containerIndex){
		var el = typeof(el) == "string" ? $("#"+el) : $(el);
		var _this = this;
		var index = 0;
		el.attr("index", containerIndex);
		$("div.wmqiniuupload", el).each(function(){
			var $this = $(this);
			$this.attr("type", "edit");
			var closeA = $(document.createElement("a"));
			$this.append(closeA);
			closeA.on("click", function(event){
				_this._remove(event, $(this).parent())
			});
			$this.attr("index", index);
			$("div.insideborder", $this).attr("id", "uploadbtnid" + containerIndex + index);
			_this.qiniuUpload("uploadbtnid" + containerIndex + index, _this.basePath, _this.basePath+_this.tokenurl);
			index++;
		});

		_this._add(el, index);
	},
	_add:function(el, index){
		var _this = this;
		//判断是否超过所设置的最大可上传数量
		var max = el.attr("max");
		var size = _this.getSize(el);
//		if(parseInt(max) <= size){
//			return;
//		}
		//获取最后一个元素的index
		if(index == null){
			index = el.find("div.wmqiniuupload").last().attr("index");
			if(index && index != ""){
				index = parseInt(index) + 1;
			}
		}
		var containerIndex = el.attr("index");
		var container = $(document.createElement("div"));
		container.addClass("wmqiniuupload");
		container.attr("type", "add");
		container.attr("index", index)
		var outsideborder = $(document.createElement("div"));
		outsideborder.addClass("outsideborder");
		var insideborder = $(document.createElement("div"));
		insideborder.addClass("insideborder");
		insideborder.attr("id", "uploadbtnid"+containerIndex+index);
		insideborder.append("<span><img src=\""+_this.basePath+"/static/image/add.png\"/></span>");
		//insideborder.append("<span><img src=\"img/add.png\"/></span>");
		insideborder.append("<input type=\"hidden\" name=\"picKey\"/>");
		outsideborder.append(insideborder);
		container.append(outsideborder);
		el.append(container);

		_this.qiniuUpload("uploadbtnid"+containerIndex+index, _this.basePath, _this.basePath+_this.tokenurl);
	},
	_remove:function(event, container){
		var el = container.parent();
		container.remove();
		var max = el.attr("max");
		var size = this.getSize(el);
		if(parseInt(max) > size && !this.hasAddElement(el)){
			this._add(el);
		}
		ohSnap("已移除", 'black');
		return false;
	},
	_uploadFinish:function(el, key){
		var _this = this;
		el.find("input[type=hidden]").val(key);
		el.find("img").attr("src", $("#qiniupath").val()+key);
		var container = el.parent().parent();
		var isEdit = container.attr("type") == "edit";
		if(isEdit){
			return;
		}
		var closeA = $(document.createElement("a"));
		container.append(closeA);
		closeA.on("click", function(event){
			_this._remove(event, container)
		});
		container.attr("type", "edit");
		_this._add(container.parent());
		 ohSnap("上传成功", 'black');
	},
	getSize:function(el){
		if(el == null)
			el = $("div[rel='upload-qiniu']").first();
		return $("div.wmqiniuupload[type=edit]", el).size();
	},
	hasAddElement:function(el){
		return el.find("div.wmqiniuupload[type=add]").size() > 0;
	},
	qiniuUpload:function(btnId, basePath, url){
		if(url == null || url == ""){
			url = basePath+"/qiniu/token";
		}
		var _this = this;
		Qiniu.uploader({
			runtimes : 'html5,flash,html4', // 上传模式,依次退化
			browse_button : btnId, // 上传选择的点选按钮，**必需**
			uptoken_url : url, // Ajax 请求 uptoken 的
			// Url，**强烈建议设置**（服务端提供）
			get_new_uptoken : true, // 设置上传文件的时候是否每次都重新获取新的 uptoken
			domain : '$("#qiniupath").val()', // bucket
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
					ohSnap("上传成功", 'black');
					eval("var result = "+info);
					if(result){
						_this._uploadFinish($("#"+btnId), result.key);
					}
				},
				'Error' : function(up, err, errTip) {
					// 上传出错时,处理相关的事情
					throw new Error("Qiniu uploading error, detail: "+errTip);
				},
				'UploadComplete' : function() {
					// 队列文件处理完毕后,处理相关的事情
				},
				'Key' : function(up, file) {
					// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
					// 该配置必须要在 unique_names: false , save_key: false 时才生效
					//var key = "";
					//// do something with key here
					//return key
				}
			}
		});
	}
};