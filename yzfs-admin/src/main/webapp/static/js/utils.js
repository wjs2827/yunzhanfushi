//url取值
function getValue(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
// 验证手机号
function checkPhone(phone) {
	if(isBlank(phone)){
		return false;
	}
	if (/^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/i.test(phone)) {
		return true;
	}
	return false;
}

function isBlank(v) {
	if (v == "" || v == null || typeof(v) == "undefined") {
		return true;
	}
	return false;
}
function isNotBlank(v) {
	return !isBlank(v);
}
function isNumber(v){
    if(/^[0-9]*$/.test(v)){
       return true;
    }
    return false;
}
function isChinese(v) {
    for (var i=0;i<v.length;i++) {
        if(!/[\u4e00-\u9fa5]/.test(v.substring(i,i+1))){
            return false;
        }
    }
	return true;
}

function checkUserName(name) {
	if(isBlank(name)){
		alert("用户名不能为空！");
		return false;
	}
	if(name.length>4){
		alert("用户名不能多于四个字！");
		return false;
	}
	if(!isChinese(name)) {
		alert("用户名只能是中文！");
		return false ;
	}
	return true;
}