var contextPath = $("link[rel=stylesheet]").first().attr("href");
contextPath = contextPath.substring(0,contextPath.indexOf("/", 1));
var UITree = function () {
    var handleSample2 = function (data) {
        $('#role_rights').jstree({
            'plugins': ["wholerow", "checkbox", "types"],
            'core': {
                "themes" : {
                    "responsive": true
                },    
                'data': data
            },
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            }
        });
    };
    
    var toTreeData = function(jsonData, parentData){
    	if(jsonData == null || typeof(jsonData) == "undefined" || jsonData.length == 0){
    		return [];
    	}
    	var treeData = new Array();
    	if(parentData != null){
    		parentData["children"] = treeData;
    	}
    	for(var i=0;i<jsonData.length;i++){
    		treeData[i] = {"text":jsonData[i].parentMenu.name,"id":jsonData[i].parentMenu.id,"state":{"selected":jsonData[i].parentMenu.isSelected,"opened":true},"icon":"fa fa-folder icon-state-default"};
    		if(jsonData[i].menus != null && jsonData[i].menus.length > 0){
    			toTreeData(jsonData[i].menus, treeData[i]);
    		}
    	}
    	return treeData;
    };


    return {
        //main function to initiate the module
        init: function (roleId) {
        	$.ajax({
        		url:"/"+contextPath+"/admin/role/edit/getMenus",
        		dataType:"json",
        		data:{"roleId":roleId},
        		type:"post",
        		success:function(result){
        			if (result.code==0) {
        				var treeData = toTreeData(result.data,null);
            			handleSample2(treeData);
					}else{
						console.log("请求数据失败，返回错误");
					}
        		},
        		error:function(){
        			console.log("系统异常");
        		}
        	});
        }
    };

}();